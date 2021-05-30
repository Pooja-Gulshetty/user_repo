package user2service;

import domain.User2;
import org.springframework.stereotype.Service;
import user2Repository.User2Repository;

import java.util.List;

@Service
public class User2service {
    private final User2Repository user2Repository;

    public User2service(User2Repository user2Repository) {
        this.user2Repository = user2Repository;

    }

    public void createUser2(User2 user2) {
        user2Repository.save(user2);
    }

    public User2 findUser2PhoneNumber(int phoneNumber) {
        return user2Repository.findUser2ByPhoneNumber(phoneNumber);

    }

    public void update(User2 user2) {
        user2Repository.save(user2);
    }

    public User2 findUser2ByName(String userName) {
        return user2Repository.findUser2ByName(userName);

    }

    public void delete(User2 user2) {
        user2Repository.delete(user2);

    }
    public List<User2> findallUsers(){
        return user2Repository.getAllUser();
    }


}
