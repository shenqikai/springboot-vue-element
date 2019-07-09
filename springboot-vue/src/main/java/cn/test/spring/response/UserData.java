package cn.test.spring.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {

    private  Long   id;
    private String  username;
    private String password;
    private String  email;
    private String  address;
}
