package com.example.hmrtgps;

import android.os.AsyncTask;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import static com.example.hmrtgps.MainActivity.message;
import static com.example.hmrtgps.MainActivity.ip;
public class Enviar extends AsyncTask<String, Void, Void> {
    Socket s;
    DataOutputStream dt;
    PrintWriter pw;
    @Override
    protected Void doInBackground(String... strings) {
        try {
            s= new Socket(ip,5000);
            pw= new PrintWriter(s.getOutputStream());
            pw.write(message);
            pw.flush();
            pw.close();
            s.close();
            } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
