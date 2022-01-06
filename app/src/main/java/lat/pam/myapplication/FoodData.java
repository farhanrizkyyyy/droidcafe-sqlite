package lat.pam.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class FoodData extends SQLiteOpenHelper {
    private static final String DB_NAME = "droidCafe";
    private static final int DB_VERSION = 1;
    private static final String TABLE_MENUS = "menus";

    public FoodData(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_MENUS +" (id INTEGER PRIMARY KEY NOT NULL, judul STRING NOT NULL, deskripsi STRING NOT NULL, harga INTEGER NOT NULL, image STRING NOT NULL)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MENUS);
        onCreate(sqLiteDatabase);
    }

    public void dataInitial() {
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food(1,"Batagor", "Baso tahu goreng", 10000, "batagor"));
        list.add(new Food(2,"Cheesecake", "Bahasa gayanya bolu keju", 8650, "cheesecake"));
        list.add(new Food(3,"Cappuchino", "Kapucino cingcau", 7200, "cappuchino"));
        list.add(new Food(4,"Black Salad", "Salad blek", 6400, "black_salad"));
        list.add(new Food(5,"Cireng Pedas", "Aci goreng lada", 17000, "cireng"));
        list.add(new Food(6,"Donut", "Bahasa inggrisnya: 'Doughnut'", 900, "donut"));
        list.add(new Food(7,"Mie Goreng", "Bahan dasarnya indomie atau mie burung dara, bukan bihun kaca", 12500, "mie_goreng"));
        for (Food food : list) {
            insert(food);
        }
    }

    public void insert(Food food) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", food.id);
        contentValues.put("judul", food.judul);
        contentValues.put("deskripsi", food.deskripsi);
        contentValues.put("harga", food.harga);
        contentValues.put("image", food.image);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_MENUS, null, contentValues);
        db.close();
    }

    public ArrayList<Food> read() {
        String sql = "SELECT * FROM " + TABLE_MENUS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery(sql, null);

        ArrayList<Food> list = new ArrayList<>();
        while (result.moveToNext()) {
            list.add(new Food(result.getInt(0), result.getString(1), result.getString(2), result.getInt(3), result.getString(4)));
        }
        result.close();
        return list;
    }

    public Food readById(int id) {
        String sql = "SELECT * FROM " + TABLE_MENUS + " WHERE id = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery(sql, null);

        Food food = null;
        if (result.moveToFirst()) {
            food = new Food(result.getInt(0), result.getString(1), result.getString(2), result.getInt(3), result.getString(4));
        }
        result.close();
        return food;
    }
}