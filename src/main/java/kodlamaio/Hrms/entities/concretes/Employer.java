package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer extends User{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyname;
	
	@Column(name="web_adress")
	private String webadress;
	
	@Column(name="phone_number")
	private String phone_number;

	public Employer(int id, String companyname, String webadress, String phone_number) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.webadress = webadress;
		this.phone_number = phone_number;
	}
	
	

}
