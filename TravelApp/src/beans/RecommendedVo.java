package beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/23.
 */
public class RecommendedVo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int recId;
    private String proName;
    private String recReason;
    private String account;
    private String recTime;
    private String recLink;


    public RecommendedVo( int recId,String proName,String recReason
            ,String account,  String recTime,  String recLink) {
        this.account = account;
        this.proName = proName;
        this.recId = recId;
        this.recLink = recLink;
        this.recReason = recReason;
        this.recTime = recTime;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
  
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public String getRecLink() {
        return recLink;
    }

    public void setRecLink(String recLink) {
        this.recLink = recLink;
    }

    public String getRecReason() {
        return recReason;
    }

    public void setRecReason(String recReason) {
        this.recReason = recReason;
    }

    public String getRecTime() {
        return recTime;
    }

    public void setRecTime(String recTime) {
        this.recTime = recTime;
    }
}
