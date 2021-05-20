package br.com.italopatricio.grapqhl

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsDataLoader
import graphql.GraphQLException
import org.dataloader.BatchLoader
import org.dataloader.MappedBatchLoader
import org.dataloader.Try
import org.springframework.beans.factory.annotation.Autowired
import java.lang.Exception
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.stream.Collectors
import kotlin.streams.toList

@DgsDataLoader(name = "productsOfBatchDataLoader")
class ProductBatchLoader: BatchLoader<Int, Product> {

    @Autowired
    lateinit var productService: ProductService

    override fun load(keys: List<Int>): CompletionStage<List<Product>>? {
        println("ProductBatchLoader.load")
        return CompletableFuture.supplyAsync { productService.productsByIds(keys) }
    }

}