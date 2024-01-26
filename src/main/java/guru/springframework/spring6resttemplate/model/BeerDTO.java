package guru.springframework.spring6resttemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
public class BeerDTO implements Serializable {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("beerName")
    private String beerName;

    @JsonProperty("beerStyle")
    private BeerStyle beerStyle;

    @JsonProperty("upc")
    private String upc;

    @JsonProperty("quantityOnHand")
    private Integer quantityOnHand;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("createdDate")
    private LocalDateTime createdDate;

    @JsonProperty("updateDate")
    private LocalDateTime updateDate;
}
