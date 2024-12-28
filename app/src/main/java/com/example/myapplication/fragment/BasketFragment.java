package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.domain.Basket;

import java.util.zip.Inflater;

public class BasketFragment extends Fragment {
    private TextView tvProducts;
    private AppCompatButton btClear;
    private AppCompatButton btBack;
    private Basket basket;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.basket_fragment,container,false);
        basket = (Basket) getArguments().getSerializable("basket");
        tvProducts = view.findViewById();
        btClear = view.findViewById();
        btBack = view.findViewById();
        tvProducts.setText(basket.toString());

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("basket", basket);
                NavHostFragment.findNavController(BasketFragment.this)
                        .navigate(R.id.action_basketFragment_to_productBasket, bundle);
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basket.clearAll();
            }
        });
    }
}
