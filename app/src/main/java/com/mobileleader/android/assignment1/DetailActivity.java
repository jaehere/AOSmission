package com.mobileleader.android.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                finish();
                //액티비티 이동
                //Intent intent = new Intent(getApplicationContext(), finish());
                return true;

            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int idx = intent.getExtras().getInt("pos");
        int i = intent.getExtras().getInt("i"); //image resourceid
        String title = intent.getExtras().getString("title");
        String content = intent.getExtras().getString("content");

        ImageView detail_image = (ImageView) findViewById(R.id.one_image_2);
        TextView detail_title = (TextView) findViewById(R.id.detail_title);
        TextView detail_content = (TextView) findViewById(R.id.detail_content);

        detail_image.setImageResource(i);
        detail_title.setText(title);
        detail_content.setText(content);
    }


}