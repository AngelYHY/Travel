package beans;

public class CollectVo {

	private String kind;
	private int kindId;
	private String stime;
	private String account;
	public CollectVo(String kind, int kindId, String stime, String account) {
		super();
		this.kind = kind;
		this.kindId = kindId;
		this.stime = stime;
		this.account = account;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getKindId() {
		return kindId;
	}
	public void setKindId(int kindId) {
		this.kindId = kindId;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
