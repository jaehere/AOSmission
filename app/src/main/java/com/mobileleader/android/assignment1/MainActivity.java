package com.mobileleader.android.assignment1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private InfoList mRecyclerAdapter;
    private ArrayList<InfoItem> minfoItems;

    private static final int REQUEST_CODE = 3000;

    private ClickCallbackListener callbackListner = new ClickCallbackListener(){


        @Override
        public void callBack(int pos, int i, String title, String content) {
           // Toast.makeText(MainActivity.this, pos+"번째 아이템 클릭", Toast.LENGTH_SHORT).show();
            ImageView changeImage = (ImageView) findViewById(R.id.one_image_1);

            changeImage.setImageResource(i);




            findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("pos", pos);
                    intent.putExtra("title",title);
                    intent.putExtra("content", content);
                    intent.putExtra("i",i);
                    startActivity(intent);


                    // Intent intent = new Intent(callbackListner.;itemView.getContext(), DetailActivity.class);
                    // itemView.getContext().

                    //Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    //Intent.putExtra("")

                    //startActivity(intent);
                    //launcher.launch(intent);

                }
            });

        }

    };

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
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setTitle("툴바 제목");


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ImageView mImageView = (ImageView) findViewById(R.id.one_image_1);

        /* initiate adapter */
        mRecyclerAdapter = new InfoList();

        // initiate recylcerview
        mRecyclerView.setAdapter(mRecyclerAdapter);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        minfoItems = new ArrayList<InfoItem>();

        for(int i=1; i<=5; i++){
            //int imgName =0;

        String str = "이것은 초심자를 위한 안드로이드 개발 가이드 책이다. 공부 열심히 하시고 쩌는 개발자가 되십시오.";
        String str_split = str.substring(0,22) + "...";

            switch (i){
                case 1:
                    minfoItems.add(new InfoItem(R.drawable.dice1,"안드로이드 개발책 #"+i,str));
                    break;
                case 2:
                    minfoItems.add(new InfoItem(R.drawable.dice2,"안드로이드 개발책 #"+i, str));
                    break;
                case 3:
                    minfoItems.add(new InfoItem(R.drawable.dice3,"안드로이드 개발책 #"+i, str));
                    break;
                case 4:
                    minfoItems.add(new InfoItem(R.drawable.dice4,"안드로이드 개발책 #"+i, str));
                    break;
                case 5:
                    minfoItems.add(new InfoItem(R.drawable.dice5,"안드로이드 개발책 #"+i, str));
                    break;
                default:
                    break;
            }

            //minfoItems.add(new InfoItem(R.drawable.ic_launcher_foreground,"안드로이드 개발책 #"+i, "이것은 초심자를 위한 안드로이드 개발 가이드 책이다. 공부 열심히 하시고"));
        }

        mRecyclerAdapter.setmInfoList(minfoItems);
        mRecyclerAdapter.setCallbackListener(callbackListner);

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Intent intent = new Intent(, DetailActivity.class);


               // Intent intent = new Intent(callbackListner.;itemView.getContext(), DetailActivity.class);
               // itemView.getContext().

                //Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                //Intent.putExtra("")

                //startActivity(intent);
                //launcher.launch(intent);

            }
        });


        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult data) {
                        Log.d("TAG", "data : " + data);
                        if(data.getResultCode() == Activity.RESULT_OK){
                            Intent intent = data.getData();
                            String result = intent.getStringExtra("result");

                           // tv_result.setText(result);
                        }
                    }
                });




    }
}