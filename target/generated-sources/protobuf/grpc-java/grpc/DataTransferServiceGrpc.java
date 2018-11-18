package grpc;

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
    comments = "Source: FileTransfer.proto")
public final class DataTransferServiceGrpc {

  private DataTransferServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.DataTransferService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.FileTransfer.FileInfo,
      grpc.FileTransfer.FileLocationInfo> METHOD_REQUEST_FILE_INFO =
      io.grpc.MethodDescriptor.<grpc.FileTransfer.FileInfo, grpc.FileTransfer.FileLocationInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.DataTransferService", "RequestFileInfo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileLocationInfo.getDefaultInstance()))
          .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("RequestFileInfo"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.FileTransfer.FileInfo,
      grpc.FileTransfer.FileLocationInfo> METHOD_GET_FILE_LOCATION =
      io.grpc.MethodDescriptor.<grpc.FileTransfer.FileInfo, grpc.FileTransfer.FileLocationInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.DataTransferService", "GetFileLocation"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileLocationInfo.getDefaultInstance()))
          .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("GetFileLocation"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.FileTransfer.ChunkInfo,
      grpc.FileTransfer.FileMetaData> METHOD_DOWNLOAD_CHUNK =
      io.grpc.MethodDescriptor.<grpc.FileTransfer.ChunkInfo, grpc.FileTransfer.FileMetaData>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "grpc.DataTransferService", "DownloadChunk"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.ChunkInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileMetaData.getDefaultInstance()))
          .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("DownloadChunk"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.FileTransfer.FileUploadData,
      grpc.FileTransfer.FileInfo> METHOD_UPLOAD_FILE =
      io.grpc.MethodDescriptor.<grpc.FileTransfer.FileUploadData, grpc.FileTransfer.FileInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "grpc.DataTransferService", "UploadFile"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileUploadData.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileInfo.getDefaultInstance()))
          .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("UploadFile"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.FileTransfer.RequestFileList,
      grpc.FileTransfer.FileList> METHOD_LIST_FILES =
      io.grpc.MethodDescriptor.<grpc.FileTransfer.RequestFileList, grpc.FileTransfer.FileList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.DataTransferService", "ListFiles"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.RequestFileList.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileList.getDefaultInstance()))
          .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("ListFiles"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.FileTransfer.FileUploadInfo,
      grpc.FileTransfer.ProxyList> METHOD_REQUEST_FILE_UPLOAD =
      io.grpc.MethodDescriptor.<grpc.FileTransfer.FileUploadInfo, grpc.FileTransfer.ProxyList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.DataTransferService", "RequestFileUpload"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.FileUploadInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.FileTransfer.ProxyList.getDefaultInstance()))
          .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("RequestFileUpload"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataTransferServiceStub newStub(io.grpc.Channel channel) {
    return new DataTransferServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTransferServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DataTransferServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataTransferServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DataTransferServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DataTransferServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * From team's client to team's own cluster
     * </pre>
     */
    public void requestFileInfo(grpc.FileTransfer.FileInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileLocationInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REQUEST_FILE_INFO, responseObserver);
    }

    /**
     * <pre>
     * From team-1 cluster to rest of the nodes of other teams
     * </pre>
     */
    public void getFileLocation(grpc.FileTransfer.FileInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileLocationInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FILE_LOCATION, responseObserver);
    }

    /**
     * <pre>
     * From team's client to the actual data-center node (can be any team's node)
     * </pre>
     */
    public void downloadChunk(grpc.FileTransfer.ChunkInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileMetaData> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DOWNLOAD_CHUNK, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.FileTransfer.FileUploadData> uploadFile(
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileInfo> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_UPLOAD_FILE, responseObserver);
    }

    /**
     * <pre>
     * Interteam request
     * </pre>
     */
    public void listFiles(grpc.FileTransfer.RequestFileList request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_FILES, responseObserver);
    }

    /**
     * <pre>
     * Request File upload get back proxy list to
     * return proxylist when raft consensus is reached
     * </pre>
     */
    public void requestFileUpload(grpc.FileTransfer.FileUploadInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.ProxyList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REQUEST_FILE_UPLOAD, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REQUEST_FILE_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.FileTransfer.FileInfo,
                grpc.FileTransfer.FileLocationInfo>(
                  this, METHODID_REQUEST_FILE_INFO)))
          .addMethod(
            METHOD_GET_FILE_LOCATION,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.FileTransfer.FileInfo,
                grpc.FileTransfer.FileLocationInfo>(
                  this, METHODID_GET_FILE_LOCATION)))
          .addMethod(
            METHOD_DOWNLOAD_CHUNK,
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.FileTransfer.ChunkInfo,
                grpc.FileTransfer.FileMetaData>(
                  this, METHODID_DOWNLOAD_CHUNK)))
          .addMethod(
            METHOD_UPLOAD_FILE,
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.FileTransfer.FileUploadData,
                grpc.FileTransfer.FileInfo>(
                  this, METHODID_UPLOAD_FILE)))
          .addMethod(
            METHOD_LIST_FILES,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.FileTransfer.RequestFileList,
                grpc.FileTransfer.FileList>(
                  this, METHODID_LIST_FILES)))
          .addMethod(
            METHOD_REQUEST_FILE_UPLOAD,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.FileTransfer.FileUploadInfo,
                grpc.FileTransfer.ProxyList>(
                  this, METHODID_REQUEST_FILE_UPLOAD)))
          .build();
    }
  }

  /**
   */
  public static final class DataTransferServiceStub extends io.grpc.stub.AbstractStub<DataTransferServiceStub> {
    private DataTransferServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * From team's client to team's own cluster
     * </pre>
     */
    public void requestFileInfo(grpc.FileTransfer.FileInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileLocationInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REQUEST_FILE_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * From team-1 cluster to rest of the nodes of other teams
     * </pre>
     */
    public void getFileLocation(grpc.FileTransfer.FileInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileLocationInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FILE_LOCATION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * From team's client to the actual data-center node (can be any team's node)
     * </pre>
     */
    public void downloadChunk(grpc.FileTransfer.ChunkInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileMetaData> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_DOWNLOAD_CHUNK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.FileTransfer.FileUploadData> uploadFile(
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileInfo> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_UPLOAD_FILE, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Interteam request
     * </pre>
     */
    public void listFiles(grpc.FileTransfer.RequestFileList request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_FILES, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Request File upload get back proxy list to
     * return proxylist when raft consensus is reached
     * </pre>
     */
    public void requestFileUpload(grpc.FileTransfer.FileUploadInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.ProxyList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REQUEST_FILE_UPLOAD, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataTransferServiceBlockingStub extends io.grpc.stub.AbstractStub<DataTransferServiceBlockingStub> {
    private DataTransferServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * From team's client to team's own cluster
     * </pre>
     */
    public grpc.FileTransfer.FileLocationInfo requestFileInfo(grpc.FileTransfer.FileInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REQUEST_FILE_INFO, getCallOptions(), request);
    }

    /**
     * <pre>
     * From team-1 cluster to rest of the nodes of other teams
     * </pre>
     */
    public grpc.FileTransfer.FileLocationInfo getFileLocation(grpc.FileTransfer.FileInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FILE_LOCATION, getCallOptions(), request);
    }

    /**
     * <pre>
     * From team's client to the actual data-center node (can be any team's node)
     * </pre>
     */
    public java.util.Iterator<grpc.FileTransfer.FileMetaData> downloadChunk(
        grpc.FileTransfer.ChunkInfo request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_DOWNLOAD_CHUNK, getCallOptions(), request);
    }

    /**
     * <pre>
     * Interteam request
     * </pre>
     */
    public grpc.FileTransfer.FileList listFiles(grpc.FileTransfer.RequestFileList request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_FILES, getCallOptions(), request);
    }

    /**
     * <pre>
     * Request File upload get back proxy list to
     * return proxylist when raft consensus is reached
     * </pre>
     */
    public grpc.FileTransfer.ProxyList requestFileUpload(grpc.FileTransfer.FileUploadInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REQUEST_FILE_UPLOAD, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataTransferServiceFutureStub extends io.grpc.stub.AbstractStub<DataTransferServiceFutureStub> {
    private DataTransferServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * From team's client to team's own cluster
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.FileTransfer.FileLocationInfo> requestFileInfo(
        grpc.FileTransfer.FileInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REQUEST_FILE_INFO, getCallOptions()), request);
    }

    /**
     * <pre>
     * From team-1 cluster to rest of the nodes of other teams
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.FileTransfer.FileLocationInfo> getFileLocation(
        grpc.FileTransfer.FileInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FILE_LOCATION, getCallOptions()), request);
    }

    /**
     * <pre>
     * Interteam request
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.FileTransfer.FileList> listFiles(
        grpc.FileTransfer.RequestFileList request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_FILES, getCallOptions()), request);
    }

    /**
     * <pre>
     * Request File upload get back proxy list to
     * return proxylist when raft consensus is reached
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.FileTransfer.ProxyList> requestFileUpload(
        grpc.FileTransfer.FileUploadInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REQUEST_FILE_UPLOAD, getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_FILE_INFO = 0;
  private static final int METHODID_GET_FILE_LOCATION = 1;
  private static final int METHODID_DOWNLOAD_CHUNK = 2;
  private static final int METHODID_LIST_FILES = 3;
  private static final int METHODID_REQUEST_FILE_UPLOAD = 4;
  private static final int METHODID_UPLOAD_FILE = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataTransferServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataTransferServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_FILE_INFO:
          serviceImpl.requestFileInfo((grpc.FileTransfer.FileInfo) request,
              (io.grpc.stub.StreamObserver<grpc.FileTransfer.FileLocationInfo>) responseObserver);
          break;
        case METHODID_GET_FILE_LOCATION:
          serviceImpl.getFileLocation((grpc.FileTransfer.FileInfo) request,
              (io.grpc.stub.StreamObserver<grpc.FileTransfer.FileLocationInfo>) responseObserver);
          break;
        case METHODID_DOWNLOAD_CHUNK:
          serviceImpl.downloadChunk((grpc.FileTransfer.ChunkInfo) request,
              (io.grpc.stub.StreamObserver<grpc.FileTransfer.FileMetaData>) responseObserver);
          break;
        case METHODID_LIST_FILES:
          serviceImpl.listFiles((grpc.FileTransfer.RequestFileList) request,
              (io.grpc.stub.StreamObserver<grpc.FileTransfer.FileList>) responseObserver);
          break;
        case METHODID_REQUEST_FILE_UPLOAD:
          serviceImpl.requestFileUpload((grpc.FileTransfer.FileUploadInfo) request,
              (io.grpc.stub.StreamObserver<grpc.FileTransfer.ProxyList>) responseObserver);
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
        case METHODID_UPLOAD_FILE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadFile(
              (io.grpc.stub.StreamObserver<grpc.FileTransfer.FileInfo>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DataTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataTransferServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.FileTransfer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataTransferService");
    }
  }

  private static final class DataTransferServiceFileDescriptorSupplier
      extends DataTransferServiceBaseDescriptorSupplier {
    DataTransferServiceFileDescriptorSupplier() {}
  }

  private static final class DataTransferServiceMethodDescriptorSupplier
      extends DataTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataTransferServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataTransferServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataTransferServiceFileDescriptorSupplier())
              .addMethod(METHOD_REQUEST_FILE_INFO)
              .addMethod(METHOD_GET_FILE_LOCATION)
              .addMethod(METHOD_DOWNLOAD_CHUNK)
              .addMethod(METHOD_UPLOAD_FILE)
              .addMethod(METHOD_LIST_FILES)
              .addMethod(METHOD_REQUEST_FILE_UPLOAD)
              .build();
        }
      }
    }
    return result;
  }
}
