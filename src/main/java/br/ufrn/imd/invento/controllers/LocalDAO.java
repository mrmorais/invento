package br.ufrn.imd.invento.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LocalDAO {
	private Connection conn;
	
	public LocalDAO() throws SQLException {
		conn = DatabaseConnector.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void criarLocal() throws SQLException {
		List<Object> data = new ArrayList<Object>();
		data.add("Arena das Dunas2");
		data.add("Natal");
		data.add("Rua s/n");
		data.add("Estádio");
		
		DatabaseConnector.runProcedure("criar_local", data);	
	}
	
	@SuppressWarnings("deprecation")
	public void criarEvento() throws SQLException {
		
		List<Object> data = new ArrayList<Object>();
		data.add(Integer.parseInt("4"));
		data.add("Show de Roberto Carlos");
		data.add("Grande show no final do ano");
		data.add("facebook.com");
		data.add(new Date(2018, 12, 31));
		data.add(new Time(20, 20, 0));
		
		DatabaseConnector.runProcedure("criar_evento", data);
	}
}
