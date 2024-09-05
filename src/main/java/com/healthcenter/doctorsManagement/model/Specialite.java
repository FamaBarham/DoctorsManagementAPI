package com.healthcenter.doctorsManagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;



@Data
@Entity
@Table(name = "specialite")
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "libelle",nullable = false, unique = true)
    private SpecialiteType libelle;


    @OneToMany
    @JoinColumn(name = "specialite_id")
    List<Medecin> medecins = new ArrayList<>();


}
