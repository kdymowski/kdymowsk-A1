package com.example.curiosity_core.kdymowsk_a1;

/**
 * Created by curiosity-core on 1/20/16.
 */
public class MultipleChoiceQuestion {

    private int mQuestionTextResId;
    private int mAnswer0TextResId;
    private int mAnswer1TextResId;
    private int mAnswer2TextResId;
    private int mAnswer3TextResId;
    private int mCorrectAnswerTestResId;

    public MultipleChoiceQuestion(int QuestionTextResId, int answer0TextResId, int answer1TextResId, int answer2TextResId, int answer3TextResId, int correctAnswerTestResId) {
        mQuestionTextResId = QuestionTextResId;
        mAnswer0TextResId = answer0TextResId;
        mAnswer1TextResId = answer1TextResId;
        mAnswer2TextResId = answer2TextResId;
        mAnswer3TextResId = answer3TextResId;
        mCorrectAnswerTestResId = correctAnswerTestResId;
    }

    public int getQuestionTextResId() {
        return mQuestionTextResId;
    }

    public int getAnswer0TextResId() {
        return mAnswer0TextResId;
    }

    public int getAnswer1TextResId() {
        return mAnswer1TextResId;
    }

    public int getAnswer2TextResId() {
        return mAnswer2TextResId;
    }

    public int getAnswer3TextResId() {
        return mAnswer3TextResId;
    }

    public int getCorrectAnswerTestResId() {
        return mCorrectAnswerTestResId;
    }

    public void setQuestionTextResId(int questionTextResId) {
        mQuestionTextResId = questionTextResId;
    }

    public void setAnswer0TextResId(int answer0TextResId) {
        mAnswer0TextResId = answer0TextResId;
    }

    public void setAnswer1TextResId(int answer1TextResId) {
        mAnswer1TextResId = answer1TextResId;
    }

    public void setAnswer2TextResId(int answer2TextResId) {
        mAnswer2TextResId = answer2TextResId;
    }

    public void setAnswer3TextResId(int answer3TextResId) {
        mAnswer3TextResId = answer3TextResId;
    }

    public void setCorrectAnswerTestResId(int correctAnswerTestResId) {
        mCorrectAnswerTestResId = correctAnswerTestResId;
    }
}
