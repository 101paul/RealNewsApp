package com.example.newsx_app.Activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.newsx_app.R;

import com.example.newsx_app.favaoriteF.ARTICLE;
import com.example.newsx_app.favaoriteF.readNewsActivity2;
import com.example.newsx_app.favaoriteF.roomDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class readNewsActivity extends AppCompatActivity {
    private WebView Webview  ;
    private ImageView arrowB ;
    private FloatingActionButton favB ;
    private boolean isHeartSelected = false ;
    private roomDB db ;
    private int isFravorite = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_news);
        Webview =  findViewById(R.id.webview) ;
//        arrowB = findViewById(R.id.arrowB) ;
        favB = findViewById(R.id.fab) ;
        String url = getIntent().getStringExtra("URL") ;
        String title = getIntent().getStringExtra("title") ;
        String urltoimage = getIntent().getStringExtra("urltoImage") ;
        String source = getIntent().getStringExtra("source") ;
        db = roomDB.getInstance(this) ;
        Webview.getSettings().setJavaScriptEnabled(true); // enable javascript
        final Activity activity = this;
        Webview .loadUrl(url);
        Webview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });
        favB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHeartSelected = !isHeartSelected; // Toggle the state
                if (isHeartSelected) {
                    ARTICLE article = new ARTICLE(title,url,urltoimage,source) ;
                    new Thread(() -> db.favoriteArticleDao().insert(article)).start() ;
                    isFravorite = 1;
                    favB.setImageResource(R.drawable.love);
                    Toast.makeText(readNewsActivity.this, "Added to favorites!", Toast.LENGTH_SHORT).show();


                } else {
                    favB.setImageResource(R.drawable.heartx);
                }
                // Get a database instance (assuming you have a method in your activity/fragment)


            }
    }) ;
}}