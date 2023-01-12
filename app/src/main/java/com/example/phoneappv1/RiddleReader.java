package com.example.phoneappv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class RiddleReader {
    ArrayList<Riddle> rlist = new ArrayList<Riddle>();

    public RiddleReader(BufferedReader infile) throws IOException {
        Riddle r;
        String question = "";

        int numQ = Integer.parseInt(infile.readLine());
        String answer = "";


        for (int i = 0; i < numQ; i++) {
            question = String.valueOf(infile.readLine());
            answer = String.valueOf(infile.readLine());
            r = new Riddle(question, answer);

            rlist.add(r);
        }
        infile.close();
    }


    public ArrayList<Riddle> getRlist() {
        return rlist;
    }

    public Riddle getRiddle(int n) {
        return rlist.get(n);
    }
}
