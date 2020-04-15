package hmo.cache.service;

import hmo.cache.domain.dto.ExampleDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class ExampleService {

    @Autowired
    private ExampleDtoResource exampleDtoResource;

    @Cacheable(cacheNames = "myExampleCache", key="#name")
    public Optional<ExampleDto> findExample(String name) {
        log.info("findExample [{}]", name);
        return (exampleDtoResource.findExampleDto(name));
    }

    public ExampleDto createExample(String name, String description) {
        log.info("createExample: name [{}], description [{}]", name, description);
        return exampleDtoResource.createExampleDto(name, description);
    }

}
