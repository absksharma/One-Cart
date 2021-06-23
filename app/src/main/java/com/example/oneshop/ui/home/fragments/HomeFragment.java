package com.example.oneshop.ui.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.oneshop.R;
import com.example.oneshop.adapters.ProductsAdapter;
import com.example.oneshop.data.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class HomeFragment extends Fragment {

    private static final String PRODUCT_URL = "https://androidtesting.in/abhishek/one_shop/apis/productsapi.php";

    List<Product> productList;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    private void loadProducts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray products = new JSONArray(response);
                            //traversing through all the object
                            for (int i = 0; i < products.length(); i++) {
                                //getting product object from json array
                                JSONObject productObject = products.getJSONObject(i);
                                //adding the product to product list
                                productList.add(new Product(
                                        productObject.getInt("id"),
                                        productObject.getString("category"),
                                        productObject.getString("title"),
                                        productObject.getString("shortdesc"),
                                        productObject.getDouble("price"),
                                        productObject.getString("image_url")
                                ));
                            }

                            ProductsAdapter adapter = new ProductsAdapter(getActivity(), productList);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }
}