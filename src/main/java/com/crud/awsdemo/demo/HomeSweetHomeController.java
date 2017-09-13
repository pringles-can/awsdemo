package com.crud.awsdemo.demo;

import com.crud.awsdemo.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.crud.awsdemo.spring.model.Person;

import javax.servlet.RequestDispatcher;
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

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    //Model
    @ModelAttribute("person")
    public Page<Person> data(ModelMap model, @PageableDefault(value = 5, page = 0, sort = {"id"}) Pageable pageable) {
        Page<Person> listPersons = personDAO.findAll(pageable);
        model.addAttribute(listPersons);
        return listPersons;
    }

    @RequestMapping(value="/update/{id}" , method = RequestMethod.POST )
    public String savePerson(@PathVariable("id") int id, @RequestParam String name, @RequestParam String country)
    {

        Person person = personDAO.findOne(id);
        person.setName(name);
        person.setCountry(country);
        personDAO.save(person);
        return "redirect:/persons/";

    }

    @ModelAttribute("person")
    @RequestMapping(value="/person", method = RequestMethod.GET)
    public String loadPersonPage(ModelMap model) {
        //model.addAttribute("person", new Person(" "," "));
        return "person";
    }

    @RequestMapping(value="/person/add", method = RequestMethod.POST)
    public String addPerson(@RequestParam String name, @RequestParam String country) {
        personDAO.save(new Person(name, country));
        return "redirect:/";
        //return "redirect:/person/add";
    }

    @RequestMapping(value="/person/remove", method = RequestMethod.POST)
    public String removePerson(@RequestParam int id) {
        personDAO.delete(id);
        return "redirect:/";
    }

}
