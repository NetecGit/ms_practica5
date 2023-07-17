package com.netec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netec.app.entities.Articulo;
import com.netec.app.service.ICarritoService;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
	@Autowired
	private ICarritoService servicio;

	@PostMapping("/{id}")
	public boolean insert(@PathVariable("id") int id) {
		return servicio.insertArticulo(id);
	}

	@GetMapping
	public List<Articulo> showAll() {
		return servicio.showAll();
	}

}
