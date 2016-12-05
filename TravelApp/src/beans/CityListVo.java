package beans;

public class CityListVo {
  //cityId":"2","cityName":"安徽","provinceId
	private int cityId;
	private String cityName;
	private int provinceId;
	
	public CityListVo(int cityId, String cityName, int provinceId) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.provinceId = provinceId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	
	
}
