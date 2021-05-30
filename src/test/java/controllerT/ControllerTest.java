package controllerT;

import domain.User2;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import user2Controller.User2Controller;
import user2service.User2service;

public class ControllerTest {


    @Test
    public void createTest() {
        User2service user2service = Mockito.mock(User2service.class);
        User2Controller user2Controller = new User2Controller(user2service);
        User2 user2 = new User2("pooja", "pgulshetty@gmail.com", 789006543);
        ResponseEntity<User2> entity = user2Controller.createUser2(user2);
        Assert.assertEquals(200, entity.getStatusCodeValue());
        Assert.assertEquals(user2, entity.getBody());
        Mockito.verify(user2service, Mockito.times(1)).createUser2(user2);


    }

    @Test
    public void updateTest() {
        User2service user2service = Mockito.mock(User2service.class);
        User2Controller user2Controller = new User2Controller(user2service);
        User2 existingUser = new User2("priya", "poojavg333@gmail.com", 908765489);
        User2 newUser = new User2("ppp", "pds", 89067534);
        Mockito.when(user2service.findUser2PhoneNumber(908765489)).thenReturn(existingUser);

        ResponseEntity<User2> entity = user2Controller.updatePhoneNumber(newUser, 908765489);

        Assert.assertEquals(200, entity.getStatusCodeValue());
        Assert.assertEquals(newUser, entity.getBody());
        Mockito.verify(user2service, Mockito.times(1)).update(newUser);
    }

    @Test
    public void getByNameTest() {
        User2service user2service = Mockito.mock(User2service.class);
        User2Controller user2Controller = new User2Controller(user2service);
        User2 existingUser = new User2("ppp", "poiuytr", 235678990);
        Mockito.when(user2service.findUser2ByName("pooja")).thenReturn(null);

        ResponseEntity<User2> entity = user2Controller.getUserForGivenUserName("pooja");

        Assert.assertEquals(404, entity.getStatusCodeValue());
    }

    @Test
    public void getUserByNameForExistingUser() {
        User2service user2service = Mockito.mock(User2service.class);
        User2Controller user2Controller = new User2Controller(user2service);
        User2 existingUser = new User2("ppp", "poiuytr", 235678990);
        Mockito.when(user2service.findUser2ByName("pooja")).thenReturn(existingUser);

        ResponseEntity<User2> responseEntity = user2Controller.getUserForGivenUserName("pooja");

        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
        Assert.assertEquals(existingUser, responseEntity.getBody());
    }

    @Test
    public void deleteTest() {
        User2service user2service = Mockito.mock(User2service.class);
        User2Controller user2Controller = new User2Controller(user2service);
        User2 existingUser = new User2("poiyuyt", "pkjtt", 897654390);
        Mockito.when(user2service.findUser2PhoneNumber(897654390)).thenReturn(existingUser);

        ResponseEntity<User2> entity = user2Controller.deletePhoneNumber(897654390);

        Assert.assertEquals(200, entity.getStatusCodeValue());
        Assert.assertEquals(existingUser, entity.getBody());
        Mockito.verify(user2service, Mockito.times(1)).delete(existingUser);
    }
}
