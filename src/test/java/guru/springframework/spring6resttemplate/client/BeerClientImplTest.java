package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerDTOList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    private BeerClient beerClient;
    @Test
    void listBeers() {
        beerClient.listBeers("077XX");
    }

    @Test
    void getBeerById() {
        BeerDTOList beerDTOList = beerClient.listBeerList();
        BeerDTO beerDTO = beerClient.getBeerById(beerDTOList.getBeerDTOS().get(0).getId());
        System.out.println(beerDTO.toString());
    }
}