package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			stmt.setString(6, userSession.getStoreCoupon());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
