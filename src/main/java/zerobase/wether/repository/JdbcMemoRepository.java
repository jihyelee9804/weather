package zerobase.wether.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zerobase.wether.domain.Memo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

// JdbcMemoRepository 클래스는 jdbc template 객체를 이용해서 데이터를 조작하는 기능을 하는 클래스다.
// 데이터베이스와 직접적으로 연결된다.
@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired // @Autowired를 통해 어플리케이션이 dataSource를  인식한다.
    public JdbcMemoRepository(DataSource dataSource) {
        // dataSource를 jdbcTemplate에 담는다.
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    // 데이터 저장하는 메소드
    public Memo save(Memo memo) {
        String sql = "insert into memo values(?,?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }
    // 테이블 내 데이터 전체 조회
    public List<Memo> findAll() {
        String sql = "select * from memo";
        return jdbcTemplate.query(sql, memoRowMapper());
    }
    // id를 통해 조회
    public Optional<Memo> findById(int id) {
        String sql = "select * from memo where id = ?";
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
    }
    // ResultSet 타입의 데이터를 Memo 객체로 변환하는 메소드
    private RowMapper<Memo> memoRowMapper(){
        // ResultSet 형식으로 데이터베이스에서 데이터를 가져온다. {id = 1, text = 'this is memo'}
        // RowMapper 메소드는 resultSet을 Memo 객체로 변환하는 기능을 한다.
        return (rs, rowNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );
    }
}
