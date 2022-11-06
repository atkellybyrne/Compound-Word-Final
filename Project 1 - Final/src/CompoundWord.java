/*
 * Kelly Byrne

 * Started: 10/26/2022
 * 
 * Project 1 Final
 */

// Import Statements
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.*;

public class CompoundWord extends JFrame{
	
	// Private variables
	private JRadioButton rButton1;
	private JRadioButton rButton2;
	private JRadioButton rButton3;
	private JCheckBox cBox1;
	private JCheckBox cBox2;
	private JCheckBox cBox3;
	private JCheckBox cBox4;
	private JCheckBox cBox5;
	private JCheckBox cBox6;
	private static JToggleButton letters[];
	private ArrayList<String> list = new ArrayList<String>();
	private String lev;
	private JButton go;

	// New public CompoundWord()
	public CompoundWord() {
		// Gets all parent objects
		super("Pick the Compound Words");
	
		// New Action
		Action aEvent = new Action();
		
		// New Panel 
		JPanel panel = new JPanel();
		add(panel);
		
		// New layouts and sets the frame to a gridLayout
		FlowLayout gLayout = new FlowLayout();
		BorderLayout bLayout = new BorderLayout();
		setLayout(gLayout);
		
		// Sets the panel to a borderLayout
		panel.setLayout(bLayout);
		
		// Adds a panel for the topic to the north of the borderlayout
		JPanel topicPanel = new JPanel();
		panel.add(topicPanel, BorderLayout.NORTH);
		topicPanel.setLayout(gLayout);
		
		// Makes a new panel for the difficulty to the center of the borderlayout
		JPanel difficultyPanel = new JPanel();
		panel.add(difficultyPanel, BorderLayout.CENTER);
		
		
		// New Label and adds to that frame
		JLabel label1 = new JLabel("Difficulty: ");
		Font font = new Font("Ariel", Font.BOLD,12);
		label1.setFont(font);
		topicPanel.add(label1);
		
		// Makes a new ButtonGroup and adds the other buttons to that group
		ButtonGroup group = new ButtonGroup();
		
		// Makes the buttons with individual ItemListeners
		rButton1 = new JRadioButton("Easy");
		group.add(rButton1);
		topicPanel.add(rButton1);
		rButton1.addItemListener(e -> lev = rButton1.getText());
		
		rButton2 = new JRadioButton("Medium");
		group.add(rButton2);
		topicPanel.add(rButton2);
		rButton2.addItemListener(e -> lev = rButton2.getText());
		
		rButton3 = new JRadioButton("Hard");
		group.add(rButton3);
		topicPanel.add(rButton3);
		rButton3.addItemListener(e -> lev = rButton3.getText());
		
		// New label for the topic
		JLabel label2 = new JLabel("Topics: ");
		label2.setFont(font);
		difficultyPanel.add(label2);
		
		// New Scanner and ArrayList 
		Scanner scan = null; 
	    ArrayList<String> al = new ArrayList<String>(); 
	    
	    // Try Catch for reading into file tags.txt
        try{
    	   scan = new Scanner(new FileReader("tags.txt")); 
    	   
    	   // While there is a next line in the scanner...
    	   while(scan.hasNextLine()){ 
    		   // Add it to the ArrayList
    		   al.add(scan.nextLine()); 

    	   }
    	   
       } catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}finally{
    	 
		if(scan != null){
    		   scan.close();
    	   }
       }

		// Makes a new JCheckBox and adds it to the frame alone with
        // individual ItemListeners
		cBox1 = new JCheckBox(al.get(0));
		difficultyPanel.add(cBox1);
		cBox1.addItemListener(e -> list.add(cBox1.getText()));
	
		cBox2 = new JCheckBox(al.get(1));
		difficultyPanel.add(cBox2);
		cBox2.addItemListener(e -> list.add(cBox2.getText()));
	
		cBox3 = new JCheckBox(al.get(2));
		difficultyPanel.add(cBox3);
		cBox3.addItemListener(e -> list.add(cBox3.getText()));
	
		cBox4 = new JCheckBox(al.get(3));
		difficultyPanel.add(cBox4);
		cBox4.addItemListener(e -> list.add(cBox4.getText()));
	
		cBox5 = new JCheckBox(al.get(4));
		difficultyPanel.add(cBox5);
		cBox5.addItemListener(e -> list.add(cBox5.getText()));
		
		cBox6 = new JCheckBox(al.get(5));
		difficultyPanel.add(cBox6);
		cBox6.addItemListener(e -> list.add(cBox6.getText()));

		setPreferredSize(new Dimension(100,200));
		
		// Makes a new JButton and adds it to the frame
		go = new JButton("Lets go");
		panel.add(go, BorderLayout.SOUTH);
		
		// Adds an ActionListener to the 'go' button
		go.addActionListener(aEvent);
		
	}
	
	
	// New Private Class named MyHandler
	private class Action implements ActionListener{

		// Checks to see if the source of the action and makes a new pane 
		// and executes the action associated with the button
		public void actionPerformed(ActionEvent event) {
			// If the source of the event is the go button...
			if(event.getSource() == go) {
				
				// New int intLev
				int intLev;
				
				// If the level is Easy...
				if(lev.equals("Easy")) {
					// intLev is 1
					intLev = 1;
				}
				// If the level is Medium...
				else if(lev.equals("Medium")) {
					// intLev is 2
					intLev = 2;
				}
				// If the level is anything else...
				else {
					// intLev is 3
					intLev = 3;
				}
			
				// New ArrayList and scanner 
				ArrayList<String> wordsList = new ArrayList<String>();
				Scanner scan = null; 
				
		       // Reads through the file WordList.txt and adds it all to the ArrayList
		       try{
		    	   scan = new Scanner(new FileReader("WordList.txt")); 
		    	   													  
		    	   while(scan.hasNextLine()){ 
		    		   wordsList.add(scan.nextLine()); 
		    	   }
		    	   
		       } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
		    	  if(scan != null){
		    		   scan.close();
		    	   }
		       }
		        
		    // Removes all of the problematic cases
		    wordsList.remove(0);
    	    wordsList.remove(1);
    	    wordsList.remove(2);
   		    wordsList.remove(3);
   		    wordsList.remove(21);
   		    wordsList.remove(31);
   		    wordsList.remove(38);
   		    wordsList.remove(63);
   		    wordsList.remove(64);
   		    wordsList.remove(64);
   		    wordsList.remove(82);
   		    wordsList.remove(82);
   		    wordsList.remove(110);
   		    wordsList.remove(172);
		    
			// New Layout and sets that frame to that layout
			JFrame newFrame = new JFrame();
			newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newFrame.setSize(600,600);
			newFrame.setVisible(true);
			FlowLayout layout = new FlowLayout();
			newFrame.setLayout(layout);
			
			 
			// New Label and adds to that frame
			JLabel label1 = new JLabel("Click on a compound word!");
			newFrame.add(label1);
						
			// New ButtonGroup and JToggleButton
			ButtonGroup group = new ButtonGroup();
			letters = new JToggleButton[wordsList.size()];
			
					
			// Iterates through the list of words...
			for(int i=0; i < wordsList.size(); i++) {

				// The String str is the whole node at each index
				String str = wordsList.get(i); 
				
				// Replaces all non-number characters with spaces
				str = str.replaceAll("[^-1-9]+", " ");
				
				// The String s1 is the substring of str from 0-3
				String s1 = str.substring(0,3);
				
				// Makes it the index value from s1
				int index = Integer.parseInt(s1.strip());
				
				// The String s2 is the substring of str from 3-5
				String s2 = str.substring(3,5);
				
				// Makes it the difficulty value from s2
				int difficulty = Integer.parseInt(s2.strip());
				
				
				// The attributes are the substring from the wherever the value of 'index' is found
				String atts = wordsList.get(i).substring(wordsList.get(i).indexOf(Integer.toString(index))+6);
				
				// If the charAt 0 is whitespace...
				if(atts.charAt(0) == ' ') {
					// Remove the whitespace
					atts = atts.substring(1);
				}
			
				// The word is the substring from 0 to wherever the value 'index' is found
				String word = wordsList.get(i).substring(0, wordsList.get(i).indexOf(Integer.toString(index))-2);
			
				// Print out all test cases to make sure it is running properly
				System.out.println("These are the num1 index and difficulty " + index  + " " + difficulty);
				System.out.println("This the index of the word: " + word);
				System.out.println("This is where it stops: " + i);
				System.out.println("This is the length of letters[]: " + letters.length);
				System.out.println("This is where it should go to: " + wordsList.size());
				System.out.println("This is where the attributes start: " + atts);
				System.out.println("This is where the comma is: " + atts.indexOf(","));
				System.out.println();

				// New object from Word class newWord that takes the attributes 
				// of word, index, and difficulty
				Word newWord = new Word(word, index, difficulty);
				
				// Edits specific cases to properly fix the attributes
				if(atts.indexOf(",") == -1) {
					newWord.setTopic1(atts);
					System.out.println("This is the topic: " + newWord.getTopic1());	
				}
				else {
					newWord.setTopic1(atts.substring(0,atts.indexOf(",")));
					newWord.setTopic2(atts.substring(atts.indexOf(",")+2));					
				}
				
				if(newWord.getWord().equals("podcast")) {
					newWord.setTopic1(atts.substring(0,atts.indexOf(",")));
					newWord.setTopic2(atts.substring(atts.indexOf(",")+2, 24));
					newWord.setTopic3(atts.substring(26));				
				}
				else if(newWord.getWord().equals("playstation")) {
					newWord.setTopic1(atts.substring(0,atts.indexOf(",")));
					newWord.setTopic2(atts.substring(atts.indexOf(",")+2, 19));
					newWord.setTopic3(atts.substring(21));				
				}
				else if(newWord.getWord().equals("outside") || newWord.getWord().equals("outdoor")) {
					newWord.setTopic1(atts.substring(0,atts.indexOf(",")));
					newWord.setTopic2(atts.substring(atts.indexOf(",")+2, 21));
					newWord.setTopic3(atts.substring(23));
				}
				
				
				// If the difficulty of the word is the same as the level...
				if(newWord.getDifficulty() == intLev) {
					// If the list contains the same topics of the word...
					if(list.contains(newWord.getTopic1()) || list.contains(newWord.getTopic2()) 
							|| list.contains(newWord.getTopic3())) {
						
						// Creates new buttons for each instance of i and
						// adds them to the ButtonGroup and the frame
						letters[i] = new JToggleButton(newWord.getWord().toString());
						group.add(letters[i]);
						newFrame.add(letters[i]);
						
						// Makes an itemListener and calls the whetherCompound() method
						letters[i].addItemListener(e -> {
							try {
								whetherCompound(newWord.getWord(), newWord.isCompound(), newWord.getIndex());
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});
						
						}
					}	
				}
			}
		}
	}
	
	// Checks if a parameter is a compound word
		public static void whetherCompound(String word, boolean compound, int index) throws FileNotFoundException {
			// If the compound word list contains the not case-sensitive
			// parameter value...
			if (compound == true) {	
				
				// Run the whereCompound() method to determine where the 
				// second word is
				whereCompound(word, index);
				
			}
			
			// Otherwise...
			else {
				
				// Opens a new JOptionPane which describes if the word is not a compound word
				JOptionPane.showMessageDialog(null, "The word: " + word + 
						" is not a compound word.", "Not Compound", JOptionPane.PLAIN_MESSAGE);
			}

		}

		// Checks where the second word in the compound word starts
		public static void whereCompound(String word, int index)throws FileNotFoundException {
			
			// Makes a new frame and sets it appropriately
			JFrame newFrame = new JFrame();
			newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newFrame.setSize(600,600);
			newFrame.setVisible(true);
			
			// Makes a new layout and sets that to the frame
			FlowLayout layout = new FlowLayout();
			layout.setHgap(3000);
			newFrame.setLayout(layout);
			
			
			// Makes a new label and adds it to the frame
			JLabel label = new JLabel("Click on the letter that the SECOND word in the"
					+ " Compound Word '" + word + "' starts with");
			newFrame.add(label);
			
			// Makes a new ButtonGroup and JToggleButton with the length 
			// of the word.length
			ButtonGroup group = new ButtonGroup();
			letters = new JToggleButton[word.length()];
					
			// Iterates through each character in word
			for(int i=0; i < word.length(); i++) {
				// Sets the text in each button to one each character in word
				// adds it to the ButtonGroup and the frame
				letters[i] = new JToggleButton(String.valueOf(word.charAt(i)));
				group.add(letters[i]);
				newFrame.add(letters[i]);
				
				// Adds an ActionListener to the buttons to detect if 
				// they are selected
				letters[i].addActionListener(new ActionListener() { 
					
					// When the button is pressed...
					  public void actionPerformed(ActionEvent e) { 
						  
						  // If the ActionCommand() is the same as the 
						  // value at where the second word starts...
						  if(String.valueOf(e.getActionCommand()).equals
								  (String.valueOf(word.charAt(index)))) {
							  
							  // Opens a JOption pane to congratulate the user
							  JOptionPane.showMessageDialog(null, "You got it right!", 
									  "Correct Second Word", JOptionPane.PLAIN_MESSAGE);
						  }
						  
						  // Else...
						  else {
							  
							  // Open a JOptionPane to correct the user
							  JOptionPane.showMessageDialog(null, "Try it again. That wasn't correct", 
									  "Incorrect Second Word", JOptionPane.PLAIN_MESSAGE);
						  }
					  } 
				});
					  
			}
		}
	
	
			
	// Main
	public static void main(String[] args) {
		// Makes a new window
		CompoundWord main = new CompoundWord();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(700,700);
		main.setVisible(true);
       
	}
	
}

// END
