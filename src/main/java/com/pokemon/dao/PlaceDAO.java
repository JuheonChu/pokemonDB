package com.pokemon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pokemon.dto.PlaceDTO;

public class PlaceDAO {
	private static final PlaceDAO instance = new PlaceDAO();

	private PlaceDAO() {
	}

	public static PlaceDAO getInstance() {
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
	
	public ArrayList<PlaceDTO> selectPlaecesDefault() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceDTO> placeArr = new ArrayList<PlaceDTO>();
		PlaceDTO dto = null;
		try {

			conn = getConnection();
			
			
			String sql = "SELECT * FROM pokemon.places";
			
			
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new PlaceDTO();
				dto.setId(rs.getString("id"));
				dto.setDescription(rs.getString("description"));
				dto.setImg(rs.getString("img"));
				dto.setName(rs.getString("name"));
				placeArr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConnection(conn, pstmt, rs);
		return placeArr;
	}
	
	
	
	
	
	
	
}
