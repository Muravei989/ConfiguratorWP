package de.energie.ritter.configuratorwp.controller;


import de.energie.ritter.configuratorwp.model.FormData;
import de.energie.ritter.configuratorwp.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @Autowired
    DocService doc;

    @GetMapping("/form-page")
    public String initialPage() {return "form-page";}

    @PostMapping("/submit")
    public String handleForm(@ModelAttribute("formData") FormData formData, ModelMap model) {
        String offerLink = doc.generateOffer(formData);
        model.addAttribute("fileLink", offerLink);
        return "result";
    }
}
