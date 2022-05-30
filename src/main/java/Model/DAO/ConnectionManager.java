package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * コネクションマネージャー
 * @author emtech-user
 *
 */
public class ConnectionManager {
	private static final String URL = "jdbc:mysql://localhost:3306/task_db";
	private static final String USER = "rabbit";
	private static final String PASSWORD = "turtle";
	/**
	 * DBとの接続を取得
	 * @return コネクション
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
