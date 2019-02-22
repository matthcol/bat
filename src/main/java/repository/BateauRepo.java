package repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.mariadb.jdbc.MySQLDataSource;

import com.mysql.cj.jdbc.MysqlDataSource;




public class BateauRepo {
	
	
	private static final String url =
			"jdbc:mysql://localhost:3306/bateau?serverTimezone=Europe/Paris";
	private static final String user = "bat";
	private static final String password = "password";
	
	
	private static DataSource initDataSource() {
		//MySQLDataSource ds = new MySQLDataSource();
		MysqlDataSource ds = new MysqlDataSource();
		try (
			InputStream is = BateauRepo.class.getResourceAsStream("/config.properties");
		) {

			//now can use this input stream as usually, i.e. to load as properties
			Properties props = new Properties();
			props.load(is);
			ds.setUrl(props.getProperty("database.url"));
			ds.setUser(props.getProperty("database.user"));
			ds.setPassword(props.getProperty("database.password"));
//			ds.setUrl(url);
//			ds.setUser(user);
//			ds.setPassword(password);
		} catch (IOException e) {
			//throw new 
			System.err.println("Error reading configuration file: " + e.getMessage());
		}
		return ds;
	}
	
	public static List<String> findAll() {
		DataSource ds = initDataSource();
		List<String> bateaux = new ArrayList<String>();
		try (
			Connection conn = ds.getConnection();
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("select * from bateau")
		) {
	
			while (res.next()) {
				bateaux.add(res.getString("nom"));
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur lecture MySQL : " + e.getMessage());
			bateaux.add(e.toString());
			bateaux.add(e.getMessage());
			bateaux.add(Optional.ofNullable(ds).toString());
		}
		return bateaux;
	}

}
