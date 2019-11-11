package com.example.practica1moviles.Models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practica1moviles.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RankingAdapter extends ArrayAdapter<User> {

    private ArrayList<User> users;
    private Context context;

    public RankingAdapter(@NonNull Context context, List<User> users) {
        super(context, -1, users);
        this.users = (ArrayList<User>) users;
        this.context = context;


    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup parent) {


        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.ranking_view, parent, false);
            ImageView userLogo = view.findViewById(R.id.userLogo);
            TextView nameLabel = view.findViewById(R.id.ItemName);
            TextView scoreLabel = view.findViewById(R.id.ItemScore);

            nameLabel.setText("Nombre: " + this.users.get(position).getNametag());
            scoreLabel.setText("Puntuación: " + this.users.get(position).getPuntuacion());

            String valor=findImage(this.users.get(position).getName());
            if(!valor.equals("No")){
                int targetW = 200;
                int targetH = 200;

                // Get the dimensions of the bitmap
                BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                bmOptions.inJustDecodeBounds = true;

                BitmapFactory.decodeFile(valor, bmOptions);
                int photoW = bmOptions.outWidth;
                int photoH = bmOptions.outHeight;

                // Determine how much to scale down the image
                int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

                // Decode the image file into a Bitmap sized to fill the View
                bmOptions.inJustDecodeBounds = false;
                bmOptions.inSampleSize = scaleFactor;
                bmOptions.inPurgeable = true;

                Bitmap bitmap = BitmapFactory.decodeFile(valor, bmOptions);
                userLogo.setImageBitmap(bitmap);
            }

        }
        return view;
    }

    private String findImage(String username) {
        File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String mCurrentPhotoPath = storageDir.getAbsolutePath();

        String path = mCurrentPhotoPath + File.separator;
        System.out.println(path);
        File f = new File(path);
        //obtiene nombres de archivos dentro del directorio.
        File file[] = f.listFiles();
        if (file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                if (file[i].getName().contains(username)) {
                    return file[i].getAbsolutePath();
                }
            }
        }
        return "No";
    }


}
