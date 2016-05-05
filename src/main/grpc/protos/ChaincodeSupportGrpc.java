package protos;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class ChaincodeSupportGrpc {

  private ChaincodeSupportGrpc() {}

  public static final String SERVICE_NAME = "protos.ChaincodeSupport";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<protos.Chaincode.ChaincodeMessage,
      protos.Chaincode.ChaincodeMessage> METHOD_REGISTER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "protos.ChaincodeSupport", "Register"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Chaincode.ChaincodeMessage.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Chaincode.ChaincodeMessage.getDefaultInstance()));

  public static ChaincodeSupportStub newStub(io.grpc.Channel channel) {
    return new ChaincodeSupportStub(channel);
  }

  public static ChaincodeSupportBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChaincodeSupportBlockingStub(channel);
  }

  public static ChaincodeSupportFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChaincodeSupportFutureStub(channel);
  }

  public static interface ChaincodeSupport {

    public io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeMessage> register(
        io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeMessage> responseObserver);
  }

  public static interface ChaincodeSupportBlockingClient {
  }

  public static interface ChaincodeSupportFutureClient {
  }

  public static class ChaincodeSupportStub extends io.grpc.stub.AbstractStub<ChaincodeSupportStub>
      implements ChaincodeSupport {
    private ChaincodeSupportStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChaincodeSupportStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChaincodeSupportStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChaincodeSupportStub(channel, callOptions);
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeMessage> register(
        io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeMessage> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_REGISTER, getCallOptions()), responseObserver);
    }
  }

  public static class ChaincodeSupportBlockingStub extends io.grpc.stub.AbstractStub<ChaincodeSupportBlockingStub>
      implements ChaincodeSupportBlockingClient {
    private ChaincodeSupportBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChaincodeSupportBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChaincodeSupportBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChaincodeSupportBlockingStub(channel, callOptions);
    }
  }

  public static class ChaincodeSupportFutureStub extends io.grpc.stub.AbstractStub<ChaincodeSupportFutureStub>
      implements ChaincodeSupportFutureClient {
    private ChaincodeSupportFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChaincodeSupportFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChaincodeSupportFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChaincodeSupportFutureStub(channel, callOptions);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final ChaincodeSupport serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_REGISTER,
        asyncBidiStreamingCall(
          new io.grpc.stub.ServerCalls.BidiStreamingMethod<
              protos.Chaincode.ChaincodeMessage,
              protos.Chaincode.ChaincodeMessage>() {
            @java.lang.Override
            public io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeMessage> invoke(
                io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeMessage> responseObserver) {
              return serviceImpl.register(responseObserver);
            }
          })).build();
  }
}
