package beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/16.
 */
public class JoinShoppingCart implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String accountname;
    String shopping_cart_time;
    String shopping_cart_product_id;
    String shopping_cart_product_count;


    @Override
    public String toString() {
        return "JoinShoppingCart{" +
                "accountname='" + accountname + '\'' +
                ", shopping_cart_time='" + shopping_cart_time + '\'' +
                ", shopping_cart_product_id='" + shopping_cart_product_id + '\'' +
                ", shopping_cart_product_count='" + shopping_cart_product_count + '\'' +
                '}';
    }

    public JoinShoppingCart(String shopping_cart_time, String shopping_cart_product_id, String shopping_cart_product_count, String accountname) {
        this.shopping_cart_time = shopping_cart_time;
        this.shopping_cart_product_id = shopping_cart_product_id;
        this.shopping_cart_product_count = shopping_cart_product_count;
        this.accountname = accountname;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getShopping_cart_time() {
        return shopping_cart_time;
    }

    public void setShopping_cart_time(String shopping_cart_time) {
        this.shopping_cart_time = shopping_cart_time;
    }

    public String getShopping_cart_product_id() {
        return shopping_cart_product_id;
    }

    public void setShopping_cart_product_id(String shopping_cart_product_id) {
        this.shopping_cart_product_id = shopping_cart_product_id;
    }

    public String getShopping_cart_product_count() {
        return shopping_cart_product_count;
    }

    public void setShopping_cart_product_count(String shopping_cart_product_count) {
        this.shopping_cart_product_count = shopping_cart_product_count;
    }
}
