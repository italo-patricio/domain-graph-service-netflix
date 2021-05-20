const { products, sellers } = require('../data');
const DataLoader = require('dataloader');

// // Example with problem N + 1
// module.exports = {
//     Query: {
//         products: () => products,
//     },
//     Product: {
//         seller: (parent) => {
//             console.log(`fetching seller ${parent.id}`)
//             return sellers.find((seller) => seller.id === parent.sellerId)
//         },
//     }
// }



// Example solution of problem N + 1
const getSellerBatchId = async (keys) => {
    console.log(`fetching seller data loader ${keys.map(it => it.id).join(',')}`)
    const result = keys.map((product) => {
        return sellers.find((sellerFind) => sellerFind.id === product.sellerId)
    });
    return Promise.resolve(result)
}

const getProductBatchId = async (keys) => {
    console.log(`fetching product data loader ${keys.join(',')}`)
    const result = keys.map((seller) => {
        return products.filter((productFind) => productFind.sellerId === seller)
    });
    return Promise.resolve(result)
}

const sellerLoader = new DataLoader(getSellerBatchId);
const productLoader = new DataLoader(getProductBatchId);

module.exports = {
    Query: {
        products: () => products,
        sellers: () => sellers,
    },
    Product: {
        seller: async (parent) => {
            console.log(`parent ${parent.id}`)
            return await sellerLoader.load(parent)
        },
    },
    Seller: {
        productsWithSeller: (parent) => {
            return productLoader.load(parent.id)
        },
    }
}