package com.tritechteal.sport_hub;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private ArrayList<String> TournamentName = new ArrayList<>();
    private ArrayList<String> TournamentDetial = new ArrayList<>();


    private Activity mActivity;
    private int lastPosition = -1;

    public DataAdapter(CurrentPreviousTournament activity, ArrayList<String> TournamentName, ArrayList<String> TournamentDetial) {
        this.mActivity = activity;
        this.TournamentName = TournamentName;
        this.TournamentDetial = TournamentDetial;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tournamenr_name, tournamenr_detial;


        public MyViewHolder(View view) {
            super(view);
            tournamenr_name = (TextView) view.findViewById(R.id.ABC);
            tournamenr_detial = (TextView) view.findViewById(R.id.CDE);


            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.datacard, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tournamenr_name.setText(TournamentName.get(position));
        holder.tournamenr_detial.setText(TournamentDetial.get(position));
        ;
    }

    @Override
    public int getItemCount() {
        return TournamentName.size();
    }
}