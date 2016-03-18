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
public class DevopsGrpc {

  private DevopsGrpc() {}

  public static final String SERVICE_NAME = "protos.Devops";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<protos.DevopsOuterClass.Secret,
      protos.Openchain.Response> METHOD_LOGIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protos.Devops", "Login"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.DevopsOuterClass.Secret.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Openchain.Response.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<protos.Chaincode.ChaincodeSpec,
      protos.Chaincode.ChaincodeDeploymentSpec> METHOD_BUILD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protos.Devops", "Build"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Chaincode.ChaincodeSpec.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Chaincode.ChaincodeDeploymentSpec.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<protos.Chaincode.ChaincodeSpec,
      protos.Chaincode.ChaincodeDeploymentSpec> METHOD_DEPLOY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protos.Devops", "Deploy"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Chaincode.ChaincodeSpec.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Chaincode.ChaincodeDeploymentSpec.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<protos.Chaincode.ChaincodeInvocationSpec,
      protos.Openchain.Response> METHOD_INVOKE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protos.Devops", "Invoke"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Chaincode.ChaincodeInvocationSpec.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Openchain.Response.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<protos.Chaincode.ChaincodeInvocationSpec,
      protos.Openchain.Response> METHOD_QUERY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protos.Devops", "Query"),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Chaincode.ChaincodeInvocationSpec.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(protos.Openchain.Response.getDefaultInstance()));

  public static DevopsStub newStub(io.grpc.Channel channel) {
    return new DevopsStub(channel);
  }

  public static DevopsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DevopsBlockingStub(channel);
  }

  public static DevopsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DevopsFutureStub(channel);
  }

  public static interface Devops {

    public void login(protos.DevopsOuterClass.Secret request,
        io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver);

    public void build(protos.Chaincode.ChaincodeSpec request,
        io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeDeploymentSpec> responseObserver);

    public void deploy(protos.Chaincode.ChaincodeSpec request,
        io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeDeploymentSpec> responseObserver);

    public void invoke(protos.Chaincode.ChaincodeInvocationSpec request,
        io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver);

    public void query(protos.Chaincode.ChaincodeInvocationSpec request,
        io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver);
  }

  public static interface DevopsBlockingClient {

    public protos.Openchain.Response login(protos.DevopsOuterClass.Secret request);

    public protos.Chaincode.ChaincodeDeploymentSpec build(protos.Chaincode.ChaincodeSpec request);

    public protos.Chaincode.ChaincodeDeploymentSpec deploy(protos.Chaincode.ChaincodeSpec request);

    public protos.Openchain.Response invoke(protos.Chaincode.ChaincodeInvocationSpec request);

    public protos.Openchain.Response query(protos.Chaincode.ChaincodeInvocationSpec request);
  }

  public static interface DevopsFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<protos.Openchain.Response> login(
        protos.DevopsOuterClass.Secret request);

    public com.google.common.util.concurrent.ListenableFuture<protos.Chaincode.ChaincodeDeploymentSpec> build(
        protos.Chaincode.ChaincodeSpec request);

    public com.google.common.util.concurrent.ListenableFuture<protos.Chaincode.ChaincodeDeploymentSpec> deploy(
        protos.Chaincode.ChaincodeSpec request);

    public com.google.common.util.concurrent.ListenableFuture<protos.Openchain.Response> invoke(
        protos.Chaincode.ChaincodeInvocationSpec request);

    public com.google.common.util.concurrent.ListenableFuture<protos.Openchain.Response> query(
        protos.Chaincode.ChaincodeInvocationSpec request);
  }

  public static class DevopsStub extends io.grpc.stub.AbstractStub<DevopsStub>
      implements Devops {
    private DevopsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DevopsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevopsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DevopsStub(channel, callOptions);
    }

    @java.lang.Override
    public void login(protos.DevopsOuterClass.Secret request,
        io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void build(protos.Chaincode.ChaincodeSpec request,
        io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeDeploymentSpec> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_BUILD, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deploy(protos.Chaincode.ChaincodeSpec request,
        io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeDeploymentSpec> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DEPLOY, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void invoke(protos.Chaincode.ChaincodeInvocationSpec request,
        io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INVOKE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void query(protos.Chaincode.ChaincodeInvocationSpec request,
        io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_QUERY, getCallOptions()), request, responseObserver);
    }
  }

  public static class DevopsBlockingStub extends io.grpc.stub.AbstractStub<DevopsBlockingStub>
      implements DevopsBlockingClient {
    private DevopsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DevopsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevopsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DevopsBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public protos.Openchain.Response login(protos.DevopsOuterClass.Secret request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request);
    }

    @java.lang.Override
    public protos.Chaincode.ChaincodeDeploymentSpec build(protos.Chaincode.ChaincodeSpec request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_BUILD, getCallOptions()), request);
    }

    @java.lang.Override
    public protos.Chaincode.ChaincodeDeploymentSpec deploy(protos.Chaincode.ChaincodeSpec request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DEPLOY, getCallOptions()), request);
    }

    @java.lang.Override
    public protos.Openchain.Response invoke(protos.Chaincode.ChaincodeInvocationSpec request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_INVOKE, getCallOptions()), request);
    }

    @java.lang.Override
    public protos.Openchain.Response query(protos.Chaincode.ChaincodeInvocationSpec request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_QUERY, getCallOptions()), request);
    }
  }

  public static class DevopsFutureStub extends io.grpc.stub.AbstractStub<DevopsFutureStub>
      implements DevopsFutureClient {
    private DevopsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DevopsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevopsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DevopsFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<protos.Openchain.Response> login(
        protos.DevopsOuterClass.Secret request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<protos.Chaincode.ChaincodeDeploymentSpec> build(
        protos.Chaincode.ChaincodeSpec request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_BUILD, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<protos.Chaincode.ChaincodeDeploymentSpec> deploy(
        protos.Chaincode.ChaincodeSpec request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DEPLOY, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<protos.Openchain.Response> invoke(
        protos.Chaincode.ChaincodeInvocationSpec request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INVOKE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<protos.Openchain.Response> query(
        protos.Chaincode.ChaincodeInvocationSpec request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_QUERY, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final Devops serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_LOGIN,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              protos.DevopsOuterClass.Secret,
              protos.Openchain.Response>() {
            @java.lang.Override
            public void invoke(
                protos.DevopsOuterClass.Secret request,
                io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver) {
              serviceImpl.login(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_BUILD,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              protos.Chaincode.ChaincodeSpec,
              protos.Chaincode.ChaincodeDeploymentSpec>() {
            @java.lang.Override
            public void invoke(
                protos.Chaincode.ChaincodeSpec request,
                io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeDeploymentSpec> responseObserver) {
              serviceImpl.build(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DEPLOY,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              protos.Chaincode.ChaincodeSpec,
              protos.Chaincode.ChaincodeDeploymentSpec>() {
            @java.lang.Override
            public void invoke(
                protos.Chaincode.ChaincodeSpec request,
                io.grpc.stub.StreamObserver<protos.Chaincode.ChaincodeDeploymentSpec> responseObserver) {
              serviceImpl.deploy(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_INVOKE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              protos.Chaincode.ChaincodeInvocationSpec,
              protos.Openchain.Response>() {
            @java.lang.Override
            public void invoke(
                protos.Chaincode.ChaincodeInvocationSpec request,
                io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver) {
              serviceImpl.invoke(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_QUERY,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              protos.Chaincode.ChaincodeInvocationSpec,
              protos.Openchain.Response>() {
            @java.lang.Override
            public void invoke(
                protos.Chaincode.ChaincodeInvocationSpec request,
                io.grpc.stub.StreamObserver<protos.Openchain.Response> responseObserver) {
              serviceImpl.query(request, responseObserver);
            }
          })).build();
  }
}
