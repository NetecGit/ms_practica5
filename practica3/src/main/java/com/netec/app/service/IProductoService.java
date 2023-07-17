package com.netec.app.service;

import java.util.List;

import com.netec.app.entities.Producto;

public abstract interface IProductoService {
	List<Producto> findAll();

	Producto save(Producto pr);

	boolean update(Producto pr);

	void deleteById(int id);

	Producto findByName(String name);

	Producto findById(int id);
}
