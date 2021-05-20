package br.com.italopatricio.grapqhl;

import org.springframework.stereotype.Service;
import kotlin.streams.toList

interface ProductService {
    fun products(titleFilter: String?): List<Product>
    fun productsByIds(ids: List<Int>): List<Product>
    fun getProductsBySellerId(sellerId: Int): List<Product>
    fun getProductsBySellersId(sellersId: List<Int>): List<Product>
}

@Service
class ProductServiceImpl : ProductService {
    private val _products = listOf(
        Product(1, "Produto AA", 1),
        Product(2, "Produto BB", 2),
        Product(3, "Produto CC", 1),
        Product(4, "Produto DD", 1),
        Product(5, "Produto EE", 1)
    )

    override fun products(titleFilter: String?): List<Product> {
        println("ProductServiceImpl.products")
        return if (titleFilter != null) {
            _products.filter { it.title.contains(titleFilter) }
        } else {
            _products
        }
    }

    override fun productsByIds(ids: List<Int>): List<Product> {
        println("ProductServiceImpl.productByIds")
        return _products.filter { ids.any { i -> i == it.id  } }
    }

    override fun getProductsBySellerId(sellerId: Int): List<Product> {
        println("ProductServiceImpl.getProductsBySellerId")
        return _products.filter { it.sellerId == sellerId }
    }

    override fun getProductsBySellersId(sellersId: List<Int>): List<Product> {
        println("ProductServiceImpl.getProductsBySellersId")
        return _products.filter { sellersId.contains(it.sellerId) }
    }
}
