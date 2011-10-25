package info.tkirk.deisfood;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Today extends Activity implements OnClickListener {
	private static final String Tag = "DAY";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Assign all the views
		View einsteinsButton = findViewById(R.id.einsteins_button);
		View facultyClubButton = findViewById(R.id.facultyclub_button);
		View javaCityButton = findViewById(R.id.javacity_button);
		View olliesButton = findViewById(R.id.ollies_button);
		View podUsdanButton = findViewById(R.id.podusdan_button);
		View podVillageButton = findViewById(R.id.podvillage_button);
		View quadCafeButton = findViewById(R.id.quadcafe_button);
		View quiznosButton = findViewById(R.id.quiznos_button);
		View shermanButton = findViewById(R.id.sherman_button);
		View steinButton = findViewById(R.id.stein_button);
		View usdanLowerButton = findViewById(R.id.usdanlower_button);
		View usdanUpperButton = findViewById(R.id.usdanupper_button);
		
		//Get Date
		Calendar rightNow = Calendar.getInstance();
		Date date = rightNow.getTime();
		
		//Get Day, Hour, and Minutes
		int day = date.getDay();
		int hour = date.getHours();
		int minutes = date.getMinutes();
		
		//Log
		Log.v(Tag, "day="+day);
		
		//HHMM : 24 Hour Time
		hour *= 100;
		int currTime = hour + minutes;
		
		
		//Is Einstein's Open?
		//If Monday - Thursday between 8:00 am - 2:00 am (also 12:00 am - 2:00 am because of Sunday)
		if((day < 5 && day != 0) && (currTime < 200 || currTime >= 800))
			einsteinsButton.setOnClickListener(this);
		//If Friday between 8:00 am - 4:00 pm (also 12:00 am - 2:00 am because of Thursday)
		else if(day == 5 && (currTime < 200 || (currTime >= 800 && currTime < 1600)))
			einsteinsButton.setOnClickListener(this);
		//If Saturday between 11:00 am - 3:00 pm
		else if(day == 6 && (currTime >= 1100 && currTime < 1500))
			einsteinsButton.setOnClickListener(this);
		//If Sunday between  5:00 pm - 2:00 am
		else if(day == 0 && currTime >= 1700)
			einsteinsButton.setOnClickListener(this);
		else
			einsteinsButton.setVisibility(View.GONE);
		
		
		//Is The Faculty Club Open?
		//If Monday - Friday between 12:00 pm - 1:30 pm
		if((day < 6 && day != 0) && (currTime >= 1200 && currTime < 1330))
			facultyClubButton.setOnClickListener(this);
		else
			facultyClubButton.setVisibility(View.GONE);
		
		
		//Is Java City Open?
		//If Monday - Friday between 8:00 am - 4:00 pm
		if((day < 6 && day != 0) && (currTime >= 800 && currTime < 1600))
			javaCityButton.setOnClickListener(this);
		else
			javaCityButton.setVisibility(View.GONE);
		
		
		//Is Ollies Open?
		//If Thursday - Saturday between 10:00 pm - 3:00 am
		if((day > 3) && (currTime >= 2200))
			olliesButton.setOnClickListener(this);
		//Accounts for the 12 - 3 block that rolls over into Friday - Sunday
		else if ((day > 4 || day == 0) && currTime < 300) 
			olliesButton.setOnClickListener(this);
		else
			olliesButton.setVisibility(View.GONE);
		
		
		//Is POD @ USDAN Open?
		//If Monday - *Friday between 9:30 am - 2:00 am (*Friday is until 12:00)
		if((day < 6 && day != 0) && (currTime < 200 || currTime >= 930)) //accounts for 12:00 - 2:00 from Sunday - Thursday)
			podUsdanButton.setOnClickListener(this);	
		//If Saturday - *Sunday between 8:00 am - 12:00 am (*Sunday is until 2:00 am)
		else if((day > 5 || day == 0) && currTime >= 800)
			podUsdanButton.setOnClickListener(this);
		else
			podUsdanButton.setVisibility(View.GONE);
		
		
		//Is POD @ Village Open?
		//If Monday - Friday between 12:00 pm - 12:00 am
		if((day < 6 && day !=0) && currTime >= 1200)
			podVillageButton.setOnClickListener(this);
		else if(day == 0 && currTime >= 1600)
			podVillageButton.setOnClickListener(this);
		else
			podVillageButton.setVisibility(View.GONE);
		
		
		//Is Quad Cafe Open?
		//If Monday - Friday between 9:00 am - 2:00 pm
		if((day < 6 && day != 0) && (currTime >= 900 && currTime < 1400))
			quadCafeButton.setOnClickListener(this);
		else
			quadCafeButton.setVisibility(View.GONE);
		
		
		//Is Quiznos Open?
		//If Monday - Friday between 11:00 am - 2:30 pm and 4:30 pm - 12:00 am
		if((day < 6 && day != 0) && ((currTime >= 1100 && currTime < 1430) || currTime > 1630))
			quiznosButton.setOnClickListener(this);
		//If Saturday between 11:00 am - 12:00 am
		else if(day == 6 && currTime >= 1100)
			quiznosButton.setOnClickListener(this);
		else
			quiznosButton.setVisibility(View.GONE);
		
		
		//Is Sherman Open?
		//If Monday - Thursday between 7:00 am - 10:00 am or 11:30 am - 8:00 pm
		if((day < 5 && day != 0) && ((currTime >= 700 && currTime < 1000) || (currTime >= 1130 && currTime < 2000)))
			shermanButton.setOnClickListener(this);
		//If Friday between 7:00 am - 10:00 am or 11:30 am - 7:00 pm
		else if (day == 5 && ((currTime >= 700 && currTime < 1000) || (currTime >= 1130 && currTime < 1900)))
			shermanButton.setOnClickListener(this);
		//If Saturday - Sunday between 9:30 am - 7:00 pm
		else if((day > 5 || day == 0) && (currTime >= 930 && currTime < 1900))
			shermanButton.setOnClickListener(this);
		else
			shermanButton.setVisibility(View.GONE);
			
			
		//Is Stein Open?
		//If Monday - Sunday between 5:00 pm - 9:00 pm
		if(currTime >= 1700 && currTime < 2100)
			steinButton.setOnClickListener(this);
		else
			steinButton.setVisibility(View.GONE);
		
		
		//Is Usdan Lower Open?
		//If Monday - Friday between 8:00 am - 10:15 am or 11:30 am - 2:15 pm
		if((day < 6 && day != 0) && ((currTime >= 800 && currTime < 1015) || (currTime >= 1130 && currTime < 1415)))
			usdanLowerButton.setOnClickListener(this);
		//If Monday - Thursday between 4:45 pm - 8:00 pm
		else if((day < 5 && day != 0) && (currTime >= 1645 && currTime < 2000))
			usdanLowerButton.setOnClickListener(this);
		//If Saturday - SUnday between 11:30 am - 3:00 pm or 4:45 - 7:00 pm
		else if((day > 5 || day == 0) && ((currTime >= 1130 && currTime < 1500) || (currTime >= 1645 && currTime < 1900)))
			usdanLowerButton.setOnClickListener(this);
		else
			usdanLowerButton.setVisibility(View.GONE);
		
		
		//Is Usdan Upper Open?
		//If Monday - Thursday between 11:00 am - 11:00 pm
		if((day < 5 && day != 0) && (currTime >= 1100 && currTime < 2300))
			usdanUpperButton.setOnClickListener(this);
		//If Friday between 11:00 am - 11:00 pm
		else if(day == 5 && (currTime >= 1100 && currTime < 2200))
			usdanUpperButton.setOnClickListener(this);
		//If Sunday between 7:00 pm - 11:00 pm
		else if(day == 0 && (currTime >= 1900 && currTime < 2300))
			usdanUpperButton.setOnClickListener(this);
		else
			usdanUpperButton.setVisibility(View.GONE);

	}
	
	public void onClick(View v) {		
		switch(v.getId()) {
		case R.id.einsteins_button:
			startActivity(new Intent(this, AboutEinsteins.class));
			break;
		case R.id.facultyclub_button:
			startActivity(new Intent(this, AboutFacultyClub.class));
			break;
		case R.id.javacity_button:
			startActivity(new Intent(this, AboutJavaCity.class));
			break;
		case R.id.ollies_button:
			startActivity(new Intent(this, AboutOllies.class));
			break;
		case R.id.podusdan_button:
			startActivity(new Intent(this, AboutPodUsdan.class));
			break;
		case R.id.podvillage_button:
			startActivity(new Intent(this, AboutPodVillage.class));
			break;
		case R.id.quadcafe_button:
			startActivity(new Intent(this, AboutQuadCafe.class));
			break;
		case R.id.quiznos_button:
			startActivity(new Intent(this, AboutQuiznos.class));
			break;
		case R.id.sherman_button:
			startActivity(new Intent(this, AboutSherman.class));
			break;
		case R.id.stein_button:
			startActivity(new Intent(this, AboutStein.class));
			break;
		case R.id.usdanlower_button:
			startActivity(new Intent(this, AboutUsdanLower.class));
			break;
		case R.id.usdanupper_button:
			startActivity(new Intent(this, AboutUsdanUpper.class));
			break;
		}
	}
	
	public void onPause() {
		super.onPause();
		onDestroy();
	}
}