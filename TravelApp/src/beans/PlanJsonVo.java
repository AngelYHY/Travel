package beans;


public class PlanJsonVo {

	private PlanVo planVo;
	private SceneryListVo sceneryListVo;
	private String cityName;
	public PlanJsonVo(PlanVo planVo, SceneryListVo sceneryListVo, String cityName) {
		super();
		this.planVo = planVo;
		this.sceneryListVo = sceneryListVo;
		this.cityName = cityName;
	}
	public PlanVo getPlanVo() {
		return planVo;
	}
	public void setPlanVo(PlanVo planVo) {
		this.planVo = planVo;
	}
	public SceneryListVo getSceneryListVo() {
		return sceneryListVo;
	}
	public void setSceneryListVo(SceneryListVo sceneryListVo) {
		this.sceneryListVo = sceneryListVo;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
