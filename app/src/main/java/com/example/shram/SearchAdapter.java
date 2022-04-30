package com.example.shram;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{

    private List<Worker> workerlist;
    Context context;

    public SearchAdapter (List<Worker> wlist, Context context){
        this.workerlist = wlist;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        final Worker t = workerlist.get(position);

        holder.name.setText(workerlist.get(position).getName());
        holder.skill.setText(workerlist.get(position).getSkill());
        Picasso.with(context)
                .load(Uri.parse(workerlist.get(position).getImage()))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return workerlist.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{

        private TextView name, skill;
        private ImageView image;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.w_r_h_name);
            skill = itemView.findViewById(R.id.w_r_h_skill);
            image = itemView.findViewById(R.id.w_r_h_img);

        }
    }

}