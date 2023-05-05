package task55;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

	private String url = "jdbc:mysql://localhost:3306/biblioteke_task5";
	private String username = "root";
	private String pass = "";

	public void insertBaza() throws SQLException {

		try (Connection conn = DriverManager.getConnection(url, username, pass)) {

			System.out.println("Konekcija sa bazom uspešna!");

			String sqlInsert = "INSERT INTO decijeod(decijeID, uzrast)VALUES(?,?)";

			PreparedStatement ps = conn.prepareStatement(sqlInsert);

			ps.setInt(1, 7);
			ps.setInt(2, 16);

			int unetiPodatak = ps.executeUpdate();

			if (unetiPodatak > 0) {
				System.out.println("Podatak je uspesno unet!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectBaza() throws SQLException {

		try (Connection conn = DriverManager.getConnection(url, username, pass)) {

			System.out.println("Konekcija sa bazom uspešna!");

			String sqlSelect = "Select * from decijeod";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sqlSelect);

			while (rs.next()) {

				String id = rs.getString(1);
				String u = rs.getString(2);

				StringBuilder sb = new StringBuilder();

				sb.append("\nID: ");
				sb.append(id);
				sb.append("\nUzrast: ");
				sb.append(u);

				System.out.print("\n----------" + sb.toString());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateBaza() throws SQLException {

		try (Connection conn = DriverManager.getConnection(url, username, pass)) {

			System.out.println("Konekcija sa bazom uspešna!");

			String sqlUpdate = "UPDATE decijeod SET uzrast = ? where decijeID =?";

			PreparedStatement ps = conn.prepareStatement(sqlUpdate);

			ps.setInt(1, 11);

			ps.setInt(2, 1);

			int apdejtPodatka = ps.executeUpdate();

			if (apdejtPodatka > 0) {
				System.out.println("Uspesno obavljena izmena!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteBaza() throws SQLException {

		try (Connection conn = DriverManager.getConnection(url, username, pass)) {

			System.out.println("Konekcija sa bazom uspešna!");

			String sqlDelete = "DELETE from decijeod WHERE decijeID = ?";

			PreparedStatement ps = conn.prepareStatement(sqlDelete);

			ps.setInt(1, 7);

			int deletePodatka = ps.executeUpdate();

			if (deletePodatka > 0) {
				System.out.println("Brisanje uspesno!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
