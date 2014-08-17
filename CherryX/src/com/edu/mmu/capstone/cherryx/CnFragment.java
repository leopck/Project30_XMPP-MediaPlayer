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

public class CnFragment extends Fragment {
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	
	public static final CnFragment newInstance(String message)
	{
		CnFragment f = new CnFragment();
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
		View v = inflater.inflate(R.layout.cnfragment_layout, container, false);
		final TextView messageTextView = (TextView)v.findViewById(R.id.textView);
		messageTextView.setText(message + message2);
		Button vibration = (Button) v.findViewById(R.id.button1);
		
		Vibrator vi = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

		// Vibrate for 400 milliseconds
		vi.vibrate(400);
		
		vibration.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Vibrator vi = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

				// Vibrate for 400 milliseconds
				vi.vibrate(600);
				
				new CountDownTimer(30000, 1000) {

				     public void onTick(long millisUntilFinished) {
				    	 messageTextView.setText("seconds remaining: " + millisUntilFinished / 1000);
				     }

				     public void onFinish() {
				    	 messageTextView.setText("done!");
				     }
				  }.start();

	
			}
		});
		
        return v;
    }

}
