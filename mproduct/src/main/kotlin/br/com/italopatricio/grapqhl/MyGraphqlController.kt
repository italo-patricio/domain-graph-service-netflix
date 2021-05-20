package br.com.italopatricio.grapqhl

import com.netflix.graphql.dgs.*
import graphql.schema.DataFetchingEnvironment
import org.dataloader.BatchLoader
import org.dataloader.DataLoader
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.CompletableFuture

@DgsComponent
class MyGraphqlController {

    @Autowired
    lateinit var productService: ProductService

    @DgsQuery
    fun products(@InputArgument titleFilter : String?): List<Product> {
      return productService.products(titleFilter)
    }

    @DgsEntityFetcher(name = "Seller")
    fun seller(values: Map<String, Object>): Seller {
        println("DgsEntityFetcher id=" + values["id"])
        return Seller(values["id"] as Int)
    }

    @DgsData(parentType = "Seller", field = "productsOf")
    fun productsOf(dfe: DataFetchingEnvironment): List<Product> {
        val dataLoader = dfe.getSource<Seller>()

        println("DgsData id =" + dataLoader.id)

        return productService.getProductsBySellerId(dataLoader.id)
    }

    @DgsData(parentType = "Seller", field = "productsOfBatchDataLoader")
    fun productsOfBatchDataLoaderFetcher(dfe: DataFetchingEnvironment): CompletableFuture<List<Product>> {
        println("productsOfBatchDataLoaderFetcher")
        val productsDataLoader: DataLoader<Int, List<Product>> = dfe.getDataLoader("productsOfBatchDataLoader")
        val seller = dfe.getSource<Seller>()
        return productsDataLoader.load(seller.id)
    }

}


