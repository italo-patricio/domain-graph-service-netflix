package br.com.italopatricio.mseller;

import br.com.italopatricio.mseller.models.Seller;
import br.com.italopatricio.mseller.models.Product;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

//@DgsComponent
//public class ProductDataFetcher {
//    @DgsData(parentType = "Seller", field = "product")
//    public CompletableFuture<Product> productFetch(DataFetchingEnvironment dfe) {
//        DataLoader<Integer, Product> dataLoader = dfe.getDataLoader("products");
//        Integer id = dfe.getArgument("id");
//
//        return dataLoader.load(id);
//    }
//
//    @DgsEntityFetcher(name = "Buyer")
//    public Seller buyerEntityFetch(Map<String, ?> values) {
//        return new Seller((Integer) values.get("id"));
//    }
//}
