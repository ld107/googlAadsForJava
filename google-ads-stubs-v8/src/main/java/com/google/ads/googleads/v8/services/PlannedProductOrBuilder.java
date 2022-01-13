// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v8/services/reach_plan_service.proto

package com.google.ads.googleads.v8.services;

public interface PlannedProductOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ads.googleads.v8.services.PlannedProduct)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. Selected product for planning.
   * The code associated with the ad product. E.g. Trueview, Bumper
   * To list the available plannable product codes use
   * [ReachPlanService.ListPlannableProducts][google.ads.googleads.v8.services.ReachPlanService.ListPlannableProducts].
   * </pre>
   *
   * <code>optional string plannable_product_code = 3;</code>
   * @return Whether the plannableProductCode field is set.
   */
  boolean hasPlannableProductCode();
  /**
   * <pre>
   * Required. Selected product for planning.
   * The code associated with the ad product. E.g. Trueview, Bumper
   * To list the available plannable product codes use
   * [ReachPlanService.ListPlannableProducts][google.ads.googleads.v8.services.ReachPlanService.ListPlannableProducts].
   * </pre>
   *
   * <code>optional string plannable_product_code = 3;</code>
   * @return The plannableProductCode.
   */
  java.lang.String getPlannableProductCode();
  /**
   * <pre>
   * Required. Selected product for planning.
   * The code associated with the ad product. E.g. Trueview, Bumper
   * To list the available plannable product codes use
   * [ReachPlanService.ListPlannableProducts][google.ads.googleads.v8.services.ReachPlanService.ListPlannableProducts].
   * </pre>
   *
   * <code>optional string plannable_product_code = 3;</code>
   * @return The bytes for plannableProductCode.
   */
  com.google.protobuf.ByteString
      getPlannableProductCodeBytes();

  /**
   * <pre>
   * Required. Maximum budget allocation in micros for the selected product.
   * The value is specified in the selected planning currency_code.
   * E.g. 1 000 000$ = 1 000 000 000 000 micros.
   * </pre>
   *
   * <code>optional int64 budget_micros = 4;</code>
   * @return Whether the budgetMicros field is set.
   */
  boolean hasBudgetMicros();
  /**
   * <pre>
   * Required. Maximum budget allocation in micros for the selected product.
   * The value is specified in the selected planning currency_code.
   * E.g. 1 000 000$ = 1 000 000 000 000 micros.
   * </pre>
   *
   * <code>optional int64 budget_micros = 4;</code>
   * @return The budgetMicros.
   */
  long getBudgetMicros();
}