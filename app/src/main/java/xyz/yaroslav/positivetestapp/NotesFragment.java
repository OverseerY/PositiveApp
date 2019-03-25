package xyz.yaroslav.positivetestapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NotesFragment extends Fragment {
    ImageView more;
    ImageView drawer;
    TextView title;
    RecyclerView notes_list;
    FloatingActionButton add_new_note;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notes_layout, container, false);

        more = rootView.findViewById(R.id.notes_menu_more);
        drawer = rootView.findViewById(R.id.notes_menu_drawer);
        title = rootView.findViewById(R.id.notes_title);
        notes_list = rootView.findViewById(R.id.notes_list);
        add_new_note = rootView.findViewById(R.id.notes_add_new);

        return rootView;
    }
}
