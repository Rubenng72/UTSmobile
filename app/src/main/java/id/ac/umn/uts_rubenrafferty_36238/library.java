package id.ac.umn.uts_rubenrafferty_36238;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.Menu;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class library extends AppCompatActivity {

    private ArrayList<Integer> fotoSFX = new ArrayList<>();
    private ArrayList<String> namaSFX = new ArrayList<>();
    private ArrayList<Integer> sound = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getSFXdata();
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        setTitle(name);
        Toast.makeText(library.this, "Selamat datang "+name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem pilihanmenu){
        int id=pilihanmenu.getItemId();

        if(id==R.id.profile){
            BukaProfilePage();
        }
        if (id==R.id.mainmenu){
            BukaMainMenu();
        }
        return super.onOptionsItemSelected(pilihanmenu);
    }

    public void BukaProfilePage(){
        Intent profile = new Intent(this, profile.class);
        startActivity(profile);
    }
    public void BukaMainMenu(){
        Intent profile = new Intent(this, MainActivity.class);
        startActivity(profile);
    }


    private void ProsessingRecyclerVA(){
        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerVA adapter = new RecyclerVA(fotoSFX,namaSFX,sound, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getSFXdata(){
        namaSFX.add("Anime WoW");
        fotoSFX.add(R.drawable.anime);
        sound.add(R.raw.animewow);

        namaSFX.add("Deez Nuts");
        fotoSFX.add(R.drawable.deeznuts);
        sound.add(R.raw.deeznuts);

        namaSFX.add("John Cena");
        fotoSFX.add(R.drawable.johncena);
        sound.add(R.raw.johncena);

        namaSFX.add("Drip");
        fotoSFX.add(R.drawable.dripgoku);
        sound.add(R.raw.drip);

        namaSFX.add("OOOOHHHH!!!!");
        fotoSFX.add(R.drawable.oohh);
        sound.add(R.raw.ohhh);

        namaSFX.add("Explooosion!!!");
        fotoSFX.add(R.drawable.megumin);
        sound.add(R.raw.megumin);

        namaSFX.add("Damn");
        fotoSFX.add(R.drawable.damn);
        sound.add(R.raw.damn);

        namaSFX.add("Korone Yubi!!");
        fotoSFX.add(R.drawable.korone);
        sound.add(R.raw.korone);

        namaSFX.add("Monokuma");
        fotoSFX.add(R.drawable.monokuma);
        sound.add(R.raw.monokuma);

        ProsessingRecyclerVA();
    }
}