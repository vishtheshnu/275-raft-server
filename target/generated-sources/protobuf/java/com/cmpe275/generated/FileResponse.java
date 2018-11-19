// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: team.proto

package com.cmpe275.generated;

/**
 * Protobuf type {@code grpc.FileResponse}
 */
public  final class FileResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.FileResponse)
    FileResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FileResponse.newBuilder() to construct.
  private FileResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FileResponse() {
    isFound_ = false;
    chunks_ = java.util.Collections.emptyList();
    requestId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FileResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            isFound_ = input.readBool();
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              chunks_ = new java.util.ArrayList<com.cmpe275.generated.ChunkData>();
              mutable_bitField0_ |= 0x00000002;
            }
            chunks_.add(
                input.readMessage(com.cmpe275.generated.ChunkData.parser(), extensionRegistry));
            break;
          }
          case 32: {

            requestId_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        chunks_ = java.util.Collections.unmodifiableList(chunks_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cmpe275.generated.Team.internal_static_grpc_FileResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cmpe275.generated.Team.internal_static_grpc_FileResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cmpe275.generated.FileResponse.class, com.cmpe275.generated.FileResponse.Builder.class);
  }

  private int bitField0_;
  public static final int ISFOUND_FIELD_NUMBER = 1;
  private boolean isFound_;
  /**
   * <code>bool isFound = 1;</code>
   */
  public boolean getIsFound() {
    return isFound_;
  }

  public static final int CHUNKS_FIELD_NUMBER = 2;
  private java.util.List<com.cmpe275.generated.ChunkData> chunks_;
  /**
   * <code>repeated .grpc.ChunkData chunks = 2;</code>
   */
  public java.util.List<com.cmpe275.generated.ChunkData> getChunksList() {
    return chunks_;
  }
  /**
   * <code>repeated .grpc.ChunkData chunks = 2;</code>
   */
  public java.util.List<? extends com.cmpe275.generated.ChunkDataOrBuilder> 
      getChunksOrBuilderList() {
    return chunks_;
  }
  /**
   * <code>repeated .grpc.ChunkData chunks = 2;</code>
   */
  public int getChunksCount() {
    return chunks_.size();
  }
  /**
   * <code>repeated .grpc.ChunkData chunks = 2;</code>
   */
  public com.cmpe275.generated.ChunkData getChunks(int index) {
    return chunks_.get(index);
  }
  /**
   * <code>repeated .grpc.ChunkData chunks = 2;</code>
   */
  public com.cmpe275.generated.ChunkDataOrBuilder getChunksOrBuilder(
      int index) {
    return chunks_.get(index);
  }

  public static final int REQUESTID_FIELD_NUMBER = 4;
  private long requestId_;
  /**
   * <code>int64 requestId = 4;</code>
   */
  public long getRequestId() {
    return requestId_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (isFound_ != false) {
      output.writeBool(1, isFound_);
    }
    for (int i = 0; i < chunks_.size(); i++) {
      output.writeMessage(2, chunks_.get(i));
    }
    if (requestId_ != 0L) {
      output.writeInt64(4, requestId_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (isFound_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, isFound_);
    }
    for (int i = 0; i < chunks_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, chunks_.get(i));
    }
    if (requestId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, requestId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.cmpe275.generated.FileResponse)) {
      return super.equals(obj);
    }
    com.cmpe275.generated.FileResponse other = (com.cmpe275.generated.FileResponse) obj;

    boolean result = true;
    result = result && (getIsFound()
        == other.getIsFound());
    result = result && getChunksList()
        .equals(other.getChunksList());
    result = result && (getRequestId()
        == other.getRequestId());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ISFOUND_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsFound());
    if (getChunksCount() > 0) {
      hash = (37 * hash) + CHUNKS_FIELD_NUMBER;
      hash = (53 * hash) + getChunksList().hashCode();
    }
    hash = (37 * hash) + REQUESTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getRequestId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cmpe275.generated.FileResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cmpe275.generated.FileResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.FileResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.FileResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.cmpe275.generated.FileResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.FileResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.FileResponse)
      com.cmpe275.generated.FileResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cmpe275.generated.Team.internal_static_grpc_FileResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cmpe275.generated.Team.internal_static_grpc_FileResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cmpe275.generated.FileResponse.class, com.cmpe275.generated.FileResponse.Builder.class);
    }

    // Construct using com.cmpe275.generated.FileResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getChunksFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      isFound_ = false;

      if (chunksBuilder_ == null) {
        chunks_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        chunksBuilder_.clear();
      }
      requestId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cmpe275.generated.Team.internal_static_grpc_FileResponse_descriptor;
    }

    public com.cmpe275.generated.FileResponse getDefaultInstanceForType() {
      return com.cmpe275.generated.FileResponse.getDefaultInstance();
    }

    public com.cmpe275.generated.FileResponse build() {
      com.cmpe275.generated.FileResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.cmpe275.generated.FileResponse buildPartial() {
      com.cmpe275.generated.FileResponse result = new com.cmpe275.generated.FileResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.isFound_ = isFound_;
      if (chunksBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          chunks_ = java.util.Collections.unmodifiableList(chunks_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.chunks_ = chunks_;
      } else {
        result.chunks_ = chunksBuilder_.build();
      }
      result.requestId_ = requestId_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.cmpe275.generated.FileResponse) {
        return mergeFrom((com.cmpe275.generated.FileResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cmpe275.generated.FileResponse other) {
      if (other == com.cmpe275.generated.FileResponse.getDefaultInstance()) return this;
      if (other.getIsFound() != false) {
        setIsFound(other.getIsFound());
      }
      if (chunksBuilder_ == null) {
        if (!other.chunks_.isEmpty()) {
          if (chunks_.isEmpty()) {
            chunks_ = other.chunks_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureChunksIsMutable();
            chunks_.addAll(other.chunks_);
          }
          onChanged();
        }
      } else {
        if (!other.chunks_.isEmpty()) {
          if (chunksBuilder_.isEmpty()) {
            chunksBuilder_.dispose();
            chunksBuilder_ = null;
            chunks_ = other.chunks_;
            bitField0_ = (bitField0_ & ~0x00000002);
            chunksBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getChunksFieldBuilder() : null;
          } else {
            chunksBuilder_.addAllMessages(other.chunks_);
          }
        }
      }
      if (other.getRequestId() != 0L) {
        setRequestId(other.getRequestId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.cmpe275.generated.FileResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.cmpe275.generated.FileResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private boolean isFound_ ;
    /**
     * <code>bool isFound = 1;</code>
     */
    public boolean getIsFound() {
      return isFound_;
    }
    /**
     * <code>bool isFound = 1;</code>
     */
    public Builder setIsFound(boolean value) {
      
      isFound_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isFound = 1;</code>
     */
    public Builder clearIsFound() {
      
      isFound_ = false;
      onChanged();
      return this;
    }

    private java.util.List<com.cmpe275.generated.ChunkData> chunks_ =
      java.util.Collections.emptyList();
    private void ensureChunksIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        chunks_ = new java.util.ArrayList<com.cmpe275.generated.ChunkData>(chunks_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.cmpe275.generated.ChunkData, com.cmpe275.generated.ChunkData.Builder, com.cmpe275.generated.ChunkDataOrBuilder> chunksBuilder_;

    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public java.util.List<com.cmpe275.generated.ChunkData> getChunksList() {
      if (chunksBuilder_ == null) {
        return java.util.Collections.unmodifiableList(chunks_);
      } else {
        return chunksBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public int getChunksCount() {
      if (chunksBuilder_ == null) {
        return chunks_.size();
      } else {
        return chunksBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public com.cmpe275.generated.ChunkData getChunks(int index) {
      if (chunksBuilder_ == null) {
        return chunks_.get(index);
      } else {
        return chunksBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder setChunks(
        int index, com.cmpe275.generated.ChunkData value) {
      if (chunksBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChunksIsMutable();
        chunks_.set(index, value);
        onChanged();
      } else {
        chunksBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder setChunks(
        int index, com.cmpe275.generated.ChunkData.Builder builderForValue) {
      if (chunksBuilder_ == null) {
        ensureChunksIsMutable();
        chunks_.set(index, builderForValue.build());
        onChanged();
      } else {
        chunksBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder addChunks(com.cmpe275.generated.ChunkData value) {
      if (chunksBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChunksIsMutable();
        chunks_.add(value);
        onChanged();
      } else {
        chunksBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder addChunks(
        int index, com.cmpe275.generated.ChunkData value) {
      if (chunksBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChunksIsMutable();
        chunks_.add(index, value);
        onChanged();
      } else {
        chunksBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder addChunks(
        com.cmpe275.generated.ChunkData.Builder builderForValue) {
      if (chunksBuilder_ == null) {
        ensureChunksIsMutable();
        chunks_.add(builderForValue.build());
        onChanged();
      } else {
        chunksBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder addChunks(
        int index, com.cmpe275.generated.ChunkData.Builder builderForValue) {
      if (chunksBuilder_ == null) {
        ensureChunksIsMutable();
        chunks_.add(index, builderForValue.build());
        onChanged();
      } else {
        chunksBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder addAllChunks(
        java.lang.Iterable<? extends com.cmpe275.generated.ChunkData> values) {
      if (chunksBuilder_ == null) {
        ensureChunksIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, chunks_);
        onChanged();
      } else {
        chunksBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder clearChunks() {
      if (chunksBuilder_ == null) {
        chunks_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        chunksBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public Builder removeChunks(int index) {
      if (chunksBuilder_ == null) {
        ensureChunksIsMutable();
        chunks_.remove(index);
        onChanged();
      } else {
        chunksBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public com.cmpe275.generated.ChunkData.Builder getChunksBuilder(
        int index) {
      return getChunksFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public com.cmpe275.generated.ChunkDataOrBuilder getChunksOrBuilder(
        int index) {
      if (chunksBuilder_ == null) {
        return chunks_.get(index);  } else {
        return chunksBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public java.util.List<? extends com.cmpe275.generated.ChunkDataOrBuilder> 
         getChunksOrBuilderList() {
      if (chunksBuilder_ != null) {
        return chunksBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(chunks_);
      }
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public com.cmpe275.generated.ChunkData.Builder addChunksBuilder() {
      return getChunksFieldBuilder().addBuilder(
          com.cmpe275.generated.ChunkData.getDefaultInstance());
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public com.cmpe275.generated.ChunkData.Builder addChunksBuilder(
        int index) {
      return getChunksFieldBuilder().addBuilder(
          index, com.cmpe275.generated.ChunkData.getDefaultInstance());
    }
    /**
     * <code>repeated .grpc.ChunkData chunks = 2;</code>
     */
    public java.util.List<com.cmpe275.generated.ChunkData.Builder> 
         getChunksBuilderList() {
      return getChunksFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.cmpe275.generated.ChunkData, com.cmpe275.generated.ChunkData.Builder, com.cmpe275.generated.ChunkDataOrBuilder> 
        getChunksFieldBuilder() {
      if (chunksBuilder_ == null) {
        chunksBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.cmpe275.generated.ChunkData, com.cmpe275.generated.ChunkData.Builder, com.cmpe275.generated.ChunkDataOrBuilder>(
                chunks_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        chunks_ = null;
      }
      return chunksBuilder_;
    }

    private long requestId_ ;
    /**
     * <code>int64 requestId = 4;</code>
     */
    public long getRequestId() {
      return requestId_;
    }
    /**
     * <code>int64 requestId = 4;</code>
     */
    public Builder setRequestId(long value) {
      
      requestId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 requestId = 4;</code>
     */
    public Builder clearRequestId() {
      
      requestId_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.FileResponse)
  }

  // @@protoc_insertion_point(class_scope:grpc.FileResponse)
  private static final com.cmpe275.generated.FileResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cmpe275.generated.FileResponse();
  }

  public static com.cmpe275.generated.FileResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FileResponse>
      PARSER = new com.google.protobuf.AbstractParser<FileResponse>() {
    public FileResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new FileResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FileResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FileResponse> getParserForType() {
    return PARSER;
  }

  public com.cmpe275.generated.FileResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

