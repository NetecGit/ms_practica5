package com.netec.app.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.netec.app.dao.IArticuloDao;
import com.netec.app.entities.Articulo;

public class ArticuloServiceImpl implements IArticuloService {

	@Autowired
	private IArticuloDao dao;

	@Value("${server.port}")
	private int port;

	@Override
	public List<Articulo> findAll() {
		return (List<Articulo>) dao.findAll();
	}

	@Override
	public Articulo findById(int id) {
		return Stream.of(dao.findById(id).orElse(null)).filter(t -> t != null).peek(t -> t.setPort(port)).findFirst()
				.orElse(null);
	}

	@Override
	public Articulo save(Articulo art) {
		return dao.save(art);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

}
