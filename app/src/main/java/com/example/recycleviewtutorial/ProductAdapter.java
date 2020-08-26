package com.example.recycleviewtutorial;



import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter  extends RecyclerView.Adapter{
    private Activity activity;
    private List<Product> listProduct;
    private IOnClickItem iOnClickItemListener;


    public ProductAdapter(Activity activity, List<Product> listProduct, IOnClickItem iOnClickItemListener) {
        this.activity = activity;
        this.listProduct = listProduct;
        this.iOnClickItemListener = iOnClickItemListener;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_product,parent,false);
        ProductHolder holder = new ProductHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProductHolder vh = (ProductHolder) holder;
        Product product = listProduct.get(position);
        vh.ivCover.setImageResource(product.getImg());
        vh.tvTitle.setText(product.getTitle());
        vh.tvDes.setText(product.getDes());
        vh.tvPrice.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface IOnClickItem {
        void OnClickItem(int position);
    }

    public static class ProductHolder extends  RecyclerView.ViewHolder {
        private ImageView ivCover;
        private TextView tvTitle;
        private TextView tvDes;
        private TextView tvPrice;

        public  ProductHolder(View itemView) {
            super(itemView);

            ivCover = (ImageView) itemView.findViewById(R.id.ivCover);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDes = (TextView)  itemView.findViewById(R.id.tvDesc);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        }

    }
}
