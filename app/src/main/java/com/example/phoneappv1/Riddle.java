package com.example.phoneappv1;
import java.io.*;

public class Riddle implements Serializable{
    private String question = "";
    private String answer = "";

    public Riddle(String q, String a) {
        question = q;
        answer = a;
    }

    public String getAns() {return answer;}

    public String getQuestion() {return question;}


}
