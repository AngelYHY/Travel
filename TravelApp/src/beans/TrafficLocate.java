package beans;

public class TrafficLocate {

	private String lng;
	private String lat;
	public TrafficLocate(String lng, String lat) {
		super();
		this.lng = lng;
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
}
