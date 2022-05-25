package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.entity.CategoryBean;
import Model.entity.StatusBean;

public class SelecterDAO {
	public List<CategoryBean> getAllCategory() throws SQLException, ClassNotFoundException{
		List<CategoryBean> list = new ArrayList<>();
		String sql ="SELECT * FROM m_category";
		
		try(Connection con =ConnectionManager.getConnection();
				Statement pstmt =con.createStatement();) {
			ResultSet res = pstmt.executeQuery(sql);
			while(res.next()) {
				CategoryBean category = new CategoryBean();
				category.setCategoryId(res.getInt("user_id"));
				category.setCategoryName(res.getString("user_name"));
			}
		}
		
		return list;
	}
	public List<StatusBean> getAllStatus() throws ClassNotFoundException, SQLException{
		List<StatusBean> list = new ArrayList<>();
		String sql ="SELECT * FROM m_status";
		
		try(Connection con =ConnectionManager.getConnection();
				Statement pstmt =con.createStatement();) {
			ResultSet res = pstmt.executeQuery(sql);
			while(res.next()) {
				StatusBean status = new StatusBean();
				status.setStatusCode(res.getString("user_id"));
				status.setStatusName(res.getString("user_name"));
			} 
		}
		
		return list;
	}
}
