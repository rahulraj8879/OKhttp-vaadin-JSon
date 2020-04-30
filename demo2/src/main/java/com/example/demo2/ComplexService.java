package com.example.demo2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;


@org.springframework.stereotype.Service

public class ComplexService {

  private String url = "https://jsonplaceholder.typicode.com/posts";

  OkHttpClient client = new OkHttpClient();
  Response response ;

  public JSONArray getData() throws IOException {
    Request request =  new Request.Builder().url(url).build();
    response = client.newCall(request).execute();
    try {
//      System.out.println(response.body().string());
      return new JSONArray(response.body().string());
    } catch (JSONException e) {
      e.printStackTrace();
    }return null;
  }

}
