package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Entrada;

public class PruebaMySQLPreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn=conectarMySQL("localhost","test","root","");
		System.out.println("Conectado a MySQL.");
		
		Statement st=cn.createStatement();
		
		System.out.print("Id? ");
		int id=Entrada.entero();
		System.out.print("Nombre? ");
		
		String nombre=Entrada.cadena();
		System.out.print("Nota? ");
		int nota=Entrada.entero();
		
		
		//Comprobamos si ya existe el id en la tabla 
		String sql="select * from notas where id=?";
		PreparedStatement pst=cn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();//Devuelve una o ninguna fila
		if (rs.next()) {
			//Ya existe por tanto hacemos UPDATE
			sql="update notas set nombre=?,nota=? where id=?";
			pst=cn.prepareStatement(sql);
			pst.setString(1, nombre);
			pst.setInt(2, nota);
			pst.setInt(3, id);
			System.out.println("Fila actualizada");
		}
		else {
			//No existe por tanto hacemos INSERT
			sql="insert into notas values (?,?,?)";
			pst=cn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, nombre);
			pst.setInt(3, nota);
			System.out.println("Fila insertada");
		}
		System.out.println(sql);
		pst.executeUpdate();
		
		
		
		//Mostrar la tabla por consola
		sql="select * from notas";
		rs=st.executeQuery(sql);
		while (rs.next()) {
			//Datos de cada fila del ResultSet
			System.out.printf("%10d %-30s %d\n",rs.getInt("id"),rs.getString("nombre"),rs.getInt("nota"));
		}
	}
	
	

	private static Connection conectarMySQL(String ip, String bd, String usu, String pass) throws SQLException {
		Connection cn = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+bd,usu,pass);
		
		return cn ;
	}

}
