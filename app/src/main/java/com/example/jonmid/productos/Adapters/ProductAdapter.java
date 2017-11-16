package com.example.jonmid.productos.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.productos.Models.Product;
import com.example.jonmid.productos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonmid on 16/11/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    List<Product> productList = new ArrayList<>();
    Context context;
    Integer id;

    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.with(context).load(productList.get(position).getImage()).into(holder.imageViewImage);
        holder.textViewPrice.setText(productList.get(position).getPrice());
        holder.textViewName.setText(productList.get(position).getName());
        holder.textViewDescription.setText(productList.get(position).getDescription());

        holder.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Actualizar producto", Toast.LENGTH_SHORT).show();

                Intent intent = new  Intent (context, EditProductoActivity.class);
                intent.putExtra (fun , "id" ,Integer.toString(productList.get(position).getId()));
                intent.putExtra (fun , "name" , productList.get(position).getName()));
                intent.putExtra (fun , "description" , productList.get(position).getDescription()));
                intent.putExtra (fun , "price" , productList.get(position).getPrice()));
                intent.putExtra (fun , "image" , productList.get(position).getImage()));
                contextItem.startActivity(intent);

             Toast.makeText(context,  text "Actualizacion", Toast.LENGTH_SHORT).show();
            }
        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = productList.get(position).get
                        SQLiteDatabes db = sqliteHelper.getWritableDatabase;
                        db.execSQL("delete from products where id= "+ id);
                Toast.makeText(context, "Eliminar producto", Toast.LENGTH_SHORT).show();
                Intent intent = new  Intent (context , IndexActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageViewImage;
        TextView textViewPrice;
        TextView textViewName;
        TextView textViewDescription;
        ImageButton buttonEdit;
        ImageButton buttonDelete;

        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);

            imageViewImage = (ImageView) item.findViewById(R.id.id_img_item_image);
            textViewPrice = (TextView) item.findViewById(R.id.id_tv_item_price);
            textViewName = (TextView) item.findViewById(R.id.id_tv_item_name);
            textViewDescription = (TextView) item.findViewById(R.id.id_tv_item_description);
            buttonEdit = (ImageButton) item.findViewById(R.id.id_btn_item_edit);
            buttonDelete = (ImageButton) item.findViewById(R.id.id_btn_item_delete);
        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
        }
    }

}
