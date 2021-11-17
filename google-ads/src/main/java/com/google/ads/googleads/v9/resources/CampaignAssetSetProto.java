// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v9/resources/campaign_asset_set.proto

package com.google.ads.googleads.v9.resources;

public final class CampaignAssetSetProto {
  private CampaignAssetSetProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v9_resources_CampaignAssetSet_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v9_resources_CampaignAssetSet_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n:google/ads/googleads/v9/resources/camp" +
      "aign_asset_set.proto\022!google.ads.googlea" +
      "ds.v9.resources\0329google/ads/googleads/v9" +
      "/enums/asset_set_link_status.proto\032\037goog" +
      "le/api/field_behavior.proto\032\031google/api/" +
      "resource.proto\032\034google/api/annotations.p" +
      "roto\"\256\003\n\020CampaignAssetSet\022H\n\rresource_na" +
      "me\030\001 \001(\tB1\340A\005\372A+\n)googleads.googleapis.c" +
      "om/CampaignAssetSet\022;\n\010campaign\030\002 \001(\tB)\340" +
      "A\005\372A#\n!googleads.googleapis.com/Campaign" +
      "\022<\n\tasset_set\030\003 \001(\tB)\340A\005\372A#\n!googleads.g" +
      "oogleapis.com/AssetSet\022]\n\006status\030\004 \001(\0162H" +
      ".google.ads.googleads.v9.enums.AssetSetL" +
      "inkStatusEnum.AssetSetLinkStatusB\003\340A\003:v\352" +
      "As\n)googleads.googleapis.com/CampaignAss" +
      "etSet\022Fcustomers/{customer_id}/campaignA" +
      "ssetSets/{campaign_id}~{asset_set_id}B\202\002" +
      "\n%com.google.ads.googleads.v9.resourcesB" +
      "\025CampaignAssetSetProtoP\001ZJgoogle.golang." +
      "org/genproto/googleapis/ads/googleads/v9" +
      "/resources;resources\242\002\003GAA\252\002!Google.Ads." +
      "GoogleAds.V9.Resources\312\002!Google\\Ads\\Goog" +
      "leAds\\V9\\Resources\352\002%Google::Ads::Google" +
      "Ads::V9::Resourcesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v9.enums.AssetSetLinkStatusProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
        });
    internal_static_google_ads_googleads_v9_resources_CampaignAssetSet_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v9_resources_CampaignAssetSet_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v9_resources_CampaignAssetSet_descriptor,
        new java.lang.String[] { "ResourceName", "Campaign", "AssetSet", "Status", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.ads.googleads.v9.enums.AssetSetLinkStatusProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}