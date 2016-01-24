package com.example.curiosity_core.kdymowsk_a1;

/**
 * Created by curiosity-core on 1/22/16.
 */
public class FillInTheBlankQuestion {

    private int mQuestion;
    private int mAnswer;

    public FillInTheBlankQuestion(int question, int answer){
        mQuestion = question;
        mAnswer = answer;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public int getAnswer() {
        return mAnswer;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public void setAnswer(int answer) {
        mAnswer = answer;
    }
}
