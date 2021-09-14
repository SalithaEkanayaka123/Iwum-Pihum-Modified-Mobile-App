package com.example.uee_recipe_management.application.temporary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.Bookmark;
import com.example.uee_recipe_management.application.category.ResponsiveVerticalHorizontalLayout;
import com.example.uee_recipe_management.application.home.Home;
import com.example.uee_recipe_management.application.settings.SettingPage;

public class TemporaryIndexPage extends AppCompatActivity {

    Button settingButton;
    Button addItem;
    Button homeButton;
    Button responsivePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary_index_page);

        settingButton = findViewById(R.id.settings_button);
        addItem = findViewById(R.id.add_item);
        homeButton = findViewById(R.id.home_button);
        responsivePage = findViewById(R.id.responsive_button);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(), SettingPage.class);
                view.getContext().startActivity(intent);
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(), Bookmark.class);
                view.getContext().startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(), Home.class);
                view.getContext().startActivity(intent);
            }
        });

        responsivePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(), ResponsiveVerticalHorizontalLayout.class);
                view.getContext().startActivity(intent);
            }
        });



    }
}