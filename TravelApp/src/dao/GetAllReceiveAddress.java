package dao;

import java.util.List;

import beans.ReceiveAddress;

public interface GetAllReceiveAddress {
//根据用户名来查询该用户的所有的收货地址
	public List<ReceiveAddress> getAllAddress(String accountname);

}
