package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
						+ "SELECT T.task_id"
						+ "    ,T.task_name"
						+ "    ,C.category_id"
						+ "    ,C.category_name"
						+ "    ,T.limit_date"
						+ "    ,U.user_id"
						+ "    ,U.user_name"
						+ "    ,S.status_code"
						+ "    ,S.status_name"
						+ "    ,T.memo"
						+ "    ,T.create_datetime"
						+ "    ,T.update_datetime"
						+ "  FROM t_task AS T"
						+ "  INNER JOIN m_user U"
						+ "  ON T.user_id = U.user_id"
						+ "  INNER JOIN m_category C"
						+ "  ON T.category_id = C.category_id"
						+ "  INNER JOIN m_status S"
						+ "  ON T.status_code = S.status_code")
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
				task.setStatusId(res.getString("status_code"));
				task.setStatus(res.getString("status_name"));
				task.setMemo(res.getString("memo"));
				task.setRegisterDate(res.getString("create_datetime"));
				task.setUpdateDate(res.getString("update_datetime"));
				list.add(task);
			}
		}
		return list;
	}
	public int delete(int taskId) throws ClassNotFoundException, SQLException{
		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement stmt =con.prepareStatement(""
						+ "DELETE FROM t_task"
						+ " WHERE task_id = ?");
		){
			stmt.setInt(1, taskId);
			return stmt.executeUpdate();
		}
	}
	public int insert(TaskBean task) throws ClassNotFoundException, SQLException{
		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement stmt = con.prepareStatement(""
						+ "INSERT INTO t_task"
						+ " VALUES (?,?,?,?,?,?,?,?,?)");
		){
			stmt.setInt(1, 0);
			stmt.setString(2, task.getTaskName());
			stmt.setInt(3, task.getCategoryId());
			stmt.setDate(4, java.sql.Date.valueOf(task.getDeadLine()));
			stmt.setString(5, String.valueOf(task.getUserId()));
			stmt.setString(6, task.getStatusId());
			stmt.setString(7, task.getMemo());
			stmt.setDate(8, java.sql.Date.valueOf(java.time.LocalDate.now()));
			stmt.setDate(9, java.sql.Date.valueOf(java.time.LocalDate.now()));
			return stmt.executeUpdate();
		}
	}
	public int update(int taskId, TaskBean task) throws ClassNotFoundException, SQLException{
		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement stmt =con.prepareStatement(""
						+ "UPDATE t_task"
						+ " SET "
						+ "	task_id = ?,"
						+ " task_name = ?,"
						+ " category_id = ?,"
						+ " limit_date = ?,"
						+ " user_id = ?,"
						+ " status_code = ?,"
						+ " memo = ?,"
						+ " create_datetime = ?,"
						+ " update_datetime = ?"
						+ " WHERE task_id = ?");
		){
			stmt.setInt(1, task.getTaskId());
			stmt.setString(2, task.getTaskName());
			stmt.setInt(3, task.getCategoryId());
			stmt.setDate(4, java.sql.Date.valueOf(task.getDeadLine()));
			stmt.setInt(5, task.getUserId());
			stmt.setString(6, task.getStatusId());
			stmt.setString(7, task.getMemo());
			stmt.setDate(8, java.sql.Date.valueOf(java.time.LocalDate.now()));
			stmt.setDate(9, java.sql.Date.valueOf(java.time.LocalDate.now()));
			stmt.setInt(10, task.getTaskId());
			return stmt.executeUpdate();
		}
	}

}
