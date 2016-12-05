package beans;

public class UrlAndKeyVo {

	//private String key = "fed4e696782349259f6962051225f524";//--林桂全的
	private String key = "3b535cd2cc1d4b2f848dd75e4812c8ec";//---这是王立法的
	//private String key = "fca0c1648f02457bb0e0ad12ea975250";//---这是我的
	//private String key = "43b3705175834705a87ad8dd245f59a0";//这是洪哲的
	private String url = "http://apis.haoservice.com/lifeservice/travel/cityList";//---参数  ?key=;
	//page=1第N页，每页返回10条数据每页返回10条数据（默认为第1页）
	//----景点列表的接口地址  ；?pid=2&cid=45&page=1&key=您申请的APPKEY
	private String urlScenery = "http://apis.haoservice.com/lifeservice/travel/scenery";
	//---景点详情；需要参数sid，key
	private String urlInfo = "http://apis.haoservice.com/lifeservice/travel/GetScenery";
	//门票信息；参数sid，key
	private String urlTicket = "http://apis.haoservice.com/lifeservice/travel/TicketInfo";
	
	//DT阿凡达数据库，使用的是城市公交/需要参数3个  ?key= &city= &station=
	private String keyDtBus = "8c3cd86afdda41f48c45ddb4b1022b04";//城市公交
	private String urlBus = "http://api.avatardata.cn/CityBus/LookUp";//公交站点查询
	private String keyDtTraffic = "0cd1f8d368f34dc28385ef79b595bde0";
	private String urlTraffic = "http://api.avatardata.cn/Traffic/LookUp";//
	
	
	public String getKeyDtBus() {
		return keyDtBus;
	}
	
	public String getKeyDtTraffic() {
		return keyDtTraffic;
	}
	public void setKeyDtTraffic(String keyDtTraffic) {
		this.keyDtTraffic = keyDtTraffic;
	}
	public String getUrlTraffic() {
		return urlTraffic;
	}
	public void setUrlTraffic(String urlTraffic) {
		this.urlTraffic = urlTraffic;
	}
	public String getUrlInfo() {
		return urlInfo;
	}
	public void setUrlInfo(String urlInfo) {
		this.urlInfo = urlInfo;
	}
	
	public String getUrlScenery() {
		return urlScenery;
	}
	public void setUrlScenery(String urlScenery) {
		this.urlScenery = urlScenery;
	}	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getUrlBus() {
		return urlBus;
	}
	public void setUrlBus(String urlBus) {
		this.urlBus = urlBus;
	}
	
	public String getUrlTicket() {
		return urlTicket;
	}
	public void setUrlTicket(String urlTicket) {
		this.urlTicket = urlTicket;
	}
}
