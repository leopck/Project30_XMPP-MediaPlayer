package com.edu.mmu.capstone.cherryx;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		 private ProgressBar progressBar;
		 private int progressStatus = 0;
		 private TextView textView;
		 private Handler handler = new Handler();
		 
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
progressBar = (ProgressBar) rootView.findViewById(R.id.timer_progress);
			
			textView =  (TextView) rootView.findViewById(R.id.textView1);
			
			new Thread(new Runnable() {
			     public void run() {
			        while (progressStatus < 100) {
			           progressStatus += 1;
			    // Update the progress bar and display the 

			                         //current value in the text view
			    handler.post(new Runnable() {
			    public void run() {
			       progressBar.setProgress(progressStatus);
			       textView.setText(progressStatus+"/"+progressBar.getMax());
			    }
			        });
			        try {
			           // Sleep for 200 milliseconds. 

			                         //Just to display the progress slowly
			           Thread.sleep(200);
			        } catch (InterruptedException e) {
			           e.printStackTrace();
			        }
			     }
			  }
			  }).start();
			
			
			
			
			return rootView;
		}
	}
}
