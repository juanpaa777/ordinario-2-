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
import mx.utng.session26.model.entity.CompraOnline2;
import mx.utng.session26.model.service.ICompraOnline2Service;

import java.util.Date;

@Controller
@SessionAttributes("compraOnline2")
public class CompraOnline2Controller {

    @Autowired
    private ICompraOnline2Service service;

    @GetMapping({"/compraOnline2", "/compraOnline2/", "/compraOnline2/list"})
    public String list(Model model) {
        model.addAttribute("title", "Listado de Compras Online");
        model.addAttribute("comprasOnline2", service.list());
        return "compraOnline2-list";
    }

    @GetMapping("/compraOnline2/form")
    public String create(Model model) {
        model.addAttribute("title", "Formulario de Compras Online");
        model.addAttribute("compraOnline2", new CompraOnline2());
        return "compraOnline2-form";
    }

    @PostMapping("/compraOnline2/form")
    public String save(@Valid CompraOnline2 compraOnline2, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Compras Online");
            return "compraOnline2-form";
        }
        service.save(compraOnline2);
        return "redirect:/compraOnline2/list";
    }

    @GetMapping("/compraOnline2/form/{id}")
    public String update(@PathVariable Long id, Model model) {
        CompraOnline2 compraOnline2 = null;
        if (id > 0) {
            compraOnline2 = service.getById(id);
        } else {
            return "redirect:/compraOnline2/list";
        }
        model.addAttribute("title", "Editar Compra Online");
        model.addAttribute("compraOnline2", compraOnline2);
        return "compraOnline2-form";
    }

    @GetMapping("/compraOnline2/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/compraOnline2/list";
    }
}
