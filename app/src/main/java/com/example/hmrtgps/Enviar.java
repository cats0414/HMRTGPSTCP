package com.example.hmrtgps;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Enviar extends AsyncTask<String, Void, Void> {

        Socket s;
        DataOutputStream dt;
        PrintWriter pw;
        //String mensaje=new MainActivity().message.toString();
        @Override
        protected Void doInBackground(String... strings) {

            try {
                s= new Socket("192.168.43.145",5000);
                pw= new PrintWriter(s.getOutputStream());
                pw.write("Hola Dios, soy yo de nuevo");
                pw.flush();
                pw.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
