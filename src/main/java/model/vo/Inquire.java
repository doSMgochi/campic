package model.vo;

import java.sql.Date;

public class Inquire {
//문의

	int no;
	String writerId;
	int productNo;
	String tag;
	String body;
	Date writedAt;

	public Inquire() {
		super();
	}

	public Inquire(int no, String writerId, int productNo, String tag, String body, Date writedAt) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.productNo = productNo;
		this.tag = tag;
		this.body = body;
		this.writedAt = writedAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getWritedAt() {
		return writedAt;
	}

	public void setWritedAt(Date writedAt) {
		this.writedAt = writedAt;
	}

}
