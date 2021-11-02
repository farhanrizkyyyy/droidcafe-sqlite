package lat.pam.myapplication;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;

import java.io.File;

public class Food {
    String judul;
    String deskripsi;
    int harga;
    Drawable image;

    Food(String judul, String deskripsi, int harga, Drawable image) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.image = image;
    }
}