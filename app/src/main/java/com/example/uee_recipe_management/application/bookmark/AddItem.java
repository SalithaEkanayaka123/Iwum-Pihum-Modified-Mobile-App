package com.example.uee_recipe_management.application.bookmark;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.uee_recipe_management.application.R;
import com.squareup.picasso.Picasso;

public class AddItem extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private Uri imageUri;

    Button addItem;
    Button attachImage;
    ProgressBar progressBar;
    EditText name;
    EditText subName;
    EditText description;
    ImageView attachImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        addItem = findViewById(R.id.add_recipe_button);
        attachImage = findViewById(R.id.attach_image_button);
        attachImageView = findViewById(R.id.attach_image);
        progressBar = findViewById(R.id.progressBar);
        name = findViewById(R.id.recipe_name);
        subName = findViewById(R.id.sub_name);
        description = findViewById(R.id.description);

        attachImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(), SingleItemView.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    //Old Method.
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageUri = data.getData();
            Picasso.with(this).load(imageUri).into(attachImageView);
        }
    }
}