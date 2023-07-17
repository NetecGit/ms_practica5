package com.netec.app.service;

import java.util.List;

import com.netec.app.entities.Articulo;

public interface ICarritoService {
	List<Articulo> showAll();
	Articulo searchByName(String nombre);
	boolean insertArticulo(int id);
	boolean deleteArticuloByName(String nombre);
	double calculateTotal();

}
