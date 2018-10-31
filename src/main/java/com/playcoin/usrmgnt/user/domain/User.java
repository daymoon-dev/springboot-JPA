package com.playcoin.usrmgnt.user.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User extends AbstractPersistable<Long> {

    @NotNull(message = "아이디를 입력해주세요")
    @NotBlank(message="아이디를 입력해주세요")
    @Size(max = 10, message = "아이디는 10자 이내로 입력할 수 있습니다")
    @Column(unique = true)
    private String userId;

    @Size(max = 10, message = "이름은 10자 이내로 입력할 수 있습니다")
    private String name;

    @Size(max = 50, message="{validation.email.Size}")
    @Email(message = "이메일 형식이 잘못되었습니다")
    @NotNull(message = "이메일을 입력해주세요")
    @NotBlank(message = "이메일을 입력해주세요")
    @Column(unique = true)
    private String email;

    @Size(max = 20, message="별명은 20자 이내로 입력할 수 있습니다")
    private String nickName;

    @CreationTimestamp
    private LocalDate regDate;

    @Builder
    public User(String userId, String name, String email, String nickName, LocalDate regDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.regDate = regDate;
    }
}