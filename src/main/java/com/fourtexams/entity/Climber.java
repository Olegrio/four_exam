package com.fourtexams.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@ToString
@Getter
@Setter
@Entity
@Table(name = "tb_climber")
@NamedQueries({
        @NamedQuery(name = "climber.get_by_name_and_email", query = "SELECT g FROM Climber g WHERE g.fullName = :climber_name AND g.email = :climber_email"),
})
public class Climber extends Parent {


    // свойства (поля, атрибуты)
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String email;

    // методы
    public void setFullName(String fullName){
        if(Objects.isNull(fullName) || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Значение fullName ошибочно");
        }
        this.fullName = fullName;

    }
    // без модификатора доступа дефолтный package-private  (доступны внутри пакета)
    public void setAge(int age){
        if(age < 18) throw new IllegalArgumentException("Значение age < 18");
        this.age = age;
    }

    public void setEmail(String email) {
        if(Objects.isNull(email) || email.trim().length() < 3 || !email.trim().contains("@")) {
            throw new IllegalArgumentException("Значение email ошибочно");
        }
        this.email = email;
    }

}

