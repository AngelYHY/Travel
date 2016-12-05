package multibean;

public class RecommUser {
	private int recId;
    private String proName;
    private String recReason;
    private String account;
    private String recTime;
    private String recLink;
    
    private int userId;
    private String userName;
    private String headImg;
  //===recommend_id_pk,product_name,recomm_reason,recomm_time
  	//recomm_account,recomm_link
  	//pk_user_id,user_name,head_picture_addr
	public RecommUser(int recId, String proName, String recReason, String recTime,
			String account,  String recLink,
			int userId, String userName, String headImg) {
		super();
		this.recId = recId;
		this.proName = proName;
		this.recReason = recReason;
		this.account = account;
		this.recTime = recTime;
		this.recLink = recLink;
		this.userId = userId;
		this.userName = userName;
		this.headImg = headImg;
	}
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getRecReason() {
		return recReason;
	}
	public void setRecReason(String recReason) {
		this.recReason = recReason;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRecTime() {
		return recTime;
	}
	public void setRecTime(String recTime) {
		this.recTime = recTime;
	}
	public String getRecLink() {
		return recLink;
	}
	public void setRecLink(String recLink) {
		this.recLink = recLink;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
    
}
