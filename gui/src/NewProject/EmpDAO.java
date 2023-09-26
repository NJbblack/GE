package NewProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDAO {

	public static EmpDAO instance = new EmpDAO();
	public static EmpDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement ps = null;

	public EmpDAO() {

		try {
			String user = "CCC";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			
//	        String user = "postgres";
//	        String pw = "postgres";
//	        String url = "jdbc:postgresql://localhost:5432/postgres";
//	        Class.forName("org.postgresql.Driver");
			
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println(conn);

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB Load Failed :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB Connection Failed : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
	}

	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}
	
	
	
	public ArrayList<EmpData> readData() {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {
			st = conn.createStatement();
			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 1";
			
			rs = ((java.sql.Statement) st).executeQuery(sql);

			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	public ArrayList<EmpData> readClosedData() {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {
			st = conn.createStatement();
			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 0";
			
			rs = ((java.sql.Statement) st).executeQuery(sql);

			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	public ArrayList<EmpData> readAllData() {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {
			st = conn.createStatement();
			String sql = "SELECT * FROM EMP";
			
			rs = ((java.sql.Statement) st).executeQuery(sql);

			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	
	public ArrayList<EmpData> searchName(String typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 1 AND NAME LIKE '%' || ? || '%'";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	

	
	
	public ArrayList<EmpData> searchEmpNo(int typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 1 AND EMPNO = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	

	public ArrayList<EmpData> searchNameClosed(String typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 0 AND NAME LIKE '%' || ? || '%'";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	

	
	
	public ArrayList<EmpData> searchEmpNoClosed(int typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 0 AND EMPNO = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	

	public ArrayList<EmpData> searchAllName(String typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE NAME LIKE '%' || ? || '%'";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	

	
	
	public ArrayList<EmpData> searchAllEmpNo(int typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	
	

	
	public ArrayList<EmpData> searchAllJoin(String typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE ESTYEARMONTH LIKE ? || '%'";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	

	public ArrayList<EmpData> searchJoin(String typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 1 AND ESTYEARMONTH LIKE ? || '%'";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	

	
	
	
	
	public ArrayList<EmpData> searchClosedJoin(String typedText) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 0 AND ESTYEARMONTH LIKE ? || '%'";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,typedText);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	

	
	public ArrayList<EmpData> readSelectedData(int empNo) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1,empNo);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	
	public ArrayList<EmpData> readFilteredData(String name) {
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		try {

			String sql = "SELECT * FROM EMP WHERE AVAILABLE = 1 AND NAME = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpData(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getString(16)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	public ArrayList<EmpCurrent> readSelectedCurrent(int empNo) {
		ArrayList<EmpCurrent> arr = new ArrayList<EmpCurrent>();
		try {

			String sql = "SELECT * FROM EMPCURRENT WHERE EMPNO = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1,empNo);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr.add(new EmpCurrent(
						rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),
						rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),
						rs.getInt(13),rs.getInt(14),rs.getInt(15),rs.getInt(16),rs.getInt(17),rs.getInt(18),
						rs.getInt(19),rs.getInt(20),rs.getInt(21),rs.getInt(22),
						rs.getString(23),rs.getString(24),rs.getString(25),rs.getString(26),rs.getString(27),
						rs.getString(28),rs.getString(29),rs.getString(30),rs.getString(31),rs.getString(32)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	
	
	public void insertData(String name, String nation, String birth, String gender) {
		try {
			String sql = "INSERT INTO EMP(EMPNO, NAME, NATION, BIRTH, GENDER, AVAILABLE) values(EMP_SEQ.NEXTVAL, ?, ?, ?, ?, 1)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, nation);
			ps.setString(3, birth);
			ps.setString(4, gender);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	
	//修正箇所
	public void insertCurrentData() {
		try {
			String sql = "INSERT INTO EMPCURRENT values((SELECT MAX(EMPNO) FROM EMP),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'','','','','','','','','','')";
			
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	
	
	public void updateData(EmpData empData) {
		try {
			System.out.println(empData);
			String sql = "UPDATE EMP SET "
					+ "EMPCD = ?, NAME = ?, NATION = ?, BIRTH = ?, GENDER = ?, SCHOOL = ?, SALARY = ?, EMPTYPE = ?, EMPLOC = ?, NOTE = ?, EMAIL = ?, ADDRESS = ?, TEL = ?, AVAILABLE = ?, ESTYEARMONTH = ? "
					+ "WHERE EMPNO = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1,empData.getEmpCd());
			ps.setString(2,empData.getName());
			ps.setString(3,empData.getNation());
			ps.setString(4,empData.getBirth());
			ps.setString(5,empData.getGender());
			ps.setString(6,empData.getSchool());
			ps.setInt(7,empData.getSalary());
			ps.setString(8,empData.getEmpType());
			ps.setString(9,empData.getEmpLoc());
			ps.setString(10,empData.getNote());
			ps.setString(11,empData.getEmail());
			ps.setString(12,empData.getAddress());
			ps.setString(13,empData.getTel());
			ps.setInt(14,empData.getAvailable());
			ps.setString(15,empData.getEstYearMonth());
			ps.setInt(16,empData.getEmpNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	
	
	public void updateCurrent(EmpCurrent empCurrent) {
		try {
			String sql = "UPDATE EMPCURRENT SET "
					+ "COEFORMREQUEST = ?,COEFORMRECEIVE = ?,COEREFRECEIVE = ?,COEORIGINRECEIVE = ?,COEAPPLICATION = ?,COERECEIVE = ?,VISAREQUEST = ?,VISAAPPLICATION = ?,VISARECEIVE = ?,IDPHOTO = ?,SHEETGUIDE = ?,SHEETCORRECT = ?,SHEETCORRECTREQUEST = ?,SHEETCORRECTM = ?,SHEETURGE = ?,SHEETFINISH = ?,SHEETNOTREQUIRE = ?,EMSGUIDE = ?,EMSSEND = ?,FLIGHTGUIDE = ?,FLIGHTARRANGE = ?,"
					+ "CALENDERCOEFORMREQUEST = ?, CALENDERCOEFORMRECEIVE = ?, NOTE13 = ?, CALENDERCOEORIGINRECEIVE =?,"
					+ "CALENDERCOEAPPLICATION = ?, CALENDERCOERECEIVE = ?, CALENDERVISAAPPLICATION = ?, CALENDERVISARECEIVE = ?, NOTE28 = ?, CALENDER = ? "
					+ "WHERE EMPNO = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,empCurrent.getCoeFormRequest());
			ps.setInt(2,empCurrent.getCoeFormReceive());
			ps.setInt(3,empCurrent.getCoeRefReceive());
			ps.setInt(4,empCurrent.getCoeOriginReceive());
			ps.setInt(5,empCurrent.getCoeApplication());
			ps.setInt(6,empCurrent.getCoeReceive());
			ps.setInt(7,empCurrent.getVisaRequest());
			ps.setInt(8,empCurrent.getVisaApplication());
			ps.setInt(9,empCurrent.getVisaReceive());
			ps.setInt(10,empCurrent.getIdPhoto());
			ps.setInt(11,empCurrent.getSheetGuide());
			ps.setInt(12,empCurrent.getSheetCorrect());
			ps.setInt(13,empCurrent.getSheetCorrectRequest());
			ps.setInt(14,empCurrent.getSheetCorrectM());
			ps.setInt(15,empCurrent.getSheetUrge());
			ps.setInt(16,empCurrent.getSheetFinish());
			ps.setInt(17,empCurrent.getSheetNotRequire());
			ps.setInt(18,empCurrent.getEmsGuide());
			ps.setInt(19,empCurrent.getEmsSend());
			ps.setInt(20,empCurrent.getFlightGuide());
			ps.setInt(21,empCurrent.getFlightArrange());
			ps.setString(22,empCurrent.getCalendercoeFormRequest());
			ps.setString(23,empCurrent.getCalendercoeFormReceive());
			ps.setString(24,empCurrent.getNote13());
			ps.setString(25,empCurrent.getCalendercoeOriginReceive());
			ps.setString(26,empCurrent.getCalendercoeApplication());
			ps.setString(27,empCurrent.getCalendercoeReceive());
			ps.setString(28,empCurrent.getCalendervisaApplication());
			ps.setString(29,empCurrent.getCalendervisaReceive());
			ps.setString(30,empCurrent.getNote28());
			ps.setString(31,empCurrent.getCalender());
			ps.setInt(32,empCurrent.getEmpNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
}


