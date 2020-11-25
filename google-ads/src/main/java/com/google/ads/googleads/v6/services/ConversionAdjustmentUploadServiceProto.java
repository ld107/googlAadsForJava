// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v6/services/conversion_adjustment_upload_service.proto

package com.google.ads.googleads.v6.services;

public final class ConversionAdjustmentUploadServiceProto {
  private ConversionAdjustmentUploadServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_ConversionAdjustment_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_ConversionAdjustment_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_RestatementValue_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_RestatementValue_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_GclidDateTimePair_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_GclidDateTimePair_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_ConversionAdjustmentResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_ConversionAdjustmentResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nKgoogle/ads/googleads/v6/services/conve" +
      "rsion_adjustment_upload_service.proto\022 g" +
      "oogle.ads.googleads.v6.services\032>google/" +
      "ads/googleads/v6/enums/conversion_adjust" +
      "ment_type.proto\032\034google/api/annotations." +
      "proto\032\027google/api/client.proto\032\037google/a" +
      "pi/field_behavior.proto\032\027google/rpc/stat" +
      "us.proto\"\320\001\n\"UploadConversionAdjustments" +
      "Request\022\030\n\013customer_id\030\001 \001(\tB\003\340A\002\022[\n\026con" +
      "version_adjustments\030\002 \003(\01326.google.ads.g" +
      "oogleads.v6.services.ConversionAdjustmen" +
      "tB\003\340A\002\022\034\n\017partial_failure\030\003 \001(\010B\003\340A\002\022\025\n\r" +
      "validate_only\030\004 \001(\010\"\247\001\n#UploadConversion" +
      "AdjustmentsResponse\0221\n\025partial_failure_e" +
      "rror\030\001 \001(\0132\022.google.rpc.Status\022M\n\007result" +
      "s\030\002 \003(\0132<.google.ads.googleads.v6.servic" +
      "es.ConversionAdjustmentResult\"\310\003\n\024Conver" +
      "sionAdjustment\022\036\n\021conversion_action\030\010 \001(" +
      "\tH\001\210\001\001\022!\n\024adjustment_date_time\030\t \001(\tH\002\210\001" +
      "\001\022m\n\017adjustment_type\030\005 \001(\0162T.google.ads." +
      "googleads.v6.enums.ConversionAdjustmentT" +
      "ypeEnum.ConversionAdjustmentType\022M\n\021rest" +
      "atement_value\030\006 \001(\01322.google.ads.googlea" +
      "ds.v6.services.RestatementValue\022S\n\024gclid" +
      "_date_time_pair\030\001 \001(\01323.google.ads.googl" +
      "eads.v6.services.GclidDateTimePairH\000\022\022\n\010" +
      "order_id\030\007 \001(\tH\000B\027\n\025conversion_identifie" +
      "rB\024\n\022_conversion_actionB\027\n\025_adjustment_d" +
      "ate_time\"p\n\020RestatementValue\022\033\n\016adjusted" +
      "_value\030\003 \001(\001H\000\210\001\001\022\032\n\rcurrency_code\030\004 \001(\t" +
      "H\001\210\001\001B\021\n\017_adjusted_valueB\020\n\016_currency_co" +
      "de\"m\n\021GclidDateTimePair\022\022\n\005gclid\030\003 \001(\tH\000" +
      "\210\001\001\022!\n\024conversion_date_time\030\004 \001(\tH\001\210\001\001B\010" +
      "\n\006_gclidB\027\n\025_conversion_date_time\"\377\002\n\032Co" +
      "nversionAdjustmentResult\022\036\n\021conversion_a" +
      "ction\030\007 \001(\tH\001\210\001\001\022!\n\024adjustment_date_time" +
      "\030\010 \001(\tH\002\210\001\001\022m\n\017adjustment_type\030\005 \001(\0162T.g" +
      "oogle.ads.googleads.v6.enums.ConversionA" +
      "djustmentTypeEnum.ConversionAdjustmentTy" +
      "pe\022S\n\024gclid_date_time_pair\030\001 \001(\01323.googl" +
      "e.ads.googleads.v6.services.GclidDateTim" +
      "ePairH\000\022\022\n\010order_id\030\006 \001(\tH\000B\027\n\025conversio" +
      "n_identifierB\024\n\022_conversion_actionB\027\n\025_a" +
      "djustment_date_time2\350\002\n!ConversionAdjust" +
      "mentUploadService\022\245\002\n\033UploadConversionAd" +
      "justments\022D.google.ads.googleads.v6.serv" +
      "ices.UploadConversionAdjustmentsRequest\032" +
      "E.google.ads.googleads.v6.services.Uploa" +
      "dConversionAdjustmentsResponse\"y\202\323\344\223\002>\"9" +
      "/v6/customers/{customer_id=*}:uploadConv" +
      "ersionAdjustments:\001*\332A2customer_id,conve" +
      "rsion_adjustments,partial_failure\032\033\312A\030go" +
      "ogleads.googleapis.comB\215\002\n$com.google.ad" +
      "s.googleads.v6.servicesB&ConversionAdjus" +
      "tmentUploadServiceProtoP\001ZHgoogle.golang" +
      ".org/genproto/googleapis/ads/googleads/v" +
      "6/services;services\242\002\003GAA\252\002 Google.Ads.G" +
      "oogleAds.V6.Services\312\002 Google\\Ads\\Google" +
      "Ads\\V6\\Services\352\002$Google::Ads::GoogleAds" +
      "::V6::Servicesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v6.enums.ConversionAdjustmentTypeProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.rpc.StatusProto.getDescriptor(),
        });
    internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsRequest_descriptor,
        new java.lang.String[] { "CustomerId", "ConversionAdjustments", "PartialFailure", "ValidateOnly", });
    internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_UploadConversionAdjustmentsResponse_descriptor,
        new java.lang.String[] { "PartialFailureError", "Results", });
    internal_static_google_ads_googleads_v6_services_ConversionAdjustment_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_ads_googleads_v6_services_ConversionAdjustment_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_ConversionAdjustment_descriptor,
        new java.lang.String[] { "ConversionAction", "AdjustmentDateTime", "AdjustmentType", "RestatementValue", "GclidDateTimePair", "OrderId", "ConversionIdentifier", "ConversionAction", "AdjustmentDateTime", });
    internal_static_google_ads_googleads_v6_services_RestatementValue_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_ads_googleads_v6_services_RestatementValue_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_RestatementValue_descriptor,
        new java.lang.String[] { "AdjustedValue", "CurrencyCode", "AdjustedValue", "CurrencyCode", });
    internal_static_google_ads_googleads_v6_services_GclidDateTimePair_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_ads_googleads_v6_services_GclidDateTimePair_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_GclidDateTimePair_descriptor,
        new java.lang.String[] { "Gclid", "ConversionDateTime", "Gclid", "ConversionDateTime", });
    internal_static_google_ads_googleads_v6_services_ConversionAdjustmentResult_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_ads_googleads_v6_services_ConversionAdjustmentResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_ConversionAdjustmentResult_descriptor,
        new java.lang.String[] { "ConversionAction", "AdjustmentDateTime", "AdjustmentType", "GclidDateTimePair", "OrderId", "ConversionIdentifier", "ConversionAction", "AdjustmentDateTime", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.ads.googleads.v6.enums.ConversionAdjustmentTypeProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}