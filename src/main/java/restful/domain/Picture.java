package restful.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString(exclude={"tagsList", "userProfile"})
public class Picture {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private UserProfile userProfile;
	
	@ManyToMany
	@JoinTable(name = "picture_tags", 
		joinColumns = @JoinColumn(name = "picture_id"), 
		inverseJoinColumns = @JoinColumn(name = "tag_id"))	
	private Set<Tag> tagsList = new HashSet<>();

	@Column(nullable = false, length = 127)
	private String originalFileName;

	/* maximum 10Mb */
	@Column(nullable = false, length = 1073741824)
	private byte[] pictureFile;

	@Column(nullable = false, length = 63)
	private String pictureTitle;
	@Column(length = 255)
	private String pictureDescription;

	@Column(nullable = false)
	private int fileSize;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@Version
	private long version;

	public Picture(){

	}

	public Picture(String originalFileName, String pictureTitle, String pictureDescription,
				   byte[] pictureFile, int fileSize) {
		super();
		this.originalFileName = originalFileName;
		this.pictureTitle = pictureTitle;
		this.pictureDescription = pictureDescription;

		this.pictureFile = pictureFile;
		this.fileSize = fileSize;

		/* set created date time */
		this.created = new Date();
	}
}
