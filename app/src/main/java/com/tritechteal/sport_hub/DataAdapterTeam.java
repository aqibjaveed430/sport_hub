package com.tritechteal.sport_hub;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class DataAdapterTeam extends RecyclerView.Adapter<DataAdapterTeam.MyViewHolder> {
    private ArrayList<String> teamname = new ArrayList<>();
    private ArrayList<String> teamsport = new ArrayList<>();
    private ArrayList<String> cityname = new ArrayList<>();
    private ArrayList<String> phoneno = new ArrayList<>();

    private Activity mActivity;
    private int lastPosition = -1;

    public DataAdapterTeam(DisplayTeam activity, ArrayList<String> teamname, ArrayList<String> teamsport, ArrayList<String> cityname, ArrayList<String> phoneno) {
        this.mActivity = activity;
        this.teamname = teamname;
        this.teamsport = teamsport;
        this.cityname = cityname;
        this.phoneno = phoneno;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView TeamName, TeamSport, CityName, PhoneNo;


        public MyViewHolder(View view) {
            super(view);
            TeamName = (TextView) view.findViewById(R.id.TeamName);
            TeamSport = (TextView) view.findViewById(R.id.TeamSport);
            CityName = (TextView) view.findViewById(R.id.CityName);
            PhoneNo = (TextView) view.findViewById(R.id.PhoneNo);


            view.setOnClickListener(this);
            TeamSport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Logic.position= getAdapterPosition();
                    Logic.TeamName=teamname.get(getAdapterPosition());

                    Intent intent=new Intent(mActivity,TeamDisplay.class);
                    mActivity.startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View view) {
            Logic.position= getAdapterPosition();
            Logic.TeamName=teamname.get(getAdapterPosition());
            Intent intent=new Intent(mActivity,TeamDisplay.class);
            mActivity.startActivity(intent);


        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.displayersteam, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.TeamName.setText(teamname.get(position));
        holder.TeamSport.setText(teamsport.get(position));
        holder.CityName.setText(cityname.get(position));
        holder.PhoneNo.setText(phoneno.get(position));

    }

    @Override
    public int getItemCount() {
        return teamname.size();
    }
}

