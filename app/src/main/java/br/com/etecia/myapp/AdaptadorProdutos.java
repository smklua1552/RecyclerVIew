package br.com.etecia.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorProdutos extends RecyclerView.Adapter<AdaptadorProdutos.ViewHolder> {
    private Context context;

    private List<Produtos> lstProdutos;

    public AdaptadorProdutos(Context context, List<Produtos> lstProdutos) {
        this.context = context;
        this.lstProdutos = lstProdutos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.modelo_produtos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produtos produto = lstProdutos.get(position);

        holder.modTituloProduto.setText(produto.getTitulo());
        holder.modImageProduto.setImageResource(produto.getImagem());
        holder.cardProdutos.setOnClickListener((__) -> {
            Toast.makeText(AdaptadorProdutos.this.context, "Oi", Toast.LENGTH_SHORT);
        });
    }

    @Override
    public int getItemCount() {
        return lstProdutos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardProdutos;
        ImageView modImageProduto;
        TextView modTituloProduto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardProdutos = itemView.findViewById(R.id.cardProdutos);
            modTituloProduto = itemView.findViewById(R.id.modTituloProduto);
            modImageProduto = itemView.findViewById(R.id.modImageProduto);
        }
    }
}

