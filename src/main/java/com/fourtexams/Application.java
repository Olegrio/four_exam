package com.fourtexams;

import com.fourtexams.dao.ClimberDao;
import com.fourtexams.dao.ClimbingGroupDao;
import com.fourtexams.dao.MountainDao;
import com.fourtexams.entity.Climber;
import com.fourtexams.entity.ClimbingGroup;
import com.fourtexams.entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager manager = factory.createEntityManager();

        Mountain everest = new Mountain("Эверест" , 8848);
        Mountain everest1 = new Mountain("Эверест1" , 8848);
        Mountain elbrus = new Mountain("Эльбрус", 5642 );


        Climber climber1 = new Climber();
        climber1.setFullName("Иван Григорьев");
        climber1.setAge(25);
        climber1.setEmail("mail_ivan@mail.ru");

        Climber climber2 = new Climber();
        climber2.setFullName("Елена Михайлова");
        climber2.setAge(27);
        climber2.setEmail("mail_helena@mail.ru");

        ClimbingGroup a = new ClimbingGroup(everest, 3);


        MountainDao mountainDao = new MountainDao(manager);
        ClimberDao climberDao = new ClimberDao(manager);

        ClimbingGroupDao climbingGroupDao = new ClimbingGroupDao(manager);

        manager.getTransaction().begin();
        climbingGroupDao.update(a);

        climberDao.update(climber1);
        climberDao.update(climber2);

        mountainDao.update(everest);
        mountainDao.update(everest1);
        mountainDao.update(elbrus);

        manager.getTransaction().commit();

        System.out.println(climbingGroupDao.getGroupsNoStart().toString());

        System.out.println(climberDao.getByNameAndEmail("Елена Михайлова","mail_helena@mail.ru" ));

        System.out.println(mountainDao.getAll().toString());
        System.out.println(mountainDao.getMountainRangeOfHeight(4000, 6000));

    }
}
