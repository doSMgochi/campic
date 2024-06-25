package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Cabin;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class CabinDao {
	public int generateKey() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT CABIN_SEQ.NEXTVAL FROM DUAL");
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

			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM CABIN");
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

	public boolean save(Cabin newCabin) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("insert into Cabin values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, newCabin.getNo());
			stmt.setInt(2, newCabin.getCampsiteId());
			stmt.setString(3, newCabin.getWriterId());
			stmt.setString(4, newCabin.getName());
			stmt.setString(5, newCabin.getBody());
			stmt.setDate(6, newCabin.getCheckIn());
			stmt.setDate(7, newCabin.getCheckOut());
			stmt.setInt(8, newCabin.getPrice());
			stmt.setInt(9, newCabin.getAtendee());
			stmt.setString(10, newCabin.getTag());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean edit(Cabin oldCabin) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE Cabin SET name=? , BODY=? , check_in=?, check_out=?, price=?, atendee=?, tag=? WHERE no =?");
			stmt.setString(1, oldCabin.getName());
			stmt.setString(2, oldCabin.getBody());
			stmt.setDate(3, oldCabin.getCheckIn());
			stmt.setDate(4, oldCabin.getCheckOut());
			stmt.setInt(5, oldCabin.getPrice());
			stmt.setInt(6, oldCabin.getAtendee());
			stmt.setString(7, oldCabin.getTag());
			stmt.setInt(8, oldCabin.getNo());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Cabin findByNo(int no) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Cabin WHERE no=?");
			stmt.setInt(1, no);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Cabin(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
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
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Cabin WHERE no=?");
			stmt.setInt(1, no);

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Cabin> findAll(int start, int end) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"select * from (select g.*, rownum rn from (select * from Cabin order by no desc) g) where rn between ? and ?");
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			ResultSet rs = stmt.executeQuery();
			List<Cabin> cabins = new ArrayList<Cabin>();
			while (rs.next()) {
				Cabin one = new Cabin(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
				cabins.add(one);
			}
			return cabins;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
