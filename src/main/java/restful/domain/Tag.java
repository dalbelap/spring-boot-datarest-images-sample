package restful.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Immutable
@EnableAutoConfiguration
public class Tag {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany
	@JoinTable(name = "picture_tags", 
		joinColumns = @JoinColumn(name = "tag_id"), 
		inverseJoinColumns = @JoinColumn(name = "picture_id"))
	private Set<Picture> picturesList = new HashSet<Picture>();

	@Column(nullable = false, length = 63)
	private String tagName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date created;

	public Tag() {
	}

	public Tag(String tagName) {
		super();
		this.tagName = tagName;
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Picture> getPicturesList() {
		return picturesList;
	}

	public void setPicturesList(Set<Picture> picturesList) {
		this.picturesList = picturesList;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + ", created="
				+ created + "]";
	}

}
