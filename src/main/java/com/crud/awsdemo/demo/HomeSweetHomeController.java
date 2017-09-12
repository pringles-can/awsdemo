package com.crud.awsdemo.demo;

import com.crud.awsdemo.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

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
/*
    //@Autowired(required = true)
    //@Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)

    public String listPersons(@Valid Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());

        return "personV";
    }

    // add/update
    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p) {
        if (p.getId() == 0) {
            // new person, add
            this.personService.addPerson(p);
        } else {
            // existing, update
            this.personService.updatePerson(p);
        }

        return "redirect:/persons";

    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id) {

        this.personService.removePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping("/edit{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("personV", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());

        return "personV";
    }
    */

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
        Page<Person> allTheCats = personDAO.findAll(pageable);
        return allTheCats;
    }

}
