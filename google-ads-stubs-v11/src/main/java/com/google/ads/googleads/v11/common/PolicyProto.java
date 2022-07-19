// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v11/common/policy.proto

package com.google.ads.googleads.v11.common;

public final class PolicyProto {
  private PolicyProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyViolationKey_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyViolationKey_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyValidationParameter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyValidationParameter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_TextList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_TextList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_WebsiteList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_WebsiteList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationTextList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationTextList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationMismatch_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationMismatch_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationNotWorking_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationNotWorking_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraintList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraintList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_ResellerConstraint_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_ResellerConstraint_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraint_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraint_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n,google/ads/googleads/v11/common/policy" +
      ".proto\022\037google.ads.googleads.v11.common\032" +
      "<google/ads/googleads/v11/enums/policy_t" +
      "opic_entry_type.proto\032Xgoogle/ads/google" +
      "ads/v11/enums/policy_topic_evidence_dest" +
      "ination_mismatch_url_type.proto\032Ygoogle/" +
      "ads/googleads/v11/enums/policy_topic_evi" +
      "dence_destination_not_working_device.pro" +
      "to\032agoogle/ads/googleads/v11/enums/polic" +
      "y_topic_evidence_destination_not_working" +
      "_dns_error_type.proto\"n\n\022PolicyViolation" +
      "Key\022\030\n\013policy_name\030\003 \001(\tH\000\210\001\001\022\033\n\016violati" +
      "ng_text\030\004 \001(\tH\001\210\001\001B\016\n\014_policy_nameB\021\n\017_v" +
      "iolating_text\"\227\001\n\031PolicyValidationParame" +
      "ter\022\037\n\027ignorable_policy_topics\030\003 \003(\t\022Y\n\034" +
      "exempt_policy_violation_keys\030\002 \003(\01323.goo" +
      "gle.ads.googleads.v11.common.PolicyViola" +
      "tionKey\"\243\002\n\020PolicyTopicEntry\022\022\n\005topic\030\005 " +
      "\001(\tH\000\210\001\001\022[\n\004type\030\002 \001(\0162M.google.ads.goog" +
      "leads.v11.enums.PolicyTopicEntryTypeEnum" +
      ".PolicyTopicEntryType\022G\n\tevidences\030\003 \003(\013" +
      "24.google.ads.googleads.v11.common.Polic" +
      "yTopicEvidence\022K\n\013constraints\030\004 \003(\01326.go" +
      "ogle.ads.googleads.v11.common.PolicyTopi" +
      "cConstraintB\010\n\006_topic\"\257\n\n\023PolicyTopicEvi" +
      "dence\022X\n\014website_list\030\003 \001(\0132@.google.ads" +
      ".googleads.v11.common.PolicyTopicEvidenc" +
      "e.WebsiteListH\000\022R\n\ttext_list\030\004 \001(\0132=.goo" +
      "gle.ads.googleads.v11.common.PolicyTopic" +
      "Evidence.TextListH\000\022\027\n\rlanguage_code\030\t \001" +
      "(\tH\000\022i\n\025destination_text_list\030\006 \001(\0132H.go" +
      "ogle.ads.googleads.v11.common.PolicyTopi" +
      "cEvidence.DestinationTextListH\000\022h\n\024desti" +
      "nation_mismatch\030\007 \001(\0132H.google.ads.googl" +
      "eads.v11.common.PolicyTopicEvidence.Dest" +
      "inationMismatchH\000\022m\n\027destination_not_wor" +
      "king\030\010 \001(\0132J.google.ads.googleads.v11.co" +
      "mmon.PolicyTopicEvidence.DestinationNotW" +
      "orkingH\000\032\031\n\010TextList\022\r\n\005texts\030\002 \003(\t\032\037\n\013W" +
      "ebsiteList\022\020\n\010websites\030\002 \003(\t\0320\n\023Destinat" +
      "ionTextList\022\031\n\021destination_texts\030\002 \003(\t\032\252" +
      "\001\n\023DestinationMismatch\022\222\001\n\turl_types\030\001 \003" +
      "(\0162\177.google.ads.googleads.v11.enums.Poli" +
      "cyTopicEvidenceDestinationMismatchUrlTyp" +
      "eEnum.PolicyTopicEvidenceDestinationMism" +
      "atchUrlType\032\350\003\n\025DestinationNotWorking\022\031\n" +
      "\014expanded_url\030\007 \001(\tH\001\210\001\001\022\222\001\n\006device\030\004 \001(" +
      "\0162\201\001.google.ads.googleads.v11.enums.Poli" +
      "cyTopicEvidenceDestinationNotWorkingDevi" +
      "ceEnum.PolicyTopicEvidenceDestinationNot" +
      "WorkingDevice\022#\n\026last_checked_date_time\030" +
      "\010 \001(\tH\002\210\001\001\022\250\001\n\016dns_error_type\030\001 \001(\0162\215\001.g" +
      "oogle.ads.googleads.v11.enums.PolicyTopi" +
      "cEvidenceDestinationNotWorkingDnsErrorTy" +
      "peEnum.PolicyTopicEvidenceDestinationNot" +
      "WorkingDnsErrorTypeH\000\022\031\n\017http_error_code" +
      "\030\006 \001(\003H\000B\010\n\006reasonB\017\n\r_expanded_urlB\031\n\027_" +
      "last_checked_date_timeB\007\n\005value\"\232\006\n\025Poli" +
      "cyTopicConstraint\022o\n\027country_constraint_" +
      "list\030\001 \001(\0132L.google.ads.googleads.v11.co" +
      "mmon.PolicyTopicConstraint.CountryConstr" +
      "aintListH\000\022h\n\023reseller_constraint\030\002 \001(\0132" +
      "I.google.ads.googleads.v11.common.Policy" +
      "TopicConstraint.ResellerConstraintH\000\022{\n#" +
      "certificate_missing_in_country_list\030\003 \001(" +
      "\0132L.google.ads.googleads.v11.common.Poli" +
      "cyTopicConstraint.CountryConstraintListH" +
      "\000\022\203\001\n+certificate_domain_mismatch_in_cou" +
      "ntry_list\030\004 \001(\0132L.google.ads.googleads.v" +
      "11.common.PolicyTopicConstraint.CountryC" +
      "onstraintListH\000\032\270\001\n\025CountryConstraintLis" +
      "t\022%\n\030total_targeted_countries\030\003 \001(\005H\000\210\001\001" +
      "\022[\n\tcountries\030\002 \003(\0132H.google.ads.googlea" +
      "ds.v11.common.PolicyTopicConstraint.Coun" +
      "tryConstraintB\033\n\031_total_targeted_countri" +
      "es\032\024\n\022ResellerConstraint\032I\n\021CountryConst" +
      "raint\022\036\n\021country_criterion\030\002 \001(\tH\000\210\001\001B\024\n" +
      "\022_country_criterionB\007\n\005valueB\353\001\n#com.goo" +
      "gle.ads.googleads.v11.commonB\013PolicyProt" +
      "oP\001ZEgoogle.golang.org/genproto/googleap" +
      "is/ads/googleads/v11/common;common\242\002\003GAA" +
      "\252\002\037Google.Ads.GoogleAds.V11.Common\312\002\037Goo" +
      "gle\\Ads\\GoogleAds\\V11\\Common\352\002#Google::A" +
      "ds::GoogleAds::V11::Commonb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v11.enums.PolicyTopicEntryTypeProto.getDescriptor(),
          com.google.ads.googleads.v11.enums.PolicyTopicEvidenceDestinationMismatchUrlTypeProto.getDescriptor(),
          com.google.ads.googleads.v11.enums.PolicyTopicEvidenceDestinationNotWorkingDeviceProto.getDescriptor(),
          com.google.ads.googleads.v11.enums.PolicyTopicEvidenceDestinationNotWorkingDnsErrorTypeProto.getDescriptor(),
        });
    internal_static_google_ads_googleads_v11_common_PolicyViolationKey_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v11_common_PolicyViolationKey_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyViolationKey_descriptor,
        new java.lang.String[] { "PolicyName", "ViolatingText", "PolicyName", "ViolatingText", });
    internal_static_google_ads_googleads_v11_common_PolicyValidationParameter_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_ads_googleads_v11_common_PolicyValidationParameter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyValidationParameter_descriptor,
        new java.lang.String[] { "IgnorablePolicyTopics", "ExemptPolicyViolationKeys", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicEntry_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_ads_googleads_v11_common_PolicyTopicEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicEntry_descriptor,
        new java.lang.String[] { "Topic", "Type", "Evidences", "Constraints", "Topic", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_descriptor,
        new java.lang.String[] { "WebsiteList", "TextList", "LanguageCode", "DestinationTextList", "DestinationMismatch", "DestinationNotWorking", "Value", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_TextList_descriptor =
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_descriptor.getNestedTypes().get(0);
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_TextList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_TextList_descriptor,
        new java.lang.String[] { "Texts", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_WebsiteList_descriptor =
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_descriptor.getNestedTypes().get(1);
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_WebsiteList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_WebsiteList_descriptor,
        new java.lang.String[] { "Websites", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationTextList_descriptor =
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_descriptor.getNestedTypes().get(2);
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationTextList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationTextList_descriptor,
        new java.lang.String[] { "DestinationTexts", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationMismatch_descriptor =
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_descriptor.getNestedTypes().get(3);
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationMismatch_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationMismatch_descriptor,
        new java.lang.String[] { "UrlTypes", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationNotWorking_descriptor =
      internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_descriptor.getNestedTypes().get(4);
    internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationNotWorking_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicEvidence_DestinationNotWorking_descriptor,
        new java.lang.String[] { "ExpandedUrl", "Device", "LastCheckedDateTime", "DnsErrorType", "HttpErrorCode", "Reason", "ExpandedUrl", "LastCheckedDateTime", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_descriptor,
        new java.lang.String[] { "CountryConstraintList", "ResellerConstraint", "CertificateMissingInCountryList", "CertificateDomainMismatchInCountryList", "Value", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraintList_descriptor =
      internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_descriptor.getNestedTypes().get(0);
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraintList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraintList_descriptor,
        new java.lang.String[] { "TotalTargetedCountries", "Countries", "TotalTargetedCountries", });
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_ResellerConstraint_descriptor =
      internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_descriptor.getNestedTypes().get(1);
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_ResellerConstraint_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_ResellerConstraint_descriptor,
        new java.lang.String[] { });
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraint_descriptor =
      internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_descriptor.getNestedTypes().get(2);
    internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraint_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v11_common_PolicyTopicConstraint_CountryConstraint_descriptor,
        new java.lang.String[] { "CountryCriterion", "CountryCriterion", });
    com.google.ads.googleads.v11.enums.PolicyTopicEntryTypeProto.getDescriptor();
    com.google.ads.googleads.v11.enums.PolicyTopicEvidenceDestinationMismatchUrlTypeProto.getDescriptor();
    com.google.ads.googleads.v11.enums.PolicyTopicEvidenceDestinationNotWorkingDeviceProto.getDescriptor();
    com.google.ads.googleads.v11.enums.PolicyTopicEvidenceDestinationNotWorkingDnsErrorTypeProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}