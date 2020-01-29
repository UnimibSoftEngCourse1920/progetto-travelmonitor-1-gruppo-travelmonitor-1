package com.sviluppotrilo.trilo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.sviluppotrilo.trilo.R;

public class Social extends AppCompatActivity {

    TabLayout tabLayout;
    WebView webView;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialnetwork);

        tabLayout = findViewById(R.id.socialtab);
        webView = findViewById(R.id.webView);

        back = findViewById(R.id.backpage);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Social.this, Preferiti.class);
                Social.this.startActivity(goBack);
            }
        });

        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://twitter.com/atm_informa");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int count = tabLayout.getSelectedTabPosition();
                if(count == 0) {
                    webView.setWebViewClient(new WebViewClient());
                    WebSettings webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.loadUrl("https://twitter.com/atm_informa");
                }
                else {
                    webView.setWebViewClient(new WebViewClient());
                    WebSettings webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.loadUrl("https://twitter.com/TrenordOfficial");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Auto-generated method
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Auto-generated method
            }
        });

    }

}
