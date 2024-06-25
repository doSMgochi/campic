package model.vo;

import java.sql.Date;

public class Cabin {
//캠핑장 숙소

	int no;
	int campsiteId;
	String writerId;
	String name;
	String body;
	Date checkIn;
	Date checkOut;
	int price;
	int atendee;
	String tag;

	public Cabin() {
		super();
	}

	public Cabin(int no, int campsiteId, String writerId, String name, String body, Date checkIn, Date checkOut,
			int price, int atendee, String tag) {
		super();
		this.no = no;
		this.campsiteId = campsiteId;
		this.writerId = writerId;
		this.name = name;
		this.body = body;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = price;
		this.atendee = atendee;
		this.tag = tag;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCampsiteId() {
		return campsiteId;
	}

	public void setCampsiteId(int campsiteId) {
		this.campsiteId = campsiteId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAtendee() {
		return atendee;
	}

	public void setAtendee(int atendee) {
		this.atendee = atendee;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
