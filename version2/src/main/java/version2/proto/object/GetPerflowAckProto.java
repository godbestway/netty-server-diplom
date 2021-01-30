// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: getPerflowAckMsg.proto
package version2.proto.object;

public final class GetPerflowAckProto {
  private GetPerflowAckProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface GetPerflowAckMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:GetPerflowAckMsg)
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
   * Protobuf type {@code GetPerflowAckMsg}
   */
  public static final class GetPerflowAckMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:GetPerflowAckMsg)
      GetPerflowAckMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use GetPerflowAckMsg.newBuilder() to construct.
    private GetPerflowAckMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private GetPerflowAckMsg() {
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new GetPerflowAckMsg();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private GetPerflowAckMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
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
      return GetPerflowAckProto.internal_static_GetPerflowAckMsg_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return GetPerflowAckProto.internal_static_GetPerflowAckMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetPerflowAckMsg.class, Builder.class);
    }

    private int bitField0_;
    public static final int COUNT_FIELD_NUMBER = 1;
    private int count_;
    /**
     * <code>required fixed32 count = 1;</code>
     * @return Whether the count field is set.
     */
    @Override
    public boolean hasCount() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required fixed32 count = 1;</code>
     * @return The count.
     */
    @Override
    public int getCount() {
      return count_;
    }

    private byte memoizedIsInitialized = -1;
    @Override
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

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeFixed32(1, count_);
      }
      unknownFields.writeTo(output);
    }

    @Override
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

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof GetPerflowAckMsg)) {
        return super.equals(obj);
      }
      GetPerflowAckMsg other = (GetPerflowAckMsg) obj;

      if (hasCount() != other.hasCount()) return false;
      if (hasCount()) {
        if (getCount()
            != other.getCount()) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @Override
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

    public static GetPerflowAckMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GetPerflowAckMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GetPerflowAckMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GetPerflowAckMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GetPerflowAckMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GetPerflowAckMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GetPerflowAckMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static GetPerflowAckMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static GetPerflowAckMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static GetPerflowAckMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static GetPerflowAckMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static GetPerflowAckMsg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(GetPerflowAckMsg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code GetPerflowAckMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:GetPerflowAckMsg)
        GetPerflowAckMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return GetPerflowAckProto.internal_static_GetPerflowAckMsg_descriptor;
      }

      @Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return GetPerflowAckProto.internal_static_GetPerflowAckMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                GetPerflowAckMsg.class, Builder.class);
      }

      // Construct using GetPerflowAckProto.GetPerflowAckMsg.newBuilder()
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
      @Override
      public Builder clear() {
        super.clear();
        count_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return GetPerflowAckProto.internal_static_GetPerflowAckMsg_descriptor;
      }

      @Override
      public GetPerflowAckMsg getDefaultInstanceForType() {
        return GetPerflowAckMsg.getDefaultInstance();
      }

      @Override
      public GetPerflowAckMsg build() {
        GetPerflowAckMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public GetPerflowAckMsg buildPartial() {
        GetPerflowAckMsg result = new GetPerflowAckMsg(this);
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

      @Override
      public Builder clone() {
        return super.clone();
      }
      @Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.setField(field, value);
      }
      @Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.addRepeatedField(field, value);
      }
      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof GetPerflowAckMsg) {
          return mergeFrom((GetPerflowAckMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(GetPerflowAckMsg other) {
        if (other == GetPerflowAckMsg.getDefaultInstance()) return this;
        if (other.hasCount()) {
          setCount(other.getCount());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        if (!hasCount()) {
          return false;
        }
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        GetPerflowAckMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (GetPerflowAckMsg) e.getUnfinishedMessage();
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
      @Override
      public boolean hasCount() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required fixed32 count = 1;</code>
       * @return The count.
       */
      @Override
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
      @Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:GetPerflowAckMsg)
    }

    // @@protoc_insertion_point(class_scope:GetPerflowAckMsg)
    private static final GetPerflowAckMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new GetPerflowAckMsg();
    }

    public static GetPerflowAckMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @Deprecated public static final com.google.protobuf.Parser<GetPerflowAckMsg>
        PARSER = new com.google.protobuf.AbstractParser<GetPerflowAckMsg>() {
      @Override
      public GetPerflowAckMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new GetPerflowAckMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<GetPerflowAckMsg> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<GetPerflowAckMsg> getParserForType() {
      return PARSER;
    }

    @Override
    public GetPerflowAckMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetPerflowAckMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetPerflowAckMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\026getPerflowAckMsg.proto\"!\n\020GetPerflowAc" +
      "kMsg\022\r\n\005count\030\001 \002(\007B\024B\022GetPerflowAckProt" +
      "o"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_GetPerflowAckMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_GetPerflowAckMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetPerflowAckMsg_descriptor,
        new String[] { "Count", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
