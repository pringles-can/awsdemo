package com.crud.awsdemo.demo;


import com.crud.awsdemo.dao.ImagDAO;
import com.crud.awsdemo.dao.PersonDAO;
import com.crud.awsdemo.spring.model.Imag;
import com.crud.awsdemo.spring.model.Person;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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


    /*@ModelAttribute("personImages")
    @RequestMapping(value = "/imag/populate")
    public void imagData(ModelMap model) { // make onLoad() or some shit in the Update view, map to something here
        //List<Imag> listImages = imagDAO.findAll();
        model.addAttribute("personImages", personImages);

    }*/


/*
    @RequestMapping(value = "/imag/lode", method = RequestMethod.GET)
    public void onLoad(ModelMap model, @RequestParam("id") int id,
                       HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listImages = imagDAO.findAll();
        personImages = imagDAO.findAllById(id);
        List<String> convImages = new ArrayList<>();
        Person person = personDAO.findOne(id);

        response.setContentType("image/jpeg, image/jpg, image/png");
        for(Imag imag : personImages) {
            response.getOutputStream().write(imag.getImg());
            byte[] imageArray = Base64Utils.encode(imag.getImg());
            String base64Image = new String(imageArray, "UTF-8");
            model.put("personImag", imag);
            convImages.add(base64Image);
        }
        response.getOutputStream().close();
        model.put("personImages", convImages);

    }*/

    @RequestMapping(value="/imag/upload/{prsn_id}", method = RequestMethod.POST)
    public String uploadImg( @PathVariable("prsn_id") int id, @RequestParam MultipartFile image)
    throws IOException {


        if (image.isEmpty()) {
            return "person";
        } else {
            Imag img = new Imag(image.getBytes());
            img.setPrsn_id(id);
            imagDAO.save(img);
        }

        return "redirect:/person";
    }





}
