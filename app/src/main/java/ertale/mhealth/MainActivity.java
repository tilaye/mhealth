package ertale.mhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    public static String EXTRA_MESSAGE_ENTRY_PAGE = "activity_entry_page";
    public static String EXTRA_MESSAGE_TITLE = "activity_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ertale.mhealth.R.layout.activity_main);
    }

    public void openDiseases(View view) {
        openRenderHTMLActivity(Content.DISEASE_TITLE, Content.DISEASE_ENTRY);
    }

    public void openSymptoms(View view) {
        openRenderHTMLActivity(Content.SYMPTOM_TITLE, Content.SYMPTOM_ENTRY);
    }

    public void openTheBody(View view) {
        openRenderHTMLActivity(Content.THE_BODY_TITLE, Content.THE_BODY_ENTRY);
    }

    public void openInstitution(View view) {
        openRenderHTMLActivity(Content.INSTITUTION_TITLE, Content.INSTITUTION_ENTRY);
    }

    private void openRenderHTMLActivity(int title, String entryPage) {
        Intent intent = new Intent(this, RenderHtmlActivity.class);
        intent.putExtra(EXTRA_MESSAGE_TITLE, getResources().getString(title));
        intent.putExtra(EXTRA_MESSAGE_ENTRY_PAGE, entryPage);
        startActivity(intent);
    }
}
