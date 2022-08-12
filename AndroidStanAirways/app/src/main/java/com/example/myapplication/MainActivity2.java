package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private final int any = 1000;
    ImageView picupload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button nextbtn = findViewById(R.id.btnNext);
        EditText agetxt = findViewById(R.id.txtogage);
        EditText nametxt = findViewById(R.id.txtogname);
        EditText destinationtxt = findViewById(R.id.txtogdis);
         picupload = findViewById(R.id.uploadpic);
        Button btnupload = findViewById(R.id.btnphoto);




        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uppic = new Intent(Intent.ACTION_PICK);
                uppic.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(uppic, any);
            }
        });



        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(agetxt.getText().toString().equals("")){
                    Toast.makeText(MainActivity2.this, "تأكد من ملئ الفراغات", Toast.LENGTH_SHORT).show();
                }
                else if(nametxt.getText().toString().equals("")){
                    Toast.makeText(MainActivity2.this, "تأكد من ملئ الفراغات", Toast.LENGTH_SHORT).show();
                }
                else if(destinationtxt.getText().toString().equals("")){
                    Toast.makeText(MainActivity2.this, "تأكد من ملئ الفراغات", Toast.LENGTH_SHORT).show();
                }
                else if(destinationtxt.getText().toString().equals("applestan")){
                    Toast.makeText(MainActivity2.this, "ممكن تنحذف من الطيارة راجع ولائك", Toast.LENGTH_LONG).show();
                }


                else{

                String clintname = nametxt.getText().toString();
                int clintage = Integer.parseInt(agetxt.getText().toString());
                String clintddes = destinationtxt.getText().toString();
                Intent androidstan = new Intent(MainActivity2.this, MainActivity3.class );


                androidstan.putExtra("name", clintname);
                androidstan.putExtra("age", clintage);
                androidstan.putExtra("des", clintddes);

                startActivity(androidstan); }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if (resultCode==any){
                picupload.setImageURI(data.getData());


            }
        }
    }
}