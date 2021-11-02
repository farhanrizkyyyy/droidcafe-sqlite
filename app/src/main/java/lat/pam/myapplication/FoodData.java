package lat.pam.myapplication;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class FoodData {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static ArrayList<Food> getData(Context context) {
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food("Batagor", "temennya baso tahu", 10000, context.getDrawable(R.drawable.batagor)));
        list.add(new Food("Cheesecake", "keju tapi ga enek", 8650, context.getDrawable(R.drawable.cheesecake)));
        list.add(new Food("Cappuchino", "kopi obat ngantuk", 7200, context.getDrawable(R.drawable.cappuchino)));
        list.add(new Food("Black Salad", "buah buahan hitam", 6400, context.getDrawable(R.drawable.black_salad)));
        list.add(new Food("Cireng Pedas", "Cireng isi Cinta", 17000, context.getDrawable(R.drawable.cireng)));
        list.add(new Food("Donut", "terbuat dari sampeu", 900, context.getDrawable(R.drawable.donut)));
        list.add(new Food("Mie Goreng", "sebenernya sih indomie goreng", 12500, context.getDrawable(R.drawable.mie_goreng)));



        return list;
    }
}