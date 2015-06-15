package com.myschool.tp1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hugo.tp1.R;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), getString(R.string.main_starting), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_exit){
            createExitDialog();
            return true;
        } else if (id == R.id.action_locale){
            changeLocale();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeLocale() {
        LocaleDialogFragment localeFragment = new LocaleDialogFragment();
        localeFragment.show(getFragmentManager(), getString(R.string.main_langage));
    }

    private void createExitDialog() {
        ExitDialogFragment exitFragment = new ExitDialogFragment();
        exitFragment.show(getFragmentManager(), getString(R.string.main_exit));
    }
}

