package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{
 
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Category> findAllCategory() {
		return jdbcTemplate.query("select * from category",(rs,rownum)->{
			Category c = new Category();
			c.setCid(rs.getInt(1));
			c.setCname(rs.getString(2));
			c.setCdesc(rs.getString(3)); 
			return c;
		});
		
	}

	@Override
	public Category findByCid(int cid) {
		return jdbcTemplate.queryForObject("select * from category where cid=?",new Object[] {cid},BeanPropertyRowMapper.newInstance(Category.class)
			
			);
	
	}

	@Override
	public boolean addNewCategory(Category c) {
		int n = jdbcTemplate.update("insert into category values(?,?,?)",
				new Object[] {c.getCid(),c.getCname(),c.getCdesc()});
		return n>0;
	}

	@Override
	public boolean modifyCategory(Category c) {
		
		int n = jdbcTemplate.update("update category set cname=?,cdesc=? where cid=?",
				new Object[] {c.getCname(),c.getCdesc(),c.getCid()});
		return n>0;
	}

	@Override
	public boolean removeByCid(int cid) {
		
		int n = jdbcTemplate.update("delete from category where cid=?",
				new Object[] {cid});
		return n>0;
	}

		
	
}
