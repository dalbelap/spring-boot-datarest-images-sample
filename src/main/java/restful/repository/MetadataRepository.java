package restful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restful.domain.Metadata;
import restful.domain.Picture;

import java.util.Collection;

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