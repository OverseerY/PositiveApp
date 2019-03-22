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

public class StartFragment extends Fragment {
    ImageView drawerMenu;
    ImageView moreMenu;
    TextView title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.start_fragment, container, false);

        drawerMenu = rootView.findViewById(R.id.start_menu_drawer);
        moreMenu = rootView.findViewById(R.id.start_menu_more);
        title = rootView.findViewById(R.id.start_title);

        drawerMenu.setOnClickListener(v -> ((MainActivity) getActivity()).openThisFuckenDrawer());

        return rootView;
    }
}
