package restful.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restful.domain.UserProfile;

/**
 * Creates a wallet JPA repository with basic actions
 * 
 * @see extends CrudRepository or PageByPageRepository to add other scaffolder
 *      functions
 * @author david
 *
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

	public UserProfile findByEmail(String email);
}