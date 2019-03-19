package xyz.yaroslav.positivetestapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {
    private List<CharacterStrength> strengthList;
    Context context;

    public ResultsAdapter(List<CharacterStrength> strengthList, Context context) {
        this.strengthList = strengthList;
        this.context = context;
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
        viewHolder.virtue.setTextColor(getColor(strength.getVirtue()));
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

    private int getColor(String currentVirtue) {
        switch (currentVirtue) {
            case "Мудрость":
                return context.getResources().getColor(R.color.color_wisdom);
            case "Мужество":
                return context.getResources().getColor(R.color.color_courage);
            case "Гуманность":
                return context.getResources().getColor(R.color.color_humanity);
            case "Справедливость":
                return context.getResources().getColor(R.color.color_justice);
            case "Самоконтроль":
                return context.getResources().getColor(R.color.color_temperance);
            case "Превосходство":
                return context.getResources().getColor(R.color.color_transcendence);
            default:
                return context.getResources().getColor(R.color.colorPrimary);
        }
    }
}






































