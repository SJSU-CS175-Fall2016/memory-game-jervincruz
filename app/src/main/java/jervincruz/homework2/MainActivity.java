package jervincruz.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button play;
    Button rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {

            @Override
                    public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), play.class);
                startActivity(i);
            }
        });

        rules = (Button)findViewById(R.id.button2);
        rules.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), rules.class);
                startActivity(i);
            }
        });



    }



}
