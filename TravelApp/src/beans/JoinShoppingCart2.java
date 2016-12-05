package beans;

import java.io.Serializable;

public class JoinShoppingCart2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int shopping_cart_id;
	 String accountname;
	 int shopping_cart_product_id;
	 int shopping_cart_product_count;
	    String shopping_cart_time;
	    
	    
	    
	    
		@Override
		public String toString() {
			return "JoinShoppingCart2 [shopping_cart_id=" + shopping_cart_id
					+ ", accountname=" + accountname
					+ ", shopping_cart_product_id=" + shopping_cart_product_id
					+ ", shopping_cart_product_count="
					+ shopping_cart_product_count + ", shopping_cart_time="
					+ shopping_cart_time + "]";
		}
		public JoinShoppingCart2(int shopping_cart_id, String accountname,
				int shopping_cart_product_id, int shopping_cart_product_count,
				String shopping_cart_time) {
			super();
			this.shopping_cart_id = shopping_cart_id;
			this.accountname = accountname;
			this.shopping_cart_product_id = shopping_cart_product_id;
			this.shopping_cart_product_count = shopping_cart_product_count;
			this.shopping_cart_time = shopping_cart_time;
		}
		public int getShopping_cart_id() {
			return shopping_cart_id;
		}
		public void setShopping_cart_id(int shopping_cart_id) {
			this.shopping_cart_id = shopping_cart_id;
		}
		public String getAccountname() {
			return accountname;
		}
		public void setAccountname(String accountname) {
			this.accountname = accountname;
		}
		public int getShopping_cart_product_id() {
			return shopping_cart_product_id;
		}
		public void setShopping_cart_product_id(int shopping_cart_product_id) {
			this.shopping_cart_product_id = shopping_cart_product_id;
		}
		public int getShopping_cart_product_count() {
			return shopping_cart_product_count;
		}
		public void setShopping_cart_product_count(int shopping_cart_product_count) {
			this.shopping_cart_product_count = shopping_cart_product_count;
		}
		public String getShopping_cart_time() {
			return shopping_cart_time;
		}
		public void setShopping_cart_time(String shopping_cart_time) {
			this.shopping_cart_time = shopping_cart_time;
		}
	    
	    
	    
	    
	    
	    
		
	   
	
	
}
