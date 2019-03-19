package xyz.yaroslav.positivetestapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Collections;

public class ResultFragment extends Fragment {

    RecyclerView resultList;
    ImageView menuResults;
    ProgressBar resultProgress;

    private ArrayList<CharacterStrength>  strengthList;
    private ResultsAdapter resultsAdapter;

    public ResultFragment() {}

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        strengthList = new ArrayList<>();
        strengthList = getArguments().getParcelableArrayList("testResults");
        Collections.sort(strengthList, CharacterStrength.StrengthComparator);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.result_fragment, container, false);

        resultList = rootView.findViewById(R.id.result_strengths);
        menuResults = rootView.findViewById(R.id.menu_results);
        resultProgress = rootView.findViewById(R.id.result_progress);

        if (!strengthList.isEmpty()) {
            buildResult();
        }

        return rootView;
    }

    private void buildResult() {
        resultsAdapter = new ResultsAdapter(strengthList, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        resultList.setLayoutManager(layoutManager);
        resultList.setItemAnimator(new DefaultItemAnimator());
        resultList.setAdapter(resultsAdapter);
    }
}
