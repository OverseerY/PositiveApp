package xyz.yaroslav.positivetestapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {
    private List<CharacterStrength> strengthList;

    public ResultsAdapter(List<CharacterStrength> strengthList) {
        this.strengthList = strengthList;
    }

    @NonNull
    @Override
    public ResultsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.strength_item, parent, false);
        return new ResultsAdapter.ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsAdapter.ViewHolder viewHolder, int position) {
        CharacterStrength strength = strengthList.get(position);

        viewHolder.header.setText(strength.getName());
        viewHolder.virtue.setText(strength.getVirtue());
        viewHolder.icon.setImageResource(strength.getIcon_resource());
    }

    @Override
    public int getItemCount() {
        return strengthList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView header, virtue;
        ImageView icon;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            header = itemView.findViewById(R.id.strength_header);
            virtue = itemView.findViewById(R.id.strength_virtue);
            icon = itemView.findViewById(R.id.strength_icon);
            cardView = itemView.findViewById(R.id.strength_card);
        }
    }
}






































