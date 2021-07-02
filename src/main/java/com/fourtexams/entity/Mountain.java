package com.fourtexams.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "tb_mountain")
@NamedQueries({
        @NamedQuery(name = "mountain.get_all", query = "SELECT g FROM Mountain g"),
        @NamedQuery(name = "mountain.range_of_height", query = "SELECT g FROM Mountain g WHERE g.height > :min_height AND g.height < :max_height"),
        @NamedQuery(name = "mountain.get_by_name", query = "SELECT g FROM Mountain g WHERE g.name = :mountain_name"),
})
public class Mountain extends Parent implements Cloneable{

    @Column(nullable = false)
    @Getter
    private String name;

    @Getter
    @Column(nullable = false)
    private int height;

    public Mountain(){
        // вызов другого конструктора
        this("Название горы", 1000);
    }

    // конструктор
    public Mountain(String name, int height){
        setName(name);
        setHeight(height);
    }

    public void setName(String name) {
        if(name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Значение name ошибочно");
        }
        this.name = name;
    }

    public void setHeight(int height) {
        if (height < 100 ) throw new IllegalArgumentException("Значение height < 100 ошибочно");
        this.height = height;
    }

    @Override
    public Mountain clone(){
        try {
            return (Mountain) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mountain)) return false;
        Mountain mountain = (Mountain) o;
        return height == mountain.height &&
                name.equals(mountain.name);
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
