package com.example.ym.sattamatka;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
     private WebView mywebview;
    InterstitialAd mInterstitialAd;
     private InterstitialAd interstitial;
    public AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        interstitial = new InterstitialAd(MainActivity.this);

//webview
        mywebview = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebview.loadUrl("http://sattamatkaresults.today/");
      //  mywebview.setWebViewClient(new WebViewClient() );
        mywebview.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if( URLUtil.isNetworkUrl(url) ) {
                    return false;
                }

                // Otherwise allow the OS to handle it
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity( intent );
                return true;
            }});

// banner adds
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment= null;
        int id = item.getItemId();

        if (id == R.id.home) {
          fragment = new Homefragment();

// Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});
            // Handle the camera action
        } else if (id == R.id.gForm) {
            fragment= new Guessingfragment();

            // Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});
        } else if (id == R.id.liveresults) {
             fragment=new livefragment();
            // Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});
        } else if (id == R.id.freetips) {
           fragment=new freetips();
            // Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});
        } else if (id == R.id.sattaking) {
            fragment=new sattaking();
            // Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});
        } else if (id == R.id.kubermatka) {
            fragment=new kubermatka();
            // Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});
        }
          else if (id == R.id.charts) {
            fragment=new charts();
            // Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});
        }
         else if (id == R.id.weeklycharts) {
            fragment=new weeklycharts();
            // Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});}

            else if (id == R.id.vipgames) {
            fragment=new vipgames();
            // Prepare the Interstitial Ad
            interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
// Call displayInterstitial() function
                    displayInterstitial();
                }});}

        else if (id == R.id.share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/Plain");
            String sharebody = "https://play.google.com/store/apps/details?id=com.smrtoday.android.abc";
            String sub = "SattaMatkaResults.today";
            intent.putExtra(Intent.EXTRA_SUBJECT,sub);
            intent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(intent,"Share using"));
        }


        if(fragment != null)
        {
            FragmentManager fragmentManager= getSupportFragmentManager();
            FragmentTransaction ft= fragmentManager.beginTransaction();
            ft.replace(R.id.screen, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
