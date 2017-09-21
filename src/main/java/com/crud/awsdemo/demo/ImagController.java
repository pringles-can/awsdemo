package com.crud.awsdemo.demo;


import com.crud.awsdemo.dao.ImagDAO;
import com.crud.awsdemo.dao.PersonDAO;
import com.crud.awsdemo.spring.model.Imag;
import com.crud.awsdemo.spring.model.Person;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
public class ImagController  {


    ImagDAO imagDAO;


    private List<Imag> listImages;
    private List<Imag> personImages;

    PersonDAO personDAO;

    @Autowired
    public ImagController(ImagDAO imagDAO) {
        this.imagDAO = imagDAO;

    }


    @ModelAttribute("personImage")
    public void imagData(ModelMap model) { // make onLoad() or some shit in the Update view, map to something here
        //List<Imag> listImages = imagDAO.findAll();
        model.addAttribute("listImages", listImages);

    }

    @RequestMapping(value = "/imag/load/{prsn_id}", method = RequestMethod.GET)
    public void onLoad(ModelMap model, @PathVariable("id") int id) {
        listImages = imagDAO.findAll();
        personImages = imagDAO.findAllById(id);

        model.put("personImages", personImages);

    }

    @RequestMapping(value="/imag/upload/{prsn_id}", method = RequestMethod.POST)
    public String uploadImg( ModelMap model, @PathVariable("prsn_id") int id, @RequestParam byte[] image) {
        Imag img = new Imag(image);
        img.setPrsn_id(id);
        imagDAO.save(img);

        return "redirect:/person";
    }




    /*@RequestMapping(value="/imag/associate{id}", method=RequestMethod.GET)
    public */

}
