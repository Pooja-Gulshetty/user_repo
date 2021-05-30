package user2Controller;

import domain.User2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user2service.User2service;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class User2Controller {
    private User2service user2service;

    public User2Controller(User2service user2service) {
        this.user2service = user2service;
    }


    /*
    {
        "name" : "Pooja",
        "email": "pgulshetty@gmail.com",
        "phone": "0616498245"
     }
     */
    @RequestMapping(path = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User2> createUser2(@RequestBody User2 user2) {
        user2service.createUser2(user2);
        return ResponseEntity.ok(user2);
    }

    @RequestMapping(path = "/users/{PhoneNumber}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User2> updatePhoneNumber(@RequestBody User2 user2, @PathVariable("PhoneNumber")
            Integer phoneNumber) {
        User2 existingUser2 = user2service.findUser2PhoneNumber(phoneNumber);
        if (existingUser2 == null) {
            return ResponseEntity.notFound().build();
        }

        user2service.update(user2);

        return ResponseEntity.ok(user2);

    }

    // http://192.168.2.224:8080/users/username/pooji
    @RequestMapping(path = "/users/userName/{UserName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User2> getUserForGivenUserName(@PathVariable("UserName") String userName) {
        User2 user2 = user2service.findUser2ByName(userName);

        if (user2 == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user2);
    }

    @RequestMapping(path = "/users/phoneNumber/{phoneNumber}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User2> getUserForGivenPhoneNumber(@PathVariable("phoneNumber") int phoneNumber) {
        User2 user2 = user2service.findUser2PhoneNumber(phoneNumber);

        if (user2 == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user2);
    }

    @RequestMapping(path = "/users",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User2>> getallUsers(){
        List<User2> user2List=user2service.findallUsers();
        return ResponseEntity.ok(user2List);
    }

    @RequestMapping(path = "/users/phoneNumber/{userPhoneNumber}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User2> deletePhoneNumber(@PathVariable("userPhoneNumber") Integer phoneNumber) {
        User2 user2 = user2service.findUser2PhoneNumber(phoneNumber);
        if (user2 == null) {
            return ResponseEntity.notFound().build();

        }
        user2service.delete(user2);
        return ResponseEntity.ok(user2);

    }


}

