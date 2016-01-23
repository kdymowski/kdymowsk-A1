package com.example.curiosity_core.kdymowsk_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MultipleChoiceActivity extends AppCompatActivity {

    private List<Object> questions = new ArrayList<>();
    private TextView mQuestionTextView;
    private TextView mScoreText;
    private RadioGroup mRadioGroup;
    private LinearLayout mLinearLayoutTF;
    private LinearLayout mLinearLayoutFITB;
    private RadioButton mAnswer0;
    private RadioButton mAnswer1;
    private RadioButton mAnswer2;
    private RadioButton mAnswer3;
    private Button mTrueButton;
    private Button mFalseButton;
    private int mCorrectAnswer;
    private int question;
    private int answer0;
    private int answer1;
    private int answer2;
    private int answer3;
    private EditText mEditText;
    private Button mSubmitButtonFillIn;
    private int mAnswerFITB;
    Object test;
    private Button mNextButton;
    private Button mPrevButton;
    private long seed = System.nanoTime();
    private int score;

    private MultipleChoiceQuestion[] mMultiQuestion = new MultipleChoiceQuestion[]{
            new MultipleChoiceQuestion(R.string.question_oregon_trail, R.string.answer_oregon_trail, R.string.answer1_oregon_trail, R.string.answer2_oregon_trail, R.string.answer3_oregon_trail, R.string.answer_oregon_trail),
    };
    private FillInTheBlankQuestion[] mFillInTheBlankQuestion = new FillInTheBlankQuestion[]{
            new FillInTheBlankQuestion(R.string.dinosaur_question, R.string.dinosaur_answer),
    };
    private TrueFalseQuestion[] mTFQuestion = new TrueFalseQuestion[]{
            new TrueFalseQuestion(R.string.my_name_is_question, true),
    };

    private int mCurrentIndex = 0;

    private void updateQuestionsList() {
        for (int i = 0; i < mMultiQuestion.length; i++) {
            questions.add(mMultiQuestion[i]);
        }
        for (int i = 0; i < mFillInTheBlankQuestion.length; i++) {
            questions.add(mFillInTheBlankQuestion[i]);
        }
        for (int i = 0; i < mTFQuestion.length; i++) {
            questions.add(mTFQuestion[i]);
        }
        Collections.shuffle(questions, new Random(seed));
    }

    private void updateQuestion() {

        test = questions.get(mCurrentIndex);
        if (test instanceof MultipleChoiceQuestion) {
            updateMultiChoice((MultipleChoiceQuestion) test);
            mRadioGroup.setVisibility(View.VISIBLE);
            mLinearLayoutTF.setVisibility(View.INVISIBLE);
            mLinearLayoutFITB.setVisibility(View.INVISIBLE);
        } else if (test instanceof FillInTheBlankQuestion) {
            updateFITB((FillInTheBlankQuestion) test);
            mLinearLayoutFITB.setVisibility(View.VISIBLE);
            mRadioGroup.setVisibility(View.INVISIBLE);
            mLinearLayoutTF.setVisibility(View.INVISIBLE);
        } else if (test instanceof TrueFalseQuestion) {
            updateTrueFalse((TrueFalseQuestion) test);
            mLinearLayoutTF.setVisibility(View.VISIBLE);
            mLinearLayoutFITB.setVisibility(View.INVISIBLE);
            mRadioGroup.setVisibility(View.INVISIBLE);
        }
    }

    private void updateMultiChoice(MultipleChoiceQuestion mcQuestion) {

        question = mcQuestion.getQuestionTextResId();
        answer0 = mcQuestion.getAnswer0TextResId();
        answer1 = mcQuestion.getAnswer1TextResId();
        answer2 = mcQuestion.getAnswer2TextResId();
        answer3 = mcQuestion.getAnswer3TextResId();
        mQuestionTextView.setText(question);
        mAnswer0.setText(answer0);
        mAnswer1.setText(answer1);
        mAnswer2.setText(answer2);
        mAnswer3.setText(answer3);
        mCorrectAnswer = mcQuestion.getCorrectAnswerTestResId();
    }

    private void updateTrueFalse(TrueFalseQuestion tfQuestion) {
        question = tfQuestion.getTextResId();
        mQuestionTextView.setText(question);
    }

    private void updateFITB(FillInTheBlankQuestion fitbQuestion) {
        question = fitbQuestion.getQuestion();
        mQuestionTextView.setText(question);
        mAnswerFITB = fitbQuestion.getAnswer();
    }

    private void checkAnswerMultiChoice(int guess) {

        if (guess == mCorrectAnswer) {
            score += 1;
            updateScore();
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
        disableRadioButton();
        return;
    }

    private void checkAnswerTF(boolean userPressedTrue) {
        TrueFalseQuestion tf = (TrueFalseQuestion)questions.get(mCurrentIndex);
        boolean answerIsTrue = tf.isAnswerTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
            score += 1;
            updateScore();
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
        mTrueButton.setEnabled(false);
        mFalseButton.setEnabled(false);
    }

    private void checkAnswerFITB(){
        if (getString(mAnswerFITB).equals(mEditText.getText().toString())){
            score += 1;
            updateScore();
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateScore(){
        mScoreText.setText("Score:" + score);
    }

    public void disableRadioButton() {
        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
            (mRadioGroup.getChildAt(i)).setEnabled(false);
        }
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_zero:
                if (checked)
                    checkAnswerMultiChoice(answer0);
                break;
            case R.id.radio_one:
                if (checked)
                    checkAnswerMultiChoice(answer1);
                break;
            case R.id.radio_two:
                if (checked)
                    checkAnswerMultiChoice(answer2);
                break;
            case R.id.radio_three:
                if (checked)
                    checkAnswerMultiChoice(answer3);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        score = 0;


        mQuestionTextView = (TextView) findViewById(R.id.multiple_question_text_view);
        mScoreText = (TextView) findViewById(R.id.score);
        updateScore();

        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mLinearLayoutFITB = (LinearLayout) findViewById(R.id.fitb);
        mLinearLayoutTF = (LinearLayout) findViewById(R.id.true_false);

        mAnswer0 = (RadioButton) findViewById(R.id.radio_zero);
        mAnswer1 = (RadioButton) findViewById(R.id.radio_one);
        mAnswer2 = (RadioButton) findViewById(R.id.radio_two);
        mAnswer3 = (RadioButton) findViewById(R.id.radio_three);

        updateQuestionsList();
        updateQuestion();

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerTF(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerTF(false);
            }
        });

        mEditText = (EditText) findViewById(R.id.edit_text_view);

        mSubmitButtonFillIn = (Button) findViewById(R.id.submit_fill_in);
        mSubmitButtonFillIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerFITB();
                mSubmitButtonFillIn.setEnabled(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex < questions.size() - 1) {
                    mCurrentIndex = mCurrentIndex + 1;
                    updateQuestion();
                }else{
                    mCurrentIndex = 0;
                    updateQuestion();
                }
            }

        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex != 0) {
                    mCurrentIndex = mCurrentIndex - 1;
                    updateQuestion();
                }
            }
        });
    }

}
