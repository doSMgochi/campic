package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Campsite;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class CampsiteDao {
	public int countAll() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM CAMPSITE");
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

	public int countVacance() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"SELECT count(*) FROM CAMPSITE WHERE POSBL LIKE '%물놀이%' OR POSBL LIKE '%해수욕%' OR POSBL LIKE '%수상레저%' OR POSBL LIKE '%수영장%' ORDER BY ID");
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

	public int countKidsZone() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("SELECT count(*) FROM CAMPSITE WHERE POSBL LIKE '%어린이%' ORDER BY ID");
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

	public int countPension() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"SELECT count(*) FROM CAMPSITE WHERE name LIKE '%펜션%' or line_intro like '%펜션%' or intro like '%펜션%' or sbrs_etc like '%펜션%' or induty like '%일반야영장%' ORDER BY ID");
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

	public Campsite findById(int id) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Campsite WHERE ID=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Campsite one = new Campsite();

				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				one.setAddress(rs.getString("address"));
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));

				return one;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Campsite> findByInduty(String induty) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Campsite WHERE induty=?");
			stmt.setString(1, induty);

			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();

				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				one.setAddress(rs.getString("address"));
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				campsites.add(one);
			}

			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Campsite> findByEnvironment(String environment) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Campsite WHERE environment=?");
			stmt.setString(1, environment);

			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();

				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				one.setAddress(rs.getString("address"));
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				campsites.add(one);
			}

			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Campsite> findByAnimalPossible() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Campsite WHERE animal = '가능' or animal = '가능(소형견)'");
			
			
			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();
				
				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				one.setAddress(rs.getString("address"));
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				campsites.add(one);
			}
			
			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Campsite> findAll(int start, int end) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"select * from (select g.*, rownum rn from (select * from Campsite order by id) g) where rn between ? and ?");
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();

				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				one.setAddress(rs.getString("address"));
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				campsites.add(one);
			}

			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Campsite> findVacance(int start, int end) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"select * from (select g.*, rownum rn from (select * from campsite where POSBL LIKE '%물놀이%' OR POSBL LIKE '%해수욕%' OR POSBL LIKE '%수상레저%' OR POSBL LIKE '%수영장%' order by id desc) g) where rn between ? and ?");
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();

				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				one.setAddress(rs.getString("address"));
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				campsites.add(one);
			}

			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Campsite> findKidsZone(int start, int end) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"select * from (select g.*, rownum rn from (select * from campsite where POSBL LIKE '%어린이%' order by id desc) g) where rn between ? and ?");
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();

				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				one.setAddress(rs.getString("address"));
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				campsites.add(one);
			}

			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Campsite> findPension(int start, int end) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"select * from (select g.*, rownum rn from (select * from campsite where name like '%펜션%' or line_intro like '%펜션%' or intro like '%펜션%' or sbrs_etc LIKE '%펜션%' or induty like '%일반야영장%' order by id desc) g) where rn between ? and ?");
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();

				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				one.setAddress(rs.getString("address"));
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				campsites.add(one);
			}

			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<String> findDistinctInduty() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT induty FROM Campsite ");

			ResultSet rs = stmt.executeQuery();
			List<String> industry = new ArrayList<>();
			while (rs.next()) {
				String induty = rs.getString("induty");
				industry.add(induty);
			}

			return industry;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<String> findDistinctEnvironment() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT Environment FROM Campsite");

			ResultSet rs = stmt.executeQuery();
			List<String> environments = new ArrayList<>();
			while (rs.next()) {
				String environment = rs.getString("Environment");
				environments.add(environment);
			}

			return environments;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Campsite> searchByCampsite(String search) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM Campsite WHERE name LIKE ? ORDER BY ID DESC");
			stmt.setString(1, "%" + search + "%");
			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();

				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				// Extract the first and second word from the address
	            String address = rs.getString("address");
	            String[] addressParts = address.split(" ");
	            String combinedAddress = addressParts.length >= 2 ? 
	                addressParts[0] + " " + addressParts[1] : 
	                addressParts[0];
	            one.setAddress(combinedAddress);
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));

				campsites.add(one);
			}

			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public List<Campsite> searchByCampsite(String search, Date date) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM Campsite WHERE name LIKE ? ORDER BY ID DESC");
			stmt.setString(1, "%" + search + "%");
			stmt.setString(2, "%" + search + "%");
			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();
				
				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				// Extract the first and second word from the address
				String address = rs.getString("address");
				String[] addressParts = address.split(" ");
				String combinedAddress = addressParts.length >= 2 ? 
						addressParts[0] + " " + addressParts[1] : 
							addressParts[0];
				one.setAddress(combinedAddress);
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				
				campsites.add(one);
			}
			
			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public List<Campsite> searchByCampsite(String search, Date date, String region) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.124.229.167:1521/xe");
		ods.setUser("campic");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM Campsite WHERE name like ? or address like ? ORDER BY ID DESC");
			stmt.setString(1, "%" + search + "%");
			stmt.setString(2, "%" + search + "%");
			stmt.setString(3, "%" + region + "%");
			ResultSet rs = stmt.executeQuery();
			List<Campsite> campsites = new ArrayList<Campsite>();
			while (rs.next()) {
				Campsite one = new Campsite();
				
				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setBusinessNumber(rs.getString("business_number"));
				one.setLineIntro(rs.getString("line_intro"));
				one.setIntro(rs.getString("intro"));
				one.setFeature(rs.getString("feature"));
				one.setInduty(rs.getString("induty"));
				one.setEnvironment(rs.getString("environment"));
				one.setZipCode(rs.getString("zip_code"));
				// Extract the first and second word from the address
				String address = rs.getString("address");
				String[] addressParts = address.split(" ");
				String combinedAddress = addressParts.length >= 2 ? 
						addressParts[0] + " " + addressParts[1] : 
							addressParts[0];
				one.setAddress(combinedAddress);
				one.setDirection(rs.getString("direction"));
				one.setTel(rs.getString("tel"));
				one.setHomepage(rs.getString("homepage"));
				one.setResveUrl(rs.getString("resveurl"));
				one.setResveCl(rs.getString("resvecl"));
				one.setGnrlSite(rs.getInt("gnrl_site"));
				one.setAutoSite(rs.getInt("auto_site"));
				one.setGlampSite(rs.getInt("glamp_site"));
				one.setCaravSite(rs.getInt("carav_site"));
				one.setIndvdlCaravSite(rs.getInt("indvdl_carav_site"));
				one.setTooltip(rs.getString("tooltip"));
				one.setGlampInner(rs.getString("glamp_inner"));
				one.setCaravInner(rs.getString("carav_inner"));
				one.setOperPd(rs.getString("oper_pd"));
				one.setOperDe(rs.getString("oper_de"));
				one.setToilet(rs.getInt("toilet"));
				one.setSwrm(rs.getInt("swrm"));
				one.setWtrpl(rs.getInt("wtrpl"));
				one.setSbrs(rs.getString("sbrs"));
				one.setSbrsEtc(rs.getString("sbrs_etc"));
				one.setPosbl(rs.getString("posbl"));
				one.setPosblEtc(rs.getString("posbl_etc"));
				one.setImageUrl(rs.getString("image_url"));
				one.setAnimal(rs.getString("animal"));
				one.setCreatedTime(rs.getDate("created_time"));
				one.setModifiedTime(rs.getDate("modified_time"));
				
				campsites.add(one);
			}
			
			return campsites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
