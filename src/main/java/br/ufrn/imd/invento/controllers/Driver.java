package br.ufrn.imd.invento.controllers;

import java.sql.SQLException;

public class Driver {
	public static void main(String[] args) {
		try {
			LocalDAO local = new LocalDAO();
			local.criarEvento();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
