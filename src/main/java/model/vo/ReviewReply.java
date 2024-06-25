package model.vo;

import java.sql.Date;

public class ReviewReply {
	int no;
	int campsiteId;
	String writerId;
	String body;
	Date writedAt;

	public ReviewReply() {
		super();
	}

	public ReviewReply(int no, int campsiteId, String writerId, String body, Date writedAt) {
		super();
		this.no = no;
		this.campsiteId = campsiteId;
		this.writerId = writerId;
		this.body = body;
		this.writedAt = writedAt;
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
