package restful.domain;

import lombok.Data;

import javax.annotation.concurrent.Immutable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Data
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private UserProfile userProfile;

	@ManyToOne
	private Picture picture;

	@Column(nullable = false, length = 255)
	private String commentText;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date created;

	/**
	 * <construct>Creates a comment entity with created date time</construct>
	 */
	public Comment(){
		super();

		/* set created date time */
		this.created = new Date();
	}

}
