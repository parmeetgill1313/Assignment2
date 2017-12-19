
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
/* **********************************************************
 * Programmer:	Parmeet Gill
 * Class:       CS30S
 * 
 * Assignment:	Assignment 2 
 *
 * Description:	object for calculating the average time and speed, and race 
                times and speeds, and also to change the race time of a 
                skater object and add a new one
 * *************************************************************
 */
 // import files here as needed
 public class A2Object
 {  // begin class
 	//PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("textOutA2.txt")));
        
 	// *********** class constants **********
            
            private final int MAX = 10; //max of skater times
            private final int secToMin = 60;    //# of seconds in minutes
            private final int distance = 5000;  //5000m in 5km
            private final double MPtoKH = 3.6;  //the number to convert metres/second to kilometers/hour
            private final int offset = 1;   //offset for the new time

 	// ********** instance variable **********
 	
            private int skaterID = 1000;    //the id of the skater
            private int min = 0;    //minutes
            private int sec = 0;    //seconds  
            private int races = 0;  //# of races for a skater
            private int secTime[] = new int[MAX];   //time in seconds
            private double speed[] = new double[MAX];// double for getting speed
            private String delim = "[ ]+";  //delimeter

 	// ********** constructors ***********
 	
            /********************************************************
            * Purpose:       create a new skater 
            *         
            * Interface:
            *     in:         none
            *     out:        none
            ********************************************************/ 
            
            public A2Object(int s, String list[]) {
                skaterID = this.newID(s);
                System.out.println("Skater: " + skaterID);
                
                
                races = list.length;
            }
 	// ********** accessors **********
            
            /********************************************************
            * Purpose:        new ID for the skater object
            *         
            * Interface:
            *     in:         int s for increasing skaterID
            *     out:        ID for skater object
            ********************************************************/
            public int newID (int s) {
                int ID = 1000 + s;
                return ID;
            }

            /********************************************************
            * Purpose:        parse the time of the skater
            *         
            * Interface:
            *     in:         none
            *     out:        single time
            ********************************************************/ 
            public int Time (String list, int j) {
                
                String[] time = list.split("[:]+");
                min = Integer.parseInt(time[0]);
                sec = Integer.parseInt(time[1]);
                
                sec = sec + (min * secToMin);
                
                secTime[j] = sec;
                return sec;
            }

            /********************************************************
            * Purpose:        finds average time of the skater
            *         
            * Interface:
            *     in:         string of times
            *     out:        average time 
            ********************************************************/ 
            public int avgTime() {
                int avgTime = 0;
                int totSec = 0;
                
                for (int i = 0; i < races; i++) {
                    totSec += secTime[i];
                }
                
                avgTime = totSec / races;
                
                
                System.out.print("Average time: " + (avgTime/secToMin) 
                        + ":");
                System.out.format( (avgTime%secToMin) + "\n");
                
                return avgTime;
            }

            /********************************************************
            * Purpose:        the average speed of the skater
            *         
            * Interface:
            *     in:         times
            *     out:        average speed 
            ********************************************************/ 
            public double avgSpeed() {
                double avgSpeed = 0;
                double totSpeed = 0;

                
                for (int n = 0; n < races; n++) {
                    totSpeed += speed[n];
                }
                
                avgSpeed = totSpeed / races;
                
                System.out.print("Average speed: ");
                System.out.format("%.2f", avgSpeed);
                System.out.println("Km/h\n");
                
                return avgSpeed;
            }
            
            
            /********************************************************
            * Purpose:        find the speed of the skater
            *         
            * Interface:
            *     in:         time of race
            *     out:        speed of skater in race 
            ********************************************************/ 
            public double singleSpeed(double n, int j) {
                double singleSpeed = 0;
                
                singleSpeed = distance/n * MPtoKH;
                
                speed[j] = singleSpeed;
                
                return singleSpeed;
            }

 	// ********** mutators **********
            
            public int changeTime(){
                String chngTo = ""; 
                int chngMin = 0;    //changing minutes
                int chngSec = 0;    //changing seconds
                int chngTotSec = 0; //changing total seconds
                
                
                chngTo = JOptionPane.showInputDialog(
                        "What time do you want to add (ex: 7:15)");
                
                String[] chan = chngTo.split("[:]+");
                
                chngMin = Integer.parseInt(chan[0]);
                chngSec = Integer.parseInt(chan[1]);
                chngTotSec = (chngMin * secToMin) + chngSec;
                
                if (races < 10){ 
                    secTime[races] = chngTotSec;
                    
                    min = secTime[races] / secToMin;
                    sec = secTime[races] % secToMin;
                    
                    System.out.print("You have changed race time " 
                        + (races + offset) + " to " );
                    System.out.format("%2s", (secTime[races]/secToMin) + ":"); 
                    System.out.format("%2s", (secTime[races]%secToMin) + "\n");
                    
                    System.out.print("Average race " + (races + offset) + " speed: ");
                    System.out.println("************************************");
                    
//                    fout.print("You have changed race time " 
//                        + (races + offset) + " to " );
//                    fout.format("%2s", (secTime[races]/secToMin) + ":"); 
//                    fout.format("%2s", (secTime[races]%secToMin) + "\n");
//                    
//                    fout.print("Average race " + (races + offset) + " speed: ");
                    races = races + offset;
                }//end if
                
                else {
                    for (int i = 1; i < races; i++) {
                        secTime[(races - offset) - i] = secTime[races - offset];
                    }
                    secTime[races - offset] = chngTotSec;
                    
                    min = secTime[races-offset] / secToMin;
                    sec = secTime[races-offset] % secToMin;
                    
                    System.out.print("You have changed race time " 
                        + (races) + " to " );
                    System.out.format("%2s", 
                            (secTime[races-offset]/secToMin) + ":"); 
                    System.out.format("%2s", 
                            (secTime[races-offset]%secToMin) + "\n");
                    
                    System.out.print("Average race " + races + " speed: ");
                    
                    
//                    fout.print("You have changed race time " 
//                        + (races) + " to " );
//                    fout.format("%2s", 
//                            (secTime[races-offset]/secToMin) + ":"); 
//                    fout.format("%2s", 
//                            (secTime[races-offset]%secToMin) + "\n");
//                    
                   // fout.print("Average race " + races + " speed: ");
                }//end else
                
                return chngTotSec;
            }//end  change time
            
        // ***** close streams *****
         //fin.close();			// close input buffer
         //fout.close();			// close output buffer
 }  // end class