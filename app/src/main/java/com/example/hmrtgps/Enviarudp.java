package com.example.hmrtgps;

import android.os.AsyncTask;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.io.DataOutputStream;
import static com.example.hmrtgps.MainActivity.ip;
import static com.example.hmrtgps.MainActivity.message;

public class Enviarudp extends AsyncTask<String, Void, Void> {
    DatagramSocket med;

    PrintWriter pw;
    @Override
    protected Void doInBackground(String... strings) {
        try {
            med= new DatagramSocket();
            byte[] mensaje = message.getBytes();
            int puerto = 12340;
            InetAddress IPA = InetAddress.getByName("192.168.42.24");
            DatagramPacket packet = new DatagramPacket(mensaje,mensaje.length,IPA,3659);
            med.send(packet);


            pw.flush();
            pw.close();
            med.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
