package com.crud.awsdemo.demo;

import com.crud.awsdemo.dao.ImagDAO;
import com.crud.awsdemo.dao.PersonDAO;
import com.crud.awsdemo.spring.model.Imag;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.crud.awsdemo.spring.model.Person;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NonUniqueResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@Validated
public class HomeSweetHomeController {

    @Autowired
    PersonDAO personDAO;

    @Autowired
    ImagDAO imagDAO;



    private List<Person> listPersons;

    private List<Imag> listImages;
    private List<byte[]> personImages;

    //home shit
    @RequestMapping(value="/")
    public String mainPage() {

        return "home";
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    //Model
    @Valid
    @ModelAttribute("persn")
    public Page<Person> data(ModelMap model,
                             @PageableDefault(value = 5, page = 0, sort = {"id"}) Pageable pageable) {
        Page<Person> persons = personDAO.findAll(pageable);
        Page<Person> prsns = personDAO.findAll(new PageRequest(0, 20));
        listPersons = prsns.getContent();

        if (!listPersons.isEmpty()) {
            model.addAttribute("listPersons", listPersons);

        }

        //model.addAttribute("listPersons", listPersons);
        return persons;
    }


    @RequestMapping(value="/person/getPeople", method = RequestMethod.POST)
    public @ResponseBody List<Person> getPeople(@RequestParam String term, HttpServletResponse response) {
        System.out.println("Term entered is: " + term);
        return simulateSearchResult(term.toLowerCase());
    }

    private List simulateSearchResult(String pName) {

        List result = new ArrayList();

        for (Person p : listPersons) {
            if (p.getName().contains(pName)) {
                result.add(p.getName());
            }
        }
        return result;
    }

    @RequestMapping(value="/person/edit/{id}" , method = RequestMethod.GET )
    public String savePerson(ModelMap model, @PathVariable("id") int id)
    {

        Person person = personDAO.findOne(id);
        personDAO.save(person);
        model.put("person", person);

        showPics(id, model);
        return "Update";

    }


    @RequestMapping(value="/person/save/{id}", method = RequestMethod.POST )
    public String save(ModelMap model, @RequestParam String name,
                       @Valid @ModelAttribute("addPerson") Person p,
                       BindingResult bindingResult, @RequestParam String country) {
        model.put("person", p);
        if (bindingResult.hasErrors()) {
            System.out.println("error saving: " + bindingResult.getAllErrors());
            return "Update";
        } else {


            Person dude = personDAO.findOne(p.getId());
            dude.setName(name);
            dude.setCountry(country);
            personDAO.save(dude);
            model.put("addPerson", dude);
            return "redirect:/";

        }
    }

    @ModelAttribute("persn")
    @RequestMapping(value="/person", method = RequestMethod.GET)
    public String loadPersonPage() {
        sortByIdAsc();
        return "person";
    }

    @RequestMapping(value="/person/add", method = RequestMethod.POST)
    public String addPerson( @RequestParam String name, @RequestParam String country) {
       /* if (bindingResult.hasErrors()) {
            System.out.println("Errors: " + bindingResult.getAllErrors());
            return "person";
        }*/
        personDAO.save(new Person(name, country));
        return "redirect:/home";
    }

    @RequestMapping(value="/imag/upload/{id}", method = RequestMethod.GET)
    public String uploadImg(ModelMap model, @PathVariable("id") int id) {
        model.put("prsn_id", id);
        return "imag";
    }

    @RequestMapping(value="/search{id}" , method = RequestMethod.GET )
    public String search(@RequestParam String id, ModelMap model)
            throws ServletException, IOException {

        try {

            if(personDAO.findByNameIgnoringCase(id)==null) {
                int intId = Integer.parseInt(id); // fucking boxing
                if (personDAO.findOne(intId) != null) {
                    showPics(intId, model);
                    return "Update";
                }

                return "Update"; // return something else, searchbyname
            }
            else {
                List<Person> listP = personDAO.findAll();
                List<Person> persons = listP.stream().filter(prsn ->
                        prsn.getName().toUpperCase().contains(id.toUpperCase())).collect(Collectors.toList());
                for (Person person : persons) {
                    showPics(person.getId(), model);
                }
                //showPics(id, model);
                return "Update";
            }
        } catch (NonUniqueResultException nure) {
            //
        }
        return "Update";
    }

    private String showPics(String id, ModelMap model) {
        int prsn_id = 0;

        Person person = personDAO.findByNameIgnoringCase(id);
        prsn_id = person.getId();

        model.put("person", person);

        listImages = imagDAO.findAll();
        personImages = imagDAO.findAllById(prsn_id);
        List<String> convImages = new ArrayList<>();

        for(byte[] imag : personImages) {
            String base64Image = Base64Utils.encodeToString(imag);
            model.put("personImag", imag);
            convImages.add(base64Image);
        }

        model.put("personImages", convImages);

        return "Update";
    }

    private String showPics(int id, ModelMap model) {
        Person person = personDAO.findOne(id);
        model.put("person", person);

        listImages = imagDAO.findAll();
        personImages = imagDAO.findAllById(id);
        List<String> convImages = new ArrayList<>();

        for(byte[] imag : personImages) {
            String base64Image = Base64Utils.encodeToString(imag);
            model.put("personImag", imag);
            convImages.add(base64Image);
        }

        model.put("personImages", convImages);

        return "Update";
    }

    @RequestMapping(value="/person/remove/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") int id, ModelMap model) {
        personDAO.delete(id);
        //showPics(id, model);

        return "redirect:/person";
    }

}
