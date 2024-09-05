package com.healthcenter.doctorsManagement.repository;

import com.healthcenter.doctorsManagement.model.Medecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends CrudRepository<Medecin, Long> {
}
