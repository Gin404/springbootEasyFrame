package com.dream.springbootframe.zsgzdemo.dao.impl;

import com.dream.springbootframe.utils.Base;
import com.dream.springbootframe.zsgzdemo.dao.CsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 *
 */
@Repository
public class CsDaoImpl<E> implements CsDao<E>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(E e) {
        Map<String, Object> map = Base.base().save(e);
        return jdbcTemplate.update((String) map.get(Base.SQL), (Object[]) map.get(Base.VALUES));
    }
}
