package com.sis.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random=new Random();
		int randomNum=random.nextInt(5000);
		return randomNum;
	}
	
	public long getRandomNumber(long n) {
		Random random=new Random();
		long randomNum=random.nextLong(n);
		return randomNum;
	}
	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(dateObj);
		return date;
	}}
