package model.vo;

public class Product {
	int no;
	String name;
	String writerId;
	int price;
	int accumulate;
	int deliveryFee;
	String body;
	String manufacturer;

	public Product() {
		super();
	}

	public Product(int no, String name, String writerId, int price, int accumulate, int deliveryFee, String body,
			String manufacturer) {
		super();
		this.no = no;
		this.name = name;
		this.writerId = writerId;
		this.price = price;
		this.accumulate = accumulate;
		this.deliveryFee = deliveryFee;
		this.body = body;
		this.manufacturer = manufacturer;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAccumulate() {
		return accumulate;
	}

	public void setAccumulate(int accumulate) {
		this.accumulate = accumulate;
	}

	public int getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
