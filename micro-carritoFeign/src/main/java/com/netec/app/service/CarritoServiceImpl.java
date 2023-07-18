package com.netec.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
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

	@Autowired
	private CircuitBreakerFactory cb;

	private Logger LOGGER = LoggerFactory.getLogger(CarritoServiceImpl.class);

	@Override
	public boolean insertArticulo(int id) {

//		Articulo art = feign.findById(id);
//
//		if (art != null) {
//			carrito.getArticulos().add(art);
//			return true;
//
//		}
//		return false;

		return cb.create("articulos").run(() -> {

			Articulo art = feign.findById(id);
			if (art != null) {
				carrito.getArticulos().add(art);
				return true;

			}
			return false;
		}, error -> metodoAlternativo(id));
	}

	@Override
	public List<Articulo> showAll() {
		return carrito.getArticulos();
	}

	private boolean metodoAlternativo(int id) {
		LOGGER.info("Se ejecuta metodo alternativo {}", id);

		// Logica de negocio, Valores por defecto..
		return false;
	}

}
