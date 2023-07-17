package com.netec.app.service;

import java.util.List;

import com.netec.app.entities.Articulo;

public interface ICarritoService {

	boolean insertArticulo(int id);

	List<Articulo> showAll();

}
