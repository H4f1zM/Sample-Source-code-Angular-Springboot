package au.corp.xtramile.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.corp.xtramile.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long > {

	Patient findByName(String name);
}