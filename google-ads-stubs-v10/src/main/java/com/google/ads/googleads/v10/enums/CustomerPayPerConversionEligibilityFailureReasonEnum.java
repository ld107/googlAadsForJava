// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v10/enums/customer_pay_per_conversion_eligibility_failure_reason.proto

package com.google.ads.googleads.v10.enums;

/**
 * <pre>
 * Container for enum describing reasons why a customer is not eligible to use
 * PaymentMode.CONVERSIONS.
 * </pre>
 *
 * Protobuf type {@code google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum}
 */
public final class CustomerPayPerConversionEligibilityFailureReasonEnum extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum)
    CustomerPayPerConversionEligibilityFailureReasonEnumOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CustomerPayPerConversionEligibilityFailureReasonEnum.newBuilder() to construct.
  private CustomerPayPerConversionEligibilityFailureReasonEnum(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CustomerPayPerConversionEligibilityFailureReasonEnum() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CustomerPayPerConversionEligibilityFailureReasonEnum();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CustomerPayPerConversionEligibilityFailureReasonEnum(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
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
    return com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonProto.internal_static_google_ads_googleads_v10_enums_CustomerPayPerConversionEligibilityFailureReasonEnum_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonProto.internal_static_google_ads_googleads_v10_enums_CustomerPayPerConversionEligibilityFailureReasonEnum_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.class, com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.Builder.class);
  }

  /**
   * <pre>
   * Enum describing possible reasons a customer is not eligible to use
   * PaymentMode.CONVERSIONS.
   * </pre>
   *
   * Protobuf enum {@code google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.CustomerPayPerConversionEligibilityFailureReason}
   */
  public enum CustomerPayPerConversionEligibilityFailureReason
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * Not specified.
     * </pre>
     *
     * <code>UNSPECIFIED = 0;</code>
     */
    UNSPECIFIED(0),
    /**
     * <pre>
     * Used for return value only. Represents value unknown in this version.
     * </pre>
     *
     * <code>UNKNOWN = 1;</code>
     */
    UNKNOWN(1),
    /**
     * <pre>
     * Customer does not have enough conversions.
     * </pre>
     *
     * <code>NOT_ENOUGH_CONVERSIONS = 2;</code>
     */
    NOT_ENOUGH_CONVERSIONS(2),
    /**
     * <pre>
     * Customer's conversion lag is too high.
     * </pre>
     *
     * <code>CONVERSION_LAG_TOO_HIGH = 3;</code>
     */
    CONVERSION_LAG_TOO_HIGH(3),
    /**
     * <pre>
     * Customer uses shared budgets.
     * </pre>
     *
     * <code>HAS_CAMPAIGN_WITH_SHARED_BUDGET = 4;</code>
     */
    HAS_CAMPAIGN_WITH_SHARED_BUDGET(4),
    /**
     * <pre>
     * Customer has conversions with ConversionActionType.UPLOAD_CLICKS.
     * </pre>
     *
     * <code>HAS_UPLOAD_CLICKS_CONVERSION = 5;</code>
     */
    HAS_UPLOAD_CLICKS_CONVERSION(5),
    /**
     * <pre>
     * Customer's average daily spend is too high.
     * </pre>
     *
     * <code>AVERAGE_DAILY_SPEND_TOO_HIGH = 6;</code>
     */
    AVERAGE_DAILY_SPEND_TOO_HIGH(6),
    /**
     * <pre>
     * Customer's eligibility has not yet been calculated by the Google Ads
     * backend. Check back soon.
     * </pre>
     *
     * <code>ANALYSIS_NOT_COMPLETE = 7;</code>
     */
    ANALYSIS_NOT_COMPLETE(7),
    /**
     * <pre>
     * Customer is not eligible due to other reasons.
     * </pre>
     *
     * <code>OTHER = 8;</code>
     */
    OTHER(8),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     * Not specified.
     * </pre>
     *
     * <code>UNSPECIFIED = 0;</code>
     */
    public static final int UNSPECIFIED_VALUE = 0;
    /**
     * <pre>
     * Used for return value only. Represents value unknown in this version.
     * </pre>
     *
     * <code>UNKNOWN = 1;</code>
     */
    public static final int UNKNOWN_VALUE = 1;
    /**
     * <pre>
     * Customer does not have enough conversions.
     * </pre>
     *
     * <code>NOT_ENOUGH_CONVERSIONS = 2;</code>
     */
    public static final int NOT_ENOUGH_CONVERSIONS_VALUE = 2;
    /**
     * <pre>
     * Customer's conversion lag is too high.
     * </pre>
     *
     * <code>CONVERSION_LAG_TOO_HIGH = 3;</code>
     */
    public static final int CONVERSION_LAG_TOO_HIGH_VALUE = 3;
    /**
     * <pre>
     * Customer uses shared budgets.
     * </pre>
     *
     * <code>HAS_CAMPAIGN_WITH_SHARED_BUDGET = 4;</code>
     */
    public static final int HAS_CAMPAIGN_WITH_SHARED_BUDGET_VALUE = 4;
    /**
     * <pre>
     * Customer has conversions with ConversionActionType.UPLOAD_CLICKS.
     * </pre>
     *
     * <code>HAS_UPLOAD_CLICKS_CONVERSION = 5;</code>
     */
    public static final int HAS_UPLOAD_CLICKS_CONVERSION_VALUE = 5;
    /**
     * <pre>
     * Customer's average daily spend is too high.
     * </pre>
     *
     * <code>AVERAGE_DAILY_SPEND_TOO_HIGH = 6;</code>
     */
    public static final int AVERAGE_DAILY_SPEND_TOO_HIGH_VALUE = 6;
    /**
     * <pre>
     * Customer's eligibility has not yet been calculated by the Google Ads
     * backend. Check back soon.
     * </pre>
     *
     * <code>ANALYSIS_NOT_COMPLETE = 7;</code>
     */
    public static final int ANALYSIS_NOT_COMPLETE_VALUE = 7;
    /**
     * <pre>
     * Customer is not eligible due to other reasons.
     * </pre>
     *
     * <code>OTHER = 8;</code>
     */
    public static final int OTHER_VALUE = 8;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static CustomerPayPerConversionEligibilityFailureReason valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static CustomerPayPerConversionEligibilityFailureReason forNumber(int value) {
      switch (value) {
        case 0: return UNSPECIFIED;
        case 1: return UNKNOWN;
        case 2: return NOT_ENOUGH_CONVERSIONS;
        case 3: return CONVERSION_LAG_TOO_HIGH;
        case 4: return HAS_CAMPAIGN_WITH_SHARED_BUDGET;
        case 5: return HAS_UPLOAD_CLICKS_CONVERSION;
        case 6: return AVERAGE_DAILY_SPEND_TOO_HIGH;
        case 7: return ANALYSIS_NOT_COMPLETE;
        case 8: return OTHER;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<CustomerPayPerConversionEligibilityFailureReason>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        CustomerPayPerConversionEligibilityFailureReason> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<CustomerPayPerConversionEligibilityFailureReason>() {
            public CustomerPayPerConversionEligibilityFailureReason findValueByNumber(int number) {
              return CustomerPayPerConversionEligibilityFailureReason.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.getDescriptor().getEnumTypes().get(0);
    }

    private static final CustomerPayPerConversionEligibilityFailureReason[] VALUES = values();

    public static CustomerPayPerConversionEligibilityFailureReason valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private CustomerPayPerConversionEligibilityFailureReason(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.CustomerPayPerConversionEligibilityFailureReason)
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
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum)) {
      return super.equals(obj);
    }
    com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum other = (com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum) obj;

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
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parseFrom(
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
  public static Builder newBuilder(com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum prototype) {
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
   * <pre>
   * Container for enum describing reasons why a customer is not eligible to use
   * PaymentMode.CONVERSIONS.
   * </pre>
   *
   * Protobuf type {@code google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum)
      com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnumOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonProto.internal_static_google_ads_googleads_v10_enums_CustomerPayPerConversionEligibilityFailureReasonEnum_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonProto.internal_static_google_ads_googleads_v10_enums_CustomerPayPerConversionEligibilityFailureReasonEnum_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.class, com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.Builder.class);
    }

    // Construct using com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.newBuilder()
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
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonProto.internal_static_google_ads_googleads_v10_enums_CustomerPayPerConversionEligibilityFailureReasonEnum_descriptor;
    }

    @java.lang.Override
    public com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum getDefaultInstanceForType() {
      return com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum build() {
      com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum buildPartial() {
      com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum result = new com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum(this);
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
      if (other instanceof com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum) {
        return mergeFrom((com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum other) {
      if (other == com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum.getDefaultInstance()) return this;
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
      com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
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


    // @@protoc_insertion_point(builder_scope:google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum)
  }

  // @@protoc_insertion_point(class_scope:google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum)
  private static final com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum();
  }

  public static com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CustomerPayPerConversionEligibilityFailureReasonEnum>
      PARSER = new com.google.protobuf.AbstractParser<CustomerPayPerConversionEligibilityFailureReasonEnum>() {
    @java.lang.Override
    public CustomerPayPerConversionEligibilityFailureReasonEnum parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CustomerPayPerConversionEligibilityFailureReasonEnum(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CustomerPayPerConversionEligibilityFailureReasonEnum> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CustomerPayPerConversionEligibilityFailureReasonEnum> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.ads.googleads.v10.enums.CustomerPayPerConversionEligibilityFailureReasonEnum getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
