package br.com.christian.firstapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<ProgrammingLanguage, String>{
    
}
