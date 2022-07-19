// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v11/services/reach_plan_service.proto

package com.google.ads.googleads.v11.services;

public interface PreferencesOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ads.googleads.v11.services.Preferences)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * True if ad skippable.
   * If not set, default is any value.
   * </pre>
   *
   * <code>optional bool is_skippable = 6;</code>
   * @return Whether the isSkippable field is set.
   */
  boolean hasIsSkippable();
  /**
   * <pre>
   * True if ad skippable.
   * If not set, default is any value.
   * </pre>
   *
   * <code>optional bool is_skippable = 6;</code>
   * @return The isSkippable.
   */
  boolean getIsSkippable();

  /**
   * <pre>
   * True if ad start with sound.
   * If not set, default is any value.
   * </pre>
   *
   * <code>optional bool starts_with_sound = 7;</code>
   * @return Whether the startsWithSound field is set.
   */
  boolean hasStartsWithSound();
  /**
   * <pre>
   * True if ad start with sound.
   * If not set, default is any value.
   * </pre>
   *
   * <code>optional bool starts_with_sound = 7;</code>
   * @return The startsWithSound.
   */
  boolean getStartsWithSound();

  /**
   * <pre>
   * The length of the ad.
   * If not set, default is any value.
   * </pre>
   *
   * <code>.google.ads.googleads.v11.enums.ReachPlanAdLengthEnum.ReachPlanAdLength ad_length = 3;</code>
   * @return The enum numeric value on the wire for adLength.
   */
  int getAdLengthValue();
  /**
   * <pre>
   * The length of the ad.
   * If not set, default is any value.
   * </pre>
   *
   * <code>.google.ads.googleads.v11.enums.ReachPlanAdLengthEnum.ReachPlanAdLength ad_length = 3;</code>
   * @return The adLength.
   */
  com.google.ads.googleads.v11.enums.ReachPlanAdLengthEnum.ReachPlanAdLength getAdLength();

  /**
   * <pre>
   * True if ad will only show on the top content.
   * If not set, default is false.
   * </pre>
   *
   * <code>optional bool top_content_only = 8;</code>
   * @return Whether the topContentOnly field is set.
   */
  boolean hasTopContentOnly();
  /**
   * <pre>
   * True if ad will only show on the top content.
   * If not set, default is false.
   * </pre>
   *
   * <code>optional bool top_content_only = 8;</code>
   * @return The topContentOnly.
   */
  boolean getTopContentOnly();

  /**
   * <pre>
   * True if the price is guaranteed. The cost of serving the ad is agreed
   * upfront and not subject to an auction.
   * If not set, default is any value.
   * </pre>
   *
   * <code>optional bool has_guaranteed_price = 9;</code>
   * @return Whether the hasGuaranteedPrice field is set.
   */
  boolean hasHasGuaranteedPrice();
  /**
   * <pre>
   * True if the price is guaranteed. The cost of serving the ad is agreed
   * upfront and not subject to an auction.
   * If not set, default is any value.
   * </pre>
   *
   * <code>optional bool has_guaranteed_price = 9;</code>
   * @return The hasGuaranteedPrice.
   */
  boolean getHasGuaranteedPrice();
}