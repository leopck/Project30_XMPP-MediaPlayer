package com.edu.mmu.capstone.cherryx;

//import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	
	public static final MyFragment newInstance(String message)
	{
		MyFragment f = new MyFragment();
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
		View v = inflater.inflate(R.layout.myfragment_layout, container, false);
		TextView messageTextView = (TextView)v.findViewById(R.id.textView);
		messageTextView.setText(message + message2);

		
		
        return v;
    }
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Vibrator vi = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

		// Vibrate for 400 milliseconds
		vi.vibrate(600);
	}
	
}
