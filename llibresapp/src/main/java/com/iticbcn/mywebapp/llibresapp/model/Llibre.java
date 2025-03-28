package com.iticbcn.mywebapp.llibresapp.model;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llibre")
public class Llibre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Llibre;
    @Column
    private String titol;
    @Column
    private String autor;
    @Column
    private String editorial;
    @Column
    private LocalDate datapublicacio;
    @Column
    private String tematica;
    @Column(unique = true, nullable = false)
    private String ISBN;
}