package com.cdacproject.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.dialect.function.DB2SubstringFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.cdacproject.model.Fd;
import com.cdacproject.dao.FdRepository;
import com.cdacproject.dao.XRepository;
import com.cdacproject.model.User;
import com.cdacproject.model.UserStatus;

@Service
public class ServiceLayer {
	
@Autowired
XRepository repository;
@Autowired 
FdRepository fdRepository;

	public User register(User user) {
		if (repository.existsById(user.getId())) {
			user.setId(0);
			System.out.println("already user exist="+user.getUserId());

		} else
			repository.save(user);

		return user;
	}


	public User userLogin(String userId, String password) {
		// TODO Auto-generated method stub
		User user;
	
		 user=repository.loginUser(userId,password);
		//System.out.println("list size="+user);
	
		return user;
	}

  
	public Fd fdBooking(Fd fixedDeposite) throws ParseException {
		//Business logic
		// //period sample year-month-day from ui ,ex 0-6-10
	String uId=	fixedDeposite.getUserId();
	String fdAmount= fixedDeposite.getDepositAmount();
	String period= fixedDeposite.getPeriod();
	String interestRate= fixedDeposite.getInterestRate();
	
	String todaysDate=getTodaysDate();
	fixedDeposite.setDateOfBooking(todaysDate);
	//fixedDeposite.setDateOfMaturity("2031-01-01");
	
	String matureAmount=calculateMatureAmount(period,fdAmount,interestRate);
	fixedDeposite.setMaturityAmount(matureAmount);
	
	String maturityDate=getMaturedDate(period);
	fixedDeposite.setDateOfMaturity(maturityDate);
	
	 
		fdRepository.save(fixedDeposite);// Fd booking has been finished.
		updateBalance(fixedDeposite);
		depositeFdAfterCompletionOfMaturity(period,fixedDeposite.getUserId(),fixedDeposite.getDateOfMaturity());
		return fixedDeposite;
	}


	private void depositeFdAfterCompletionOfMaturity(String period,String userId,String maturityDate) {

		int noOfDays=getTotalNoOfDays(period);
		System.out.println("total no of days: "+noOfDays);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				withDradFd(userId,maturityDate);
			}
		},noOfDays*24*60*60*1000 );
		//noOfDays*24*60*60*1000
		//1000*60
	}

	private void withDradFd(String userId, String maturityDate) {

	System.out.println("Inside withDradFd methiod: userId: "+userId+"Date of matyurity: "+maturityDate);	
	Fd dbFd=fdRepository.getFdByUidAndMaturutyDate(userId,maturityDate );
	System.out.println("after thread query"+dbFd);
	fdRepository.delete(dbFd);//deleting fd after fd get matured
	System.out.println("Deleted fd is :"+dbFd);
	//updateBalance(dbFd);
	addMaturityAmountToBalance(dbFd);
		
	}
	
	
	private void addMaturityAmountToBalance(Fd dbfd) {
		      User u= getUserByUserId(dbfd.getUserId());
		      int updateBal=Integer.parseInt(u.getAccount().getBalance())+Integer.parseInt(dbfd.getMaturityAmount());
		      String updateBalStr=String.valueOf(updateBal);
		      u.getAccount().setBalance(updateBalStr);
		      System.out.println("after fd maturity date compl balance="+u);
		      repository.save(u);
	}


	private void updateBalance(Fd fixedDeposite) {
		User dbUser = getUserByUserId(fixedDeposite.getUserId());
		System.out.println("Acount bal is :"+dbUser.getAccount().getBalance());
		System.out.println("Fd amount is : "+fixedDeposite.getDepositAmount());
		int updatedAmount= Integer.parseInt(dbUser.getAccount().getBalance())-Integer.parseInt(fixedDeposite.getDepositAmount());
		String updatedAmountString=String.valueOf(updatedAmount);
		
		//dbUser.setAddress(address);
		dbUser.getAccount().setBalance(updatedAmountString);
		System.out.println("final dbUser is: "+dbUser);
		repository.save(dbUser); //Db row will update
	}


	public User getUserByUserId(String userId) {
		return repository.getUserById(userId);
	}


	private String calculateMatureAmount(String period, String fdAmount, String rate) {
		// TODO Auto-generated method stub
		String matureAmount="";
		//String period="1-6-7";
		try
		{
			String[] str=period.split("-");
			String year=str[0];
			String month=str[1];
			String days=str[2];
			
			int intyr=Integer.parseInt(year);
			int intmonth=Integer.parseInt(month);
			int intdays=Integer.parseInt(days);
			
			int totaldays=(intyr*365)+(intmonth*30)+intdays;
			System.out.println("total days="+totaldays);
			
			int amount=Integer.parseInt(fdAmount);
			
			int r=Integer.parseInt(rate);
			
			int interAmount=(amount*r*totaldays)/(100*365);
			System.out.println("interest amount="+interAmount);
			
			int maturityAmount=interAmount+amount;
			System.out.println("Maturity amount="+maturityAmount);
			
			String interestAmount=String.valueOf(interAmount);
			 matureAmount=String.valueOf(maturityAmount);
			
			System.out.println("string inter amount="+interestAmount);
			System.out.println("string mature amount="+matureAmount);
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 return matureAmount;
		
	}


	private String getTodaysDate() {
		// TODO Auto-generated method stub
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now(); 
		  String stringDate= dtf.format(now);
		   System.out.println("string date"+stringDate);  
		   	
		return stringDate;
	}

	private static String getMaturedDate(String period) throws ParseException {
		int days=getTotalNoOfDays(period);
		System.out.println("Total number off days is: "+days);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateInString =dateFormat.format(date);
		System.out.println("Date of booking in String : "+dateInString);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat.parse(dateInString));		
		System.out.println("Current Date and Time = " + calendar.getTime());
		calendar.add(Calendar.DATE, days);
		System.out.println("Updated time Time = " + calendar.getTime());//In Date format
		String maturedDate=dateFormat.format(calendar.getTime());
	
		return maturedDate;
	}
	
	private static int getTotalNoOfDays(String period) {
		//0-6-10
		String[] daysArr = period.split("-");
		int  days=Integer.parseInt(daysArr[0])*360+Integer.parseInt(daysArr[1])*30+Integer.parseInt(daysArr[2]);
		return days;
	}


	public List<Fd> fdStatement(String userId) {
		// TODO Auto-generated method stub
		
		return fdRepository.fdStatement(userId);
	}
	
}
