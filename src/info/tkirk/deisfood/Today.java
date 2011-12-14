package info.tkirk.deisfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

public class Today extends Activity implements OnClickListener {
	private final Handler handler = new Handler(); 
	private WebView webView;
	
	View einsteinsButton;
	View facultyClubButton;
	View javaCityButton;
	View olliesButton;
	View podUsdanButton;
	View podVillageButton;
	View quadCafeButton;
	View quiznosButton;
	View shermanButton;
	View steinButton;
	View usdanLowerButton;
	View usdanUpperButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Assign all the views
		einsteinsButton = findViewById(R.id.einsteins_button);
		facultyClubButton = findViewById(R.id.facultyclub_button);
	 	javaCityButton = findViewById(R.id.javacity_button);
	 	olliesButton = findViewById(R.id.ollies_button);
	 	podUsdanButton = findViewById(R.id.podusdan_button);
	 	podVillageButton = findViewById(R.id.podvillage_button);
	 	quadCafeButton = findViewById(R.id.quadcafe_button);
	 	quiznosButton = findViewById(R.id.quiznos_button);
	 	shermanButton = findViewById(R.id.sherman_button);
	 	steinButton = findViewById(R.id.stein_button);
	 	usdanLowerButton = findViewById(R.id.usdanlower_button);
	 	usdanUpperButton = findViewById(R.id.usdanupper_button);
	 	
	 	//webView
	 	webView = (WebView) findViewById(R.id.web_view);
	 	webView.getSettings().setJavaScriptEnabled(true);
	 	webView.addJavascriptInterface(new AndroidBridge(),
            "android");
	 	webView.loadUrl("http://people.brandeis.edu/~tkirk/deisfood.html");
	 	
	 	//Initiate Views
	 	einsteinsButton.setOnClickListener(this);
	 	facultyClubButton.setOnClickListener(this);
	 	javaCityButton.setOnClickListener(this);
	 	olliesButton.setOnClickListener(this);
	 	podUsdanButton.setOnClickListener(this);
	 	podVillageButton.setOnClickListener(this);
	 	quadCafeButton.setOnClickListener(this);
	 	quiznosButton.setOnClickListener(this);
	 	shermanButton.setOnClickListener(this);
	 	steinButton.setOnClickListener(this);
	 	usdanLowerButton.setOnClickListener(this);
	    usdanUpperButton.setOnClickListener(this);
	 	


	}

   
   //Java Object exposed to JavaScript
   private class AndroidBridge  {
      public void callEinsteins(final String arg)  { 
         handler.post(new Runnable() {
            public void run()  {
            	if(!arg.equals("Einstein Bros Bagels"))
       				einsteinsButton.setVisibility(View.GONE);
            }
         });
      }
      
      public void callFacultyClub(final String arg) {
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("The Faculty Club"))
             		facultyClubButton.setVisibility(View.GONE);
             }
          });
       }
      
      public void callJavaCity(final String arg) { 
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("Java City Schneider"))
             		javaCityButton.setVisibility(View.GONE);
             }
          });
       }
      
      public void callOllies(final String arg) { 
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("Ollie's Eatery"))
             		olliesButton.setVisibility(View.GONE);
             }
          });
       }
      public void callPODUsdan(final String arg) {
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("P.O.D. Market at Usdan"))
             		podUsdanButton.setVisibility(View.GONE);
             }
          });
       }
      public void callPODVillage(final String arg) {
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("P.O.D. Market at Village"))
             		podVillageButton.setVisibility(View.GONE);
             }
          });
       }
      public void callQuadCafe(final String arg) { 
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("Quad Café"))
             		quadCafeButton.setVisibility(View.GONE);
             }
          });
       }
      public void callQuiznos(final String arg) { 
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("Quiznos"))
             		quiznosButton.setVisibility(View.GONE);
             }
          });
       }
      public void callSherman(final String arg) { 
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("Sherman Dining Hall"))
             		shermanButton.setVisibility(View.GONE);
             }
          });
       }
      public void callStein(final String arg) { 
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("The Stein"))
             		steinButton.setVisibility(View.GONE);
             }
          });
       }
      public void callUsdanLower(final String arg) { 
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("Usdan Café"))
             		usdanLowerButton.setVisibility(View.GONE);
             }
          });
       }
      
      public void callUsdanUpper(final String arg) { 
          handler.post(new Runnable() {
             public void run() {
             	if(!arg.equals("Usdan Boulevard"))
             		usdanUpperButton.setVisibility(View.GONE);
             }
          });
       }

   }
   
   public void onClick(View v) {		
		switch(v.getId()) {
		case R.id.einsteins_button:
			 Intent i = new Intent(this, AboutEinsteins.class);
	    	 i.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(i);
			break;
		case R.id.facultyclub_button:
			 Intent j = new Intent(this, AboutFacultyClub.class);
	    	 j.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(j);
			break;
		case R.id.javacity_button:
			 Intent a = new Intent(this, AboutJavaCity.class);
	    	 a.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(a);
			break;
		case R.id.ollies_button:
			 Intent b = new Intent(this, AboutOllies.class);
	    	 b.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(b);
			 break;
		case R.id.podusdan_button:
			 Intent c = new Intent(this, AboutPodUsdan.class);
	    	 c.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(c);
			break;
		case R.id.podvillage_button:
			 Intent d = new Intent(this, AboutPodVillage.class);
	    	 d.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(d);
			break;
		case R.id.quadcafe_button:
			 Intent e = new Intent(this, AboutQuadCafe.class);
	    	 e.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(e);
			break;
		case R.id.quiznos_button:
			 Intent f = new Intent(this, AboutQuiznos.class);
	    	 f.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(f);
			break;
		case R.id.sherman_button:
			 Intent g = new Intent(this, AboutSherman.class);
	    	 g.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(g);
			break;
		case R.id.stein_button:
			 Intent h = new Intent(this, AboutStein.class);
	    	 h.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(h);
			break;
		case R.id.usdanlower_button:
			 Intent l = new Intent(this, AboutUsdanLower.class);
	    	 l.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(l);
			break;
		case R.id.usdanupper_button:
			 Intent k = new Intent(this, AboutUsdanUpper.class);
	    	 k.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
	         startActivity(k);
			break;
		}
	}
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      super.onCreateOptionsMenu(menu);
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu, menu);
      return true;
   }
   

   
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
      case R.id.about:
    	 Intent i = new Intent(this, About.class);
    	 i.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
         startActivity(i);
         return true;
      
  	case R.id.browser:
 	 Intent j = new Intent(this, BrowserRedirect.class);
 	 j.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
      startActivity(j);
      return true;
   }
      return false;
   }
   
	
    //I want to make sure the web page is loaded every time someone starts the app
	public void onUserLeaveHint() {
		super.onUserLeaveHint();
		finish();
	}
}
