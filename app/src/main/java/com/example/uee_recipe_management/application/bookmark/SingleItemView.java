package com.example.uee_recipe_management.application.bookmark;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.uee_recipe_management.application.R;
import com.smarteist.autoimageslider.SliderView;


public class SingleItemView extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_view);


    }
}