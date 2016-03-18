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
  public static final io.grpc.MethodDescriptor<protos.Openchain.OpenchainMessage,
      protos.Openchain.OpenchainMessage> METHOD_CHAT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "protos.Peer", "Chat"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Openchain.OpenchainMessage.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Openchain.OpenchainMessage.getDefaultInstance()));

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

    public io.grpc.stub.StreamObserver<protos.Openchain.OpenchainMessage> chat(
        io.grpc.stub.StreamObserver<protos.Openchain.OpenchainMessage> responseObserver);
  }

  public static interface PeerBlockingClient {
  }

  public static interface PeerFutureClient {
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
    public io.grpc.stub.StreamObserver<protos.Openchain.OpenchainMessage> chat(
        io.grpc.stub.StreamObserver<protos.Openchain.OpenchainMessage> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_CHAT, getCallOptions()), responseObserver);
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
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final Peer serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_CHAT,
        asyncBidiStreamingCall(
          new io.grpc.stub.ServerCalls.BidiStreamingMethod<
              protos.Openchain.OpenchainMessage,
              protos.Openchain.OpenchainMessage>() {
            @java.lang.Override
            public io.grpc.stub.StreamObserver<protos.Openchain.OpenchainMessage> invoke(
                io.grpc.stub.StreamObserver<protos.Openchain.OpenchainMessage> responseObserver) {
              return serviceImpl.chat(responseObserver);
            }
          })).build();
  }
}
