package beans;

public class GoodVo {

	private int goodId;
	private String kind;
	private int kindId;
	
	private String goodAccount;
	public GoodVo(int goodId, String kind, int kindId,String goodAccount) {
		super();
		this.goodId = goodId;
		this.kind = kind;
		this.kindId = kindId;
		
		this.goodAccount = goodAccount;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
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
	
	
	public String getGoodAccount() {
		return goodAccount;
	}
	public void setGoodAccount(String goodAccount) {
		this.goodAccount = goodAccount;
	}
	@Override
	public String toString() {
		return "GoodVo [goodId=" + goodId + ", kind=" + kind + ", kindId=" + kindId +  "]";
	}
}
