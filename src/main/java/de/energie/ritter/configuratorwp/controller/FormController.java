package de.energie.ritter.configuratorwp.controller;


import de.energie.ritter.configuratorwp.model.FormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form-page")
    public String initialPage() {return "form-page";}

    @PostMapping("/submit")
    public String handleForm(@ModelAttribute("formData") FormData formData, ModelMap model) {
        model.addAttribute("heatload", formData.heatLoad());
        model.addAttribute("eblan", formData.isEblan());
        return "result";
    }
}
