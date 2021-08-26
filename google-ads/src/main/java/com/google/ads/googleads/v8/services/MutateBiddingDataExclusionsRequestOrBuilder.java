// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v8/services/bidding_data_exclusion_service.proto

package com.google.ads.googleads.v8.services;

public interface MutateBiddingDataExclusionsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ads.googleads.v8.services.MutateBiddingDataExclusionsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. ID of the customer whose data exclusions are being modified.
   * </pre>
   *
   * <code>string customer_id = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The customerId.
   */
  java.lang.String getCustomerId();
  /**
   * <pre>
   * Required. ID of the customer whose data exclusions are being modified.
   * </pre>
   *
   * <code>string customer_id = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for customerId.
   */
  com.google.protobuf.ByteString
      getCustomerIdBytes();

  /**
   * <pre>
   * Required. The list of operations to perform on individual data exclusions.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v8.services.BiddingDataExclusionOperation operations = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  java.util.List<com.google.ads.googleads.v8.services.BiddingDataExclusionOperation> 
      getOperationsList();
  /**
   * <pre>
   * Required. The list of operations to perform on individual data exclusions.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v8.services.BiddingDataExclusionOperation operations = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.ads.googleads.v8.services.BiddingDataExclusionOperation getOperations(int index);
  /**
   * <pre>
   * Required. The list of operations to perform on individual data exclusions.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v8.services.BiddingDataExclusionOperation operations = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  int getOperationsCount();
  /**
   * <pre>
   * Required. The list of operations to perform on individual data exclusions.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v8.services.BiddingDataExclusionOperation operations = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  java.util.List<? extends com.google.ads.googleads.v8.services.BiddingDataExclusionOperationOrBuilder> 
      getOperationsOrBuilderList();
  /**
   * <pre>
   * Required. The list of operations to perform on individual data exclusions.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v8.services.BiddingDataExclusionOperation operations = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.ads.googleads.v8.services.BiddingDataExclusionOperationOrBuilder getOperationsOrBuilder(
      int index);

  /**
   * <pre>
   * If true, successful operations will be carried out and invalid
   * operations will return errors. If false, all operations will be carried
   * out in one transaction if and only if they are all valid.
   * Default is false.
   * </pre>
   *
   * <code>bool partial_failure = 3;</code>
   * @return The partialFailure.
   */
  boolean getPartialFailure();

  /**
   * <pre>
   * If true, the request is validated but not executed. Only errors are
   * returned, not results.
   * </pre>
   *
   * <code>bool validate_only = 4;</code>
   * @return The validateOnly.
   */
  boolean getValidateOnly();

  /**
   * <pre>
   * The response content type setting. Determines whether the mutable resource
   * or just the resource name should be returned post mutation.
   * </pre>
   *
   * <code>.google.ads.googleads.v8.enums.ResponseContentTypeEnum.ResponseContentType response_content_type = 5;</code>
   * @return The enum numeric value on the wire for responseContentType.
   */
  int getResponseContentTypeValue();
  /**
   * <pre>
   * The response content type setting. Determines whether the mutable resource
   * or just the resource name should be returned post mutation.
   * </pre>
   *
   * <code>.google.ads.googleads.v8.enums.ResponseContentTypeEnum.ResponseContentType response_content_type = 5;</code>
   * @return The responseContentType.
   */
  com.google.ads.googleads.v8.enums.ResponseContentTypeEnum.ResponseContentType getResponseContentType();
}