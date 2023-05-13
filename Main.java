/************************
* Programmers: Finnley Howald, Shubho Mukherjee, and Koushik Paul
* Date:24-09-2020 to 10-10-2020
* Program Name: Water Project 
* Program Description: The program outputs the total statistics for how many types of people participated in the test as well as the total answers for questions pertaining to choosing bottled or tap water. The next part is the user can input a number from 1 - 50 to get a individual student's answers to each question. The last portion is the final statistics for which type of people prefer bottled or tap water before and after the test, as well as which type of water they think is more environmentally friendly to obtain. 
*************************/

//imports
import java.text.*;
import java.util.*;
import java.io.*;

//Main class where we stitch together the methods
class Main {
  

  //Variables for current staistics
  static String[] answersCur1 = new String[50]; // for q1
  static String[] answersCur2 = new String[50];
  static String[] answersCur3 = new String[50];
  static String[] answersCur4 = new String[50];
  static String[] answersCur5 = new String[50];
  static String[] answersCur6 = new String[50];
  static String[] answersCur7 = new String[50];
  static String[] answersCur8 = new String[50];

  //Variables for total and final statistics
  static int[] answers1 = new int[50];
  static int[] answers2 = new int[50];
  static int[] answers3 = new int[50];
  static int[] answers4 = new int[50];
  static int[] answers5 = new int[50];
  static int[] answers6 = new int[50];
  static int[] answers7 = new int[50];
  static int[] answers8 = new int[50];

	// 7 methods were used - 6 in the main (random generator in the output method)
  public static void main(String[] args) {
    output();
    System.out.println("\n*********STATISICAL SUMMARY*********\n");
    statSummary();
    freqStatSummary();
    afterTestStatSummary();
    envStatSummary();
    individualTest();
  }

  // essentially mimicking a random generator, but it is not 100% random as it is
  // not a gaussian curve
  // the percentages choosen are based on research using surveys and census data (check our biases in our final report)

  public static void randomGenerator() {
     
     // general questions relating to the respondent
    for (int count1 = 0; count1 < 50; count1++) //for loop to keep track of what respondent we are on
    {
      double gender = (Math.random() * 10);

      if (gender <= 4.9 && gender >= 0) //chances for being a male
      {
        answersCur1[count1] = "MALE";
        answers1[0] = answers1[0] + 1;
      } 
      else if (gender <= 9.8 && gender > 4.9) //chances for being female
      {
        answersCur1[count1] = "FEMALE";
        answers1[1] = answers1[1] + 1;
      } 
      else //chances of being nonbinary, genderqueer etc.
      {
        answersCur1[count1] = "OTHER";
        answers1[2] = answers1[2] + 1;
      }
    }

    // grade - equal population across all grades
    for (int count2 = 0; count2 < 50; count2++) 
    {
      double grade = (Math.random() * 10);

      if (grade <= 2.5 && grade >= 0) 
      {
        answersCur2[count2] = "GRADE 9";
        answers2[0] = answers2[0] + 1;
      } 
      else if (grade <= 5.0 && grade > 2.5) 
      {
        answersCur2[count2] = "GRADE 10";
        answers2[1] = answers2[1] + 1;
      } 
      else if (grade <= 7.5 && grade > 5.0) 
      {
        answersCur2[count2] = "GRADE 11";
        answers2[2] = answers2[2] + 1;
      } 
      else 
      {
        answersCur2[count2] = "GRADE 12";
        answers2[3] = answers2[3] + 1;
      }
    }

    // socio-economic Class
    for (int count3 = 0; count3 < 50; count3++) 
    {
      double socioClass = (Math.random() * 10);

      if (socioClass <= 2.2 && socioClass >= 0) 
      {
        answersCur3[count3] = "LOWER CLASS";
        answers3[0] = answers3[0] + 1;
      } 
      else if (socioClass <= 7.19 && socioClass > 2.2) {
        answersCur3[count3] = "MIDDLE CLASS";
        answers3[1] = answers3[1] + 1;
      } 
      else 
      {
        answersCur3[count3] = "HIGH CLASS";
        answers3[2] = answers3[2] + 1;
      }
    }

    // water preference 
    for (int count4 = 0; count4 < 50; count4++) 
    {
      double waterPreference = (Math.random() * 10);

      if (waterPreference <= 5.5 && waterPreference >= 0) 
      {
        answersCur4[count4] = "BOTTLED WATER";
        answers4[0] = answers4[0] + 1;
      } 
      else 
      {
        answersCur4[count4] = "TAP WATER";
        answers4[1] = answers4[1] + 1;
      }
    }

    // which type of water they drink more frequently
    for (int count5 = 0; count5 < 50; count5++) 
    {
      double waterFrequency = (Math.random() * 10);

      if(waterFrequency <= 7.0 && answersCur3[count5].equals("HIGH CLASS"))// adding the probability of high class people more likely to choose bottled water 
      {
        answersCur5[count5] = "BOTTLED WATER";
        answers5[0] = answers5[0] + 1;
      }
      else if(waterFrequency <= 0.5 && answersCur3[count5].equals("LOWER CLASS"))// adding the probability of low class people more likely to choose tap water 
      {
        answersCur5[count5] = "BOTTLED WATER";
        answers5[0] = answers5[0] + 1;
      }
      else if (waterFrequency <= 2.0 && waterFrequency >= 0) 
      {
        answersCur5[count5] = "BOTTLED WATER";
        answers5[0] = answers5[0] + 1;
      } 
      else 
      {
        answersCur5[count5] = "TAP WATER";
        answers5[1] = answers5[1] + 1;
      }
    }
    // which they think is healthier to drink
    for (int count6 = 0; count6 < 50; count6++) 
    {
      double waterHealth = (Math.random() * 10);

      if (waterHealth <= 5.0 && waterHealth >= 0) 
      {
        answersCur6[count6] = "BOTTLED WATER";
        answers6[0] = answers6[0] + 1;
      } 
      else 
      {
        answersCur6[count6] = "TAP WATER";
        answers6[1] = answers6[1] + 1;
      }
    }
    // which they think is more environmentally friendly to obtain
    for (int count7 = 0; count7 < 50; count7++) 
    {
      double waterEnvironment = (Math.random() * 10);

      if (waterEnvironment <= 0.4 && waterEnvironment >= 0) 
      {
        answersCur7[count7] = "BOTTLED WATER";
        answers7[0] = answers7[0] + 1;
      } 
      else 
      {
        answersCur7[count7] = "TAP WATER";
        answers7[1] = answers7[1] + 1;
      }
    }

    // After water test
    // Preference after the taste test
    for (int count8 = 0; count8 < 50; count8++) 
    {
      double afterTestPreference = (Math.random() * 10);

      if (afterTestPreference <= 2.5 && afterTestPreference >= 0) 
      {
        answersCur8[count8] = "BOTTLED WATER";
        answers8[0] = answers8[0] + 1;
      } 
      else 
      {
        answersCur8[count8] = "TAP WATER";
        answers8[1] = answers8[1] + 1;
      }
    }
  }
  // current statistics - tells one of the students' answers to all the questions above
  public static void individualTest() {
    
    System.out.println("\nA random test will be shown from the 50 participants.");
    int student = (int)(Math.random() * 50);
    
    System.out.println(""); // spacing
		
    System.out.println("****STUDENT "+ student +"'S TEST RESULTS****\n");
    System.out.println("Gender: "+ answersCur1[student - 1] + "\n" +"Grade: "+  answersCur2[student - 1] + "\n" +"Economic Class: "+  answersCur3[student - 1] + "\n" +"Water that tastes the best: "+  answersCur4[student - 1] + "\n" +"Water that they drink the most:  "+  answersCur5[student - 1] + "\n" +"Water they think is healthier to drink: "+  answersCur6[student - 1] + "\n" +"Water that they think is more environmentally friendly to obtain: "+  answersCur7[student - 1] + "\n" +"Water they think tastes the best after the taste test: "+  answersCur8[student - 1] + "\n");
    
  }
  // outputs the total answers to each question as a rough number and a percentage
  public static void output() {
    randomGenerator();
    
    System.out.print("\n*********TOTAL STATISTICS*********\n");
        
        System.out.println("\nWhat is your gender?(male/female/other)\n");
        System.out.format("%-10s %8s %8s %8s", "Gender", "Male", "Female", "Other\n");
        System.out.format("%-10s %5s %8s %8s", "Rough Numbers", answers1[0], answers1[1], answers1[2] + "\n");
        System.out.format("%-10s %8s %8s %8s", "Percentage", answers1[0] * 2 + "%", answers1[1] * 2 + "%",
        answers1[2] * 2 + "%\n");
      
        System.out.println("\nWhat is your grade?(grade 9/grade 10/grade 11/grade 12)\n");
        System.out.format("%-10s %8s %8s %8s %8s", "Grade", "Grade 9", "Grade 10", "Grade 11", "Grade 12\n");
        System.out.format("%-10s %5s %8s %8s %8s", "Rough Numbers", answers2[0], answers2[1], answers2[2], answers2[3]+ "\n");
        System.out.format("%-10s %8s %8s %8s %8s", "Percentage", answers2[0] * 2 + "%", answers2[1] * 2 + "%", answers2[2] * 2 + "%", answers2[3] * 2 + "%\n");
      
        System.out.println("\nWhat is your socio-economic-class?(lower class/middle class/upper class)\n");
        System.out.format("%-10s %12s %12s %12s", "Eco Class", "Low Class", "Middle Class", "High Class\n");
        System.out.format("%-10s %9s %12s %12s", "Rough Numbers", answers3[0], answers3[1], answers3[2] + "\n");
        System.out.format("%-10s %12s %12s %12s", "Percentage", answers3[0] * 2 + "%", answers3[1] * 2 + "%", answers3[2] * 2 + "%\n");
      
        System.out.println("\nWhat water do you think tastes best?(bottled water/tap water)\n");
        System.out.format("%-10s %8s %8s", "Water Type", "Bottle", "Tap\n");
        System.out.format("%-10s %5s %8s", "Rough Numbers", answers4[0], answers4[1]+ "\n");
        System.out.format("%-10s %8s %8s", "Percentage", answers4[0] * 2 + "%", answers4[1] * 2 + "%\n");
      
        System.out.println("\nWhat water do you drink the most frequently?(bottled water/tap water)\n");
        System.out.format("%-10s %8s %8s", "Water Type", "Bottle", "Tap\n");
        System.out.format("%-10s %5s %8s", "Rough Numbers", answers5[0], answers5[1]+ "\n");
        System.out.format("%-10s %8s %8s", "Percentage", answers5[0] * 2 + "%", answers5[1] * 2 + "%\n");
      
        System.out.println("\nWhat water do you think is safer for your health to drink?(bottled water/tap water)\n");
        System.out.format("%-10s %8s %8s", "Water Type", "Bottle", "Tap\n");
        System.out.format("%-10s %5s %8s", "Rough Numbers", answers6[0], answers6[1]+ "\n");
        System.out.format("%-10s %8s %8s", "Percentage", answers6[0] * 2 + "%", answers6[1] * 2 + "%\n");
      
        System.out.println("\nWhat type of water do you think is more environmentally friendly to obtain?(bottled water/tap water)\n");
        System.out.format("%-10s %8s %8s", "Water Type", "Bottle", "Tap\n");
        System.out.format("%-10s %5s %8s", "Rough Numbers", answers7[0], answers7[1]+ "\n");
        System.out.format("%-10s %8s %8s", "Percentage", answers7[0] * 2 + "%", answers7[1] * 2 + "%\n");
      
        System.out.println("\nWhich water do you think tastes better after blind tasting both?(bottled water/tap water)\n");
        System.out.format("%-10s %8s %8s", "Water Type", "Bottle", "Tap\n");
        System.out.format("%-10s %5s %8s", "Rough Numbers", answers8[0], answers8[1]+ "\n");
        System.out.format("%-10s %8s %8s", "Percentage", answers8[0] * 2 + "%", answers8[1] * 2 + "%\n");
      
    
  }
  //Prints out the different genders, grades, and social classes preference of water, between bottled and tap water before the taste test
  public static void statSummary(){ //q3
    DecimalFormat numberFormat = new DecimalFormat(".0");
    int[] statCount = new int [10];
    //the for loop checks if the answer to question 4 is bottled water and increases statCount by 1 if it is
    for (int i = 0; i<50; i++)
    {
      if (answersCur1[i].equals("MALE") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[0]++;
      }
      else if (answersCur1[i].equals("FEMALE") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[1]++;
      }
      else if (answersCur1[i].equals("OTHER") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[2]++;
      }

      if (answersCur2[i].equals("GRADE 9") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[3]++;
      }
      else if (answersCur2[i].equals("GRADE 10") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[4]++;
      }
      else if (answersCur2[i].equals("GRADE 11") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[5]++;
      }
      else if (answersCur2[i].equals("GRADE 12") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[6]++;
      }
      
      if (answersCur3[i].equals("LOWER CLASS") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[7]++;
      }
      else if (answersCur3[i].equals("MIDDLE CLASS") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[8]++;
      }
      else if (answersCur3[i].equals("HIGH CLASS") && answersCur4[i].equals("BOTTLED WATER"))
      {
        statCount[9]++;
      }
    }

		//displays the preference statics as a table showing which types of people choose bottled and tap water as a percentage


    // gender's preference of water
     if (answers1[2] != 0 )
    {
      System.out.println("-----PREFERENCE STATISTICS-----\n");
      //Prints out the number of people who choose bottled water
		  System.out.println("Percentage males, females, and others that choose bottled or tap water:\n");
      System.out.format("%-10s %8s %8s %8s", "", "Male", "Female", "Other\n");
      System.out.format("%-10s %8s %8s %8s", "Bottled", numberFormat.format(((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(((double)statCount[1]/answers1[1])*100) + "%", numberFormat.format(((double)statCount[2]/answers1[2])*100) + "%"+ "\n");
      //Prints out the number of people who choose tap water 
      System.out.format("%-10s %8s %8s %8s", "Tap", numberFormat.format(100 - ((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(100 - ((double)statCount[1]/answers1[1])*100) + "%", numberFormat.format(100 - ((double)statCount[2]/answers1[2])*100) + "%\n");
		}
    else
    {
      System.out.println("-----PREFERENCE STATISTICS-----\n");
      //Prints out the number of people who choose bottled water
		  System.out.println("Percentage males, females, and others that choose bottled or tap water:\n");
      System.out.format("%-10s %8s %8s %8s", "", "Male", "Female", "Other\n");
      System.out.format("%-10s %8s %8s %8s", "Bottled", numberFormat.format(((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(((double)statCount[1]/answers1[1])*100) + "%", 0.0 + "%"+ "\n");
      //Prints out the number of people who choose tap water 
      System.out.format("%-10s %8s %8s %8s", "Tap", numberFormat.format(100 - ((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(100 - ((double)statCount[1]/answers1[1])*100) + "%", 0.0 + "%\n");
    }
    
		
		//grades statistics 
    //Prints out the number of people who choose bottled water
    System.out.println("\nPercentage of grade 9, 10, 11, 12 students that choose bottled or tap water: \n");
    System.out.format("%-10s %8s %8s %8s %8s", "", "Grade 9", "Grade 10", "Grade 11", "Grade 12\n");
    System.out.format("%-10s %8s %8s %8s %9s", "Bottled", numberFormat.format(((double)statCount[3]/answers2[0])*100) + "%", numberFormat.format(((double)statCount[4]/answers2[1])*100) + "%", numberFormat.format(((double)statCount[5]/answers2[2])*100) + "%", numberFormat.format(((double)statCount[6]/answers2[3])*100) + "%"+ "\n");

    //Prints out the number of people who choose tap water 
    System.out.format("%-10s %8s %8s %8s %9s", "Tap", numberFormat.format(100 - ((double)statCount[3]/answers2[0])*100) + "%", numberFormat.format(100 - ((double)statCount[4]/answers2[1])*100) + "%", numberFormat.format(100 - ((double)statCount[5]/answers2[2])*100) + "%", numberFormat.format(100 - ((double)statCount[6]/answers2[3])*100) + "%\n");

		// social class statistics
    //Prints out the number of people who choose bottled water
    System.out.println("\nPercentage of lower, middle, and high class people that choose bottled and tap water: \n");
    System.out.format("%-10s %10s %10s %10s", "", "Low Class", "Middle Class", "High Class\n");
    System.out.format("%-10s %10s %12s %11s", "Bottled", numberFormat.format(((double)statCount[7]/answers3[0])*100) + "%", numberFormat.format(((double)statCount[8]/answers3[1])*100) + "%", numberFormat.format(((double)statCount[9]/answers3[2])*100) + "%" + "\n");
    //Prints out the number of people who choose tap water 
    System.out.format("%-10s %10s %12s %12s", "Tap", numberFormat.format(100 - ((double)statCount[7]/answers3[0])*100) + "%", numberFormat.format(100 - ((double)statCount[8]/answers3[1])*100) + "%", numberFormat.format(100 - ((double)statCount[9]/answers3[2])*100) + "%\n\n");

  }

   
  public static void envStatSummary(){ //q3
    DecimalFormat numberFormat = new DecimalFormat(".0");
    int[] statCount = new int [10];
    //the for loop checks if the answer to question 7 is bottled water and increases statCount by 1 if it is   
    for (int i = 0; i<50; i++)
    {
      if (answersCur1[i].equals("MALE") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[0]++;
      }
      else if (answersCur1[i].equals("FEMALE") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[1]++;
      }
      else if (answersCur1[i].equals("OTHER") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[2]++;
      }

      if (answersCur2[i].equals("GRADE 9") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[3]++;
      }
      else if (answersCur2[i].equals("GRADE 10") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[4]++;
      }
      else if (answersCur2[i].equals("GRADE 11") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[5]++;
      }
      else if (answersCur2[i].equals("GRADE 12") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[6]++;
      }
      
      if (answersCur3[i].equals("LOWER CLASS") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[7]++;
      }
      else if (answersCur3[i].equals("MIDDLE CLASS") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[8]++;
      }
      else if (answersCur3[i].equals("HIGH CLASS") && answersCur7[i].equals("BOTTLED WATER"))
      {
        statCount[9]++;
      }
    }
    //Prints out the different genders, grades, and social classes answer to what type of water is more environmentally friendly to obtain as a table and as percentages 
		//gender's preference of water after the test 
    if (answers1[2] != 0 )
    {
      System.out.println("\n-----ENVIRONMENT STATISTICS-----\n");
      //Prints out the number of people who choose bottled water
		  System.out.println("Percentage males, females, and others that choose bottled or tap water:\n");
      System.out.format("%-10s %8s %8s %8s", "", "Male", "Female", "Other\n");
      System.out.format("%-10s %8s %8s %8s", "Bottled", numberFormat.format(((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(((double)statCount[1]/answers1[1])*100) + "%", numberFormat.format(((double)statCount[2]/answers1[2])*100) + "%"+ "\n");
      //Prints out the number of people who choose tap water 
      System.out.format("%-10s %8s %8s %8s", "Tap", numberFormat.format(100 - ((double)statCount[0] /answers1[0])*100) + "%", numberFormat.format(100 - ((double)statCount[1]/answers1[1])*100) + "%", numberFormat.format(100 - ((double)statCount[2]/answers1[2])*100) + "%\n");
		}
    else
    {
      System.out.println("\n-----ENVIRONMENT STATISTICS-----\n");
      //Prints out the number of people who choose bottled water
		  System.out.println("Percentage males, females, and others that choose bottled or tap water:\n");
      System.out.format("%-10s %8s %8s %8s", "", "Male", "Female", "Other\n");
      System.out.format("%-10s %8s %8s %8s", "Bottled", numberFormat.format(((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(((double)statCount[1]/answers1[1])*100) + "%", 0.0 + "%"+ "\n");
      //Prints out the number of people who choose tap water 
      System.out.format("%-10s %8s %8s %8s", "Tap", numberFormat.format(100 - ((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(100 - ((double)statCount[1]/answers1[1])*100) + "%", 0.0 + "%\n");
    }
    
		
		//grade statistics
    //Prints out the number of people who choose bottled water
    System.out.println("\nPercentage of grade 9, 10, 11, 12 students that choose bottled or tap water: \n");
    System.out.format("%-10s %8s %8s %8s %8s", "", "Grade 9", "Grade 10", "Grade 11", "Grade 12\n");
    System.out.format("%-10s %8s %8s %8s %9s", "Bottled", numberFormat.format(((double)statCount[3]/answers2[0])*100) + "%", numberFormat.format(((double)statCount[4]/answers2[1])*100) + "%", numberFormat.format(((double)statCount[5]/answers2[2])*100) + "%", numberFormat.format(((double)statCount[6]/answers2[3])*100) + "%"+ "\n");
    //Prints out the number of people who choose tap water 
    System.out.format("%-10s %8s %8s %8s %9s", "Tap", numberFormat.format(100 - ((double)statCount[3]/answers2[0])*100) + "%", numberFormat.format(100 - ((double)statCount[4]/answers2[1])*100) + "%", numberFormat.format(100 - ((double)statCount[5]/answers2[2])*100) + "%", numberFormat.format(100 - ((double)statCount[6]/answers2[3])*100) + "%\n");

		// social class statistics
    //Prints out the number of people who choose bottled water
    System.out.println("\nPercentage of lower, middle, and high class people that choose bottled and tap water: \n");
    System.out.format("%-10s %10s %10s %10s", "", "Low Class", "Middle Class", "High Class\n");
    System.out.format("%-10s %10s %12s %11s", "Bottled", numberFormat.format(((double)statCount[7]/answers3[0])*100) + "%", numberFormat.format(((double)statCount[8]/answers3[1])*100) + "%", numberFormat.format(((double)statCount[9]/answers3[2])*100) + "%" + "\n");
    //Prints out the number of people who choose tap water 
    System.out.format("%-10s %10s %12s %12s", "Tap", numberFormat.format(100 - ((double)statCount[7]/answers3[0])*100) + "%", numberFormat.format(100 - ((double)statCount[8]/answers3[1])*100) + "%", numberFormat.format(100 - ((double)statCount[9]/answers3[2])*100) + "%\n\n");
  }
  
  public static void afterTestStatSummary(){ //q3
    DecimalFormat numberFormat = new DecimalFormat(".0");
    int[] statCount = new int [10];
    //the for loop checks if the answer to question 8 is bottled water and increases statCount by 1 if it is
    for (int i = 0; i<50; i++)
    {
      if (answersCur1[i].equals("MALE") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[0]++;
      }
      else if (answersCur1[i].equals("FEMALE") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[1]++;
      }
      else if (answersCur1[i].equals("OTHER") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[2]++;
      }

      if (answersCur2[i].equals("GRADE 9") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[3]++;
      }
      else if (answersCur2[i].equals("GRADE 10") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[4]++;
      }
      else if (answersCur2[i].equals("GRADE 11") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[5]++;
      }
      else if (answersCur2[i].equals("GRADE 12") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[6]++;
      }
      
      if (answersCur3[i].equals("LOWER CLASS") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[7]++;
      }
      else if (answersCur3[i].equals("MIDDLE CLASS") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[8]++;
      }
      else if (answersCur3[i].equals("HIGH CLASS") && answersCur8[i].equals("BOTTLED WATER"))
      {
        statCount[9]++;
      }
    }

		//Prints out the different genders, grades, and social classes preference of water, between bottled and tap water after the taste test
		//gender statistics
    if (answers1[2] != 0 )
    {
      System.out.println("-----PREFERENCE STATISTICS AFTER THE TEST-----\n");
      //Prints out the number of people who choose bottled water
		  System.out.println("Percentage males, females, and others that choose bottled or tap water:\n");
      System.out.format("%-10s %8s %8s %8s", "", "Male", "Female", "Other\n");
      System.out.format("%-10s %8s %8s %8s", "Bottled", numberFormat.format(((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(((double)statCount[1]/answers1[1])*100) + "%", numberFormat.format(((double)statCount[2]/answers1[2])*100) + "%"+ "\n");
      //Prints out the number of people who choose tap water 
      System.out.format("%-10s %8s %8s %8s", "Tap", numberFormat.format(100 - ((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(100 - ((double)statCount[1]/answers1[1])*100) + "%", numberFormat.format(100 - ((double)statCount[2]/answers1[2])*100) + "%\n");
		}
    else
    {
      System.out.println("-----PREFERENCE STATISTICS AFTER THE TEST-----\n");
      //Prints out the number of people who choose bottled water
		  System.out.println("Percentage males, females, and others that choose bottled or tap water:\n");
      System.out.format("%-10s %8s %8s %8s", "", "Male", "Female", "Other\n");
      System.out.format("%-10s %8s %8s %8s", "Bottled", numberFormat.format(((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(((double)statCount[1]/answers1[1])*100) + "%", 0.0 + "%"+ "\n");
      //Prints out the number of people who choose tap water 
      System.out.format("%-10s %8s %8s %8s", "Tap", numberFormat.format(100 - ((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(100 - ((double)statCount[1]/answers1[1])*100) + "%", 0.0 + "%\n");
    }
    
		
		//grades statistics 
    //Prints out the number of people who choose bottled water
    System.out.println("\nPercentage of grade 9, 10, 11, 12 students that choose bottled or tap water: \n");
    System.out.format("%-10s %8s %8s %8s %8s", "", "Grade 9", "Grade 10", "Grade 11", "Grade 12\n");
    System.out.format("%-10s %8s %8s %8s %9s", "Bottled", numberFormat.format(((double)statCount[3]/answers2[0])*100) + "%", numberFormat.format(((double)statCount[4]/answers2[1])*100) + "%", numberFormat.format(((double)statCount[5]/answers2[2])*100) + "%", numberFormat.format(((double)statCount[6]/answers2[3])*100) + "%"+ "\n");
    //Prints out the number of people who choose tap water 
    System.out.format("%-10s %8s %8s %8s %9s", "Tap", numberFormat.format(100 - ((double)statCount[3]/answers2[0])*100) + "%", numberFormat.format(100 - ((double)statCount[4]/answers2[1])*100) + "%", numberFormat.format(100 - ((double)statCount[5]/answers2[2])*100) + "%", numberFormat.format(100 - ((double)statCount[6]/answers2[3])*100) + "%\n");

		// social class statistics 
    //Prints out the number of people who choose bottled water
    System.out.println("\nPercentage of lower, middle, and high class people that choose bottled and tap water: \n");
    System.out.format("%-10s %10s %10s %10s", "", "Low Class", "Middle Class", "High Class\n");
    System.out.format("%-10s %10s %12s %11s", "Bottled", numberFormat.format(((double)statCount[7]/answers3[0])*100) + "%", numberFormat.format(((double)statCount[8]/answers3[1])*100) + "%", numberFormat.format(((double)statCount[9]/answers3[2])*100) + "%" + "\n");
    //Prints out the number of people who choose tap water 
    System.out.format("%-10s %10s %12s %11s", "Tap", numberFormat.format(100 - ((double)statCount[7]/answers3[0])*100) + "%", numberFormat.format(100 - ((double)statCount[8]/answers3[1])*100) + "%", numberFormat.format(100 - ((double)statCount[9]/answers3[2])*100) + "%\n");
  }

  //Prints out the different genders, grades, and social classes and which type of water they drink most frequently, between bottled and tap water before the taste test
  public static void freqStatSummary(){ 
    DecimalFormat numberFormat = new DecimalFormat(".0");
    int[] statCount = new int [10];
    //the for loop checks if the answer to question 5 is bottled water and increases statCount by 1 if it is
    for (int i = 0; i<50; i++)
    {
      if (answersCur1[i].equals("MALE") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[0]++;
      }
      else if (answersCur1[i].equals("FEMALE") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[1]++;
      }
      else if (answersCur1[i].equals("OTHER") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[2]++;
      }

      if (answersCur2[i].equals("GRADE 9") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[3]++;
      }
      else if (answersCur2[i].equals("GRADE 10") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[4]++;
      }
      else if (answersCur2[i].equals("GRADE 11") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[5]++;
      }
      else if (answersCur2[i].equals("GRADE 12") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[6]++;
      }
      
      if (answersCur3[i].equals("LOWER CLASS") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[7]++;
      }
      else if (answersCur3[i].equals("MIDDLE CLASS") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[8]++;
      }
      else if (answersCur3[i].equals("HIGH CLASS") && answersCur5[i].equals("BOTTLED WATER"))
      {
        statCount[9]++;
      }
    }

		//displays the frequency statics as a table showing which types of people choose bottled and tap water as a percentage


    // gender's frequency of water
     if (answers1[2] != 0 )
    {
      System.out.println("-----FREQUENCY STATISTICS-----\n");
      //Prints out the number of people who choose bottled water
		  System.out.println("Percentage males, females, and others that choose bottled or tap water:\n");
      System.out.format("%-10s %8s %8s %8s", "", "Male", "Female", "Other\n");
      System.out.format("%-10s %8s %8s %8s", "Bottled", numberFormat.format(((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(((double)statCount[1]/answers1[1])*100) + "%", numberFormat.format(((double)statCount[2]/answers1[2])*100) + "%"+ "\n");
      //Prints out the number of people who choose tap water 
      System.out.format("%-10s %8s %8s %8s", "Tap", numberFormat.format(100 - ((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(100 - ((double)statCount[1]/answers1[1])*100) + "%", numberFormat.format(100 - ((double)statCount[2]/answers1[2])*100) + "%\n");
		}
    else
    {
      System.out.println("-----FREQUENCY STATISTICS-----\n");
      //Prints out the number of people who choose bottled water
		  System.out.println("Percentage males, females, and others that choose bottled or tap water:\n");
      System.out.format("%-10s %8s %8s %8s", "", "Male", "Female", "Other\n");
      System.out.format("%-10s %8s %8s %8s", "Bottled", numberFormat.format(((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(((double)statCount[1]/answers1[1])*100) + "%", 0.0 + "%"+ "\n");
      //Prints out the number of people who choose tap water 
      System.out.format("%-10s %8s %8s %8s", "Tap", numberFormat.format(100 - ((double)statCount[0]/answers1[0])*100) + "%", numberFormat.format(100 - ((double)statCount[1]/answers1[1])*100) + "%", 0.0 + "%\n");
    }
    
		
		//grades frequency of water
    //Prints out the number of people who choose bottled water
    System.out.println("\nPercentage of grade 9, 10, 11, 12 students that choose bottled or tap water: \n");
    System.out.format("%-10s %8s %8s %8s %8s", "", "Grade 9", "Grade 10", "Grade 11", "Grade 12\n");
    System.out.format("%-10s %8s %8s %8s %9s", "Bottled", numberFormat.format(((double)statCount[3]/answers2[0])*100) + "%", numberFormat.format(((double)statCount[4]/answers2[1])*100) + "%", numberFormat.format(((double)statCount[5]/answers2[2])*100) + "%", numberFormat.format(((double)statCount[6]/answers2[3])*100) + "%"+ "\n");
    //Prints out the number of people who choose tap water 
    System.out.format("%-10s %8s %8s %8s %9s", "Tap", numberFormat.format(100 - ((double)statCount[3]/answers2[0])*100) + "%", numberFormat.format(100 - ((double)statCount[4]/answers2[1])*100) + "%", numberFormat.format(100 - ((double)statCount[5]/answers2[2])*100) + "%", numberFormat.format(100 - ((double)statCount[6]/answers2[3])*100) + "%\n");

		// social class frequency of water
    //Prints out the number of people who choose bottled water
    System.out.println("\nPercentage of lower, middle, and high class people that choose bottled and tap water: \n");
    System.out.format("%-10s %10s %10s %10s", "", "Low Class", "Middle Class", "High Class\n");
    System.out.format("%-10s %10s %12s %11s", "Bottled", numberFormat.format(((double)statCount[7]/answers3[0])*100) + "%", numberFormat.format(((double)statCount[8]/answers3[1])*100) + "%", numberFormat.format(((double)statCount[9]/answers3[2])*100) + "%" + "\n");
    //Prints out the number of people who choose tap water 
    System.out.format("%-10s %10s %12s %12s", "Tap", numberFormat.format(100 - ((double)statCount[7]/answers3[0])*100) + "%", numberFormat.format(100 - ((double)statCount[8]/answers3[1])*100) + "%", numberFormat.format(100 - ((double)statCount[9]/answers3[2])*100) + "%\n\n");

  }
}