package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;

public class HomeActivity extends ActivityBase {

    ImageButton saleImgBtn,lastBillImgBtn;

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity=new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.home_activity);
        return uiElementInActivity;
    }

    @Override
    protected void initialize(){
        initializeImageButtons();
        setImageButtonsClickListener();
    }

    private void initializeImageButtons(){
        saleImgBtn=(ImageButton)findViewById(R.id.imgBtnSale);
        lastBillImgBtn=(ImageButton)findViewById(R.id.imgBtnLastBill);
    }
    private void setImageButtonsClickListener(){
        setSaleImgBtnListener();
        setLastBillImgBtnListener();
    }
    private void setSaleImgBtnListener(){
        saleImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void setLastBillImgBtnListener(){
        lastBillImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,LastBillActivity.class);
                startActivity(intent);
            }
        });
    }
}
