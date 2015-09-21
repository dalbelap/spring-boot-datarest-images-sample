package restful.domain;

import lombok.Data;

import javax.annotation.concurrent.Immutable;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Immutable
@Data
public class Tag {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany
	@JoinTable(name = "picture_tags", 
		joinColumns = @JoinColumn(name = "tag_id"), 
		inverseJoinColumns = @JoinColumn(name = "picture_id"))
	private Set<Picture> picturesList = new HashSet<>();

	@Column(nullable = false, length = 63)
	private String tagName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date created;

	/**
	 * <construct>Created a tag name with name and date time</construct>
	 */
	public Tag() {
		super();


		/* tag date time */
		this.created = new Date();
	}

	/**
	 * <construct>Creates a tag name with name and date time</construct>
	 * @param tagName
	 */
	public Tag(String tagName) {
		super();

		this.tagName = tagName;

		/* tag date time */
		this.created = new Date();
	}

}
