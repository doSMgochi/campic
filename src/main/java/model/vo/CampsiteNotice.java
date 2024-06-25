package model.vo;

import java.sql.Date;

public class CampsiteNotice {
	int no;
	String writerId;
	String body;
	Date writedAt;
	String title;

	public CampsiteNotice() {
		super();
	}

	public CampsiteNotice(int no, String writerId, String body, Date writedAt, String title) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.body = body;
		this.writedAt = writedAt;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
