package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.entity.TaskBean;

public class TaskDAO {
	public List<TaskBean> selectAll() throws ClassNotFoundException, SQLException{
		List<TaskBean> list = new ArrayList<>();
		try(Connection con =ConnectionManager.getConnection();
				Statement stmt =con.createStatement();
				ResultSet res =stmt.executeQuery(""
						+ "SELECT *"
						+ " FROM t_task AS T"
						+ " INNER JOIN m_user U"
						+ " ON T.user_id = U.user_id"
						+ " INNER JOIN m_category C"
						+ " ON T.category_id = C.category_id"
						+ " INNER JOIN m_status S"
						+ " ON T.status_code = S.status_code")
		){
			while(res.next()) {
				TaskBean task = new TaskBean();
				task.setTaskId(res.getInt("task_id"));
				task.setTaskName(res.getString("task_name"));
				task.setCategoryId(res.getInt("category_id"));
				task.setCategoryName(res.getString("category_name"));
				task.setDeadLine(res.getString("limit_date"));
				task.setUserId(res.getInt("user_id"));
				task.setUserName(res.getString("user_name"));
				task.setStatusId(res.getInt("status_code"));
				task.setStatus(res.getString("status_name"));
				task.setMemo(res.getString("memo"));
				task.setRegisterDate(res.getString("create_datetime"));
				task.setUpdateDate(res.getString("update_datetime"));
			}
		}
		return list;
	}
	public int delete(int taskId) {
		return 0;
		
	}
	public int insert(TaskBean task) {
		return 0;
	}
	public int update(TaskBean task) {
		return 0;
	}

}
