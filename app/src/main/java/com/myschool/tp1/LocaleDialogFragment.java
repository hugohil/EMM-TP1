package com.myschool.tp1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.example.hugo.tp1.R;

import java.util.Locale;

import static com.example.hugo.tp1.R.array.localeArray;

/**
 * Created by hugo on 15/06/15.
 */
public class LocaleDialogFragment extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.changeLocale)
                .setItems(localeArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        TypedArray locales = getResources().obtainTypedArray(localeArray);
                        Locale locale = new Locale(locales.getString(which));
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                        getActivity().getBaseContext().getResources().updateConfiguration(config,
                                getActivity().getBaseContext().getResources().getDisplayMetrics());
                    }
                });
        return builder.create();
    }
}
