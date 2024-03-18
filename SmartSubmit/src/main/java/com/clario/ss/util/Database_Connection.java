package com.clario.ss.util;
//package engage.pom.util;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Database_Connection {
//	
//	
//	public static String DB_URL = ConstantsConfig.DB_URL;    
//	public static String DB_USER = ConstantsConfig.DB_USER;   
//	public static String DB_PASSWORD = ConstantsConfig.DB_PASSWORD;
//	public static String DB_URL_Replicated = ConstantsConfig.DB_URL_Replicated;  
//	public static String DB_USER_Replicated = ConstantsConfig.DB_USER_Replicated;   
//	public static String DB_PASSWORD_Replicated= ConstantsConfig.DB_PASSWORD_Replicated;
//	
//	public static String sqlMethod = null;
//	public  static Connection connReplicated = null;  
//	public  static Connection conn = null;
//	public static PreparedStatement pstmt=null;
//	public static CallableStatement stmt=null;
//	public static Statement stnt=null;
//	
//	/**  Code For Multiple Filing 
//	 
//	insert into swat_replicated.TEMP_NEW_FILING (DOC_TYPE_CODE, CIK, FILE_NUMBER, NO_FILING_REQ, ORG_ID, IS_401, IS_402, IS_RM, PERIOD_REQ)
//	values('S-1', '' , '',20,'05',0,0,0,0);
//	commit;
//
//	set SERVEROUTPUT ON
//	exec SWAT_REPLICATED.PKG_ADD_AMD_CORSP_DELAM.INSERT_FILES_FROM_TEMP_TABLE; */
//	
//	
//	public static void main(String[] args)
//	{
//				System.out.println("For testing a db method");
//		
//	}
//	public static int termUserTaskCount(String user)
//	{
//		int count=0;
//		try
//		{
//			count=resultsetCount("SELECT (SELECT RLL.REVIEW_LVL_NAME FROM RVW_LVL_LOOKUP RLL WHERE RLL.REVIEW_LVL_ID= CMR.REVIEW_LVL_ID) REVIEW_LEVEL, DCL.DISP_CD_NAME STATUS, '"+user+"' AS ASSIGNED_USERNAME,CMR.CF_MST_REVIEW_ID CF_MST_REVIEW_ID,CMR.CURRENT_RVW_ROUND CURRENT_RVW_ROUND,(SELECT CASE WHEN RA.OUTCOME IS NULL THEN 'In Progress' ELSE RA.OUTCOME END FROM RVW_ASSIGNMENT RA WHERE (RA.RVW_ASSIGNMENT_ID = ASGN.E_RVW_ASSIGNMENT_ID OR RA.RVW_ASSIGNMENT_ID = ASGN.R_RVW_ASSIGNMENT_ID)AND RA.ASSIGNED_USERNAME='"+user+"') AS OUTCOME,(SELECT TL.TASK_NAME ||' '||TL.TASK_DESCRIPTION FROM TASK_LOOKUP TL, RVW_ASSIGNMENT RA WHERE TL.TASK_CD=RA.TASK_CD AND(RA.RVW_ASSIGNMENT_ID = ASGN.E_RVW_ASSIGNMENT_ID OR RA.RVW_ASSIGNMENT_ID = ASGN.R_RVW_ASSIGNMENT_ID)AND RA.ASSIGNED_USERNAME='"+user+"') AS TASK_DESC_NAME,SF.DOC_TYPE_GRP_CD DOC_GROUP_TYPE FROM CF_MST_REVIEW CMR ,SWAT_FILING SF , SWAT_ENTITY_NAME VEN ,DISP_CD_LOOKUP DCL,ASSIGNMENT ASGN WHERE VEN.CIK=SF.CIK AND VEN.CURRENT_ENTITY_NAME_FLAG=1 AND VEN.ENTITY_NAME_TYPE='COMP' AND VEN.DELETED='0'AND SF.SWAT_FILING_ID=CMR.PRY_SWAT_FILING_ID AND CMR.RVW_DISP_CD_ID IS NULL AND DCL.DISP_CD_ID=CMR.CURRENT_STATUS_ID AND CMR.CF_MST_REVIEW_ID=ASGN.CF_MST_REVIEW_ID AND CMR.CURRENT_RVW_ROUND=ASGN.REVIEW_ROUND AND (UPPER(ASGN.EXAMINER_NAME)=UPPER('"+user+"') OR UPPER(ASGN.REVIEWER_NAME)=UPPER('"+user+"') )AND ASGN.RVW_PROFESSION_ID IN (1,2,3,4,5,6,7,13) ORDER BY CF_MST_REVIEW_ID DESC","CF_MST_REVIEW_ID");
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return count;
//		
//	}
//	
//public static Connection getDBConnection_Replicated() throws SQLException {
//    
//    try {
//    	
//         System.out.println("Connecting to database...");
//         System.out.println("Connected"+DB_URL_Replicated);
//         System.out.println("Connected"+DB_USER_Replicated);
//         System.out.println("Connected"+DB_PASSWORD_Replicated);
////         if(connReplicated==null){
//        	 Class.forName("com.mysql.jdbc.Driver");
//        	 connReplicated = DriverManager.getConnection(DB_URL_Replicated,DB_USER_Replicated,DB_PASSWORD_Replicated);
////         }
//         return connReplicated;
//      }catch(SQLException se){
//         //Handle errors for JDBC
//         se.printStackTrace();
//      }catch(Exception e){
//         //Handle errors for Class.forName
//         e.printStackTrace();
//      }
//    /*finally{
//         //finally block used to close resources
//         try{
//            if(stmt!=null)
//               stmt.close();
//         }catch(SQLException se2){
//         }// nothing we can do
//         try{
//            if(conn!=null)
//               conn.close();
//         }catch(SQLException se){
//            se.printStackTrace();
//         }//end finally try
//      }//end try
//*/
//	return connReplicated;       }//end main
//   }//end 
//	