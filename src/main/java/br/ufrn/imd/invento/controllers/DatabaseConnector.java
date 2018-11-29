package br.ufrn.imd.invento.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.sound.midi.Soundbank;

public class DatabaseConnector {
	private static String url = "jdbc:postgresql://localhost/invento";
	private static String username = "postgres";
	private static String password = "admin";
	
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = connect();
		}
		return conn;
	}
	
	private static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public static int runProcedure(String procedureName, List<Object> params) throws SQLException {
		getConnection();
		
		StringBuilder sBuilder = new StringBuilder("select ");
		sBuilder.append(procedureName);
		sBuilder.append(" (");
		
		if (params.size() > 1) {
			for (int i = 0; i < params.size() - 1; i++) {
				sBuilder.append("?, ");
			}
			sBuilder.append("?");
		} else if (params.size() == 1) {
			sBuilder.append("?");
		}
		
		sBuilder.append(")");
		
		PreparedStatement pst = conn.prepareStatement(sBuilder.toString());
		
		for (int i = 0; i < params.size(); i++) {
			pst.setObject(i + 1, params.get(i));
		}
		pst.execute();
		conn.commit();
		pst.close();
		
		return 0;
	}
}
