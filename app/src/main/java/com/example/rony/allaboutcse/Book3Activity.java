package com.example.rony.allaboutcse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Book3Activity extends AppCompatActivity {
    ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        WebView webview = (WebView) findViewById(R.id.web);
        webview.setWebViewClient(new Book3Activity.MyWebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        mProgress = ProgressDialog.show(this, "Loading", "Please wait while page is loading...");
        webview.setWebViewClient(new WebViewClient() {
            // load url
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            // when finish loading page
            public void onPageFinished(WebView view, String url) {
                if(mProgress.isShowing()) {
                    mProgress.dismiss();
                }
            }
        });
        String url = "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=7&cad=rja&uact=8&ved=0ahUKEwjQqPaslMTTAhWLQo8KHcIXClQQFghKMAY&url=http%3A%2F%2F202.74.245.22%3A8080%2Fxmlui%2Fbitstream%2Fhandle%2F123456789%2F673%2F1.%2520Introductory%2520Page.pdf%3Fsequence%3D1&usg=AFQjCNFXQ17wF37nKk0wLBsZDWqzEdh1Kw&sig2=BVtYTsyr3ELNBaD_m-5J3w";
        webview.loadUrl(url);
        webview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });

    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        else if (id == R.id.action_settings) {
            Intent i=new Intent(Book3Activity.this, AboutUsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
