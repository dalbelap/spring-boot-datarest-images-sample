package restful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restful.domain.Comment;
import restful.domain.Picture;
import restful.domain.UserProfile;

import java.util.Collection;

/**
 * Creates a wallet JPA repository with basic actions
 * 
 * @see extends CrudRepository or PageByPageRepository to add other scaffolder
 *      functions
 * @author david
 *
 */
@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
	
	public Collection<Comment> findByUserProfile(UserProfile userProfile);
	
	public Collection<Comment> findByPicture(Picture picture);
	
}