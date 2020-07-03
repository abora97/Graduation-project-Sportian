package com.example.graduationprojectsportian.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graduationprojectsportian.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_Config {

    private Context mcontext;
    private SportsAdapter mSportsAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Sport> sports, List<String> keys){
        mcontext = context;
        mSportsAdapter = new SportsAdapter(sports,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mSportsAdapter);

    }


    class SportItemView extends RecyclerView.ViewHolder{
        private TextView center;
        private TextView captain;
        private TextView day = (TextView) itemView.findViewById(R.id.txtPhone);
        private TextView time;
        private TextView age;
        private TextView cost;
        private TextView gender;
        private TextView phone;

        private String key;

        public SportItemView (ViewGroup parent){
            super(LayoutInflater.from(mcontext).
                    inflate(R.layout.sport_list_item, parent , false));

                    center = (TextView) itemView.findViewById(R.id.txtCenter);
                    captain = (TextView) itemView.findViewById(R.id.txtCaptain);
                    day = (TextView) itemView.findViewById(R.id.txtDay);
                    time = (TextView) itemView.findViewById(R.id.txtTime);
                    age = (TextView) itemView.findViewById(R.id.txtAge);
                    cost = (TextView) itemView.findViewById(R.id.txtCost);
                    gender = (TextView) itemView.findViewById(R.id.txtGender);
                    phone = (TextView) itemView.findViewById(R.id.txtPhone);
        }

        public void bind(Sport sport, String key){
            center.setText((sport.getCenter()));
            captain.setText((sport.getCaptain()));
            day.setText((sport.getDay()));
            time.setText((sport.getTime()));
            age.setText((sport.getAge()));
            cost.setText((sport.getCost()));
            gender.setText((sport.getGender()));
            phone.setText((sport.getPhone()));

            this.key=key;
        }
    }
    class SportsAdapter extends RecyclerView.Adapter<SportItemView>{
        private List<Sport> mSportList;
        private List<String> mkeys;

        public SportsAdapter(List<Sport> mSportList, List<String> mkeys) {
            this.mSportList = mSportList;
            this.mkeys = mkeys;
        }

        @Override
        public SportItemView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SportItemView(parent);
        }

        @Override
        public void onBindViewHolder(SportItemView holder, int position) {
            holder.bind(mSportList.get(position),mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mSportList.size();
        }
    }

}
