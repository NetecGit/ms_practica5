package com.netec.app.service;

import java.util.List;

import com.netec.app.entities.Articulo;

public interface IArticuloService {

	List<Articulo> findAll();

	Articulo findById(int id);

	Articulo save(Articulo art);

	void deleteById(int id);

}
