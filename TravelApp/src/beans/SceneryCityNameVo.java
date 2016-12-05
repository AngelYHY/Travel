package beans;

public class SceneryCityNameVo {

	private int sid;
	private String title;
	private String cityName;
	private String imgurl;
	
	

	public SceneryCityNameVo(int sid ,String title, String cityName, String imgurl) {
		super();
		this.sid = sid;
		this.title = title;
		this.cityName = cityName;
		this.imgurl = imgurl;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return  "title=" + title+", cityName=" + cityName ;
	}
	
}
