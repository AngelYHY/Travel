package beans;

public class SceneryInfoVo {

	private String title;
	private String referral;
	private String img;
	public SceneryInfoVo(String title, String referral, String img) {
		super();
		this.title = title;
		this.referral = referral;
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReferral() {
		return referral;
	}
	public void setReferral(String referral) {
		this.referral = referral;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
