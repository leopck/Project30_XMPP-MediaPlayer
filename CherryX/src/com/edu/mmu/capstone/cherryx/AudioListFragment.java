package com.edu.mmu.capstone.cherryx;

import java.util.ArrayList;

import junit.runner.Version;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class AudioListFragment extends ListFragment implements AdapterView.OnItemClickListener {
	
	private ArrayList<Version> versions = new ArrayList<Version>();
	String URL_STRING = "http://mmu-foe-capstone.appspot.com/control?group=09&msg=";
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	Button bCommand;
	
	public static final AudioListFragment newInstance(String message)
	{
		AudioListFragment f = new AudioListFragment();
		Bundle bdl = new Bundle(1);
	    bdl.putString(EXTRA_MESSAGE, message);
	    bdl.putString("ET", " hello");
	    f.setArguments(bdl);
	    return f;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
View mView = inflater.inflate(R.layout.my_list_fragment, container, false);
		
		bCommand = (Button) mView.findViewById(R.id.button1);
		
		bCommand.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final CharSequence[] items = {
			            "Play", "Pause", "Stop", "Forward", "Rewind", "Increase", "Decrease", "Info"
			    };

			    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			    builder.setTitle("Make your selection");
			    builder.setItems(items, new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int item) {
			            // Do something with the selection
			            if(item == 0)
			            	new DownloadTask().execute(URL_STRING + "play");
			            if(item ==1)
			            	new DownloadTask().execute(URL_STRING + "pause");
			            if(item ==2)
			            	new DownloadTask().execute(URL_STRING + "stop");
			            if(item == 3)
			            	new DownloadTask().execute(URL_STRING + "for");
			            if(item ==4)
			            	new DownloadTask().execute(URL_STRING + "bac");
			            if(item ==5)
			            	new DownloadTask().execute(URL_STRING + "inc");
			            if(item ==6)
			            	new DownloadTask().execute(URL_STRING + "dec");
			            if(item ==7)
			            	new DownloadTask().execute(URL_STRING + "info");
			        }
			    });
			    AlertDialog alert = builder.create();
			    alert.show();
				
			}
		});
		
		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.audio, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
		//Toast.makeText(getActivity(), "Item " + position, Toast.LENGTH_LONG).show();
		Toast.makeText(getActivity(), "Songs "+Integer.toString(position), Toast.LENGTH_LONG).show();
		new DownloadTask().execute(URL_STRING + "a" + Integer.toString(position));
	}
	
}
