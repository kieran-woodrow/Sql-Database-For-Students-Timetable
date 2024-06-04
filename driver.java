package driver;

import java.sql.*; //HAVE TO IMPORT. IT PROVIDES THE API FOR ACCESSING AND PROCESSING INFO FROM A DATABASE
import java.util.Scanner; //USED TO GET USER IMPUT FROM CONSOLE
import java.util.*; 




public class driver
{
                    //1. THIS FUNCTION QUERYS THE DATABASE AND ADDS A STUDENT TO THE DATABASE
    /*---------------------------------------------------------------------------------------------------------------*/  
    public void  addStudent(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will add a student to the database");
        System.out.println(" ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println("Enter the student number excluding the letter (eg 12345678)");
        Integer studentNumber=in.nextInt(); //HOLDS STUDENT NUMBER OF STUDENT
        in.nextLine();
        System.out.println(" ");
        System.out.println("Enter the student's first name (eg John) ");
        String firstName=in.nextLine(); //HOLDS FIRST NAME OF STUDENT
        System.out.println(" ");
        System.out.println("Enter the student's last name (eg Doe) ");
        String lastName=in.nextLine(); //HOLDS LAST NAME OF STUDENT
        System.out.println(" ");
        System.out.println("Enter how many years the student has been at Tuks (so if a first year-0, if second year-1 etc");
        Integer year=in.nextInt(); //HOLDS YEAR OF STUDENT
        //in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT
            

            String query = "INSERT INTO `student`(Student_Number, first_Name, last_Name, years_Completed)" + "VALUES(?, ?, ?, ?)";//THE SQL QUERY
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, studentNumber);//SET THE VALUE OF STUDENT TO POSITION 1 (FIRST QUESTION MARK )
            preparedStmt.setString(2, firstName);//SET THE VALUE OF FIRSTNAME TO POSITION 2 (SECOND QUESTION MARK )
            preparedStmt.setString(3, lastName);//SET THE VALUE OF LASTNAME TO POSITION 3 (THIRD QUESTION MARK )
            preparedStmt.setInt(4, year);//SET THE VALUE OF LASTNAME TO POSITION 4 (FORTH QUESTION MARK )
            preparedStmt.execute();System.out.println(" ");//THIS EXECTUES THE ADDING 
            System.out.println("ADDED SUCCESSFULLY");
            System.out.println(" ");
        
        String query1 = "SELECT Student_Number, first_Name, last_Name, years_Completed  from `student` where Student_Number="+studentNumber;
        ResultSet rs=stmt.executeQuery(query1); //STORE AS AN 'OBJECT'
        System.out.println("This query pulls the newly added info from the database to show that it was added successfully ");
            
        while(rs.next())//GOES UNTIL THE LAST VARIABLE FROM THE QUERY
        {
            Integer a=rs.getInt("Student_Number");//GET STUDENT NUMBER FROM UNDER STUDENT NUMBER COLOUMN IN THE TABLE
            String b=rs.getString("first_Name");
            String c=rs.getString("last_Name");
            Integer d=rs.getInt("years_Completed");
            System.out.format("%s, %s, %s, %s\n", a, b, c, d);//PRINTS OUT THE FORMAT
            System.out.println(" ");
        }

    }
                                            // END OF FUNCTION 1
    /*---------------------------------------------------------------------------------------------------------------*/  



                        //2. THIS FUNCTION QUERYS THE DATABASE AND ADDS A VENUE TO THE DATABASE
    /*---------------------------------------------------------------------------------------------------------------*/  
    public void  addVenue(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will add a venue to the database");
        System.out.println(" ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println("Enter the Venue name (eg Thuto 1-2) ");
        String venueName=in.nextLine(); //HOLDS VENUE NAME 
        System.out.println(" ");
        System.out.println("Enter the Venue Lecture Capacity-the actual number (eg 300) ");
        System.out.println(" ");
        Integer lectureCapacity=in.nextInt(); //HOLDS LECTURE CAPACITY
        System.out.println(" ");
        System.out.println("Enter the Venue Exam Capacity-the actual number (eg 150) ");
        Integer examCapacity=in.nextInt(); //HOLDS EXAM CAPACITY
        in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT

            String query = "INSERT INTO `venue`( venue_Name, Capacity, ExamCapacity)" + "VALUES(?, ?, ?)";//THE SQL QUERY
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, venueName);
            preparedStmt.setInt(2, lectureCapacity);
            preparedStmt.setInt(3, examCapacity);
            preparedStmt.execute();System.out.println(" ");
            System.out.println("ADDED SUCCESSFULLY");
            System.out.println(" ");
        
        String query1 = "SELECT venue_Name, Capacity, ExamCapacity from `venue` where venue_Name='"+venueName+"'";
        ResultSet rs=stmt.executeQuery(query1); //STORE AS AN 'OBJECT'
        System.out.println("This query pulls the newly added info from the database to show that it was added successfully ");
            
        while(rs.next())
        {
            String b=rs.getString("Venue_Name");
            Integer c=rs.getInt("Capacity");
            Integer d=rs.getInt("ExamCapacity");
            System.out.format("%s, %s, %s\n", b, c, d);
            System.out.println(" ");
        }

    }
                                            // END OF FUNCTION 2
    /*---------------------------------------------------------------------------------------------------------------*/  


                        //3. THIS FUNCTION QUERYS THE DATABASE AND ADDS A MODULE TO THE DATABASE
    /*---------------------------------------------------------------------------------------------------------------*/  
    public void  addModule(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will add a module to the database");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println("");
        System.out.println("Enter the module code (eg COS132) ");
        String moduleCode=in.nextLine().toUpperCase(); //HOLDS MODULE NUMBER 
        System.out.println("");
        System.out.println("Enter the description of the module (Data Structures and Algorithms) ");
        String description=in.nextLine(); //HOLDS YEAR
        System.out.println("");
        System.out.println("Enter the year the module is taken in (1/2/3) ");
        Integer year=in.nextInt(); //HOLDS SEMESTER
        in.nextLine();
        System.out.println(" ");
        System.out.println("Enter the semester the module is taken in (First/Second) ");
        String semester=in.nextLine(); //HOLDS MODULE CODE
        System.out.println(" ");
        System.out.println("Enter the module capacity (The actual number) ");
        Integer capacity=in.nextInt(); //HOLDS MODULE 
        System.out.println(" ");
        in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT

            String query = "INSERT INTO `module`(module_Code, description, module_Year, module_Semester, module_Capacity)" + "VALUES(?, ?, ?, ?, ?)";//THE SQL QUERY
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, moduleCode);
            preparedStmt.setString(2, description);
            preparedStmt.setInt(3, year);
            preparedStmt.setString(4, semester);
            preparedStmt.setInt(5, capacity);
            
            preparedStmt.execute();
            System.out.println(" ");
            System.out.println("ADDED SUCCESSFULLY");
            System.out.println(" ");
        
        String query1 = "SELECT module_Code, description, module_Year, module_Semester, module_Capacity from `module` where module_Code='"+moduleCode+"'";
        ResultSet rs=stmt.executeQuery(query1); //STORE AS AN 'OBJECT'
        System.out.println("This query pulls the newly added info from the database to show that it was added successfully ");
            
        while(rs.next())
        {
            String a=rs.getString("module_Code");
            String b=rs.getString("description");
            Integer c=rs.getInt("module_Year");
            String d=rs.getString("module_Semester");
            Integer e=rs.getInt("module_Capacity");
            System.out.format("%s, %s, %s, %s, %s\n", a, b, c, d, e);
            System.out.println(" ");
        }

    }
                                             // END OF FUNCTION 3
    /*---------------------------------------------------------------------------------------------------------------*/ 
    
    

                   //4. THIS FUNCTION QUERYS THE DATABASE AND ADDS A TEST (Sem Test 1) TO THE DATABASE
    /*---------------------------------------------------------------------------------------------------------------*/ 
    public void  addAssessment(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will add a semester test or Exam to the database");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println(" ");
        System.out.println("Enter the Module Code for the test (eg COS132) ");
        String moduleCode=in.nextLine().toUpperCase(); //HOLDS MODULE CODE
        System.out.println(" ");
        System.out.println("Enter the Venue for the test. Watch spacing and capital leters (eg. Thuto 1-2, Centenary 1) ");
        String moduleVenue=in.nextLine(); //HOLDS MODULE VENUE
        System.out.println(" ");
        System.out.println("Enter the Assessmnet type (Sem test 1/2/3, Examination or Supp Exam) ");
        String assessment=in.nextLine(); //HOLDS MODULE VENUE
        System.out.println(" ");
        System.out.println("Enter the Date for the test (yyyy-mm-dd) ");
        String moduleDate=in.nextLine(); //HOLDS DATE
        System.out.println(" ");
        System.out.println("Enter the Time for the test (hh:mm) ");
        String moduleTime=in.nextLine(); //HOLDS TIME
        System.out.println(" ");
     
        in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT

            String query = "INSERT INTO `assessment`(module_Code, venue_name, assessment_Type, assessment_Date, assessment_Time)" + "VALUES(?, ?, ?, ?, ?)";//THE SQL QUERY
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, moduleCode);
            preparedStmt.setString(2, moduleVenue);
            preparedStmt.setString(3, assessment);
            preparedStmt.setString(4, moduleDate);
            preparedStmt.setString(5, moduleTime);
            preparedStmt.execute();
            System.out.println(" ");
            System.out.println("ADDED SUCCESSFULLY");
            System.out.println(" ");
        
        String query1 = "SELECT module_Code, venue_name, assessment_Type, assessment_Date, assessment_Time from `assessment` where module_Code='"+moduleCode+"' and venue_name='"+moduleVenue+"' and assessment_Type='"+assessment+"'";
        ResultSet rs=stmt.executeQuery(query1); //STORE AS AN 'OBJECT'
        System.out.println("This query pulls the newly added info from the database to show that it was added successfully ");
            
        while(rs.next())
        {
            String a=rs.getString("module_Code");
            String b=rs.getString("venue_Name");
            String c=rs.getString("assessment_Type");
            String d=rs.getString("assessment_Date");
            String e=rs.getString("assessment_Time");
            System.out.format("%s, %s, %s, %s, %s,\n", a, b, c, d, e);
            System.out.println(" ");
        }

    }
                                            //. END OF FUNCTION 4
    /*---------------------------------------------------------------------------------------------------------------*/ 


                        //5. THIS FUNCTION QUERYS THE DATABASE AND ADDS A LECTURE TO THE DATABASE
    /*---------------------------------------------------------------------------------------------------------------*/ 
    public void  addLecture(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will add a Lecture to the database");
        System.out.println(" ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println("Enter the Module Code (eg COS132) ");
        String moduleCode=in.nextLine().toUpperCase(); //HOLDS MODULE CODE
        System.out.println(" ");
        System.out.println("Enter the Venue Name (eg. Thuto 1-2, Centenary 1) ");
        String moduleVenue=in.nextLine(); //HOLDS GROUP
        System.out.println(" ");
        System.out.println("Enter the Lecture Lesson (1/2/3/4) ");
        Integer moduleLesson=in.nextInt(); //HOLDS LESSON
        in.nextLine();
        System.out.println(" ");
        System.out.println("Enter the module group for the lecture (eg G01/G02) ");
        String moduleGroup=in.nextLine(); //HOLDS DATE
        System.out.println(" ");
        System.out.println("Enter the Time of the lecture (hh:mm) ");
        String moduleTime=in.nextLine(); //HOLDS TIME
        System.out.println(" ");
        System.out.println("Enter the Day of the lecture (eg. Tuesday) ");
        String moduleDay=in.nextLine(); //HOLDS MODULE VENUE
        System.out.println(" ");
        in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT

            String query = "INSERT INTO `lecture`(module_Code, venue_Name, lesson, l_Group, l_Time, l_Day)" + "VALUES(?, ?, ?, ?, ?, ?)";//THE SQL QUERY
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, moduleCode);
            preparedStmt.setString(2, moduleVenue);
            preparedStmt.setInt(3, moduleLesson);
            preparedStmt.setString(4, moduleGroup);
            preparedStmt.setString(5, moduleTime);
            preparedStmt.setString(6, moduleDay);
            preparedStmt.execute();
            System.out.println(" ");
            System.out.println("ADDED SUCCESSFULLY");
            System.out.println(" ");
        
        String query1 = "SELECT module_Code, venue_Name, lesson, l_Group, l_Time, l_Day from `lecture` where module_Code='"+moduleCode+"' and venue_Name='"+moduleVenue+"' and l_Group='"+moduleGroup+"'";
        ResultSet rs=stmt.executeQuery(query1); //STORE AS AN 'OBJECT'
        System.out.println("This query shows the info of the new module added into the database");
            
        while(rs.next())
        {
            String a=rs.getString("module_Code");
            String b=rs.getString("venue_Name");
            String c=rs.getString("lesson");
            String d=rs.getString("l_Group");
            String e=rs.getString("l_Time");
            String f=rs.getString("l_Day");
            System.out.format("%s, %s, %s, %s, %s, %s\n", a, b, c, d, e, f);
            System.out.println(" ");
        }

    }
                                    // END OF FUNCTION 5
    /*---------------------------------------------------------------------------------------------------------------*/ 

     
                    //6. THIS FUNCTION QUERYS THE DATABASE AND RETURNS ALL STUDENTS REGISTERED FOR A MODULE 
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  showStudentsForAModule(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will return students who are registered a certain module ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println(" ");
        System.out.println("Enter module with code (eg COS132)");
        String moduleName=in.nextLine().toUpperCase(); //HOLDS USER IMPOUT
        in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT

            String reg="registered";
            String query = "select student.Student_Number, first_Name, last_Name from student, student_Module_Future_Year where student.Student_Number=student_Module_Future_Year.student_Number and stat='"+reg+"' and  module_Code='"+moduleName+"'";//THE SQL QUERY
            ResultSet rs=stmt.executeQuery(query); //STORE AS AN 'OBJECT'
            System.out.println(" ");
            System.out.println("These are the students that are registered for the module '" + moduleName +"'");
            System.out.println(" ");
            
        while(rs.next())
        {
            String id=rs.getString("Student_Number");
            String firstname=rs.getString("first_Name");
            String lastname=rs.getString("last_Name");
            System.out.format("%s, %s, %s\n", id, firstname, lastname);
            System.out.println(" ");
        }
    }
                                            // END OF FUNCTION 6
    /*---------------------------------------------------------------------------------------------------------------*/ 
        

                   //7. THIS FUNCTION QUERYS THE DATABASE AND RETURNS ALL PREREQUISITES FOR A MODULE 
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  getModulePrerequisite(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will return the prerequisites for a certain module ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println(" ");
        System.out.println("Enter module with code (eg COS132)");
        String moduleName=in.nextLine().toUpperCase(); //HOLDS USER IMPUT
        in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT
        Vector<String> prereqModules=new Vector<String>();

            String query = "select prereq from prerequisite where  module_Code='"+ moduleName +"'";//THE SQL QUERY
            ResultSet rs=stmt.executeQuery(query); //STORE AS AN 'OBJECT'
            System.out.println(" ");
            System.out.println("This is/ these are the prerequisite(s) for the module '" + moduleName +"'");
            System.out.println(" ");

            while(rs.next())
            {
                String answer=rs.getString("prereq");
                prereqModules.add(answer);
            }

            for(int x=0; x<prereqModules.size(); x++)
            {
                String answer=prereqModules.get(x);
                System.out.format("%s\n", answer);
                System.out.println(" ");

                
            }
    }
                                            // END OF FUNCTION 7
    /*---------------------------------------------------------------------------------------------------------------*/ 

      

        //8. THIS FUNCTION QUERYS THE ALLOWS/DOESN'T ALLOW STUDENT TO REGISTER FOR A CERTAIN MODULE BASED ON SPACE
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  moduleRegisterprereq(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will register the student if he/she met the prerequisite ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println(" ");
        System.out.println("Enter module with code (eg COS132)" );
        String moduleName=in.nextLine().toUpperCase(); //HOLDS USER IMPOUT
        System.out.println(" ");
        System.out.println("Enter the student number-without the letter (eg 12345678) ");
        String studentNumber=in.nextLine(); //HOLDS USER IMPOUT
        //in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT
        System.out.println(" ");
        Vector<String> prereqModules=new Vector<String>();
        Vector<String> status=new Vector<String>();


        String query = "select prereq from prerequisite where  module_Code='"+ moduleName +"'";//THE SQL QUERY
            ResultSet rs=stmt.executeQuery(query); //STORE AS AN 'OBJECT'
            System.out.println(" ");
            System.out.println("This is/ these are the prerequisite(s) for the module '" + moduleName +"'");
            System.out.println(" ");

            while(rs.next())
            {
                String answer=rs.getString("prereq");
                prereqModules.add(answer);
            }

            for(int z=0; z<prereqModules.size(); z++)
            {
                String module=prereqModules.get(z);
                System.out.format("%s\n", module);
            }
           
            for(int x=0; x<prereqModules.size(); x++)
            {
                String module=prereqModules.get(x);

                String query1="select stat from student_Module_Current_And_Previous_Year where module_Code='"+module+"' and student_Number='"+studentNumber+"'";
                ResultSet rs1=stmt.executeQuery(query1); 

                while(rs1.next())
                {
                    String statusForPrereqModule=rs1.getString("stat");
                    status.add(statusForPrereqModule);

                }
                
            }
            System.out.println(" ");
            System.out.println("The following results show whether you passed or failed the prerequisites.");
            System.out.println(" ");

            Integer counter=0;
            for(int y=0; y<status.size(); y++)
            {
                String a=status.get(y);
                System.out.format("%s\n", a);

                if(status.get(y).equals("fail") || status.get(y).equals(null))//fix this
                {
                    counter++;
                }
            }
            System.out.println("Size of vector holding pass/fail is: " +status.size());
            System.out.println("Count of all fails is: " +counter);
            String reg="registered";
            String mark="0";

            if(counter<1)
            {
                System.out.println("You may register for the module. ");
                System.out.println(" ");

                String query2 = "INSERT INTO `student_Module_Future_Year`(student_Number, module_Code, mark, stat)" + "VALUES(?, ?, ?, ?)";//THE SQL QUERY
                PreparedStatement preparedStmt1 = conn.prepareStatement(query2);
                preparedStmt1.setString(1, studentNumber);
                preparedStmt1.setString(2, moduleName);
                preparedStmt1.setString(3, mark);
                preparedStmt1.setString(4, reg);
                preparedStmt1.execute();
                System.out.println(" ");
                System.out.println("ADDED SUCCESSFULLY");
                System.out.println(" ");

                System.out.println("You are now registered for the following module below and here are the details.");
                System.out.println(" ");

                String query3 = "SELECT student_Number, module_Code, mark, stat from `student_Module_Future_Year` where module_Code='"+moduleName+"' and student_Number='"+studentNumber+"' and stat='"+reg+"'";
                ResultSet rs2=stmt.executeQuery(query3); //STORE AS AN 'OBJECT'
                System.out.println("This query pulls the newly added info from the database to show that it was added successfully ");
                    
                while(rs2.next())
                {
                    String a=rs2.getString("student_Number");
                    String b=rs2.getString("module_Code");
                    String c=rs2.getString("mark");
                    String d=rs2.getString("stat");
                    System.out.format("%s, %s, %s, %s\n", a, b, c, d);
                    System.out.println(" ");
                }

            }
            
            else
            {
                System.out.println(" ");
                System.out.println("YOU FAILED A PREREQUISITE AND CANNOT REGISTER FOR THIS MODULE");
                return;
            }

                    
    }
                                            // END OF FUNCTION 8
    /*---------------------------------------------------------------------------------------------------------------*/

            //9. THIS FUNCTION QUERYS THE ALLOWS/DOESN'T ALLOW STUDENT TO REGISTER FOR A CERTAIN MODULE BASED ON SPACE
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  moduleRegisterSpace(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will register the student if there is still space ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println(" ");
        System.out.println("Enter the module with code (eg COS132)" );
        String moduleName=in.nextLine().toUpperCase(); //HOLDS USER IMPOUT
        //in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT
        System.out.println(" ");

            String query = "select count(student_Number) from `student_Module_Future_Year` where  module_Code='"+ moduleName +"'";//THE SQL QUERY
            ResultSet rs=stmt.executeQuery(query); //STORE AS AN 'OBJECT'
            System.out.println(" ");
            
            rs.next();
            Integer count=rs.getInt(1);
            System.out.println("This is the amount of people registered for the module " + moduleName +" so far: '"+count+"'");
            System.out.println(" ");
            System.out.println(" ");

            Vector<String> venueNames=new Vector<String>();
            Vector<Integer> venueSizes=new Vector<Integer>();


            String query3 = "select venue_name from assessment where module_Code='"+moduleName+"'";//THE SQL QUERY
            ResultSet rs3=stmt.executeQuery(query3); //STORE AS AN 'OBJECT'

            

            while(rs3.next())
                {
                    String a=rs3.getString("venue_Name");
                    venueNames.add(a);
                }
            System.out.println(" ");
            System.out.println("These are the venues for the lectures for module '"+moduleName+"'");
            System.out.println(" ");

                for(int x=0; x<venueNames.size(); x++ )
            {
                System.out.println(venueNames.get(x)) ;
            }
            System.out.println(" ");
            System.out.println("These are the lecture hall sizes ");
            System.out.println(" ");

            
            for(int y=0; y<venueNames.size(); y++)
            {
             String query4 = "select Capacity from venue where venue_Name='"+venueNames.get(y)+"'";//THE SQL QUERY

             ResultSet rs4=stmt.executeQuery(query4); //STORE AS AN 'OBJECT'

                while(rs4.next())
                {
                    Integer b=rs4.getInt("Capacity");
                    venueSizes.add(b);
                    
                }
            }
            

            for(int x=0; x<venueSizes.size(); x++ )
            {
                System.out.println(venueSizes.get(x)) ;
            }

            Integer smallest=1000;
            for(int t=0; t<venueSizes.size(); t++)
            {
                if(venueSizes.get(t)<smallest)
                {
                    smallest=venueSizes.get(t);
                }
            }
            System.out.println(" ");
            System.out.println("The smallest venue size is: "+smallest);
            System.out.println(" ");






                if(count < smallest)//IF LESS THAN THE MODULE CAPACITY
                {
                    System.out.println("This query will register a student for a certain module because there is space ");
                    //Scanner input= new Scanner(System.in); //USED TO GET USER IMPUT
                    System.out.println(" ");
                    System.out.println("Enter the student number (eg 12345678) ");
                    String studentNumber=in.nextLine(); //HOLDS STUDENT NUMBER
                    in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT

                    String mark="0";
                    String stat="registered";

                    String query1 = "INSERT INTO `student_Module_Future_Year`(student_Number, module_Code, mark, stat)" + "VALUES(?, ?, ?, ?)";//THE SQL QUERY
                    PreparedStatement preparedStmt = conn.prepareStatement(query1);
                    preparedStmt.setString(1, studentNumber);
                    preparedStmt.setString(2, moduleName);
                    preparedStmt.setString(3, mark);
                    preparedStmt.setString(4, stat);
                    preparedStmt.execute();
                    System.out.println(" ");
                    System.out.println("ADDED SUCCESSFULLY");
                    System.out.println(" ");

                String query2 = "select count(student_Number) from `student_Module_Future_Year` where  module_Code='"+ moduleName +"'";//THE SQL QUERY
                ResultSet rs2=stmt.executeQuery(query2); //STORE AS AN 'OBJECT'
                System.out.println(" ");
                
                rs2.next();//ALLOWS YOU TO GET THE COUNT
                Integer count1=rs2.getInt(1);//ALLOWS YOU TO GET THE COUNT
                System.out.println("This is the previous amount of people registered for the module '"+moduleName+"': " + count +" ");
                System.out.println(" ");
                System.out.println("This is the new amount of people registered for '"+moduleName+"': " +count1);

                }
                
                else
                    {
                        System.out.println("Cannot register. The module is full");
                        System.out.println(" ");
                    }
        
    }
                                            // END OF FUNCTION 9
    /*---------------------------------------------------------------------------------------------------------------*/


                   //10. THIS FUNCTION QUERYS THE DATABASE AND ADDS MARKS FOR A STUDENT FOR A CERTAIN MODULE 
                   //THE STUDENT MUIST ALREADY BE IN THE DATABASE..YOU CANT ADD A MARK FOR A STUDENT WHO DOESNT EXIST
                   //SO ADD STUDENT FIRST
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  addFinalMarks(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will add the final marks for a student and a certain module ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println(" ");
        System.out.println("Enter the student number-without the letter (eg 12345678) ");
        String studentNumber=in.nextLine(); //HOLDS ID
        System.out.println(" ");
        System.out.println("Enter the module (eg COS132) ");
        String moduleName=in.nextLine().toUpperCase(); //HOLDS USER IMPOUT
        System.out.println(" ");
        System.out.println("Enter mark for module without percentage sign (eg 67) ");
        Integer mark=in.nextInt(); //HOLDS USER IMPOUT
        in.nextLine();
        System.out.println(" ");
        System.out.println("Enter pass or fail for module ");
        String status=in.nextLine(); //HOLDS USER IMPOUT
        System.out.println(" ");

        String query = "delete from `student_Module_Future_Year` where  module_Code='"+moduleName+"' and student_Number='"+studentNumber+"' ";
        PreparedStatement preparedStmt= conn.prepareStatement(query);
        preparedStmt.execute();


        String query2 = "INSERT INTO `student_Module_Current_And_Previous_Year`(student_Number, module_Code, mark, stat)" + "VALUES(?, ?, ?, ?)";//THE SQL QUERY
        PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
                    preparedStmt2.setString(1, studentNumber);
                    preparedStmt2.setString(2, moduleName);
                    preparedStmt2.setInt(3, mark);
                    preparedStmt2.setString(4, status);
                    preparedStmt2.execute();
                    System.out.println(" ");
                    System.out.println(" ");

        String query5 = "INSERT INTO `student_Module_Current_Year`(student_Number, module_Code, mark, stat)" + "VALUES(?, ?, ?, ?)";//THE SQL QUERY
        PreparedStatement preparedStmt5 = conn.prepareStatement(query5);
                    preparedStmt5.setString(1, studentNumber);
                    preparedStmt5.setString(2, moduleName);
                    preparedStmt5.setInt(3, mark);
                    preparedStmt5.setString(4, status);
                    preparedStmt5.execute();
                    System.out.println(" ");
                    System.out.println(" ");



    
 
            
        String query1 = "SELECT student_Number, module_Code, mark, stat from `student_Module_Current_And_Previous_Year` where module_Code='"+moduleName+"' and student_Number='"+studentNumber+"'";
        ResultSet rs=stmt.executeQuery(query1); //STORE AS AN 'OBJECT'
        System.out.println("This query shows the info of the new module added into the database");
            
        while(rs.next())
        {
            String b=rs.getString("student_Number");
            String c=rs.getString("module_Code");
            Integer d=rs.getInt("mark");
            String e=rs.getString("stat");
            System.out.format("%s, %s, %s, %s\n", b, c, d, e);
            System.out.println(" ");
        }
    }
                                            // END OF FUNCTION 10
    /*---------------------------------------------------------------------------------------------------------------*/ 


                //11. THIS FUNCTION QUERYS THE DATABASE AND RETURNS MODULES THAT A STUDENT HAS PASSED
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  showModulesPassed(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will return all the modules a certain student has passed ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println(" ");
        System.out.println("Enter the student number (eg 12345678) ");
        Integer studentNumber=in.nextInt(); //HOLDS STUDENT NUMBER
        in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT
        String Pass="pass";//EASIER TO INSERT AS A VARIABLE

            String query = "select module_Code from student_Module_Current_And_Previous_Year where student_Number="+ studentNumber +" and stat='"+ Pass +"'";//THE SQL QUERY
            ResultSet rs=stmt.executeQuery(query); //STORE AS AN 'OBJECT'
            System.out.println("These are the modules that a student has passed from previous and current year ");
            System.out.println(" ");
            
        while(rs.next())
        {
            String a=rs.getString("module_Code");
            System.out.format("%s\n", a);
            System.out.println(" ");
        }
        System.out.println(" ");

       
        
    }
                                            // END OF FUNCTION 11
    /*---------------------------------------------------------------------------------------------------------------*/ 



    //12. THIS FUNCTION QUERYS THE DATABASE AND RETURNS MODULES THAT A STUDENT HAS FAILED
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  showModulesFailed(Connection conn, Statement stmt) throws SQLException
    {
        System.out.println("This query will return all the modules a certain student has failed ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        System.out.println(" ");
        System.out.println("Enter student number (eg 12345678) ");
        Integer studentNumber=in.nextInt(); //HOLDS STUDENT NUMBER
        System.out.println(" ");
        in.close(); //CLOSE SCANNER WHEN FINISHED GETTING USER IMPUT
        String Fail="fail";//EASIER TO INSERT AS A VARIABLE

            String query = "select module_Code from student_Module_Current_And_Previous_Year where student_Number="+ studentNumber +" and stat='"+ Fail +"'";//THE SQL QUERY
            ResultSet rs=stmt.executeQuery(query); //STORE AS AN 'OBJECT'
            System.out.println("These are the modules that a student has failed from the previous and current year");
            System.out.println(" ");
            
        while(rs.next())
        {
            String a=rs.getString("module_Code");
            System.out.format("%s\n", a);
            System.out.println(" ");    
        }
       
        
    }
                                            // END OF FUNCTION 12
    /*---------------------------------------------------------------------------------------------------------------*/ 


    //13. THIS FUNCTION QUERYS THE DATABASE AND RETURNS STUDENTS WHO MUST BE ACADEMICALLY EXCLUDED BECAUSE THEY FAILED MORE
    //THAN 75% OF THEIR MODULES
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  showExclusion(Connection conn, Statement stmt) throws SQLException
    {
       // System.out.println("Getting the unique student numbers and adding to vector ");
        String query= "select distinct(student_Number) from `student_Module_Current_Year`"; //THE DISTINCT(S_NUMBER) RETURNS NO DUPLICATES
        ResultSet rs=stmt.executeQuery(query);
        Vector<Integer> studentNumbers=new Vector<Integer>();//STORE THE STUDENT NUMBERS IN A VECTOR

        while(rs.next())
        {
            Integer number=rs.getInt("student_Number");
            studentNumbers.add(number);//ADD IT INTO THE VECTOR. USE A VECTOR BECAUSE YOU DON'T HAVE TO FIX THE SIZE IN THE BEGINNING.
        }

        //System.out.println("Getting the value of vector called MODULE ");
        Integer size=studentNumbers.size();
       // System.out.print(size);
        System.out.println(" ");
         
        Vector<Integer> countModules=new Vector<Integer>();//STORE THE AMOUNT OF MODULES THE STUDENT TOOK IN A VECTOR
        Vector<Integer> countStatus=new Vector<Integer>();//STORE THE AMOUNT OF FAILS THE STUDENT HAD IN A VECTOR

        
        for(Integer x=0; x<size; x++)
        {
            
            String query1= "select count(module_Code) from `student_Module_Current_Year` where student_Number="+studentNumbers.get(x);
            ResultSet rs1=stmt.executeQuery(query1);
            rs1.next();//GET THE COUNT OF ALL THE MODULES A STUDENT TOO
            Integer moduleCount=rs1.getInt(1);
            countModules.add(moduleCount);
        
           // System.out.print("The count in the vector module for " +x+ " is : ");
            //System.out.print(countModules.get(x));
           // System.out.println(" ");
            
            String Status="fail";
            String query2= "select count(stat) from `student_Module_Current_Year` where stat='"+Status+"' and student_Number="+studentNumbers.get(x);
            ResultSet rs2=stmt.executeQuery(query2);
            rs2.next();//GET THE COUNT OF ALL THE FAILS A STUDENT HAD
              
            Integer status=rs2.getInt(1);
            countStatus.add(status);
             
            //System.out.println("The size of vector STATUS is ");
            //System.out.print(countStatus.get(x));
           // System.out.println(" ");
            Integer a=countStatus.get(x);//THIS HOLDS ALL THE FAILS FOR A STUDENT AT A SPECIFIC ELEMENT
            Integer b=countModules.get(x);//THIS HOLDS ALL THE MODULES FOR A STUDENT AT A SPECIFIC ELEMENT
            
            Float percentage=(float)a*100/(float)b;//THIS IS THE MATH THAT CALCULATES IF THEY MUST BE EXCLUDED OR NOT. TYPE CASTED INTO A FLOAT

              if( percentage > 75 )
              {
                System.out.println(" ");
                System.out.println("This student should be academically excluded.");
                String query3= "select Student_Number ,first_Name, last_Name from `student` where Student_Number="+studentNumbers.get(x);
                ResultSet rs3=stmt.executeQuery(query3);
            
                  while(rs3.next())
                 {
                    Integer sNumber=rs3.getInt("Student_Number");
                    String firstName=rs3.getString("first_Name");
                    String lastName=rs3.getString("last_Name");

                    System.out.format("%s, %s, %s\n", sNumber, firstName, lastName);
                    System.out.println(" ");
                 }     
             } 
            
           
    }
    //System.out.println("Finished");
}
                                            // END OF FUNCTION 13
    /*---------------------------------------------------------------------------------------------------------------*/ 
        
     //14. THIS FUNCTION QUERYS THE DATABASE AND GENERATES A TIMETABLE
    /*---------------------------------------------------------------------------------------------------------------*/       
    public void  generateTimeTable(Connection conn, Statement stmt ) throws SQLException
    {
        System.out.println("This query will generate a timetable for you ");
        Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
        Vector<String> allModules=new Vector<String>();//STORE ALL THE MODULES THE USER WILL IMPUT IN A VECTOR. USE A VECTOR BECAUSE YOU DON'T KNOW THE INITIAL SIZE
        System.out.println(" ");
        System.out.println("Enter the module code (eg COS110)");
        String module=in.nextLine().toUpperCase();//CONVERT IT TO UPPER CASE
        Integer counter=1;
        allModules.add(module);//ADD IT INTO THE VECTOR
        System.out.println(" ");
        System.out.print("Do you want to add another module? (yes or no) ");
        System.out.println(" ");
        String answer=in.nextLine().toLowerCase();//CONVERT TO LOWER CASE BECAUSE IT IS LOWERCASE YES/NO IN THE STATUS IN THE DB

        while(answer.equals("yes"))
        {
            System.out.println("Enter the module code (eg COS110) ");
            //System.out.println(" ");
            module=in.nextLine().toUpperCase(); //HOLDS MODULE CODE
            counter++;
            allModules.add(module);//ADD MODULE TO VECTOR
            System.out.println(" ");
            System.out.println("Do you want to add another module? (yes or no) ");
            //System.out.println(" ");
            answer=in.nextLine().toLowerCase();
            System.out.println(" ");
        }

        Vector<String>lectureDay=new Vector<String>();
        Vector<String>lectureTime=new Vector<String>();
        
        for(int t=0; t<allModules.size(); t++)
        {
            String query = "select l_Time from lecture where module_Code='"+ allModules.get(t)+"'"; //THE SQL QUERY
            ResultSet rs=stmt.executeQuery(query); //STORE AS AN 'OBJECT'
            
            while(rs.next())
            {
                String a=rs.getString("l_Time");
                lectureTime.add(a);
            }
            
        }
        for(int h=0; h<allModules.size(); h++)
        {
            String query2 = "select l_Day from lecture where module_Code='"+ allModules.get(h)+"'"; //THE SQL QUERY
            ResultSet rs2=stmt.executeQuery(query2); //STORE AS AN 'OBJECT'

            while(rs2.next())
            {
                String b=rs2.getString("l_Day");
                lectureDay.add(b);
            }
            
        }

       
        Boolean clash=false;

        for(int z=0; z<lectureTime.size(); z++)
        {
            for(int r=z+1; r<lectureDay.size(); r++)
            {
                if(lectureTime.get(z).equals(lectureTime.get(r)) && lectureDay.get(z).equals(lectureDay.get(r)) )
                {
                    clash=true;
                }
            }
        }

        if(clash.equals(true))
        {
            System.out.println("THERE IS A CLASH WITH SOME MODULES AND NO OTHER SOLUTION IS VALID.  ");
            System.out.println(" ");
            System.out.println("Do you want to see the best timetable with minimum clashes? (yes/no) ");
            System.out.println(" ");
            String Answer=in.nextLine().toUpperCase();

            if(Answer.equals("NO"))
            {
                System.out.println(" ");
                System.out.println("okay, GOODBYE.  ");
                System.out.println(" ");
                return;
            }
               

        }


        System.out.println("I WILL NOW GENERATE YOUR TIMETABLE ");
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("You typed in "+counter+" modules " );
        System.out.println(" ");
        System.out.println("They are: ");
        Integer x=0;
            while(x<counter)
            {
                
                System.out.print(allModules.get(x));
                System.out.print(", ");
                x++;

            }
        System.out.println(" ");
        System.out.println("Here is your timetable below ");
        System.out.println(" ");
        for(Integer k=0; k<counter; k++)
        {
            String query="select venue_Name, lesson, l_Group, l_Time, l_Day from lecture where module_Code='"+allModules.get(k)+"'";
            ResultSet rs=stmt.executeQuery(query);
            System.out.println(" ");
            System.out.println(allModules.get(k));
            System.out.println("-----------------------------------------------------------------");
            System.out.println(" ");

            while (rs.next())
            {
                String a=rs.getString("venue_Name");
                Integer b=rs.getInt("lesson");
                String c=rs.getString("l_Group");
                String d=rs.getString("l_Time");
                String e=rs.getString("l_Day");
                System.out.format("%s, %s, %s, %s, %s\n", a, b, c, d, e);
                System.out.println(" ");
                
            }
            System.out.println("-----------------------------------------------------------------");

        }
        in.close();//CLOSE THE SCANNER   
    }
                                            // END OF FUNCTION 14
    /*---------------------------------------------------------------------------------------------------------------*/ 
    

public static void main (String[] args)
    {

        Connection conn = null;//USED TO HOLD A CONNECTION. TRY CONNECT, ELSE CATCH EXCEPTION
        try 
        {
            
        /*-----------------------------------------------------*/
        
            String userName ="root"; //CHANGE TO YOUR USERNAME HERE IF IT NOT CALLED ROOT ON YOUR LOCALHOST SERVER ON YOUR MYSQL WORKBENCH
            String password ="//YOUR PASSWORD GOES HERE";  //CHANGE TO YOUR PASSWORD THAT YOU USE FOR YOUR MYSQL LOCALHOST SERVER 
                                                        
            String url = "jdbc:mysql://127.0.0.1:3306/Bsc_Database"; //EVERYTHING HERE SHOULD STAY THE SAME UNLESS YOUR PORT NUMBER IS NOT 3306
     
            Class.forName("com.mysql.jdbc.Driver"); //CALLING A CLASS FROM A JAVA LIBRARY THAT WE NEED
            conn = DriverManager.getConnection(url, userName, password);//, password); //GET CONNECTED TO THE DATABASE
            System.out.println(" ");
            System.out.println("Database connection established");
            System.out.println(" ");
            Statement stmt=conn.createStatement(); //CREATE AN SQL STATEMENT

             // END OF ADMIN STUFF TO CONNECT TO THE SERVER
        /*-----------------------------------------------------*/

            System.out.println("Welcome to the Student Module System.");
            System.out.println(" ");
            System.out.println("Click the following operation that you would like to do");
            System.out.println("----------------------------------------------------------------------------");
            Scanner in= new Scanner(System.in); //USED TO GET USER IMPUT
            System.out.println("Type 1 if you want to ADD A STUDENT TO THE DATABASE ");
            System.out.println(" ");
            System.out.println("Type 2 if you want to ADD A VENUE TO THE DATABASE ");
            System.out.println(" ");
            System.out.println("Type 3 if you want to ADD A MODULE TO THE DATABASE ");
            System.out.println(" ");
            System.out.println("Type 4 if you want to ADD AN Assessment (Sem Test1/Exam) TO THE DATABASE ");
            System.out.println(" ");
            System.out.println("Type 5 if you want to ADD A LECTURE TO THE DATABASE ");
            System.out.println(" ");
            System.out.println("Type 6 if you want to RETURN ALL STUDENTS REGISTERED FOR A MODULE ");
            System.out.println(" ");
            System.out.println("Type 7 if you want to RETURN ALL PREREQUISITES FOR A MODULE ");
            System.out.println(" ");
            System.out.println("Type 8 if you want to ALLOW STUDENT TO REGISTER FOR A CERTAIN MODULE BY CHECKING IF PREREQUISITE WAS MET " );
            System.out.println(" ");
            System.out.println("Type 9 if you want to ALLOW STUDENT TO REGISTER FOR A CERTAIN MODULE BY CHECKING SPACE AVAILABLE " );
            System.out.println(" ");
            System.out.println("Type 10 if you want to AND GENERATES A TIMETABLE "); 
            System.out.println(" ");
            System.out.println("Type 11 if you want to ADD MARKS FOR A STUDENT FOR A CERTAIN MODULE ");
            System.out.println(" ");
            System.out.println("Type 12 if you want to RETURN MODULES THAT A STUDENT HAS PASSED");
            System.out.println(" ");
            System.out.println("Type 13 if you want to RETURN MODULES THAT A STUDENT HAS FAILED ");
            System.out.println(" ");
            System.out.println("Type 14 if you want to RETURN STUDENTS WHO MUST BE ACADEMICALLY EXCLUDED");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Type the number that corresponds to your query ");
            System.out.println(" ");
            Integer number=in.nextInt(); 
            System.out.println(" ");
            
            
            driver object=new driver();

            switch(number)
            {
                case 1: //1. THIS FUNCTION QUERYS THE DATABASE AND ADDS A STUDENT TO THE DATABASE
                try{
                        object.addStudent(conn, stmt);
                        break;
                } 
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This student number already exists in the database or you entered something in an invalid format.");
                        break;
                }
                
                case 2: //2. THIS FUNCTION QUERYS THE DATABASE AND ADDS A VENUE TO THE DATABASE
                try{
                        object.addVenue(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This venue already exists in the database or you entered something in an invalid format.");
                        break;

                }
                    
                case 3: //3. THIS FUNCTION QUERYS THE DATABASE AND ADDS A MODULE TO THE DATABASE
                try{
                        object.addModule(conn, stmt);
                        break;
                } 
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This module already exists in the database or you entered something in an invalid format or the module doesn't exist so you can't add an assessment for it ");
                        break;

                }

                case 4: //4. THIS FUNCTION QUERYS THE DATABASE AND ADDS A TEST (Sem Test 1) TO THE DATABASE
                try{
                        object.addAssessment(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This assessment already exists in the database or the module is not registered in the system or you entered something in an invalid format.");
                        break;

                }


                case 5: //8. THIS FUNCTION QUERYS THE DATABASE AND ADDS A LECTURE TO THE DATABASE
                try{
                        object.addLecture(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This lecture already exists in the database or the module is not registered in the system or you entered something in an invalid format.");
                        break;

                }
                case 6: //10. THIS FUNCTION QUERYS THE DATABASE AND RETURNS ALL STUDENTS REGISTERED FOR A MODULE 
                try{
                        object.showStudentsForAModule(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This module doesn't exists in the database or the module is not registered in the system or you entered something in an invalid format.");
                        break;

                }

                case 7:
                try{ //11. THIS FUNCTION QUERYS THE DATABASE AND RETURNS ALL PREREQUISITES FOR A MODULE 
                        object.getModulePrerequisite(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This module doesn't exists in the database or the module is not registered in the system or you entered something in an invalid format.");
                        break;

                }

                case 8: //13. THIS FUNCTION QUERYS THE ALLOWS/DOESN'T ALLOW STUDENT TO REGISTER FOR A CERTAIN MODULE BY CHECKING IF PREREQUISITE WAS MET
                try{ 
                        object.moduleRegisterprereq(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.print("This student number doesn't exists in the database or the module is not registered in the system or you entered something in an invalid format.");
                        break;

                }

                case 9: //12. THIS FUNCTION QUERYS THE ALLOWS/DOESN'T ALLOW STUDENT TO REGISTER FOR A CERTAIN MODULE BY CHECKING SPACE
                try{
                        object.moduleRegisterSpace(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This student number or module doesn't exists in the database or you entered something in an invalid format.");
                        break;
                }
        
                    
                case 10: //14. THIS FUNCTION QUERYS THE DATABASE AND GENERATES A TIMETABLE
                    object.generateTimeTable(conn, stmt);
                        break;

                case 11:  //15. THIS FUNCTION QUERYS THE DATABASE AND ADDS MARKS FOR A STUDENT FOR A CERTAIN MODULE 
                try{
                        object.addFinalMarks(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This student number/module doesn't exists in the database or you entered something in an invalid format.");
                        break;
                }

                case 12:
                try{ //16. THIS FUNCTION QUERYS THE DATABASE AND RETURNS MODULES THAT A STUDENT HAS PASSED
                        object.showModulesPassed(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This student number/module doesn't exists in the database or you entered something in an invalid format.");
                        break;
                }

                case 13:
                try{ //17. THIS FUNCTION QUERYS THE DATABASE AND RETURNS MODULES THAT A STUDENT HAS FAILED
                        object.showModulesFailed(conn, stmt);
                        break;
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This student number doesn't exists in the database or you entered something in an invalid format.");
                        break;
                }

                case 14: //18. THIS FUNCTION QUERYS THE DATABASE AND RETURNS STUDENTS WHO MUST BE ACADEMICALLY EXCLUDED
                try{
                        object.showExclusion(conn, stmt);
                        break;  
                }
                catch(Exception e)
                {
                        System.out.println(" ");
                        System.out.println("This student number doesn't exists in the database or you entered something in an invalid format.");
                        break;
                }
                                 
            }

         in.close();

        }//BRACKET FOR END OF TRY STATEMENT

        catch (Exception e)
            {
                    System.out.println(e);
                System.err.println("Cannot connect to database server eish..");
            }
            

        finally
        {
            if (conn != null)
            {    try
                    {   
                        System.out.println();
                        System.out.println("Database connection will now close.  Run the program again to do another query.");
                        conn.close ();
                        System.out.println(" ");
                        System.out.println("Database connection has been terminated.");
                        System.out.println(" ");
                        System.out.println("Goodbye.");
                        System.out.println(" ");
                    }
                catch(Exception  e)
                    {
                            System.out.println("Unsuccessful closing the database connection");
                        
                    }
            }
        }  
    }

}