package lat.pam.myapplication;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;

import java.io.File;

public class Food {
    int id;
    String judul;
    String deskripsi;
    int harga;
    String image;

    Food(int id, String judul, String deskripsi, int harga, String image) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.image = image;
    }
}