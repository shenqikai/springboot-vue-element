package cn.test.spring.dao.pojo;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String tel;
    @Pattern(regexp = "publish|deleted")
    private String status = "publish";
}
