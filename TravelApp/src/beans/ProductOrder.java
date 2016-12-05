package beans;

import java.io.Serializable;


public class ProductOrder implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//    订单表的id
    int order_id;
    int product_id;
    int product_count;
//收货地址的id
    int receive_id;
//   当前的用户名，唯一的
    String account_name;
//    产生订单的时间
    String order_time;
//    是否支付了。0为没支付，1为支付了，默认为0
    int ispay;
//    支付的时间
    String pay_time;
//    是否发货
    int is_back_product;
//    发货时间
    String back_time;
//    是否收货
   int is_receive;
//收货时间
    String receive_time;
//    是否评论
    int is_evaluate;
//    评论时间
    String evaluate_time;
//买家留言
   String buyer_message;

//快递编号
    String express_number;


    @Override
    public String toString() {
        return "ProductOrder{" +
                "order_id=" + order_id +
                ", product_id=" + product_id +
                ", product_count=" + product_count +
                ", receive_id=" + receive_id +
                ", account_name='" + account_name + '\'' +
                ", order_time='" + order_time + '\'' +
                ", ispay=" + ispay +
                ", pay_time='" + pay_time + '\'' +
                ", is_back_product=" + is_back_product +
                ", back_time='" + back_time + '\'' +
                ", is_receive=" + is_receive +
                ", receive_time='" + receive_time + '\'' +
                ", is_evaluate=" + is_evaluate +
                ", evaluate_time='" + evaluate_time + '\'' +
                ", buyer_message='" + buyer_message + '\'' +
                ", express_number='" + express_number + '\'' +
                '}';
    }

    public ProductOrder(int product_count, int order_id, int product_id, int receive_id, String account_name, String order_time, int ispay, String pay_time, int is_back_product, String back_time, int is_receive, String receive_time, int is_evaluate, String buyer_message, String evaluate_time, String express_number) {
        this.product_count = product_count;
        this.order_id = order_id;
        this.product_id = product_id;
        this.receive_id = receive_id;
        this.account_name = account_name;
        this.order_time = order_time;
        this.ispay = ispay;
        this.pay_time = pay_time;
        this.is_back_product = is_back_product;
        this.back_time = back_time;
        this.is_receive = is_receive;
        this.receive_time = receive_time;
        this.is_evaluate = is_evaluate;
        this.buyer_message = buyer_message;
        this.evaluate_time = evaluate_time;
        this.express_number = express_number;
    }

    public String getExpress_number() {
        return express_number;
    }

    public void setExpress_number(String express_number) {
        this.express_number = express_number;
    }

    public String getBuyer_message() {
        return buyer_message;
    }

    public void setBuyer_message(String buyer_message) {
        this.buyer_message = buyer_message;
    }

    public String getEvaluate_time() {
        return evaluate_time;
    }

    public void setEvaluate_time(String evaluate_time) {
        this.evaluate_time = evaluate_time;
    }

    public int getIs_evaluate() {
        return is_evaluate;
    }

    public void setIs_evaluate(int is_evaluate) {
        this.is_evaluate = is_evaluate;
    }

    public String getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(String receive_time) {
        this.receive_time = receive_time;
    }

    public int getIs_receive() {
        return is_receive;
    }

    public void setIs_receive(int is_receive) {
        this.is_receive = is_receive;
    }

    public String getBack_time() {
        return back_time;
    }

    public void setBack_time(String back_time) {
        this.back_time = back_time;
    }

    public int getIs_back_product() {
        return is_back_product;
    }

    public void setIs_back_product(int is_back_product) {
        this.is_back_product = is_back_product;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public int getIspay() {
        return ispay;
    }

    public void setIspay(int ispay) {
        this.ispay = ispay;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public int getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(int receive_id) {
        this.receive_id = receive_id;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
