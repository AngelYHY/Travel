package beans;

import java.util.List;

public class TrafficJsonVo {

	private List<TrafficVo> result;
	private String error_code;
	private String reason;
	
	public TrafficJsonVo(List<TrafficVo> result, String error_code, String reason) {
		super();
		this.result = result;
		this.error_code = error_code;
		this.reason = reason;
	}
	
	
	public List<TrafficVo> getResult() {
		return result;
	}
	public void setResult(List<TrafficVo> result) {
		this.result = result;
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
	
	
}
