package com.crud.awsdemo.demo;


import com.crud.awsdemo.dao.ImagDAO;
import com.crud.awsdemo.dao.PersonDAO;
import com.crud.awsdemo.spring.model.Imag;
import com.crud.awsdemo.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ImagController  {


    ImagDAO imagDAO;

    PersonDAO personDAO;

    @Autowired
    public ImagController(ImagDAO imagDAO) {
        this.imagDAO = imagDAO;
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
