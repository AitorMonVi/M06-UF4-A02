package com.iticbcn.mywebapp.llibresapp.services;

import java.util.Optional;
import java.util.Set;

import com.iticbcn.mywebapp.llibresapp.model.Llibre;

public interface LlibreService {
    // same as repository
    Set<Llibre> findAll();
    Llibre findByTitol(String titol) throws Exception;
    Set<Llibre> findByTitolAndEditorial(String title, String editorial) throws Exception;
    Llibre save(Llibre llibre);

    // unique from service
    Optional<Llibre> findByIdLlibre(int id_Llibre) throws Exception;
    Boolean validateISBN(String ISBN);
}
