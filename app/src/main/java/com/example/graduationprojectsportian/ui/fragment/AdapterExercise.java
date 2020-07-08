package com.example.graduationprojectsportian.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.ExerciseList;
import com.example.graduationprojectsportian.ui.activity.DetailsActivity;
import com.example.graduationprojectsportian.ui.activity.ExerciseActivity;
import com.example.graduationprojectsportian.util.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterExercise extends RecyclerView.Adapter<AdapterExercise.ViewHolder> {

    private List<ExerciseList> list;
    Context context;

    AdapterExercise(Context context) {
        this.context=context;
        list = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise, parent, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExerciseList mlist = list.get(position);

        holder.tvName.setText(mlist.getExerciseName());
        holder.ivSport.setImageResource(mlist.getExerciseImage());

        holder.lay_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ExerciseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.COUNTRY, mlist);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    public void setList(List<ExerciseList> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivSport)
        ImageView ivSport;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.lay_news)
        LinearLayout lay_news;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}