package model.vo;

import java.sql.Date;

public class Board {
	int no;
	String writerId;
	String body;
	String selectTag;
	String writeTag;
	Date writedAt;
	int favorite;
	String category;
	String title;
	int readCnt;

	public Board() {
		super();
	}

	public Board(int no, String writerId, String body, String selectTag, String writeTag, Date writedAt, int favorite,
			String category, String title, int readCnt) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.body = body;
		this.selectTag = selectTag;
		this.writeTag = writeTag;
		this.writedAt = writedAt;
		this.favorite = favorite;
		this.category = category;
		this.title = title;
		this.readCnt = readCnt;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

}
