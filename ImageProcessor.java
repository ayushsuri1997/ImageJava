import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class imageProcessingApplet extends JFrame implements ActionListener{
	
	JPanel cards,signup,welcome,processPage,result;
	
	//elements on signup page
	JLabel sl;
	JLabel heading;
	JLabel p;
	JButton signupButton;
	JTextField name;
	
	//elements on process page
	JLabel chooseFile;
	JButton process;
	JButton browse;	
	JLabel t;
		
	//welcome page
	JLabel wel;
	JLabel ps1;
	JLabel ps2;
	JLabel ps3;
	JButton cont;	
	
	//result page
	JLabel res;
	JLabel t1;
	JButton back;
	JLabel img;
	JLabel tr;
	
	//backend variables
	String username="";
	CardLayout c;
	
	final JFileChooser fc = new JFileChooser();
	String filename="null";
	
	imageProcessingApplet(String title)
	{
		super(title);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
		
		this.setSize(1000,720);
		this.setResizable(false);
		
		signup=new JPanel();
		signup.setLayout(null);
		
		processPage=new JPanel();
		processPage.setLayout(null);
		
		result=new JPanel();
		result.setLayout(null);
		
		welcome=new JPanel();
		welcome.setLayout(null);
		
		c = new CardLayout();
		cards = new JPanel();
		cards.setLayout(c);		
		this.add(cards);
		
		signup.setBackground(new Color(29,38,53));
		welcome.setBackground(new Color(29,38,53));
		processPage.setBackground(new Color(29,38,53));
		result.setBackground(new Color(29,38,53));
				
		//SIGNUP PAGE		
		heading = new JLabel("IMAGE PROCESSOR");
		heading.setFont(new Font("Helvetica" , Font.PLAIN , 50));
		heading.setBounds(250 , 100, 800 , 40);
		heading.setForeground(new Color(147,242,20));
		signup.add(heading);

		p=new JLabel("Enter your name:");
		p.setBounds(250  , 250 ,  500 , 30);
		p.setFont(new Font("Helvetica" , Font.PLAIN , 20));
		p.setForeground(new Color(4,159,168));
		signup.add(p);
		
		name=new JTextField(50);
		name.setBounds(250  , 300 ,  500 , 30);
		name.setFont(new Font("Helvetica" , Font.PLAIN , 20));
		signup.add(name);
		
		signupButton = new JButton("SIGN IN");
		signupButton.setBounds(450 , 400 , 90 , 50);
		signupButton.setEnabled(true);
		
		signupButton.setBackground(new Color(4,159,168));
		signupButton.setForeground(Color.white);
		
		signupButton.addActionListener(this);
		
		signup.add(signupButton);
				
		cards.add(signup);
		
		//WELCOME PAGE		
		wel = new JLabel();
		wel.setFont(new Font("Helvetica" , Font.PLAIN , 30));
		wel.setBounds(400 , 20, 400 , 40);
		welcome.add(wel);
		
		ps1 = new JLabel("Welcome to the Elite Image Processor. In this application, you can input");
		ps1.setFont(new Font("Helvetica" , Font.PLAIN , 20));
		ps1.setBounds(200 , 100, 800 , 40);
		ps1.setForeground(new Color(4,159,168));
		welcome.add(ps1);
		ps2 = new JLabel("any image of your choice and our processor shall tell you whether there");
		ps2.setFont(new Font("Helvetica" , Font.PLAIN , 20));
		ps2.setBounds(200 , 140, 800 , 40);
		ps2.setForeground(new Color(4,159,168));
		welcome.add(ps2);
		ps3 = new JLabel("is day in the image or night!");
		ps3.setFont(new Font("Helvetica" , Font.PLAIN , 20));
		ps3.setBounds(200 , 180, 800 , 40);
		ps3.setForeground(new Color(4,159,168));
		welcome.add(ps3);
						
		cont = new JButton("CONTINUE");
		cont.setBounds(450 , 400 , 100 , 50);
		cont.setEnabled(true);
		cont.setBackground(new Color(4,159,168));
		cont.setForeground(Color.white);
		
		cont.addActionListener(this);
				
		welcome.add(cont);
						
		cards.add(welcome);		
		
		//PROCESS PAGE
		chooseFile = new JLabel("CHOOSE FILE");
		chooseFile.setFont(new Font("Helvetica" , Font.PLAIN , 30));
		chooseFile.setBounds(420 , 20, 400 , 40);
		chooseFile.setForeground(new Color(147,242,20));
		processPage.add(chooseFile);
		
		browse=new JButton("Browse");
		browse.setBounds(350 , 170 , 90 , 50);		
		browse.addActionListener(this);
		browse.setBackground(new Color(4,159,168));
		browse.setForeground(Color.white);
		processPage.add(browse);
		
		process=new JButton("Process");
		process.setBounds(550 , 170 , 90 , 50);
		process.addActionListener(this); 
		process.setBackground(new Color(4,159,168));
		process.setForeground(Color.white);
		processPage.add(process);
		
		t=new JLabel("Choose the image file you want to process");
		t.setFont(new Font("Helvetica" , Font.PLAIN , 20));
		t.setBounds(320 , 80, 400 , 40);
		t.setForeground(new Color(4,159,168));
		processPage.add(t);
				
		cards.add(processPage);
		
		//RESULT PAGE
		res = new JLabel("RESULT");
		res.setFont(new Font("Helvetica" , Font.PLAIN , 30));
		res.setBounds(440 , 20, 400 , 40);
		res.setForeground(new Color(147,242,20));
		result.add(res);
		
		tr=new JLabel("The image shows:");
		tr.setFont(new Font("Helvetica" , Font.PLAIN , 15));
		tr.setBounds(250 , 100, 400 , 40);
		tr.setForeground(new Color(4,159,168));
		result.add(tr);
		
		t1=new JLabel();
		t1.setFont(new Font("Helvetica" , Font.PLAIN , 20));
		t1.setBounds(250 , 150, 400 , 40);
		result.add(t1);
		
		img=new JLabel();
		img.setPreferredSize(new Dimension(500,400));
		img.setBounds(250 , 200, 500 , 400);
		result.add(img);
		
		back = new JButton("BACK");
		back.setBounds(450 , 620 , 100 , 50);
		back.setEnabled(true);
		back.addActionListener(this);
		
		back.setBackground(new Color(4,159,168));
		back.setForeground(Color.white);
		
		result.add(back);
		
		cards.add(result);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==signupButton)
		{
			if(!name.getText().isEmpty())
			{
				username=name.getText();
				wel.setText("Welcome, "+username);
				wel.setForeground(new Color(147,242,20));
				c.next(cards);
			}
		}
		else if(e.getSource()==cont)
		{
			c.next(cards);
		}
		else if(e.getSource()==back)
		{			
			c.previous(cards);
		}
		else if(e.getSource()==process)
		{
			if(filename!="null")
			{
				c.next(cards);
				try
				{
					t1.setText("Processing...");
					getStatus();
				}
				catch(IOException ex)
				{
					System.out.println(ex);
				}
			}
			else
			{
				t.setText("Please choose a filename");
			}
		}
		else if(e.getSource()==browse)
		{
			int returnVal = fc.showOpenDialog(this);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            filename=file.getName();
	        }
		}
		
	}
	
	public void getStatus()throws IOException{
		
		BufferedImage image=null;
		File f=null;
		
		try{
			f=new File("D:\\Images\\"+filename);
			
			image=ImageIO.read(f);
			
			int width=image.getWidth();
			int height=image.getHeight();
			
			int bright=0;//number of bright pixels
			int dark=0;//number of dark pixels
						
			for(int x=0;x<width;x++)
			{
				//getting x coordinate with x
				for(int y=0;y<height;y++)
				{
					//getting y coordinate with y
					
					//getting the pixel
					int p=image.getRGB(x,y);
					
					//getting rgb values
					int r=(p>>16) & 0xff;
					int g=(p>>8) & 0xff;
					int b=p & 0xff;
					
					//getting the luminance
					double l=0.2126*r + 0.7152*g + 0.0722*b;
					 
					if(l>80)
					{
						bright+=1;
					}
					else
					{
						dark+=1;
					}
				}
			}

			if(bright>dark)
			{
				t1.setText("DAY TIME");
				t1.setForeground(new Color(147,242,20));
			}
			else 
			{
				t1.setText("NIGHT TIME");
				t1.setForeground(new Color(147,242,20));
			}

			//image preview
			Image i=image.getScaledInstance(500,400,BufferedImage.SCALE_FAST);
			img.setIcon(new ImageIcon(i));

		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public static void main(String args[])
	{
		imageProcessingApplet ob=new imageProcessingApplet("Image Processor");
	}
}

