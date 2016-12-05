package dao;

import java.util.List;

import beans.ProductOrder;

public interface InputProductOrder {
	public List<Integer> inputproductorder(List<ProductOrder> olist,List<Integer> cartlist);

}
