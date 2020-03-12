package com.example.last;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static android.content.Context.MODE_PRIVATE;

public class BackgroundTask extends AsyncTask<String, Void, String> {
    AlertDialog dialog;
    Context ctx;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }


    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(ctx).create();
        dialog.setTitle("Login info...");
    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url = "https://founditlost.000webhostapp.com/includes/register.php";
        String log_url = "https://founditlost.000webhostapp.com/includes/login.php";
        final String method = params[0];
        String response = "";
        if (method.equals("register")) {
            String name = params[1];
            String email = params[2];
            String password = params[3];
            String phone = params[4];
            String img = params[5];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                OutputStream os = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")
                        + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
                        + "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8")
                        + "&"
                        + URLEncoder.encode("img", "UTF-8") + "=" + URLEncoder.encode(img, "UTF-8");
                writer.write(data);
                writer.flush();
                writer.close();
                os.close();
//                Response
                InputStream io = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(io, "iso-8859-1"));
                response = "";
                String line = "";
                while ((line = reader.readLine()) != null) {
                    response += line;
                }
                reader.close();
                io.close();
                connection.disconnect();
                final String response1 = response;
                return response1;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (method.equals("login")) {
                String email = params[1];
                String password = params[2];
                try {
                    URL login = new URL(log_url);
                    HttpURLConnection conn = (HttpURLConnection) login.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter write = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                            URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    write.write(data);
                    write.flush();
                    write.close();
                    os.close();

//                    Response
                    InputStream io = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(io, "iso-8859-1"));
                    response = "";
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        response += line;
                    }
                    reader.close();
                    io.close();
                    conn.disconnect();
                    return response;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }//If
        }//Else
        return response;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Log.e("result", result);
        Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
        String[] separated = result.split(":");
        SharedPreferences preferences = ctx.getSharedPreferences("info", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("remember", "true");
        editor.putString("lname", separated[2]);
        editor.putString("fname", separated[1]);
        editor.putString("email", separated[0]);
        editor.putString("phnoe", separated[3]);
        editor.commit();


    }


}
