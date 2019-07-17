package edu.ustb.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.UserDao;
import edu.ustb.domain.User;
import edu.ustb.util.JDBCUtils;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	@Override
	public int add(User user) {
		   //1.定义sql
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        //2.执行sql

        return template.update(sql,user.getUsername(),
                    user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
                );
	}
	@Override
	public User findByUserName(String username) {
		 User user = null;
	        try {
	            //1.定义sql
	            String sql = "select * from tab_user where username = ?";
	            //2.执行sql
	            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
	        } catch (Exception e) {

	        }

	        return user;
	}

}
