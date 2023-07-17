package com.netec.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.netec.app.entities.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Integer> {

	@Query("SELECT u FROM Producto u WHERE u.nombre=:nombre")
	Optional<Producto> findByName(@Param("nombre") String nombre);
}
