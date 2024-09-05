package com.healthcenter.doctorsManagement.service;

import com.healthcenter.doctorsManagement.model.Medecin;
import com.healthcenter.doctorsManagement.model.Specialite;
import com.healthcenter.doctorsManagement.model.SpecialiteType;
import com.healthcenter.doctorsManagement.repository.MedecinRepository;
import com.healthcenter.doctorsManagement.repository.SpecialiteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    public Optional<Medecin> getMedecin(final Long id) {
        return medecinRepository.findById(id);
    }

    public Iterable<Medecin> getMedecins() {
        return medecinRepository.findAll();
    }

    public void deleteMedecin(final Long id) {
        medecinRepository.deleteById(id);
    }

    public Medecin saveMedecin(Medecin medecin) {
        Medecin savedMedecin = medecinRepository.save(medecin);
        return savedMedecin;
    }
    @Autowired
    private SpecialiteRepository specialiteRepository;

    public Iterable<Medecin> getMedecinsBySpecialiteLibelle(SpecialiteType libelle) {
        Specialite specialite = specialiteRepository.findByLibelle(libelle);
        if (specialite != null) {
            return specialite.getMedecins();
        } else {
            return List.of(); // Retourne une liste vide si la spécialité n'est pas trouvée
        }
    }

}
