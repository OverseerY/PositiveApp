package xyz.yaroslav.positivetestapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestFragment extends Fragment {

    private int current_answer = 0;

    TextView questionNumber;
    TextView questionText;
    FloatingActionButton nextButton;
    RadioGroup answers;
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    RadioButton answer4;
    RadioButton answer5;

    Resources res;
    String[] questions;

    public TestFragment() {}

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();
        questions = res.getStringArray(R.array.questions);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.test_fragment, container, false);

        questionNumber = rootView.findViewById(R.id.question_label);
        questionText = rootView.findViewById(R.id.question_text);
        nextButton = rootView.findViewById(R.id.fab_next);
        answers = rootView.findViewById(R.id.rg_answers);
        answer1 = rootView.findViewById(R.id.rb_answer_1);
        answer2 = rootView.findViewById(R.id.rb_answer_2);
        answer3 = rootView.findViewById(R.id.rb_answer_3);
        answer4 = rootView.findViewById(R.id.rb_answer_4);
        answer5 = rootView.findViewById(R.id.rb_answer_5);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnswer();
            }
        });

        return rootView;
    }

    private void applyAnswer() {
        if (answers.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getContext(), "Выберите подходящий ответ, чтобы продолжить", Toast.LENGTH_SHORT).show();
        } else {
            if (current_answer < 4) {
                current_answer++;
                questionText.setText(questions[current_answer]);
                answers.clearCheck();
            } else {
                Toast.makeText(getContext(), "Это были все вопросы на сегодня", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
























































