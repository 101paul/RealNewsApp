package com.example.newsx_app.favaoriteF;

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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.newsx_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class readNewsActivity2 extends AppCompatActivity {
    private WebView Webview  ;
    private ImageView arrowB ;
    private boolean isHeartSelected = true ;

    private FloatingActionButton favB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_news2);
        Webview =  findViewById(R.id.webview2) ;
        String url = getIntent().getStringExtra("URL") ;
        boolean isFromFavoriteFragment = getIntent().getBooleanExtra("fromFavorites", false);

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

    }
}