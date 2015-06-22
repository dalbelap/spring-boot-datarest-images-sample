package restful.domain;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

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