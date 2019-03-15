package xyz.yaroslav.positivetestapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFragment extends Fragment {

    private int current_answer = 0;

    private List<String> characterStrengths;

    ImageView menuMore;
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
    String[] quest_strength;
    Map<String, Integer> strength_value;

    public TestFragment() {}

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();
        questions = res.getStringArray(R.array.questions);
        characterStrengths = new ArrayList<>();
        characterStrengths = Arrays.asList(res.getStringArray(R.array.strengths));
        quest_strength = new String[questions.length];
        fillArrayWithCharacterStrengthPerQuestion(quest_strength, characterStrengths);
        strength_value = new HashMap<>();
        fillCollection(strength_value, characterStrengths);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.test_fragment, container, false);

        menuMore = rootView.findViewById(R.id.menu_more);
        questionNumber = rootView.findViewById(R.id.question_label);
        questionText = rootView.findViewById(R.id.question_text);
        nextButton = rootView.findViewById(R.id.fab_next);
        answers = rootView.findViewById(R.id.rg_answers);
        answer1 = rootView.findViewById(R.id.rb_answer_1);
        answer2 = rootView.findViewById(R.id.rb_answer_2);
        answer3 = rootView.findViewById(R.id.rb_answer_3);
        answer4 = rootView.findViewById(R.id.rb_answer_4);
        answer5 = rootView.findViewById(R.id.rb_answer_5);

        String cur_number = getString(R.string.label_question) + 1 + " из " + questions.length;
        questionNumber.setText(cur_number);

        nextButton.setOnClickListener(v -> applyAnswer());

        return rootView;
    }

    private void applyAnswer() {
        if (answers.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getContext(), "Выберите подходящий ответ, чтобы продолжить", Toast.LENGTH_SHORT).show();
        } else {
            getAnswer(current_answer);
            if (current_answer < questions.length - 1) {
                current_answer++;
                questionText.setText(questions[current_answer]);
                answers.clearCheck();
                String next_question = getString(R.string.label_question) + Integer.toString(current_answer + 1) + " из " + questions.length;
                questionNumber.setText(next_question);
            } else {
                Toast.makeText(getContext(), "Это были все вопросы на сегодня", Toast.LENGTH_SHORT).show();
                Log.i("RESULTS", strength_value.values().toString());
            }
        }
    }

    private void getAnswer(int index) {
        int value;
        if (answer1.isChecked()) {
            value = 4;
        } else if (answer2.isChecked()) {
            value = 3;
        } else if (answer3.isChecked()) {
            value = 2;
        } else if (answer4.isChecked()) {
            value = 1;
        } else {
            value = 0;
        }
        updateStrengthValue(index, value);
    }

    private void updateStrengthValue(int index, int value) {
        String str = quest_strength[index];
        if (strength_value.containsKey(str)) {
            strength_value.put(str, strength_value.get(str) + value);
        }
    }

    private void fillArrayWithCharacterStrengthPerQuestion(String[] arr, List<String> strengths) {
        arr[0] = strengths.get(0);
        arr[1] = strengths.get(1);
        arr[2] = strengths.get(2);
        arr[3] = strengths.get(3);
        arr[4] = strengths.get(4);
        arr[5] = strengths.get(5);
        arr[6] = strengths.get(6);
        arr[7] = strengths.get(7);
        arr[8] = strengths.get(8);
        arr[9] = strengths.get(9);
        arr[10] = strengths.get(10);
        arr[11] = strengths.get(11);
        arr[12] = strengths.get(12);
        arr[13] = strengths.get(13);
        arr[14] = strengths.get(14);
        arr[15] = strengths.get(15);
        arr[16] = strengths.get(16);
        arr[17] = strengths.get(17);
        arr[18] = strengths.get(18);
        arr[19] = strengths.get(19);
        arr[20] = strengths.get(20);
        arr[21] = strengths.get(21);
        arr[22] = strengths.get(22);
        arr[23] = strengths.get(23);
        arr[24] = strengths.get(0);
        arr[25] = strengths.get(1);
        arr[26] = strengths.get(2);
        arr[27] = strengths.get(3);
        arr[28] = strengths.get(4);
        arr[29] = strengths.get(5);
        arr[30] = strengths.get(6);
        arr[31] = strengths.get(7);
        arr[32] = strengths.get(8);
        arr[33] = strengths.get(9);
        arr[34] = strengths.get(10);
        arr[35] = strengths.get(11);
        arr[36] = strengths.get(12);
        arr[37] = strengths.get(13);
        arr[38] = strengths.get(14);
        arr[39] = strengths.get(15);
        arr[40] = strengths.get(16);
        arr[41] = strengths.get(17);
        arr[42] = strengths.get(18);
        arr[43] = strengths.get(19);
        arr[44] = strengths.get(20);
        arr[45] = strengths.get(21);
        arr[46] = strengths.get(22);
        arr[47] = strengths.get(23);
        arr[48] = strengths.get(0);
        arr[49] = strengths.get(1);
        arr[50] = strengths.get(2);
        arr[51] = strengths.get(3);
        arr[52] = strengths.get(4);
        arr[53] = strengths.get(5);
        arr[54] = strengths.get(6);
        arr[55] = strengths.get(7);
        arr[56] = strengths.get(8);
        arr[57] = strengths.get(9);
        arr[58] = strengths.get(10);
        arr[59] = strengths.get(11);
        arr[60] = strengths.get(12);
        arr[61] = strengths.get(13);
        arr[62] = strengths.get(14);
        arr[63] = strengths.get(15);
        arr[64] = strengths.get(16);
        arr[65] = strengths.get(17);
        arr[66] = strengths.get(18);
        arr[67] = strengths.get(19);
        arr[68] = strengths.get(20);
        arr[69] = strengths.get(21);
        arr[70] = strengths.get(22);
        arr[71] = strengths.get(23);
        arr[72] = strengths.get(0);
        arr[73] = strengths.get(1);
        arr[74] = strengths.get(2);
        arr[75] = strengths.get(3);
        arr[76] = strengths.get(4);
        arr[77] = strengths.get(5);
        arr[78] = strengths.get(6);
        arr[79] = strengths.get(7);
        arr[80] = strengths.get(8);
        arr[81] = strengths.get(9);
        arr[82] = strengths.get(10);
        arr[83] = strengths.get(11);
        arr[84] = strengths.get(12);
        arr[85] = strengths.get(13);
        arr[86] = strengths.get(14);
        arr[87] = strengths.get(15);
        arr[88] = strengths.get(16);
        arr[89] = strengths.get(17);
        arr[90] = strengths.get(18);
        arr[91] = strengths.get(19);
        arr[92] = strengths.get(20);
        arr[93] = strengths.get(21);
        arr[94] = strengths.get(22);
        arr[95] = strengths.get(23);
        arr[96] = strengths.get(0);
        arr[97] = strengths.get(1);
        arr[98] = strengths.get(2);
        arr[99] = strengths.get(3);
        arr[100] = strengths.get(4);
        arr[101] = strengths.get(5);
        arr[102] = strengths.get(6);
        arr[103] = strengths.get(7);
        arr[104] = strengths.get(8);
        arr[105] = strengths.get(9);
        arr[106] = strengths.get(10);
        arr[107] = strengths.get(11);
        arr[108] = strengths.get(12);
        arr[109] = strengths.get(13);
        arr[110] = strengths.get(14);
        arr[111] = strengths.get(15);
        arr[112] = strengths.get(16);
        arr[113] = strengths.get(17);
        arr[114] = strengths.get(18);
        arr[115] = strengths.get(19);
        arr[116] = strengths.get(20);
        arr[117] = strengths.get(21);
        arr[118] = strengths.get(22);
        arr[119] = strengths.get(23);
    }

    private void fillCollection(Map<String, Integer> map, List<String> strengths) {
        for (String s : strengths) {
            map.put(s, 0);
        }
    }

}
























































