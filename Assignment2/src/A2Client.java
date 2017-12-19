/********************************************************************
 * Programmer:	Parmeet Gill
 * Class:       CS30S
 *
 * Assignment:    Assignment 2
 * 
 * Description: program that is supposed to replicate/calculate the data of a olympics race
 * 
 * Input: from the skaterdata file
 * 
 * Output: skater id, average time, race times, average speed,
 *         single race speed
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
 

public class A2Client {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
    
        final int MAX = 10;
        final int offset = 1;
        final int sentinelVal = -1;
        final int secToMin = 60;
    
    // ********** declaration of variables **********
    	
    	String delim = "[ ]+";		// delimiter string for splitting input string
        String delim2 = "[;]+";
        String strin = "";
        String list[] = null;
        int n = 0;
        int times[] = new int[MAX];
        int avgTime = 0;
        double speed = 0;
        int singleTime = 0;
        double avgSpeed = 0;
        int chngTime = 0;
        int chng = 0;
        int races = 0;

    // create instances of objects for i/o and formatting
    
    	//ConsoleReader console = new ConsoleReader(System.in);
    	//DecimalFormat df1 = new DecimalFormat("$##.00");
    	
    	BufferedReader fin = new BufferedReader(new FileReader("skaterData.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("textOutA2.txt")));
        
        ProgramInfo programInfo = new ProgramInfo("Assignment 2");
    	
    // ********** Print output Banner **********
    
    	System.out.println(programInfo.toString());
    	
    // ************************ get input **********************

        strin = fin.readLine();
        
        while(strin != null){
            chng = 0;
            int j = 0;
            list = strin.split(delim);
            
            races = list.length;
            
            A2Object skater = new A2Object(n, list);
          
            for(int i = 0; i < races; i++){
                times[n] = skater.Time(list[i], j);
                speed = skater.singleSpeed(times[n], j);
                
                System.out.println("Race " + (i + offset) + " time: " + list[i]);
                System.out.print("Race " + (i + offset) + " speed: ");
                System.out.format("%.2f", speed);
                System.out.println("Km/h\n");
                
                fout.println("Race " + (i + offset) + " time: " + list[i]);
                fout.print("Race " + (i + offset) + " speed: ");
                fout.format("%.2f", speed);
                fout.println("Km/h\n");
                
                j++;
            } // end for tokens
            
            while (chng != sentinelVal) {
                
                chng = Integer.parseInt(JOptionPane.showInputDialog(
                 "Enter a number to change a time for skater " + skater.newID(n) + "\nOr enter -1 to end the program"));
                
                if (chng == sentinelVal) {
                    break;
                }//end if statement
                
                chngTime = skater.changeTime();
                
                if (races < MAX) {
                    speed = skater.singleSpeed(chngTime, races);
                }//end if
                else {
                    speed = skater.singleSpeed(chngTime, (races - offset));
                }
                
                System.out.format("%.2f", speed);
                System.out.println("Km/h");
                
                fout.format("%.2f", speed);
                fout.println("Km/h");
                } //end while loop

            avgTime = skater.avgTime();
            avgSpeed = skater.avgSpeed();
            
          n++;
          strin = fin.readLine();
        } // end eof loop

        // ******** closing message *********
        
        System.out.println("end of processing");
        fout.println("end of processing");
        
        // ***** close streams *****
        
        fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main
}  // end class
