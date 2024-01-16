package com.edi;

public class EDIModel {
    private String segmentDelimiter;
    private String dataElementDelimiter;
    private ISA_Segment isa;

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
