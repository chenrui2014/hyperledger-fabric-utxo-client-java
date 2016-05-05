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
public class PeerGrpc {

  private PeerGrpc() {}

  public static final String SERVICE_NAME = "protos.Peer";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<protos.Fabric.Message,
      protos.Fabric.Message> METHOD_CHAT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "protos.Peer", "Chat"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Fabric.Message.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Fabric.Message.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<protos.Fabric.Transaction,
      protos.Fabric.Response> METHOD_PROCESS_TRANSACTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protos.Peer", "ProcessTransaction"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Fabric.Transaction.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Fabric.Response.getDefaultInstance()));

  public static PeerStub newStub(io.grpc.Channel channel) {
    return new PeerStub(channel);
  }

  public static PeerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PeerBlockingStub(channel);
  }

  public static PeerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PeerFutureStub(channel);
  }

  public static interface Peer {

    public io.grpc.stub.StreamObserver<protos.Fabric.Message> chat(
        io.grpc.stub.StreamObserver<protos.Fabric.Message> responseObserver);

    public void processTransaction(protos.Fabric.Transaction request,
        io.grpc.stub.StreamObserver<protos.Fabric.Response> responseObserver);
  }

  public static interface PeerBlockingClient {

    public protos.Fabric.Response processTransaction(protos.Fabric.Transaction request);
  }

  public static interface PeerFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<protos.Fabric.Response> processTransaction(
        protos.Fabric.Transaction request);
  }

  public static class PeerStub extends io.grpc.stub.AbstractStub<PeerStub>
      implements Peer {
    private PeerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PeerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PeerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PeerStub(channel, callOptions);
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<protos.Fabric.Message> chat(
        io.grpc.stub.StreamObserver<protos.Fabric.Message> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_CHAT, getCallOptions()), responseObserver);
    }

    @java.lang.Override
    public void processTransaction(protos.Fabric.Transaction request,
        io.grpc.stub.StreamObserver<protos.Fabric.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PROCESS_TRANSACTION, getCallOptions()), request, responseObserver);
    }
  }

  public static class PeerBlockingStub extends io.grpc.stub.AbstractStub<PeerBlockingStub>
      implements PeerBlockingClient {
    private PeerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PeerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PeerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PeerBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public protos.Fabric.Response processTransaction(protos.Fabric.Transaction request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_PROCESS_TRANSACTION, getCallOptions()), request);
    }
  }

  public static class PeerFutureStub extends io.grpc.stub.AbstractStub<PeerFutureStub>
      implements PeerFutureClient {
    private PeerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PeerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PeerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PeerFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<protos.Fabric.Response> processTransaction(
        protos.Fabric.Transaction request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PROCESS_TRANSACTION, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final Peer serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_CHAT,
        asyncBidiStreamingCall(
          new io.grpc.stub.ServerCalls.BidiStreamingMethod<
              protos.Fabric.Message,
              protos.Fabric.Message>() {
            @java.lang.Override
            public io.grpc.stub.StreamObserver<protos.Fabric.Message> invoke(
                io.grpc.stub.StreamObserver<protos.Fabric.Message> responseObserver) {
              return serviceImpl.chat(responseObserver);
            }
          }))
      .addMethod(
        METHOD_PROCESS_TRANSACTION,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              protos.Fabric.Transaction,
              protos.Fabric.Response>() {
            @java.lang.Override
            public void invoke(
                protos.Fabric.Transaction request,
                io.grpc.stub.StreamObserver<protos.Fabric.Response> responseObserver) {
              serviceImpl.processTransaction(request, responseObserver);
            }
          })).build();
  }
}
