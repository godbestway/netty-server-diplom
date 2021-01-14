// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: multiflowState.proto
package version1.proto.object;
public final class MultiflowStateProto {
  private MultiflowStateProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MultiflowStateOrBuilder extends
      // @@protoc_insertion_point(interface_extends:MultiflowState)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 data = 1;</code>
     * @return Whether the data field is set.
     */
    boolean hasData();
    /**
     * <code>required int32 data = 1;</code>
     * @return The data.
     */
    int getData();

    /**
     * <code>required int32 commondata = 2;</code>
     * @return Whether the commondata field is set.
     */
    boolean hasCommondata();
    /**
     * <code>required int32 commondata = 2;</code>
     * @return The commondata.
     */
    int getCommondata();
  }
  /**
   * Protobuf type {@code MultiflowState}
   */
  public static final class MultiflowState extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:MultiflowState)
      MultiflowStateOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use MultiflowState.newBuilder() to construct.
    private MultiflowState(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MultiflowState() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new MultiflowState();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MultiflowState(
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
            case 8: {
              bitField0_ |= 0x00000001;
              data_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              commondata_ = input.readInt32();
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
      return MultiflowStateProto.internal_static_MultiflowState_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MultiflowStateProto.internal_static_MultiflowState_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MultiflowStateProto.MultiflowState.class, MultiflowStateProto.MultiflowState.Builder.class);
    }

    private int bitField0_;
    public static final int DATA_FIELD_NUMBER = 1;
    private int data_;
    /**
     * <code>required int32 data = 1;</code>
     * @return Whether the data field is set.
     */
    @java.lang.Override
    public boolean hasData() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required int32 data = 1;</code>
     * @return The data.
     */
    @java.lang.Override
    public int getData() {
      return data_;
    }

    public static final int COMMONDATA_FIELD_NUMBER = 2;
    private int commondata_;
    /**
     * <code>required int32 commondata = 2;</code>
     * @return Whether the commondata field is set.
     */
    @java.lang.Override
    public boolean hasCommondata() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required int32 commondata = 2;</code>
     * @return The commondata.
     */
    @java.lang.Override
    public int getCommondata() {
      return commondata_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasData()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasCommondata()) {
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
        output.writeInt32(1, data_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeInt32(2, commondata_);
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
          .computeInt32Size(1, data_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, commondata_);
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
      if (!(obj instanceof MultiflowStateProto.MultiflowState)) {
        return super.equals(obj);
      }
      MultiflowStateProto.MultiflowState other = (MultiflowStateProto.MultiflowState) obj;

      if (hasData() != other.hasData()) return false;
      if (hasData()) {
        if (getData()
            != other.getData()) return false;
      }
      if (hasCommondata() != other.hasCommondata()) return false;
      if (hasCommondata()) {
        if (getCommondata()
            != other.getCommondata()) return false;
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
      if (hasData()) {
        hash = (37 * hash) + DATA_FIELD_NUMBER;
        hash = (53 * hash) + getData();
      }
      if (hasCommondata()) {
        hash = (37 * hash) + COMMONDATA_FIELD_NUMBER;
        hash = (53 * hash) + getCommondata();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static MultiflowStateProto.MultiflowState parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static MultiflowStateProto.MultiflowState parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static MultiflowStateProto.MultiflowState parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static MultiflowStateProto.MultiflowState parseFrom(
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
    public static Builder newBuilder(MultiflowStateProto.MultiflowState prototype) {
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
     * Protobuf type {@code MultiflowState}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:MultiflowState)
        MultiflowStateProto.MultiflowStateOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MultiflowStateProto.internal_static_MultiflowState_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MultiflowStateProto.internal_static_MultiflowState_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                MultiflowStateProto.MultiflowState.class, MultiflowStateProto.MultiflowState.Builder.class);
      }

      // Construct using MultiflowStateProto.MultiflowState.newBuilder()
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
        data_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        commondata_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MultiflowStateProto.internal_static_MultiflowState_descriptor;
      }

      @java.lang.Override
      public MultiflowStateProto.MultiflowState getDefaultInstanceForType() {
        return MultiflowStateProto.MultiflowState.getDefaultInstance();
      }

      @java.lang.Override
      public MultiflowStateProto.MultiflowState build() {
        MultiflowStateProto.MultiflowState result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public MultiflowStateProto.MultiflowState buildPartial() {
        MultiflowStateProto.MultiflowState result = new MultiflowStateProto.MultiflowState(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.data_ = data_;
          to_bitField0_ |= 0x00000001;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.commondata_ = commondata_;
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
        if (other instanceof MultiflowStateProto.MultiflowState) {
          return mergeFrom((MultiflowStateProto.MultiflowState)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(MultiflowStateProto.MultiflowState other) {
        if (other == MultiflowStateProto.MultiflowState.getDefaultInstance()) return this;
        if (other.hasData()) {
          setData(other.getData());
        }
        if (other.hasCommondata()) {
          setCommondata(other.getCommondata());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasData()) {
          return false;
        }
        if (!hasCommondata()) {
          return false;
        }
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        MultiflowStateProto.MultiflowState parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (MultiflowStateProto.MultiflowState) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int data_ ;
      /**
       * <code>required int32 data = 1;</code>
       * @return Whether the data field is set.
       */
      @java.lang.Override
      public boolean hasData() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required int32 data = 1;</code>
       * @return The data.
       */
      @java.lang.Override
      public int getData() {
        return data_;
      }
      /**
       * <code>required int32 data = 1;</code>
       * @param value The data to set.
       * @return This builder for chaining.
       */
      public Builder setData(int value) {
        bitField0_ |= 0x00000001;
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 data = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearData() {
        bitField0_ = (bitField0_ & ~0x00000001);
        data_ = 0;
        onChanged();
        return this;
      }

      private int commondata_ ;
      /**
       * <code>required int32 commondata = 2;</code>
       * @return Whether the commondata field is set.
       */
      @java.lang.Override
      public boolean hasCommondata() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>required int32 commondata = 2;</code>
       * @return The commondata.
       */
      @java.lang.Override
      public int getCommondata() {
        return commondata_;
      }
      /**
       * <code>required int32 commondata = 2;</code>
       * @param value The commondata to set.
       * @return This builder for chaining.
       */
      public Builder setCommondata(int value) {
        bitField0_ |= 0x00000002;
        commondata_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 commondata = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearCommondata() {
        bitField0_ = (bitField0_ & ~0x00000002);
        commondata_ = 0;
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


      // @@protoc_insertion_point(builder_scope:MultiflowState)
    }

    // @@protoc_insertion_point(class_scope:MultiflowState)
    private static final MultiflowStateProto.MultiflowState DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new MultiflowStateProto.MultiflowState();
    }

    public static MultiflowStateProto.MultiflowState getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<MultiflowState>
        PARSER = new com.google.protobuf.AbstractParser<MultiflowState>() {
      @java.lang.Override
      public MultiflowState parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MultiflowState(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MultiflowState> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MultiflowState> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public MultiflowStateProto.MultiflowState getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MultiflowState_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MultiflowState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024multiflowState.proto\"2\n\016MultiflowState" +
      "\022\014\n\004data\030\001 \002(\005\022\022\n\ncommondata\030\002 \002(\005B\025B\023Mu" +
      "ltiflowStateProto"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_MultiflowState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MultiflowState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MultiflowState_descriptor,
        new java.lang.String[] { "Data", "Commondata", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
