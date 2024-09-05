package com.healthcenter.doctorsManagement.repository;

import com.healthcenter.doctorsManagement.model.Medecin;
import com.healthcenter.doctorsManagement.model.Specialite;
import com.healthcenter.doctorsManagement.model.SpecialiteType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepository extends CrudRepository<Specialite, Long> {
    Specialite findByLibelle(SpecialiteType libelle);
}
