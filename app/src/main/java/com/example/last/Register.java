package com.example.last;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.util.UUID;

public class Register extends AppCompatActivity {
    //Variables
    Button register, loginbk, profpic;
    TextInputEditText fname, lname, phone, cfmpass, email, pasd;
    private  Uri filepath;

    ProgressDialog pd;
    public static final String URL = "https://founditlost.000webhostapp.com/includes/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);


        if (globalconst.user != null) {
            Intent intent = new Intent(Register.this, Dashboard.class);
            startActivity(intent);
            finish();

        }

        email = findViewById(R.id.regem);
        fname = findViewById(R.id.fname1);
        lname = findViewById(R.id.lname1);
        phone = findViewById(R.id.tell1);
        pasd = findViewById(R.id.regpp);
        cfmpass = findViewById(R.id.regconf);
        register = findViewById(R.id.registerbtn);
        profpic = findViewById(R.id.uploadimg);
        loginbk = findViewById(R.id.bklogin);
        pd = new ProgressDialog(Register.this);


        loginbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                Toast.makeText(Register.this, "Clicked",
                        Toast.LENGTH_SHORT).show();


            }
        });
        checkPermissions();

        profpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               picker();


            }

        });


    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                ContextCompat.checkSelfPermission(Register.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Register.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);


        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void picker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && data != null && data.getData() != null) {

            filepath = data.getData();

        }
    }

    private String getPath(Uri uri) {

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Images.Media._ID + "=?", new String[]{document_id}, null
        );
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();
        return path;
    }



    private Boolean validateEmail() {
        String mail = email.getText().toString();
        String mailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (mail.isEmpty()) {
            email.setError("Field is required");
            return false;
        } else if (!mail.matches(mailPattern)) {
            email.setError("Invalid Email");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String passw = pasd.getText().toString();
        String cpassw = cfmpass.getText().toString();
        pasd.setError(null);
        cfmpass.setError(null);
        if (passw == cpassw) {

            if (passw.isEmpty() && cpassw.isEmpty()) {

                pasd.setError("Field is required");
                cfmpass.setError("Field is required");
                return false;
            } else if (passw.isEmpty()) {
                pasd.setError("Field is required");
                return false;
            } else if (cpassw.isEmpty()) {
                cfmpass.setError("Field is required");
                return false;
            } else
                pasd.setError(null);
            cfmpass.setError(null);
            return true;
        } else {
            return false;
        }
    }


    public void registerUser(View view) {
        String namestr = fname.getText().toString();
        String lnamestr = lname.getText().toString();
        String emailstr = email.getText().toString();
        String passstr = pasd.getText().toString();
        String tellno = phone.getText().toString();
        String path = getPath(filepath);
        String method = "register";
        BackgroundTask backt = new BackgroundTask(this);
//        Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
//        backt.execute(method, namestr, emailstr, passstr, tellno,path);
        try{
            String upid = UUID.randomUUID().toString();
            new MultipartUploadRequest(this, upid,URL)
                    .addFileToUpload(path,"img")
                    .addParameter("name",namestr)
                    .addParameter("lname",lnamestr)
                    .addParameter("password",passstr)
                    .addParameter("email",emailstr)
                    .addParameter("phone",tellno)
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(3)
                    .startUpload();
        }
        catch (Exception ex){

        }
        Handler deel = new Handler();
        Runnable runer = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        };
        deel.postDelayed(runer,1000);


//        finish();


    }


}
