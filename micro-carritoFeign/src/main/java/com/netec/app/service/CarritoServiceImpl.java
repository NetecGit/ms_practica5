package com.netec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netec.app.entities.Articulo;
import com.netec.app.entities.Carrito;
import com.netec.app.feign.IArticuloFeign;

@Service
public class CarritoServiceImpl implements ICarritoService {
	@Autowired
	private IArticuloFeign feign;

	@Autowired
	private Carrito carrito;

	@Override
	public boolean insertArticulo(int id) {

		Articulo art = feign.findById(id);

		if (art != null) {
			carrito.getArticulos().add(art);
			return true;

		}
		return false;

	}

	@Override
	public List<Articulo> showAll() {
		return carrito.getArticulos();
	}
}
