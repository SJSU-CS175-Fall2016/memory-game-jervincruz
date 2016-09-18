package jervincruz.homework2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class play extends AppCompatActivity implements OnClickListener {
    TextView points;
    Button restart;
    ImageButton eevee1, eevee2, ditto1, ditto2, jigglypuff1, jigglypuff2, mew1, mew2, mewtwo1, mewtwo2,
    ninetales1, ninetales2, pikachu1, pikachu2, psyduck1, psyduck2, slowpoke1, slowpoke2, togepi1, togepi2;

    String firstPokemon, secondPokemon;
    ArrayList<String> matchedPokemon = new ArrayList<>();

    int pointCounter = 0;
    int clickCounter = 0;

    SharedPreferences sharedPreferences;

    private void savePreferences(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> matched = sharedPreferences.getStringSet("set", new HashSet<String>());

        for(int i = 0; i < matchedPokemon.size(); i++){
            matched.add(matchedPokemon.get(i));
        }

        editor.putStringSet("set", matched);

        editor.commit();
    }

    private void loadPreferences(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        Set<String> getSet = new HashSet<String>();

        for(int i = 0; i < matchedPokemon.size(); i++){
            getSet = sharedPreferences.getStringSet("set", null);
        }

        for(String a : getSet){
            flipOver(a);
        }
    }

    @Override
    public void onBackPressed(){
        savePreferences();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadPreferences();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);


        eevee1 = (ImageButton) findViewById(R.id.imageButton);
        eevee2 = (ImageButton) findViewById(R.id.imageButton20);
        ditto1 = (ImageButton) findViewById(R.id.imageButton2);
        ditto2 = (ImageButton) findViewById(R.id.imageButton19);
        jigglypuff1 = (ImageButton) findViewById(R.id.imageButton3);
        jigglypuff2 = (ImageButton) findViewById(R.id.imageButton18);
        mew1 = (ImageButton) findViewById(R.id.imageButton4);
        mew2 = (ImageButton) findViewById(R.id.imageButton17);
        mewtwo1 = (ImageButton) findViewById(R.id.imageButton5);
        mewtwo2 = (ImageButton) findViewById(R.id.imageButton16);
        ninetales1 = (ImageButton) findViewById(R.id.imageButton6);
        ninetales2 = (ImageButton) findViewById(R.id.imageButton15);
        pikachu1 = (ImageButton) findViewById(R.id.imageButton7);
        pikachu2 = (ImageButton) findViewById(R.id.imageButton14);
        psyduck1 = (ImageButton) findViewById(R.id.imageButton8);
        psyduck2 = (ImageButton) findViewById(R.id.imageButton13);
        slowpoke1 = (ImageButton) findViewById(R.id.imageButton9);
        slowpoke2 = (ImageButton) findViewById(R.id.imageButton12);
        togepi1 = (ImageButton) findViewById(R.id.imageButton10);
        togepi2 = (ImageButton) findViewById(R.id.imageButton11);
        restart = (Button) findViewById(R.id.button3);

        eevee1.setOnClickListener(this);
        eevee2.setOnClickListener(this);
        ditto1.setOnClickListener(this);
        ditto2.setOnClickListener(this);
        jigglypuff1.setOnClickListener(this);
        jigglypuff2.setOnClickListener(this);
        mew1.setOnClickListener(this);
        mew2.setOnClickListener(this);
        mewtwo1.setOnClickListener(this);
        mewtwo2.setOnClickListener(this);
        ninetales1.setOnClickListener(this);
        ninetales2.setOnClickListener(this);
        pikachu1.setOnClickListener(this);
        pikachu2.setOnClickListener(this);
        psyduck1.setOnClickListener(this);
        psyduck2.setOnClickListener(this);
        slowpoke1.setOnClickListener(this);
        slowpoke2.setOnClickListener(this);
        togepi1.setOnClickListener(this);
        togepi2.setOnClickListener(this);
        restart.setOnClickListener(this);


        points = (TextView) findViewById(R.id.textView3);

        loadPreferences();
     }

    public void onClick(View v) {
        switch (v.getId()) {
            /* Eevee1 */
            case R.id.imageButton:
                clickCounter++;
                if (clickCounter == 1) {
                    firstPokemon = "eevee1";
                    eevee1.setImageResource(R.drawable.eevee);
                    break;
                } else if(clickCounter == 2) {
                    secondPokemon = "eevee1";
                    eevee1.setImageResource(R.drawable.eevee);
                    isMatch(firstPokemon, secondPokemon);
                    break;
                }
                break;
            /* Eevee2 */
            case R.id.imageButton20:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "eevee2";
                    eevee2.setImageResource(R.drawable.eevee);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "eevee2";
                    eevee2.setImageResource(R.drawable.eevee);
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
            /* Ditto1 */
            case R.id.imageButton2:
                clickCounter++;
                if (clickCounter == 1) {
                    firstPokemon = "ditto1";
                    ditto1.setImageResource(R.drawable.ditto);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "ditto1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
            /* Ditto2 */

            case R.id.imageButton19:
                clickCounter++;
                if (clickCounter == 1) {
                    firstPokemon = "ditto2";
                    ditto2.setImageResource(R.drawable.ditto);
                    break;
                }
                else if(clickCounter == 2) {
                    secondPokemon = "ditto2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
            /* Jigglypuff1 */
            case R.id.imageButton3:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "jigglypuff1";
                    jigglypuff1.setImageResource(R.drawable.jigglypuff);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "jigglypuff1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* Jigglypuff2 */
            case R.id.imageButton18:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "jigglypuff2";
                    jigglypuff2.setImageResource(R.drawable.jigglypuff);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "jigglypuff2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* mew1 */
            case R.id.imageButton4:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "mew1";
                    mew1.setImageResource(R.drawable.mew);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "mew1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* mew2 */
            case R.id.imageButton17:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "mew2";
                    jigglypuff2.setImageResource(R.drawable.mew);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "mew2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* mewtwo1 */
            case R.id.imageButton5:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "mewtwo1";
                    mewtwo1.setImageResource(R.drawable.mewtwo);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "mewtwo1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* mewtwo2 */
            case R.id.imageButton16:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "mewtwo2";
                    mewtwo2.setImageResource(R.drawable.mewtwo);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "mewtwo2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* ninetales1 */
            case R.id.imageButton6:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "ninetales1";
                    ninetales1.setImageResource(R.drawable.ninetales);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "ninetales1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* ninetales2 */
            case R.id.imageButton15:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "ninetales2";
                    ninetales2.setImageResource(R.drawable.ninetales);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "ninetales2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* pikachu1 */
            case R.id.imageButton7:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "pikachu1";
                    pikachu1.setImageResource(R.drawable.pikachu);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "pikachu1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* pikachu2 */
            case R.id.imageButton14:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "pikachu2";
                    pikachu2.setImageResource(R.drawable.pikachu);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "pikachu2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* psyduck1 */
            case R.id.imageButton8:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "psyduck1";
                    psyduck1.setImageResource(R.drawable.psyduck);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "psyduck1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* psyduck2 */
            case R.id.imageButton13:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "psyduck2";
                    psyduck2.setImageResource(R.drawable.psyduck);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "psyduck2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* slowpoke1 */
            case R.id.imageButton9:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "slowpoke1";
                    slowpoke1.setImageResource(R.drawable.slowpoke);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "slowpoke1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* slowpoke2 */
            case R.id.imageButton12:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "slowpoke2";
                    slowpoke2.setImageResource(R.drawable.slowpoke);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "slowpoke2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* togepi1 */
            case R.id.imageButton10:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "togepi1";
                    togepi1.setImageResource(R.drawable.togepi);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "togepi1";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* togepi2 */
            case R.id.imageButton11:
                clickCounter++;
                if(clickCounter == 1){
                    firstPokemon = "togepi2";
                    togepi2.setImageResource(R.drawable.togepi);
                    break;
                }
                else if(clickCounter == 2){
                    secondPokemon = "togepi2";
                    isMatch(firstPokemon, secondPokemon);
                    clickCounter = 0;
                    break;
                }
                /* Restart Game */
            case R.id.button3:
                /* Make imageButtons visible again then make it transparent (turn it over) */
                eevee1.setVisibility(View.VISIBLE);
                eevee2.setVisibility(View.VISIBLE);
                ditto1.setVisibility(View.VISIBLE);
                ditto2.setVisibility(View.VISIBLE);
                jigglypuff1.setVisibility(View.VISIBLE);
                jigglypuff2.setVisibility(View.VISIBLE);
                mew1.setVisibility(View.VISIBLE);
                mew2.setVisibility(View.VISIBLE);
                mewtwo1.setVisibility(View.VISIBLE);
                mewtwo2.setVisibility(View.VISIBLE);
                ninetales1.setVisibility(View.VISIBLE);
                ninetales2.setVisibility(View.VISIBLE);
                pikachu1.setVisibility(View.VISIBLE);
                pikachu2.setVisibility(View.VISIBLE);
                psyduck1.setVisibility(View.VISIBLE);
                psyduck2.setVisibility(View.VISIBLE);
                slowpoke1.setVisibility(View.VISIBLE);
                slowpoke2.setVisibility(View.VISIBLE);
                togepi1.setVisibility(View.VISIBLE);
                togepi2.setVisibility(View.VISIBLE);

                eevee1.setImageResource(android.R.color.transparent);
                eevee2.setImageResource(android.R.color.transparent);
                ditto1.setImageResource(android.R.color.transparent);
                ditto2.setImageResource(android.R.color.transparent);
                jigglypuff1.setImageResource(android.R.color.transparent);
                jigglypuff2.setImageResource(android.R.color.transparent);
                mew1.setImageResource(android.R.color.transparent);
                mew2.setImageResource(android.R.color.transparent);
                mewtwo1.setImageResource(android.R.color.transparent);
                mewtwo2.setImageResource(android.R.color.transparent);
                ninetales1.setImageResource(android.R.color.transparent);
                ninetales2.setImageResource(android.R.color.transparent);
                pikachu1.setImageResource(android.R.color.transparent);
                pikachu2.setImageResource(android.R.color.transparent);
                psyduck1.setImageResource(android.R.color.transparent);
                psyduck2.setImageResource(android.R.color.transparent);
                slowpoke1.setImageResource(android.R.color.transparent);
                slowpoke2.setImageResource(android.R.color.transparent);
                togepi1.setImageResource(android.R.color.transparent);
                togepi2.setImageResource(android.R.color.transparent);

                pointCounter = 0;
                points.setText("0");
                break;
        }



        }

            public void isMatch(String firstPokemon, String secondPokemon){
                // SECOND CLICKS ONLY

                // Eevee
                if((firstPokemon == "eevee1" && secondPokemon == "eevee2") || (firstPokemon == "eevee2" && secondPokemon == "eevee1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    eevee1.setVisibility(View.INVISIBLE);
                    eevee2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;
                    matchedPokemon.add(firstPokemon);
                    matchedPokemon.add(secondPokemon);
                }
                // Ditto
                else if((firstPokemon == "ditto1" && secondPokemon == "ditto2") || (firstPokemon == "ditto2" && secondPokemon == "ditto1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    ditto1.setVisibility(View.INVISIBLE);
                    ditto2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Jigglypuff
                else if((firstPokemon == "jigglypuff1" && secondPokemon == "jigglypuff2") || (firstPokemon == "jigglypuff2" && secondPokemon == "jigglypuff1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    jigglypuff1.setVisibility(View.INVISIBLE);
                    jigglypuff2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Mew
                else if((firstPokemon == "mew1" && secondPokemon == "mew2") || (firstPokemon == "mew2" && secondPokemon == "mew1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    mew1.setVisibility(View.INVISIBLE);
                    mew2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Mewtwo
                else if((firstPokemon == "mewtwo1" && secondPokemon == "mewtwo2") || (firstPokemon == "mewtwo2" && secondPokemon == "mewtwo1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    mewtwo1.setVisibility(View.INVISIBLE);
                    mewtwo2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Ninetales
                else if((firstPokemon == "ninetales1" && secondPokemon == "ninetales2") || (firstPokemon == "ninetales2" && secondPokemon == "ninetales1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    ninetales1.setVisibility(View.INVISIBLE);
                    ninetales2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Pikachu
                else if((firstPokemon == "pikachu1" && secondPokemon == "pikachu2") || (firstPokemon == "pikachu2" && secondPokemon == "pikachu1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    pikachu1.setVisibility(View.INVISIBLE);
                    pikachu2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Psyduck
                else if((firstPokemon == "psyduck1" && secondPokemon == "psyduck2") || (firstPokemon == "psyduck2" && secondPokemon == "psyduck1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    psyduck1.setVisibility(View.INVISIBLE);
                    psyduck2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Slowpoke
                else if((firstPokemon == "slowpoke1" && secondPokemon == "slowpoke2") || (firstPokemon == "slowpoke2" && secondPokemon == "slowpoke1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    slowpoke1.setVisibility(View.INVISIBLE);
                    slowpoke2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Togepi
                else if((firstPokemon == "togepi1" && secondPokemon == "togepi2") || (firstPokemon == "togepi2" && secondPokemon == "togepi1")){
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    togepi1.setVisibility(View.INVISIBLE);
                    togepi2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                else{ // hide unmatched pokemon
                    hidePokemon(firstPokemon, secondPokemon);
                }

            }

        // Flip both pokemon if they're not a match
        public void hidePokemon(String firstPokemon, String secondPokemon){
            if(firstPokemon == "eevee1" || secondPokemon == "eevee1"){
                eevee1.setImageResource(android.R.color.transparent);
            }
            if(firstPokemon == "eevee2" || secondPokemon == "eevee2"){
                eevee2.setImageResource(android.R.color.transparent);
            }
            if(firstPokemon == "ditto1" || secondPokemon == "ditto1"){
                ditto1.setImageResource(android.R.color.transparent);
            }
            if(firstPokemon == "ditto2" || secondPokemon == "ditto2"){
                ditto2.setImageResource(android.R.color.transparent);
            }
        }



    // Save pokemon
    public void flipOver(String firstPokemon){
        if(firstPokemon == "eevee1" || secondPokemon == "eevee1"){
            eevee1.setVisibility(View.INVISIBLE);
        }
        if(firstPokemon == "eevee2" || secondPokemon == "eevee2"){
            eevee2.setVisibility(View.INVISIBLE);
        }
        if(firstPokemon == "ditto1" || secondPokemon == "ditto1"){
            ditto1.setVisibility(View.INVISIBLE);
        }
        if(firstPokemon == "ditto2" || secondPokemon == "ditto2"){
            ditto2.setVisibility(View.INVISIBLE);
        }
    }

    /*
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putStringArrayList("MatchedPokemon", matchedPokemon);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        matchedPokemon = savedInstanceState.getStringArrayList("MatchedPokemon");
        savedState(matchedPokemon);
    }
    */



    }



// NEED TO GET VALUE OF LAST BUTTON CLICKED SO THAT IT WILL CHECK WITH CURRENT CLICKED.
// ELSE, IT'S JUST GOING TO GET TRANSPARENT BECAUSE IT HAPPENS IN REAL TIME (ELSE STATEMENT, DOESN'T KEEP TRACK OF PAST BOOLEANS?)