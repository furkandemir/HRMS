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
@Table(name="verification_codes")
public class VerificationCode {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="verifide_date")
	private Date verifieddate;

	public VerificationCode(int id, String code, Date verifieddate) {
		super();
		this.id = id;
		this.code = code;
		this.verifieddate = verifieddate;
	}
	
	

}
