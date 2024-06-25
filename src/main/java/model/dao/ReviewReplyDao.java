package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.ReviewReply;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class ReviewReplyDao {
	public int generateKey() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT REVIEW_REPLY_SEQ.NEXTVAL FROM DUAL");
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

	public int countAll() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM REVIEW_REPLY");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public boolean save(ReviewReply newReviewReply) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("insert into REVIEW_REPLY values(?, ?, ?, ?, ?)");

			stmt.setInt(1, newReviewReply.getNo());
			stmt.setInt(2, newReviewReply.getCampsiteId());
			stmt.setString(3, newReviewReply.getWriterId());
			stmt.setString(4, newReviewReply.getBody());
			stmt.setDate(5, newReviewReply.getWritedAt());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean edit(ReviewReply oldReviewReply) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("UPDATE REVIEW_REPLY SET BODY=? WHERE no =?");
			stmt.setString(1, oldReviewReply.getBody());
			stmt.setInt(2, oldReviewReply.getNo());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ReviewReply findByNo(int no) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REVIEW_REPLY WHERE no=?");
			stmt.setInt(1, no);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new ReviewReply(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteByNo(int no) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM REVIEW_REPLY WHERE no=?");
			stmt.setInt(1, no);

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ReviewReply> findAll(int start, int end) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"select * from (select g.*, rownum rn from (select * from REVIEW_REPLY order by no desc) g) where rn between ? and ?");
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			ResultSet rs = stmt.executeQuery();
			List<ReviewReply> reviewReplies = new ArrayList<ReviewReply>();
			while (rs.next()) {
				ReviewReply one = new ReviewReply(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				reviewReplies.add(one);
			}
			return reviewReplies;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
