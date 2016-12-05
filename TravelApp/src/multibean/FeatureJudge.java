package multibean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/29.
 */
public class FeatureJudge implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sceneJudgeId;
    private String judgeName;
    private int sid;
    private float score;
    private String judgeContent;
    private String time;
    private String headImg;
    //feature_evaluate_id_pk"
	//+ ",feature_sid_fk,user_name_fk,score"
	//+ ",feature_evaluate,time
    public FeatureJudge(String headImg, String judgeName
            , String judgeContent, int sceneJudgeId
            , float score, int sid, String time) {
        this.headImg = headImg;
        this.judgeName = judgeName;
        this.judgeContent = judgeContent;
        this.sceneJudgeId = sceneJudgeId;
        this.score = score;
        this.sid = sid;
        this.time = time;  
    }

 

	public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }


    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeAccount(String judgeAccount) {
        this.judgeName = judgeAccount;
    }

    public String getJudgeContent() {
        return judgeContent;
    }

    public void setJudgeContent(String judgeContent) {
        this.judgeContent = judgeContent;
    }

    public int getSceneJudgeId() {
        return sceneJudgeId;
    }

    public void setSceneJudgeId(int sceneJudgeId) {
        this.sceneJudgeId = sceneJudgeId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FeatureJudge{" +
                "judgeName='" + judgeName + '\'' +
                ", sceneJudgeId=" + sceneJudgeId +
                ", sid=" + sid +
                ", score=" + score +
                ", time='" + time + '\'' +
                '}';
    }
}
