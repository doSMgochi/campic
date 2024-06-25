package model.vo;

import java.sql.Date;

public class ProductBuyReview {
	int no;
	String writerId;
	int productNo;
	int scope;
	String body;
	Date writedAt;

	public ProductBuyReview() {
		super();
	}

	public ProductBuyReview(int no, String writerId, int productNo, int scope, String body, Date writedAt) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.productNo = productNo;
		this.scope = scope;
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

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
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
