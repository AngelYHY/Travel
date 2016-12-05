package beans;

/**
 * Created by Administrator on 2016/8/16.
 */
public class BusJsonVo {
    private BusVo result;
    private String error_code;
    private String reason;


    public BusJsonVo(BusVo result ,String error_code, String reason) {
        this.result = result;
        this.error_code = error_code;
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public BusVo getResult() {
        return result;
    }

    public void setResult(BusVo result) {
        this.result = result;
    }
}
