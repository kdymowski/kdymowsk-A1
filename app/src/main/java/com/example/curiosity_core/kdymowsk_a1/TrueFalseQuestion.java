package com.example.curiosity_core.kdymowsk_a1;

/**
 * Created by curiosity-core on 1/22/16.
 */
public class TrueFalseQuestion {

    private int mTextResId;
    private boolean mAnswerTrue;

    public TrueFalseQuestion(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }


}
