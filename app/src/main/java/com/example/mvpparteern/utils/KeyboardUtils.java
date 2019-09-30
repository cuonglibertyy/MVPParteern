package com.example.mvpparteern.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardUtils {
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager)
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}
