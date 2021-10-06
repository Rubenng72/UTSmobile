package id.ac.umn.uts_rubenrafferty_36238;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button profile=findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewprofile();
            }
        });

        Button library=findViewById(R.id.library);

        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewlogin();
            }
        });

    }
    public void viewprofile(){
        Intent profile= new Intent(this, profile.class);
        startActivity(profile);
    }
    public void viewlogin(){
        Intent login= new Intent(this, loginpage.class);
        startActivity(login);
    }


}