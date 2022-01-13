// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v8/services/webpage_view_service.proto

package com.google.ads.googleads.v8.services;

public final class WebpageViewServiceProto {
  private WebpageViewServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v8_services_GetWebpageViewRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v8_services_GetWebpageViewRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n;google/ads/googleads/v8/services/webpa" +
      "ge_view_service.proto\022 google.ads.google" +
      "ads.v8.services\0324google/ads/googleads/v8" +
      "/resources/webpage_view.proto\032\034google/ap" +
      "i/annotations.proto\032\027google/api/client.p" +
      "roto\032\037google/api/field_behavior.proto\032\031g" +
      "oogle/api/resource.proto\"\\\n\025GetWebpageVi" +
      "ewRequest\022C\n\rresource_name\030\001 \001(\tB,\340A\002\372A&" +
      "\n$googleads.googleapis.com/WebpageView2\237" +
      "\002\n\022WebpageViewService\022\301\001\n\016GetWebpageView" +
      "\0227.google.ads.googleads.v8.services.GetW" +
      "ebpageViewRequest\032..google.ads.googleads" +
      ".v8.resources.WebpageView\"F\202\323\344\223\0020\022./v8/{" +
      "resource_name=customers/*/webpageViews/*" +
      "}\332A\rresource_name\032E\312A\030googleads.googleap" +
      "is.com\322A\'https://www.googleapis.com/auth" +
      "/adwordsB\376\001\n$com.google.ads.googleads.v8" +
      ".servicesB\027WebpageViewServiceProtoP\001ZHgo" +
      "ogle.golang.org/genproto/googleapis/ads/" +
      "googleads/v8/services;services\242\002\003GAA\252\002 G" +
      "oogle.Ads.GoogleAds.V8.Services\312\002 Google" +
      "\\Ads\\GoogleAds\\V8\\Services\352\002$Google::Ads" +
      "::GoogleAds::V8::Servicesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v8.resources.WebpageViewProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
        });
    internal_static_google_ads_googleads_v8_services_GetWebpageViewRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v8_services_GetWebpageViewRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v8_services_GetWebpageViewRequest_descriptor,
        new java.lang.String[] { "ResourceName", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.ads.googleads.v8.resources.WebpageViewProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}