package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.entity.TaskBean;
/**
 * タスク情報のDAO
 * @author emtech-user
 *
 */
public class TaskDAO {
	/**
	 * すべてのタスクの情報を取得
	 * @return 登録されたすべてのタスク情報が格納されたTaskBeanのリスト
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
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
				task.setUserId(res.getString("user_id"));
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
	/**
	 * タスクを削除する
	 * @param taskId 削除したいタスクのタスクID
	 * @return 削除した件数 (1->成功 0->失敗)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
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
	/**
	 * タスクを登録する
	 * @param task 登録するTaskBean
	 * @return 登録した件数 (1->成功 0->失敗)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insert(TaskBean task) throws ClassNotFoundException, SQLException{
		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement stmt = con.prepareStatement(""
						+ "INSERT INTO t_task"
						+ " VALUES (?,?,?,?,?,?,?,?,?)");
		){
			stmt.setInt(1, 0);
			stmt.setString(2, task.getTaskName());
			stmt.setInt(3, task.getCategoryId());
			if(task.getDeadLine() == "") {
				stmt.setNull(4, java.sql.Types.NULL);
			}else {
				stmt.setString(4, task.getDeadLine());
			}
			stmt.setString(5, String.valueOf(task.getUserId()));
			stmt.setString(6, task.getStatusId());
			stmt.setString(7, task.getMemo());
			stmt.setDate(8, java.sql.Date.valueOf(java.time.LocalDate.now()));
			stmt.setDate(9, java.sql.Date.valueOf(java.time.LocalDate.now()));
			return stmt.executeUpdate();
		}
	}
	/**
	 * タスクを更新する
	 * @param taskId 更新対象のタスクのタスクID
	 * @param task 更新後のタスクの内容
	 * @return 更新した件数 (1->成功 0->失敗)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
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
						+ " update_datetime = ?"
						+ " WHERE task_id = ?");
		){
			stmt.setInt(1, task.getTaskId());
			stmt.setString(2, task.getTaskName());
			stmt.setInt(3, task.getCategoryId());
			stmt.setString(4, task.getDeadLine());
			stmt.setString(5, task.getUserId());
			stmt.setString(6, task.getStatusId());
			stmt.setString(7, task.getMemo());
			stmt.setDate(8, java.sql.Date.valueOf(java.time.LocalDate.now()));
			stmt.setInt(9, task.getTaskId());
			return stmt.executeUpdate();
		}
	}

}
