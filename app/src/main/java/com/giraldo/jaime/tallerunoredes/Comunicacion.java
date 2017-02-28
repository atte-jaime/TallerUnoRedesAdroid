package com.giraldo.jaime.tallerunoredes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by jaime on 27/02/2017.
 */

public class Comunicacion implements Runnable {
    private static Comunicacion ref;
    public static final String android = "10.0.2.2";
    public static final int PORT = 6000;
    private DatagramSocket s;


    private Comunicacion() {
        try {
            s = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {

        }
    }

    public static Comunicacion instancia() {
        if (ref == null) {
            ref = new Comunicacion();
            new Thread(ref).start();
        }
        return ref;
    }


    public void enviar(final byte[] pack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (s != null) {
                    try {
                        InetAddress ipEnvio = null;
                        ipEnvio = InetAddress.getByName("172.30.161.23");
                        DatagramPacket paqueteEnviar = new DatagramPacket(pack, pack.length, ipEnvio, PORT);
                        s.send(paqueteEnviar);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}



