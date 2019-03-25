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
    ImageView more;
    TextView title;
    RecyclerView cards_list;

    List<Card> cards;
    String[] headers;
    String[] descriptions;
    String[] icons;
    Resources resourses;

    CardAdapter cardAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resourses = getResources();
        cards = new ArrayList<>();
        headers = resourses.getStringArray(R.array.card_titles);
        descriptions = resourses.getStringArray(R.array.card_descriptions);
        icons = resourses.getStringArray(R.array.icons);

        prepareCards();

        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cards_layout, container, false);

        drawer = rootView.findViewById(R.id.cards_menu_drawer);
        more = rootView.findViewById(R.id.cards_menu_more);
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
            /*TODO: check for getResId != -1*/
            Card card = new Card(headers[i], descriptions[i], getResId(icons[i], R.drawable.class));
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
}















