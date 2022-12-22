package com.example.flushspringboot.Utils;




import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增策略
    private  Integer id;

    private  String username;

    private  String useremail;

    private  String userpassword;
    private  String userpicture;


}
