package ru.ryzhko.dkb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ryzhko.dkb.dao.CodeExampleDAO;

@Controller
public class FirstController {

    // внедрить DAO в контроллер.
    private final CodeExampleDAO codeExampleDAO;
    public FirstController(CodeExampleDAO codeExampleDAO) {
        this.codeExampleDAO = codeExampleDAO;
    }

    @GetMapping("/code")
    public String index(Model model){
        // получить все примеры кода и отобразить их.
        model.addAttribute("codeExample", CodeExampleDAO.index());
        return "main/code_page";
    }
    @GetMapping("/article")
    public String articlePage(){
        return "main/article_page";
    }

    @GetMapping("/books")
    public String booksPage(){
        return "main/books_page";
    }
}
