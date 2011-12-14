package info.tkirk.deisfood;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;

import android.webkit.WebView;

import android.widget.Button;
import android.widget.EditText;


public class BrowserRedirect extends Activity {
   
   private EditText urlText;
   private Button goButton;
   private WebView webView;   

   
   @Override
   public void onCreate(Bundle savedInstanceState) {      
      super.onCreate(savedInstanceState);
      setContentView(R.layout.browser);

      
      webView = (WebView) findViewById(R.id.web_view);
      webView.loadUrl("http://brandeis.campusdish.com/en-US/CSNE/Brandeis/LocationsMenus/HoursOfOperation.htm");


   }
   

   
   /** Open a browser on the URL specified in the text box */
   private void openBrowser() {
      webView.getSettings().setJavaScriptEnabled(true);
      webView.loadUrl(urlText.getText().toString());
   }
   
   
}

