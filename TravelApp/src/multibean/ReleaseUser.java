package multibean;

public class ReleaseUser {

	//int releaseId, String relAccount, String relContent, String relTime
	//int userId, String account, String password, String userName
	//, String address, String phoneNum,
	//int age, String sex, String headImg
	int releaseId; String relAccount; String relContent; String relTime;
	int userId; String account; String userName; String headImg;


	public ReleaseUser(int releaseId, String relAccount, String relContent, String relTime, int userId, String account,
			String userName, String headImg) {
		super();
		this.releaseId = releaseId;
		this.relAccount = relAccount;
		this.relContent = relContent;
		this.relTime = relTime;
		this.userId = userId;
		this.account = account;
		this.userName = userName;
		this.headImg = headImg;
	}


	public int getReleaseId() {
		return releaseId;
	}


	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}


	public String getRelAccount() {
		return relAccount;
	}


	public void setRelAccount(String relAccount) {
		this.relAccount = relAccount;
	}


	public String getRelContent() {
		return relContent;
	}


	public void setRelContent(String relContent) {
		this.relContent = relContent;
	}


	public String getRelTime() {
		return relTime;
	}


	public void setRelTime(String relTime) {
		this.relTime = relTime;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
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
