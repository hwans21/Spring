package com.spring.db.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
	class BoardMapper implements RowMapper<BoardVO> {

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO vo = new BoardVO();
			vo.setBoardNo(rs.getInt("board_id"));
			vo.setWriter(rs.getString("board_writer"));
			vo.setTitle(rs.getString("board_title"));
			vo.setContent(rs.getString("board_content"));
			return vo;
		}
		
	}
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO board VALUES(board_id_seq.NEXTVAL,?,?,?)";
		template.update(sql,vo.getWriter(),vo.getTitle(),vo.getContent());
	}

	@Override
	public List<BoardVO> getArticle() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM board ORDER BY board_id ASC";
		
		return template.query(sql, new BoardMapper());
	}

	@Override
	public BoardVO getArticle(int bId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM board WHERE board_id=?";
		return template.queryForObject(sql, new BoardMapper(), bId);
			
		
	}

	@Override
	public void deleteArticle(int bId) {
		String sql = "DELETE FROM board WHERE board_id=?";
		template.update(sql, bId);
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void updateArticle(BoardVO vo) {
		String sql = "UPDATE board SET board_writer=?, board_title=?, board_content=? WHERE board_id=?";
		template.update(sql, vo.getWriter(), vo.getTitle(), vo.getContent(), vo.getBoardNo());
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> searchArticle(String keyword) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM board WHERE board_writer LIKE ?";
		return template.query(sql,new BoardMapper(), keyword);
	}

	

}
