package com.example.mustafa.dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    private static final int DIALOG_SAVE_CONFIRM=0;
    private static final int DIALOG_CHOOSE_ITEM=1;
    private static final int DIALOG_CHOOSE_ITEM_CHECKED=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnKaydet=(Button) findViewById(R.id.buttonKaydet);
        Button btnUrunSec=(Button) findViewById(R.id.buttonUrunSec);
        Button btnUrunSecCheck=(Button)findViewById(R.id.buttonUrunSecCheck);
        Button btnProgresDialog=(Button)findViewById(R.id.buttonProgress);

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_SAVE_CONFIRM);
            }
        });


       btnUrunSec.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showDialog(DIALOG_CHOOSE_ITEM);
           }
       });

        btnUrunSecCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_CHOOSE_ITEM_CHECKED);
            }
        });
        btnProgresDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog.show(AlertDialogActivity.this,"","İşleminiz Yürütülüyor.Lütfen bekleyiniz...",true,true);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        Dialog dialog;
                switch(id){
                    case DIALOG_SAVE_CONFIRM:
                        dialog=getSaveConfirmDialog();
                        break;
                    case DIALOG_CHOOSE_ITEM:
                        dialog=getChooseItemDialog();
                        break;
                    case DIALOG_CHOOSE_ITEM_CHECKED:
                        dialog=getChooseItemCheckedDialog();
                        break;
                    default:
                        dialog=null;
                }
        return  dialog;
    }
    private  Dialog getSaveConfirmDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Kaydetmek istediğinizden eminim misiniz ? ");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogActivity.this,"Kaydet Buttonunu Bastınız",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setCancelable(false);
        return builder.create();
    }
    private  Dialog getChooseItemDialog(){
        final CharSequence [] items={"Ayakkabı","Gömlek","Tişort","Pantolon"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Ürün Şeçin");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0)
                    Toast.makeText(AlertDialogActivity.this,"Ayakkabı",Toast.LENGTH_SHORT).show();
                if (which==1)
                    Toast.makeText(AlertDialogActivity.this,"Gömlek",Toast.LENGTH_SHORT).show();
                if (which==2)
                    Toast.makeText(AlertDialogActivity.this,"Tişort",Toast.LENGTH_SHORT).show();
                if (which==3)
                    Toast.makeText(AlertDialogActivity.this,"Pantolon",Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });
        return  builder.create();
    }
    private  Dialog getChooseItemCheckedDialog(){

        final CharSequence [] items={"Ayakkabı","Gömlek","Tişort","Pantolon"};

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("Ürün Seçin");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0)
                    Toast.makeText(AlertDialogActivity.this,"Ayakkabı",Toast.LENGTH_SHORT).show();
                if (which==1)
                    Toast.makeText(AlertDialogActivity.this,"Gömlek",Toast.LENGTH_SHORT).show();
                if (which==2)
                    Toast.makeText(AlertDialogActivity.this,"Tişort",Toast.LENGTH_SHORT).show();
                if (which==3)
                    Toast.makeText(AlertDialogActivity.this,"Pantolon",Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });
        return  builder.create();
    }
}
