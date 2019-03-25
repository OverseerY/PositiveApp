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
    ImageView more;
    TextView title;
    TextView description;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_full_layout, container, false);

        drawer = rootView.findViewById(R.id.cf_menu_drawer);
        more = rootView.findViewById(R.id.cf_menu_more);
        title = rootView.findViewById(R.id.cf_title);
        description = rootView.findViewById(R.id.cf_description);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            title.setText(bundle.getString("cardHeader"));
            description.setText(bundle.getString("cardDescription"));
        }

        drawer.setOnClickListener(v -> ((MainActivity) getActivity()).openThisFuckenDrawer());
        return rootView;
    }
}
