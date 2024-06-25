package model.vo;

import java.sql.Date;

public class Review {
	int no;
	int campsiteId;
	String writerId;
	String privateUser;
	String selectTag;
	String writeTag;
	String body;
	Date writedAt;

	public Review() {
		super();
	}

	public Review(int no, int campsiteId, String writerId, String privateUser, String selectTag, String writeTag,
			String body, Date writedAt) {
		super();
		this.no = no;
		this.campsiteId = campsiteId;
		this.writerId = writerId;
		this.privateUser = privateUser;
		this.selectTag = selectTag;
		this.writeTag = writeTag;
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

	public String getPrivateUser() {
		return privateUser;
	}

	public void setPrivateUser(String privateUser) {
		this.privateUser = privateUser;
	}

	public String getSelectTag() {
		return selectTag;
	}

	public void setSelectTag(String selectTag) {
		this.selectTag = selectTag;
	}

	public String getWriteTag() {
		return writeTag;
	}

	public void setWriteTag(String writeTag) {
		this.writeTag = writeTag;
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
