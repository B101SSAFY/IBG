package com.ssafy.IBG.User.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(uniqueConstraints = {@UniqueConstraint(name = "userNick_unique", columnNames = {"userEmail", "userNick"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private String nick;

    @Column(columnDefinition = "varchar(20) default 'ROLE_USER'")
    @Enumerated(EnumType.STRING)
    private UserAuthType auth = UserAuthType.ROLE_USER;

    @Builder
    public User(String email, String pwd, String nick, UserAuthType auth) {
        this.email = email;
        this.pwd = pwd;
        this.nick = nick;
        this.auth = auth;
    }
}
