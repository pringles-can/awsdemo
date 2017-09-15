package com.crud.awsdemo.demo;

import com.crud.awsdemo.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.crud.awsdemo.spring.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeSweetHomeController {



    @Autowired
    PersonDAO personDAO;

    private String imgUrl;
    private List<Person> listPersons;

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
        Page<Person> persons = personDAO.findAll(pageable);
        Page<Person> prsns = personDAO.findAll(new PageRequest(0, 20));
        listPersons = prsns.getContent();
        ;
        model.addAttribute("listPersons", listPersons);
        return persons;
    }

    private void setListPersons(ArrayList<Person> lp) {
        listPersons = lp;
    }

    @RequestMapping(value="/person/edit/{id}" , method = RequestMethod.GET )
    public String savePerson(ModelMap model, @PathVariable("id") int id)
    {

        Person person = personDAO.findOne(id);
        personDAO.save(person);
        model.put("person", person);

        return "Update";

    }

    @RequestMapping(value="/person/save/{id}", method = RequestMethod.POST )
    public String save(@PathVariable("id") int id, @RequestParam String name, @RequestParam String country)
    {
        if(name=="" || country=="")
        {
            return "updateerror";
        }

        else if(name.length() > 20 || country.length() > 30)
        {
            return "updateerror";
        }

        else {
            Person dude = personDAO.findOne(id);
            dude.setName(name);
            dude.setCountry(country);
            personDAO.save(dude);
            return "redirect:/person";
        }
    }

    @ModelAttribute("person")
    @RequestMapping(value="/person", method = RequestMethod.GET)
    public String loadPersonPage() {
        return "person";
    }

    @RequestMapping(value="/person/add", method = RequestMethod.POST)
    public String addPerson(@RequestParam String name, @RequestParam String country) {
        personDAO.save(new Person(name, country));
        return "redirect:/person";
        //return "redirect:/person/add";
    }
    
    @RequestMapping(value="/search{id}" , method = RequestMethod.GET )
    public String search(@RequestParam int id, ModelMap model)
    {
        if(personDAO.findOne(id)==null) {
            return "searcherr"; // return something else, searchbyname
        }

        else {
            Person person = personDAO.findOne(id);
            model.put("person", person);
            return "Update";
        }
    }

    @RequestMapping(value="/searchbyname", method = RequestMethod.POST)
    public String searchname(@RequestParam String name, ModelMap model)
    {
        List<Person> listP = personDAO.findAll();
        List<Person> persons =
                listP.stream().filter(x -> x.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
        model.put("persons", persons);
        return "home";
    }

    @RequestMapping(value="/person/remove/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/person";
    }

}
