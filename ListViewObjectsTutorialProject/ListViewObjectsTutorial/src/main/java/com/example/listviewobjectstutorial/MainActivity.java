package com.example.listviewobjectstutorial;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identifichiamo la lista nel layout principale
        ListView lista = (ListView) findViewById(R.id.lista);
        //ottengo i dati tramite un metodo
        Cms[] objectsArray = getObjects();
        //assegno il mio custom adapter
        final ObjectAdapter adapter = new ObjectAdapter(this, R.layout.riga_lista, objectsArray);
        //assegno l'adapter alla listView
        lista.setAdapter(adapter);
        //assegno un'azione al click
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cms cms = adapter.getItem(i);
                Toast.makeText(getBaseContext(), Integer.toString(cms.getId()), Toast.LENGTH_SHORT).show();
            }
        });
        //assegno un'azione al long click
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cms cms = adapter.getItem(i);
                Toast.makeText(getBaseContext(), cms.getSmall(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    //metodo per il popolamento dell'array di oggetti necessario ai test
    public Cms[] getObjects(){
        //creazione dell'array di test
        Cms[] array = new Cms[3];
        array[0] = new Cms("Drupal", "The best cms in the world", 100);
        array[1] = new Cms("Joomla", "Lol, is really a cms?", 101);
        array[2] = new Cms("Wordpress", "Ok if you need a blog...", 102);

        return array;
    }
    
}
















