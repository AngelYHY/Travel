package beans;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Evaluate {

    int evaluate_id;
    int order_id;
    int product_id;
    String accountname;
    String evaluate_time;
    int product_count;
    String evaluate_content;


    public Evaluate(int evaluate_id, int order_id, int product_id, String accountname, String evaluate_time, int product_count, String evaluate_content) {
        this.evaluate_id = evaluate_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.accountname = accountname;
        this.evaluate_time = evaluate_time;
        this.product_count = product_count;
        this.evaluate_content = evaluate_content;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "evaluate_id=" + evaluate_id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", accountname='" + accountname + '\'' +
                ", evaluate_time='" + evaluate_time + '\'' +
                ", product_count=" + product_count +
                ", evaluate_content='" + evaluate_content + '\'' +
                '}';
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(int evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getEvaluate_time() {
        return evaluate_time;
    }

    public void setEvaluate_time(String evaluate_time) {
        this.evaluate_time = evaluate_time;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public String getEvaluate_content() {
        return evaluate_content;
    }

    public void setEvaluate_content(String evaluate_content) {
        this.evaluate_content = evaluate_content;
    }
}
