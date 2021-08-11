package kodlamaio.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="candidates")
public class Candidate extends User{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="identity_number")
	private String identitynumber;
	
	@Column(name="date_of_birth")
	private Date birthday;

	public Candidate(int id, String firstname, String lastname, String identitynumber, Date birthday) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.identitynumber = identitynumber;
		this.birthday = birthday;
	}
	
	

}
