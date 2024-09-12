package com.edi;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToEDI {

    public static void main(String[] args) {
        String jsonData = "[{ \"SegmentDelimiter\": \"~\", \"DataElementDelimiter\": \"*\", " +
                "\"ISA\": { \"ISA01\": \"00\", \"ISA02\": \" \", \"ISA03\": \"00\", \"ISA04\": \" \", \"ISA05\": \"ZZ\", \"ISA06\": \"SENDERID4567891\", \"ISA07\": \"ZZ\", \"ISA08\": \"77034\", \"ISA09\": \"210102\", \"ISA10\": \"1200\", \"ISA11\": \"^\", \"ISA12\": \"00501\", \"ISA13\": \"00\", \"ISA14\": \"0\", \"ISA15\": \"T\", \"ISA16\": \":\" } }]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EDIModel[] ediMessages = objectMapper.readValue(jsonData, EDIModel[].class);

            for (EDIModel ediMessage : ediMessages) {
                System.out.println("Segment Delimiter: " + ediMessage.getSegmentDelimiter());
                System.out.println("Data Element Delimiter: " + ediMessage.getDataElementDelimiter());

                ISA_Segment isa = ediMessage.getIsa();
                System.out.println("ISA01: " + isa.getIsa01());
                // Print other ISA fields
                System.out.println("ISA02: " + isa.getIsa02());
                System.out.println("ISA03: " + isa.getIsa03());
                System.out.println("ISA04: " + isa.getIsa04());
                System.out.println("ISA05: " + isa.getIsa05());
                System.out.println("ISA06: " + isa.getIsa06());
                System.out.println("ISA07: " + isa.getIsa07());
                System.out.println("ISA08: " + isa.getIsa08());
                System.out.println("ISA09: " + isa.getIsa09());
                System.out.println("ISA10: " + isa.getIsa10());
                System.out.println("ISA11: " + isa.getIsa11());
                System.out.println("ISA12: " + isa.getIsa12());
                System.out.println("ISA13: " + isa.getIsa13());
                System.out.println("ISA14: " + isa.getIsa14());
                System.out.println("ISA15: " + isa.getIsa15());
                System.out.println("ISA16: " + isa.getIsa16());

                // Add logic to process other segments and structures
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

