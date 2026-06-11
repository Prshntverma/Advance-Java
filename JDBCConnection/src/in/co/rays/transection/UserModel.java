package in.co.rays.transection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserModel {

	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");

	public int nextPK() throws ClassNotFoundException, SQLException {

		int pk = 0;
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement("select max(id)from st_user");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}
	// ADD Method
		public void add(UserBean bean) throws SQLException {
			Connection conn = null;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, password);

				conn.setAutoCommit(false);
				PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(? ,? ,? ,? ,? ,?)");
				pstmt.setInt(1, nextPK());
				pstmt.setString(2, bean.getFirstname());
				pstmt.setString(3, bean.getLastname());
				pstmt.setString(4, bean.getLogin());
				pstmt.setString(5, bean.getPassword());
				pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
				int i = pstmt.executeUpdate();

				System.out.println(i + "row affected(records inserted...)");
				conn.commit();
				conn.close();

			} catch (Exception e) {
				conn.rollback();

			}

		}
	
	
}
