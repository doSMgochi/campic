package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.BoardReplyOfReply;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class BoardReplyOfReplyDao {

	public int generateKey() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT BOARDS_REPLY_OF_REPLY_SEQ.NEXTVAL FROM DUAL");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int key = rs.getInt("nextval");
				return key;
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public boolean save(BoardReplyOfReply newBoardReplyOfReply) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO BOARDS_REPLY_OF_REPLY VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, newBoardReplyOfReply.getNo());
			stmt.setString(2, newBoardReplyOfReply.getWriterId());
			stmt.setInt(3, newBoardReplyOfReply.getBoardId());
			stmt.setInt(4, newBoardReplyOfReply.getBoardReplyId());
			stmt.setString(5, newBoardReplyOfReply.getBody());
			stmt.setDate(6, newBoardReplyOfReply.getWritedAt());
			stmt.setInt(7, newBoardReplyOfReply.getFavorite());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<BoardReplyOfReply> findAll(int boardReply) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM BOARD_REPLY where BOARD_ID=? ORDER BY ID DESC");
			stmt.setInt(1, boardReply);

			ResultSet rs = stmt.executeQuery();
			List<BoardReplyOfReply> boardReplyOfReply = new ArrayList<>();
			while (rs.next()) {
				BoardReplyOfReply one = new BoardReplyOfReply();
				one.setNo(rs.getInt("no"));
				one.setWriterId(rs.getString("writer_id"));
				one.setBoardId(rs.getInt("board_id"));
				one.setBoardReplyId(rs.getInt("board_reply_id"));
				one.setBody(rs.getString("body"));
				one.setWritedAt(rs.getDate("writed_at"));
				one.setFavorite(rs.getInt("favorite"));

				boardReplyOfReply.add(one);
			}

			return boardReplyOfReply;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
