// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v11/resources/conversion_custom_variable.proto

package com.google.ads.googleads.v11.resources;

public final class ConversionCustomVariableProto {
  private ConversionCustomVariableProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_resources_ConversionCustomVariable_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_resources_ConversionCustomVariable_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nCgoogle/ads/googleads/v11/resources/con" +
      "version_custom_variable.proto\022\"google.ad" +
      "s.googleads.v11.resources\032Fgoogle/ads/go" +
      "ogleads/v11/enums/conversion_custom_vari" +
      "able_status.proto\032\037google/api/field_beha" +
      "vior.proto\032\031google/api/resource.proto\"\350\003" +
      "\n\030ConversionCustomVariable\022P\n\rresource_n" +
      "ame\030\001 \001(\tB9\340A\005\372A3\n1googleads.googleapis." +
      "com/ConversionCustomVariable\022\017\n\002id\030\002 \001(\003" +
      "B\003\340A\003\022\021\n\004name\030\003 \001(\tB\003\340A\002\022\023\n\003tag\030\004 \001(\tB\006\340" +
      "A\002\340A\005\022q\n\006status\030\005 \001(\0162a.google.ads.googl" +
      "eads.v11.enums.ConversionCustomVariableS" +
      "tatusEnum.ConversionCustomVariableStatus" +
      "\022A\n\016owner_customer\030\006 \001(\tB)\340A\003\372A#\n!google" +
      "ads.googleapis.com/Customer:\212\001\352A\206\001\n1goog" +
      "leads.googleapis.com/ConversionCustomVar" +
      "iable\022Qcustomers/{customer_id}/conversio" +
      "nCustomVariables/{conversion_custom_vari" +
      "able_id}B\217\002\n&com.google.ads.googleads.v1" +
      "1.resourcesB\035ConversionCustomVariablePro" +
      "toP\001ZKgoogle.golang.org/genproto/googlea" +
      "pis/ads/googleads/v11/resources;resource" +
      "s\242\002\003GAA\252\002\"Google.Ads.GoogleAds.V11.Resou" +
      "rces\312\002\"Google\\Ads\\GoogleAds\\V11\\Resource" +
      "s\352\002&Google::Ads::GoogleAds::V11::Resourc" +
      "esb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v11.enums.ConversionCustomVariableStatusProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
        });
    internal_static_google_ads_googleads_v11_resources_ConversionCustomVariable_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v11_resources_ConversionCustomVariable_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_resources_ConversionCustomVariable_descriptor,
        new java.lang.String[] { "ResourceName", "Id", "Name", "Tag", "Status", "OwnerCustomer", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.ads.googleads.v11.enums.ConversionCustomVariableStatusProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}