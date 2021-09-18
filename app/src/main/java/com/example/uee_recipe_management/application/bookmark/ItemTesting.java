package com.example.uee_recipe_management.application.bookmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.uee_recipe_management.application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ItemTesting extends AppCompatActivity {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_testing);

        fab =findViewById(R.id.add_btn);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemTesting.this, "You clicked on add item button", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(view.getContext(), AddItem.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}