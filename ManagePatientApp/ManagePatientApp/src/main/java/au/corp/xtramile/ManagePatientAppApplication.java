package au.corp.xtramile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import au.corp.xtramile.model.Patient;
import au.corp.xtramile.repository.PatientRepository;

@SpringBootApplication
public class ManagePatientAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ManagePatientAppApplication.class, args);
		
	}

	@Autowired
	private PatientRepository patientRepository ; 
	
	@Override
	public void run(String... args ) throws Exception {
		
		this.patientRepository.save(new Patient("Hafiz",38, "L") ) ;
		this.patientRepository.save(new Patient("Adul",23, "L") ) ;
		
	}
	
}
