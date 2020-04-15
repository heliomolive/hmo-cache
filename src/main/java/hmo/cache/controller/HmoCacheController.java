package hmo.cache.controller;

import hmo.cache.domain.dto.ExampleDto;
import hmo.cache.domain.exception.NotFoundException;
import hmo.cache.service.ExampleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class HmoCacheController {
    private static final String V1 = "/v1";

    @Autowired
    private ExampleService exampleService;

    @GetMapping(V1 + "/example")
    @ResponseStatus(HttpStatus.OK)
    public ExampleDto getExample(@RequestParam String name) {
        log.info("Processing getExample for name [{}]", name);
        return exampleService.findExample(name).orElseThrow(NotFoundException::new);
    }

    @PostMapping(V1 + "/example")
    @ResponseStatus(HttpStatus.CREATED)
    public ExampleDto createExample(@RequestBody @Valid ExampleDto request) {
        log.info("Processing createExample: [{}]", request);
        return exampleService.createExample(request.getName(), request.getDescription());
    }

}
