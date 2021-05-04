package br.com.italopatricio.mbuyer;

import br.com.italopatricio.mbuyer.models.Buyer;
import br.com.italopatricio.mbuyer.models.Product;
import com.netflix.graphql.dgs.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DgsComponent
public class MyGraphQLComponent {
    private List<Buyer> buyers = Arrays.asList(
            new Buyer(1, "Lojinha AA", "1000"),
            new Buyer(2, "Lojinha BB", "1001"),
            new Buyer(3, "Lojinha CC", "2000")
    );

    @DgsQuery()
    public List<Buyer> buyers(@InputArgument(name = "nameFilter") String nameFilter) {
        if(nameFilter != null) {
            return buyers.stream()
                    .filter(it -> it.getName().contains(nameFilter))
                    .collect(Collectors.toList());
        } else {
            return buyers;
        }
    }

    // relation many-to-one
    @DgsEntityFetcher(name = "Product")
    public Product buyer(Map<String, Object> values) {
        return new Product(0, (int) values.get("buyerId"));
    }

    @DgsData(parentType = "Product", field = "buyer")
    public Buyer buyerFetcher(DgsDataFetchingEnvironment dataFetchingEnvironment) {
        Product product = dataFetchingEnvironment.getSource();
        return buyers.stream()
                .filter(it -> it.getId() == product.getBuyerId())
                .findFirst()
                .get();
    }
    // relation many-to-one

    // @DgsEntityFetcher(name = "Buyer")
    // public Buyer character(Map<String, Object> values) {
    //     return new Buyer((String) values.get("characterId"));
    // }
    //
    // @DgsData(parentType = "Buyer", field = "character")
    // public Buyer characterFetcher(DgsDataFetchingEnvironment dataFetchingEnvironment) {
    //     // Buyer character = dataFetchingEnvironment.getSource();
    //     return buyers.stream()
    //             // .filter(it -> it.getId() == product.getBuyerId())
    //             .findFirst()
    //             .get();
    // }

}
