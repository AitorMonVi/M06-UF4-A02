package com.iticbcn.mywebapp.llibresapp.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.iticbcn.mywebapp.llibresapp.model.Llibre;
import com.iticbcn.mywebapp.llibresapp.repositories.LlibreRepository;

@Service
public class LlibreServiceImpl implements LlibreService {
    @Autowired
    private LlibreRepository repository;

    @Override
    public Set<Llibre> findAll() {
        return repository.findAll();
    }

    @Override
    public Llibre findByTitol(String titol) throws Exception {
        return repository.findByTitol(titol);
    }

    @Override
    public Set<Llibre> findByTitolAndEditorial(String title, String editorial) throws Exception {
        return repository.findByTitolAndEditorial(title, editorial);
    }

    @Override
    public Llibre save(Llibre llibre) {
        return repository.save(llibre);
    }

    @Override
    public Optional<Llibre> findByIdLlibre(int id_Llibre) throws Exception {
        return repository.findById((long) id_Llibre);
    }

    @Override
    public Boolean validateISBN(String isbn) throws Exception {
        if (isbn.matches("^(?=(?:\\D\\d){10}(?:(?:\\D\\d){3})?$)[\\d-]+$")) throw new Exception();
        return true;
    }
}