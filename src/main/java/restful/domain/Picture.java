package restful.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
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
	private Set<Tag> tagsList = new HashSet<Tag>();

	@Column(unique = true, nullable = false, length = 64)
	private String uuidFile;

	@Column(nullable = false, length = 127)
	private String originalFile;

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

	public Picture() {
	}

	public Picture(String uuidFile, String originalFile, String pictureTitle,
			String pictureDescription, int fileSize) {
		super();
		this.uuidFile = uuidFile;
		this.originalFile = originalFile;
		this.pictureTitle = pictureTitle;
		this.pictureDescription = pictureDescription;
		this.fileSize = fileSize;

		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Tag> getTagsList() {
		return tagsList;
	}

	public void setTagsList(Set<Tag> tagsList) {
		this.tagsList = tagsList;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getUuidFile() {
		return uuidFile;
	}

	public void setUuidFile(String uuidFile) {
		this.uuidFile = uuidFile;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public String getPictureTitle() {
		return pictureTitle;
	}

	public void setPictureTitle(String pictureTitle) {
		this.pictureTitle = pictureTitle;
	}

	public String getPictureDescription() {
		return pictureDescription;
	}

	public void setPictureDescription(String pictureDescription) {
		this.pictureDescription = pictureDescription;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
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

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", userProfile=" + userProfile
				+ ", uuidFile=" + uuidFile + ", originalFile=" + originalFile
				+ ", pictureTitle=" + pictureTitle + ", pictureDescription="
				+ pictureDescription + ", fileSize=" + fileSize + ", created="
				+ created + ", modified=" + modified + "]";
	}

}
