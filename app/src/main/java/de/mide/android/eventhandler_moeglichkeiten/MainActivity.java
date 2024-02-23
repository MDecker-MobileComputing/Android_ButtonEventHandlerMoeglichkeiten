package de.mide.android.eventhandler_moeglichkeiten;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * Demo-App die mehrere Möglichkeiten zeigt, einen Event-Handler für einen Button zu definieren.
 * <br><br>
 * <b>Achtung:</b>
 * App läuft nur auf Geräten mit mindestens API-Level 14 (Android 4.0+), weil die Klasse
 * {@link android.widget.GridLayout} verwendet wird.
 * <br><br>
 *
 * Die Activity-Klasse selbst implementiert das Interface {@link android.view.View.OnClickListener},
 * was aber nur für Button 1 benötigt wird.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity implements OnClickListener

    /** In dieses UI-Element wird bei jedem Button-Event eine Zeile geschrieben. */
    protected TextView _textView = null;


    /**
     * Lifecycle-Methode. Lädt Layout-Datei und definiert Event-Handler für alle
     * Buttons (bis auf Button 5).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _textView = findViewById(R.id.textview_1);


        // Button 1: Activity-Objekt selbst als Event-Handler
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(this);


        // Button 2: Objekt einer anonymen Klasse als Event-Handler
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                _textView.append("Klick auf Button 2 (anonyme Klasse).\n");
            }
        });


        // Button 3: Objekt einer inneren Klasse als Event-Handler
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener( new MeineInnereKlasse() );

        // Button 4: Separate (externe) Klasse als Event-Handler
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener( new SeparateKlasse(_textView) );

        // Button 5: siehe Attribut in Layout-Datei android:onClick="meineMethode"
    }


    /**
     * Einzige Methode aus Interface {@link android.view.View.OnClickListener}
     * implementieren.
     */
    @Override
    public void onClick(View view) {

        _textView.append("Klick auf Button 1 (Activity-Klasse selbst).\n");
    }


    /**
     * Diese Methode wird in der Layout-Datei über das Attribut
     * <tt>android:onClick</tt> als Event-Handler-Methode zugeordnet.
     */
    public void meineMethode(View view) {

        _textView.append("Klick auf Button 5 (in Layout-Datei definiert).\n");
    }


    /* **************************************** */
    /* ********* Start Innere Klasse ********** */
    /* **************************************** */

    /**
     * Innere Klasse als Event-Handler für Button 3.
     * Die innere Klasse kann auch auf die Member-Variable der "äußeren Klasse"
     * (also die Klasse, in die sie eingebettet ist, hier: MainActivity) zugreifen.
     */
    class MeineInnereKlasse implements OnClickListener {

        /**
         * Einzige Methode aus Interface {@link android.view.View.OnClickListener}
         * implementieren.
         */
        @Override
        public void onClick(View view) {

            _textView.append("Klick auf Button 3 (innere Klasse).\n");
        }

    };
    /* **************************************** */
    /* ********* Ende Innere Klasse *********** */
    /* **************************************** */
}
