package com.wbz;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 王炳智 on 2017/8/23.
 */
public class jdbcTemplate {
    public static void main(String[] args) {
        countList();
    }
    //查询返回对象list
    public static void countList(){





        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //设置数据库地址
        dataSource.setUrl("jdbc:mysql:///student");
        dataSource.setUsername("root");
        dataSource.setPassword("h.1111032");


        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from user";
        //第二个参数接口是RowMapper,需要自己写类实现借口，自己做数据的封装
        List<User> list =  jdbcTemplate.query(sql,new MyRowMapper());
        System.out.println(list);
    }
    //查询操作，返回对象
    public static void countObject(){
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //设置数据库地址
        dataSource.setUrl("jdbc:mysql:///student");
        dataSource.setUsername("root");
        dataSource.setPassword("h.1111032");


        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from user where username=?";
        //第二个参数接口是RowMapper,需要自己写类实现借口，自己做数据的封装
        User user = jdbcTemplate.queryForObject(sql,new MyRowMapper(),"wbz");
        System.out.println(user);
    }

        //查询操作
    public static void count() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //设置数据库地址
        dataSource.setUrl("jdbc:mysql:///student");
        dataSource.setUsername("root");
        dataSource.setPassword("h.1111032");


        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select count(*) from user";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }
        //删除操作
        public static void delete() {
            //设置数据库信息
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            //设置数据库地址
            dataSource.setUrl("jdbc:mysql:///student");
            dataSource.setUsername("root");
            dataSource.setPassword("h.1111032");


            //创建jdbcTemplate对象，设置数据源
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            String sql = "delete from user where username=?";
            int rows = jdbcTemplate.update(sql, "wbz");
            System.out.println(rows);
        }

    //修改操作
    public static void update(){
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //设置数据库地址
        dataSource.setUrl("jdbc:mysql:///student");
        dataSource.setUsername("root");
        dataSource.setPassword("h.1111032");


        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "update user set password=? where username=?";
        int rows = jdbcTemplate.update(sql, "999", "wbz");
        System.out.println(rows);
    }

    public static void add() {
        //1 添加操作

        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //设置数据库地址
        dataSource.setUrl("jdbc:mysql:///student");
        dataSource.setUsername("root");
        dataSource.setPassword("h.1111032");


        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象里面的方法实现操作
        //创建sql语句
        String sql = "insert into user values(?,?)";
        int rows = jdbcTemplate.update(sql, "zxy", "666");
        System.out.println(rows);

    }
}
class MyRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs, int num) throws SQLException {
       //1.从结果集里面把数据得到
        String username = rs.getString("username");
        String password = rs.getString("password");

        //2.把得到的数据封装到对象里面
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
}

