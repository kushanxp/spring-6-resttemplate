package guru.springframework.spring6resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerDTOList;
import guru.springframework.spring6resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;

    private final static String BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(BEER_PATH);

        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), Map.class);

        ResponseEntity<JsonNode> jsonEntity = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), JsonNode.class);

        jsonEntity.getBody().findPath("content").elements().forEachRemaining(node -> {
            System.out.println(node.get("beerName").asText());
        });


        BeerDTOList beerDTOList = restTemplate.getForObject(uriComponentsBuilder.toUriString(), BeerDTOList.class);
        ResponseEntity<BeerDTOList> responseList = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOList.class);
        ResponseEntity<BeerDTOPageImpl> responseListImpl = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

        System.out.println(beerDTOList);
        System.out.println(responseList);

        return responseListImpl.getBody();
    }
}
