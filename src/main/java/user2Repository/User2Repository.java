package user2Repository;

import domain.User2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface User2Repository extends CrudRepository<User2, Integer> {
    @Query("select a from User2 a Where a.userPhonenumber=:phoneNumber")
    User2 findUser2ByPhoneNumber(int phoneNumber);

    @Query("select a from User2 a Where a.userName=:name")
    User2 findUser2ByName(String name);

    @Query("select a from User2 a ")
    List<User2> getAllUser();
}
