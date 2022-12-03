package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BoardDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int insertBoard(BoardVO vo) {
        String sql = "insert into BOARD (title, writer, content, category) values("
                + "'" + vo.getTitle() + "'" + ","
                + "'" + vo.getWriter() + "'" +  ","
                + "'" + vo.getContent() + "'" + ","
                + "'" + vo.getCategory() +"'"+ ")";
        return jdbcTemplate.update(sql);
    }
    public int deleteBoard(int seq) {
        String sql = "delete from BOARD where seq = "+ seq;
        return jdbcTemplate.update(sql);
    }
    public int updateBoard(BoardVO vo) {
        String sql = "update BOARD set "
                + "title=" + vo.getTitle()  + ","
                + "writer=" + vo.getWriter() + ","
                + "content=" + vo.getContent() + ","
                + "category=" + vo.getCategory() + " where seq= " + vo.getSeq();
        return jdbcTemplate.update(sql);
    }

    public BoardVO getBoard(int seq) {
        String sql = "select * from BOARD where seq=" + seq;
        return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
    }
    public List<BoardVO> getBoardList(){
        String sql = "select * from BOARD order by regdate desc";
        return jdbcTemplate.query(sql, new BoardRowMapper());
    }
}

