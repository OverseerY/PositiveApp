package xyz.yaroslav.positivetestapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.Collections;
import java.util.Comparator;

public class TestFragment extends Fragment {

    private List<Question> questionList;
    private List<CharacterStrength> strengthList;

    private int current_question = 0;


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
    String[] strengths;
    String[] questions_strengths;
    String[] virtues;
    Map<String, Integer> results;
    String[] iconsRes;

    public TestFragment() {}

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();
        questions = res.getStringArray(R.array.questions);
        prepareQuestions();
        strengths = res.getStringArray(R.array.strengths);
        questions_strengths = setStrengthsToQuestions();
        results = new HashMap<>();
        prepareResults();
        virtues = res.getStringArray(R.array.virtues);
        iconsRes = res.getStringArray(R.array.icons);
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

        String cur_number = Integer.toString(questionList.get(current_question).getQ_id() + 1) + " из " + questions.length;
        String cur_question = questionList.get(current_question).getQ_description();
        questionText.setText(cur_question);
        questionNumber.setText(cur_number);

        nextButton.setOnClickListener(v -> saveAnswer());

        return rootView;
    }

    private void saveAnswer() {
        if (answers.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getContext(), "Выберите подходящий ответ, чтобы продолжить", Toast.LENGTH_SHORT).show();
        } else {
            questionList.get(current_question).setQ_result(getAnswerValue());
            Log.i("RESULT", Integer.toString(questionList.get(current_question).getQ_result()));

            if (current_question < questions.length - 1) {
                current_question++;
                String cur_question = questionList.get(current_question).getQ_description();
                String cur_number = Integer.toString(questionList.get(current_question).getQ_id() + 1) + " из " + questions.length;
                questionText.setText(cur_question);
                questionNumber.setText(cur_number);
                answers.clearCheck();
            } else {
                Toast.makeText(getContext(), "Это были все вопросы на сегодня", Toast.LENGTH_SHORT).show();
                calculateResults();
                Log.i("RESULT", results.entrySet().toString());
            }
        }
    }

    private int getAnswerValue() {
        if (answer1.isChecked()) {
            return 4;
        } else if (answer2.isChecked()) {
            return  3;
        } else if (answer3.isChecked()) {
            return  2;
        } else if (answer4.isChecked()) {
            return  1;
        } else {
            return  0;
        }
    }

    private void prepareQuestions() {
        questionList = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            Question question = new Question(i, questions[i], 0);
            questionList.add(question);
        }
    }

    private void prepareStrengths() {
        strengthList = new ArrayList<>();
        for (int i = 0; i < strengths.length; i++) {
            String virtue;
            int img_res;
            switch (strengths[i]) {
                case "Честность":
                    virtue = getString(R.string.virtue_2);
                    img_res = R.drawable.str1;
                    break;
                case "Чувство юмора":
                    virtue = getString(R.string.virtue_6);
                    img_res = R.drawable.str2;
                    break;
                case "Критическое мышление":
                    virtue = getString(R.string.virtue_1);
                    img_res = R.drawable.str3;
                    break;
                case "Креативность (творческое мышление, оригинальность)":
                    virtue = getString(R.string.virtue_1);
                    img_res = R.drawable.str4;
                    break;
                case "Храбрость (отвага)":
                    virtue = getString(R.string.virtue_2);
                    img_res = R.drawable.str5;
                    break;
                case "Любопытство (любознательность)":
                    virtue = getString(R.string.virtue_1);
                    img_res = R.drawable.str6;
                    break;
                case "Беспристрастность":
                    virtue = getString(R.string.virtue_4);
                    img_res = R.drawable.str7;
                    break;
                case "Прощение (умение прощать)":
                    virtue = getString(R.string.virtue_5);
                    img_res = R.drawable.str8;
                    break;
                case "Оптимизм (надежда,ориентация на будущее)":
                    virtue = getString(R.string.virtue_6);
                    img_res = R.drawable.str9;
                    break;
                case "Доброта (великодушие, забота, сострадание)":
                    virtue = getString(R.string.virtue_3);
                    img_res = R.drawable.str10;
                    break;
                case "Энергичность (жажда жизни, энтузиазм, бодрость)":
                    virtue = getString(R.string.virtue_2);
                    img_res = R.drawable.str11;
                    break;
                case "Лидерство":
                    virtue = getString(R.string.virtue_4);
                    img_res = R.drawable.str12;
                    break;
                case "Любовь к учению":
                    virtue = getString(R.string.virtue_1);
                    img_res = R.drawable.str13;
                    break;
                case "Любовь":
                    virtue = getString(R.string.virtue_3);
                    img_res = R.drawable.str14;
                    break;
                case "Благодарность":
                    virtue = getString(R.string.virtue_6);
                    img_res = R.drawable.str15;
                    break;
                case "Настойчивость (усердие, трудолюбие, стойкость)":
                    virtue = getString(R.string.virtue_2);
                    img_res = R.drawable.str16;
                    break;
                case "Социальный (эмоциональный) интеллект":
                    virtue = getString(R.string.virtue_3);
                    img_res = R.drawable.str17;
                    break;
                case "Умение ценить красоту и совершенство во всём":
                    virtue = getString(R.string.virtue_6);
                    img_res = R.drawable.str18;
                    break;
                case "Широта видения (взгляд с разных точек зрения)":
                    virtue = getString(R.string.virtue_1);
                    img_res = R.drawable.str19;
                    break;
                case "Духовность (вера, смысл жизни)":
                    virtue = getString(R.string.virtue_6);
                    img_res = R.drawable.str20;
                    break;
                case "Благоразумие (осторожность)":
                    virtue = getString(R.string.virtue_5);
                    img_res = R.drawable.str21;
                    break;
                case "Командный дух":
                    virtue = getString(R.string.virtue_4);
                    img_res = R.drawable.str22;
                    break;
                case "Смирение":
                    virtue = getString(R.string.virtue_5);
                    img_res = R.drawable.str23;
                    break;
                case "Самоконтроль (саморегуляция)":
                    virtue = getString(R.string.virtue_5);
                    img_res = R.drawable.str24;
                    break;
                default:
                    virtue = "Неизвестно";
                    img_res = R.drawable.str1;
                    break;
            }
            CharacterStrength characterStrength = new CharacterStrength(strengths[i],virtue,results.get(strengths[i]),img_res);
            strengthList.add(characterStrength);
        }
    }

    private void calculateResults() {
        results.clear();
        prepareResults();
        for (int i = 0; i < questions_strengths.length; i++) {
            results.put(questions_strengths[i], results.get(questions_strengths[i]) + questionList.get(i).getQ_result());
        }
        prepareStrengths();
    }

    private void prepareResults() {
        for (String s : strengths) {
            results.put(s,0);
        }
    }

    private String[] setStrengthsToQuestions() {
        String[] quest_strength = new String[questions.length];
        quest_strength[0] = strengths[0];
        quest_strength[1] = strengths[1];
        quest_strength[2] = strengths[2];
        quest_strength[3] = strengths[3];
        quest_strength[4] = strengths[4];
        quest_strength[5] = strengths[5];
        quest_strength[6] = strengths[6];
        quest_strength[7] = strengths[7];
        quest_strength[8] = strengths[8];
        quest_strength[9] = strengths[9];
        quest_strength[10] = strengths[10];
        quest_strength[11] = strengths[11];
        quest_strength[12] = strengths[12];
        quest_strength[13] = strengths[13];
        quest_strength[14] = strengths[14];
        quest_strength[15] = strengths[15];
        quest_strength[16] = strengths[16];
        quest_strength[17] = strengths[17];
        quest_strength[18] = strengths[18];
        quest_strength[19] = strengths[19];
        quest_strength[20] = strengths[20];
        quest_strength[21] = strengths[21];
        quest_strength[22] = strengths[22];
        quest_strength[23] = strengths[23];
        quest_strength[24] = strengths[0];
        quest_strength[25] = strengths[1];
        quest_strength[26] = strengths[2];
        quest_strength[27] = strengths[3];
        quest_strength[28] = strengths[4];
        quest_strength[29] = strengths[5];
        quest_strength[30] = strengths[6];
        quest_strength[31] = strengths[7];
        quest_strength[32] = strengths[8];
        quest_strength[33] = strengths[9];
        quest_strength[34] = strengths[10];
        quest_strength[35] = strengths[11];
        quest_strength[36] = strengths[12];
        quest_strength[37] = strengths[13];
        quest_strength[38] = strengths[14];
        quest_strength[39] = strengths[15];
        quest_strength[40] = strengths[16];
        quest_strength[41] = strengths[17];
        quest_strength[42] = strengths[18];
        quest_strength[43] = strengths[19];
        quest_strength[44] = strengths[20];
        quest_strength[45] = strengths[21];
        quest_strength[46] = strengths[22];
        quest_strength[47] = strengths[23];
        quest_strength[48] = strengths[0];
        quest_strength[49] = strengths[1];
        quest_strength[50] = strengths[2];
        quest_strength[51] = strengths[3];
        quest_strength[52] = strengths[4];
        quest_strength[53] = strengths[5];
        quest_strength[54] = strengths[6];
        quest_strength[55] = strengths[7];
        quest_strength[56] = strengths[8];
        quest_strength[57] = strengths[9];
        quest_strength[58] = strengths[10];
        quest_strength[59] = strengths[11];
        quest_strength[60] = strengths[12];
        quest_strength[61] = strengths[13];
        quest_strength[62] = strengths[14];
        quest_strength[63] = strengths[15];
        quest_strength[64] = strengths[16];
        quest_strength[65] = strengths[17];
        quest_strength[66] = strengths[18];
        quest_strength[67] = strengths[19];
        quest_strength[68] = strengths[20];
        quest_strength[69] = strengths[21];
        quest_strength[70] = strengths[22];
        quest_strength[71] = strengths[23];
        quest_strength[72] = strengths[0];
        quest_strength[73] = strengths[1];
        quest_strength[74] = strengths[2];
        quest_strength[75] = strengths[3];
        quest_strength[76] = strengths[4];
        quest_strength[77] = strengths[5];
        quest_strength[78] = strengths[6];
        quest_strength[79] = strengths[7];
        quest_strength[80] = strengths[8];
        quest_strength[81] = strengths[9];
        quest_strength[82] = strengths[10];
        quest_strength[83] = strengths[11];
        quest_strength[84] = strengths[12];
        quest_strength[85] = strengths[13];
        quest_strength[86] = strengths[14];
        quest_strength[87] = strengths[15];
        quest_strength[88] = strengths[16];
        quest_strength[89] = strengths[16];
        quest_strength[90] = strengths[18];
        quest_strength[91] = strengths[19];
        quest_strength[92] = strengths[20];
        quest_strength[93] = strengths[21];
        quest_strength[94] = strengths[22];
        quest_strength[95] = strengths[23];
        quest_strength[96] = strengths[0];
        quest_strength[97] = strengths[1];
        quest_strength[98] = strengths[2];
        quest_strength[99] = strengths[3];
        quest_strength[100] = strengths[4];
        quest_strength[101] = strengths[5];
        quest_strength[102] = strengths[6];
        quest_strength[103] = strengths[7];
        quest_strength[104] = strengths[8];
        quest_strength[105] = strengths[9];
        quest_strength[106] = strengths[10];
        quest_strength[107] = strengths[11];
        quest_strength[108] = strengths[12];
        quest_strength[109] = strengths[13];
        quest_strength[110] = strengths[14];
        quest_strength[111] = strengths[15];
        quest_strength[112] = strengths[16];
        quest_strength[113] = strengths[17];
        quest_strength[114] = strengths[18];
        quest_strength[115] = strengths[19];
        quest_strength[116] = strengths[20];
        quest_strength[117] = strengths[21];
        quest_strength[118] = strengths[22];
        quest_strength[119] = strengths[23];

        return quest_strength;
    }

    private void showResultFragment() {
        ResultFragment fragment = new ResultFragment();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

}
























































