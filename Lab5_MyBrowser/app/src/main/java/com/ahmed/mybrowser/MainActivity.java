package com.ahmed.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating and Linking objects to modify XML items
        final WebView webview = (WebView) findViewById(R.id.webview);
        Button btnGo = (Button) findViewById(R.id.go);
        final EditText txtAddress =(EditText) findViewById(R.id.address);
        //////////////////

        //To enable java script into webView
        webview.getSettings().setJavaScriptEnabled(true);
        /////////////////

        //Sets whether the DOM storage API is enabled.
        //boolean: true if the WebView should use the DOM storage API
        //Web storage, sometimes known as DOM storage (Document Object Model storage)
        // DOM storage provides web apps with methods and protocols for storing client-side data
        webview.getSettings().setDomStorageEnabled(true);
        ///////////////


        webview.setWebViewClient(new WebViewClient(){
            @Override
            // you tell the webClient you want to catch when a url is about to load
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                CookieManager.getInstance().setAcceptCookie(true);
                return true;
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://"+ txtAddress.getText());
            }
        });

        if(getIntent() != null && getIntent().getData() != null){
            txtAddress.setText(getIntent().getData().toString());
            webview.loadUrl(getIntent().getData().toString());
        }

    }

    //A MenuInflater is an object that is able to create Menu from xml resources (of course only menus resources),
    // that is : construct a new instance of Menu given a menu resource identifier.
    //The onCreateOptionMenu(Menu) is called when the menu button of the device is pressed, or either Activity.openOptionsMenu() is called.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
