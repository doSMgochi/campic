package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.User;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class UserDao {
	public boolean save(User user) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERS VALUES(?, ?, ?, ? , ?, ? , ?)");
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getNickname());
			stmt.setString(4, user.getGender());
			stmt.setDate(5, user.getBirth());
			stmt.setString(6, user.getEmail());
			stmt.setString(7, user.getAuthority());
			
			int r =  stmt.executeUpdate();
			return r == 1 ? true : false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	
	public User findById(String id) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		
		try (Connection conn = ods.getConnection()){
			
			//식별키로 조회하고,
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE ID=?");
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new User(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5), rs.getString(6), rs.getString(7));
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean updateNicknameAndPassword(User oldUser) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("UPDATE USERS SET NICKNAME=?, PASSWORD=? WHERE ID=?");
			stmt.setString(1, oldUser.getNickname());
			stmt.setString(2, oldUser.getPassword());
			stmt.setString(3, oldUser.getId());
			
			
			int r =  stmt.executeUpdate();
			return r == 1 ? true : false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean updateNickname(User oldUser) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("UPDATE USERS SET NICKNAME=? WHERE ID=?");
			stmt.setString(1, oldUser.getNickname());
			stmt.setString(2, oldUser.getId());
			
			
			int r =  stmt.executeUpdate();
			return r == 1 ? true : false;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
	}
	
	public boolean deleteById(String id) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM USERS WHERE ID=?");
			stmt.setString(1, id);
			
			
			int r =  stmt.executeUpdate();
			return r == 1 ? true : false;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	
}
