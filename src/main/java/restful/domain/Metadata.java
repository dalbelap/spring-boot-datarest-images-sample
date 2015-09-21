package restful.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
	
}
