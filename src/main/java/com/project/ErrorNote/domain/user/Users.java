package com.project.ErrorNote.domain.user;

import com.project.ErrorNote.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "Users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Comment("사용자")
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false, updatable = false)
    private Integer userId;

    @Comment("이메일")
    @Column(length = 20, nullable = false, unique = true)
    private String email;

    @Comment("회원이름")
    @Column(length = 100, nullable = false)
    private String name;

    @Comment("비밀번호")
    @Column(length = 100, nullable = false)
    private String password;

}
