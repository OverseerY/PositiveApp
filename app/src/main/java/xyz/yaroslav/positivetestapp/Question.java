package xyz.yaroslav.positivetestapp;

import java.util.HashMap;
import java.util.Map;

public class Question {
    private int q_id;
    private String q_description;
    private String q_strength;
    private int q_result;

    public Question() {}

    public Question(int q_id, String q_description, int q_result) {
        this.q_id = q_id;
        this.q_description = q_description;
        this.q_result = q_result;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public void setQ_result(int q_result) {
        this.q_result = q_result;
    }

    public void setQ_strength(String q_strength) {
        this.q_strength = q_strength;
    }

    public void setQ_description(String q_description) {
        this.q_description = q_description;
    }

    public int getQ_id() {
        return q_id;
    }

    public int getQ_result() {
        return q_result;
    }

    public String getQ_description() {
        return q_description;
    }

    public String getQ_strength() {
        return q_strength;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("qId", getQ_id());
        result.put("qDescription", getQ_description());
        result.put("qResult", getQ_result());

        return result;
    }
}




















