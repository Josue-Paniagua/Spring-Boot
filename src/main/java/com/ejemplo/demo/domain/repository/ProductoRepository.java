package com.ejemplo.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.domain.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{

}
