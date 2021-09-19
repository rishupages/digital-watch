package digitalClockProject;

import java.util.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


//MyWindow class creation and pre-defined class(JFrame) inherit
public class MyWindow extends JFrame
{
	
	//create JLabel class Object heading(object name)
	private JLabel heading;
	
	//create JLabel class Object clockLabel(object name)
	private JLabel clockLabel1;
	private JLabel clockLabel2;
	
	//create Font class Object font(object name) with Font-family, Font-style, Font-size
	private Font font = new Font("",Font.BOLD,35);
	
	
	MyWindow()  //constructor define
	{
		//Set Title on title bar(top-left)
		super.setTitle("My clock");  //without super it works similar
		
		
		//Set Size of frame(width,Height)
		super.setSize(500,500);
		
		
		//set X and Y position of frame
		super.setLocation(250, 100);
		
		
		//call createGUI method
		this.createGUI();
		
		//Set Visibility, if false then not visible
		super.setVisible(true);
		
	}
	
	//user-defined createGUI method for gui
	public void createGUI()
	{
		//memory allocation through new keyword and pass MY clock(anything)
		heading = new JLabel("My Clock");
		
		
		//memory allocation through new keyword and pass clock 
		clockLabel1 = new JLabel("Time");
		clockLabel2 = new JLabel("Day");
		
		//set font size in heading and clockLabel
		heading.setFont(font);
		clockLabel1.setFont(font);
		clockLabel2.setFont(font);
		
		
		this.startClock();
		
		//set Layout with grid(row,column)
		this.setLayout(new GridLayout(3,1)); //grid divide container into rows nd columns(rows,columns)
		
		
		//add heading in layout
		this.add(heading);
		
		
		//add clockLabel in layout
		this.add(clockLabel1);
		
		this.add(clockLabel2);
	}
	
	
//	//user-defined method startClock Method
	public void startClock()
{
//		/* Timer is class that call actionPerformed method of ActionListner interface after some time duration */
//		Timer timer = new Timer(1000, new ActionListener()
//		{
//
//			@Override
//			public void actionPerformed(ActionEvent e) 
//			{
//				
//				
////				create Date class object. Date is a class present into java.util package
////				String dateTime = new Date().toString(); //find date and change into string
//				
//				
////				//Another way to find date in local format
////				String dateTime = new Date().toLocaleString();
//				
//				
//				//Another way to find date
//				Date date = new Date();
//				
//
////				Format date manually. SimpledateFormat is pre-defined class
//				SimpleDateFormat time = new SimpleDateFormat("hh : mm : ss a");
//				SimpleDateFormat day = new SimpleDateFormat("EE : MM : YYYY");
//
//				
//				String dateTime = time.format(date);
//				String dateDay = day.format(date);
//
//				
//				//update clockLabel
//				clockLabel1.setText(dateTime);
//				clockLabel2.setText(dateDay);
//				
//				
//			}
//			
//		});
//		timer.start();
//				

		//USING THREAD
		Thread threadObj = new Thread()
			{
				public void run()
				{
					try
					{
						while(true)
						{
//							Another way to find date
							Date date = new Date();
							
			
//							Format date manually. SimpledateFormat is pre-defined class
							SimpleDateFormat time = new SimpleDateFormat("hh : mm : ss a");
							SimpleDateFormat day = new SimpleDateFormat("EE : MM : YYYY");
			
							
							String dateTime = time.format(date);
							String dateDay = day.format(date);
			
							
//							update clockLabel
							clockLabel1.setText(dateTime);
							clockLabel2.setText(dateDay);
//							
							
							Thread.sleep(1000);
							
						}
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			};
		threadObj.start();
	}
}






