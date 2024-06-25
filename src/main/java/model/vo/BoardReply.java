package model.vo;

import java.sql.Date;

public class BoardReply {
	int no;
	String writerId;
	int boardId;
	String body;
	Date writedAt;
	int favorite;

	public BoardReply() {
		super();
	}

	public BoardReply(int no, String writerId, int boardId, String body, Date writedAt, int favorite) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.boardId = boardId;
		this.body = body;
		this.writedAt = writedAt;
		this.favorite = favorite;
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

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
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

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

}
