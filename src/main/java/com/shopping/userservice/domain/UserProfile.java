package com.shopping.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @Column(name = "user_profile_id")
    private String userProfileId = UUID.randomUUID().toString();

    @Column(name = "user_id")
    private String userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile_no")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "theme")
    private String theme="DARK";

    @Column(name = "search")
    private Boolean search=true;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public UserProfile(User user) {
        this.userProfileId=UUID.randomUUID().toString();
        this.userId=user.getUserId();
        this.mobile=user.getMobile();
        this.email=user.getEmail();
        this.firstName=user.getUserProfile().getFirstName();
        this.lastName=user.getUserProfile().getLastName();
        this.search=true;
        this.theme=(user.getUserProfile().getTheme()!=null && !(user.getUserProfile().getTheme().isEmpty())) ? user.getUserProfile().getTheme() :"DARK";
        this.gender=Gender.MALE;
    }

}
