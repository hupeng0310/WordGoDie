package com.hupeng.entity;

public class Vocabulary {
    private int id;
    private String word;
    private String part_of_speech;
    private String interpretation;
    private String part_of_speech_nd;
    private String interpretation_nd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPart_of_speech() {
        return part_of_speech;
    }

    public void setPart_of_speech(String part_of_speech) {
        this.part_of_speech = part_of_speech;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public String getPart_of_speech_nd() {
        return part_of_speech_nd;
    }

    public void setPart_of_speech_nd(String part_of_speech_nd) {
        this.part_of_speech_nd = part_of_speech_nd;
    }

    public String getInterpretation_nd() {
        return interpretation_nd;
    }

    public void setInterpretation_nd(String interpretation_nd) {
        this.interpretation_nd = interpretation_nd;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", part_of_speech='" + part_of_speech + '\'' +
                ", interpretation='" + interpretation + '\'' +
                ", part_of_speech_nd='" + part_of_speech_nd + '\'' +
                ", interpretation_nd='" + interpretation_nd + '\'' +
                '}';
    }
}
