// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: connPutPerflowMsg.proto
package version2.proto.object;
public final class ConnPutPerflowMsgProto {
  private ConnPutPerflowMsgProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ConnPutPerflowMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ConnPutPerflowMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .ConnState state = 1;</code>
     * @return Whether the state field is set.
     */
    boolean hasState();
    /**
     * <code>required .ConnState state = 1;</code>
     * @return The state.
     */
    ConnStateProto.ConnState getState();
    /**
     * <code>required .ConnState state = 1;</code>
     */
    ConnStateProto.ConnStateOrBuilder getStateOrBuilder();
  }
  /**
   * Protobuf type {@code ConnPutPerflowMsg}
   */
  public static final class ConnPutPerflowMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ConnPutPerflowMsg)
      ConnPutPerflowMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ConnPutPerflowMsg.newBuilder() to construct.
    private ConnPutPerflowMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ConnPutPerflowMsg() {
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new ConnPutPerflowMsg();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ConnPutPerflowMsg(
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
            case 10: {
              ConnStateProto.ConnState.Builder subBuilder = null;
              if (((bitField0_ & 0x00000001) != 0)) {
                subBuilder = state_.toBuilder();
              }
              state_ = input.readMessage(ConnStateProto.ConnState.PARSER, extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(state_);
                state_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000001;
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
      return ConnPutPerflowMsgProto.internal_static_ConnPutPerflowMsg_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ConnPutPerflowMsgProto.internal_static_ConnPutPerflowMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ConnPutPerflowMsg.class, Builder.class);
    }

    private int bitField0_;
    public static final int STATE_FIELD_NUMBER = 1;
    private ConnStateProto.ConnState state_;
    /**
     * <code>required .ConnState state = 1;</code>
     * @return Whether the state field is set.
     */
    @Override
    public boolean hasState() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required .ConnState state = 1;</code>
     * @return The state.
     */
    @Override
    public ConnStateProto.ConnState getState() {
      return state_ == null ? ConnStateProto.ConnState.getDefaultInstance() : state_;
    }
    /**
     * <code>required .ConnState state = 1;</code>
     */
    @Override
    public ConnStateProto.ConnStateOrBuilder getStateOrBuilder() {
      return state_ == null ? ConnStateProto.ConnState.getDefaultInstance() : state_;
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasState()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!getState().isInitialized()) {
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
        output.writeMessage(1, getState());
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
          .computeMessageSize(1, getState());
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
      if (!(obj instanceof ConnPutPerflowMsg)) {
        return super.equals(obj);
      }
      ConnPutPerflowMsg other = (ConnPutPerflowMsg) obj;

      if (hasState() != other.hasState()) return false;
      if (hasState()) {
        if (!getState()
            .equals(other.getState())) return false;
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
      if (hasState()) {
        hash = (37 * hash) + STATE_FIELD_NUMBER;
        hash = (53 * hash) + getState().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ConnPutPerflowMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ConnPutPerflowMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ConnPutPerflowMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ConnPutPerflowMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ConnPutPerflowMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ConnPutPerflowMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ConnPutPerflowMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ConnPutPerflowMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ConnPutPerflowMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ConnPutPerflowMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ConnPutPerflowMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ConnPutPerflowMsg parseFrom(
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
    public static Builder newBuilder(ConnPutPerflowMsg prototype) {
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
     * Protobuf type {@code ConnPutPerflowMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ConnPutPerflowMsg)
        ConnPutPerflowMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ConnPutPerflowMsgProto.internal_static_ConnPutPerflowMsg_descriptor;
      }

      @Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ConnPutPerflowMsgProto.internal_static_ConnPutPerflowMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ConnPutPerflowMsg.class, Builder.class);
      }

      // Construct using ConnPutPerflowMsgProto.ConnPutPerflowMsg.newBuilder()
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
          getStateFieldBuilder();
        }
      }
      @Override
      public Builder clear() {
        super.clear();
        if (stateBuilder_ == null) {
          state_ = null;
        } else {
          stateBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ConnPutPerflowMsgProto.internal_static_ConnPutPerflowMsg_descriptor;
      }

      @Override
      public ConnPutPerflowMsg getDefaultInstanceForType() {
        return ConnPutPerflowMsg.getDefaultInstance();
      }

      @Override
      public ConnPutPerflowMsg build() {
        ConnPutPerflowMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public ConnPutPerflowMsg buildPartial() {
        ConnPutPerflowMsg result = new ConnPutPerflowMsg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          if (stateBuilder_ == null) {
            result.state_ = state_;
          } else {
            result.state_ = stateBuilder_.build();
          }
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
        if (other instanceof ConnPutPerflowMsg) {
          return mergeFrom((ConnPutPerflowMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ConnPutPerflowMsg other) {
        if (other == ConnPutPerflowMsg.getDefaultInstance()) return this;
        if (other.hasState()) {
          mergeState(other.getState());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        if (!hasState()) {
          return false;
        }
        if (!getState().isInitialized()) {
          return false;
        }
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ConnPutPerflowMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ConnPutPerflowMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private ConnStateProto.ConnState state_;
      private com.google.protobuf.SingleFieldBuilderV3<
          ConnStateProto.ConnState, ConnStateProto.ConnState.Builder, ConnStateProto.ConnStateOrBuilder> stateBuilder_;
      /**
       * <code>required .ConnState state = 1;</code>
       * @return Whether the state field is set.
       */
      public boolean hasState() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required .ConnState state = 1;</code>
       * @return The state.
       */
      public ConnStateProto.ConnState getState() {
        if (stateBuilder_ == null) {
          return state_ == null ? ConnStateProto.ConnState.getDefaultInstance() : state_;
        } else {
          return stateBuilder_.getMessage();
        }
      }
      /**
       * <code>required .ConnState state = 1;</code>
       */
      public Builder setState(ConnStateProto.ConnState value) {
        if (stateBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          state_ = value;
          onChanged();
        } else {
          stateBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000001;
        return this;
      }
      /**
       * <code>required .ConnState state = 1;</code>
       */
      public Builder setState(
          ConnStateProto.ConnState.Builder builderForValue) {
        if (stateBuilder_ == null) {
          state_ = builderForValue.build();
          onChanged();
        } else {
          stateBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000001;
        return this;
      }
      /**
       * <code>required .ConnState state = 1;</code>
       */
      public Builder mergeState(ConnStateProto.ConnState value) {
        if (stateBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0) &&
              state_ != null &&
              state_ != ConnStateProto.ConnState.getDefaultInstance()) {
            state_ =
              ConnStateProto.ConnState.newBuilder(state_).mergeFrom(value).buildPartial();
          } else {
            state_ = value;
          }
          onChanged();
        } else {
          stateBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000001;
        return this;
      }
      /**
       * <code>required .ConnState state = 1;</code>
       */
      public Builder clearState() {
        if (stateBuilder_ == null) {
          state_ = null;
          onChanged();
        } else {
          stateBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }
      /**
       * <code>required .ConnState state = 1;</code>
       */
      public ConnStateProto.ConnState.Builder getStateBuilder() {
        bitField0_ |= 0x00000001;
        onChanged();
        return getStateFieldBuilder().getBuilder();
      }
      /**
       * <code>required .ConnState state = 1;</code>
       */
      public ConnStateProto.ConnStateOrBuilder getStateOrBuilder() {
        if (stateBuilder_ != null) {
          return stateBuilder_.getMessageOrBuilder();
        } else {
          return state_ == null ?
              ConnStateProto.ConnState.getDefaultInstance() : state_;
        }
      }
      /**
       * <code>required .ConnState state = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          ConnStateProto.ConnState, ConnStateProto.ConnState.Builder, ConnStateProto.ConnStateOrBuilder> 
          getStateFieldBuilder() {
        if (stateBuilder_ == null) {
          stateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              ConnStateProto.ConnState, ConnStateProto.ConnState.Builder, ConnStateProto.ConnStateOrBuilder>(
                  getState(),
                  getParentForChildren(),
                  isClean());
          state_ = null;
        }
        return stateBuilder_;
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


      // @@protoc_insertion_point(builder_scope:ConnPutPerflowMsg)
    }

    // @@protoc_insertion_point(class_scope:ConnPutPerflowMsg)
    private static final ConnPutPerflowMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ConnPutPerflowMsg();
    }

    public static ConnPutPerflowMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @Deprecated public static final com.google.protobuf.Parser<ConnPutPerflowMsg>
        PARSER = new com.google.protobuf.AbstractParser<ConnPutPerflowMsg>() {
      @Override
      public ConnPutPerflowMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ConnPutPerflowMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ConnPutPerflowMsg> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ConnPutPerflowMsg> getParserForType() {
      return PARSER;
    }

    @Override
    public ConnPutPerflowMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ConnPutPerflowMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ConnPutPerflowMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\027connPutPerflowMsg.proto\032\017connState.pro" +
      "to\".\n\021ConnPutPerflowMsg\022\031\n\005state\030\001 \002(\0132\n" +
      ".ConnStateB\030B\026ConnPutPerflowMsgProto"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          ConnStateProto.getDescriptor(),
        });
    internal_static_ConnPutPerflowMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ConnPutPerflowMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ConnPutPerflowMsg_descriptor,
        new String[] { "State", });
    ConnStateProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
