package com.crud.awsdemo.demo;


import com.crud.awsdemo.dao.ImagDAO;
import com.crud.awsdemo.spring.model.Imag;
import com.crud.awsdemo.spring.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImagController  {
    ImagDAO imagDAO;

    @RequestMapping(value="piss/imag/upload{id}", method = RequestMethod.POST)
    public String uploadImg(ModelMap model, @PathVariable("id") int id) {
        Imag imag = imagDAO.findOne(id);
        model.put("Imag", imag);

        return "redirect:/person";
    }

    /*@RequestMapping(value="/imag/associate{id}", method=RequestMethod.GET)
    public */

}
