package com.example.poorvi.slidertablayout;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefs
{

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String SHARED = "Languagues Demo";

    public static final String Language_Name = "val";

    public SharedPrefs(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String get_Language_name() {
        return sharedPreferences.getString(Language_Name, "");
    }

    public void save_Language_name(String Language_name) {
        editor.putString(Language_Name, Language_name);
        editor.commit();
    }
}
