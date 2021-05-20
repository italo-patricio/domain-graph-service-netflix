const { gql } = require("apollo-server")

module.exports = gql`
    type Query {
        products: [Product]!
        sellers: [Seller]
    }

    type Product {
        id: ID!
        title: String!
        seller: Seller
        type: String!
    }

    type Seller {
        id: ID
        name: String
        productsWithSeller: [Product]
    }

`