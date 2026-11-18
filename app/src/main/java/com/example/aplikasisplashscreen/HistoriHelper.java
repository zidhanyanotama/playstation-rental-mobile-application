package com.example.aplikasisplashscreen;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HistoriHelper {

    private static final String PREF_NAME = "HistoriPrefs";
    private static final String KEY_HISTORI = "data_histori";

    public static void simpanHistori(Context context, String histori) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Set<String> historiSet = prefs.getStringSet(KEY_HISTORI, new HashSet<>());
        Set<String> updatedSet = new HashSet<>(historiSet);
        updatedSet.add(histori);
        prefs.edit().putStringSet(KEY_HISTORI, updatedSet).apply();
    }

    public static void hapusSemuaHistori(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().remove(KEY_HISTORI).apply();
    }

    public static ArrayList<String> ambilHistori(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Set<String> historiSet = prefs.getStringSet(KEY_HISTORI, new HashSet<>());
        return new ArrayList<>(historiSet);
    }
}
