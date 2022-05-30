package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.entity.CategoryBean;
import Model.entity.StatusBean;
/**
 * カテゴリ・ステータス一覧のDAO
 * @author emtech-user
 *
 */
public class SelecterDAO {
	/**
	 * すべてのカテゴリの情報を取得
	 * @return すべてのカテゴリ情報が入ったリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CategoryBean> getAllCategory() throws SQLException, ClassNotFoundException{
		List<CategoryBean> list = new ArrayList<>();
		String sql ="SELECT * FROM m_category";
		
		try(Connection con =ConnectionManager.getConnection();
				Statement pstmt =con.createStatement();) {
			ResultSet res = pstmt.executeQuery(sql);
			while(res.next()) {
				CategoryBean category = new CategoryBean();
				category.setCategoryId(res.getInt("category_id"));
				category.setCategoryName(res.getString("category_name"));
				list.add(category);
			}
		}
		
		return list;
	}
	/**
	 * すべてのステータスの情報を取得
	 * @return すべてのステータス情報が入ったリスト
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<StatusBean> getAllStatus() throws ClassNotFoundException, SQLException{
		List<StatusBean> list = new ArrayList<>();
		String sql ="SELECT * FROM m_status";
		
		try(Connection con =ConnectionManager.getConnection();
				Statement pstmt =con.createStatement();) {
			ResultSet res = pstmt.executeQuery(sql);
			while(res.next()) {
				StatusBean status = new StatusBean();
				status.setStatusCode(res.getString("status_code"));
				status.setStatusName(res.getString("status_name"));
				list.add(status);
			} 
		}
		
		return list;
	}
}
