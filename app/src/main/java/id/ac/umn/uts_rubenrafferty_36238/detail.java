package id.ac.umn.uts_rubenrafferty_36238;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class detail extends AppCompatActivity {


    ImageView imageviewfoto;
    TextView textviewLibrary;
    Button suara;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle b = getIntent().getExtras();
        String name = b.getString("NamaSFX");
        setTitle(name);


        imageviewfoto = findViewById(R.id.imagefoto);
        textviewLibrary = findViewById(R.id.textimages);
        suara = findViewById(R.id.suara);

        ActionBar actBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIncomingExtra();

    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        if (mediaPlayer != null) mediaPlayer.release();
    }

    private void getIncomingExtra(){
        if(getIntent().hasExtra("ImageUrl")&& getIntent().hasExtra("NamaSFX")){
            Integer fotoSFX = getIntent().getIntExtra("ImageUrl",0);
            String namaSFX = getIntent().getStringExtra("NamaSFX");
            Integer sound = getIntent().getIntExtra("Sound",0);
            setMediaPlayer(fotoSFX,namaSFX,sound);
        }
    }

    private void setMediaPlayer(Integer fotoSFX, String namaSFX,Integer sound){
        Glide.with(this).asBitmap().load(fotoSFX).into(imageviewfoto);
        textviewLibrary.setText(namaSFX);

        suara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer = MediaPlayer.create(getApplicationContext(), sound);
                mediaPlayer.start();
            }
        });
    }
}
