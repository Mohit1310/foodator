package com.mohit.foodator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.mohit.foodator.Adaptor.CategoryAdaptor;
import com.mohit.foodator.Adaptor.PopularAdaptor;
import com.mohit.foodator.domain.CategoryDomain;
import com.mohit.foodator.domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    private LinearLayout settingsBtn;
    private BottomSheetDialog bottomSheetDialog;
    private FirebaseAuth mAuth;
    private TextView logout;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsBtn = findViewById(R.id.settingsBtn);
        sharedPreferences = getSharedPreferences("",MODE_PRIVATE);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
//        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(MainActivity.this,R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottomsheetlayout, null);

                sheetView.findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hot Dog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza","pop_1","slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",9.76));
        foodList.add(new FoodDomain("Cheese Burger","pop_2","beef, Gouda Cheese, special sauce, lettuce, tomato",8.79));
        foodList.add(new FoodDomain("Vegetable Pizza", "pop_3", "olive oil, Vegetable oil, pitted kalmata, cherry tomatoes, fresh oregano, basil", 8.50));

        adapter2 = new PopularAdaptor(this,foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }

}