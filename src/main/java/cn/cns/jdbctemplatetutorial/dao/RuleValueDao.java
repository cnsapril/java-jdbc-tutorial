package cn.cns.jdbctemplatetutorial.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class RuleValueDao {

    private static final String QUERY_LE_OU_PAIR = "select count(*) from RULE_VALUE where id_le = ? and id_ou = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RuleValueDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean isLEOUInvalid(String le, String ou) {
        Integer rowCount = jdbcTemplate.queryForObject(QUERY_LE_OU_PAIR, Integer.class, le, ou);
        return rowCount == 0;
    }
}
