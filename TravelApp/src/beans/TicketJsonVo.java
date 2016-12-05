package beans;

import java.util.List;

public class TicketJsonVo {

	private String error_code;
	private String reason;
	private List<TicketVo> result;
	public TicketJsonVo(String error_code, String reason, List<TicketVo> result) {
		super();
		this.error_code = error_code;
		this.reason = reason;
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
	public List<TicketVo> getResult() {
		return result;
	}
	public void setResult(List<TicketVo> result) {
		this.result = result;
	}
	
}
