package au.corp.xtramile.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import au.corp.xtramile.model.Patient;
import au.corp.xtramile.repository.PatientRepository;
import au.corp.xtramile.service.PatientService;

@RestController
@RequestMapping("api/")
public class PatientController {

	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	

	@RequestMapping(value = "patient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> getAllPatients() {
		return patientService.findAll();
	}
	
	@RequestMapping(value = "patient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) throws URISyntaxException {
		try {
			Patient result = patientService.save(patient);
			return ResponseEntity.created(new URI("/api/patient/" + result.getid())).body(result);
		} catch (EntityExistsException e) {
			return new ResponseEntity<Patient>(HttpStatus.CONFLICT);
		}
	}
	

	@RequestMapping(value = "patient", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) throws URISyntaxException {
		if (patient.getid() == null) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
		
		try {
			Patient result = patientService.update(patient);
			return ResponseEntity.created(new URI("/api/patient/" + result.getid())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(value = "/patient/{id}", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBody deletePatient(@PathVariable("id") Long id) {
		System.out.println("call requestMethod.delete()");
		patientService.delete(id);

		return (ResponseBody) ResponseEntity.ok().build();
	}
	
	
	/*
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
		System.out.println("call requestMethod.delete()");
		patientService.delete(id);

		return ResponseEntity.ok().build();
	}
	
	*/
	
	
}
