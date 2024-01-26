package guru.springframework.spring6resttemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class BeerDTOList{

    @JsonProperty("content")
    private List<BeerDTO> beerDTOS;

}
