package com.example.demo2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
@Route("")
public class mtView extends VerticalLayout {


  



  public mtView() throws IOException {


    TextArea textArea = new TextArea("write");
    Button button =new Button("click me");
    Label label = new Label();
    add(textArea,button,label);

    ComplexService complexService = new ComplexService();
//    complexService.getData();

    JSONArray myObj = complexService.getData();

    for (int i=0;i<myObj.length();i++){

      try {
        JSONObject jsonObject = myObj.getJSONObject(i);
       int id = jsonObject.getInt("userId");
       String title = jsonObject.getString("title");
       if (id == 1){
         System.out.println(title);
       }
//        System.out.println("title :-"+jsonObject.getString("title"));
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    System.out.println(myObj);


  }
}
