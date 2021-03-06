// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: actionGetPerflowMsg.proto
package version1.proto.object;
public final class ActionGetPerflowMsgProto {
  private ActionGetPerflowMsgProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ActionGetPerflowMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ActionGetPerflowMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string key = 1;</code>
     * @return Whether the key field is set.
     */
    boolean hasKey();
    /**
     * <code>optional string key = 1;</code>
     * @return The key.
     */
    java.lang.String getKey();
    /**
     * <code>optional string key = 1;</code>
     * @return The bytes for key.
     */
    com.google.protobuf.ByteString
        getKeyBytes();
  }
  /**
   * Protobuf type {@code ActionGetPerflowMsg}
   */
  public static final class ActionGetPerflowMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ActionGetPerflowMsg)
      ActionGetPerflowMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ActionGetPerflowMsg.newBuilder() to construct.
    private ActionGetPerflowMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ActionGetPerflowMsg() {
      key_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ActionGetPerflowMsg();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ActionGetPerflowMsg(
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
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              key_ = bs;
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
      return ActionGetPerflowMsgProto.internal_static_ActionGetPerflowMsg_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ActionGetPerflowMsgProto.internal_static_ActionGetPerflowMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ActionGetPerflowMsgProto.ActionGetPerflowMsg.class, ActionGetPerflowMsgProto.ActionGetPerflowMsg.Builder.class);
    }

    private int bitField0_;
    public static final int KEY_FIELD_NUMBER = 1;
    private volatile java.lang.Object key_;
    /**
     * <code>optional string key = 1;</code>
     * @return Whether the key field is set.
     */
    @java.lang.Override
    public boolean hasKey() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional string key = 1;</code>
     * @return The key.
     */
    @java.lang.Override
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          key_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string key = 1;</code>
     * @return The bytes for key.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
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
      if (!(obj instanceof ActionGetPerflowMsgProto.ActionGetPerflowMsg)) {
        return super.equals(obj);
      }
      ActionGetPerflowMsgProto.ActionGetPerflowMsg other = (ActionGetPerflowMsgProto.ActionGetPerflowMsg) obj;

      if (hasKey() != other.hasKey()) return false;
      if (hasKey()) {
        if (!getKey()
            .equals(other.getKey())) return false;
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
      if (hasKey()) {
        hash = (37 * hash) + KEY_FIELD_NUMBER;
        hash = (53 * hash) + getKey().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg parseFrom(
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
    public static Builder newBuilder(ActionGetPerflowMsgProto.ActionGetPerflowMsg prototype) {
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
     * Protobuf type {@code ActionGetPerflowMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ActionGetPerflowMsg)
        ActionGetPerflowMsgProto.ActionGetPerflowMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ActionGetPerflowMsgProto.internal_static_ActionGetPerflowMsg_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ActionGetPerflowMsgProto.internal_static_ActionGetPerflowMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ActionGetPerflowMsgProto.ActionGetPerflowMsg.class, ActionGetPerflowMsgProto.ActionGetPerflowMsg.Builder.class);
      }

      // Construct using ActionGetPerflowMsgProto.ActionGetPerflowMsg.newBuilder()
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
        key_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ActionGetPerflowMsgProto.internal_static_ActionGetPerflowMsg_descriptor;
      }

      @java.lang.Override
      public ActionGetPerflowMsgProto.ActionGetPerflowMsg getDefaultInstanceForType() {
        return ActionGetPerflowMsgProto.ActionGetPerflowMsg.getDefaultInstance();
      }

      @java.lang.Override
      public ActionGetPerflowMsgProto.ActionGetPerflowMsg build() {
        ActionGetPerflowMsgProto.ActionGetPerflowMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public ActionGetPerflowMsgProto.ActionGetPerflowMsg buildPartial() {
        ActionGetPerflowMsgProto.ActionGetPerflowMsg result = new ActionGetPerflowMsgProto.ActionGetPerflowMsg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          to_bitField0_ |= 0x00000001;
        }
        result.key_ = key_;
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
        if (other instanceof ActionGetPerflowMsgProto.ActionGetPerflowMsg) {
          return mergeFrom((ActionGetPerflowMsgProto.ActionGetPerflowMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ActionGetPerflowMsgProto.ActionGetPerflowMsg other) {
        if (other == ActionGetPerflowMsgProto.ActionGetPerflowMsg.getDefaultInstance()) return this;
        if (other.hasKey()) {
          bitField0_ |= 0x00000001;
          key_ = other.key_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ActionGetPerflowMsgProto.ActionGetPerflowMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ActionGetPerflowMsgProto.ActionGetPerflowMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object key_ = "";
      /**
       * <code>optional string key = 1;</code>
       * @return Whether the key field is set.
       */
      public boolean hasKey() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>optional string key = 1;</code>
       * @return The key.
       */
      public java.lang.String getKey() {
        java.lang.Object ref = key_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            key_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string key = 1;</code>
       * @return The bytes for key.
       */
      public com.google.protobuf.ByteString
          getKeyBytes() {
        java.lang.Object ref = key_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          key_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string key = 1;</code>
       * @param value The key to set.
       * @return This builder for chaining.
       */
      public Builder setKey(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        key_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string key = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearKey() {
        bitField0_ = (bitField0_ & ~0x00000001);
        key_ = getDefaultInstance().getKey();
        onChanged();
        return this;
      }
      /**
       * <code>optional string key = 1;</code>
       * @param value The bytes for key to set.
       * @return This builder for chaining.
       */
      public Builder setKeyBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        key_ = value;
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


      // @@protoc_insertion_point(builder_scope:ActionGetPerflowMsg)
    }

    // @@protoc_insertion_point(class_scope:ActionGetPerflowMsg)
    private static final ActionGetPerflowMsgProto.ActionGetPerflowMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ActionGetPerflowMsgProto.ActionGetPerflowMsg();
    }

    public static ActionGetPerflowMsgProto.ActionGetPerflowMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<ActionGetPerflowMsg>
        PARSER = new com.google.protobuf.AbstractParser<ActionGetPerflowMsg>() {
      @java.lang.Override
      public ActionGetPerflowMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ActionGetPerflowMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ActionGetPerflowMsg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ActionGetPerflowMsg> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public ActionGetPerflowMsgProto.ActionGetPerflowMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ActionGetPerflowMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ActionGetPerflowMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031actionGetPerflowMsg.proto\"\"\n\023ActionGet" +
      "PerflowMsg\022\013\n\003key\030\001 \001(\tB\032B\030ActionGetPerf" +
      "lowMsgProto"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ActionGetPerflowMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ActionGetPerflowMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ActionGetPerflowMsg_descriptor,
        new java.lang.String[] { "Key", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
