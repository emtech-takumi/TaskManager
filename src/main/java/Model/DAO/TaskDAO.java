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
				ResultSet res =stmt.executeQuery("SELECT * FROM task_db")){
		
			while(res.next()) {
				TaskBean task = new TaskBean();
				task.setTaskId(0);
				task.setTaskName(null);
				task.setCategoryId(0);
				task.setCategoryName(null);
				task.setDeadLine(null);
				task.setUserId(0);
				task.setUserName(null);
				task.setStatusId(0);
				task.setStatus(null);
				task.setMemo(null);
				task.setRegisterDate(null);
				task.setUpdateDate(null);
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
