package Model.entity;
/**
 * ユーザ情報を表すクラス
 * @author emtech-user
 *
 */
public class UserBean {
	/**
	 * ユーザID
	 */
	private String userId;
	/**
	 * パスワード
	 */
	private String password;
	/**
	 * ユーザ名
	 */
	private String userName;
	/**
	 * 更新日
	 */
	private String updateDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	

}
