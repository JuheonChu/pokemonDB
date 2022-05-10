package com.pokemon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pokemon.dto.PokemonDTO;

public class PokemonDAO {
	private static final PokemonDAO instance = new PokemonDAO();

	private PokemonDAO() {
	}

	public static PokemonDAO getInstance() {
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
	
	public ArrayList<PokemonDTO> selectPokemonDefault() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PokemonDTO> pokArr = new ArrayList<PokemonDTO>();
		PokemonDTO dto = null;
		try {

			conn = getConnection();
			String sql = "SELECT * FROM pokemon.151pokemon pok ORDER by pok.name ASC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new PokemonDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setType1(rs.getString("type1"));
				dto.setType2(rs.getString("type2"));
				dto.setStrength(rs.getInt("strength"));
				dto.setImg(rs.getString("img"));
				dto.setColor1(rs.getString("color1"));
				dto.setColor2(rs.getString("color2"));
				pokArr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConnection(conn, pstmt, rs);
		return pokArr;
	}
	
	
	public ArrayList<PokemonDTO> selectPokemonByStrongest() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PokemonDTO> pokArr = new ArrayList<PokemonDTO>();
		PokemonDTO dto = null;
		try {

			conn = getConnection();
			String sql = "SELECT * FROM pokemon.151pokemon pok ORDER by pok.strength DESC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new PokemonDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setType1(rs.getString("type1"));
				dto.setType2(rs.getString("type2"));
				dto.setStrength(rs.getInt("strength"));
				dto.setImg(rs.getString("img"));
				dto.setColor1(rs.getString("color1"));
				dto.setColor2(rs.getString("color2"));
				pokArr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConnection(conn, pstmt, rs);
		return pokArr;
	}
	
	
	public ArrayList<PokemonDTO> selectPokemonByWeakest() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PokemonDTO> pokArr = new ArrayList<PokemonDTO>();
		PokemonDTO dto = null;
		try {

			conn = getConnection();
			String sql = "SELECT * FROM pokemon.151pokemon pok ORDER by pok.strength ASC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new PokemonDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setType1(rs.getString("type1"));
				dto.setType2(rs.getString("type2"));
				dto.setStrength(rs.getInt("strength"));
				dto.setImg(rs.getString("img"));
				dto.setColor1(rs.getString("color1"));
				dto.setColor2(rs.getString("color2"));
				pokArr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConnection(conn, pstmt, rs);
		return pokArr;
	}

	
}
