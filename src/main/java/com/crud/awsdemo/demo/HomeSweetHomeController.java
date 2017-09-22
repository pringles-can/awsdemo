package com.crud.awsdemo.demo;

import com.crud.awsdemo.dao.ImagDAO;
import com.crud.awsdemo.dao.PersonDAO;
//import org.hibernate.validator.constraints.NotBlank;
import com.crud.awsdemo.spring.model.Imag;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Size;
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

    private String imgUrl;
    private List<Person> listPersons;

    private List<Imag> listImages;
    private List<byte[]> personImages;

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
    @Valid
    @ModelAttribute("person")
    public Page<Person> data(ModelMap model,
                             @PageableDefault(value = 5, page = 0, sort = {"id"}) Pageable pageable) {
        Page<Person> persons = personDAO.findAll(pageable);
        Page<Person> prsns = personDAO.findAll(new PageRequest(0, 20));
        listPersons = prsns.getContent();

        model.addAttribute("listPersons", listPersons);
        return persons;
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
    public String save(@PathVariable("id") int id,  @RequestParam String name,
                        @RequestParam String country) {

        /*if (bindingResult.hasErrors()) {
            return "person";

        } else*/
            if (name.length() > 20 || country.length() > 30) {
            return "updateerror";

        } else {
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
    }

    @RequestMapping(value="/imag/upload/{id}", method = RequestMethod.GET)
    public String uploadImg(ModelMap model, @PathVariable("id") int id) {
        model.put("prsn_id", id);
        return "imag";
    }

    @RequestMapping(value="/search{id}" , method = RequestMethod.GET )
    public String search(@RequestParam int id, ModelMap model)
            throws ServletException, IOException {

        if(personDAO.findOne(id)==null) {

            return "searcherr"; // return something else, searchbyname
        }

        else {
            showPics(id, model);
            return "Update";
        }
    }

    @RequestMapping(value="/search" , method = RequestMethod.GET )
    public String search(@RequestParam String id, ModelMap model)
            throws ServletException, IOException {

        if(personDAO.findByName(id)==null) {

            return "searcherr"; // return something else, searchbyname
        }

        else {
            showPics(id, model);

            return "Update";
        }
    }

    private String showPics(String id, ModelMap model) {
        int prsn_id = 0;
        Person person = personDAO.findByName(id);
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
    public String removePerson(@PathVariable("id") int id, ModelMap model) {
        personDAO.delete(id);
        //showPics(id, model);

        return "redirect:/person";
    }

}
