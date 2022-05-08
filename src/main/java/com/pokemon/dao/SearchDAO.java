package com.pokemon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pokemon.dto.*;

public class SearchDAO {
	
	private static final SearchDAO instance = new SearchDAO();

	private SearchDAO() {
	}

	public static SearchDAO getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/pokemon?characterEncoding=UTF-8" + "&serverTimezone=UTC", "root", "tiger");
		return conn;
	}

	private void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {
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

	public ArrayList<PokemonDTO> searchPokemon(String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<PokemonDTO> pokRes = new ArrayList<PokemonDTO>(); 

		try {
			conn = getConnection();

			String sql = "SELECT * FROM pokemon.151pokemon WHERE `name` LIKE ?"
					+ "OR `type1` LIKE ? OR `type2` LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setString(2, "%" + search + "%");
			pstmt.setString(3, "%" + search + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {

				PokemonDTO temp = new PokemonDTO();
				temp.setIdx(rs.getInt("idx"));
				temp.setName(rs.getString("name"));
				temp.setStrength(rs.getInt("Strength"));
				temp.setType1(rs.getString("type1"));
				temp.setType2(rs.getString("type2"));
				temp.setImg(rs.getString("img"));
				temp.setColor1(rs.getString("color1"));
				temp.setColor2(rs.getString("color2"));
				pokRes.add(temp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pokRes;
	}
	
	public ArrayList<TrainersDTO> selectTrainers(String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<TrainersDTO> sb = new ArrayList<TrainersDTO>(); // 상품목록들

		try {
			conn = getConnection();

			String sql = "SELECT * FROM pokemon.151pokemon WHERE `name` LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {

				TrainersDTO temp = new TrainersDTO();
				/*
				 * temp.setType(rs.getString("type")); temp.setPnum(rs.getInt("pnum"));
				 * temp.setName(rs.getString("name"));
				 * 
				 * temp.setPrice(rs.getInt("price")); temp.setExplain(rs.getString("explain"));
				 * temp.setDetailexplain(rs.getString("detailexplain"));
				 * temp.setImg(rs.getString("img")); temp.setGender(rs.getString("gender"));
				 */
				sb.add(temp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	
	
}