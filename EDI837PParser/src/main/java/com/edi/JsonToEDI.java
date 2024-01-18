package com.edi;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;


public class JsonToEDI {

    public static void main(String[] args) {

        String jsonData = "[{"
                + "\"SegmentDelimiter\": \"~\","
                + "\"DataElementDelimiter\": \"*\","
                // ISA Segment
                + "\"ISA\": {"
                + "    \"ISA01\": \"00\","
                + "    \"ISA02\": \"          \","
                + "    \"ISA03\": \"00\","
                + "    \"ISA04\": \"          \","
                + "    \"ISA05\": \"ZZ\","
                + "    \"ISA06\": \"SENDERID4567891\","
                + "    \"ISA07\": \"ZZ\","
                + "    \"ISA08\": \"77034\","
                + "    \"ISA09\": \"210102\","
                + "    \"ISA10\": \"1200\","
                + "    \"ISA11\": \"^\","
                + "    \"ISA12\": \"00501\","
                + "    \"ISA13\": \"00\","
                + "    \"ISA14\": \"0\","
                + "    \"ISA15\": \"T\","
                + "    \"ISA16\": \":\""
//                // GS Segment
//                + "    \"GS\": {\n"
//                + "      \"GS01\": \"HC\",\n"
//                + "      \"GS02\": \"SENDERID4567891\",\n"
//                + "      \"GS03\": \"77034\",\n"
//                + "      \"GS04\": \"20210102\",\n"
//                + "      \"GS05\": \"1200\",\n"
//                + "      \"GS06\": \"1\",\n"
//                + "      \"GS07\": \"X\",\n"
//                + "      \"GS08\": \"005010X222A1\"\n"
//                + "    },\n"
//                // ST Segment
//                + "    [\n"
//                + "      {\n"
//                + "        \"ST\": {\n"
//                + "          \"ST01\": \"837\",\n"
//                + "          \"ST02\": \"000000001\",\n"
//                + "          \"ST03\": \"005010X222A1\"\n"
//                + "        },\n"
//                // BHT Segment
//                + "        \"BHT\": {\n"
//                + "          \"BHT01\": \"0019\",\n"
//                + "          \"BHT02\": \"00\",\n"
//                + "          \"BHT03\": \"2223254003792\",\n"
//                + "          \"BHT04\": \"20230118\",\n"
//                + "          \"BHT05\": \"1200\",\n"
//                + "          \"BHT06\": \"CH\"\n"
//
//
//                + "        }\n"
//                + "      }\n"
//                + "    ]\n"
//                + "  }\n"
 //               + "]"
                + "} }]";

         try {

             ObjectMapper mapper = new ObjectMapper();
             JsonNode jsonNode = mapper.readTree(jsonData);
             JsonNode ISAJsonNode = jsonNode.findValue("ISA");

             ISA_Segment isaSegment = new ISA_Segment();
             isaSegment.setIsa01(ISAJsonNode.findValue("ISA01").toString());

             System.out.println("ISA01: " + isaSegment.getIsa01());


             //SSSegment ss
//             JsonNode GSJsonNode = jsonNode.findValue("GS");
//             GS_Segment gsSegment;
//             gsSegment.setGS01(GSJsonNode.findValue("GS01").toString());

//
//             EDIModel[] ediMessages = objectMapper.readValue(jsonData, EDIModel[].class);
//
////                ISA_Segment isa = ediMessage.getIsa();
////                System.out.println("ISA01: " + isa.getIsa01());
////                // Print other ISA fields
////                System.out.println("ISA02: " + isa.getIsa02());
////                System.out.println("ISA03: " + isa.getIsa03());
////                System.out.println("ISA04: " + isa.getIsa04());
////                System.out.println("ISA05: " + isa.getIsa05());
////                System.out.println("ISA06: " + isa.getIsa06());
////                System.out.println("ISA07: " + isa.getIsa07());
////                System.out.println("ISA08: " + isa.getIsa08());
////                System.out.println("ISA09: " + isa.getIsa09());
////                System.out.println("ISA10: " + isa.getIsa10());
////                System.out.println("ISA11: " + isa.getIsa11());
////                System.out.println("ISA12: " + isa.getIsa12());
////                System.out.println("ISA13: " + isa.getIsa13());
////                System.out.println("ISA14: " + isa.getIsa14());
////                System.out.println("ISA15: " + isa.getIsa15());
////                System.out.println("ISA16: " + isa.getIsa16());
////            }
////}
//             for (EDIModel ediMessage : ediMessages) {
//                 System.out.println("ISA*"
//                         + ediMessage.getIsa().getIsa01() + "*"
//                         + ediMessage.getIsa().getIsa02() + "*"
//                         + ediMessage.getIsa().getIsa03() + "*"
//                         + ediMessage.getIsa().getIsa04() + "*"
//                         + ediMessage.getIsa().getIsa05() + "*"
//                         + ediMessage.getIsa().getIsa06() + "*"
//                         + ediMessage.getIsa().getIsa07() + "*"
//                         + ediMessage.getIsa().getIsa08() + "*"
//                         + ediMessage.getIsa().getIsa09() + "*"
//                         + ediMessage.getIsa().getIsa10() + "*"
//                         + ediMessage.getIsa().getIsa11() + "*"
//                         + ediMessage.getIsa().getIsa12() + "*"
//                         + ediMessage.getIsa().getIsa13() + "*"
//                         + ediMessage.getIsa().getIsa14() + "*"
//                         + ediMessage.getIsa().getIsa15() + "*"
//                         + ediMessage.getIsa().getIsa16() + ":~"
//
//                 );
             //}
             // Add logic to process other segments and structures

         }  catch (Exception e) {
            e.printStackTrace();
         }
}
}

