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
	
	public ArrayList<TrainerDTO> selectTrainers(String search) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<TrainerDTO> sb = new ArrayList<>(); 
		try {
			conn = getConnection();

			String sql = "SELECT * FROM pokemon.trainers WHERE `name` LIKE ? OR `type` LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setString(2, "%" + search + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {

				TrainerDTO temp = new TrainerDTO();
				temp.setId(rs.getInt("id"));
				temp.setName(rs.getString("name"));
				temp.setNum_pokemon(rs.getInt("num_pokemon"));
				temp.setType(rs.getString("type"));
				temp.setImage(rs.getString("image"));
				sb.add(temp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConnection(conn, pstmt, rs);
		return sb;
	}
	
	
	public ArrayList<PlaceDTO> searchPlaces(String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<PlaceDTO> placesRes = new ArrayList<>(); 

		try {
			conn = getConnection();

			String sql = "SELECT * FROM pokemon.places WHERE `name` LIKE ?"
					+ "OR `description` LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setString(2, "%" + search + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				PlaceDTO dto = new PlaceDTO();
				dto.setDescription(rs.getString("description"));
				dto.setId(rs.getString("id"));
				dto.setImg(rs.getString("img"));
				dto.setName(rs.getString("name"));
				placesRes.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return placesRes;
	}
	
	
}