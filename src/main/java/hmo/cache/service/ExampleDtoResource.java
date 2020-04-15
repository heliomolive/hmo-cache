package hmo.cache.service;

import hmo.cache.domain.dto.ExampleDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class maintains a mapping of objects for testing usage. This would normally represent a repository.
 */
@Log4j2
@Component
public class ExampleDtoResource {

    private Map<String, ExampleDto> examples = new HashMap<>();
    private AtomicLong exampleDtoUidGenerator = new AtomicLong(0);

    public ExampleDto createExampleDto(String name, String description) {
        log.info("createExampleDto: name [{}], description [{}]", name, description);
        ExampleDto exampleDto = ExampleDto.builder()
                .description(description)
                .name(name)
                .uid(exampleDtoUidGenerator.incrementAndGet())
                .build();
        examples.put(name, exampleDto);
        return exampleDto;
    }

    public Optional<ExampleDto> findExampleDto(String name) {
        log.info("findExampleDto [{}]", name);
        return Optional.ofNullable(examples.get(name));
    }
}
