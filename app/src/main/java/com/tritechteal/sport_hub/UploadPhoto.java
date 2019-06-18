package com.tritechteal.sport_hub;
import  android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.io.BufferedReader;
import java.net.URLEncoder;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


public class UploadPhoto extends AppCompatActivity {

    Button GetImageFromGalleryButton, UploadImageOnServerButton;

    ImageView ShowSelectedImage;

    EditText GetImageName;

    Bitmap FixBitmap;
    Bitmap bb;

    ByteArrayOutputStream byteArrayOutputStream ;


    boolean check = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);
        GetImageFromGalleryButton = (Button)findViewById(R.id.button);

        UploadImageOnServerButton = (Button)findViewById(R.id.button2);

        ShowSelectedImage = (ImageView)findViewById(R.id.imageView);

        GetImageName = (EditText)findViewById(R.id.editText);

        byteArrayOutputStream = new ByteArrayOutputStream();

        GetImageFromGalleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "Select Image From Gallery"), 1);

            }
        });


        UploadImageOnServerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FixBitmap!=null) {
                    UploadImageToServer();
                }
                else
                {
                    Toast errorToast = Toast.makeText(UploadPhoto.this, "Select Image ", Toast.LENGTH_SHORT);
                    errorToast.show();
                }



            }
        });
    }
    @Override
    protected void onActivityResult(int RC, int RQC, Intent I) {

        super.onActivityResult(RC, RQC, I);

        if (RC == 1 && RQC == RESULT_OK && I != null && I.getData() != null) {

            Uri uri = I.getData();

            try {


                FixBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

////////
                ////////////
                /////   BitmapFile
                ShowSelectedImage.setImageBitmap(FixBitmap);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    public void UploadImageToServer() {





        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bb=getResizedBitmap(FixBitmap,200);
        bb.compress(Bitmap.CompressFormat.PNG, 30, baos);
        ShowSelectedImage.setImageBitmap(bb);


        byte[] imageBytes = baos.toByteArray();
        final String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        Logic.player.ImageId=imageString;




        //server


        String url = "http://192.168.43.26/SportHub/api/PlayerInfo/";
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.


                Toast SavedToast = Toast.makeText(UploadPhoto.this, response.toString(), Toast.LENGTH_SHORT);
                SavedToast.show();

                Intent intent = new Intent(UploadPhoto.this, LoginActivity.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                //This code is executed if there is an error.
                Toast SavedToast = Toast.makeText(UploadPhoto.this, error.toString(), Toast.LENGTH_SHORT);
                SavedToast.show();

            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> object = new HashMap<String, String>();
                object.put("PlayerName",Logic.player.PlayerName);
                object.put("PlayerPhoneNo",Logic.player.PlayerPhoneNo);
                object.put("Sport",Logic.player.Sport);
                object.put("City",Logic.player.City);
                object.put("role",Logic.player.Role);
                object.put("PlayerImage",Logic.player.ImageId);
                //  object.put("Type",Type.getSelectedItem().toString().trim());
                //object.put("Type","Type");
                object.put("Monday",Logic.player.Monday);
                object.put("Tuesday",Logic.player.Tuesday);
                object.put("Wednesday",Logic.player.Wednesday);
                object.put("Thursday",Logic.player.Thursday);
                object.put("Friday",Logic.player.Friday);
                object.put("Saturday",Logic.player.Saturday);
                object.put("Sunday",Logic.player.Sunday);
                object.put("UserName",Logic.player.UserName);
                object.put("Password",Logic.player.Password);
                return object;
            }
        };
        AppController.getInstance().addToRequestQueue(MyStringRequest, "");






    }


    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }
    private Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//Compression quality, here 100 means no compression, the storage of compressed data to baos
        int options = 90;
        while (baos.toByteArray().length / 1024 > 400) {  //Loop if compressed picture is greater than 400kb, than to compression
            baos.reset();//Reset baos is empty baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//The compression options%, storing the compressed data to the baos
            options -= 10;//Every time reduced by 10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//The storage of compressed data in the baos to ByteArrayInputStream
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//The ByteArrayInputStream data generation
        return bitmap;
    }

}

