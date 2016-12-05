package beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/2.
 */
public class CitySceneVo implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
    private String content;
    private String time1;
    private String time2;
    private String cityName;

    public CitySceneVo(String title, String content, String time1
            , String time2 , String cityName) {
        this.content = content;
        this.time1 = time1;
        this.time2 = time2;
        this.title = title;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
