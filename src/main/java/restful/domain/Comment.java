package restful.domain;

import java.util.Date;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Immutable
@EnableAutoConfiguration
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

	public Comment() {
	}

	public Comment(String commentText) {
		super();
		this.commentText = commentText;
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", userProfile=" + userProfile
				+ ", picture=" + picture + ", commentText=" + commentText
				+ ", created=" + created + "]";
	}

}
