package com.example.okttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public String getRequests() throws IOException {
        OkHttpClient client = new OkHttpClient();

        String url = "http://www.baidu.com";
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String getPost() throws IOException{

         final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        String json = "http://www.roundsapp.com/post";
        String url = bowlingJson("Jesse","Jake");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON,json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }

    public void getRequest(View view) {

        new Thread() {
            @Override
            public void run() {
                String response = null;
                try {
                    response = getPost();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("xx", "response:::" + response);
            }
        }.start();


    }
}
