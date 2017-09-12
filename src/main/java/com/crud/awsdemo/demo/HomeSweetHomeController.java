package com.crud.awsdemo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.awsdemo.spring.model.Person;
import com.crud.awsdemo.service.PersonService;


@Controller
public class HomeSweetHomeController {

    private PersonService personService;

    private String imgUrl;


    public void setImgUrl(String url) {
        this.imgUrl = url;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    //@Autowired(required = true)
    //@Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("personV", new Person());
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

    //home shit
    @RequestMapping(value="/")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value="/index")
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }



}
