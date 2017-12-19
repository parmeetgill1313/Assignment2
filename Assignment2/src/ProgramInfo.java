/* **********************************************************
 * Programmer:      Parmeet Gill
 * Class:           CS30S
 * 
 * Assignment:      Lab 2.1 Program Info
 *
 * Description:     
 * *************************************************************
 */
 
 // import files here as needed

public class ProgramInfo {  // begin class
 	
 	// *********** class variables *********
     
                public static String assignmentData;
                public static String questionData = "";

 	// ********** instance variable **********
     
 	// ********** constructors ***********
                
           /***************************************************
            * Purpose:    print banner with assignment & question
            * Interface:
            * in:         none
            * return      only print the name and class data
            ****************************************************/
            public ProgramInfo(){
                assignmentData = "";
            }//end default constructors    
            
           /***************************************************
           * Purpose:    print banner with assignment name
           * Interface:
           * in:         none
           * return      get assignment name only
           ****************************************************/
            public ProgramInfo(String a){
                assignmentData = a;
                
            }//end initialized constructor
            
            /***************************************************
           * Purpose:    print banner with assignment name and
           *             question
           * Interface:
           * in:         none
           * return      get assignment name, and question
           ****************************************************/
            public ProgramInfo(String a, String b){
                assignmentData = a;
                questionData = b;
                
            }//end initialized constructor
            
 	// ********** accessors **********
            
            
            public String getAssignment(){
                String assignment = assignmentData;
                return assignment;
            }
            
            public String getClassData() {
                String classData = "CS30S";
                return classData;
            }
            
            public String getName(){
                String nameData = "Parmeet Gill";
                return nameData;
            }
            
            public String getQuestion() {
                return questionData;
            }
            
            public String toString(){
                String programInfo;
                programInfo =  "*********************************\n";
                programInfo += "Name:        " + this.getName() + "\n";
		programInfo += "Class:       " + this.getClassData() + "\n";
		programInfo += "Assignment: " + this.getAssignment() + " " + this.getQuestion() + "\n";
		programInfo += "***********************************";
                return programInfo;
            }
            
            public String endProgram(){
                String endProgram = "end of processing";
                return endProgram;
            }
            
 	// ********** mutators **********
        
 }  // end class