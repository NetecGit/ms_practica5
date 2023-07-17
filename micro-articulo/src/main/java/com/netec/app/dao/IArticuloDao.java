package com.netec.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.netec.app.entities.Articulo;

public interface IArticuloDao extends CrudRepository<Articulo, Integer> {

}
