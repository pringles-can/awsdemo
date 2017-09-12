package com.crud.awsdemo.demo;

import com.crud.awsdemo.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.crud.awsdemo.spring.model.Person;

import javax.validation.Valid;


@Controller
public class HomeSweetHomeController {



    @Autowired
    PersonDAO personDAO;

    private String imgUrl;


    public void setImgUrl(String url) {
        this.imgUrl = url;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    //home shit
    @RequestMapping(value="/")
    public String mainPage() {
        return "home";
    }

    
    /*
    @RequestMapping(value="/index")
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }
*/

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    //Model
    @ModelAttribute("person")
    public Page<Person> data(@PageableDefault(value = 5, page = 0, sort = {"id"}) Pageable pageable) {
        Page<Person> persons = personDAO.findAll(pageable);
        return persons;
    }

    @RequestMapping(value="/update/{id}" , method = RequestMethod.POST )
    public String savePerson(@PathVariable("id") int id, @RequestParam String name, @RequestParam String country)
    {

        Person person = personDAO.findOne(id);
        person.setName(name);
        person.setCountry(country);
        personDAO.save(person);
        return "redirect:/awsdemo/";

    }

    @RequestMapping(value="/person/add", method = RequestMethod.POST)
    public String addPerson(@PathVariable("id") int id, @RequestParam String name, @RequestParam String country) {

        Person person = new Person(id, name);
        personDAO.save(person);


        return "redirect:/awsdemo/";
    }

}
