package com.netec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netec.app.entities.Articulo;
import com.netec.app.service.IArticuloService;

@RequestMapping("/articulo")
public class ArticuloController {
	@Autowired
	private IArticuloService servicio;

	@GetMapping("/{id}")
	public Articulo findById(@PathVariable("id") int id) {
		return servicio.findById(id);
	}

	@GetMapping
	public List<Articulo> findAll() {
		return servicio.findAll();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id) {
		servicio.deleteById(id);
	}

	@PostMapping
	public Articulo insert(@RequestBody Articulo articulo) {
		return servicio.save(articulo);
	}

}
