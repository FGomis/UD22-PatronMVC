package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Modelo {

	public static Connection conexion;

	public static void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.51:3306?useTimeone=true&serverTimezone=UTC",
					"remote", "Password123+");
			System.out.print("Server Connected");

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.println(ex.getMessage());
		}

	}

	public static void closeConnection() {
		try {

			conexion.close();
			System.out.print("Server Disconnected");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.print("Error cerrando conexion");
		}
	}

//	**** MÉTODOS PARA EL CRUD ****

	public static void insertData(String db, String tabla, String nombre, String apellidos, String direccion,
			String dni) {
		openConnection();
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + tabla + " (nombre, apellidos, direccion, dni, fecha) VALUES ('" + nombre + "', '"
					+ apellidos + "', '" + direccion + "', " + dni + ", now()); ";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");
			;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
		closeConnection();
	}

	public static void selectData(String db, String tabla) {
		openConnection();
		String output = "";
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + tabla;
			Statement st = conexion.createStatement();
			ResultSet resultado = st.executeQuery(Query);

			while (resultado.next()) {
				output += "ID: " + resultado.getString("codigo") + "\n";
				output += "Nombre: " + resultado.getString("nombre") + "\n";
				output += "Apellidos: " + resultado.getString("apellidos") + "\n";
				output += "Dirección: " + resultado.getString("direccion") + "\n";
				output += "DNI: " + resultado.getString("dni") + "\n";
				output += "Fecha creación: " + resultado.getString("fecha") + "\n";
				output += "--------------------------\n";
			}
			JOptionPane.showMessageDialog(null, output);
			System.out.println("Lectura realizada correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la lectura");
		}
		closeConnection();
	}

	public static void updateData(String db, String tabla, String nombre, String apellidos, String direccion,
			String dni) {
		openConnection();
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "UPDATE" + tabla + " SET nombre = " + nombre + ", apellidos = " + apellidos
					+ ", direccion = " + direccion + "" + ", dni = " + dni + " WHERE dni = "
					+ dni;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Actualización realizada correctamente");
			;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la actualización");
		}
		closeConnection();
	}

	public static void deleteData(String db, String tabla) {
		openConnection();
		try {
			String dni = JOptionPane.showInputDialog("Indica el dni del cliente a eliminar");
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "DELETE FROM " + tabla + " WHERE dni = " + dni;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos eliminados correctamente");
			;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el borrado");
		}
		closeConnection();
	}
}
