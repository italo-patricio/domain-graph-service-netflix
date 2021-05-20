package br.com.italopatricio.mseller;

import br.com.italopatricio.mseller.models.Seller;
import br.com.italopatricio.mseller.models.Product;
import com.netflix.graphql.dgs.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DgsComponent
public class MyGraphQLComponent {
    private List<Seller> sellers = Arrays.asList(
            new Seller(1, "Lojinha AA", Arrays.asList(1,3,4,5)),
            new Seller(2, "Lojinha BB", Arrays.asList(2)),
            new Seller(3, "Lojinha CC", Arrays.asList())
    );

    @DgsData(parentType = "Query", field = "sellers")
    public List<Seller> buyers(@InputArgument(name = "nameFilter") String nameFilter) {
        if(nameFilter != null) {
            return sellers.stream()
                    .filter(it -> it.getName().contains(nameFilter))
                    .collect(Collectors.toList());
        } else {
            return sellers;
        }
    }

}
