package beans;

public class TicketVo {

	private String name;
	private String price_mk;
	private String price;
	public TicketVo(String name, String price_mk, String price) {
		super();
		this.name = name;
		this.price_mk = price_mk;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice_mk() {
		return price_mk;
	}
	public void setPrice_mk(String price_mk) {
		this.price_mk = price_mk;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
