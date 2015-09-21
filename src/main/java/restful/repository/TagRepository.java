package restful.repository;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restful.domain.Picture;
import restful.domain.Tag;

/**
 * Creates a wallet JPA repository with basic actions
 * 
 * @see extends CrudRepository or PageByPageRepository to add other scaffolder
 *      functions
 * @author david
 *
 */
@RepositoryRestResource(collectionResourceRel = "tags", path = "tags")
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
	
	public Collection<Tag> findByTagName(String tagName);
	
	@Query("SELECT t FROM Tag t INNER JOIN t.picturesList p WHERE p = :picture")
	public Collection<Tag> findByPicture(@Param("picture") Picture picture);
	
}