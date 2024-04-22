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
import mx.utng.session26.model.entity.DocumentoLegal1;
import mx.utng.session26.model.service.IDocumentoLegal1Service;

@Controller
@SessionAttributes("documentoLegal1")
public class DocumentoLegal1Controller {

    @Autowired
    private IDocumentoLegal1Service service;

    @GetMapping({"/documentoLegal1", "/documentoLegal1/", "/documentoLegal1/list"})
    public String list(Model model) {
        model.addAttribute("title", "Listado de Documentos Legales");
        model.addAttribute("documentosLegales1", service.list());
        return "documentoLegal1-list";
    }

    @GetMapping("/documentoLegal1/form")
    public String create(Model model) {
        model.addAttribute("title", "Formulario de Documentos Legales");
        model.addAttribute("documentoLegal1", new DocumentoLegal1());
        return "documentoLegal1-form";
    }

    @PostMapping("/documentoLegal1/form")
    public String save(@Valid DocumentoLegal1 documentoLegal1, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Documentos Legales");
            return "documentoLegal1-form";
        }
        service.save(documentoLegal1);
        return "redirect:/documentoLegal1/list";
    }

    @GetMapping("/documentoLegal1/form/{id}")
    public String update(@PathVariable String id, Model model) {
        DocumentoLegal1 documentoLegal1 = null;
        if (id != null && !id.isEmpty()) {
            documentoLegal1 = service.getById(id);
        } else {
            return "redirect:/documentoLegal1/list";
        }
        model.addAttribute("title", "Editar Documento Legal");
        model.addAttribute("documentoLegal1", documentoLegal1);
        return "documentoLegal1-form";
    }

    @GetMapping("/documentoLegal1/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        if (id != null && !id.isEmpty()) {
            service.delete(id);
        }
        return "redirect:/documentoLegal1/list";
    }
}
