package ru.ryzhko.dkb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ryzhko.dkb.dao.CodeExampleDAO;

@Controller

public class CodeExampleController {

    // внедрить DAO в контроллер.
    private final CodeExampleDAO codeExampleDAO;
    public CodeExampleController(CodeExampleDAO codeExampleDAO) {
        this.codeExampleDAO = codeExampleDAO;
    }

    @GetMapping()
    public String index(Model model){
        // получить все примеры кода и отобразить их.
        model.addAttribute("codeExampleList", CodeExampleDAO.index());
        return "main/code_page";
    }

    @GetMapping("/code/{id}")
    public String showContent(@PathVariable("id") int id, Model model){
        // получить один пример кода по айди из ДАО.
        model.addAttribute("codeExample", codeExampleDAO.show(id));
        return "personal/code_example";
    }

}
