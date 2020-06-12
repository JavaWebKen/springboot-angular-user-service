package ken.controllers;

import ken.entities.User;
import ken.repositories.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
    Now, let's implement the REST API. In this case, it's just a simple REST controller.

    There's nothing inherently complex in the definition of the UserController class. Of course, the only
    implementation detail worth noting here is the use of the @CrossOrigin annotation. As the name implies,
    the annotation enables Cross-Origin Resource Sharing (CORS) on the server.

    This step isn't always necessary. Since we are deploying our Angular frontend to http://localhost:4200
    and our Boot backend to http://localhost:8080, the browser would otherwise deny requests from one to the other.

    Regarding the controller methods, getUser() fetches all the User entities from the database. Similarly,
    the addUser() method persists a new entity in the database, which is passed in the request body.

    To keep things simple, we deliberately left out of the controller implementation triggering Spring Boot
    validation before persisting an entity. In production, however, we just can't trust user input, so server-side validation should be a mandatory feature.
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
