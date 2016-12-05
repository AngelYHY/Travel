package lvchenglogin;

import java.io.Serializable;

//用户表的类
public class UserVo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String account;
	private String password;
	private String userName;
	private String address;
	private String phoneNum;
	private int age;
	private String sex;
	private String headImg;
	public UserVo(int userId, String account,String password,String userName, String address,
			String phoneNum,
			int age, String sex, String headImg) {
		super();
		this.userId = userId;
		this.account = account;
		this.password = password;
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.headImg = headImg;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "UserVo [account=" + account + ", userName=" + userName + ", phoneNum=" + phoneNum + ", age=" + age
				+ ", sex=" + sex + "]";
	}
}
