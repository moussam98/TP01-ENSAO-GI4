package com.ensa.gi4.datatabase.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.modele.TypeMateriel;

import javax.sql.DataSource;
import java.util.List;

public abstract class GenericDAO<T> implements InitializingBean {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterPropertiesSet() { // from InitializingBean
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected List<T> findAll(String query) {
        return jdbcTemplate.query(query, getRowMapper());
    }

    protected T findOne(String query, long id ) {
        return jdbcTemplate.queryForObject(query, getRowMapper(), id );
    }
   
    protected abstract RowMapper<T> getRowMapper();
    
    protected int add(String query, Materiel materiel) {
    	return jdbcTemplate.update(query, materiel.getName(), materiel.getCode()); 
    }
    
    protected List<T> listMaterialByType(String query, TypeMateriel typeMateriel){
    	return jdbcTemplate.query(query, getRowMapper(), typeMateriel.toString().toLowerCase());  
    }
    
    protected int updateMaterial(String query, String code, long id) {
    	return jdbcTemplate.update(query, code, id); 
    }
 
    protected int deleteMaterial(String query, long id) {
    	return jdbcTemplate.update(query, id); 
    }
}
