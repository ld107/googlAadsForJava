// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v3/services/ad_parameter_service.proto

package com.google.ads.googleads.v3.services;

public final class AdParameterServiceProto {
  private AdParameterServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v3_services_GetAdParameterRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v3_services_GetAdParameterRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v3_services_MutateAdParametersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v3_services_MutateAdParametersRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v3_services_AdParameterOperation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v3_services_AdParameterOperation_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v3_services_MutateAdParametersResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v3_services_MutateAdParametersResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v3_services_MutateAdParameterResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v3_services_MutateAdParameterResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n;google/ads/googleads/v3/services/ad_pa" +
      "rameter_service.proto\022 google.ads.google" +
      "ads.v3.services\0324google/ads/googleads/v3" +
      "/resources/ad_parameter.proto\032\034google/ap" +
      "i/annotations.proto\032\027google/api/client.p" +
      "roto\032\037google/api/field_behavior.proto\032 g" +
      "oogle/protobuf/field_mask.proto\032\027google/" +
      "rpc/status.proto\"3\n\025GetAdParameterReques" +
      "t\022\032\n\rresource_name\030\001 \001(\tB\003\340A\002\"\266\001\n\031Mutate" +
      "AdParametersRequest\022\030\n\013customer_id\030\001 \001(\t" +
      "B\003\340A\002\022O\n\noperations\030\002 \003(\01326.google.ads.g" +
      "oogleads.v3.services.AdParameterOperatio" +
      "nB\003\340A\002\022\027\n\017partial_failure\030\003 \001(\010\022\025\n\rvalid" +
      "ate_only\030\004 \001(\010\"\352\001\n\024AdParameterOperation\022" +
      "/\n\013update_mask\030\004 \001(\0132\032.google.protobuf.F" +
      "ieldMask\022@\n\006create\030\001 \001(\0132..google.ads.go" +
      "ogleads.v3.resources.AdParameterH\000\022@\n\006up" +
      "date\030\002 \001(\0132..google.ads.googleads.v3.res" +
      "ources.AdParameterH\000\022\020\n\006remove\030\003 \001(\tH\000B\013" +
      "\n\toperation\"\233\001\n\032MutateAdParametersRespon" +
      "se\0221\n\025partial_failure_error\030\003 \001(\0132\022.goog" +
      "le.rpc.Status\022J\n\007results\030\002 \003(\01329.google." +
      "ads.googleads.v3.services.MutateAdParame" +
      "terResult\"0\n\027MutateAdParameterResult\022\025\n\r" +
      "resource_name\030\001 \001(\t2\336\003\n\022AdParameterServi" +
      "ce\022\301\001\n\016GetAdParameter\0227.google.ads.googl" +
      "eads.v3.services.GetAdParameterRequest\032." +
      ".google.ads.googleads.v3.resources.AdPar" +
      "ameter\"F\202\323\344\223\0020\022./v3/{resource_name=custo" +
      "mers/*/adParameters/*}\332A\rresource_name\022\346" +
      "\001\n\022MutateAdParameters\022;.google.ads.googl" +
      "eads.v3.services.MutateAdParametersReque" +
      "st\032<.google.ads.googleads.v3.services.Mu" +
      "tateAdParametersResponse\"U\202\323\344\223\0026\"1/v3/cu" +
      "stomers/{customer_id=*}/adParameters:mut" +
      "ate:\001*\332A\026customer_id,operations\032\033\312A\030goog" +
      "leads.googleapis.comB\376\001\n$com.google.ads." +
      "googleads.v3.servicesB\027AdParameterServic" +
      "eProtoP\001ZHgoogle.golang.org/genproto/goo" +
      "gleapis/ads/googleads/v3/services;servic" +
      "es\242\002\003GAA\252\002 Google.Ads.GoogleAds.V3.Servi" +
      "ces\312\002 Google\\Ads\\GoogleAds\\V3\\Services\352\002" +
      "$Google::Ads::GoogleAds::V3::Servicesb\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v3.resources.AdParameterProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.protobuf.FieldMaskProto.getDescriptor(),
          com.google.rpc.StatusProto.getDescriptor(),
        }, assigner);
    internal_static_google_ads_googleads_v3_services_GetAdParameterRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v3_services_GetAdParameterRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v3_services_GetAdParameterRequest_descriptor,
        new java.lang.String[] { "ResourceName", });
    internal_static_google_ads_googleads_v3_services_MutateAdParametersRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_ads_googleads_v3_services_MutateAdParametersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v3_services_MutateAdParametersRequest_descriptor,
        new java.lang.String[] { "CustomerId", "Operations", "PartialFailure", "ValidateOnly", });
    internal_static_google_ads_googleads_v3_services_AdParameterOperation_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_ads_googleads_v3_services_AdParameterOperation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v3_services_AdParameterOperation_descriptor,
        new java.lang.String[] { "UpdateMask", "Create", "Update", "Remove", "Operation", });
    internal_static_google_ads_googleads_v3_services_MutateAdParametersResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_ads_googleads_v3_services_MutateAdParametersResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v3_services_MutateAdParametersResponse_descriptor,
        new java.lang.String[] { "PartialFailureError", "Results", });
    internal_static_google_ads_googleads_v3_services_MutateAdParameterResult_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_ads_googleads_v3_services_MutateAdParameterResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v3_services_MutateAdParameterResult_descriptor,
        new java.lang.String[] { "ResourceName", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.ads.googleads.v3.resources.AdParameterProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}