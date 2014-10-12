package com.example.udpsender;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends ActionBarActivity {
	Button send;
	Button btn_cast;
	EditText txtEditDelay; 
	EditText txtEditPort;
	EditText txtEditIp;
	EditText txtEditMessage;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		send = (Button) findViewById(R.id.btnSend);
		btn_cast = (Button) findViewById(R.id.btnBroadCast); 
		
		
		btn_cast.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) { 
	        	String txtCastIp="255.255.255.255";
	        	txtEditPort=(EditText) findViewById(R.id.txtPort);
	    		txtEditDelay=(EditText) findViewById(R.id.txtDelay);
	    		txtEditMessage=(EditText) findViewById(R.id.txtMessage);  
	    		try {
	    			Thread.sleep(Integer.parseInt(txtEditDelay.getText().toString()));	    	       
	    	        InetAddress local = InetAddress.getByName(txtCastIp);
	    	        int msg_length = txtEditMessage.getText().length();
	    	        byte[] message = txtEditMessage.getText().toString().getBytes();
	    	        DatagramPacket p = new DatagramPacket(message, msg_length, local,
	    	                Integer.parseInt(txtEditPort.getText().toString()));
	    	        Thread t= new Thread(new PacketSender(p));
		    		t.start();	    	        
	    			} 
	    		catch (Exception e  ) 
	    			{
	    	    	
	    			}	    		
	        	}	        	        	
	        });
		
		send.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	txtEditIp=(EditText) findViewById(R.id.txtIp);
	        	txtEditPort=(EditText) findViewById(R.id.txtPort);
	    		txtEditDelay=(EditText) findViewById(R.id.txtDelay);
	    		txtEditMessage=(EditText) findViewById(R.id.txtMessage);  
	    		try {
	    			Thread.sleep(Integer.parseInt(txtEditDelay.getText().toString()));	    	       
	    	        InetAddress local = InetAddress.getByName(txtEditIp.getText().toString());
	    	        int msg_length = txtEditMessage.getText().length();
	    	        byte[] message = txtEditMessage.getText().toString().getBytes();
	    	        DatagramPacket p = new DatagramPacket(message, msg_length, local,
	    	                Integer.parseInt(txtEditPort.getText().toString()));
	    	        Thread t= new Thread(new PacketSender(p));
		    		t.start();	    	        
	    			} 
	    		catch (Exception e  ) 
	    			{
	    	    	
	    			}	    		
	        }
	    });	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
