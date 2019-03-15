package xyz.yaroslav.positivetestapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ResultFragment extends Fragment {

    RecyclerView resultList;
    ImageView menuResults;

    public ResultFragment() {}

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.result_fragment, container, false);

        resultList = rootView.findViewById(R.id.result_strengths);
        menuResults = rootView.findViewById(R.id.menu_results);

        return rootView;
    }
}