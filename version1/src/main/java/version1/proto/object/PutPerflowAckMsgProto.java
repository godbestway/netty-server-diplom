// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: putPerflowAckMsg.proto
package version1.proto.object;

public final class PutPerflowAckMsgProto {
  private PutPerflowAckMsgProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PutPerflowAckMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PutPerflowAckMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required fixed32 count = 1;</code>
     * @return Whether the count field is set.
     */
    boolean hasCount();
    /**
     * <code>required fixed32 count = 1;</code>
     * @return The count.
     */
    int getCount();
  }
  /**
   * Protobuf type {@code PutPerflowAckMsg}
   */
  public static final class PutPerflowAckMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PutPerflowAckMsg)
      PutPerflowAckMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PutPerflowAckMsg.newBuilder() to construct.
    private PutPerflowAckMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PutPerflowAckMsg() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new PutPerflowAckMsg();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private PutPerflowAckMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 13: {
              bitField0_ |= 0x00000001;
              count_ = input.readFixed32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
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
      return PutPerflowAckMsgProto.internal_static_PutPerflowAckMsg_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PutPerflowAckMsgProto.internal_static_PutPerflowAckMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              PutPerflowAckMsgProto.PutPerflowAckMsg.class, PutPerflowAckMsgProto.PutPerflowAckMsg.Builder.class);
    }

    private int bitField0_;
    public static final int COUNT_FIELD_NUMBER = 1;
    private int count_;
    /**
     * <code>required fixed32 count = 1;</code>
     * @return Whether the count field is set.
     */
    @java.lang.Override
    public boolean hasCount() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required fixed32 count = 1;</code>
     * @return The count.
     */
    @java.lang.Override
    public int getCount() {
      return count_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasCount()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeFixed32(1, count_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFixed32Size(1, count_);
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
      if (!(obj instanceof PutPerflowAckMsgProto.PutPerflowAckMsg)) {
        return super.equals(obj);
      }
      PutPerflowAckMsgProto.PutPerflowAckMsg other = (PutPerflowAckMsgProto.PutPerflowAckMsg) obj;

      if (hasCount() != other.hasCount()) return false;
      if (hasCount()) {
        if (getCount()
            != other.getCount()) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasCount()) {
        hash = (37 * hash) + COUNT_FIELD_NUMBER;
        hash = (53 * hash) + getCount();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PutPerflowAckMsgProto.PutPerflowAckMsg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(PutPerflowAckMsgProto.PutPerflowAckMsg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     * Protobuf type {@code PutPerflowAckMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PutPerflowAckMsg)
        PutPerflowAckMsgProto.PutPerflowAckMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return PutPerflowAckMsgProto.internal_static_PutPerflowAckMsg_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return PutPerflowAckMsgProto.internal_static_PutPerflowAckMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                PutPerflowAckMsgProto.PutPerflowAckMsg.class, PutPerflowAckMsgProto.PutPerflowAckMsg.Builder.class);
      }

      // Construct using PutPerflowAckMsgProto.PutPerflowAckMsg.newBuilder()
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
      @java.lang.Override
      public Builder clear() {
        super.clear();
        count_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return PutPerflowAckMsgProto.internal_static_PutPerflowAckMsg_descriptor;
      }

      @java.lang.Override
      public PutPerflowAckMsgProto.PutPerflowAckMsg getDefaultInstanceForType() {
        return PutPerflowAckMsgProto.PutPerflowAckMsg.getDefaultInstance();
      }

      @java.lang.Override
      public PutPerflowAckMsgProto.PutPerflowAckMsg build() {
        PutPerflowAckMsgProto.PutPerflowAckMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public PutPerflowAckMsgProto.PutPerflowAckMsg buildPartial() {
        PutPerflowAckMsgProto.PutPerflowAckMsg result = new PutPerflowAckMsgProto.PutPerflowAckMsg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.count_ = count_;
          to_bitField0_ |= 0x00000001;
        }
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof PutPerflowAckMsgProto.PutPerflowAckMsg) {
          return mergeFrom((PutPerflowAckMsgProto.PutPerflowAckMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(PutPerflowAckMsgProto.PutPerflowAckMsg other) {
        if (other == PutPerflowAckMsgProto.PutPerflowAckMsg.getDefaultInstance()) return this;
        if (other.hasCount()) {
          setCount(other.getCount());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasCount()) {
          return false;
        }
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        PutPerflowAckMsgProto.PutPerflowAckMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (PutPerflowAckMsgProto.PutPerflowAckMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int count_ ;
      /**
       * <code>required fixed32 count = 1;</code>
       * @return Whether the count field is set.
       */
      @java.lang.Override
      public boolean hasCount() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required fixed32 count = 1;</code>
       * @return The count.
       */
      @java.lang.Override
      public int getCount() {
        return count_;
      }
      /**
       * <code>required fixed32 count = 1;</code>
       * @param value The count to set.
       * @return This builder for chaining.
       */
      public Builder setCount(int value) {
        bitField0_ |= 0x00000001;
        count_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required fixed32 count = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearCount() {
        bitField0_ = (bitField0_ & ~0x00000001);
        count_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:PutPerflowAckMsg)
    }

    // @@protoc_insertion_point(class_scope:PutPerflowAckMsg)
    private static final PutPerflowAckMsgProto.PutPerflowAckMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new PutPerflowAckMsgProto.PutPerflowAckMsg();
    }

    public static PutPerflowAckMsgProto.PutPerflowAckMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<PutPerflowAckMsg>
        PARSER = new com.google.protobuf.AbstractParser<PutPerflowAckMsg>() {
      @java.lang.Override
      public PutPerflowAckMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PutPerflowAckMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PutPerflowAckMsg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PutPerflowAckMsg> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public PutPerflowAckMsgProto.PutPerflowAckMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PutPerflowAckMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PutPerflowAckMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026putPerflowAckMsg.proto\"!\n\020PutPerflowAc" +
      "kMsg\022\r\n\005count\030\001 \002(\007B\027B\025PutPerflowAckMsgP" +
      "roto"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_PutPerflowAckMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PutPerflowAckMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PutPerflowAckMsg_descriptor,
        new java.lang.String[] { "Count", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
