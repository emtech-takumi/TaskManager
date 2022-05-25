package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.entity.UserBean;

public class UserDAO {
	public UserBean select(String user_id) throws SQLException,ClassNotFoundException{
		UserBean user = new UserBean();
		
		String sql ="SELECT * FROM m_user WHERE user_id = ?";
		
		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement pstmt =con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				user.setUserId(res.getString("user_id"));
				user.setPassword(res.getString("password"));
				user.setUserName(res.getString("username"));
				user.setUpdateDate(res.getString("updateDate"));
			} 
		}
		return user;
	}
}
