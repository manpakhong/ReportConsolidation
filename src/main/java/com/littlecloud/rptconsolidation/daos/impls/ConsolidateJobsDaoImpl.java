package com.littlecloud.rptconsolidation.daos.impls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.rptconsolidation.criterias.ConsolidateJobCriteria;
import com.littlecloud.rptconsolidation.daos.BaseDao;
import com.littlecloud.rptconsolidation.dtos.PreparedStatementParamListDto;
import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.helpers.DaoHelper;
import com.littlecloud.utils.CalendarUtils;
import com.littlecloud.utils.CommonUtils;

public class ConsolidateJobsDaoImpl extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(ConsolidateJobsDaoImpl.class);
	private final String selectSql = "select * from consolidate_jobs ";
	private final String updateSql = "update consolidate_jobs ";
	private final String insertSql = "insert into consolidate_jobs ";
	public ConsolidateJobsDaoImpl(){
		super();
	}
	public ConsolidateJobsDaoImpl(String mode){
		super(mode);
	}
	public int insertConsolidateJob(ConsolidateJob consolidateJob){
		int lastGeneratedKey = 0;
		StringBuilder sbSql = new StringBuilder(insertSql);
		PreparedStatement preparedStmt = null;
		ResultSet generatedKeysRs = null;
		try{
			DaoHelper daoHelper = new DaoHelper();
			sbSql.append("(");
			sbSql.append("created_date, ");
			sbSql.append("updated_date, ");
			sbSql.append("server, ");
			sbSql.append("org_id, ");
			sbSql.append("job_name, ");
			sbSql.append("do_date_from, ");
			sbSql.append("do_date_to, ");
			sbSql.append("status, ");
			sbSql.append("no_of_records, ");
			sbSql.append("start_datetime, ");
			sbSql.append("end_datetime, ");
			sbSql.append("active, ");
			sbSql.append("type ");
			sbSql.append(") ");
			sbSql.append("values ");
			sbSql.append("(");
			sbSql.append("?,?,?,?,?,?,?,?,?,?,?,?,?");
			sbSql.append(")");
			
			PreparedStatementParamListDto preparedStatementParamListDto = new PreparedStatementParamListDto();
			int count = 0;
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getCreatedDate()));
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getUpdatedDate()));
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getServer());
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getOrgId());
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getJobName());
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getDoDateFrom()));
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getDoDateTo()));
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getStatus());
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getNoOfRecords());
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getStartDateTime()));
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getEndDateTime()));
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getActive());
			count ++;
			preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getType());
			count ++;
			daoHelper.addPreparedStatementParamListDto(preparedStatementParamListDto);
			
			conn.setAutoCommit(false);
			preparedStmt = daoHelper.getSingleRecordPreparedStatement(conn, sbSql.toString(), true);
			int affectedRows = preparedStmt.executeUpdate();
			if (affectedRows == 0){
				log.warn("ConsolidateJobsDao.insertConsolidateJob() - lastGeneratedKey:" + lastGeneratedKey);
			} else {
				generatedKeysRs = preparedStmt.getGeneratedKeys();
	            if (generatedKeysRs.next()) {
	            	lastGeneratedKey = generatedKeysRs.getInt(1);
	            }
			}
			conn.commit();
		} catch (Exception e){
			log.error("ConsolidateJobsDao.insertConsolidateJob() - Exception: ", e);
		} finally{
			try{
				if (preparedStmt != null){
					preparedStmt.close();
					preparedStmt = null;
				}
				if (generatedKeysRs != null){
					generatedKeysRs.close();
					generatedKeysRs = null;
				}
			} catch (Exception e){
				log.error("ConsolidateJobsDao.insertConsolidateJob() - Exception: ", e);
			}
			
		}
		return lastGeneratedKey;
	}
	
	public int updateConsolidateJobList(List<ConsolidateJob> consolidateJobList){
		int noOfRecordsUpdated = 0; 
		StringBuilder sbSql = new StringBuilder(updateSql);
		PreparedStatement preparedStmt = null;
		try{
			DaoHelper daoHelper = new DaoHelper();
			sbSql.append("set ");
			sbSql.append("created_date = ?, ");
			sbSql.append("updated_date = ?, ");
			sbSql.append("server = ?, ");
			sbSql.append("org_id = ?, ");
			sbSql.append("job_name = ?, ");
			sbSql.append("do_date_from = ?, ");
			sbSql.append("do_date_to = ?, ");
			sbSql.append("status = ?, ");
			sbSql.append("no_of_records = ?, ");
			sbSql.append("start_datetime = ?, ");
			sbSql.append("end_datetime = ?, ");
			sbSql.append("active = ?, ");
			sbSql.append("type = ? ");
			
			sbSql.append("where ");
			sbSql.append("id = ? ");
			
			for (ConsolidateJob consolidateJob: consolidateJobList){
				PreparedStatementParamListDto preparedStatementParamListDto = new PreparedStatementParamListDto();
				int count = 0;
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getCreatedDate()));
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getUpdatedDate()));
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getServer());
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getOrgId());
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getJobName());
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getDoDateFrom()));
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getDoDateTo()));
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getStatus());
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getNoOfRecords());
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getStartDateTime()));
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, CalendarUtils.convertSqlDate2SqlTimestamp(consolidateJob.getEndDateTime()));
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getActive());
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getType());
				count ++;
				preparedStatementParamListDto.putSequenceAndValue(count, consolidateJob.getId());
				count ++;
				daoHelper.addPreparedStatementParamListDto(preparedStatementParamListDto);
			}
			conn.setAutoCommit(false);
			preparedStmt = daoHelper.getBatchModePreparedStatement(conn, sbSql.toString());
			int [] numUpdates=preparedStmt.executeBatch();             
			for (int i=0; i < numUpdates.length; i++) {            
				if (numUpdates[i] == -2){
					if (log.isDebugEnabled()){
						log.debug("Execution " + i + ": unknown number of rows updated");
					}
				}
				else{
					if (log.isDebugEnabled()){
						log.debug("Execution " + i + " successful: " + numUpdates[i] + " rows updated");
					}
					noOfRecordsUpdated += numUpdates[i];
				}
			}
			conn.commit();
		} catch (Exception e){
			log.error("ConsolidateJobsDao.updateConsolidateJobList() - Exception: ", e);
		} finally {
			try{
				if (preparedStmt != null){
					preparedStmt.close();
					preparedStmt = null;
				}
			} catch (Exception e){
				log.error("ConsolidateJobsDao.updateConsolidateJobList() - Exception: ", e);
			}
		}
		return noOfRecordsUpdated;
	}
	public List<ConsolidateJob> getConsolidateJobList(ConsolidateJobCriteria criteria){
		List<ConsolidateJob> results = new ArrayList<ConsolidateJob>();
		StringBuilder sbSql = new StringBuilder(selectSql);
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		try{			
			DaoHelper daoHelper = new DaoHelper();
			PreparedStatementParamListDto preparedStatementParamListDto = new PreparedStatementParamListDto();
			if (criteria != null){
				int count = 0;

				if (criteria.getId() != null && criteria.getId().intValue() > 0){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("id=? ");
					Integer value = criteria.getId();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getJobName() != null && !criteria.getJobName().isEmpty()){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("job_name=? ");
					String value = criteria.getJobName();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getServer() != null && !criteria.getServer().isEmpty()){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("server=? ");
					String value = criteria.getServer();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getOrgId() != null && !criteria.getOrgId().isEmpty()){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("org_id=? ");
					String value = criteria.getOrgId();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getJobName() != null && !criteria.getJobName().isEmpty()){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("job_name=? ");
					String value = criteria.getJobName();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getStatus() != null && !criteria.getStatus().isEmpty()){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("status=? ");
					String value = criteria.getStatus();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getNoOfRecords() != null){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("no_of_records=? ");
					Integer value = criteria.getNoOfRecords();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getActive() != null){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("active=? ");
					Boolean value = criteria.getActive();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getType() != null && !criteria.getType().isEmpty()){
					if (count == 0){
						sbSql.append("where ");
					} else {
						sbSql.append(",");
					}
					sbSql.append("type=? ");
					String value = criteria.getType();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
				if (criteria.getLimit() != null){

					sbSql.append("limit ? ");
					Integer value = criteria.getLimit();
					preparedStatementParamListDto.putSequenceAndValue(count, value);
					count ++;
				}
			}
			daoHelper.addPreparedStatementParamListDto(preparedStatementParamListDto);
			preparedStmt = daoHelper.getSingleRecordPreparedStatement(conn, sbSql.toString());
			
			rs = preparedStmt.executeQuery();
			while (rs.next()){
				ConsolidateJob rsObj = new ConsolidateJob();
				rsObj.setId(CommonUtils.number2Integer((Number) rs.getObject("id")));
				rsObj.setCreatedDate((Date) rs.getObject("created_date"));
				rsObj.setUpdatedDate((Date) rs.getObject("updated_date"));
				rsObj.setServer((String) rs.getObject("server"));
				rsObj.setOrgId((String) rs.getObject("org_id"));
				rsObj.setJobName((String) rs.getObject("job_name"));
				rsObj.setDoDateFrom((Date) rs.getObject("do_date_from"));
				rsObj.setDoDateTo((Date) rs.getObject("do_date_to"));
				rsObj.setStatus((String) rs.getObject("status"));
				rsObj.setNoOfRecords((Integer) rs.getObject("no_of_records"));
				rsObj.setStartDateTime((Date) rs.getObject("start_datetime"));
				rsObj.setEndDateTime((Date) rs.getObject("end_datetime"));
				rsObj.setActive((Boolean) rs.getObject("active"));
				rsObj.setType((String) rs.getObject("type"));
				results.add(rsObj);
			}	
		} catch (Exception e){
			if (e instanceof SQLException){
				log.error("ConsolidateJobsDao.getConsolidateJobList() - SQLException: ", e);
			} else {
				log.error("ConsolidateJobsDao.getConsolidateJobList() - Exception: ", e);
			}
		} finally {
			try {
				if (preparedStmt != null){
					preparedStmt.close();
					preparedStmt = null;
				}
				if (rs != null){
					rs.close();
					rs = null;
				}
			} catch (SQLException e) {
				log.error("ConsolidateJobsDao.getConsolidateJobList() close preparedStmt ... finally - Exception: ", e);
			}
//			 using jndi, no need to close
//			if (conn != null){
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					log.error("ConsolidateJobsDao.getConsolidateJobList() close connection ... finally - Exception: ", e);
//				}
//			}
		}
		return results;
	}
	
	
}
