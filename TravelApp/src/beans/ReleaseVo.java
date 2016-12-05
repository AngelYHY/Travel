package beans;

import java.io.Serializable;

public class ReleaseVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int releaseId;
	private String relAccount;
	private String relContent;
	private String relTime;
	
	
	public ReleaseVo(int releaseId, String relAccount, String relContent, String relTime) {
		super();
		this.releaseId = releaseId;
		this.relAccount = relAccount;
		this.relContent = relContent;
		this.relTime = relTime;
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

}
