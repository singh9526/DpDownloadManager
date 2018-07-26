package main;

import java.io.RandomAccessFile;
import java.net.URL;
import java.util.Observable;

public class Download extends Observable implements Runnable {

	private URL url; 
	private int size; // bytes to download
	private int downloaded; // bytes downloaded
	private int status; // current status of download
	
	// Status Codes :
	private static final int DOWNLOADING = 0;
	private static final int PAUSED = 1;
	private static final int COMPLETE = 2;
	private static final int CANCELLED = 3; 
	private static final int ERROR = 4;	
	
	// Status Names :
	public static final String STATUSES[] = {"Downloading",
			"Paused","Complete","Cancelled","Error"};
	
	public static final int MAX_BUFFER_SIZE = 1024;

	public Download(URL url) {
		this.url = url;
		size = -1;
		downloaded = 0;
		status = DOWNLOADING;
		
		download();
	}

	private void download() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public String getUrl(){
		return url.toString();
	}
	
	public int getSize(){
		return size;
	}
	
	public float getProgress(){
		return ((float)downloaded/size)*100;
	}
	
	public int getStatus(){
		return status;
	}
	
	@Override
	public void run(){
		RandomAccessFile file = null;
	}
}