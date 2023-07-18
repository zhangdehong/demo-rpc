package com.hong.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: Feature.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FeatureServiceGrpc {

  private FeatureServiceGrpc() {}

  public static final String SERVICE_NAME = "FeatureService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.hong.grpc.generated.FeatureProto.FeatureRequest,
      com.hong.grpc.generated.FeatureProto.FeatureResponse> getFeatureTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "featureTest",
      requestType = com.hong.grpc.generated.FeatureProto.FeatureRequest.class,
      responseType = com.hong.grpc.generated.FeatureProto.FeatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hong.grpc.generated.FeatureProto.FeatureRequest,
      com.hong.grpc.generated.FeatureProto.FeatureResponse> getFeatureTestMethod() {
    io.grpc.MethodDescriptor<com.hong.grpc.generated.FeatureProto.FeatureRequest, com.hong.grpc.generated.FeatureProto.FeatureResponse> getFeatureTestMethod;
    if ((getFeatureTestMethod = FeatureServiceGrpc.getFeatureTestMethod) == null) {
      synchronized (FeatureServiceGrpc.class) {
        if ((getFeatureTestMethod = FeatureServiceGrpc.getFeatureTestMethod) == null) {
          FeatureServiceGrpc.getFeatureTestMethod = getFeatureTestMethod =
              io.grpc.MethodDescriptor.<com.hong.grpc.generated.FeatureProto.FeatureRequest, com.hong.grpc.generated.FeatureProto.FeatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "featureTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hong.grpc.generated.FeatureProto.FeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hong.grpc.generated.FeatureProto.FeatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureServiceMethodDescriptorSupplier("featureTest"))
              .build();
        }
      }
    }
    return getFeatureTestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FeatureServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeatureServiceStub>() {
        @java.lang.Override
        public FeatureServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeatureServiceStub(channel, callOptions);
        }
      };
    return FeatureServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeatureServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeatureServiceBlockingStub>() {
        @java.lang.Override
        public FeatureServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeatureServiceBlockingStub(channel, callOptions);
        }
      };
    return FeatureServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FeatureServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeatureServiceFutureStub>() {
        @java.lang.Override
        public FeatureServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeatureServiceFutureStub(channel, callOptions);
        }
      };
    return FeatureServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void featureTest(com.hong.grpc.generated.FeatureProto.FeatureRequest request,
        io.grpc.stub.StreamObserver<com.hong.grpc.generated.FeatureProto.FeatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFeatureTestMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FeatureService.
   */
  public static abstract class FeatureServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FeatureServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FeatureService.
   */
  public static final class FeatureServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FeatureServiceStub> {
    private FeatureServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureServiceStub(channel, callOptions);
    }

    /**
     */
    public void featureTest(com.hong.grpc.generated.FeatureProto.FeatureRequest request,
        io.grpc.stub.StreamObserver<com.hong.grpc.generated.FeatureProto.FeatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFeatureTestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FeatureService.
   */
  public static final class FeatureServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FeatureServiceBlockingStub> {
    private FeatureServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.hong.grpc.generated.FeatureProto.FeatureResponse featureTest(com.hong.grpc.generated.FeatureProto.FeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFeatureTestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FeatureService.
   */
  public static final class FeatureServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FeatureServiceFutureStub> {
    private FeatureServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hong.grpc.generated.FeatureProto.FeatureResponse> featureTest(
        com.hong.grpc.generated.FeatureProto.FeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFeatureTestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FEATURE_TEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FEATURE_TEST:
          serviceImpl.featureTest((com.hong.grpc.generated.FeatureProto.FeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.hong.grpc.generated.FeatureProto.FeatureResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFeatureTestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.hong.grpc.generated.FeatureProto.FeatureRequest,
              com.hong.grpc.generated.FeatureProto.FeatureResponse>(
                service, METHODID_FEATURE_TEST)))
        .build();
  }

  private static abstract class FeatureServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeatureServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.hong.grpc.generated.FeatureProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeatureService");
    }
  }

  private static final class FeatureServiceFileDescriptorSupplier
      extends FeatureServiceBaseDescriptorSupplier {
    FeatureServiceFileDescriptorSupplier() {}
  }

  private static final class FeatureServiceMethodDescriptorSupplier
      extends FeatureServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FeatureServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FeatureServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FeatureServiceFileDescriptorSupplier())
              .addMethod(getFeatureTestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
