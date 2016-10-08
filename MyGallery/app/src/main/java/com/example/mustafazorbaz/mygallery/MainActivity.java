package com.example.mustafazorbaz.mygallery;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;

public class MainActivity extends Activity {

    private static int RESULT_LOAD_IMAGE = 1;
    private  String picturePath;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get button instance
        Button buttonLoadImage = (Button) findViewById(R.id.btnLoadPicture);
        //set button onlick listener
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Resim seçmek için intent oluşturduk galerimizden seçim yaptık.
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE); //Activiteyi başlatıyoruz ve image'i yüklüyoruz
            }
        });

        Button buttonShare= (Button) findViewById(R.id.buttonShare);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Burada ise seçimiş resmin yolunu instagrama eklemek için  metoda gönderdik.
                String mediaPath = picturePath;
                createInstagramIntent(mediaPath);

            }
        });
    }
    //Bu metodumuz instagramda image paylaşmak için
    private void createInstagramIntent(String imagePath){
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android"); //get package
        if (intent != null) //control for intent
        {
            //Bir intent oluşturduk ve instagram uygulammız için paketimizi ekledik.
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setPackage("com.instagram.android");
            try {
                //Resmin yolunu koyduk.
                shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse
                (MediaStore.Images.Media.insertImage(getContentResolver(), imagePath, "I am Happy", "Share happy !")));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            shareIntent.setType("image/jpeg");

            startActivity(shareIntent);
        }
        else
        {
      //uygulama yüklemek için ilgili işlevleri oluşturduk.
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id="+"com.instagram.android"));
            startActivity(intent);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//Aktivite sonuçlandığı zaman
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImg = data.getData(); // Şartlar doğrultusunda resmi çekiyoruz.

            String[] filePathColumn = { MediaStore.Images.Media.DATA }; //Resmin yolunu elde ettikten sonra

            Cursor cursor = getContentResolver().query(selectedImg, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            //get imageview instance
            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            // Set the Image in ImageView after decoding the String
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        } else {
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }

    }
}