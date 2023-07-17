package com.netec.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netec.app.entities.Articulo;
import com.netec.app.entities.Carrito;

@Service
public class CarritoServiceImpl implements ICarritoService {
	@Autowired
	private Carrito carrito;

	@Autowired
	private RestTemplate rest;

	@Override
	public List<Articulo> showAll() {

		return carrito.getArticulos();
	}

	@Override
	public Articulo searchByName(String nombre) {

		return carrito.getArticulos().stream().filter(t -> t.getNombre().equals(nombre)).findFirst().orElse(null);
	}

	@Override
	public boolean insertArticulo(int id) {
		final Map<String, String> mapa = new HashMap<>();
		mapa.put("id", String.valueOf(id));
		final String url = "http://localhost:9091/articulo/{id}";
		final Articulo art = rest.getForObject(url, Articulo.class, mapa);
		if (art != null) {
			carrito.getArticulos().add(art);
			return true;

		}

		return false;
	}

	@Override
	public boolean deleteArticuloByName(String nombre) {
		final Articulo art = carrito.getArticulos().stream().filter(t -> t.getNombre().equals(nombre)).findFirst()
				.orElse(null);

		return carrito.getArticulos().remove(art);
	}

	@Override
	public double calculateTotal() {
		return 0.0d;
	}
}
