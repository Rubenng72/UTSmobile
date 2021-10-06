package id.ac.umn.uts_rubenrafferty_36238;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class RecyclerVA extends RecyclerView.Adapter<RecyclerVA.ViewHolder>{

    private ArrayList<Integer> fotoSFX = new ArrayList<>();
    private ArrayList<String> namaSFX = new ArrayList<>();
    private ArrayList<Integer> sound = new ArrayList<>();
    private Context context;

    public RecyclerVA(ArrayList<Integer> fotoSFX, ArrayList<String> namaSFX, ArrayList<Integer> sound, Context context) {
        this.fotoSFX = fotoSFX;
        this.namaSFX = namaSFX;
        this.sound = sound;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutdesign,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(fotoSFX.get(position)).into(holder.imageviewfoto);

        holder.textviewLibrary.setText(namaSFX.get(position));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detail.class);
                intent.putExtra("ImageUrl", fotoSFX.get(position));
                intent.putExtra("NamaSFX", namaSFX.get(position));
                intent.putExtra("Sound", sound.get(position));

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return namaSFX.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageviewfoto;
        TextView textviewLibrary;
        ConstraintLayout constraintLayout;
        Button hapus;
        public ViewHolder(@NonNull View ViewObject) {
            super(ViewObject);
            imageviewfoto = ViewObject.findViewById(R.id.imageviewfoto);
            textviewLibrary = ViewObject.findViewById(R.id.textviewLibrary);
            constraintLayout = ViewObject.findViewById(R.id.constraintLayout);
            hapus = ViewObject.findViewById(R.id.hapus);
            hapus.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            int location = getAdapterPosition();
            Toast.makeText(view.getContext(), "Deleted "+namaSFX.get(location),Toast.LENGTH_LONG).show();
            namaSFX.remove(location);
            fotoSFX.remove(location);
            sound.remove(location);
            notifyItemRemoved(location);
            notifyItemRangeChanged(location, getItemCount());
        }
    }
}
