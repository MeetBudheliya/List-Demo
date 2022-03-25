package com.example.itemslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView list;
    Button addButton;
    EditText nameText;

//    String[] fruits = new String[]{"Apple","Banana","Strawberry","Mango"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> fruits = new ArrayList<String>();
        list = findViewById(R.id.list);
        addButton = findViewById(R.id.AddBTN);
        nameText = findViewById(R.id.nameET);
        nameText.setText("");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,fruits);
        list.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = nameText.getText().toString();
                if (text.equals("")){
                    Toast.makeText(MainActivity.this,"Please fill textfield value for add fruit in list...",Toast.LENGTH_LONG).show();
                }else{
                    fruits.add(nameText.getText().toString());
                    adapter.notifyDataSetChanged();
                    nameText.setText("");
                }
            }
        });
    }
}