package cn.utils.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by 王炳智 on 2017/8/23.
 */
public class Dao {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;


    public void add(){
        //创建jdbcTemplate对象
        String sql = "insert into user values(?,?)";
        jdbcTemplate.update(sql,"lee","999999999");

    }
}
