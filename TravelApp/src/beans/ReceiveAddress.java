package beans;

import java.io.Serializable;
//收货地址的实体类
/**
 * Created by Administrator on 2016/8/22.
 */
public class ReceiveAddress implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//    收货地址的id
   int receive_id;
//    当前的用户名
    String account_name;
//收货人的名字
    String name;
//    收货人的电话号码
    String phone_num;
//    收货地址的省
    String province;
//    收货地址的市
    String city;
//    收货的具体详细的地址
    String detailed_addr;
//   是否为默认地址
    int default_address;





    public ReceiveAddress(String name, String phone_num, String province,
			String city, String detailed_addr) {
		super();
		this.name = name;
		this.phone_num = phone_num;
		this.province = province;
		this.city = city;
		this.detailed_addr = detailed_addr;
	}

	@Override
    public String toString() {
        return "ReceiveAddress{" +
                "receive_id=" + receive_id +
                ", account_name='" + account_name + '\'' +
                ", name='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", detailed_addr='" + detailed_addr + '\'' +
                ", default_address=" + default_address +
                '}';
    }

    public ReceiveAddress(int receive_id, String account_name, String name, String phone_num, String province, String city, String detailed_addr, int default_address) {
        this.receive_id = receive_id;
        this.account_name = account_name;
        this.name = name;
        this.phone_num = phone_num;
        this.province = province;
        this.city = city;
        this.detailed_addr = detailed_addr;
        this.default_address = default_address;
    }

    public int getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(int receive_id) {
        this.receive_id = receive_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailed_addr() {
        return detailed_addr;
    }

    public void setDetailed_addr(String detailed_addr) {
        this.detailed_addr = detailed_addr;
    }

    public int getDefault_address() {
        return default_address;
    }

    public void setDefault_address(int default_address) {
        this.default_address = default_address;
    }
}
