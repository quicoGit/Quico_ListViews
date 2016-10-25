package com.plumbaria.listviews;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    private TextView selection;
    private static final String[] items = {"En", "un", "lugar", "de",
            "la", "Mancha", "de", "cuyo", "nombre", "no", "quiero",
            "acordarme", "no", "ha", "mucho", "tiempo", "que",
            "vivía", "un", "hidalgo", "de", "los", "de", "lanza",
            "en", "astillero", "adarga", "antigua", "rocín", "flaco",
            "y", "galgo", "corredor"};
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_multiple_choice,
                        items);
        setListAdapter(arrayAdapter);
        selection = (TextView)
                findViewById(R.id.elemento_seleccionado);
    }
    @Override
    public void onListItemClick(ListView parent, View v, int position,
                                long id) {
 //       selection.setText(items[position]);
        SparseBooleanArray marcados = parent.getCheckedItemPositions();
        StringBuilder elementos = new StringBuilder();
        if (marcados != null) {
            for (int i = 0; i < marcados.size(); i++) {
                if (marcados.valueAt(i)) {
// valueAt(i) valdrá true si el ítem está marcado
                    elementos.append(items[marcados.keyAt(i)]);
// keyAt(i) nos devuelve la posición del elemento
                    elementos.append(" + ");
                }
            }
            elementos.delete(elementos.lastIndexOf(" + "),elementos.length()-1);
        }
        selection.setText(elementos.toString());
    }
}