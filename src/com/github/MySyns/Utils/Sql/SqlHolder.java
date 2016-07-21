package com.github.MySyns.Utils.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.github.MySyns.SynsConfig;

public class SqlHolder {
	private static Connection c = null;
	public SqlHolder() {
	}
	
	public static boolean init() {
		String url=
				"jdbc:mysql://"
				+ SynsConfig.host
				+ ":"
				+ SynsConfig.port
				+ "/"
				+ SynsConfig.dbName
				+ "?user="
				+ SynsConfig.userName
				+ "&password="
				+ SynsConfig.passwd
				+"&useUnicode=true&characterEncoding=UTF8";
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url);
			if (!tableExists(SynsConfig.tableName)) 
				createTable(SynsConfig.tableName,
						"name VARCHAR(255) not null,data text","name");
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if ((st != null) && (!st.isClosed())) st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}
	private static void createTable(String tableName,String args,String pk) {
		doSql("create table "+ tableName + " (" 
				+ args
				+ ",PRIMARY KEY (" + pk + ")) CHARACTER SET utf8 COLLATE utf8_general_ci");
	}
	
	public static MyResult doSqlQuery(String cmd) {
		MyResult result = null;
	    Statement st = null;
	    ResultSet res = null;
	    try {
	    	st = c.createStatement();
	    	res = st.executeQuery(cmd);
	    	result = new MyResult(res);
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	try {
				if ((st != null) && (!st.isClosed())) st.close();
		    	if ((res != null) && (!res.isClosed())) res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    return result;
	}
	
	public static void  doSql(String cmd) {
	    Statement st = null;
	    try {
	    	st = c.createStatement();
	    	st.execute(cmd);
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	try {
				if ((st != null) && (!st.isClosed())) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	private static boolean tableExists(String tableName) {
		MyResult result = doSqlQuery("SHOW TABLES");
	    for(ArrayList<String> s:result.getAllTable()) {
	    	if (s.isEmpty()) continue;
	    	if (s.get(1).equalsIgnoreCase(tableName))return true;
	    }
	    return false;
	}


}
