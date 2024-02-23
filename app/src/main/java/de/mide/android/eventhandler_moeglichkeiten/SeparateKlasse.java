package de.mide.android.eventhandler_moeglichkeiten;


import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;


/**
 * Separate Klasse, von der ein Objekt als Event-Handler
 * für Button 4 verwendet wird. Diese Klasse muss nicht
 * in der Manifest-Datei deklariert werden, da es sich hierbei
 * um keine Activity-Klasse handelt.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class SeparateKlasse implements OnClickListener {

    /** Referenz auf TextView-Element muss im Konstruktor übergeben werden. */
    protected TextView _textView = null;


    /**
     * Konstruktor zur Übergabe von Referenz auf TextView-Element.
     * <br/>
     * Diese Klasse ist keine Unterklasse von Activity und kann deshalb
     * auch nicht die Methode {@link android.app.Activity#findViewById(int)}
     * verwenden, um diese Referenz anhand der entsprechenden Konstante aus
     * der Datei <tt>R.java</tt> selbst abzufragen.
     */
    public SeparateKlasse(TextView textView) {

        _textView = textView;
    }


    /**
     * Einzige Methode aus Interface {@link android.view.View.OnClickListener}
     * implementieren.
     */
    @Override
    public void onClick(View view) {

        _textView.append("Klick auf Button 4 (separate Klasse).\n");
    }

}
