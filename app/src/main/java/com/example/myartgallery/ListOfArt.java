package com.example.myartgallery;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListOfArt extends AppCompatActivity {
    ListView listView;String ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_art);
        listView=findViewById(R.id.listItem);
        ss=getIntent().getStringExtra("artistName");
        ParseData();
    }

    private void ParseData() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url="https://api.myjson.online/v1/records/18076d9c-6cc4-46fc-9c56-a4c57c216357";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                jasonparse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(stringRequest);
    }

    private void jasonparse(String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);
            ArrayList<String>art,artistName,period,element,location;
            art=new ArrayList<>();artistName=new ArrayList<>();
            period=new ArrayList<>();element=new ArrayList<>();location=new ArrayList<>();
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                JSONArray jsonArray1=jsonObject1.getJSONArray("art");
                String jc;
                jc=jsonObject1.getString("artistName");
                if(jc.equals(ss)){
                    for(int j=0;j<jsonArray1.length();j++){
                        JSONObject jsonObject2=jsonArray1.getJSONObject(j);
                        String pp=jsonObject2.getString("artName");

                        JSONObject jsonObject3=jsonObject2.getJSONObject("address");
                        period.add(jsonObject3.getString("period"));

                        element.add(jsonObject3.getString("element"));
                        location.add(jsonObject3.getString("location"));

                        artistName.add(pp);
                    }
                }

            }
            ArrayAdapter arrayAdapter=new ArrayAdapter<>(ListOfArt.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,artistName);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String cc,zz,st;
                    cc=period.get(position);
                    st=element.get(position);
                    zz=location.get(position);
                    Intent intent=new Intent(ListOfArt.this,DetailsOfArt.class);

                    String p = "Period:" + cc;
                    String e = "Element:" + st;
                    String z = "Location:" + zz;

                    //Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("value1", p);
                    bundle.putString("value2", e);
                    bundle.putString("value3", z);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }
}