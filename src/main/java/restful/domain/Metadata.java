package restful.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
public class Metadata {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Picture picture;
	
	@Column(nullable = false, length = 63)
	private String key;
	
	@Column(nullable = false, length = 255)
	private String value;

	public Metadata(){}
	
	public Metadata(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Metadata [id=" + id + ", picture=" + picture + ", key=" + key
				+ ", value=" + value + "]";
	}
	
}
