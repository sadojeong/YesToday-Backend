package dev.yestoday.yestoday.core.todo.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // 시간을 자동으로 넣어주는 기능
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(name="registration_date")
    @DateTimeFormat(pattern = "yyyy.MMMM.dd ")
    private LocalDateTime registrationDate;






}
