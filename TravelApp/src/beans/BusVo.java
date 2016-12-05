package beans;

/**
 * Created by Administrator on 2016/8/16.
 */
public class BusVo {

    private String city;
    private String station;
    private String result;

    public BusVo(String city, String station, String result) {
        this.station = station;
        this.result = result;
        this.city = city;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
