package restful;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import restful.domain.Picture;
import restful.domain.PictureRepository;
import restful.domain.UserProfile;
import restful.domain.UserProfileRepository;

/**
 * Start this app with "mvn spring-boot:run"
 * 
 * @author david
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    PictureRepository pictureRepository;
    
    @Autowired
    UserProfileRepository userProfileRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

	@Override
	public void run(String... args) throws Exception {

		// Create user
		UserProfile userProfile = new UserProfile("sample@localhost", "ab42341c2f23cdf23a342234242b1231e29",
				"Bob", "Grant");
		userProfileRepository.save(userProfile);
		
		UserProfile userProfile2 = new UserProfile("john@localhost", "cb42341c2f23cdf23a342234242b1231e30",
				"John", "All");
		userProfileRepository.save(userProfile2);
		
		
		// Create picture 
		Picture picture = new Picture(UUID.randomUUID().toString(), "image.jgp",
				"Other Picture", "Description picture", 1231324);
		picture.setUserProfile(userProfile);
		pictureRepository.save(picture);
		
		Picture picture2 = new Picture(UUID.randomUUID().toString(), "picture2.jgp",
				"My first picture", "Description picture", 1231324);
		picture2.setUserProfile(userProfile);
		pictureRepository.save(picture2);
		
		Picture picture3 = new Picture(UUID.randomUUID().toString(), "picture2.jgp",
				"My first picture", "Description picture", 1231324);
		picture3.setUserProfile(userProfile2);
		pictureRepository.save(picture3);

		// Show user 
		System.out.println(userProfile.toString());
		System.out.println(userProfile2.toString());

		
		// loop to show all generated pictures		
		for (Picture w : this.pictureRepository.findAll()) {
			System.out.println(w.toString());
		}
		
		for (Picture w : this.pictureRepository.findByUserProfile(userProfile)) {
			System.out.println(w.toString());
		}
	}
}
