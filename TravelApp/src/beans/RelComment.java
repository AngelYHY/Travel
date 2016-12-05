package beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/21.
 */
public class RelComment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int relCommentId;
    private int releaseId;
    private String account;
    private String userName;
    private String commentTime;
    private String content;
    private String pName;//回复谁
    
    

    //这是根据数据库表的字段
    public RelComment(int relCommentId, int releaseId, String account
            , String commentTime, String content,String pName) {
        this.account = account;
        this.commentTime = commentTime;
        
        this.pName = pName;
        this.relCommentId = relCommentId;
        this.releaseId = releaseId;
        this.content = content;
    }

    //这是接收数据，需要的字段----在RelComment的dao有用到
    public RelComment(int relCommentId, int releaseId, String account, String userName
            , String commentTime,String content,String pName) {
        this.account = account;
        this.commentTime = commentTime;
       
        
        this.relCommentId = relCommentId;
        this.releaseId = releaseId;
        this.userName = userName;
        this.pName = pName;
        this.content = content;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }


    public int getRelCommentId() {
        return relCommentId;
    }

    public void setRelCommentId(int relCommentId) {
        this.relCommentId = relCommentId;
    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
