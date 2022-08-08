package com.ub.card.controller;

import com.ub.card.dao.PersonDao;
import com.ub.card.model.Payment;
import com.ub.card.model.Person;
import com.ub.card.model.PersonImage;
import com.ub.card.model.Term;
import com.ub.card.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matshedisoo on 6/13/2016.
 */
@RestController
public class IndexController {

    @Autowired
    private PersonDao personDao;

    private PersonService personService = PersonService.retrofit.create(PersonService.class);

    @RequestMapping("/")
    public String index(){
        return "UB Cards";
    }

    @RequestMapping("/nextseq")
    public
    @ResponseBody
    Integer getNextSeq() {
        return personDao.getNextSeq();
    }

    @RequestMapping("/nextseqtest")
    public
    @ResponseBody
    Integer getNextSeqTest() {
        return personDao.getNextSeqTest();
    }

    @RequestMapping("/activestudents")
    public
    @ResponseBody
    Iterable<Person> getActiveStudents() {

        Term term = personDao.getTerms();

       // Iterable<Person> people = personDao.findAllByTerm(Integer.parseInt(term.getSTRMA()),Integer.parseInt(term.getSTRMB()));

        Iterable<Person> person = personDao.findAllByTermToIts(2191,2192);
        return person;
    }

    @RequestMapping("/recordswithphoto")
    public @ResponseBody Iterable<Person> getRecordsWithPhoto() {
        Iterable<Person> person = personDao.getRecordsWithPhoto();

        //System.out.println("Inside ubarcds");
       // System.out.println(person);

        return person;
    }

    @RequestMapping("/currentstudents")
    public
    @ResponseBody
    Iterable<Person> getCurrentStudents() {

        Term term = personDao.getTerms();

        // Iterable<Person> people = personDao.findAllByTerm(Integer.parseInt(term.getSTRMA()),Integer.parseInt(term.getSTRMB()));

        Iterable<Person> person = personDao.findUpdateByTerm(Integer.parseInt("2191"),Integer.parseInt("2192"));
        return person;
    }

    @RequestMapping(value = "/currentstudent/{student}", method = RequestMethod.GET)
    public
    @ResponseBody
    Iterable<Person> getCurrentStudent(@PathVariable String student) {

        Term term = personDao.getTerms();
        Iterable<Person> person = personDao.findUpdateByTermById(Integer.parseInt("2191"),Integer.parseInt("2192"),student);
        return person;
    }

    @RequestMapping(value = "/studenttoits/{student}", method = RequestMethod.GET)
    public
    @ResponseBody
    Iterable<Person> getPersonToIts(@PathVariable String student) {

        Iterable<Person> person = personDao.getPersonToIts(student);
        return person;
    }

    @RequestMapping(value = "/inserttransactions", method = RequestMethod.POST)
    public
    @ResponseBody
    void insertTransaction(@RequestBody Payment payment) {
       System.out.print("Inside from CURL");
    }

    @RequestMapping(value = "/insertexternal", method = RequestMethod.POST)
    public
    @ResponseBody
    Person insertExternal(@RequestBody Person person) {
        System.out.println("inside "+person.toString());
        personDao.insertPerson(person);
        return person;
    }

    @RequestMapping(value = "/insertstudents", method = RequestMethod.POST)
    public
    @ResponseBody
    Iterable<Person> insertPeople(@RequestBody ArrayList<Person> people) {
        if (!people.isEmpty()) {
            /*final Call<List<Person>> call = personService.insertRecords(people);
            call.enqueue(new Callback<List<Person>>() {
                @Override
                public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                    List<Person> people = response.body();
                    System.out.println(response.code());
                }

                @Override
                public void onFailure(Call<List<Person>> call, Throwable throwable) {
                    System.out.println(throwable.getMessage());
                }
            });*/

            for (Person person : people) {
                List<Person> p = personDao.getPerson(person.getCAGUNUM());
                if (!p.isEmpty()) {
                    personDao.updatePerson(p.get(0));
                }
            }
        }

        return people;
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
        PersonImage personImage = personDao.getImage(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(personImage.getUB_CAGPHOTOIMG());
    }
}
