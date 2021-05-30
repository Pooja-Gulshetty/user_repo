package service;

import domain.User2;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import user2Repository.User2Repository;
import user2service.User2service;

public class ServiceTest {


    @Test
    public void serviceCreateTest() {
        User2Repository user2Repository = Mockito.mock(User2Repository.class);
        User2service user2service = new User2service(user2Repository);
        User2 newUser = new User2("pooja", "ppppp", 456789898);

        user2service.createUser2(newUser);

        Mockito.verify(user2Repository, Mockito.times(1)).save(newUser);
    }


    @Test
    public void updateTest() {
        User2Repository user2Repository = Mockito.mock(User2Repository.class);
        User2service user2service = new User2service(user2Repository);
        User2 existingUser = new User2("pppp", "pjklm", 987654390);

        user2service.update(existingUser);

        Mockito.verify(user2Repository, Mockito.times(1)).save(existingUser);
    }

    @Test
    public void deleteTest() {
        User2Repository user2Repository = Mockito.mock(User2Repository.class);
        User2service user2service = new User2service(user2Repository);
        User2 user2 = new User2("pooja", "piuyte", 973196488);
        user2service.delete(user2);
        Mockito.verify(user2Repository, Mockito.times(1)).delete(user2);
    }

    @Test
    public void findUserByName() {
        User2Repository user2Repository=Mockito.mock(User2Repository.class);
        User2service user2service=new User2service(user2Repository);
        User2 existing=new User2("pooja","ptyh",897654587);
        Mockito.when(user2Repository.findUser2ByName("priya")).thenReturn(existing);

        User2 result = user2service.findUser2ByName("priya");

        Assert.assertEquals(existing, result);



    }
}
