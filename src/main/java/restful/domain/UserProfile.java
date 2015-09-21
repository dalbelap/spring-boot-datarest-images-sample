package restful.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class UserProfile {

	/**
	 * Role statement for UserProfile
	 *
	 */
	public enum Role {
		CUSTOMER, PREMIUM, ENTERPRISE;
	}
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Role role = Role.CUSTOMER;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false, length = 60)
	@JsonIgnore
	private String encryptedPassword;

	@Column(nullable = false, length = 31)
	private String firstName;
	@Column(nullable = false, length = 63)
	private String lastName;

	@Column(length = 31)
	private String organization;

	@Column(length = 31)
	private String country;

	@Column(length = 31)
	private String region;
	@Column(length = 31)
	private String location;
	@Column(length = 63)
	private String postalAddress;
	@Column(length = 10)
	private String postalCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date created = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastAccess;

	private boolean enabled;

	@Version
	private long version;


    public UserProfile(){

    }

	public UserProfile(String email, String encryptedPassword, String firstName, String lastName) {
		super();

		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.firstName = firstName;
		this.lastName = lastName;

		this.created = new Date();

	}

}
