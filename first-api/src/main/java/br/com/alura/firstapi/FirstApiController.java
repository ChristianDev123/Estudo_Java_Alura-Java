package br.com.alura.firstapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApiController {
    
    @Autowired
    private LanguageRepository repository;

    @GetMapping(value = "/languages")
    public List<ProgrammingLanguage> getLanguages(){
        return repository.findAll();
    }

    @PostMapping("/languages")
    public ProgrammingLanguage registerLanguage(@RequestBody ProgrammingLanguage language){
        ProgrammingLanguage savedLanguage = repository.save(language);
        return savedLanguage;
    }
    
}
