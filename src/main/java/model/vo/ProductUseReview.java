package model.vo;

import java.sql.Date;

public class ProductUseReview {
	int no;
	String writerId;
	int productNo;
	int scope;
	String goods;
	String bads;
	Date writedAt;

	public ProductUseReview() {
		super();
	}

	public ProductUseReview(int no, String writerId, int productNo, int scope, String goods, String bads,
			Date writedAt) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.productNo = productNo;
		this.scope = scope;
		this.goods = goods;
		this.bads = bads;
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

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getBads() {
		return bads;
	}

	public void setBads(String bads) {
		this.bads = bads;
	}

	public Date getWritedAt() {
		return writedAt;
	}

	public void setWritedAt(Date writedAt) {
		this.writedAt = writedAt;
	}

}
