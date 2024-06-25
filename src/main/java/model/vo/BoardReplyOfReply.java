package model.vo;

import java.sql.Date;

public class BoardReplyOfReply {
	int no;
	String writerId;
	int boardId;
	int boardReplyId;
	String body;
	Date writedAt;
	int favorite;

	public BoardReplyOfReply() {
		super();
	}

	public BoardReplyOfReply(int no, String writerId, int boardId, int boardReplyId, String body, Date writedAt,
			int favorite) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.boardId = boardId;
		this.boardReplyId = boardReplyId;
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

	public int getBoardReplyId() {
		return boardReplyId;
	}

	public void setBoardReplyId(int boardReplyId) {
		this.boardReplyId = boardReplyId;
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
