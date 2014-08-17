package com.edu.mmu.capstone.cherryx;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LampFragment extends Fragment {
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	boolean isPressed=false;
	public static final LampFragment newInstance(String message)
	{
		LampFragment f = new LampFragment();
		Bundle bdl = new Bundle(1);
	    bdl.putString(EXTRA_MESSAGE, message);
	    bdl.putString("ET", " hello");
	    f.setArguments(bdl);
	    return f;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
		String message = getArguments().getString(EXTRA_MESSAGE);
		String message2 = getArguments().getString("ET");
		View v = inflater.inflate(R.layout.lamp_fragment_layout, container, false);
		final TextView messageTextView = (TextView)v.findViewById(R.id.textView);
		messageTextView.setText(message + message2);
		final Button vibration = (Button) v.findViewById(R.id.button1);
		
		Vibrator vi = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

		// Vibrate for 400 milliseconds
		vi.vibrate(400);
		
		vibration.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(isPressed){
					//vibration.setBackgroundColor(0xFF0000);
					vibration.setText("Lamp ON");
			        }else{
						//vibration.setBackgroundColor(0x00FFFF);
						vibration.setText("Lamp OFF");
			        }
				isPressed=!isPressed;
			   
	
			}
		});
		
        return v;
    }

}
