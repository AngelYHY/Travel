package beans;

import java.io.Serializable;

public class BannerSceneVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String title;
	private String intro;
	private String tips;
	private String open_time;
	private String trip_time;
	private String city_name;
	
	
	
	public BannerSceneVo(Integer id , String title, String intro, String tips
			, String open_time, String trip_time,
			String city_name) {
		super();
		this.id = id;
		this.title = title;
		this.intro = intro;
		this.tips = tips;
		this.open_time = open_time;
		this.trip_time = trip_time;
		this.city_name = city_name;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public String getOpen_time() {
		return open_time;
	}
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}
	public String getTrip_time() {
		return trip_time;
	}
	public void setTrip_time(String trip_time) {
		this.trip_time = trip_time;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
