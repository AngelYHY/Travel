package dao;

import java.sql.SQLException;

public interface AllShopCartProduct {
//	查询该用户购物车里商品的总和
	public int getShopCartCount(String accountname) throws SQLException;
}
