package beans;

import java.io.Serializable;

public class SceneryListVo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String title;
	private String grade;
	private float price_min;
	private int comm_cnt;
	private int cityId;
	private String address;
	private int sid;
	private String url;
	private String imgurl;
	
	
	public SceneryListVo(String title, int cityId, String imgurl) {
		super();
		this.title = title;
		this.cityId = cityId;
		this.imgurl = imgurl;
	}


	public SceneryListVo(String title, String grade, float price_min, int comm_cnt, int cityId, String address,
			int sid, String url, String imgurl) {
		super();
		this.title = title;
		this.grade = grade;
		this.price_min = price_min;
		this.comm_cnt = comm_cnt;
		this.cityId = cityId;
		this.address = address;
		this.sid = sid;
		this.url = url;
		this.imgurl = imgurl;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public float getPrice_min() {
		return price_min;
	}
	public void setPrice_min(float price_min) {
		this.price_min = price_min;
	}
	public int getComm_cnt() {
		return comm_cnt;
	}
	public void setComm_cnt(int comm_cnt) {
		this.comm_cnt = comm_cnt;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
}
