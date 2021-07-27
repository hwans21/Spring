package com.spring.db.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.db.commons.ScoreMapper;
import com.spring.db.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {

	/*
	 * 전통적인 jsp jdbc처리
	 * 
	 * @Override public void insertScore(ScoreVO score) { // TODO Auto-generated
	 * method stub
	 * 
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * String sql = "INSERT INTO scores " + "VALUES (id_seq.NEXTVAL,?,?,?,?,?,?)";
	 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); conn =
	 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "spring",
	 * "spring"); pstmt = conn.prepareStatement(sql); pstmt.setString(1,
	 * score.getStuName()); pstmt.setInt(2, score.getKor()); pstmt.setInt(3,
	 * score.getEng()); pstmt.setInt(4, score.getMath()); pstmt.setInt(5,
	 * score.getTotal()); pstmt.setDouble(6, score.getAverage());
	 * pstmt.executeUpdate(); System.out.println("점수 등록 성공!"); } catch (Exception e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } finally { try {
	 * if(pstmt != null) pstmt.close(); if(conn != null) conn.close();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } }
	 */

	// # Spring-jdbc 방식의 처리: JdbcTemplate 사용!
	@Autowired
	private JdbcTemplate template;

	@Override
	public void insertScore(ScoreVO score) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO scores " + "VALUES(id_seq.NEXTVAL,?,?,?,?,?,?)";
		template.update(sql, score.getStuName(), score.getKor(), score.getEng(), score.getMath(), score.getTotal(),
				score.getAverage());
	}
	/*
	@Override
	public List<ScoreVO> selectAllScores() {
		// TODO Auto-generated method stub
		List<ScoreVO> scoreList = new ArrayList<ScoreVO>();

		String sql = "SELECT * FROM scores";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin::@localhost:1521:xe", "spring", "spring");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setStuId(rs.getInt("stu_id"));
				vo.setStuName(rs.getString("stu_name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMath(rs.getInt("math"));
				vo.setTotal(rs.getInt("total"));
				vo.setAverage(rs.getDouble("average"));

				scoreList.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return scoreList;
	}
	*/
	
	@Override
	public List<ScoreVO> selectAllScores() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM scores ORDER BY stu_id ASC";
		return template.query(sql,new ScoreMapper());
		
	}
	@Override
	public void deleteScore(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public ScoreVO selectOne(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
