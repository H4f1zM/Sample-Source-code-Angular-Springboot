package au.corp.xtramile.model;

import javax.persistence.Column;
import javax.persistence.Entity ;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener; 


@Entity
@Table( name="Patient")
@EntityListeners(AuditingEntityListener.class)
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name="NAME")
	private String name ;
	
	@Column( name="AGE")
	private int   age ;
	
	@Column( name="GENDER")
	private String gender ;
	
	public Patient( ) {
		

	}	
	
	public Patient(String name, int age, String gender ) {
		
		this.name = name ;
		this.age =  age ;
		this.gender = gender ;
		
	}
	
	
	
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	} 
	
	
	
}
