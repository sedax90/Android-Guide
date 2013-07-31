package com.example.downloadimagefromurltutorial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;


import org.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTask<Void, String, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
            try{
                downloadImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXqmIlCRXRnHnQOFoXDerXwlQSiqb_-DLpS8pdmnDoEht01unUyA");
            }
            catch (IOException e){
            }
            return null;
            }
        }.execute();

    }


    public void downloadImage(String path) throws IOException{
        //creiamo un'istanza per il nostro url
        URL url = new URL(path);
        //Definiamo il percorso in cui si andrà a salvare il file e il suo nome
        String fileName = "/data/data/com.example.downloadimagefromurltutorial/test.jpg";
        File file = new File(fileName);

        //Monitoriamo il tempo che impiegherà il nostro download registrando il tempo attuale
        long startTime = System.currentTimeMillis();
        Log.d("Tutorial", "Begin Download URL: " + url + " Filename: " + fileName);

        //apriamo un nuova connessione
        URLConnection connection = url.openConnection();
        //otteniamo lo streaming dati in ingresso
        InputStream inputStream = connection.getInputStream();
        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        //misuriamo la grandezza dello streaming
        int contentLenght = connection.getContentLength();
        //settiamo il buffer in base alla lunghezza
        ByteArrayBuffer byteBuffer = new ByteArrayBuffer(contentLenght);

        //Leggiamo ogni singolo byte finchè non verrà restituito -1 (file completo)
        int current = 0;
        while((current = buffer.read()) != -1){
            byteBuffer.append((byte) current);
            Log.d("Tutorial", byteBuffer.toString()); //visualizza a log ogni singolo cambiamento del byteBuffer
        }

        //prepariamo il file finale
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteBuffer.toByteArray());

        fileOutputStream.close();

        //vediamo in quanto tempo è stato scaricato
        Log.d("Tutorial", "File was downloaded in: " + ((System.currentTimeMillis() - startTime) / 1000) + "s");
    }
}























