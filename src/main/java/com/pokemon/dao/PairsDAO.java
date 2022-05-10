package com.pokemon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pokemon.dto.PairsDTO;

public class PairsDAO {
	private static final PairsDAO instance = new PairsDAO();

	private PairsDAO() {
	}

	public static PairsDAO getInstance() {
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
	
	public ArrayList<PairsDTO> selectPairsDefault() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PairsDTO> pairArr = new ArrayList<>();
		PairsDTO dto = null;
		try {

			conn = getConnection();
			String sql = "SELECT\r\n"
					+ "  pair.owner, tr.type, pair.level, pok.name, pok.strength, tr.num_pokemon, pok.img, tr.image, pok.type1, pok.type2, pok.color1, pok.color2\r\n"
					+ "FROM\r\n"
					+ "    pokemon.pairs pair\r\n"
					+ "Left JOIN pokemon.151pokemon pok ON\r\n"
					+ "    pair.num = pok.idx\r\n"
					+ "Left JOIN `pokemon`.trainers tr ON\r\n"
					+ "    pair.`owner` = tr.`name`\r\n"
					+ "ORDER BY\r\n"
					+ "    tr.name\r\n"
					+ "";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new PairsDTO();
				dto.setOwner(rs.getString("owner"));
				dto.setType(rs.getString("type"));
				dto.setLevel(rs.getInt("level"));
				dto.setName(rs.getString("name"));
				dto.setStrength(rs.getInt("strength"));
				dto.setNum_pokemon(rs.getInt("num_pokemon"));
				dto.setImg(rs.getString("img"));
				dto.setImage(rs.getString("image"));
				dto.setType1(rs.getString("type1"));
				dto.setType2(rs.getString("type2"));
				dto.setColor1(rs.getString("color1"));
				dto.setColor2(rs.getString("color2"));
				
				pairArr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConnection(conn, pstmt, rs);
		return pairArr;
	}
	
	


	
}
