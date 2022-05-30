package Model.entity;
/**
 * カテゴリを表すクラス
 * @author emtech-user
 *
 */
public class CategoryBean {
	/**
	 * カテゴリID
	 */
	private int categoryId;
	/**
	 * カテゴリネーム
	 */
	private String categoryName;
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

}
