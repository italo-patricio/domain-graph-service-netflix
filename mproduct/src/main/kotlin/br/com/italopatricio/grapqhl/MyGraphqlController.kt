package br.com.italopatricio.grapqhl

import com.netflix.dgs.codgen.generated.types.Product
import com.netflix.graphql.dgs.*

@DgsComponent
class MyGraphqlController {
    private val products = listOf(
            Product(1, "Produto AA", 1),
            Product(2, "Produto BB", 2),
            Product(3, "Produto CC", 1),
            Product(4, "Produto DD", 1),
            Product(5, "Produto EE", 1)
    )

    @DgsQuery
    fun products(@InputArgument titleFilter : String?): List<Product> {
        return if(titleFilter != null) {
            products.filter { it.title.contains(titleFilter) }
        } else {
            products
        }
    }

    // relation one-to-many
 //   @DgsEntityFetcher(name = "Product")
 //   fun buyerEntityFetch(values: Map<String?, Any?>): Buyer? {
 //       return Buyer(values["id"] as Int)
 //   }
 //
 //   @DgsData(parentType = "Query", field = "buyer")
 //   fun buyerData(dataFetchingEnvironment: DgsDataFetchingEnvironment): List<Product?>? {
 //       val buyer: Buyer = dataFetchingEnvironment.getSource()
 //       return products.stream()
 //           .filter({
 //               it.buyerId === buyer.id
 //           }).collect(Collectors.toList())
 //   }
    // relation one-to-many

}

data class Product(val id: Int, val title: String, val buyerId: Int)
