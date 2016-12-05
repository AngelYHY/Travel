package beans;

import java.io.Serializable;

public class ShowShoppingCart implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	购物车表的Id;
	String show_shopping_cart_id;
//	购物车里的商品的Id
	String show_shopping_cart_productid;
//	商品的第一张照片
	String show_shopping_cart_product_picture1;
//	商品的名字
	String show_shopping_cart_product_name;
//	商品的价格
	String show_shopping_cart_product_price;
//	商品的库存
	String show_shopping_cart_product_stock;
//	商品的数量
	String show_shopping_cart_product_count;
//	该商品属于哪个用户
	String show_shopping_cart_accountname;
//	该商品加入购物车的时间
	String show_shopping_cart_time;
	
	
	
	
	public ShowShoppingCart(String show_shopping_cart_id,
		String show_shopping_cart_productid,
		String show_shopping_cart_product_picture1,
		String show_shopping_cart_product_name,
		String show_shopping_cart_product_price,
		String show_shopping_cart_product_stock,
		String show_shopping_cart_product_count,
		String show_shopping_cart_accountname, String show_shopping_cart_time) {
	super();
	this.show_shopping_cart_id = show_shopping_cart_id;
	this.show_shopping_cart_productid = show_shopping_cart_productid;
	this.show_shopping_cart_product_picture1 = show_shopping_cart_product_picture1;
	this.show_shopping_cart_product_name = show_shopping_cart_product_name;
	this.show_shopping_cart_product_price = show_shopping_cart_product_price;
	this.show_shopping_cart_product_stock = show_shopping_cart_product_stock;
	this.show_shopping_cart_product_count = show_shopping_cart_product_count;
	this.show_shopping_cart_accountname = show_shopping_cart_accountname;
	this.show_shopping_cart_time = show_shopping_cart_time;
}
	public String getShow_shopping_cart_id() {
		return show_shopping_cart_id;
	}
	public void setShow_shopping_cart_id(String show_shopping_cart_id) {
		this.show_shopping_cart_id = show_shopping_cart_id;
	}
	public String getShow_shopping_cart_productid() {
		return show_shopping_cart_productid;
	}
	public void setShow_shopping_cart_productid(String show_shopping_cart_productid) {
		this.show_shopping_cart_productid = show_shopping_cart_productid;
	}
	public String getShow_shopping_cart_product_picture1() {
		return show_shopping_cart_product_picture1;
	}
	public void setShow_shopping_cart_product_picture1(
			String show_shopping_cart_product_picture1) {
		this.show_shopping_cart_product_picture1 = show_shopping_cart_product_picture1;
	}
	public String getShow_shopping_cart_product_name() {
		return show_shopping_cart_product_name;
	}
	public void setShow_shopping_cart_product_name(
			String show_shopping_cart_product_name) {
		this.show_shopping_cart_product_name = show_shopping_cart_product_name;
	}
	public String getShow_shopping_cart_product_price() {
		return show_shopping_cart_product_price;
	}
	public void setShow_shopping_cart_product_price(
			String show_shopping_cart_product_price) {
		this.show_shopping_cart_product_price = show_shopping_cart_product_price;
	}
	public String getShow_shopping_cart_product_stock() {
		return show_shopping_cart_product_stock;
	}
	public void setShow_shopping_cart_product_stock(
			String show_shopping_cart_product_stock) {
		this.show_shopping_cart_product_stock = show_shopping_cart_product_stock;
	}
	public String getShow_shopping_cart_product_count() {
		return show_shopping_cart_product_count;
	}
	public void setShow_shopping_cart_product_count(
			String show_shopping_cart_product_count) {
		this.show_shopping_cart_product_count = show_shopping_cart_product_count;
	}
	public String getShow_shopping_cart_accountname() {
		return show_shopping_cart_accountname;
	}
	public void setShow_shopping_cart_accountname(
			String show_shopping_cart_accountname) {
		this.show_shopping_cart_accountname = show_shopping_cart_accountname;
	}
	public String getShow_shopping_cart_time() {
		return show_shopping_cart_time;
	}
	public void setShow_shopping_cart_time(String show_shopping_cart_time) {
		this.show_shopping_cart_time = show_shopping_cart_time;
	}
	@Override
	public String toString() {
		return "ShowShoppingCart [show_shopping_cart_id="
				+ show_shopping_cart_id + ", show_shopping_cart_productid="
				+ show_shopping_cart_productid
				+ ", show_shopping_cart_product_picture1="
				+ show_shopping_cart_product_picture1
				+ ", show_shopping_cart_product_name="
				+ show_shopping_cart_product_name
				+ ", show_shopping_cart_product_price="
				+ show_shopping_cart_product_price
				+ ", show_shopping_cart_product_stock="
				+ show_shopping_cart_product_stock
				+ ", show_shopping_cart_product_count="
				+ show_shopping_cart_product_count
				+ ", show_shopping_cart_accountname="
				+ show_shopping_cart_accountname + ", show_shopping_cart_time="
				+ show_shopping_cart_time + "]";
	}
	
	
	
	


}
