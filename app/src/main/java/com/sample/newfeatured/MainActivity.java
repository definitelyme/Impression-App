package com.sample.newfeatured;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements ActInterface {
    private Button show_banner_ads;
    private Runnable bannerRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                initAdViews();
            } finally {
                adHandler.postDelayed(this, BANNER_REFRESH_DELAY);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, initializationStatus -> sendToast(this, "Ads Initialized!"));
        MobileAds.initialize(this, getString(R.string.ad_app_id));

        show_banner_ads = findViewById(R.id.show_banner_ads);
        Button to_act_2 = findViewById(R.id.to_banner_activity_2);

        show_banner_ads.setOnClickListener(v -> {
            if (show_banner_ads.getText().toString().contains(__BANNER_SEARCH_STRING)) {
                initAdViews();
                show_banner_ads.setText(getString(R.string.stop_banner_ads));
                adHandler.post(bannerRunnable);
            } else adHandler.removeCallbacks(bannerRunnable);
        });
        to_act_2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, BannerActivity2.class)));
    }

    private void initAdViews() {
        AdView adView1,
                adView2, adView3, adView4, adView5, adView6,
                adView7, adView8, adView9, adView10, adView11,
                adView12, adView13, adView14, adView15, adView16,
                adView17, adView18, adView19, adView20, adView21,
                adView22, adView23, adView24, adView25;

        adView1 = findViewById(R.id.adView1);
        adView2 = findViewById(R.id.adView2);
        adView3 = findViewById(R.id.adView3);
        adView4 = findViewById(R.id.adView4);
        adView5 = findViewById(R.id.adView5);
        adView6 = findViewById(R.id.adView6);
        adView7 = findViewById(R.id.adView7);
        adView8 = findViewById(R.id.adView8);
        adView9 = findViewById(R.id.adView9);
        adView10 = findViewById(R.id.adView10);
        adView11 = findViewById(R.id.adView11);
        adView12 = findViewById(R.id.adView12);
        adView13 = findViewById(R.id.adView13);
        adView14 = findViewById(R.id.adView14);
        adView15 = findViewById(R.id.adView15);
        adView16 = findViewById(R.id.adView16);
        adView17 = findViewById(R.id.adView17);
        adView18 = findViewById(R.id.adView18);
        adView19 = findViewById(R.id.adView19);
        adView20 = findViewById(R.id.adView20);
        adView21 = findViewById(R.id.adView21);
        adView22 = findViewById(R.id.adView22);
        adView23 = findViewById(R.id.adView23);
        adView24 = findViewById(R.id.adView24);
        adView25 = findViewById(R.id.adView25);

        adView1.loadAd(adRequest());
        adView2.loadAd(adRequest());
        adView3.loadAd(adRequest());
        adView4.loadAd(adRequest());
        adView5.loadAd(adRequest());
        adView6.loadAd(adRequest());
        adView7.loadAd(adRequest());
        adView8.loadAd(adRequest());
        adView9.loadAd(adRequest());
        adView10.loadAd(adRequest());
        adView11.loadAd(adRequest());
        adView12.loadAd(adRequest());
        adView13.loadAd(adRequest());
        adView14.loadAd(adRequest());
        adView15.loadAd(adRequest());
        adView16.loadAd(adRequest());
        adView17.loadAd(adRequest());
        adView18.loadAd(adRequest());
        adView19.loadAd(adRequest());
        adView20.loadAd(adRequest());
        adView21.loadAd(adRequest());
        adView22.loadAd(adRequest());
        adView23.loadAd(adRequest());
        adView24.loadAd(adRequest());
        adView25.loadAd(adRequest());
    }

    private AdRequest adRequest() {
        return new AdRequest.Builder()
                .build();
    }
}
