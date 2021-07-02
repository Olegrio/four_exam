package com.fourtexams.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_climbing_groups")
@NamedQueries({
        @NamedQuery(name = "climbing_groups.get_no_start", query = "SELECT g FROM ClimbingGroup g WHERE g.start = NULL"),
})
public class ClimbingGroup extends Parent {

    public ClimbingGroup() {
        this(new Mountain("Кудыкина гора", 333), 1);
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Mountain mountain;

    private Climber[] climbers;

    @Getter
    @Setter
    private LocalDateTime start = null;


    public ClimbingGroup(Mountain mountain, int climberCount) {
        this.mountain = Objects.requireNonNull(mountain, "mountain в ClimbingGroup ошибочно"); //проверка на null + исключение
        climbers = new Climber[climberCount];
    }

    public void addClimber(Climber climber){
        Objects.requireNonNull(climber, "climber -> addClimber в ClimbingGroup ошибочно");
        for (int i = 0; i < climbers.length; i++) {
            if(climbers[i] == null){
                climbers[i] = climber;
                return; // в void методах используется для завершения работы метода
            }
        }
        System.out.println("В группе нет мест");
    }

    public void startClimbingTheMountain(){
        this.start = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClimbingGroup)) return false;
        ClimbingGroup group = (ClimbingGroup) o;
        return Objects.equals(mountain, group.mountain) &&
                Arrays.equals(climbers, group.climbers);
    }

    @Override
    protected Object clone() {
        Mountain copyM = this.mountain.clone();
        ClimbingGroup copyGr = new ClimbingGroup(copyM, climbers.length);
        copyGr.climbers = climbers.clone();
        return copyGr;
    }
}
