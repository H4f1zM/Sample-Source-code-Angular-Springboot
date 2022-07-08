package au.corp.xtramile.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import au.corp.xtramile.model.Patient;
import au.corp.xtramile.repository.PatientRepository;


@Service
public class PatientService {
	
	private PatientRepository patientRepository ;
	
	@Autowired
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	
	public Patient save(Patient patient) {
		if (  patient.getid() != null &&   patientRepository.existsById(patient.getid().longValue())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		System.out.println("call function PatientService.save()");
		return patientRepository.save(patient);
	}
	
	
	public Patient update(Patient patient) {
		/*if (  patient.getid() != null &&   patientRepository.existsById(patient.getid().longValue()))  {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}*/
		System.out.println("call function PatientService.update()");
		return patientRepository.save(patient);
	}
	
	public List<Patient> findAll() {
		System.out.println("call function PatientService.findAll()");
		return patientRepository.findAll();
		
	}

	public Optional<Patient> findOne(Long id) {
		return patientRepository.findById(id);
	}

	public void delete(Long id) {
		System.out.println("call function PatientService.delete()");
		patientRepository.deleteById(id);
	}
	
	
}
