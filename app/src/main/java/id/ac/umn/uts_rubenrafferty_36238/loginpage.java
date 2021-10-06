package id.ac.umn.uts_rubenrafferty_36238;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.Normalizer;

public class loginpage extends AppCompatActivity {
    EditText username;
    Button search;
    String namauser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        username = (EditText) findViewById(R.id.username);
        search = (Button) findViewById(R.id.next);

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (TextUtils.isEmpty(username.getText().toString()))
                {
                    username.setError("Nama Tidak Boleh Dikosongkan");
                }else{
                    BukaLbry();
                }
            }
        });
    }
    public String BukaLbry(){
        namauser = username.getText().toString();
        Intent intent = getIntent();
        Intent profile = new Intent(this, library.class);
        profile.putExtra("name", namauser);
        startActivity(profile);
        return null;
    }
}