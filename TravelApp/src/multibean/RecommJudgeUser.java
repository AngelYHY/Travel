package multibean;

public class RecommJudgeUser {

	//recommend_evaluate_id_pk,recommend_id_fk,account_name_fk,
	//evaluate_content,evaluate_time,eval_pname

	private int recJudgeId;
	private int recommId;
	private String account;
	private String name;
	private String judgeContent;
	private String time;
	private String pName;
	private String headImg;
	
	
	
	public RecommJudgeUser(int recJudgeId, int recommId, String account
			, String name, String judgeContent, String time,
			String pName,String headImg) {
		super();
		this.recJudgeId = recJudgeId;
		this.recommId = recommId;
		this.account = account;
		this.name = name;
		this.judgeContent = judgeContent;
		this.time = time;
		this.pName = pName;
		this.headImg = headImg;
	}
	
	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRecJudgeId() {
		return recJudgeId;
	}
	public void setRecJudgeId(int recJudgeId) {
		this.recJudgeId = recJudgeId;
	}
	public int getRecommId() {
		return recommId;
	}
	public void setRecommId(int recommId) {
		this.recommId = recommId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getJudgeContent() {
		return judgeContent;
	}
	public void setJudgeContent(String judgeContent) {
		this.judgeContent = judgeContent;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	
}
