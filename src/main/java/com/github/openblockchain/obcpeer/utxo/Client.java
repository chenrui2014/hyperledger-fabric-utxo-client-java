package com.github.openblockchain.obcpeer.utxo;

import java.util.Base64;

import io.grpc.ManagedChannel;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import protos.Chaincode.ChaincodeID;
import protos.Chaincode.ChaincodeInput;
import protos.Chaincode.ChaincodeInvocationSpec;
import protos.Chaincode.ChaincodeSpec;
import protos.DevopsGrpc;
import protos.DevopsGrpc.DevopsBlockingStub;

public class Client {


	private DevopsBlockingStub dbs;

	public Client(String host, int port) {
		ManagedChannel channel = NettyChannelBuilder.forAddress(host, port).negotiationType(NegotiationType.PLAINTEXT).build();
		this.dbs = DevopsGrpc.newBlockingStub(channel);
	}

	public void invoke(String chaincodeName, byte[] transaction) {
		String encodedTransaction = Base64.getEncoder().encodeToString(transaction);

		ChaincodeID.Builder chaincodeId = ChaincodeID.newBuilder();
		chaincodeId.setName(chaincodeName);

		ChaincodeInput.Builder chaincodeInput = ChaincodeInput.newBuilder();
		chaincodeInput.setFunction("execute");
		chaincodeInput.addArgs(encodedTransaction);

		ChaincodeSpec.Builder chaincodeSpec = ChaincodeSpec.newBuilder();
		chaincodeSpec.setChaincodeID(chaincodeId);
		chaincodeSpec.setCtorMsg(chaincodeInput);

		ChaincodeInvocationSpec.Builder chaincodeInvocationSpec = ChaincodeInvocationSpec.newBuilder();
		chaincodeInvocationSpec.setChaincodeSpec(chaincodeSpec);

		dbs.invoke(chaincodeInvocationSpec.build());
	}

}
