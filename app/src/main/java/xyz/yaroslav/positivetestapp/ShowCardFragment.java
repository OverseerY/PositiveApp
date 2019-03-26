package xyz.yaroslav.positivetestapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowCardFragment extends Fragment {
    ImageView drawer;
    //ImageView more;
    TextView title;
    TextView description1;
    TextView description2;
    TextView description3;
    TextView description4;
    TextView description5;
    TextView label1;
    TextView label2;
    TextView label3;
    TextView label4;
    TextView label5;
    ImageView card17;

    String[] descriptions;
    String[] labels;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_full_layout, container, false);

        drawer = rootView.findViewById(R.id.cf_menu_drawer);
        //more = rootView.findViewById(R.id.cf_menu_more);
        title = rootView.findViewById(R.id.cf_title);
        description1 = rootView.findViewById(R.id.cf_paragraph1);
        description2 = rootView.findViewById(R.id.cf_paragraph2);
        description3 = rootView.findViewById(R.id.cf_paragraph3);
        description4 = rootView.findViewById(R.id.cf_paragraph4);
        description5 = rootView.findViewById(R.id.cf_paragraph5);
        label1 = rootView.findViewById(R.id.cf_label1);
        label2 = rootView.findViewById(R.id.cf_label2);
        label3 = rootView.findViewById(R.id.cf_label3);
        label4 = rootView.findViewById(R.id.cf_label4);
        label5 = rootView.findViewById(R.id.cf_label5);
        card17 = rootView.findViewById(R.id.cf_card17);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            title.setText(bundle.getString("cardHeader"));
            if (bundle.getString("cardHeader").equals(getString(R.string.card_title_17))) {
                card17.setVisibility(View.VISIBLE);
                card17.setImageResource(R.drawable.img17);
            }

            descriptions = bundle.getStringArray("cardDesc");
            labels = bundle.getStringArray("cardLab");

            if (descriptions[0].equals("")) {
                description1.setVisibility(View.GONE);
            } else {
                description1.setText(descriptions[0]);
            }

            if (descriptions[1].equals("")) {
                description2.setVisibility(View.GONE);
            } else {
                description2.setText(descriptions[1]);
            }

            if (descriptions[2].equals("")) {
                description3.setVisibility(View.GONE);
            } else {
                description3.setText(descriptions[2]);
            }

            if (descriptions[3].equals("")) {
                description4.setVisibility(View.GONE);
            } else {
                description4.setText(descriptions[3]);
            }

            if (descriptions[4].equals("")) {
                description5.setVisibility(View.GONE);
            } else {
                description5.setText(descriptions[4]);
            }

            if (labels[0].equals("")) {
                label1.setVisibility(View.GONE);
            } else {
                label1.setText(labels[0]);
            }

            if (labels[1].equals("")) {
                label2.setVisibility(View.GONE);
            } else {
                label2.setText(labels[1]);
            }

            if (labels[2].equals("")) {
                label3.setVisibility(View.GONE);
            } else {
                label3.setText(labels[2]);
            }

            if (labels[3].equals("")) {
                label4.setVisibility(View.GONE);
            } else {
                label4.setText(labels[3]);
            }

            if (labels[4].equals("")) {
                label5.setVisibility(View.GONE);
            } else {
                label5.setText(labels[4]);
            }
        }

        drawer.setOnClickListener(v -> ((MainActivity) getActivity()).openThisFuckenDrawer());
        return rootView;
    }
}
