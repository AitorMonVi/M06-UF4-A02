package com.iticbcn.mywebapp.llibresapp.controllers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.iticbcn.mywebapp.llibresapp.model.Llibre;
import com.iticbcn.mywebapp.llibresapp.services.LlibreService;

@Controller
public class BookController {

    @Autowired
    private LlibreService service;

    @GetMapping("/")
    public String iniciar(Model model) {
        return "login";
    }

    @PostMapping("/index")
    public String login(@RequestParam(name = "usuari") String usuari,
                        @RequestParam(name = "password") String password, 
                        Model model) {
        
        if (usuari.equals("aitor") && password.equals("1234")) return "index";
        else {
            model.addAttribute("error", "Usuari o contrasenya incorrectes!");
            return "login";
        }
    }


    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/consulta") 
    public String consulta(Model model) {

        Set<Llibre> llibres = service.findAll();

        model.addAttribute("llibres", llibres);
        
        return "consulta";
    }

    @GetMapping("/inserir") 
    public String inputInserir(Model model) {
        return "inserir";
    }
    
    @PostMapping("/inserir")
    public String inserir(@RequestParam(name = "titol") String titol,  
                          @RequestParam(name = "autor") String autor,
                          @RequestParam(name = "editorial") String editorial,  
                          @RequestParam(name = "datapublicacio") String datapublicacio,
                          @RequestParam(name = "tematica") String tematica,
                          @RequestParam(name = "ISBN") String isbn,
                          Model model) {
        String message = "";
        boolean llibreErr = false;

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(datapublicacio);
        } catch (Exception e) {
            message = "La fecha que has aportado es incorrecta utiliza formato (YYYY-MM-DD)";
            llibreErr = true;

            model.addAttribute("message", message);
            model.addAttribute("llibreErr", llibreErr);
            return "inserir";
        }

        try {
            service.validateISBN(isbn);
        } catch (Exception e) {
            message = "El ISBN que has aportado es incorrecto";
            llibreErr = true;

            model.addAttribute("message", message);
            model.addAttribute("llibreErr", llibreErr);
            return "inserir";
        }

        Llibre llibre = new Llibre();

        llibre.setTitol(titol);
        llibre.setAutor(autor);
        llibre.setEditorial(editorial);
        llibre.setDatapublicacio(fecha);
        llibre.setTematica(tematica);
        llibre.setISBN(isbn);

        try {
            llibre = service.save(llibre);
            if (llibre == null) {
                message = "El libro no se ha podido guardar correctamente";
                llibreErr = true;

                model.addAttribute("message", message);
                model.addAttribute("llibreErr", llibreErr);
                return "inserir";
            }
        } catch (Exception e) {
            message = "El libro no se ha podido guardar correctamente";
            llibreErr = true;

            model.addAttribute("message", message);
            model.addAttribute("llibreErr", llibreErr);
            return "inserir";
        }

        Set<Llibre> llibres = service.findAll();
        model.addAttribute("llibres", llibres);

        return "consulta";        
    }

    @GetMapping("/cercaid")
    public String inputCerca(Model model) {
        Llibre llibre = new Llibre();
        llibre.setId_Llibre(0);
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", llibre);

        return "cercaid";

    }

    @PostMapping("/cercaid")
    public String cercaId(@RequestParam(name = "id_Llibre", required = false) String idLlibre, 
                           Model model) {
        int id_Llibre = 0;
        String message = "";
        boolean llibreErr = false;

        try {
            id_Llibre = Integer.parseInt(idLlibre);
            Optional<Llibre> llibre = service.findByIdLlibre(id_Llibre);
            
            if(llibre.isPresent()) model.addAttribute("llibre", llibre.get());
            else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }

        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        } 
        
        model.addAttribute("message", message);
        model.addAttribute("llibreErr",llibreErr);

        return "cercaid";
    }

    @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
}