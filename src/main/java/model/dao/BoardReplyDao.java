package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.BoardReply;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class BoardReplyDao {

	public int generateKey() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT BOARD_REPLY_SEQ.NEXTVAL FROM DUAL");
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

	public boolean save(BoardReply newBoardReply) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO BOARD_REPLY VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, newBoardReply.getNo());
			stmt.setString(2, newBoardReply.getWriterId());
			stmt.setInt(3, newBoardReply.getBoardId());
			stmt.setString(4, newBoardReply.getBody());
			stmt.setDate(5, newBoardReply.getWritedAt());
			stmt.setInt(6, newBoardReply.getFavorite());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<BoardReply> findAll(int boardId) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM BOARD_REPLY where BOARD_ID=? ORDER BY BOARD_ID DESC");
			stmt.setInt(1, boardId);

			ResultSet rs = stmt.executeQuery();
			List<BoardReply> boardReply = new ArrayList<>();
			while (rs.next()) {
				BoardReply one = new BoardReply();
				one.setNo(rs.getInt("no"));
				one.setWriterId(rs.getString("writer_id"));
				one.setBoardId(rs.getInt("board_id"));
				one.setBody(rs.getString("body"));
				one.setWritedAt(rs.getDate("writed_at"));
				one.setFavorite(rs.getInt("favorite"));

				boardReply.add(one);
			}

			return boardReply;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
