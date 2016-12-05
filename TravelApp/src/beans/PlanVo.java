package beans;

/**
 * Created by Administrator on 2016/8/17.
 */
public class PlanVo {
    private int planId;
    private String account;
    private String sdate;
    private int featureId;

    public PlanVo(int planId,String account,  String sdate, int featureId) {
        this.account = account;
        this.featureId = featureId;
        this.planId = planId;
        this.sdate = sdate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    @Override
    public String toString() {
        return "PlanVo{" + "account='" + account + ", planId=" + planId + ", sdate='" + sdate +
                ", featureId=" + featureId +
                '}';
    }
}
