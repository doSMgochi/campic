package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.CampsiteNotice;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class CampsiteNoticeDao {
	public int generateKey() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT CAMPSITE_NOTICE_SEQ.NEXTVAL FROM DUAL");
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

			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM CAMPSITE_NOTCIE");
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

	public boolean save(CampsiteNotice newCampsiteNotice) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("insert into CAMPSITE_NOTICE values(?, ?, ?, ?, ?)");

			stmt.setInt(1, newCampsiteNotice.getNo());
			stmt.setString(2, newCampsiteNotice.getWriterId());
			stmt.setString(3, newCampsiteNotice.getBody());
			stmt.setDate(4, newCampsiteNotice.getWritedAt());
			stmt.setString(5, newCampsiteNotice.getTitle());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean edit(CampsiteNotice oldCampsiteNotice) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("UPDATE CAMPSITE_NOTICE SET TITLE=? , BODY=? WHERE no =?");
			stmt.setString(1, oldCampsiteNotice.getTitle());
			stmt.setString(2, oldCampsiteNotice.getBody());
			stmt.setInt(3, oldCampsiteNotice.getNo());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public CampsiteNotice findByNo(int no) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			// 식별키로 조회하고,
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CAMPSITE_NOTICE WHERE no=?");
			stmt.setInt(1, no);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new CampsiteNotice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
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
			// 식별키로 조회하고,
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Campsite_Notice WHERE no=?");
			stmt.setInt(1, no);

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<CampsiteNotice> findAll(int start, int end) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"select * from (select g.*, rownum rn from (select * from Campsite_Notice order by no desc) g) where rn between ? and ?");
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			ResultSet rs = stmt.executeQuery();
			List<CampsiteNotice> campsiteNotices = new ArrayList<CampsiteNotice>();
			while (rs.next()) {
				CampsiteNotice one = new CampsiteNotice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
				campsiteNotices.add(one);
			}
			return campsiteNotices;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<CampsiteNotice> searchByCampsiteNotice(String search) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM Campsite_Notice WHERE TITLE LIKE ? OR BODY LIKE ? ORDER BY NO DESC");
			stmt.setString(1, "%" + search + "%");
			stmt.setString(2, "%" + search + "%");
			ResultSet rs = stmt.executeQuery();
			List<CampsiteNotice> campsiteNotices = new ArrayList<CampsiteNotice>();
			while (rs.next()) {
				CampsiteNotice one = new CampsiteNotice();

				one.setNo(rs.getInt("no"));
				one.setWriterId(rs.getString("writer_id"));
				one.setBody(rs.getString("body"));
				one.setWritedAt(rs.getDate("writed_at"));
				one.setTitle(rs.getString("title"));

				campsiteNotices.add(one);
			}

			return campsiteNotices;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
