package restful;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import restful.domain.Picture;
import restful.domain.UserProfile;
import restful.repository.PictureRepository;
import restful.repository.UserProfileRepository;

/**
 * Start this app with "mvn spring-boot:run"
 * 
 * @author david
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	private byte[] fileImage = "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAAAAACPAi4CAAAD8klEQVR4AaXXb0xVdRzH8c859wIKV+XmEPkzh7iihrgYQUqMIvuzrCdlpG2urT9Diq2srVwPrC2qteUinWvpNFyGmn9abmJ/EUsGlSCxAMN1xwhCQMCh3MuAc++n7jn3nJ1z77n3/pqvB78H3wfv3/fpVyLsKYpf+mNcAsDcFZLD6YA9J+z4RsfONneOQ5d75/q7l6UnwobdBldams9dQrii+x8qXoJIDDf09roFsHVLxe55hgPDfJCTgKiS807FCXQUOxFT0hPDMQIz+52IK/u7+WiB0RqIcH7oswsE2PkIBG0dswmwvQCABCGPjkUGOgsQ9EBV5VJEVfbCM9kI2jAaHpjciKBVXfTPfFUMOymv9Cn+uZ1QvTlnDcxuD82pql/hRKLLtTQj6z9pS1zJMpIqtU9/cUPVYA2chOYtaqa3l9Ue+/Iyg66dP1FfVVJHTX8pVCmd5kB/CjQ7qPPRYoYhnhJo8gMMkhH0rBfhFsJiAcL17ECQGmhoQYgD4nb16QGlVkFI1ySEeV/VA58OQjc8hTg8vyGE7T9rgblGH3TFGYgjNQ+6q8fVDpuWQVfUz7iOpEJX+BcJBt6DLvkoBWySECIfI8Hhe6HLoYgfFkNX7SXY7YLuEwrJhK5kkDI909CthJAN0P0+AVk5D0MhhNwF3ZyHsv8iDOkQMg9Du18OjOAmjARkfy9uQpsiEwYo+L8UyDDpgBAvTCwBD4R8HzUwACGXowYaIKLpetTAYDMEnPHBQMiODBh8jYhv5KwCQ4FDlpfDoBxuQVyfd8OA5RJmq2Hy8FXGcTobJgf98O+F2WM3GEOA36bDrIXgBVjc9w9jOLAIZqs8BPvzoZG0N2EnoxnY7IBF5SRB74ta7BwntjkRlP3xwDWvEqCJf2Zq4qcnnQizmwR5Qp0nvjtKnkqH5van6lpo4I0vqu/JRIScX9XA0Fqo1veRx93Q1dHAKw/CzqZ5NcDXZahWj5EvIaScZmfciOQ6SC1wKQOaGnK6CCp5Fy0KEWmNEgqwSoYqtZWcK0eQo40Wz0kI5/yMeiCQBpXjZZIc3vf8GyenaFXvQLgyBvQAv4Yms5lR7I8IJA0xCFRVQ0JQfodwYA/NgfFSaHJqZ0UCEmpmqZII1cXH/4Yq0Z15hyJ5u5puhdmBrX6YVRzKgoYhRxbCzNkbc4OVbQyREbL5/UUQlrVnLXQ0fJQmukHeaQbs7oVvbhMLVHQyQLsAuzeKBF4boglodv0dR7yA+/AszUCrP9c5YwUStkzSSoZVXuu+NYthT0ovbzzkRhhG8B99enUCemixF67SbRcYSSJs9PZ0VOXCrPXHwqJMkdtZN48EmCkOCYB4QNy/HoBnXx+NmK8AAAAASUVORK5CYII=".getBytes();

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
		Picture picture = new Picture("image.jgp", "Other Picture", "Description picture", Base64.decodeBase64(fileImage), fileImage.length);
		picture.setUserProfile(userProfile);
		pictureRepository.save(picture);
		
		Picture picture2 = new Picture("picture2.jgp",
				"My first picture", "Description picture", Base64.decodeBase64(fileImage), fileImage.length);
		picture2.setUserProfile(userProfile);
		pictureRepository.save(picture2);
		
		Picture picture3 = new Picture("picture2.jgp",
				"My first picture", "Description picture", Base64.decodeBase64(fileImage), fileImage.length);
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
