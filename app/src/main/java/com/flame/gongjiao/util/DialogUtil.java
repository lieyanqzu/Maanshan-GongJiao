package com.flame.gongjiao.util;

import android.content.Context;
import com.afollestad.materialdialogs.MaterialDialog;
import com.flame.gongjiao.R;

public class DialogUtil {

    private static MaterialDialog dialog;

    public static void showProcessDia(Context context) {
        dialog = new MaterialDialog.Builder(context)
                .title(R.string.progress_dialog)
                .content(R.string.please_wait)
                .progress(true, 0)
                .cancelable(false)
                .build();
        dialog.show();
    }

    public static void dismissProcessDia() {
        dialog.dismiss();
    }
}
