package edu.ustb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.CategoryDao;
import edu.ustb.domain.Category;
import edu.ustb.domain.User;
import edu.ustb.util.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao{

	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	public List<Category> getAllCategory(){
		List<Category> list = null;
		try {
			String sql="select cid,cname from tab_category";
			list = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
