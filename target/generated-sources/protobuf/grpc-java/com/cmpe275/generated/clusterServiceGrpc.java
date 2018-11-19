package com.cmpe275.generated;

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
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: team.proto")
public final class clusterServiceGrpc {

  private clusterServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.clusterService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.cmpe275.generated.Heartbeat,
      com.cmpe275.generated.Heartbeat> METHOD_LIVELINESS =
      io.grpc.MethodDescriptor.<com.cmpe275.generated.Heartbeat, com.cmpe275.generated.Heartbeat>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.clusterService", "Liveliness"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.cmpe275.generated.Heartbeat.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.cmpe275.generated.Heartbeat.getDefaultInstance()))
          .setSchemaDescriptor(new clusterServiceMethodDescriptorSupplier("Liveliness"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.cmpe275.generated.ChunkData,
      com.cmpe275.generated.ChunkDataResponse> METHOD_UPDATE_CHUNK_DATA =
      io.grpc.MethodDescriptor.<com.cmpe275.generated.ChunkData, com.cmpe275.generated.ChunkDataResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.clusterService", "updateChunkData"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.cmpe275.generated.ChunkData.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.cmpe275.generated.ChunkDataResponse.getDefaultInstance()))
          .setSchemaDescriptor(new clusterServiceMethodDescriptorSupplier("updateChunkData"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.cmpe275.generated.FileQuery,
      com.cmpe275.generated.FileResponse> METHOD_IS_FILE_PRESENT =
      io.grpc.MethodDescriptor.<com.cmpe275.generated.FileQuery, com.cmpe275.generated.FileResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.clusterService", "isFilePresent"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.cmpe275.generated.FileQuery.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.cmpe275.generated.FileResponse.getDefaultInstance()))
          .setSchemaDescriptor(new clusterServiceMethodDescriptorSupplier("isFilePresent"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static clusterServiceStub newStub(io.grpc.Channel channel) {
    return new clusterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static clusterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new clusterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static clusterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new clusterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class clusterServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * to detect if servers are live
     * </pre>
     */
    public void liveliness(com.cmpe275.generated.Heartbeat request,
        io.grpc.stub.StreamObserver<com.cmpe275.generated.Heartbeat> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIVELINESS, responseObserver);
    }

    /**
     * <pre>
     * used to change the isAvailable flag in the
     * coordination server's table:
     * PrimaryKey | FileName | ChunkID | MaxChunk | isAvailable | IP | Port
     * </pre>
     */
    public void updateChunkData(com.cmpe275.generated.ChunkData request,
        io.grpc.stub.StreamObserver<com.cmpe275.generated.ChunkDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_CHUNK_DATA, responseObserver);
    }

    /**
     * <pre>
     * rpc to get the location of chunks for a file
     * </pre>
     */
    public void isFilePresent(com.cmpe275.generated.FileQuery request,
        io.grpc.stub.StreamObserver<com.cmpe275.generated.FileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_IS_FILE_PRESENT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LIVELINESS,
            asyncUnaryCall(
              new MethodHandlers<
                com.cmpe275.generated.Heartbeat,
                com.cmpe275.generated.Heartbeat>(
                  this, METHODID_LIVELINESS)))
          .addMethod(
            METHOD_UPDATE_CHUNK_DATA,
            asyncUnaryCall(
              new MethodHandlers<
                com.cmpe275.generated.ChunkData,
                com.cmpe275.generated.ChunkDataResponse>(
                  this, METHODID_UPDATE_CHUNK_DATA)))
          .addMethod(
            METHOD_IS_FILE_PRESENT,
            asyncUnaryCall(
              new MethodHandlers<
                com.cmpe275.generated.FileQuery,
                com.cmpe275.generated.FileResponse>(
                  this, METHODID_IS_FILE_PRESENT)))
          .build();
    }
  }

  /**
   */
  public static final class clusterServiceStub extends io.grpc.stub.AbstractStub<clusterServiceStub> {
    private clusterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clusterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clusterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clusterServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * to detect if servers are live
     * </pre>
     */
    public void liveliness(com.cmpe275.generated.Heartbeat request,
        io.grpc.stub.StreamObserver<com.cmpe275.generated.Heartbeat> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIVELINESS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * used to change the isAvailable flag in the
     * coordination server's table:
     * PrimaryKey | FileName | ChunkID | MaxChunk | isAvailable | IP | Port
     * </pre>
     */
    public void updateChunkData(com.cmpe275.generated.ChunkData request,
        io.grpc.stub.StreamObserver<com.cmpe275.generated.ChunkDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_CHUNK_DATA, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * rpc to get the location of chunks for a file
     * </pre>
     */
    public void isFilePresent(com.cmpe275.generated.FileQuery request,
        io.grpc.stub.StreamObserver<com.cmpe275.generated.FileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_IS_FILE_PRESENT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class clusterServiceBlockingStub extends io.grpc.stub.AbstractStub<clusterServiceBlockingStub> {
    private clusterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clusterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clusterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clusterServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * to detect if servers are live
     * </pre>
     */
    public com.cmpe275.generated.Heartbeat liveliness(com.cmpe275.generated.Heartbeat request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIVELINESS, getCallOptions(), request);
    }

    /**
     * <pre>
     * used to change the isAvailable flag in the
     * coordination server's table:
     * PrimaryKey | FileName | ChunkID | MaxChunk | isAvailable | IP | Port
     * </pre>
     */
    public com.cmpe275.generated.ChunkDataResponse updateChunkData(com.cmpe275.generated.ChunkData request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_CHUNK_DATA, getCallOptions(), request);
    }

    /**
     * <pre>
     * rpc to get the location of chunks for a file
     * </pre>
     */
    public com.cmpe275.generated.FileResponse isFilePresent(com.cmpe275.generated.FileQuery request) {
      return blockingUnaryCall(
          getChannel(), METHOD_IS_FILE_PRESENT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class clusterServiceFutureStub extends io.grpc.stub.AbstractStub<clusterServiceFutureStub> {
    private clusterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clusterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clusterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clusterServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * to detect if servers are live
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cmpe275.generated.Heartbeat> liveliness(
        com.cmpe275.generated.Heartbeat request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIVELINESS, getCallOptions()), request);
    }

    /**
     * <pre>
     * used to change the isAvailable flag in the
     * coordination server's table:
     * PrimaryKey | FileName | ChunkID | MaxChunk | isAvailable | IP | Port
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cmpe275.generated.ChunkDataResponse> updateChunkData(
        com.cmpe275.generated.ChunkData request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_CHUNK_DATA, getCallOptions()), request);
    }

    /**
     * <pre>
     * rpc to get the location of chunks for a file
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cmpe275.generated.FileResponse> isFilePresent(
        com.cmpe275.generated.FileQuery request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_IS_FILE_PRESENT, getCallOptions()), request);
    }
  }

  private static final int METHODID_LIVELINESS = 0;
  private static final int METHODID_UPDATE_CHUNK_DATA = 1;
  private static final int METHODID_IS_FILE_PRESENT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final clusterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(clusterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIVELINESS:
          serviceImpl.liveliness((com.cmpe275.generated.Heartbeat) request,
              (io.grpc.stub.StreamObserver<com.cmpe275.generated.Heartbeat>) responseObserver);
          break;
        case METHODID_UPDATE_CHUNK_DATA:
          serviceImpl.updateChunkData((com.cmpe275.generated.ChunkData) request,
              (io.grpc.stub.StreamObserver<com.cmpe275.generated.ChunkDataResponse>) responseObserver);
          break;
        case METHODID_IS_FILE_PRESENT:
          serviceImpl.isFilePresent((com.cmpe275.generated.FileQuery) request,
              (io.grpc.stub.StreamObserver<com.cmpe275.generated.FileResponse>) responseObserver);
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

  private static abstract class clusterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    clusterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cmpe275.generated.Team.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("clusterService");
    }
  }

  private static final class clusterServiceFileDescriptorSupplier
      extends clusterServiceBaseDescriptorSupplier {
    clusterServiceFileDescriptorSupplier() {}
  }

  private static final class clusterServiceMethodDescriptorSupplier
      extends clusterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    clusterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (clusterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new clusterServiceFileDescriptorSupplier())
              .addMethod(METHOD_LIVELINESS)
              .addMethod(METHOD_UPDATE_CHUNK_DATA)
              .addMethod(METHOD_IS_FILE_PRESENT)
              .build();
        }
      }
    }
    return result;
  }
}
