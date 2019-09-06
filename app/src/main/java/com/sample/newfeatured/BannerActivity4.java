package com.sample.newfeatured;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class BannerActivity4 extends AppCompatActivity implements ActInterface {
    private Button show_inter_3, show_inter_4, show_banner_ads_btn;
    private View container;
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
    private Runnable intersRunnable1 = new Runnable() {
        @Override
        public void run() {
            try {
                setupInterstitialAd();
            } finally {
                adHandler.postDelayed(this, INTERS_REFRESH_DELAY);
            }
        }
    };
    private Runnable intersRunnable2 = new Runnable() {
        @Override
        public void run() {
            try {
                setupInterstitialAd2();
            } finally {
                adHandler.postDelayed(this, INTERS_REFRESH_DELAY);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner4);

        MobileAds.initialize(this, initializationStatus -> sendToast(this, "Ads Initialized!"));
        MobileAds.initialize(this, AD_APP_ID);

        show_inter_3 = findViewById(R.id.show_interstitial_3);
        show_banner_ads_btn = findViewById(R.id.show_banner_ads);
        show_inter_4 = findViewById(R.id.show_interstitial_4);
        container = findViewById(R.id.container);

        show_banner_ads_btn.setOnClickListener(v -> {
            if (show_banner_ads_btn.getText().toString().contains(__BANNER_SEARCH_STRING)) {
                initAdViews();
                show_banner_ads_btn.setText(getString(R.string.stop_banner_ads));
                adHandler.post(bannerRunnable);
            } else adHandler.removeCallbacks(bannerRunnable);
        });
        show_inter_3.setOnClickListener(v -> {
            setupInterstitialAd();
            adHandler.post(intersRunnable1);
        });
        show_inter_4.setOnClickListener(v -> {
            setupInterstitialAd2();
            adHandler.post(intersRunnable2);
        });
    }

    private void setupInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);

        interstitialAd.setAdUnitId(INTERSTITIAL_AD_3);

        initInterstitial(interstitialAd);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                showInterstitial(interstitialAd);
            }

            @Override
            public void onAdImpression() {
                sendSnackbar(container, "Impression has been sent!");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                sendSnackbar(container, "Interstitial failed to load with error code: " + i);
                if (i == AdRequest.ERROR_CODE_NETWORK_ERROR) setupInterstitialAd();
            }
        });
    }

    private void initInterstitial(InterstitialAd interstitialAd) {
        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
//        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
//            AdRequest adRequest = new AdRequest.Builder().build();
//            interstitialAd.loadAd(adRequest);
//        }

        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
    }

    private void showInterstitial(InterstitialAd interstitialAd) {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            sendToast(BannerActivity4.this, "The interstitial wasn't loaded yet.");
        }
    }


    private void setupInterstitialAd2() {
        InterstitialAd interstitialAd2 = new InterstitialAd(this);

        interstitialAd2.setAdUnitId(INTERSTITIAL_AD_4);

        initInterstitial2(interstitialAd2);

        interstitialAd2.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                showInterstitial2(interstitialAd2);
            }

            @Override
            public void onAdImpression() {
                sendSnackbar(container, "Impression has been sent!");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                sendSnackbar(container, "Interstitial failed to load with error code: " + i);
                if (i == AdRequest.ERROR_CODE_NETWORK_ERROR) setupInterstitialAd();
            }
        });
    }

    private void initInterstitial2(InterstitialAd interstitialAd2) {
//        if (!interstitialAd2.isLoading() && !interstitialAd2.isLoaded()){
//            AdRequest adRequest = new AdRequest.Builder().build();
//            interstitialAd2.loadAd(adRequest);
//        }

        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd2.loadAd(adRequest);
    }

    private void showInterstitial2(InterstitialAd interstitialAd2) {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (interstitialAd2 != null && interstitialAd2.isLoaded()) {
            interstitialAd2.show();
        } else {
            sendToast(BannerActivity4.this, "The interstitial wasn't loaded yet.");
        }
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

    @Override
    protected void onPause() {
        super.onPause();
        adHandler.removeCallbacks(bannerRunnable);
        show_banner_ads_btn.setText(getString(R.string.start_banner_ads_string));
        adHandler.removeCallbacks(intersRunnable1);
        show_inter_3.setText(getString(R.string.show_interstitial_3_string));
        adHandler.removeCallbacks(intersRunnable2);
        show_inter_4.setText(getString(R.string.show_interstitial_4_string));
    }
}
