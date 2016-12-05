package beans;

public class TrafficVo {

	private String startTime;
	private String endTime;
	private String title;
	private String description;
	private TrafficLocate location;	
	private String type;
	public TrafficVo(String startTime, String endTime, String title
			, String description, TrafficLocate location,
			String type) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.description = description;
		this.location = location;
		this.type = type;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TrafficLocate getLocation() {
		return location;
	}
	public void setLocation(TrafficLocate location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
