package com.iticbcn.mywebapp.llibresapp.repositories;

import org.springframework.stereotype.Repository;

import com.iticbcn.mywebapp.llibresapp.model.Llibre;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.Set;

@Repository
public interface LlibreRepository extends CrudRepository<Llibre, Long> {
    @Override
    @NonNull
    Set<Llibre> findAll();
    Llibre findByTitol(String titol) throws Exception;
    Set<Llibre> findByTitolAndEditorial(String title, String editorial) throws Exception;
}