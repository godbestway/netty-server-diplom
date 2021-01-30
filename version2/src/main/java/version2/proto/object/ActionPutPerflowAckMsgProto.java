// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: actionPutPerflowAckMsg.proto
package version2.proto.object;
public final class ActionPutPerflowAckMsgProto {
  private ActionPutPerflowAckMsgProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ActionPutPerflowAckMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ActionPutPerflowAckMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required fixed32 hash = 1;</code>
     * @return Whether the hash field is set.
     */
    boolean hasHash();
    /**
     * <code>required fixed32 hash = 1;</code>
     * @return The hash.
     */
    int getHash();
  }
  /**
   * Protobuf type {@code ActionPutPerflowAckMsg}
   */
  public static final class ActionPutPerflowAckMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ActionPutPerflowAckMsg)
      ActionPutPerflowAckMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ActionPutPerflowAckMsg.newBuilder() to construct.
    private ActionPutPerflowAckMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ActionPutPerflowAckMsg() {
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new ActionPutPerflowAckMsg();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ActionPutPerflowAckMsg(
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
              hash_ = input.readFixed32();
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
      return ActionPutPerflowAckMsgProto.internal_static_ActionPutPerflowAckMsg_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ActionPutPerflowAckMsgProto.internal_static_ActionPutPerflowAckMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ActionPutPerflowAckMsg.class, Builder.class);
    }

    private int bitField0_;
    public static final int HASH_FIELD_NUMBER = 1;
    private int hash_;
    /**
     * <code>required fixed32 hash = 1;</code>
     * @return Whether the hash field is set.
     */
    @Override
    public boolean hasHash() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required fixed32 hash = 1;</code>
     * @return The hash.
     */
    @Override
    public int getHash() {
      return hash_;
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasHash()) {
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
        output.writeFixed32(1, hash_);
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
          .computeFixed32Size(1, hash_);
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
      if (!(obj instanceof ActionPutPerflowAckMsg)) {
        return super.equals(obj);
      }
      ActionPutPerflowAckMsg other = (ActionPutPerflowAckMsg) obj;

      if (hasHash() != other.hasHash()) return false;
      if (hasHash()) {
        if (getHash()
            != other.getHash()) return false;
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
      if (hasHash()) {
        hash = (37 * hash) + HASH_FIELD_NUMBER;
        hash = (53 * hash) + getHash();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ActionPutPerflowAckMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ActionPutPerflowAckMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ActionPutPerflowAckMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ActionPutPerflowAckMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ActionPutPerflowAckMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ActionPutPerflowAckMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ActionPutPerflowAckMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ActionPutPerflowAckMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ActionPutPerflowAckMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ActionPutPerflowAckMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ActionPutPerflowAckMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ActionPutPerflowAckMsg parseFrom(
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
    public static Builder newBuilder(ActionPutPerflowAckMsg prototype) {
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
     * Protobuf type {@code ActionPutPerflowAckMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ActionPutPerflowAckMsg)
        ActionPutPerflowAckMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ActionPutPerflowAckMsgProto.internal_static_ActionPutPerflowAckMsg_descriptor;
      }

      @Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ActionPutPerflowAckMsgProto.internal_static_ActionPutPerflowAckMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ActionPutPerflowAckMsg.class, Builder.class);
      }

      // Construct using ActionPutPerflowAckMsgProto.ActionPutPerflowAckMsg.newBuilder()
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
        hash_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ActionPutPerflowAckMsgProto.internal_static_ActionPutPerflowAckMsg_descriptor;
      }

      @Override
      public ActionPutPerflowAckMsg getDefaultInstanceForType() {
        return ActionPutPerflowAckMsg.getDefaultInstance();
      }

      @Override
      public ActionPutPerflowAckMsg build() {
        ActionPutPerflowAckMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public ActionPutPerflowAckMsg buildPartial() {
        ActionPutPerflowAckMsg result = new ActionPutPerflowAckMsg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.hash_ = hash_;
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
        if (other instanceof ActionPutPerflowAckMsg) {
          return mergeFrom((ActionPutPerflowAckMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ActionPutPerflowAckMsg other) {
        if (other == ActionPutPerflowAckMsg.getDefaultInstance()) return this;
        if (other.hasHash()) {
          setHash(other.getHash());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        if (!hasHash()) {
          return false;
        }
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ActionPutPerflowAckMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ActionPutPerflowAckMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int hash_ ;
      /**
       * <code>required fixed32 hash = 1;</code>
       * @return Whether the hash field is set.
       */
      @Override
      public boolean hasHash() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required fixed32 hash = 1;</code>
       * @return The hash.
       */
      @Override
      public int getHash() {
        return hash_;
      }
      /**
       * <code>required fixed32 hash = 1;</code>
       * @param value The hash to set.
       * @return This builder for chaining.
       */
      public Builder setHash(int value) {
        bitField0_ |= 0x00000001;
        hash_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required fixed32 hash = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearHash() {
        bitField0_ = (bitField0_ & ~0x00000001);
        hash_ = 0;
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


      // @@protoc_insertion_point(builder_scope:ActionPutPerflowAckMsg)
    }

    // @@protoc_insertion_point(class_scope:ActionPutPerflowAckMsg)
    private static final ActionPutPerflowAckMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ActionPutPerflowAckMsg();
    }

    public static ActionPutPerflowAckMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @Deprecated public static final com.google.protobuf.Parser<ActionPutPerflowAckMsg>
        PARSER = new com.google.protobuf.AbstractParser<ActionPutPerflowAckMsg>() {
      @Override
      public ActionPutPerflowAckMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ActionPutPerflowAckMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ActionPutPerflowAckMsg> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ActionPutPerflowAckMsg> getParserForType() {
      return PARSER;
    }

    @Override
    public ActionPutPerflowAckMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ActionPutPerflowAckMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ActionPutPerflowAckMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\034actionPutPerflowAckMsg.proto\"&\n\026Action" +
      "PutPerflowAckMsg\022\014\n\004hash\030\001 \002(\007B\035B\033Action" +
      "PutPerflowAckMsgProto"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ActionPutPerflowAckMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ActionPutPerflowAckMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ActionPutPerflowAckMsg_descriptor,
        new String[] { "Hash", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
