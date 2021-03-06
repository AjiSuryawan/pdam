package com.tangria.spa.bookingku.Fragment.Home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tangria.spa.bookingku.Activity.FormRecord;
import com.tangria.spa.bookingku.R;
import com.tangria.spa.bookingku.Util.DatabaseProvider;

import java.util.List;

public class adapter_list_item_spa extends RecyclerView.Adapter<adapter_list_item_spa.Holder> {

    private List<data_item_spa> arrayList;
    private Context context;

    public adapter_list_item_spa(Context context, List<data_item_spa> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_spa, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        final data_item_spa data_item = arrayList.get(position);
        if(DatabaseProvider.getInstance().isSubmitted(data_item.getName())){
            holder.imageview_item_spa.setVisibility(View.VISIBLE);
        }
        holder.textview_item_spa.setText(data_item.getName());
        holder.textview_description_item.setText(data_item.getDescription());
        if(data_item.getPrice() != null)
            //holder.textview_cost_item.setText(String.valueOf(data_item.getPrice().getHarga()));
        Glide.with(context)
                .load(data_item.getImage())
                .into(holder.imageview_item_spa);
        holder.cardku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final Integer id = data_item.getId();
////                final String name = data_item.getName();
////                final String image = data_item.getImage();
////                final String description = data_item.getDescription();
////                final Price price = data_item.getPrice();
////                final boolean available = data_item.getAvailable();
////                Intent intent = new Intent(holder.itemView.getContext(),DetailActivity.class);
////                intent.putExtra("id",id);
////                Log.d("idbarang", "onClick: "+id);
////                intent.putExtra("name",name);
////                intent.putExtra("image",image);
////                intent.putExtra("description",description);
////                intent.putExtra("price",price.getHarga());
////                intent.putExtra("available",available);
                Intent intent = new Intent(context, FormRecord.class);
                intent.putExtra("name", data_item.getName());
                //intent.putExtra("product", data_item);

                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList == null? 0 : arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView imageview_item_spa;
        private CardView cardku;
        private TextView textview_item_spa,textview_description_item;
        //TextView textview_cost_item;

        public Holder(View itemView) {
            super(itemView);
            imageview_item_spa = (ImageView) itemView.findViewById(R.id.textview_cost_item);
            cardku = (CardView) itemView.findViewById(R.id.cardku);
            textview_item_spa = (TextView) itemView.findViewById(R.id.textview_name_item);
            textview_description_item = (TextView)itemView.findViewById(R.id.textview_description_item);
            //textview_cost_item = (TextView)itemView.findViewById(R.id.textview_cost_item);
        }
    }
}
