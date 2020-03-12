package com.example.last;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IDadapter extends RecyclerView.Adapter<IDadapter.MyViewHolder> {
    Context ctx;
    List<IDs> iddata;

    IDItemClick idclick;

    public IDadapter(Context ctx, List<IDs> iddata, IDItemClick cick) {
        this.ctx = ctx;
        this.iddata = iddata;
        idclick = cick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.itemsid, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.Title.setText(iddata.get(position).getTitle());
        holder.ID.setImageResource(iddata.get(position).getThumbnail());


    }

    @Override
    public int getItemCount() {
        return iddata.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView Title;
        private ImageView ID;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);



            Title = itemView.findViewById(R.id.idtitle);
            ID = itemView.findViewById(R.id.idimg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idclick.onIDsClick(iddata.get(getAdapterPosition()), ID);
                }
            });


        }
    }
}
