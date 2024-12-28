package com.example.myapplication.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.domain.Basket;
import com.example.myapplication.domain.Product;

public class ProductBasket extends Fragment  {
    private Product[] products = {new Product("name1", "desc1",
            "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
            new Product("name2", "desc2",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQNvSHYDBRY2JmCzO55x7GZy2oFvMNyqrW1Q&s"),
            new Product("name3", "desc3",
                    "https://i.pinimg.com/236x/d3/45/a5/d345a5c6a9ff42b31a8254b49b0f67d7.jpg"),
            new Product("name4", "desc4",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR44PSFlQ487_hUY1wijDb7j0lhkdvWkcuURA&s"),
            new Product("name5", "desc5",
                    "https://outmaxshop.ru/images/_NEWS2024_/novosti_rubruka/03.12/Campus_1920.jpg"),
            new Product("name6", "desc6",
                    "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
            new Product("name7", "desc7",
                    "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
            new Product("name8", "desc8",
                    "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
            new Product("name9", "desc9",
                    "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
            new Product("name10", "desc10",
                    "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
            new Product("name11", "desc11",
                    "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
            new Product("name12", "desc12",
                    "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
            new Product("name13", "desc13",
                    "https://lh5.googleusercontent.com/proxy/Vrn30hMW3iy9kFMxxgWy1dj0BPcla28ca3I81d0J5yCvD3h9Xao4UZTwyLmUypuGhWZ73Zo4YwHqruRXYv4rjcZkWNHzjIGU"),
    };
    private Basket basket;
    private int currentId = 0;
    private ImageView image;
    private ImageView ivBasket;
    private TextView tvName;
    private TextView tvDesc;
    private AppCompatButton btAddDel;
    private AppCompatButton btPrev;
    private AppCompatButton btNext;
    private AppCompatButton btBasket;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(R.layout.pr, container, false);
        image = view.findViewById(R.id.iv_product);
        ivBasket = view.findViewById(R.id.iv_product_basket);
        tvName = view.findViewById(R.id.tv_product_name);
        tvDesc = view.findViewById(R.id.tv_product_desc);
        btAddDel = view.findViewById(R.id.bt_product_add);
        btPrev = view.findViewById(R.id.bt_product_prev);
        btNext = view.findViewById(R.id.bt_product_next);

    }
    private void showProduct(int id){
        Product product = products[id];
        Glide.with(getContext()).load(product.getImgUrl()).into(image);
        tvName.setText(product.getNameProd());
        tvDesc.setText(product.getDescProd());
        if(basket.contain(product)){
            btAddDel.setText("Delete");
            addDellListen();
        }else{
            addDellListen();
        }
        if (id == 0){
            btPrev.setBackgroundColor(Color.GRAY);
            prevListen();
        } else if (id == products.length - 1) {
            btNext.setBackgroundColor(Color.GRAY);
            nextListen();
        } else {
            prevListen();
            nextListen();
        }
    }
    private void prevListen(){
        btPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentId--;
                showProduct(currentId);
            }
        });
    }

    private  void nextListen(){
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentId++;
                showProduct(currentId);
            }
        });
    }

    private void addDellListen(){
        btAddDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (basket.contain(products[currentId])){
                    basket.remProduct(products[currentId]);
                }else {
                    basket.addProd(products[currentId]);
                }
            }
        });
    }
    private void baskListen(){
        btBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("basket", basket);
                Log.e("BASKET", bundle.getSerializable("basket").toString());
                NavHostFragment.findNavController(ProductBasket.this)
                        .navigate(R.id.action_productBasket_to_basketFragment, bundle);
            }
        });

    }
}
