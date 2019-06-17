package com.tritechteal.sport_hub;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PlayerAddDataAdapter extends RecyclerView.Adapter<PlayerAddDataAdapter.MyViewHolder> {

    private ArrayList<String> mBlogTitleList = new ArrayList<>();
    private ArrayList<String> mAuthorNameList = new ArrayList<>();
    private ArrayList<String> mBlogUploadDateList = new ArrayList<>();
    private ArrayList<Bitmap> mBlogImageList = new ArrayList<>();

    private Activity mActivity;
    private int lastPosition = -1;

    public PlayerAddDataAdapter(NeededPlayer activity, ArrayList<String> mBlogTitleList, ArrayList<String> mAuthorNameList, ArrayList<String> mBlogUploadDateList, ArrayList<Bitmap> mBlogImageList) {
        this.mActivity = activity;
        this.mBlogTitleList = mBlogTitleList;
        this.mAuthorNameList = mAuthorNameList;
        this.mBlogUploadDateList = mBlogUploadDateList;
        this.mBlogImageList = mBlogImageList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tv_blog_title, tv_blog_author;
        private TextView tv_blog_upload_date;
        private ImageView ig;
        private Button add;

        public MyViewHolder(View view) {
            super(view);
            tv_blog_title = (TextView) view.findViewById(R.id.Name);
            tv_blog_author = (TextView) view.findViewById(R.id.Car);
            tv_blog_upload_date = (TextView) view.findViewById(R.id.Address);
            add = (Button) view.findViewById(R.id.Addbutton);
            ig=(ImageView) view.findViewById(R.id.imageViewpic);

            view.setOnClickListener(this);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    /*Logic.positionforplaces = getAdapterPosition();
                    if (Logic.PlaceIdres.get(Logic.positionforplaces) == false) {
                        Logic.PlanPlaces.add(Logic.PlaceId.get(Logic.positionforplaces));

                        Logic.PlaceIdres.add(Logic.positionforplaces,true);
                        Toast errorToast = Toast.makeText(mActivity, "Added to your Places ", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }
                    else
                    {
                        Toast errorToast = Toast.makeText(mActivity, "Already Added ", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }*/
                }
            });
        }
        @Override
        public void onClick(View view) {




        }

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playerlist, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_blog_title.setText(mBlogTitleList.get(position));
        holder.tv_blog_author.setText(mAuthorNameList.get(position));
        holder.tv_blog_upload_date.setText(mBlogUploadDateList.get(position));


        holder.ig.setImageBitmap(mBlogImageList.get(position));
    }

    @Override
    public int getItemCount() {
        return mBlogTitleList.size();
    }
}
