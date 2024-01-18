package com.edi;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EDIModel {
    @JsonProperty("SegmentDelimiter")
    private String segmentDelimiter;
    @JsonProperty("DataElementDelimiter")
    private String dataElementDelimiter;
    @JsonProperty("ISA")
    private ISA_Segment isa;
    @JsonProperty("GS")
    private GS_Segment gs;


    public String getSegmentDelimiter() {
        return segmentDelimiter;
    }

    public void setSegmentDelimiter(String segmentDelimiter) {
        this.segmentDelimiter = segmentDelimiter;
    }

    public String getDataElementDelimiter() {
        return dataElementDelimiter;
    }

    public void setDataElementDelimiter(String dataElementDelimiter) {
        this.dataElementDelimiter = dataElementDelimiter;
    }

    public ISA_Segment getIsa() {
        return isa;
    }

    public void setIsa(ISA_Segment isa) {
        this.isa = isa;
    }
}
