package jh.jhspring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Member {

	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @Size(min=2,max=15)
	private String name;
	
	@NotBlank @Size(min=2,max=150)
	private String password;

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
