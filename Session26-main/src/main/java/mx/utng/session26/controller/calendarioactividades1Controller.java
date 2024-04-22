package mx.utng.session26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.session26.model.entity.calendarioactividades1;
import mx.utng.session26.model.service.Icalendarioactividades1Service;

@Controller
@SessionAttributes("calendarioactividades1")
public class calendarioactividades1Controller {

    @Autowired
    private Icalendarioactividades1Service service;

    @GetMapping({"/calendarioactividades1", "/calendarioactividades1/", "/calendarioactividades1/list"})
    public String list(Model model) {
        model.addAttribute("title", "Activity Calendar List");
        model.addAttribute("calendarioactividades1s", service.list());
        return "calendarioactividades1-list";
    }

    @GetMapping("/calendarioactividades1/form")
    public String create(Model model) {
        model.addAttribute("title", "Activity Calendar Form");
        model.addAttribute("calendarioactividades1", new calendarioactividades1());
        return "calendarioactividades1-form";
    }

    @PostMapping("/calendarioactividades1/form")
    public String save(@Valid calendarioactividades1 calendarioactividades1, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("title", "Activity Calendar Form");
            return "calendarioactividades1-form";
        }
        service.save(calendarioactividades1);
        return "redirect:/calendarioactividades1/list";
    }

    @GetMapping("/calendarioactividades1/form/{id}")
    public String update(@PathVariable Long id, Model model) {
        calendarioactividades1 calendarioactividades1 = null;
        if (id > 0) {
            calendarioactividades1 = service.getById(id);
        } else {
            return "redirect:/calendarioactividades1/list";
        }
        model.addAttribute("title", "Edit Activity Calendar");
        model.addAttribute("calendarioactividades1", calendarioactividades1);
        return "calendarioactividades1-form";
    }

    @GetMapping("/calendarioactividades1/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/calendarioactividades1/list";
    }
}
