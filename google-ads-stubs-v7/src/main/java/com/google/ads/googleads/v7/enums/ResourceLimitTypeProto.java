// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v7/enums/resource_limit_type.proto

package com.google.ads.googleads.v7.enums;

public final class ResourceLimitTypeProto {
  private ResourceLimitTypeProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v7_enums_ResourceLimitTypeEnum_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v7_enums_ResourceLimitTypeEnum_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n7google/ads/googleads/v7/enums/resource" +
      "_limit_type.proto\022\035google.ads.googleads." +
      "v7.enums\032\034google/api/annotations.proto\"\300" +
      "\032\n\025ResourceLimitTypeEnum\"\246\032\n\021ResourceLim" +
      "itType\022\017\n\013UNSPECIFIED\020\000\022\013\n\007UNKNOWN\020\001\022\032\n\026" +
      "CAMPAIGNS_PER_CUSTOMER\020\002\022\037\n\033BASE_CAMPAIG" +
      "NS_PER_CUSTOMER\020\003\022%\n!EXPERIMENT_CAMPAIGN" +
      "S_PER_CUSTOMER\020i\022 \n\034HOTEL_CAMPAIGNS_PER_" +
      "CUSTOMER\020\004\022)\n%SMART_SHOPPING_CAMPAIGNS_P" +
      "ER_CUSTOMER\020\005\022\032\n\026AD_GROUPS_PER_CAMPAIGN\020" +
      "\006\022#\n\037AD_GROUPS_PER_SHOPPING_CAMPAIGN\020\010\022 " +
      "\n\034AD_GROUPS_PER_HOTEL_CAMPAIGN\020\t\022*\n&REPO" +
      "RTING_AD_GROUPS_PER_LOCAL_CAMPAIGN\020\n\022(\n$" +
      "REPORTING_AD_GROUPS_PER_APP_CAMPAIGN\020\013\022(" +
      "\n$MANAGED_AD_GROUPS_PER_SMART_CAMPAIGN\0204" +
      "\022\"\n\036AD_GROUP_CRITERIA_PER_CUSTOMER\020\014\022\'\n#" +
      "BASE_AD_GROUP_CRITERIA_PER_CUSTOMER\020\r\022-\n" +
      ")EXPERIMENT_AD_GROUP_CRITERIA_PER_CUSTOM" +
      "ER\020k\022\"\n\036AD_GROUP_CRITERIA_PER_CAMPAIGN\020\016" +
      "\022\"\n\036CAMPAIGN_CRITERIA_PER_CUSTOMER\020\017\022\'\n#" +
      "BASE_CAMPAIGN_CRITERIA_PER_CUSTOMER\020\020\022-\n" +
      ")EXPERIMENT_CAMPAIGN_CRITERIA_PER_CUSTOM" +
      "ER\020l\022!\n\035WEBPAGE_CRITERIA_PER_CUSTOMER\020\021\022" +
      "&\n\"BASE_WEBPAGE_CRITERIA_PER_CUSTOMER\020\022\022" +
      ",\n(EXPERIMENT_WEBPAGE_CRITERIA_PER_CUSTO" +
      "MER\020\023\022+\n\'COMBINED_AUDIENCE_CRITERIA_PER_" +
      "AD_GROUP\020\024\0225\n1CUSTOMER_NEGATIVE_PLACEMEN" +
      "T_CRITERIA_PER_CUSTOMER\020\025\022;\n7CUSTOMER_NE" +
      "GATIVE_YOUTUBE_CHANNEL_CRITERIA_PER_CUST" +
      "OMER\020\026\022\031\n\025CRITERIA_PER_AD_GROUP\020\027\022\037\n\033LIS" +
      "TING_GROUPS_PER_AD_GROUP\020\030\022*\n&EXPLICITLY" +
      "_SHARED_BUDGETS_PER_CUSTOMER\020\031\022*\n&IMPLIC" +
      "ITLY_SHARED_BUDGETS_PER_CUSTOMER\020\032\022+\n\'CO" +
      "MBINED_AUDIENCE_CRITERIA_PER_CAMPAIGN\020\033\022" +
      "\"\n\036NEGATIVE_KEYWORDS_PER_CAMPAIGN\020\034\022$\n N" +
      "EGATIVE_PLACEMENTS_PER_CAMPAIGN\020\035\022\034\n\030GEO" +
      "_TARGETS_PER_CAMPAIGN\020\036\022#\n\037NEGATIVE_IP_B" +
      "LOCKS_PER_CAMPAIGN\020 \022\034\n\030PROXIMITIES_PER_" +
      "CAMPAIGN\020!\022(\n$LISTING_SCOPES_PER_SHOPPIN" +
      "G_CAMPAIGN\020\"\022,\n(LISTING_SCOPES_PER_NON_S" +
      "HOPPING_CAMPAIGN\020#\022$\n NEGATIVE_KEYWORDS_" +
      "PER_SHARED_SET\020$\022&\n\"NEGATIVE_PLACEMENTS_" +
      "PER_SHARED_SET\020%\022-\n)SHARED_SETS_PER_CUST" +
      "OMER_FOR_TYPE_DEFAULT\020(\022>\n:SHARED_SETS_P" +
      "ER_CUSTOMER_FOR_NEGATIVE_PLACEMENT_LIST_" +
      "LOWER\020)\022;\n7HOTEL_ADVANCE_BOOKING_WINDOW_" +
      "BID_MODIFIERS_PER_AD_GROUP\020,\022#\n\037BIDDING_" +
      "STRATEGIES_PER_CUSTOMER\020-\022!\n\035BASIC_USER_" +
      "LISTS_PER_CUSTOMER\020/\022#\n\037LOGICAL_USER_LIS" +
      "TS_PER_CUSTOMER\0200\022\"\n\036BASE_AD_GROUP_ADS_P" +
      "ER_CUSTOMER\0205\022(\n$EXPERIMENT_AD_GROUP_ADS" +
      "_PER_CUSTOMER\0206\022\035\n\031AD_GROUP_ADS_PER_CAMP" +
      "AIGN\0207\022#\n\037TEXT_AND_OTHER_ADS_PER_AD_GROU" +
      "P\0208\022\032\n\026IMAGE_ADS_PER_AD_GROUP\0209\022#\n\037SHOPP" +
      "ING_SMART_ADS_PER_AD_GROUP\020:\022&\n\"RESPONSI" +
      "VE_SEARCH_ADS_PER_AD_GROUP\020;\022\030\n\024APP_ADS_" +
      "PER_AD_GROUP\020<\022#\n\037APP_ENGAGEMENT_ADS_PER" +
      "_AD_GROUP\020=\022\032\n\026LOCAL_ADS_PER_AD_GROUP\020>\022" +
      "\032\n\026VIDEO_ADS_PER_AD_GROUP\020?\022&\n\"LEAD_FORM" +
      "_ASSET_LINKS_PER_CAMPAIGN\020D\022\023\n\017VERSIONS_" +
      "PER_AD\020R\022\033\n\027USER_FEEDS_PER_CUSTOMER\020Z\022\035\n" +
      "\031SYSTEM_FEEDS_PER_CUSTOMER\020[\022\034\n\030FEED_ATT" +
      "RIBUTES_PER_FEED\020\\\022\033\n\027FEED_ITEMS_PER_CUS" +
      "TOMER\020^\022\037\n\033CAMPAIGN_FEEDS_PER_CUSTOMER\020_" +
      "\022$\n BASE_CAMPAIGN_FEEDS_PER_CUSTOMER\020`\022*" +
      "\n&EXPERIMENT_CAMPAIGN_FEEDS_PER_CUSTOMER" +
      "\020m\022\037\n\033AD_GROUP_FEEDS_PER_CUSTOMER\020a\022$\n B" +
      "ASE_AD_GROUP_FEEDS_PER_CUSTOMER\020b\022*\n&EXP" +
      "ERIMENT_AD_GROUP_FEEDS_PER_CUSTOMER\020n\022\037\n" +
      "\033AD_GROUP_FEEDS_PER_CAMPAIGN\020c\022\037\n\033FEED_I" +
      "TEM_SETS_PER_CUSTOMER\020d\022 \n\034FEED_ITEMS_PE" +
      "R_FEED_ITEM_SET\020e\022%\n!CAMPAIGN_EXPERIMENT" +
      "S_PER_CUSTOMER\020p\022(\n$EXPERIMENT_ARMS_PER_" +
      "VIDEO_EXPERIMENT\020q\022\035\n\031OWNED_LABELS_PER_C" +
      "USTOMER\020s\022\027\n\023LABELS_PER_CAMPAIGN\020u\022\027\n\023LA" +
      "BELS_PER_AD_GROUP\020v\022\032\n\026LABELS_PER_AD_GRO" +
      "UP_AD\020w\022!\n\035LABELS_PER_AD_GROUP_CRITERION" +
      "\020x\022\036\n\032TARGET_CUSTOMERS_PER_LABEL\020y\022\'\n#KE" +
      "YWORD_PLANS_PER_USER_PER_CUSTOMER\020z\0223\n/K" +
      "EYWORD_PLAN_AD_GROUP_KEYWORDS_PER_KEYWOR" +
      "D_PLAN\020{\022+\n\'KEYWORD_PLAN_AD_GROUPS_PER_K" +
      "EYWORD_PLAN\020|\0223\n/KEYWORD_PLAN_NEGATIVE_K" +
      "EYWORDS_PER_KEYWORD_PLAN\020}\022+\n\'KEYWORD_PL" +
      "AN_CAMPAIGNS_PER_KEYWORD_PLAN\020~\022$\n\037CONVE" +
      "RSION_ACTIONS_PER_CUSTOMER\020\200\001\022!\n\034BATCH_J" +
      "OB_OPERATIONS_PER_JOB\020\202\001\022\034\n\027BATCH_JOBS_P" +
      "ER_CUSTOMER\020\203\001\0229\n4HOTEL_CHECK_IN_DATE_RA" +
      "NGE_BID_MODIFIERS_PER_AD_GROUP\020\204\001B\353\001\n!co" +
      "m.google.ads.googleads.v7.enumsB\026Resourc" +
      "eLimitTypeProtoP\001ZBgoogle.golang.org/gen" +
      "proto/googleapis/ads/googleads/v7/enums;" +
      "enums\242\002\003GAA\252\002\035Google.Ads.GoogleAds.V7.En" +
      "ums\312\002\035Google\\Ads\\GoogleAds\\V7\\Enums\352\002!Go" +
      "ogle::Ads::GoogleAds::V7::Enumsb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
        });
    internal_static_google_ads_googleads_v7_enums_ResourceLimitTypeEnum_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v7_enums_ResourceLimitTypeEnum_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v7_enums_ResourceLimitTypeEnum_descriptor,
        new java.lang.String[] { });
    com.google.api.AnnotationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}