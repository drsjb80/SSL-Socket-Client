package edu.msudenver;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

/**
 * @author Joe Prasanna Kumar
 */

public class SSLSocketClient {
    public static void main(String[] args) throws IOException {
        String strServerName = "localhost";
        int intSSLport = 853;

        System.setProperty("javax.net.ssl.trustStore", "/tmp/testkeystore.ks");
        System.setProperty("javax.net.ssl.trustStorePassword","testpwd");

        SSLSocketFactory sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket)sslsocketfactory.createSocket(strServerName,intSSLport);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sslSocket.getOutputStream()));

        out.write("Hello World!\n");
        out.flush();
        String receieved = in.readLine();
        System.out.println("RECEIVED: " + receieved);

        out.close();
        in.close();
        sslSocket.close();
    }
}