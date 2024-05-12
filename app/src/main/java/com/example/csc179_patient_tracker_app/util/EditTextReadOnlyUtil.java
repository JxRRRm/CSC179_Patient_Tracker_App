package com.example.csc179_patient_tracker_app.util;

import android.widget.EditText;

public class EditTextReadOnlyUtil {
    public static void readOnly(EditText editText) {
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        editText.setClickable(false);
    }

    public static void editable(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setClickable(true);
    }
}
