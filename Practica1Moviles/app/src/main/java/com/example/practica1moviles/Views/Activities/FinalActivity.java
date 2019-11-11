package com.example.practica1moviles.Views.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.UserDBAccess;
import com.example.practica1moviles.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinalActivity extends AppCompatActivity {

    private User user ;
    private UserDBAccess dbAccess;


    ImageView userPicture;
    String mCurrentPhotoPath, currentUserName;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent mIntent = getIntent();


        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        mCurrentPhotoPath=storageDir.getAbsolutePath();

        userPicture = findViewById(R.id.userPicture);
        int puntuation = mIntent.getIntExtra("Puntuation", 0);

        this.dbAccess = UserDBAccess.get(this);
        String unametag = mIntent.getStringExtra("user");
        this.user = dbAccess.getUser(unametag);
        setPuntuation(puntuation);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String color = preferences.getString("color", "");
        if (!color.isEmpty())
            changeColor(color);

        String valor = findImage(user.getName());
        if (!valor.equals("No")) {
            int targetW = 200;
            int targetH = 200;

            // Get the dimensions of the bitmap
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;

            BitmapFactory.decodeFile(valor, bmOptions);
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;

            // Determine how much to scale down the image
            int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

            // Decode the image file into a Bitmap sized to fill the View
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;

            Bitmap bitmap = BitmapFactory.decodeFile(valor, bmOptions);
            userPicture.setImageBitmap(bitmap);
        }

        userPicture.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
             /*   Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 4);
                }*/
                dispatchTakePictureIntent(user.getName());

            }
        });
    }


    public void changeColor(String color) {
        View view1 = this.getWindow().getDecorView();
        switch (color) {
            case "Blanco":
                view1.setBackgroundColor(Color.WHITE);
                break;
            case "Rojo":
                view1.setBackgroundColor(Color.RED);
                break;
            case "Amarillo":
                view1.setBackgroundColor(Color.YELLOW);
                break;
            case "Verde":
                view1.setBackgroundColor(Color.GREEN);
                break;
            case "Azul":
                view1.setBackgroundColor(Color.BLUE);
                break;
            case "Negro":
                view1.setBackgroundColor(Color.BLACK);
                break;
        }
    }


    private void setPuntuation(int puntuation) {
        TextView dp_punt = findViewById(R.id.displayPunt);
        dp_punt.setText("" + puntuation);
    }

    public void exit(View view) {
        finish();
    }

    public void restart(View view) {
        Intent intent2 = new Intent(getApplicationContext(), GameActivity.class);
        intent2.putExtra("user", this.user.getNametag());
        startActivity(intent2);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 4 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            userPicture.setImageBitmap(imageBitmap);
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);

        String valor = findImage(user.getName());
        if (!valor.equals("No")) {
            int targetW = 200;
            int targetH = 200;

            // Get the dimensions of the bitmap
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;

            BitmapFactory.decodeFile(valor, bmOptions);
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;

            // Determine how much to scale down the image
            int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

            // Decode the image file into a Bitmap sized to fill the View
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;

            Bitmap bitmap = BitmapFactory.decodeFile(valor, bmOptions);
            userPicture.setImageBitmap(bitmap);
        }
    }


    private void dispatchTakePictureIntent(String nombre) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this, "¡No se ha podido guardar la imagen!", Toast.LENGTH_SHORT).show();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
        galleryAddPic();
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = user.getName();
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = storageDir.getPath();
        currentUserName = image.getName();
        return image;
    }

    private String findImage(String username) {
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
