package beans;

import java.io.Serializable;

public class ProductShop implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String ProductId;
    String productCity;
    String productName;
    String productCategotyId;
    String productDiscription;
    float productPrice;
    int productStock;
    String productCountUnit;
    String productPicture1;
    String productPicture2;
    String productPicture3;
	@Override
	public String toString() {
		return "ProductShop [ProductId=" + ProductId + ", productCity="
				+ productCity + ", productName=" + productName
				+ ", productCategotyId=" + productCategotyId
				+ ", productDiscription=" + productDiscription
				+ ", productPrice=" + productPrice + ", productStock="
				+ productStock + ", productCountUnit=" + productCountUnit
				+ ", productPicture1=" + productPicture1 + ", productPicture2="
				+ productPicture2 + ", productPicture3=" + productPicture3
				+ "]";
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductCity() {
		return productCity;
	}
	public void setProductCity(String productCity) {
		this.productCity = productCity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategotyId() {
		return productCategotyId;
	}
	public void setProductCategotyId(String productCategotyId) {
		this.productCategotyId = productCategotyId;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public String getProductCountUnit() {
		return productCountUnit;
	}
	public void setProductCountUnit(String productCountUnit) {
		this.productCountUnit = productCountUnit;
	}
	public String getProductPicture1() {
		return productPicture1;
	}
	public void setProductPicture1(String productPicture1) {
		this.productPicture1 = productPicture1;
	}
	public String getProductPicture2() {
		return productPicture2;
	}
	public void setProductPicture2(String productPicture2) {
		this.productPicture2 = productPicture2;
	}
	public String getProductPicture3() {
		return productPicture3;
	}
	public void setProductPicture3(String productPicture3) {
		this.productPicture3 = productPicture3;
	}
	public ProductShop() {
		
	}
		
	
	public ProductShop(String productId, String productCity, String productName,
					   String productCategotyId, String productDiscription,
					   float productPrice, int productStock, String productCountUnit,
					   String productPicture1, String productPicture2,
					   String productPicture3) {
		super();
		ProductId = productId;
		this.productCity = productCity;
		this.productName = productName;
		this.productCategotyId = productCategotyId;
		this.productDiscription = productDiscription;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productCountUnit = productCountUnit;
		this.productPicture1 = productPicture1;
		this.productPicture2 = productPicture2;
		this.productPicture3 = productPicture3;
	}

   
}
