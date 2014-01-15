package mssql_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName : PlayncCheckDomain.java
 * @Project : test_project
 * @Date : 2013. 9. 26.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class PlayncCheckDomain {

	/** JDBC URL */
	private final String jdbcUrl = "jdbc:sqlserver://op-infradb-18;DatabaseName=DisplayGoodsDb";
	/** 아이디 */
	private final String userId = "smiledev";
	/** 패스워드 */
	private final String password = "roqkf12#";

	/**
	 * <pre>
	 * getConnection
	 * 커넥션 생성
	 *
	 * <pre>
	 * @return
	 */
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(jdbcUrl, userId, password);
		} catch (Exception ex) {
			System.out.println("##getConnection## (exception failed) jdbcUrl=" + jdbcUrl + ", userId=" + userId + ", password=" + password);
			ex.printStackTrace();
		}

		return conn;
	}

	/**
	 * <pre>
	 * getColumnListSql
	 *
	 * <pre>
	 * @return
	 */
	private String getColumnListSql() {
		return "select table_name, column_name from  information_schema.columns";
	}

	/**
	 * <pre>
	 * getSql
	 *
	 * <pre>
	 * @return
	 */
	private String getSql(String tableName, String columnName) {
		return "select COUNT(*) from " + tableName + " WHERE " + columnName + " like '%plaync.co.kr%'";
	}

	/**
	 * <pre>
	 * main
	 * 실행 process
	 *
	 * <pre>
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		PlayncCheckDomain playncCheckDomain = new PlayncCheckDomain();
		playncCheckDomain.job();
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 */
	private void job() {
		List<Map<String, String>> columnList = selectColumnList();
		for (Map<String, String> schemaInfo : columnList) {
			checkDomain(schemaInfo.get("tableName"), schemaInfo.get("columnName"));
		}
	}

	/**
	 * <pre>
	 * checkDomain
	 *
	 * <pre>
	 * @param tableName
	 * @param columnName
	 */
	private void checkDomain(String tableName, String columnName) {
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement psmt = null;
		String sql = getSql(tableName, columnName); // sql 쿼리문

		try {
			conn = getConnection();
			if (conn != null) {
				psmt = conn.prepareStatement(sql);
				resultSet = psmt.executeQuery();

				if (resultSet.next()) {
				}
				printLog(tableName, columnName, resultSet.getInt(1));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * <pre>
	 * printLog
	 *
	 * <pre>
	 * @param tableName
	 * @param columnName
	 * @param rowCnt
	 * @throws SQLException
	 */
	private void printLog(String tableName, String columnName, int rowCnt) throws SQLException {
		if (rowCnt > 0) {
			System.out.println("tableName=" + tableName + ", columnName=" + columnName);
		}
	}

	/**
	 * <pre>
	 * selectColumnList
	 *
	 * <pre>
	 * @return
	 */
	public List<Map<String, String>> selectColumnList() {
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement psmt = null;

		String sql = getColumnListSql();
		List<Map<String, String>> columnList = new ArrayList<Map<String,String>>();

		try {
			conn = getConnection();
			if (conn != null) {
				psmt = conn.prepareStatement(sql);
				resultSet = psmt.executeQuery();
				while (resultSet.next()) {
					Map<String, String> tableInfo = new HashMap<String, String>();
					tableInfo.put("tableName", resultSet.getString(1));
					tableInfo.put("columnName", resultSet.getString(2));
					columnList.add(tableInfo);
				}
			}

			return columnList;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
