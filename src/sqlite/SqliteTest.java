package sqlite;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.sqlite.SQLiteDataSource;
import org.sqlite.SQLiteJDBCLoader;

/**
 * @FileName : SqliteTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class SqliteTest {

	@Test
	public void selectTest() throws SQLException {
		Connection conn = getConnection();
		ResultSet resultSet = conn.createStatement().executeQuery("select * from t1");
		while (resultSet.next()) {
			System.out.println("name=" + resultSet.getString("name") + ", age=" + resultSet.getInt("age"));
		}

		boolean initialize = SQLiteJDBCLoader.initialize();
		assertThat(true, is(initialize));

		resultSet.close();
		conn.close();
	}

	@Test
	public void insertTest() throws SQLException {
		String insertQuery = "insert into t1 (name, age) values (?, ?)";
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement(insertQuery);

		pst.setString(1, "namkyu");
		pst.setInt(2, 33);
		pst.executeUpdate();

		pst.close();
		conn.close();
	}

	/**
	 * <pre>
	 * getConnection
	 *
	 * <pre>
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		SQLiteDataSource dataSource = new SQLiteDataSource();
		dataSource.setUrl("jdbc:sqlite:test.db");
		Connection conn = dataSource.getConnection();
		return conn;
	}
}
