package com.tritechteal.sport_hub;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    public static ArrayList<String> TournamentName = new ArrayList<>();
    public static ArrayList<String> Venue = new ArrayList<>();
    public static ArrayList<String> Sport = new ArrayList<>();
    public static ArrayList<String> StartDate = new ArrayList<>();
    public static ArrayList<String> EndDate = new ArrayList<>();
    public static ArrayList<String> Description = new ArrayList<>();



    private Activity mActivity;
    private int lastPosition = -1;

    public DataAdapter(CurrentPreviousTournament activity, ArrayList<String> TournamentName, ArrayList<String> Venue, ArrayList<String> Sport, ArrayList<String> StartDate,  ArrayList<String> EndDate, ArrayList<String> Description ) {
        this.mActivity = activity;
        this.TournamentName = TournamentName;
        this.Venue = Venue;
        this.Sport = Sport;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Description = Description;


    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tournamenr_name, venue,sport,startdate,enddate,descripition;


        public MyViewHolder(View view) {
            super(view);
            tournamenr_name = (TextView) view.findViewById(R.id.TournamentName);
            venue = (TextView) view.findViewById(R.id.Venue);
            sport = (TextView) view.findViewById(R.id.Sport);
            startdate = (TextView) view.findViewById(R.id.StartDate);
            enddate = (TextView) view.findViewById(R.id.EndDate);
            descripition = (TextView) view.findViewById(R.id.Description);


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
        holder.venue.setText(Venue.get(position));
        holder.sport.setText(Sport.get(position));
        holder.startdate.setText(StartDate.get(position));
        holder.enddate.setText(EndDate.get(position));
        holder.descripition.setText(Description.get(position));
        ;
    }

    @Override
    public int getItemCount() {
        return TournamentName.size();
    }
}