// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: team.proto

package com.cmpe275.generated;

/**
 * <pre>
 * not being used in this proto but look at additional info for more
 * </pre>
 *
 * Protobuf type {@code grpc.Chunk}
 */
public  final class Chunk extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.Chunk)
    ChunkOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Chunk.newBuilder() to construct.
  private Chunk(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Chunk() {
    fileName_ = "";
    chunkId_ = 0L;
    maxChunks_ = 0L;
    seqNum_ = 0L;
    seqMax_ = 0L;
    data_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Chunk(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            fileName_ = s;
            break;
          }
          case 16: {

            chunkId_ = input.readInt64();
            break;
          }
          case 24: {

            maxChunks_ = input.readInt64();
            break;
          }
          case 32: {

            seqNum_ = input.readInt64();
            break;
          }
          case 40: {

            seqMax_ = input.readInt64();
            break;
          }
          case 50: {

            data_ = input.readBytes();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cmpe275.generated.Team.internal_static_grpc_Chunk_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cmpe275.generated.Team.internal_static_grpc_Chunk_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cmpe275.generated.Chunk.class, com.cmpe275.generated.Chunk.Builder.class);
  }

  public static final int FILENAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object fileName_;
  /**
   * <code>string fileName = 1;</code>
   */
  public java.lang.String getFileName() {
    java.lang.Object ref = fileName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fileName_ = s;
      return s;
    }
  }
  /**
   * <code>string fileName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getFileNameBytes() {
    java.lang.Object ref = fileName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      fileName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CHUNKID_FIELD_NUMBER = 2;
  private long chunkId_;
  /**
   * <code>int64 chunkId = 2;</code>
   */
  public long getChunkId() {
    return chunkId_;
  }

  public static final int MAXCHUNKS_FIELD_NUMBER = 3;
  private long maxChunks_;
  /**
   * <code>int64 maxChunks = 3;</code>
   */
  public long getMaxChunks() {
    return maxChunks_;
  }

  public static final int SEQNUM_FIELD_NUMBER = 4;
  private long seqNum_;
  /**
   * <code>int64 seqNum = 4;</code>
   */
  public long getSeqNum() {
    return seqNum_;
  }

  public static final int SEQMAX_FIELD_NUMBER = 5;
  private long seqMax_;
  /**
   * <code>int64 seqMax = 5;</code>
   */
  public long getSeqMax() {
    return seqMax_;
  }

  public static final int DATA_FIELD_NUMBER = 6;
  private com.google.protobuf.ByteString data_;
  /**
   * <code>bytes data = 6;</code>
   */
  public com.google.protobuf.ByteString getData() {
    return data_;
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
    if (!getFileNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, fileName_);
    }
    if (chunkId_ != 0L) {
      output.writeInt64(2, chunkId_);
    }
    if (maxChunks_ != 0L) {
      output.writeInt64(3, maxChunks_);
    }
    if (seqNum_ != 0L) {
      output.writeInt64(4, seqNum_);
    }
    if (seqMax_ != 0L) {
      output.writeInt64(5, seqMax_);
    }
    if (!data_.isEmpty()) {
      output.writeBytes(6, data_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getFileNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, fileName_);
    }
    if (chunkId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, chunkId_);
    }
    if (maxChunks_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, maxChunks_);
    }
    if (seqNum_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, seqNum_);
    }
    if (seqMax_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, seqMax_);
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(6, data_);
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
    if (!(obj instanceof com.cmpe275.generated.Chunk)) {
      return super.equals(obj);
    }
    com.cmpe275.generated.Chunk other = (com.cmpe275.generated.Chunk) obj;

    boolean result = true;
    result = result && getFileName()
        .equals(other.getFileName());
    result = result && (getChunkId()
        == other.getChunkId());
    result = result && (getMaxChunks()
        == other.getMaxChunks());
    result = result && (getSeqNum()
        == other.getSeqNum());
    result = result && (getSeqMax()
        == other.getSeqMax());
    result = result && getData()
        .equals(other.getData());
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
    hash = (37 * hash) + FILENAME_FIELD_NUMBER;
    hash = (53 * hash) + getFileName().hashCode();
    hash = (37 * hash) + CHUNKID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getChunkId());
    hash = (37 * hash) + MAXCHUNKS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMaxChunks());
    hash = (37 * hash) + SEQNUM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSeqNum());
    hash = (37 * hash) + SEQMAX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSeqMax());
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cmpe275.generated.Chunk parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.Chunk parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.Chunk parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.Chunk parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.Chunk parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.Chunk parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.Chunk parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.Chunk parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cmpe275.generated.Chunk parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.Chunk parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cmpe275.generated.Chunk parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.Chunk parseFrom(
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
  public static Builder newBuilder(com.cmpe275.generated.Chunk prototype) {
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
   * <pre>
   * not being used in this proto but look at additional info for more
   * </pre>
   *
   * Protobuf type {@code grpc.Chunk}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.Chunk)
      com.cmpe275.generated.ChunkOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cmpe275.generated.Team.internal_static_grpc_Chunk_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cmpe275.generated.Team.internal_static_grpc_Chunk_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cmpe275.generated.Chunk.class, com.cmpe275.generated.Chunk.Builder.class);
    }

    // Construct using com.cmpe275.generated.Chunk.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      fileName_ = "";

      chunkId_ = 0L;

      maxChunks_ = 0L;

      seqNum_ = 0L;

      seqMax_ = 0L;

      data_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cmpe275.generated.Team.internal_static_grpc_Chunk_descriptor;
    }

    public com.cmpe275.generated.Chunk getDefaultInstanceForType() {
      return com.cmpe275.generated.Chunk.getDefaultInstance();
    }

    public com.cmpe275.generated.Chunk build() {
      com.cmpe275.generated.Chunk result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.cmpe275.generated.Chunk buildPartial() {
      com.cmpe275.generated.Chunk result = new com.cmpe275.generated.Chunk(this);
      result.fileName_ = fileName_;
      result.chunkId_ = chunkId_;
      result.maxChunks_ = maxChunks_;
      result.seqNum_ = seqNum_;
      result.seqMax_ = seqMax_;
      result.data_ = data_;
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
      if (other instanceof com.cmpe275.generated.Chunk) {
        return mergeFrom((com.cmpe275.generated.Chunk)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cmpe275.generated.Chunk other) {
      if (other == com.cmpe275.generated.Chunk.getDefaultInstance()) return this;
      if (!other.getFileName().isEmpty()) {
        fileName_ = other.fileName_;
        onChanged();
      }
      if (other.getChunkId() != 0L) {
        setChunkId(other.getChunkId());
      }
      if (other.getMaxChunks() != 0L) {
        setMaxChunks(other.getMaxChunks());
      }
      if (other.getSeqNum() != 0L) {
        setSeqNum(other.getSeqNum());
      }
      if (other.getSeqMax() != 0L) {
        setSeqMax(other.getSeqMax());
      }
      if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
        setData(other.getData());
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
      com.cmpe275.generated.Chunk parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.cmpe275.generated.Chunk) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object fileName_ = "";
    /**
     * <code>string fileName = 1;</code>
     */
    public java.lang.String getFileName() {
      java.lang.Object ref = fileName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fileName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string fileName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFileNameBytes() {
      java.lang.Object ref = fileName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        fileName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string fileName = 1;</code>
     */
    public Builder setFileName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      fileName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string fileName = 1;</code>
     */
    public Builder clearFileName() {
      
      fileName_ = getDefaultInstance().getFileName();
      onChanged();
      return this;
    }
    /**
     * <code>string fileName = 1;</code>
     */
    public Builder setFileNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      fileName_ = value;
      onChanged();
      return this;
    }

    private long chunkId_ ;
    /**
     * <code>int64 chunkId = 2;</code>
     */
    public long getChunkId() {
      return chunkId_;
    }
    /**
     * <code>int64 chunkId = 2;</code>
     */
    public Builder setChunkId(long value) {
      
      chunkId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 chunkId = 2;</code>
     */
    public Builder clearChunkId() {
      
      chunkId_ = 0L;
      onChanged();
      return this;
    }

    private long maxChunks_ ;
    /**
     * <code>int64 maxChunks = 3;</code>
     */
    public long getMaxChunks() {
      return maxChunks_;
    }
    /**
     * <code>int64 maxChunks = 3;</code>
     */
    public Builder setMaxChunks(long value) {
      
      maxChunks_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 maxChunks = 3;</code>
     */
    public Builder clearMaxChunks() {
      
      maxChunks_ = 0L;
      onChanged();
      return this;
    }

    private long seqNum_ ;
    /**
     * <code>int64 seqNum = 4;</code>
     */
    public long getSeqNum() {
      return seqNum_;
    }
    /**
     * <code>int64 seqNum = 4;</code>
     */
    public Builder setSeqNum(long value) {
      
      seqNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 seqNum = 4;</code>
     */
    public Builder clearSeqNum() {
      
      seqNum_ = 0L;
      onChanged();
      return this;
    }

    private long seqMax_ ;
    /**
     * <code>int64 seqMax = 5;</code>
     */
    public long getSeqMax() {
      return seqMax_;
    }
    /**
     * <code>int64 seqMax = 5;</code>
     */
    public Builder setSeqMax(long value) {
      
      seqMax_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 seqMax = 5;</code>
     */
    public Builder clearSeqMax() {
      
      seqMax_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes data = 6;</code>
     */
    public com.google.protobuf.ByteString getData() {
      return data_;
    }
    /**
     * <code>bytes data = 6;</code>
     */
    public Builder setData(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes data = 6;</code>
     */
    public Builder clearData() {
      
      data_ = getDefaultInstance().getData();
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


    // @@protoc_insertion_point(builder_scope:grpc.Chunk)
  }

  // @@protoc_insertion_point(class_scope:grpc.Chunk)
  private static final com.cmpe275.generated.Chunk DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cmpe275.generated.Chunk();
  }

  public static com.cmpe275.generated.Chunk getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Chunk>
      PARSER = new com.google.protobuf.AbstractParser<Chunk>() {
    public Chunk parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Chunk(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Chunk> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Chunk> getParserForType() {
    return PARSER;
  }

  public com.cmpe275.generated.Chunk getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

