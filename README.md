### Hypereledger Fabric UTXO Chaincode Client

This demo client will read transactions from Bitcoin blocks on the local system and send the transactions to the [UTXO example chaincode](https://github.com/hyperledger/fabric/tree/master/examples/chaincode/go/utxo) for processing. It utilizes the gRPC API for communication between the client and Hypereledger Fabric peer.

Instructions

1. Deploy the [UTXO example chaincode](https://github.com/openblockchain/obc-peer/tree/master/examples/chaincode/go/utxo)

1. Clone this project
```
git clone https://github.com/srderson/obc-utxo-client-java.git
cd obc-utxo-client-java
```

1. Edit the config.properties file in ./src/main/java/com/github/srderson/hyperledger_fabric_utxo_client_java

2. Build
```
./gradlew build
```

3. Copy the config.properties file ./src/main/java/com/github/srderson/hyperledger_fabric_utxo_client_java/config.properties to ./build/classes/main/com/github/srderson/hyperledger_fabric_utxo_client_java/config.properties

4. Start the client
```
./gradlew run
```
