package com.example.shram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private List<Job> joblist;

    public JobAdapter(Home home, List<Job> joblist){
        this.joblist = joblist;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_recycler_view, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.image.setImageResource(joblist.get(position).getImage());
        holder.name.setText(joblist.get(position).getJname());
    }

    @Override
    public int getItemCount() {
        return joblist.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;

        public JobViewHolder(@NonNull View itemView) {

            super(itemView);

            image = itemView.findViewById(R.id.j_r_img);
            name = itemView.findViewById(R.id.j_r_name);

        }
    }

}
