package lat.pam.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra("id", -1);

        FoodData data = new FoodData(getApplicationContext());
        Food food = data.readById(id);

        if (food != null) {
            TextView judulTV = findViewById(R.id.detail_judul);
            TextView hargaTV = findViewById(R.id.detail_harga);
            TextView deskripsiTV = findViewById(R.id.detail_deskripsi);
            ImageView image = findViewById(R.id.detail_photo);

            String PACKAGE_NAME = getPackageName();
            int imageResource = getResources().getIdentifier("@drawable/" + food.image, null, PACKAGE_NAME);
            image.setImageDrawable(getResources().getDrawable(imageResource));

            judulTV.setText(food.judul);
            hargaTV.setText(String.valueOf(food.harga));
            deskripsiTV.setText(food.deskripsi);
        }
    }
}