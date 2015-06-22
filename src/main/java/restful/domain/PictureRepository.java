package restful.domain;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Creates a wallet JPA repository with basic actions
 * 
 * @see extends CrudRepository or PageByPageRepository to add other scaffolder
 *      functions
 * @author david
 *
 */
@RepositoryRestResource(collectionResourceRel = "pictures", path = "pictures")
public interface PictureRepository extends PagingAndSortingRepository<Picture, Long> {
	
	public Collection<Picture> findByUserProfile(@Param("userProfile") UserProfile userProfile);
	
	public Collection<Picture> findByUserProfile_Email(@Param("email") String email);
	
	@Query("SELECT p FROM Picture p INNER JOIN p.tagsList t WHERE t = :tag ")
	public Collection<Picture> findByTag(@Param("tag") Tag tag);
	
	@Query("SELECT p FROM Picture p INNER JOIN p.tagsList t WHERE t.tagName = :tag_name ")
	public Collection<Picture> findByTag_TagName(@Param("tag_name") String tagName);

}