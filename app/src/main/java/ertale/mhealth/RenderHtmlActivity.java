package ertale.mhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class RenderHtmlActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_render_html);
        initializeWebView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(ertale.mhealth.R.menu.menu_navigation, menu);
        return true;
    }

    private void initializeWebView() {

        Intent intent = getIntent();
        String title = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_TITLE);
        setTitle(title);

        wv().getSettings().setJavaScriptEnabled(true);
        String entryPage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_ENTRY_PAGE);
        wv().loadUrl("file:///android_asset/content/" + entryPage);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.action_disease:
                return openPage(Content.DISEASE_ENTRY);
            case R.id.action_symptom:
                return openPage(Content.SYMPTOM_ENTRY);
            case R.id.action_the_body:
                return openPage(Content.THE_BODY_ENTRY);
            case R.id.action_institution:
                return openPage(Content.INSTITUTION_ENTRY);
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onBackPressed() {
        if (wv().canGoBack()) {
            wv().goBack();
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private boolean openPage(String page) {
        wv().loadUrl("file:///android_asset/content/" + page);
        return true;
    }

    private WebView wv() {
        return (WebView) findViewById(R.id.web_view);
    }
}
