package ken.repositories;

import ken.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
    Since we'll need basic CRUD functionality on the User entities,
    we must also define a UserRepository interface

 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{}


