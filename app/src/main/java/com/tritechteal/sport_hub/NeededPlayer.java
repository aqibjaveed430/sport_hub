package com.tritechteal.sport_hub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class NeededPlayer extends AppCompatActivity {
    public static ArrayList<String> Name = new ArrayList<>();
    public static ArrayList<String> Address = new ArrayList<>();
    public static ArrayList<String> Phoneno = new ArrayList<>();
    public static ArrayList<Bitmap> Image = new ArrayList<>();
    public static ArrayList<String> Image2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needed_player);

        String url = "http://192.168.10.14/SportHub/api/PlayerInfo/";
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("apicallres", response.toString());


                try {



                    int a=0;
                    for (int i = 0; i < response.length(); i++) {
                        a=1;
                        JSONObject c = response.getJSONObject(i);
                        Name.add(c.getString("PlayerName").toString().trim());
                        Address.add(c.getString("PlayerPhoneNo").toString().trim());
                        Phoneno.add(c.getString("Sport").toString().trim());
                        Image2.add(c.getString("PlayerImage").toString().trim());

                    }

                    if(a==0) {
                        Toast errorToast = Toast.makeText(NeededPlayer.this, "No Player Found ", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }

                    if(Name.size()==response.length())
                    {

                        for(int i=0;i<Image2.size();i++)
                        {
                            String base64String = Image2.get(i);
                            //String base64Image = base64String.split(",")[1];

                            byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
                            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                            Image.add(decodedByte);
                        }



                        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.act_recyclerview2);



                        PlayerAddDataAdapter mDataAdapter = new PlayerAddDataAdapter(NeededPlayer.this, Name , Address, Phoneno,Image);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        mRecyclerView.setAdapter(mDataAdapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast errorToast = Toast.makeText(NeededPlayer.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, "");






        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {






            }
        }, 2000);

    }



}



