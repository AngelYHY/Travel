package multibean;

public class GoodUser {

	//int goodId, String kind, int kindId, int goodNum,String goodAccount
	//int userId, String userName, String headImg
	int goodId; String kind; int kindId; String goodAccount;
	int userId; String userName; String headImg;

	public GoodUser(int goodId, String kind, int kindId, String goodAccount, int userId, String userName,
			String headImg) {
		super();
		this.goodId = goodId;
		this.kind = kind;
		this.kindId = kindId;
		this.goodAccount = goodAccount;
		this.userId = userId;
		this.userName = userName;
		this.headImg = headImg;
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
