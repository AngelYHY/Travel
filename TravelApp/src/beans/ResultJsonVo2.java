package beans;

import java.util.ArrayList;

//----------接收SceneryListVo类型的ResultJsonVo

public class ResultJsonVo2 {
//----------{"error_code":0,"reason":"成功","result":[{"----参数要一样error_code,reason,result
	//205001参数错误,205002查询无结果
	String error_code;//-------0成功,10001错误的key,10003key过期
	String reason;//---"Success"
	ArrayList<SceneryListVo> result = new ArrayList<SceneryListVo>();
	
	public ResultJsonVo2(String error_code, String reason, ArrayList<SceneryListVo> result) {
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
	public ArrayList<SceneryListVo> getArrayList() {
		return result;
	}
	public void setArrayList(ArrayList<SceneryListVo> result) {
		this.result = result;
	}
	
	
}
