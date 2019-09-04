package com.tbuk.grpc.psd2Transfer;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: transfer.proto")
public final class TransferServiceGrpc {

  private TransferServiceGrpc() {}

  public static final String SERVICE_NAME = "com.tbuk.grpc.psd2Transfer.TransferService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest,
      com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse> getTransferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transfer",
      requestType = com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest.class,
      responseType = com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest,
      com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse> getTransferMethod() {
    io.grpc.MethodDescriptor<com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest, com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse> getTransferMethod;
    if ((getTransferMethod = TransferServiceGrpc.getTransferMethod) == null) {
      synchronized (TransferServiceGrpc.class) {
        if ((getTransferMethod = TransferServiceGrpc.getTransferMethod) == null) {
          TransferServiceGrpc.getTransferMethod = getTransferMethod = 
              io.grpc.MethodDescriptor.<com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest, com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.tbuk.grpc.psd2Transfer.TransferService", "transfer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TransferServiceMethodDescriptorSupplier("transfer"))
                  .build();
          }
        }
     }
     return getTransferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest,
      com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse> getTransferStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transferStatus",
      requestType = com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest.class,
      responseType = com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest,
      com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse> getTransferStatusMethod() {
    io.grpc.MethodDescriptor<com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest, com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse> getTransferStatusMethod;
    if ((getTransferStatusMethod = TransferServiceGrpc.getTransferStatusMethod) == null) {
      synchronized (TransferServiceGrpc.class) {
        if ((getTransferStatusMethod = TransferServiceGrpc.getTransferStatusMethod) == null) {
          TransferServiceGrpc.getTransferStatusMethod = getTransferStatusMethod = 
              io.grpc.MethodDescriptor.<com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest, com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.tbuk.grpc.psd2Transfer.TransferService", "transferStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TransferServiceMethodDescriptorSupplier("transferStatus"))
                  .build();
          }
        }
     }
     return getTransferStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransferServiceStub newStub(io.grpc.Channel channel) {
    return new TransferServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransferServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TransferServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransferServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TransferServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TransferServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void transfer(com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest request,
        io.grpc.stub.StreamObserver<com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTransferMethod(), responseObserver);
    }

    /**
     */
    public void transferStatus(com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest request,
        io.grpc.stub.StreamObserver<com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTransferStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTransferMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest,
                com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse>(
                  this, METHODID_TRANSFER)))
          .addMethod(
            getTransferStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest,
                com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse>(
                  this, METHODID_TRANSFER_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class TransferServiceStub extends io.grpc.stub.AbstractStub<TransferServiceStub> {
    private TransferServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransferServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransferServiceStub(channel, callOptions);
    }

    /**
     */
    public void transfer(com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest request,
        io.grpc.stub.StreamObserver<com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void transferStatus(com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest request,
        io.grpc.stub.StreamObserver<com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransferStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransferServiceBlockingStub extends io.grpc.stub.AbstractStub<TransferServiceBlockingStub> {
    private TransferServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransferServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransferServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse transfer(com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest request) {
      return blockingUnaryCall(
          getChannel(), getTransferMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse transferStatus(com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getTransferStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransferServiceFutureStub extends io.grpc.stub.AbstractStub<TransferServiceFutureStub> {
    private TransferServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransferServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransferServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse> transfer(
        com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse> transferStatus(
        com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTransferStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSFER = 0;
  private static final int METHODID_TRANSFER_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransferServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransferServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRANSFER:
          serviceImpl.transfer((com.tbuk.grpc.psd2Transfer.Transfer.TransferRequest) request,
              (io.grpc.stub.StreamObserver<com.tbuk.grpc.psd2Transfer.Transfer.TransferResponse>) responseObserver);
          break;
        case METHODID_TRANSFER_STATUS:
          serviceImpl.transferStatus((com.tbuk.grpc.psd2Transfer.Transfer.PaymentStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.tbuk.grpc.psd2Transfer.Transfer.TransferStatusResponse>) responseObserver);
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

  private static abstract class TransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransferServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.tbuk.grpc.psd2Transfer.Transfer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransferService");
    }
  }

  private static final class TransferServiceFileDescriptorSupplier
      extends TransferServiceBaseDescriptorSupplier {
    TransferServiceFileDescriptorSupplier() {}
  }

  private static final class TransferServiceMethodDescriptorSupplier
      extends TransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransferServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TransferServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransferServiceFileDescriptorSupplier())
              .addMethod(getTransferMethod())
              .addMethod(getTransferStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
