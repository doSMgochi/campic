package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.User;
import model.vo.UserSession;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class UserSessionDao {
//조인 활용
	public boolean save(UserSession userSession) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO User_Session VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, userSession.getUserId());
			stmt.setInt(2, userSession.getReservation());
			stmt.setInt(3, userSession.getFavorite());
			stmt.setString(4, userSession.getCampsiteCoupon());
			stmt.setString(5, userSession.getStoreCoupon());
			stmt.setInt(6, userSession.getStorePoint());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public int findReservationByUserId(String userId) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			// 식별키로 조회하고,
			PreparedStatement stmt = conn.prepareStatement("SELECT reservation FROM User_Session WHERE user_id=?");
			stmt.setString(1, userId);

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
}
