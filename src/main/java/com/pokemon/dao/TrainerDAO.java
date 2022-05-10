package com.pokemon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pokemon.dto.TrainerDTO;

public class TrainerDAO {
	private static final TrainerDAO instance = new TrainerDAO();

	private TrainerDAO() {
	}

	public static TrainerDAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/pokemon?charactherEncoding=UTF-8&serverTimezone=UTC", "root", "tiger");
		return conn;
	}

	private void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	
	public ArrayList<TrainerDTO> selectTrainerDefault() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TrainerDTO> trainerArr = new ArrayList<>();
		TrainerDTO dto = null;
		try {

			conn = getConnection();
			String sql = "SELECT * FROM pokemon.trainers";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new TrainerDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setNum_pokemon(rs.getInt("num_pokemon"));
				dto.setType(rs.getString("type"));
				
				trainerArr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConnection(conn, pstmt, rs);
		return trainerArr;
	}
	
	


	
}
