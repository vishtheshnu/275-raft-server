// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: team.proto

package com.cmpe275.generated;

/**
 * <pre>
 * data sent &amp; received for liveliness
 * </pre>
 *
 * Protobuf type {@code grpc.Heartbeat}
 */
public  final class Heartbeat extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.Heartbeat)
    HeartbeatOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Heartbeat.newBuilder() to construct.
  private Heartbeat(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Heartbeat() {
    messageId_ = 0L;
    isAck_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Heartbeat(
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

            messageId_ = input.readInt64();
            break;
          }
          case 16: {

            isAck_ = input.readBool();
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
    return com.cmpe275.generated.Team.internal_static_grpc_Heartbeat_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cmpe275.generated.Team.internal_static_grpc_Heartbeat_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cmpe275.generated.Heartbeat.class, com.cmpe275.generated.Heartbeat.Builder.class);
  }

  public static final int MESSAGEID_FIELD_NUMBER = 1;
  private long messageId_;
  /**
   * <code>int64 messageId = 1;</code>
   */
  public long getMessageId() {
    return messageId_;
  }

  public static final int ISACK_FIELD_NUMBER = 2;
  private boolean isAck_;
  /**
   * <code>bool isAck = 2;</code>
   */
  public boolean getIsAck() {
    return isAck_;
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
    if (messageId_ != 0L) {
      output.writeInt64(1, messageId_);
    }
    if (isAck_ != false) {
      output.writeBool(2, isAck_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (messageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, messageId_);
    }
    if (isAck_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, isAck_);
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
    if (!(obj instanceof com.cmpe275.generated.Heartbeat)) {
      return super.equals(obj);
    }
    com.cmpe275.generated.Heartbeat other = (com.cmpe275.generated.Heartbeat) obj;

    boolean result = true;
    result = result && (getMessageId()
        == other.getMessageId());
    result = result && (getIsAck()
        == other.getIsAck());
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
    hash = (37 * hash) + MESSAGEID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMessageId());
    hash = (37 * hash) + ISACK_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsAck());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cmpe275.generated.Heartbeat parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cmpe275.generated.Heartbeat parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.Heartbeat parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cmpe275.generated.Heartbeat parseFrom(
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
  public static Builder newBuilder(com.cmpe275.generated.Heartbeat prototype) {
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
   * data sent &amp; received for liveliness
   * </pre>
   *
   * Protobuf type {@code grpc.Heartbeat}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.Heartbeat)
      com.cmpe275.generated.HeartbeatOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cmpe275.generated.Team.internal_static_grpc_Heartbeat_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cmpe275.generated.Team.internal_static_grpc_Heartbeat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cmpe275.generated.Heartbeat.class, com.cmpe275.generated.Heartbeat.Builder.class);
    }

    // Construct using com.cmpe275.generated.Heartbeat.newBuilder()
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
      messageId_ = 0L;

      isAck_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cmpe275.generated.Team.internal_static_grpc_Heartbeat_descriptor;
    }

    public com.cmpe275.generated.Heartbeat getDefaultInstanceForType() {
      return com.cmpe275.generated.Heartbeat.getDefaultInstance();
    }

    public com.cmpe275.generated.Heartbeat build() {
      com.cmpe275.generated.Heartbeat result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.cmpe275.generated.Heartbeat buildPartial() {
      com.cmpe275.generated.Heartbeat result = new com.cmpe275.generated.Heartbeat(this);
      result.messageId_ = messageId_;
      result.isAck_ = isAck_;
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
      if (other instanceof com.cmpe275.generated.Heartbeat) {
        return mergeFrom((com.cmpe275.generated.Heartbeat)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cmpe275.generated.Heartbeat other) {
      if (other == com.cmpe275.generated.Heartbeat.getDefaultInstance()) return this;
      if (other.getMessageId() != 0L) {
        setMessageId(other.getMessageId());
      }
      if (other.getIsAck() != false) {
        setIsAck(other.getIsAck());
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
      com.cmpe275.generated.Heartbeat parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.cmpe275.generated.Heartbeat) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long messageId_ ;
    /**
     * <code>int64 messageId = 1;</code>
     */
    public long getMessageId() {
      return messageId_;
    }
    /**
     * <code>int64 messageId = 1;</code>
     */
    public Builder setMessageId(long value) {
      
      messageId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 messageId = 1;</code>
     */
    public Builder clearMessageId() {
      
      messageId_ = 0L;
      onChanged();
      return this;
    }

    private boolean isAck_ ;
    /**
     * <code>bool isAck = 2;</code>
     */
    public boolean getIsAck() {
      return isAck_;
    }
    /**
     * <code>bool isAck = 2;</code>
     */
    public Builder setIsAck(boolean value) {
      
      isAck_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isAck = 2;</code>
     */
    public Builder clearIsAck() {
      
      isAck_ = false;
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


    // @@protoc_insertion_point(builder_scope:grpc.Heartbeat)
  }

  // @@protoc_insertion_point(class_scope:grpc.Heartbeat)
  private static final com.cmpe275.generated.Heartbeat DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cmpe275.generated.Heartbeat();
  }

  public static com.cmpe275.generated.Heartbeat getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Heartbeat>
      PARSER = new com.google.protobuf.AbstractParser<Heartbeat>() {
    public Heartbeat parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Heartbeat(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Heartbeat> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Heartbeat> getParserForType() {
    return PARSER;
  }

  public com.cmpe275.generated.Heartbeat getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

