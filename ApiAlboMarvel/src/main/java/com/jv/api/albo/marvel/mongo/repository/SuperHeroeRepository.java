package com.jv.api.albo.marvel.mongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jv.api.albo.marvel.mongo.entity.SuperHeroeEntity;

public interface SuperHeroeRepository extends JpaRepository<SuperHeroeEntity, Long>{

}
