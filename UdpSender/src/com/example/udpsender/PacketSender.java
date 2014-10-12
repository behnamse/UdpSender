package com.example.udpsender;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PacketSender implements Runnable {
	DatagramPacket data;
	@Override
	public void run() {
		// TODO Auto-generated method stub
	    try {
	    	DatagramSocket s = new DatagramSocket();
			s.send(data);
	    } catch (Exception e) {

	    }    
	}
	public PacketSender (DatagramPacket p)  {
		
		try
		{
			data=p;	
		}		 
		catch (Exception e)
		{
			
		}
		
	}
	}