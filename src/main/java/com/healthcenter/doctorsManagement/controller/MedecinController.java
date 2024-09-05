package com.healthcenter.doctorsManagement.controller;

import com.healthcenter.doctorsManagement.model.Medecin;
import com.healthcenter.doctorsManagement.model.SpecialiteType;
import com.healthcenter.doctorsManagement.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MedecinController {
    @Autowired
    private MedecinService medecinService;


    @GetMapping("/medecin")
    public ResponseEntity<?> getMedecins() {
        Iterable<Medecin> medecins = medecinService.getMedecins();
        if (medecins.iterator().hasNext()) {
            return ResponseEntity.ok(medecins);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Aucun medecin n'a ete trouve");
        }
    }

    @PostMapping("/medecin")
    public ResponseEntity<Medecin> createMedecin(@RequestBody Medecin medecin) {
        Medecin createdMedecin = medecinService.saveMedecin(medecin);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdMedecin);
    }


    @DeleteMapping("/medecin/{id}")
    public ResponseEntity<?> deleteMedecin(@PathVariable Long id) {
        Optional<Medecin> existingMedecin = medecinService.getMedecin(id);
        if (existingMedecin.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Medecin non trouvé avec l'id : " + id);
        }
        medecinService.deleteMedecin(id);
        return ResponseEntity.ok("Medecin avec l'id" + " " + id + "   " + "is deleted");
    }

    @GetMapping("/medecin/{id}")
    public ResponseEntity<?> getMedecinByID(@PathVariable Long id) {
        Optional<Medecin> medecin = medecinService.getMedecin(id);
        if (medecin.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Employé non trouvé avec l'id : " + id);
        }
        return ResponseEntity.ok(medecin);
    }


    @PutMapping("/medecin/{id}")
    public ResponseEntity<?> updateMedecin(@PathVariable Long id, @RequestBody Medecin medecin) {
        Optional<Medecin> existingMedecin = medecinService.getMedecin(id);
        if (existingMedecin.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Employé non trouvé avec l'id : " + id);
        }
        Medecin updatedMedecin = medecinService.saveMedecin(medecin);
        return ResponseEntity.ok(updatedMedecin);

    }

    @GetMapping("/medecin/specialite/{libelle}")
    public ResponseEntity<?> getMedecinsBySpecialite(@PathVariable SpecialiteType libelle) {
        Iterable<Medecin> medecins = medecinService.getMedecinsBySpecialiteLibelle(libelle);
        if (medecins.iterator().hasNext()) {
            return ResponseEntity.ok(medecins);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Aucun medecin de cette categorie n'a ete trouve");
        }
    }


}
