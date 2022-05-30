package Model.entity;
/**
 * ステータスを表すクラス
 * @author emtech-user
 *
 */
public class StatusBean {
	/**
	 * ステータスコード
	 */
	private String statusCode;
	/**
	 * ステータス名
	 */
	private String statusName;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
