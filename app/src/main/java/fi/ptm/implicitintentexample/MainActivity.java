package fi.ptm.implicitintentexample;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchInternet(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY,"Pasi Manninen");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"No activity to handle intent.",Toast.LENGTH_LONG).show();
        }
    }

    public void openBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://pasimanninen.com"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"No activity to handle intent.",Toast.LENGTH_LONG).show();
        }
    }

    public void dialNumber(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"No activity to handle intent.",Toast.LENGTH_LONG).show();
        }
    }

    public void sendSMS(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address", "04012345678");
        intent.putExtra("sms_body", "Your message here");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"No activity to handle intent.",Toast.LENGTH_LONG).show();
        }
    }

    public void showMap(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=Piippukatu 2, Jyväskylä"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"No activity to handle intent.",Toast.LENGTH_LONG).show();
        }
    }

}
