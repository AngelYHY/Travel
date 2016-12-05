package beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/26.
 */
public class ProductOrderState implements Serializable {
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
    //商品的名字
    String product_name;
//    商品的价格
    String product_price;
//    商品的第一张照片
    String product_picture1;
//   收货人姓名
    String name;
//    收货人的电话号码
    String phone_num;
//    收货的省
    String province;
//    收货的市
    String city;
//    收货的具体地址
    String detailed_addr;


    public ProductOrderState(String name, String phone_num, String detailed_addr, String province, String city, String product_price, String product_picture1, String product_name, String express_number, String buyer_message, String evaluate_time, int is_evaluate, String receive_time, int is_receive, String back_time, int is_back_product, String pay_time, int ispay, String order_time, String account_name, int product_id, int product_count, int receive_id, int order_id) {
        this.name = name;
        this.phone_num = phone_num;
        this.detailed_addr = detailed_addr;
        this.province = province;
        this.city = city;
        this.product_price = product_price;
        this.product_picture1 = product_picture1;
        this.product_name = product_name;
        this.express_number = express_number;
        this.buyer_message = buyer_message;
        this.evaluate_time = evaluate_time;
        this.is_evaluate = is_evaluate;
        this.receive_time = receive_time;
        this.is_receive = is_receive;
        this.back_time = back_time;
        this.is_back_product = is_back_product;
        this.pay_time = pay_time;
        this.ispay = ispay;
        this.order_time = order_time;
        this.account_name = account_name;
        this.product_id = product_id;
        this.product_count = product_count;
        this.receive_id = receive_id;
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "ProductOrderState{" +
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
                ", product_name='" + product_name + '\'' +
                ", product_price='" + product_price + '\'' +
                ", product_picture1='" + product_picture1 + '\'' +
                ", name='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", detailed_addr='" + detailed_addr + '\'' +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public int getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(int receive_id) {
        this.receive_id = receive_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getIspay() {
        return ispay;
    }

    public void setIspay(int ispay) {
        this.ispay = ispay;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public int getIs_back_product() {
        return is_back_product;
    }

    public void setIs_back_product(int is_back_product) {
        this.is_back_product = is_back_product;
    }

    public String getBack_time() {
        return back_time;
    }

    public void setBack_time(String back_time) {
        this.back_time = back_time;
    }

    public int getIs_receive() {
        return is_receive;
    }

    public void setIs_receive(int is_receive) {
        this.is_receive = is_receive;
    }

    public String getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(String receive_time) {
        this.receive_time = receive_time;
    }

    public int getIs_evaluate() {
        return is_evaluate;
    }

    public void setIs_evaluate(int is_evaluate) {
        this.is_evaluate = is_evaluate;
    }

    public String getEvaluate_time() {
        return evaluate_time;
    }

    public void setEvaluate_time(String evaluate_time) {
        this.evaluate_time = evaluate_time;
    }

    public String getBuyer_message() {
        return buyer_message;
    }

    public void setBuyer_message(String buyer_message) {
        this.buyer_message = buyer_message;
    }

    public String getExpress_number() {
        return express_number;
    }

    public void setExpress_number(String express_number) {
        this.express_number = express_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_picture1() {
        return product_picture1;
    }

    public void setProduct_picture1(String product_picture1) {
        this.product_picture1 = product_picture1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailed_addr() {
        return detailed_addr;
    }

    public void setDetailed_addr(String detailed_addr) {
        this.detailed_addr = detailed_addr;
    }
}
