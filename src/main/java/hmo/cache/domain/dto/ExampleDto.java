package hmo.cache.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDto implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private String description;

    private Long uid;
}
