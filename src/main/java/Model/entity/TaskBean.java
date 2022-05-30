package Model.entity;

import java.io.Serializable;
/**
 * タスクを表すクラス
 * @author emtech-user
 *
 */
public class TaskBean implements Serializable {
	/**
	 * タスクID
	 */
	private int taskId;
	/**
	 * タスク名
	 */
	private String taskName;
	/**
	 * カテゴリID
	 */
	private int categoryId;
	/**
	 * カテゴリ名
	 */
	private String categoryName;
	/**
	 * 期限
	 */
	private String deadLine;
	/**
	 * ユーザID(担当者ID)
	 */
	private String userId;
	/**
	 * ユーザ名(担当者名)
	 */
	private String userName;
	/**
	 * ステータスID
	 */
	private String statusId;
	/**
	 * ステータス
	 */
	private String status;
	/**
	 * メモ内容
	 */
	private String memo;
	/**
	 * 登録日
	 */
	private String registerDate;
	/**
	 * 更新日
	 */
	private String updateDate;
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
}
