package restful.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
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
	private Role role;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false, length = 60)
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
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastAccess;

	private boolean enabled;

	@Version
	private long version;

	public UserProfile() {
	}

	public UserProfile(String email, String encryptedPassword,
			String firstName, String lastName) {

		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.role = Role.CUSTOMER;

		this.enabled = false;
		this.created = new Date();
	}
	
	public UserProfile(String email, String encryptedPassword,
			String firstName, String lastName, Role role) {

		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.role = role;

		this.enabled = false;
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", organization="
				+ organization + ", created=" + created + "]";
	}

}
