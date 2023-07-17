package com.netec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netec.app.entities.Producto;
import com.netec.app.service.IProductoService;

@RestController
public class ProductoController {
	@Autowired
	private IProductoService servicio;

	@GetMapping("/producto")
	public List<Producto> findAll() {
		return servicio.findAll();
	}

	@PostMapping("/producto")
	public Producto salvarProducto(@RequestBody Producto pr) {
		return servicio.save(pr);
	}

	@GetMapping("/producto/{id}")
	public Producto findById(@PathVariable("id") int id) {
		return servicio.findById(id);
	}

	@GetMapping("/producton/{name}")
	public Producto findByName(@PathVariable("name") String name) {
		return servicio.findByName(name);
	}

	@DeleteMapping("/producto/{id}")
	public void deleteById(@PathVariable("id") int id) {
		servicio.deleteById(id);
	}

	@PutMapping("/productou")
	public boolean actualizarProducto(@RequestBody Producto pr) {
		return servicio.update(pr);
	}

}
