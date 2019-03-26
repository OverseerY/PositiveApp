package xyz.yaroslav.positivetestapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private List<Card> cardList;
    private Context context;

    public CardAdapter(List<Card> cardList, Context context) {
        this.cardList = cardList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardAdapter.ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Card card = cardList.get(position);
        holder.icon.setImageResource(card.getImgResource());
        holder.title.setText(card.getTitle());
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;

        public ViewHolder(@NonNull View view) {
            super(view);

            view.setOnClickListener(v -> {
                Card selected_card = cardList.get(getAdapterPosition());
                openCardFullFragment(selected_card);
            });

            icon = view.findViewById(R.id.card_icon);
            title = view.findViewById(R.id.card_header);
        }
    }

    private void openCardFullFragment(Card card) {
        ShowCardFragment fragment = new ShowCardFragment();
        Bundle bundle = new Bundle();
        bundle.putString("cardHeader", card.getTitle());
        bundle.putStringArray("cardDesc", card.getDescription());
        bundle.putStringArray("cardLab", card.getLabel());
        fragment.setArguments(bundle);
        FragmentTransaction ft = ((MainActivity)context).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

}





































