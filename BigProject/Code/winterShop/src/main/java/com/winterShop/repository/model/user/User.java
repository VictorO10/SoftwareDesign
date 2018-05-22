package com.winterShop.repository.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Id
    private Long userid;

    @Column(nullable = false)
    private String email;

    private String password;

    private String token;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "User_UserRole")
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public User() {
    }
}
