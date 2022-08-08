package com.ub.card.schedule;

import com.ub.card.dao.PersonDao;
import com.ub.card.model.Person;
import com.ub.card.model.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by matshedisoo on 5/19/2016.
 */
@Component
public class CardSchedule {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final long RUN_TASK_EVERY_10_SEC = 10000l;
    private final Logger logger = LoggerFactory.getLogger(CardSchedule.class);

    @Autowired
    private PersonDao personDao;


    @Scheduled(cron = "0 0/5 * * * *")
    public void reportCurrentTime() {

        Term term = personDao.getTerms();

        System.out.println(term.toString());



        //Iterable<Person> people = personDao.findAllByTerm(Integer.parseInt(term.getSTRMA()),Integer.parseInt(term.getSTRMB()));
        Iterable<Person> people = personDao.findAllByTerm(Integer.parseInt("2221"),Integer.parseInt("2227"));
        for (Person person : people) {

            System.out.println(people.toString());

            List<Person> p = personDao.getPerson(person.getCAGUNUM());
            if (p.isEmpty()) {
                System.out.println("inside "+people.toString());
                personDao.insertPerson(person);
            }
        }
    }

    @Scheduled(cron = "0 0/5 * * * *")
    public void international() {

        Term term = personDao.getTerms();

        System.out.println(term.toString());

        //Iterable<Person> people = personDao.findIntByTerm(Integer.parseInt(term.getSTRMA()),Integer.parseInt(term.getSTRMB()));
        Iterable<Person> people = personDao.findIntByTerm(Integer.parseInt("2221"),Integer.parseInt("2227"));
        for (Person person : people) {

            System.out.println("International = "+people.toString());

            List<Person> p = personDao.getPerson(person.getCAGUNUM());
            if (p.isEmpty()) {
                System.out.println("inside "+people.toString());
                personDao.insertPerson(person);
            }
        }
    }

}
