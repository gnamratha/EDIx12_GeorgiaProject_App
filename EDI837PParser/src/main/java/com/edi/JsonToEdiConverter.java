//package com.edi;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.Map;
//import java.util.Iterator;
//
//
//import static com.fasterxml.jackson.databind.type.LogicalType.Map;
//
//public class JsonToEdiConverter {
//
//    public static void main(String[] args) {
//        // Your JSON string
//        String jsonString = "[{"
//                + "\"SegmentDelimiter\": \"~\","
//                + "\"DataElementDelimiter\": \"*\","+
////                " \"[\\n\" +\n" +
////                "            \"  {\\n\" +\n" +
////                "            \"    \\\"SegmentDelimiter\\\": \\\"~\\\",\\n\" +\n" +
////                "            \"    \\\"DataElementDelimiter\\\": \\\"*\\\",\\n\" +\n" +
//                "            \"    \\\"ISA\\\": {\\n\" +\n" +
//                "            \"      \\\"ISA01\\\": \\\"00\\\",\\n\" +\n" +
//                "            \"      \\\"ISA02\\\": \\\"          \\\",\\n\" +\n" +
//                "            \"      \\\"ISA03\\\": \\\"00\\\",\\n\" +\n" +
//                "            \"      \\\"ISA04\\\": \\\"          \\\",\\n\" +\n" +
//                "            \"      \\\"ISA05\\\": \\\"ZZ\\\",\\n\" +\n" +
//                "            \"      \\\"ISA06\\\": \\\"SENDERID4567891\\\",\\n\" +\n" +
//                "            \"      \\\"ISA07\\\": \\\"ZZ\\\",\\n\" +\n" +
//                "            \"      \\\"ISA08\\\": \\\"77034\\\",\\n\" +\n" +
//                "            \"      \\\"ISA09\\\": \\\"210102\\\",\\n\" +\n" +
//                "            \"      \\\"ISA10\\\": \\\"1200\\\",\\n\" +\n" +
//                "            \"      \\\"ISA11\\\": \\\"^\\\",\\n\" +\n" +
//                "            \"      \\\"ISA12\\\": \\\"00501\\\",\\n\" +\n" +
//                "            \"      \\\"ISA13\\\": \\\"00\\\",\\n\" +\n" +
//                "            \"      \\\"ISA14\\\": \\\"0\\\",\\n\" +\n" +
//                "            \"      \\\"ISA15\\\": \\\"T\\\",\\n\" +\n" +
//                "            \"      \\\"ISA16\\\": \\\":\\\"\\n\" +\n" +
//                "            \"    },\\n\" +\n" +
//                "            \"    \\\"Groups\\\": [\\n\" +\n" +
//                "            \"      {\\n\" +\n" +
//                "            \"        \\\"GS\\\": {\\n\" +\n" +
//                "            \"          \\\"GS01\\\": \\\"HC\\\",\\n\" +\n" +
//                "            \"          \\\"GS02\\\": \\\"SENDERID4567891\\\",\\n\" +\n" +
//                "            \"          \\\"GS03\\\": \\\"77034\\\",\\n\" +\n" +
//                "            \"          \\\"GS04\\\": \\\"20210102\\\",\\n\" +\n" +
//                "            \"          \\\"GS05\\\": \\\"1200\\\",\\n\" +\n" +
//                "            \"          \\\"GS06\\\": \\\"1\\\",\\n\" +\n" +
//                "            \"          \\\"GS07\\\": \\\"X\\\",\\n\" +\n" +
//                "            \"          \\\"GS08\\\": \\\"005010X222A1\\\"\\n\" +\n" +
//                "            \"        },\\n\" +\n" +
//                "            \"        \\\"Transactions-FunctionalGroup\\\": [\\n\" +\n" +
//                "            \"          {\\n\" +\n" +
//                "            \"            \\\"ST\\\": {\\n\" +\n" +
//                "            \"              \\\"ST01\\\": \\\"837\\\",\\n\" +\n" +
//                "            \"              \\\"ST02\\\": \\\"000000001\\\",\\n\" +\n" +
//                "            \"              \\\"ST03\\\": \\\"005010X222A1\\\"\\n\" +\n" +
//                "            \"            },\\n\" +\n" +
//                "            \"            \\\"BHT_BeginningOfHierarchicalTransaction\\\": {\\n\" +\n" +
//                "            \"              \\\"BHT01\\\": \\\"0019\\\",\\n\" +\n" +
//                "            \"              \\\"BHT02\\\": \\\"00\\\",\\n\" +\n" +
//                "            \"              \\\"BHT03\\\": \\\"2223254003792\\\",\\n\" +\n" +
//                "            \"              \\\"BHT04\\\": \\\"20230118\\\",\\n\" +\n" +
//                "            \"              \\\"BHT05\\\": \\\"1200\\\",\\n\" +\n" +
//                "            \"              \\\"BHT06\\\": \\\"CH\\\"\\n\" +\n" +
//                "            \"            },\\n\" +\n" +
//                "            \"            \\\"AllNM1 - SubmitterInformation\\\": {\\n\" +\n" +
//                "            \"              \\\"Loop1000A\\\": {\\n\" +\n" +
//                "            \"                \\\"NM1_SubmitterName\\\": {\\n\" +\n" +
//                "            \"                  \\\"NM101\\\": \\\"41\\\",\\n\" +\n" +
//                "            \"                  \\\"NM102\\\": \\\"2\\\",\\n\" +\n" +
//                "            \"                  \\\"NM103\\\": \\\"PREMIUM BILLING SERVICES\\\",\\n\" +\n" +
//                "            \"                  \\\"NM109\\\": \\\"XX\\\",\\n\" +\n" +
//                "            \"                  \\\"NM110\\\": \\\"123456789\\\"\\n\" +\n" +
//                "            \"                },\\n\" +\n" +
//                "            \"                \\\"PER\\\": [\\n\" +\n" +
//                "            \"                  {\\n\" +\n" +
//                "            \"                    \\\"PER01\\\": \\\"IC\\\",\\n\" +\n" +
//                "            \"                    \\\"PER02\\\": \\\"TOM CRUISE\\\",\\n\" +\n" +
//                "            \"                    \\\"PER03\\\": \\\"TE\\\",\\n\" +\n" +
//                "            \"                    \\\"PER04\\\": \\\"3055552222\\\"\\n\" +\n" +
//                "            \"                  }\\n\" +\n" +
//                "            \"                ]\\n\" +\n" +
//                "            \"              },\\n\" +\n" +
//                "            \"              \\\"Loop1000B\\\": {\\n\" +\n" +
//                "            \"                \\\"NM1_ReceiverName\\\": {\\n\" +\n" +
//                "            \"                  \\\"NM101\\\": \\\"40\\\",\\n\" +\n" +
//                "            \"                  \\\"NM102\\\": \\\"2\\\",\\n\" +\n" +
//                "            \"                  \\\"NM103\\\": \\\"GEORGIA FAMILIES\\\",\\n\" +\n" +
//                "            \"                  \\\"NM108\\\": \\\"46\\\",\\n\" +\n" +
//                "            \"                  \\\"NM109\\\": \\\"77034\\\"\\n\" +\n" +
//                "            \"                }\\n\" +\n" +
//                "            \"              }\\n\" +\n" +
//                "            \"            },\\n\" +\n" +
//                "            \"            \\\"Loop2000A\\\": [\\n\" +\n" +
//                "            \"              {\\n\" +\n" +
//                "            \"                \\\"HL_BillingProviderHierarchicalLevel\\\": {\\n\" +\n" +
//                "            \"                  \\\"HL01\\\": \\\"1\\\",\\n\" +\n" +
//                "            \"                  \\\"HL02\\\": \\\"20\\\",\\n\" +\n" +
//                "            \"                  \\\"HL03\\\": \\\"1\\\"\\n\" +\n" +
//                "            \"                },\\n\" +\n" +
//                "            \"                \\\"PRV_BillingProviderSpecialtyInformation\\\": {\\n\" +\n" +
//                "            \"                  \\\"PRV01\\\": \\\"BI\\\",\\n\" +\n" +
//                "            \"                  \\\"PRV02\\\": \\\"PXC\\\",\\n\" +\n" +
//                "            \"                  \\\"PRV03\\\": \\\"453088947A\\\"\\n\" +\n" +
//                "            \"                },\\n\" +\n" +
//                "            \"                \\\"AllNM1\\\": {\\n\" +\n" +
//                "            \"                  \\\"Loop2010AA\\\": {\\n\" +\n" +
//                "            \"                    \\\"NM1_BillingProviderName\\\": {\\n\" +\n" +
//                "            \"                      \\\"NM101\\\": \\\"85\\\",\\n\" +\n" +
//                "            \"                      \\\"NM102\\\": \\\"2\\\",\\n\" +\n" +
//                "            \"                      \\\"NM103\\\": \\\"LGREEN20\\\",\\n\" +\n" +
//                "            \"                      \\\"NM108\\\": \\\"XX\\\",\\n\" +\n" +
//                "            \"                      \\\"NM109\\\": \\\"9876543210\\\"\\n\" +\n" +
//                "            \"                    },\\n\" +\n" +
//                "            \"                    \\\"N3_BillingProviderAddress\\\": {\\n\" +\n" +
//                "            \"                      \\\"N301\\\": \\\"234 SEAWAY ST\\\"\\n\" +\n" +
//                "            \"                    },\\n\" +\n" +
//                "            \"                    \\\"N4_BillingProviderCity_State_ZIPCode\\\": {\\n\" +\n" +
//                "            \"                      \\\"N401\\\": \\\"MIAMI\\\",\\n\" +\n" +
//                "            \"                      \\\"N402\\\": \\\"FL\\\",\\n\" +\n" +
//                "            \"                      \\\"N403\\\": \\\"33111\\\"\\n\" +\n" +
//                "            \"                    },\\n\" +\n" +
//                "            \"                    \\\"AllREF\\\": {\\n\" +\n" +
//                "            \"                      \\\"REF_BillingProviderTaxIdentification\\\": {\\n\" +\n" +
//                "            \"                        \\\"REF01\\\": \\\"EI\\\",\\n\" +\n" +
//                "            \"                        \\\"REF02\\\": \\\"587654321\\\"\\n\" +\n" +
//                "            \"                      }\\n\" +\n" +
//                "            \"                    }\\n\" +\n" +
//                "            \"                  }\\n\" +\n" +
//                "            \"                },\\n\" +\n" +
//                "            \"                \\\"Loop2000B\\\": [\\n\" +\n" +
//                "            \"                  {\\n\" +\n" +
//                "            \"                    \\\"HL_SubscriberHierarchicalLevel\\\": {\\n\" +\n" +
//                "            \"                      \\\"HL01\\\": \\\"2\\\",\\n\" +\n" +
//                "            \"                      \\\"HL02\\\": \\\"1\\\",\\n\" +\n" +
//                "            \"                      \\\"HL03\\\": \\\"22\\\",\\n\" +\n" +
//                "            \"                      \\\"HL04\\\": \\\"1\\\"\\n\" +\n" +
//                "            \"                    },\\n\" +\n" +
//                "            \"                    \\\"SBR_SubscriberInformation\\\": {\\n\" +\n" +
//                "            \"                      \\\"SBR01\\\": \\\"P\\\",\\n\" +\n" +
//                "            \"                      \\\"SBR03\\\": \\\"2222-SJ\\\",\\n\" +\n" +
//                "            \"                      \\\"SBR09\\\": \\\"CI\\\"\\n\" +\n" +
//                "            \"                    },\\n\" +\n" +
//                "            \"                    \\\"AllNM1\\\": {\\n\" +\n" +
//                "            \"                      \\\"Loop2010BA\\\": {\\n\" +\n" +
//                "            \"                        \\\"NM1_SubscriberName\\\": {\\n\" +\n" +
//                "            \"                          \\\"NM101\\\": \\\"IL\\\",\\n\" +\n" +
//                "            \"                          \\\"NM102\\\": \\\"1\\\",\\n\" +\n" +
//                "            \"                          \\\"NM103\\\": \\\"BRYANT\\\",\\n\" +\n" +
//                "            \"                          \\\"NM104\\\": \\\"AHMED\\\",\\n\" +\n" +
//                "            \"                          \\\"NM108\\\": \\\"MI\\\",\\n\" +\n" +
//                "            \"                          \\\"NM109\\\": \\\"222114962578\\\"\\n\" +\n" +
//                "            \"                        },\\n\" +\n" +
//                "            \"                        \\\"DMG_SubscriberDemographicInformation\\\": {\\n\" +\n" +
//                "            \"                          \\\"DMG01\\\": \\\"D8\\\",\\n\" +\n" +
//                "            \"                          \\\"DMG02\\\": \\\"19740112\\\",\\n\" +\n" +
//                "            \"                          \\\"DMG03\\\": \\\"M\\\"\\n\" +\n" +
//                "            \"                        }\\n\" +\n" +
//                "            \"                      }\\n\" +\n" +
//                "            \"                    },\\n\" +\n" +
//                "            \"                    \\\"Loop2010BB\\\": {\\n\" +\n" +
//                "            \"                      \\\"NM1_PayerName\\\": {\\n\" +\n" +
//                "            \"                        \\\"NM101\\\": \\\"PR\\\",\\n\" +\n" +
//                "            \"                        \\\"NM102\\\": \\\"2\\\",\\n\" +\n" +
//                "            \"                        \\\"NM103\\\": \\\"GEORGIA FAMILIES\\\",\\n\" +\n" +
//                "            \"                        \\\"NM108\\\": \\\"PI\\\",\\n\" +\n" +
//                "            \"                        \\\"NM109\\\": \\\"77034\\\"\\n\" +\n" +
//                "            \"                      },\\n\" +\n" +
//                "            \"                      \\\"N4_PayerName\\\": {\\n\" +\n" +
//                "            \"                        \\\"N401\\\": \\\"TUCKER\\\",\\n\" +\n" +
//                "            \"                        \\\"N402\\\": \\\"GA\\\",\\n\" +\n" +
//                "            \"                        \\\"N403\\\": \\\"300855201\\\"\\n\" +\n" +
//                "            \"                      },\\n\" +\n" +
//                "            \"                      \\\"AllREF\\\": {\\n\" +\n" +
//                "            \"                        \\\"REF_BillingProviderSecondaryIdentification\\\": [\\n\" +\n" +
//                "            \"                          {\\n\" +\n" +
//                "            \"                            \\\"REF01\\\": \\\"G2\\\",\\n\" +\n" +
//                "            \"                            \\\"REF02\\\": \\\"KA6663\\\"\\n\" +\n" +
//                "            \"                          }\\n\" +\n" +
//                "            \"                        ]\\n\" +\n" +
//                "            \"                      }\\n\" +\n" +
//                "            \"                    },\\n\" +\n" +
//                "            \"                    \\\"Loop2000C\\\": [\\n\" +\n" +
//                "            \"                      {\\n\" +\n" +
//                "            \"                        \\\"HL_PatientHierarchicalLevel\\\": {\\n\" +\n" +
//                "            \"                          \\\"HL01\\\": \\\"3\\\",\\n\" +\n" +
//                "            \"                          \\\"HL02\\\": \\\"2\\\",\\n\" +\n" +
//                "            \"                          \\\"HL03\\\": \\\"23\\\",\\n\" +\n" +
//                "            \"                          \\\"HL04\\\": \\\"0\\\"\\n\" +\n" +
//                "            \"                        },\\n\" +\n" +
//                "            \"                        \\\"PAT_PatientInformation\\\": {\\n\" +\n" +
//                "            \"                          \\\"PAT01\\\": \\\"21\\\"\\n\" +\n" +
//                "            \"                        },\\n\" +\n" +
//                "            \"                        \\\"Loop2010CA\\\": {\\n\" +\n" +
//                "            \"                          \\\"NM1_PatientName\\\": {\\n\" +\n" +
//                "            \"                            \\\"NM101\\\": \\\"QC\\\",\\n\" +\n" +
//                "            \"                            \\\"NM102\\\": \\\"1\\\",\\n\" +\n" +
//                "            \"                            \\\"NM103\\\": \\\"SMITH\\\",\\n\" +\n" +
//                "            \"                            \\\"NM104\\\": \\\"TED\\\"\\n\" +\n" +
//                "            \"                          },\\n\" +\n" +
//                "            \"                          \\\"N3_PatientAddress\\\": {\\n\" +\n" +
//                "            \"                            \\\"N301\\\": \\\"236 N MAIN ST\\\"\\n\" +\n" +
//                "            \"                          },\\n\" +\n" +
//                "            \"                          \\\"N4_PatientCity_State_ZIPCode\\\": {\\n\" +\n" +
//                "            \"                            \\\"N401\\\": \\\"MIAMI\\\",\\n\" +\n" +
//                "            \"                            \\\"N402\\\": \\\"FL\\\",\\n\" +\n" +
//                "            \"                            \\\"N403\\\": \\\"33413\\\"\\n\" +\n" +
//                "            \"                          },\\n\" +\n" +
//                "            \"                          \\\"DMG_PatientDemographicInformation\\\": {\\n\" +\n" +
//                "            \"                            \\\"DMG01\\\": \\\"D8\\\",\\n\" +\n" +
//                "            \"                            \\\"DMG02\\\": \\\"19730501\\\",\\n\" +\n" +
//                "            \"                            \\\"DMG03\\\": \\\"M\\\"\\n\" +\n" +
//                "            \"                          }\\n\" +\n" +
//                "            \"                        },\\n\" +\n" +
//                "            \"                        \\\"Loop2300\\\": [\\n\" +\n" +
//                "            \"                          {\\n\" +\n" +
//                "            \"                            \\\"CLM_ClaimInformation\\\": {\\n\" +\n" +
//                "            \"                              \\\"CLM01\\\": \\\"2223254003792\\\",\\n\" +\n" +
//                "            \"                              \\\"CLM02\\\": \\\"292.32\\\",\\n\" +\n" +
//                "            \"                              \\\"HealthCareServiceLocationInformation_05\\\": {\\n\" +\n" +
//                "            \"                                \\\"CLM05-1\\\": \\\"11\\\",\\n\" +\n" +
//                "            \"                                \\\"CLM05-2\\\": \\\"B\\\",\\n\" +\n" +
//                "            \"                                \\\"CLM05-03\\\": \\\"1\\\"\\n\" +\n" +
//                "            \"                              },\\n\" +\n" +
//                "            \"                              \\\"CLM09\\\": \\\"Y\\\",\\n\" +\n" +
//                "            \"                              \\\"CLM10\\\": \\\"A\\\",\\n\" +\n" +
//                "            \"                              \\\"CLM11\\\": \\\"Y\\\",\\n\" +\n" +
//                "            \"                              \\\"CLM12\\\": \\\"I\\\"\\n\" +\n" +
//                "            \"                            },\\n\" +\n" +
//                "            \"                            \\\"AllREF\\\": {\\n\" +\n" +
//                "            \"                              \\\"REF_Referral Number\\\": {\\n\" +\n" +
//                "            \"                                \\\"REF01\\\": \\\"9F\\\",\\n\" +\n" +
//                "            \"                                \\\"REF02\\\": \\\"17312345600006351\\\"\\n\" +\n" +
//                "            \"                              },\\n\" +\n" +
//                "            \"                              \\\"REF_PriorAuthorization\\\": {\\n\" +\n" +
//                "            \"                                \\\"REF01\\\": \\\"G1\\\",\\n\" +\n" +
//                "            \"                                \\\"REF02\\\": \\\"900019507620\\\"\\n\" +\n" +
//                "            \"                              },\\n\" +\n" +
//                "            \"                              \\\"REF_PayerClaimCOntrolNumber\\\": {\\n\" +\n" +
//                "            \"                                \\\"REF01\\\": \\\"F8\\\",\\n\" +\n" +
//                "            \"                                \\\"REF02\\\": \\\"1456823987456\\\"\\n\" +\n" +
//                "            \"                              },\\n\" +\n" +
//                "            \"                              \\\"REF_ClaimIdentifierForTransmissionIntermediaries\\\": {\\n\" +\n" +
//                "            \"                                \\\"REF01\\\": \\\"9F\\\",\\n\" +\n" +
//                "            \"                                \\\"REF02\\\": \\\"17312345600006351235\\\"\\n\" +\n" +
//                "            \"                              }\\n\" +\n" +
//                "            \"                            },\\n\" +\n" +
//                "            \"                            \\\"AllHI\\\": {\\n\" +\n" +
//                "            \"                              \\\"HI_HealthCareDiagnosisCode\\\": {\\n\" +\n" +
//                "            \"                                \\\"HealthCareCodeInformation_01\\\": {\\n\" +\n" +
//                "            \"                                  \\\"HI01-1\\\": \\\"ABK\\\",\\n\" +\n" +
//                "            \"                                  \\\"HI01-2\\\": \\\"0340\\\"\\n\" +\n" +
//                "            \"                                },\\n\" +\n" +
//                "            \"                                \\\"HealthCareIndustryCode_02\\\":" +
//                "                                \"HI02-1\": \"ABF\",\n" +
//                "                                \"HI02-2\": \"V7389\"\n" +
//                "                              }\n" +
//                "                            }\n" +
//                "                          },\n" +
//                "                          \"Loop2310A\": {\n" +
//                "                            \"NM1_ReferringProviderName\": {\n" +
//                "                              \"NM101\": \"DN\",\n" +
//                "                              \"NM108\": \"XX\",\n" +
//                "                              \"NM109\": \"9876543210\"\n" +
//                "                            }\n" +
//                "                          },\n" +
//                "                          \"Loop2310B\": {\n" +
//                "                            \"NM1_RenderingProviderName\": {\n" +
//                "                              \"NM101\": \"\",\n" +
//                "                              \"NM108\": \"XX\",\n" +
//                "                              \"NM109\": \"9876543280\"\n" +
//                "                            },\n" +
//                "                            \"PRV_RenderingProviderSpecialtyInformation\": {\n" +
//                "                              \"PRV01\": \"AT\",\n" +
//                "                              \"PRV02\": \"PXC\",\n" +
//                "                              \"PRV03\": \"453088947A\"\n" +
//                "                            }\n" +
//                "                          },\n" +
//                "                          \"Loop2320\": {\n" +
//                "                            \"AMT_COB PayerPaidAMount\": {\n" +
//                "                              \"AMT01\": \"D\",\n" +
//                "                              \"AMT02\": \"292.32\"\n" +
//                "                            }\n" +
//                "                          },\n" +
//                "                          \"Loop2330B\": {\n" +
//                "                            \"AllDTP\": {\n" +
//                "                              \"DTP_RemittanceDate\": {\n" +
//                "                                \"DTP01\": \"573\",\n" +
//                "                                \"DTP02\": \"D8\",\n" +
//                "                                \"DTP03\": \"20230918\"\n" +
//                "                              }\n" +
//                "                            }\n" +
//                "                          },\n" +
//                "                          \"Loop2400\": [\n" +
//                "                            {\n" +
//                "                              \"LX_ServiceLineNumber\": {\n" +
//                "                                \"LX01\": \"1\"\n" +
//                "                              },\n" +
//                "                              \"SV1_ProfessionalService\": {\n" +
//                "                                \"CompositeMedicalProcedureIdentifier_01\": {\n" +
//                "                                  \"SV101-1\": \"HC\",\n" +
//                "                                  \"SV101-2\": \"H2017\"\n" +
//                "                                },\n" +
//                "                                \"SV102\": \"146.16\",\n" +
//                "                                \"SV103\": \"UN\",\n" +
//                "                                \"SV104\": \"6.0\",\n" +
//                "                                \"SV105\": \"12\",\n" +
//                "                                \"CompositeDiagnosisCodePointer_07\": {\n" +
//                "                                  \"SV107\": \"1\"\n" +
//                "                                },\n" +
//                "                                \"SV109\": \"N\",\n" +
//                "                                \"SV112\": \"Y\"\n" +
//                "                              },\n" +
//                "                              \"SV5_DMEdetails\": {\n" +
//                "                                \"CompositeMedicalProcedureIdentifier_01\": {\n" +
//                "                                  \"SV105-1\": \"HC\",\n" +
//                "                                  \"SV105-2\": \"H2017\"\n" +
//                "                                }\n" +
//                "                              },\n" +
//                "                              \"AllDTP\": {\n" +
//                "                                \"DTP_Date_ServiceDate\": {\n" +
//                "                                  \"DTP01\": \"472\",\n" +
//                "                                  \"DTP02\": \"D8\",\n" +
//                "                                  \"DTP03\": \"20230903\"\n" +
//                "                                }\n" +
//                "                              }\n" +
//                "                            },\n" +
//                "                            {\n" +
//                "                              \"LX_ServiceLineNumber\": {\n" +
//                "                                \"LX01\": \"2\"\n" +
//                "                              },\n" +
//                "                              \"SV1_ProfessionalService\": {\n" +
//                "                                \"CompositeMedicalProcedureIdentifier_01\": {\n" +
//                "                                  \"SV101-1\": \"HC\",\n" +
//                "                                  \"SV101-2\": \"H0004\"\n" +
//                "                                },\n" +
//                "                                \"SV102\": \"146.16\",\n" +
//                "                                \"SV103\": \"UN\",\n" +
//                "                                \"SV104\": \"6.0\",\n" +
//                "                                \"SV105\": \"12\",\n" +
//                "                                \"CompositeDiagnosisCodePointer_07\": {\n" +
//                "                                  \"SV107-1\": \"1\"\n" +
//                "                                },\n" +
//                "                                \"SV109\": \"N\",\n" +
//                "                                \"SV112\": \"Y\"\n" +
//                "                              },\n" +
//                "                              \"SV5_DMEdetails\": {\n" +
//                "                                \"CompositeMedicalProcedureIdentifier_01\": {\n" +
//                "                                  \"SV105-1\": \"HC\",\n" +
//                "                                  \"SV105-2\": \"H0004\"\n" +
//                "                                }\n" +
//                "                              },\n" +
//                "                              \"AllDTP\": {\n" +
//                "                                \"DTP_Date_ServiceDate\": {\n" +
//                "                                  \"DTP01\": \"472\",\n" +
//                "                                  \"DTP02\": \"D8\",\n" +
//                "                                  \"DTP03\": \"20230903\"\n" +
//                "                                }\n" +
//                "                              }\n" +
//                "                            },\n" +
//                "                            {\n" +
//                "                              \"Loop2410\": {\n" +
//                "                                \"LIN_DrugIdentification\": {\n" +
//                "                                  \"LIN03\": \"123456789012\"\n" +
//                "                                },\n" +
//                "                                \"CTP_DrugQuantity\": {\n" +
//                "                                  \"CTP04\": \"100\",\n" +
//                "                                  \"CTP05\": \"EA\"\n" +
//                "                                }\n" +
//                "                              }\n" +
//                "                            },\n" +
//                "                            {\n" +
//                "                              \"Loop2420A\": {\n" +
//                "                                \"_comment\": \" Required if the Rendering Provider NM1 information is different than that carried in the 2310B (claim) loop, or if the Rendering provider information is different than the Billing Provider (2010AA)\",\n" +
//                "                                \"NM1_RenderingProviderName\": {\n" +
//                "                                  \"NM101\": \"82\",\n" +
//                "                                  \"NM102\": \"1\",\n" +
//                "                                  \"NM103\": \"MEDICAL CENTER\",\n" +
//                "                                  \"NM109\": \"1234567890\"\n" +
//                "                                },\n" +
//                "                                \"PRV_RenderingProviderSpecialtyInformation\": {\n" +
//                "                                  \"PRV01\": \"BI\",\n" +
//                "                                  \"PRV02\": \"ZZ\",\n" +
//                "                                  \"PRV03\": \"2000B0234A\"\n" +
//                "                                }\n" +
//                "                              }\n" +
//                "                            }\n" +
//                "                          ]\n" +
//                "                        }\n" +
//                "                      }\n" +
//                "                    ]\n" +
//                "                  }\n" +
//                "                ]\n" +
//                "              }\n" +
//                "            ]\n" +
//                "          }\n" +
//                "        ]\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  }\n" +
//                "]";
//
//
//        // Convert JSON to EDI
//        String ediString = convertJsonToEdi(jsonString);
//        System.out.println(ediString);
//    }
//
//public static String convertJsonToEdi(String jsonString) {
//    try {
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(jsonString);
//
//        StringBuilder ediBuilder = new StringBuilder();
//        convertNodeToEdi(jsonNode, ediBuilder);
//
//        return ediBuilder.toString();
//    } catch (Exception e) {
//        e.printStackTrace();
//        return null;
//    }
//}
//
//private static void convertNodeToEdi(JsonNode node, StringBuilder ediBuilder) {
//    if (node.isObject()) {
//        boolean isFirst = true;
//        for (Iterator<Map.Entry<String, JsonNode>> fields = node.fields(); fields.hasNext(); ) {
//            Map.Entry<String, JsonNode> entry = fields.next();
//
//            ediBuilder.append(entry.getKey()).append(":");
//
//            if (entry.getValue().isObject() || entry.getValue().isArray()) {
//                ediBuilder.append("\n");
//            }
//
//            convertNodeToEdi(entry.getValue(), ediBuilder);
//
//            if (fields.hasNext()) {
//                ediBuilder.append("\n");
//            }
//        }
//    } else if (node.isArray()) {
//        node.elements().forEachRemaining(arrayItem -> {
//            convertNodeToEdi(arrayItem, ediBuilder);
//            ediBuilder.append("\n");
//        });
//    } else {
//        ediBuilder.append(node.asText());
//    }
//}
//}