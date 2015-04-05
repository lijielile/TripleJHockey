package beans;

public class ItemBean {
	// TODO: add a field for each column in the Item table in the database, along with getters/setters
	/**
	 * Added the implementation of ItemBean
	 * @author jie
	 */
	private String productName;
	private double price;
	private String image;
	public ItemBean(String productName, double price, String image) {
		super();
		this.productName = productName;
		this.price = price;
		this.image = image;
	}
	public ItemBean() {
		super();
	}
	public String getProductName() {
		return productName;
	}
	public double getPrice() {
		return price;
	}
	public String getImage() {
		return image;
	}
	
}
