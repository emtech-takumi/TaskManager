package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.entity.UserBean;
/**
 * ユーザ情報のDAO
 * @author emtech-user
 *
 */
public class UserDAO {
	/**
	 * 指定されたユーザIDの情報を取得
	 * @param user_id ユーザID
	 * @return 指定されたユーザIDのユーザ情報が格納されたUserBean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public UserBean select(String user_id) throws SQLException, ClassNotFoundException{
		UserBean user = new UserBean();
		
		String sql ="SELECT * FROM m_user WHERE user_id = ?";
		
		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement pstmt =con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				user.setUserId(res.getString("user_id"));
				user.setPassword(res.getString("password"));
				user.setUserName(res.getString("user_name"));
				user.setUpdateDate(res.getString("update_datetime"));
			} 
		}
		return user;
	}
	/**
	 * すべてのユーザ情報を取得
	 * @return 登録されたすべてのユーザ情報が格納されたUserBeanのリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<UserBean> selectAll() throws  SQLException, ClassNotFoundException{
		List<UserBean> list = new ArrayList<UserBean>();
		
		String sql ="SELECT * FROM m_user";
		
		try(Connection con =ConnectionManager.getConnection();
				Statement pstmt =con.createStatement();) {
			ResultSet res = pstmt.executeQuery(sql);
			while(res.next()) {
				UserBean user = new UserBean();
				user.setUserId(res.getString("user_id"));
				user.setUserName(res.getString("user_name"));
				user.setUpdateDate(res.getString("update_datetime"));
				list.add(user);
			} 
		}
		
		return list;
	}
}
