package com.example.curiosity_core.kdymowsk_a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MultipleChoiceActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    private RadioButton mAnswer0;
    private RadioButton mAnswer1;
    private RadioButton mAnswer2;
    private RadioButton mAnswer3;

    private MultipleChoiceQuestion[] mQuestionBank = new MultipleChoiceQuestion[] {
            new MultipleChoiceQuestion(R.string.question_oregon_trail,R.string.answer_oregon_trail,R.string.answer1_oregon_trail,R.string.answer2_oregon_trail,R.string.answer3_oregon_trail, R.string.answer_oregon_trail),
    };

    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getQuestionTextResId();
        int answer0 = mQuestionBank[mCurrentIndex].getAnswer0TextResId();
        int answer1 = mQuestionBank[mCurrentIndex].getAnswer1TextResId();
        int answer2 = mQuestionBank[mCurrentIndex].getAnswer2TextResId();
        int answer3 = mQuestionBank[mCurrentIndex].getAnswer3TextResId();
        mQuestionTextView.setText(question);
        mAnswer0.setText(answer0);
        mAnswer1.setText(answer1);
        mAnswer2.setText(answer2);
        mAnswer3.setText(answer3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_question);

        mQuestionTextView = (TextView) findViewById(R.id.multiple_question_text_view);

        mAnswer0 = (RadioButton) findViewById(R.id.radio_zero);
        mAnswer1 = (RadioButton) findViewById(R.id.radio_one);
        mAnswer2 = (RadioButton) findViewById(R.id.radio_two);
        mAnswer3 = (RadioButton) findViewById(R.id.radio_three);
        updateQuestion();
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

    }
}
