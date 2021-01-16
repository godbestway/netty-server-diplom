// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: putPerflowMsg.proto
package version1.proto.object;

public final class PutPerflowProto {
  private PutPerflowProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PutPerflowMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PutPerflowMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .FlowState state = 1;</code>
     * @return Whether the state field is set.
     */
    boolean hasState();
    /**
     * <code>required .FlowState state = 1;</code>
     * @return The state.
     */
    FlowStateProto.FlowState getState();
    /**
     * <code>required .FlowState state = 1;</code>
     */
    FlowStateProto.FlowStateOrBuilder getStateOrBuilder();

    /**
     * <code>required fixed32 count = 2;</code>
     * @return Whether the count field is set.
     */
    boolean hasCount();
    /**
     * <code>required fixed32 count = 2;</code>
     * @return The count.
     */
    int getCount();
  }
  /**
   * Protobuf type {@code PutPerflowMsg}
   */
  public static final class PutPerflowMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PutPerflowMsg)
      PutPerflowMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PutPerflowMsg.newBuilder() to construct.
    private PutPerflowMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PutPerflowMsg() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new PutPerflowMsg();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private PutPerflowMsg(
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
              FlowStateProto.FlowState.Builder subBuilder = null;
              if (((bitField0_ & 0x00000001) != 0)) {
                subBuilder = state_.toBuilder();
              }
              state_ = input.readMessage(FlowStateProto.FlowState.PARSER, extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(state_);
                state_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000001;
              break;
            }
            case 21: {
              bitField0_ |= 0x00000002;
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
      return PutPerflowProto.internal_static_PutPerflowMsg_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PutPerflowProto.internal_static_PutPerflowMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              PutPerflowProto.PutPerflowMsg.class, PutPerflowProto.PutPerflowMsg.Builder.class);
    }

    private int bitField0_;
    public static final int STATE_FIELD_NUMBER = 1;
    private FlowStateProto.FlowState state_;
    /**
     * <code>required .FlowState state = 1;</code>
     * @return Whether the state field is set.
     */
    @java.lang.Override
    public boolean hasState() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required .FlowState state = 1;</code>
     * @return The state.
     */
    @java.lang.Override
    public FlowStateProto.FlowState getState() {
      return state_ == null ? FlowStateProto.FlowState.getDefaultInstance() : state_;
    }
    /**
     * <code>required .FlowState state = 1;</code>
     */
    @java.lang.Override
    public FlowStateProto.FlowStateOrBuilder getStateOrBuilder() {
      return state_ == null ? FlowStateProto.FlowState.getDefaultInstance() : state_;
    }

    public static final int COUNT_FIELD_NUMBER = 2;
    private int count_;
    /**
     * <code>required fixed32 count = 2;</code>
     * @return Whether the count field is set.
     */
    @java.lang.Override
    public boolean hasCount() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required fixed32 count = 2;</code>
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

      if (!hasState()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasCount()) {
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

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeMessage(1, getState());
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeFixed32(2, count_);
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
          .computeMessageSize(1, getState());
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFixed32Size(2, count_);
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
      if (!(obj instanceof PutPerflowProto.PutPerflowMsg)) {
        return super.equals(obj);
      }
      PutPerflowProto.PutPerflowMsg other = (PutPerflowProto.PutPerflowMsg) obj;

      if (hasState() != other.hasState()) return false;
      if (hasState()) {
        if (!getState()
            .equals(other.getState())) return false;
      }
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
      if (hasState()) {
        hash = (37 * hash) + STATE_FIELD_NUMBER;
        hash = (53 * hash) + getState().hashCode();
      }
      if (hasCount()) {
        hash = (37 * hash) + COUNT_FIELD_NUMBER;
        hash = (53 * hash) + getCount();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static PutPerflowProto.PutPerflowMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static PutPerflowProto.PutPerflowMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static PutPerflowProto.PutPerflowMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PutPerflowProto.PutPerflowMsg parseFrom(
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
    public static Builder newBuilder(PutPerflowProto.PutPerflowMsg prototype) {
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
     * Protobuf type {@code PutPerflowMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PutPerflowMsg)
        PutPerflowProto.PutPerflowMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return PutPerflowProto.internal_static_PutPerflowMsg_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return PutPerflowProto.internal_static_PutPerflowMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                PutPerflowProto.PutPerflowMsg.class, PutPerflowProto.PutPerflowMsg.Builder.class);
      }

      // Construct using PutPerflowProto.PutPerflowMsg.newBuilder()
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
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (stateBuilder_ == null) {
          state_ = null;
        } else {
          stateBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000001);
        count_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return PutPerflowProto.internal_static_PutPerflowMsg_descriptor;
      }

      @java.lang.Override
      public PutPerflowProto.PutPerflowMsg getDefaultInstanceForType() {
        return PutPerflowProto.PutPerflowMsg.getDefaultInstance();
      }

      @java.lang.Override
      public PutPerflowProto.PutPerflowMsg build() {
        PutPerflowProto.PutPerflowMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public PutPerflowProto.PutPerflowMsg buildPartial() {
        PutPerflowProto.PutPerflowMsg result = new PutPerflowProto.PutPerflowMsg(this);
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
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.count_ = count_;
          to_bitField0_ |= 0x00000002;
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
        if (other instanceof PutPerflowProto.PutPerflowMsg) {
          return mergeFrom((PutPerflowProto.PutPerflowMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(PutPerflowProto.PutPerflowMsg other) {
        if (other == PutPerflowProto.PutPerflowMsg.getDefaultInstance()) return this;
        if (other.hasState()) {
          mergeState(other.getState());
        }
        if (other.hasCount()) {
          setCount(other.getCount());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasState()) {
          return false;
        }
        if (!hasCount()) {
          return false;
        }
        if (!getState().isInitialized()) {
          return false;
        }
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        PutPerflowProto.PutPerflowMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (PutPerflowProto.PutPerflowMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private FlowStateProto.FlowState state_;
      private com.google.protobuf.SingleFieldBuilderV3<
          FlowStateProto.FlowState, FlowStateProto.FlowState.Builder, FlowStateProto.FlowStateOrBuilder> stateBuilder_;
      /**
       * <code>required .FlowState state = 1;</code>
       * @return Whether the state field is set.
       */
      public boolean hasState() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required .FlowState state = 1;</code>
       * @return The state.
       */
      public FlowStateProto.FlowState getState() {
        if (stateBuilder_ == null) {
          return state_ == null ? FlowStateProto.FlowState.getDefaultInstance() : state_;
        } else {
          return stateBuilder_.getMessage();
        }
      }
      /**
       * <code>required .FlowState state = 1;</code>
       */
      public Builder setState(FlowStateProto.FlowState value) {
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
       * <code>required .FlowState state = 1;</code>
       */
      public Builder setState(
          FlowStateProto.FlowState.Builder builderForValue) {
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
       * <code>required .FlowState state = 1;</code>
       */
      public Builder mergeState(FlowStateProto.FlowState value) {
        if (stateBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0) &&
              state_ != null &&
              state_ != FlowStateProto.FlowState.getDefaultInstance()) {
            state_ =
              FlowStateProto.FlowState.newBuilder(state_).mergeFrom(value).buildPartial();
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
       * <code>required .FlowState state = 1;</code>
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
       * <code>required .FlowState state = 1;</code>
       */
      public FlowStateProto.FlowState.Builder getStateBuilder() {
        bitField0_ |= 0x00000001;
        onChanged();
        return getStateFieldBuilder().getBuilder();
      }
      /**
       * <code>required .FlowState state = 1;</code>
       */
      public FlowStateProto.FlowStateOrBuilder getStateOrBuilder() {
        if (stateBuilder_ != null) {
          return stateBuilder_.getMessageOrBuilder();
        } else {
          return state_ == null ?
              FlowStateProto.FlowState.getDefaultInstance() : state_;
        }
      }
      /**
       * <code>required .FlowState state = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          FlowStateProto.FlowState, FlowStateProto.FlowState.Builder, FlowStateProto.FlowStateOrBuilder> 
          getStateFieldBuilder() {
        if (stateBuilder_ == null) {
          stateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              FlowStateProto.FlowState, FlowStateProto.FlowState.Builder, FlowStateProto.FlowStateOrBuilder>(
                  getState(),
                  getParentForChildren(),
                  isClean());
          state_ = null;
        }
        return stateBuilder_;
      }

      private int count_ ;
      /**
       * <code>required fixed32 count = 2;</code>
       * @return Whether the count field is set.
       */
      @java.lang.Override
      public boolean hasCount() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>required fixed32 count = 2;</code>
       * @return The count.
       */
      @java.lang.Override
      public int getCount() {
        return count_;
      }
      /**
       * <code>required fixed32 count = 2;</code>
       * @param value The count to set.
       * @return This builder for chaining.
       */
      public Builder setCount(int value) {
        bitField0_ |= 0x00000002;
        count_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required fixed32 count = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearCount() {
        bitField0_ = (bitField0_ & ~0x00000002);
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


      // @@protoc_insertion_point(builder_scope:PutPerflowMsg)
    }

    // @@protoc_insertion_point(class_scope:PutPerflowMsg)
    private static final PutPerflowProto.PutPerflowMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new PutPerflowProto.PutPerflowMsg();
    }

    public static PutPerflowProto.PutPerflowMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<PutPerflowMsg>
        PARSER = new com.google.protobuf.AbstractParser<PutPerflowMsg>() {
      @java.lang.Override
      public PutPerflowMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PutPerflowMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PutPerflowMsg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PutPerflowMsg> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public PutPerflowProto.PutPerflowMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PutPerflowMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PutPerflowMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023putPerflowMsg.proto\032\017flowstate.proto\"9" +
      "\n\rPutPerflowMsg\022\031\n\005state\030\001 \002(\0132\n.FlowSta" +
      "te\022\r\n\005count\030\002 \002(\007B\021B\017PutPerflowProto"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          FlowStateProto.getDescriptor(),
        });
    internal_static_PutPerflowMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PutPerflowMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PutPerflowMsg_descriptor,
        new java.lang.String[] { "State", "Count", });
    FlowStateProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
