package br.com.italopatricio.grapqhl

import com.netflix.graphql.dgs.DgsDataLoader
import org.dataloader.BatchLoader
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage


@DgsDataLoader(name = "productsOfBatchDataLoader")
class ProductBatchLoader: BatchLoader<Int, Product> {

    @Autowired
    lateinit var productService: ProductService

    override fun load(keys: List<Int>): CompletionStage<List<Product>>? {
        println("ProductBatchLoader.load")
        return CompletableFuture.supplyAsync { return@supplyAsync productService.getProductsBySellersId(keys) }
    }

}