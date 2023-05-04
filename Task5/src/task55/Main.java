package milosbogdanovic;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Konekcija...");
		CRUD crud = new CRUD();

		System.out.println("Brisanje: 1");
		System.out.println("Insert: 2");
		System.out.println("Update: 3");
		System.out.println("Select: 4");
		System.out.print("Unesite operaciju koju želite: ");
		int n = sc.nextInt();

		switch (n) {
		case 1: {
			crud.deleteBaza();
			break;
		}
		case 2: {
			crud.insertBaza();
			break;
		}
		case 3: {
			crud.updateBaza();
			break;
		}
		case 4: {
			crud.selectBaza();
			break;
		}

		}

	}

}
