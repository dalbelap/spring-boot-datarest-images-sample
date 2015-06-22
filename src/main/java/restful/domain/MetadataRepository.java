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
@RepositoryRestResource(collectionResourceRel = "metadatas", path = "metadatas")
public interface MetadataRepository extends PagingAndSortingRepository<Metadata, Long> {
	
	public Collection<Metadata> findByPicture(Picture picture);
	
}