// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: team.proto

package com.cmpe275.generated;

public interface ChunkOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.Chunk)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string fileName = 1;</code>
   */
  java.lang.String getFileName();
  /**
   * <code>string fileName = 1;</code>
   */
  com.google.protobuf.ByteString
      getFileNameBytes();

  /**
   * <code>int64 chunkId = 2;</code>
   */
  long getChunkId();

  /**
   * <code>int64 maxChunks = 3;</code>
   */
  long getMaxChunks();

  /**
   * <code>int64 seqNum = 4;</code>
   */
  long getSeqNum();

  /**
   * <code>int64 seqMax = 5;</code>
   */
  long getSeqMax();

  /**
   * <code>bytes data = 6;</code>
   */
  com.google.protobuf.ByteString getData();
}
