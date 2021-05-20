const { ApolloServer, gql } = require('apollo-server');
const { ApolloGateway } = require('@apollo/gateway')

const DataLoader = require('dataloader');

const typeDefs = require('./typedefs');
const resolvers = require('./resolvers');


const gateway = new ApolloGateway({
    serviceList: [
        { name: 'products', url: 'http://localhost:8082/graphql' },
        { name: 'sellers', url: 'http://localhost:8083/graphql' },
    ]
});

const server = new ApolloServer({ gateway, subscriptions:false });


// const server = new ApolloServer({
//     typeDefs,
//     resolvers,
//     subscriptions: false,
// });


const port = 8081
server.listen({ port }).then(() => {
    console.log(`O servidor esta rodando em http://localhost:${port}`);
});