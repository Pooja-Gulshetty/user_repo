package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bhatta_users")
public class User2 {
    @Column(name="user_name")
    private String userName;
    @Column(name="user_email")
    private String userEmailId;
    @Id
    @Column(name="phone_number")
    private  int userPhonenumber;

    protected  User2(){}

    @JsonCreator
    public User2(@JsonProperty("name") String userName,
                 @JsonProperty("email") String userEmailId,
                 @JsonProperty("phone") int userPhonenumber) {
        this.userName = userName;
        this.userEmailId = userEmailId;
        this.userPhonenumber = userPhonenumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public int getUserPhonenumber() {
        return userPhonenumber;
    }

    @Override
    public String toString() {
        return "User2{" +
                "userName='" + userName + '\'' +
                ", userEmailId='" + userEmailId + '\'' +
                ", userPhonenumber=" + userPhonenumber +
                '}';
    }
}
