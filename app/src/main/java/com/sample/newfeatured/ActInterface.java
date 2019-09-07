package com.sample.newfeatured;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public interface ActInterface {
    // Google Ad Unit - ca-app-pub-3940256099942544/1033173712

    String TAG = "new-feat-tag";
    String __BANNER_SEARCH_STRING = "Start Banner";

    Handler adHandler = new Handler();
    long BANNER_REFRESH_DELAY = 20000;
    long INTERS_REFRESH_DELAY = 25000;

    default void sendToast(Activity context, String msg) {
        Toast.makeText(context, msg != null && !TextUtils.isEmpty(msg) ? msg : "No Message", Toast.LENGTH_LONG).show();
    }

    default void sendSnackbar(View rootView, String msg) {
        Snackbar sn = Snackbar.make(rootView, msg != null && !TextUtils.isEmpty(msg) ? msg : "No Message", BaseTransientBottomBar.LENGTH_LONG);
        sn.setAction("Okay", v -> sn.dismiss());
        sn.show();
    }
}
