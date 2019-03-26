package xyz.yaroslav.positivetestapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CardsFragment extends Fragment {
    ImageView drawer;
    //ImageView search;
    TextView title;
    RecyclerView cards_list;

    List<Card> cards;
    String[] headers;
    String[] icons;
    Resources resourses;

    CardAdapter cardAdapter;

    String[][] card_desc;
    String[][] card_parag;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resourses = getResources();
        cards = new ArrayList<>();
        headers = resourses.getStringArray(R.array.card_titles);
        icons = resourses.getStringArray(R.array.icons);

        card_parag = new String[17][];
        card_desc = new String[17][];

        prepareCardDescriptions();
        prepareCards();

        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cards_layout, container, false);

        drawer = rootView.findViewById(R.id.cards_menu_drawer);
        //search = rootView.findViewById(R.id.cards_menu_more);
        title = rootView.findViewById(R.id.cards_title);
        cards_list = rootView.findViewById(R.id.cards_list);

        if (!cards.isEmpty()) {
            cardAdapter = new CardAdapter(cards, getContext());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            cards_list.setLayoutManager(mLayoutManager);
            cards_list.setItemAnimator(new DefaultItemAnimator());
            cards_list.setAdapter(cardAdapter);
        }



        drawer.setOnClickListener(v -> ((MainActivity) getActivity()).openThisFuckenDrawer());

        return rootView;
    }

    private void prepareCards() {
        for (int i = 0; i < headers.length; i++) {
            int img_res;
            String[] des = card_desc[i];
            String[] lab = card_parag[i];

            if (getResId(icons[i], R.drawable.class) != -1) {
                img_res = getResId(icons[i], R.drawable.class);
            } else {
                img_res = R.drawable.img_def;
            }
            Card card = new Card(headers[i], des, lab, img_res);
            cards.add(card);
        }
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void prepareCardDescriptions() {
        card_desc[0] = resourses.getStringArray(R.array.card_d1);
        card_desc[1] = resourses.getStringArray(R.array.card_d2);
        card_desc[2] = resourses.getStringArray(R.array.card_d3);
        card_desc[3] = resourses.getStringArray(R.array.card_d4);
        card_desc[4] = resourses.getStringArray(R.array.card_d5);
        card_desc[5] = resourses.getStringArray(R.array.card_d6);
        card_desc[6] = resourses.getStringArray(R.array.card_d7);
        card_desc[7] = resourses.getStringArray(R.array.card_d8);
        card_desc[8] = resourses.getStringArray(R.array.card_d9);
        card_desc[9] = resourses.getStringArray(R.array.card_d10);
        card_desc[10] = resourses.getStringArray(R.array.card_d11);
        card_desc[11] = resourses.getStringArray(R.array.card_d12);
        card_desc[12] = resourses.getStringArray(R.array.card_d13);
        card_desc[13] = resourses.getStringArray(R.array.card_d14);
        card_desc[14] = resourses.getStringArray(R.array.card_d15);
        card_desc[15] = resourses.getStringArray(R.array.card_d16);
        card_desc[16] = resourses.getStringArray(R.array.card_d17);

        card_parag[0] = resourses.getStringArray(R.array.card_p1);
        card_parag[1] = resourses.getStringArray(R.array.card_p2);
        card_parag[2] = resourses.getStringArray(R.array.card_p3);
        card_parag[3] = resourses.getStringArray(R.array.card_p4);
        card_parag[4] = resourses.getStringArray(R.array.card_p5);
        card_parag[5] = resourses.getStringArray(R.array.card_p6);
        card_parag[6] = resourses.getStringArray(R.array.card_p7);
        card_parag[7] = resourses.getStringArray(R.array.card_p8);
        card_parag[8] = resourses.getStringArray(R.array.card_p9);
        card_parag[9] = resourses.getStringArray(R.array.card_p10);
        card_parag[10] = resourses.getStringArray(R.array.card_p11);
        card_parag[11] = resourses.getStringArray(R.array.card_p12);
        card_parag[12] = resourses.getStringArray(R.array.card_p13);
        card_parag[13] = resourses.getStringArray(R.array.card_p14);
        card_parag[14] = resourses.getStringArray(R.array.card_p15);
        card_parag[15] = resourses.getStringArray(R.array.card_p16);
        card_parag[16] = resourses.getStringArray(R.array.card_p17);
    }
}















