package com.example.marvel.marvel.util;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utils {

    public static boolean isConected(Context cont) {
        ConnectivityManager conmag = (ConnectivityManager) cont.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conmag != null) {
            conmag.getActiveNetworkInfo();

            //Verifica internet pela WIFI
            if (conmag.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected()) {
                return true;
            }

            //Verifica se tem internet móvel
            if (conmag.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected()) {
                return true;
            }
        }

        return false;
    }

}
