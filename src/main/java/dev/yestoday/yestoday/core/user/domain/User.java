package dev.yestoday.yestoday.core.user.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.yestoday.yestoday.core.follow.domain.Follow;
import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_email", nullable = false)
    private String email;
    @Column(name = "user_password", nullable = false)
    private String password;
    @Column(name = "user_name", length = 20)
    private String name;
    @Column(name = "user_phone_number")
    private String phoneNumber;
    @Column(name = "user_nickname", nullable = false, length = 20)
    private String nickname;
    @Lob
    @Column(name = "user_description")
    private String description;
    @Column(name = "profile_image")
    private String imageUrl;
    @OneToMany(mappedBy = "user")
    private List<Follow> followings;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String nickname, String password, String name, String email, String description, String phoneNumber,  String imageUrl, List<Follow> followings, Authority authority){
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.email = email;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.followings = followings;
        this.authority = authority;

    }
}
