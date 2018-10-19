package com.company;

import java.util.Calendar;
import java.util.*;

public class Schedule {

    private Matches_01 matches_01;
    private Standings standings;
    private WorldCup worldCup;
    // GroupArray
    private Group[][] groupArray;
    // Indexes Array
    private int index_8[] = new int[]{0,0,1,0,0,1,1,1,1,0,0,0,1,1,0,1,0,2,1,2,0,3,1,3,1,2,0,2,1,3,0,3};
    private int index_6[] = new int[]{0,0,1,0,0,1,1,1,1,0,0,0,1,1,0,1,0,2,1,2,1,2,0,2};
    private int index_4[] = new int[]{0,0,1,0,0,1,1,1,1,0,0,0,1,1,0,1};
    private int index_2[] = new int[]{0,0,1,0,1,0,0,0};



    public Schedule(WorldCup worldCup){
        matches_01 = new Matches_01(worldCup);
        matches_01.getMatches();
        standings = new Standings(worldCup);
        this.worldCup = new WorldCup(worldCup.getWorldcup().length);
        this.worldCup = worldCup;
        groupArray = new Group[2][worldCup.getWorldcup().length];
        // counters
        int count_even = 0;
        int count_odd = 1;
        int index=0;
        while (count_odd < worldCup.getWorldcup().length){
            groupArray[0][index] = worldCup.getWorldcupGroup(worldCup.getWorldcup().length - (worldCup.getWorldcup().length - count_even));
            count_even += 2;
            groupArray[1][index] = worldCup.getWorldcupGroup(worldCup.getWorldcup().length - (worldCup.getWorldcup().length - count_odd));
            count_odd += 2;
            index+=1;
        }

    }

    public Matches_01 returnMatches(){
        return matches_01;
    }

    public void generateSchedule(){

       String[] month = {"January", "February", "March", "Abril", "May", "June",
               "July", "Augost", "September", "Octuber", "November", "December"};
       int days_month[] = new int[31];
       for(int i=1; i<=30; i++)
           days_month[i] = i;

        String[] hours = {"17:00 Local Time Luzhniki Stadium Moscow" , "18:00 Local Time Kazan Arena Kazan" ,
                "19:00 Local Time Saint Petersburgs Stadium St.Petersburgs", "21:00 Local Time Samara Arena Samara"};


       StringBuilder str = new StringBuilder("Day 1: " + month[5] + " " +  days_month[14] + "\n" +
               hours[1] + "\n");
       int day_counter=0;
       int day =1;
       int months = 14;
       int counter=2;
       int counter2=3;
       str = str = str.append(matches_01.getMatchList(0).getTeamName() + " vs " +
               matches_01.getMatchList(1).getTeamName()+ " " +
               hours[day_counter] + "\n" );
       do {
           day_counter += 1;
           if (day_counter == 3) {
               day_counter = 0;
               day += 1;
               months += 1;
               str.append(" Day " + day  + " " + month[5] + " " +  days_month[months] + "\n" );
           }
           str = str.append(matches_01.getMatchList(counter).getTeamName() + " vs " +
                   matches_01.getMatchList(counter2).getTeamName()+ " " +
                   hours[day_counter] + "\n" );

           counter +=2; counter2 +=2;


       }while(counter2 <= matches_01.matchesListLength());
       System.out.println(str);


   }

    public void generateRoundOf16(){

       String[] month = {"January", "February", "March", "April", "May", "June",
               "July", "August", "September", "October", "November", "December"};
       int days_month[] = new int[31];
       for(int i=1; i<=30; i++)
           days_month[i] = i;

        String[] hours = {"17:00 Local Time Luzhniki Stadium Moscow" , "18:00 Local Time Kazan Arena Kazan" ,
                "19:00 Local Time Saint Petersburgs Stadium St.Petersburgs", "21:00 Local Time Samara Arena Samara"};

       // Strings to hold matches and out string
       String str_match = new String();
       StringBuilder str_out   = new StringBuilder();
       // counters
       int counter=0;
       int index=0;
       int counter_match=0; int counter_day=0;
       int days = (worldCup.getWorldcup().length / 2);

       str_out = str_out.append("Day 17: " + month[5] + " " +  days_month[30] + "\n");

       if (days == 4){
           while (counter_match < worldCup.getWorldcup().length){
               str_match+=(standings.getGroupWinner(groupArray[index_8[index]][index_8[index + 1]]).getTeamName() + " vs "
               + standings.getGroupRunner(groupArray[index_8[index+2]][index_8[index + 3]]).getTeamName() + " " +
                       hours[1] + "\n");
               if (counter == 2){
                   counter=0;
                   counter_day+=1;
                   str_out.append("Day " + (17 + counter_day) + month[6] + " " + days_month[counter_day] + "\n");
               }

               str_out.append(str_match);
               str_match ="";
               counter+=1;
               index+=4;
               counter_match+=1;


           }

           System.out.print(str_out);
       }
       else if (days == 3){

           while (counter_match < worldCup.getWorldcup().length){
               str_match+=(standings.getGroupWinner(groupArray[index_6[index]][index_6[index + 1]]).getTeamName() + " vs "
                       + standings.getGroupRunner(groupArray[index_6[index+2]][index_6[index + 3]]).getTeamName() + " " +
                       hours[1] + "\n");
               if (counter == 2){
                   counter=0;
                   counter_day+=1;
                   str_out.append("Day " + (17 + counter_day) + month[6] + " " + days_month[counter_day] + "\n");
               }

               str_out.append(str_match);
               str_match ="";
               counter+=1;
               index+=4;
               counter_match+=1;


           }

           System.out.println(str_out);
       }
       else if (days == 2){

           while (counter_match < worldCup.getWorldcup().length){
               str_match+=(standings.getGroupWinner(groupArray[index_4[index]][index_4[index + 1]]).getTeamName() + " vs "
                       + standings.getGroupRunner(groupArray[index_4[index+2]][index_4[index + 3]]).getTeamName() + " " +
                       hours[1] + "\n");
               if (counter == 2){
                   counter=0;
                   counter_day+=1;
                   str_out.append("Day " + (17 + counter_day) + month[6] + " " + days_month[counter_day] + "\n");
               }

               str_out.append(str_match);
               str_match ="";
               counter+=1;
               index+=4;
               counter_match+=1;


           }

           System.out.print(str_out);
       }
       else if (days == 1){

           while (counter_match < worldCup.getWorldcup().length){
               str_match+=(standings.getGroupWinner(groupArray[index_2[index]][index_2[index + 1]]).getTeamName() + " vs "
                       + standings.getGroupRunner(groupArray[index_2[index+2]][index_2[index + 3]]).getTeamName() + " " +
                       hours[1] + "\n");
               if (counter == 2){
                   counter=0;
                   counter_day+=1;
                   str_out.append("Day " + (17 + counter_day)+ ": " + month[6] + " " + days_month[counter_day] + "\n");
               }

               str_out.append(str_match);
               str_match = "";
               counter+=1;
               index+=4;
               counter_match+=1;


           }

           System.out.print(str_out);
       }






   }

   public void generateQuaterFinals(ArrayList<Team> winners){

       String[] month = {"January", "February", "March", "April", "May", "June",
               "July", "August", "September", "October", "November", "December"};
       int days_month[] = new int[31];
       for(int i=1; i<=30; i++)
           days_month[i] = i;

       String[] hours = {"17:00 Local Time Luzhniki Stadium Moscow" , "18:00 Local Time Kazan Arena Kazan" ,
               "19:00 Local Time Saint Petersburgs Stadium St.Petersburgs", "21:00 Local Time Samara Arena Samara"};

       StringBuilder str_out  = new StringBuilder();

       if (winners.size() == 8) {
           str_out.append("Day 21: " + month[6] + " " + days_month[6] + "\n");
           str_out.append(winners.get(0).getTeamName() + " vs " + winners.get(1).getTeamName() + " " +
                   hours[1] + "\n");
           str_out.append(winners.get(4).getTeamName() + " vs " + winners.get(5).getTeamName() +
                   hours[3] + "\n");
           str_out.append("Day 22: " + month[6] + " " + days_month[7] + "\n");
           str_out.append(winners.get(6).getTeamName() + " vs " + winners.get(7).getTeamName() +
                   hours[1] + "\n");
           str_out.append(winners.get(2).getTeamName() + " vs " + winners.get(3).getTeamName() +
                   hours[3] + "\n");
       }
       else if (winners.size() == 6){
           str_out.append("Day 21: " + month[6] + " " + days_month[6] + "\n");
           str_out.append(winners.get(0).getTeamName() + " vs " + winners.get(1).getTeamName() +
                   hours[1] + "\n");
           str_out.append(winners.get(4).getTeamName() + " vs " + winners.get(5).getTeamName() +
                   hours[3] + "\n");
           str_out.append("Day 22: " + month[6] + " " + days_month[7] + "\n");
           str_out.append(winners.get(2).getTeamName() + " vs " + winners.get(3).getTeamName() +
                   hours[3] + "\n");
       }
       else if (winners.size() == 4){
           str_out.append("Day 21: " + month[6] + " " + days_month[6] + "\n");
           str_out.append(winners.get(0).getTeamName() + " vs " + winners.get(1).getTeamName() +
                   hours[1] + "\n");
           str_out.append(winners.get(2).getTeamName() + " vs " + winners.get(3).getTeamName() +
                   hours[3] + "\n");
       }
       else if (winners.size() == 2){
           str_out.append("Day 21: " + month[6] + " " + days_month[6] + "\n");
           str_out.append(winners.get(0).getTeamName() + " vs " + winners.get(1).getTeamName() +
                   hours[1] + "\n");
       }

       System.out.println(str_out);


   }

   public void generateSemiFinals(ArrayList<Team> winners){

       String[] month = {"January", "February", "March", "April", "May", "June",
               "July", "August", "September", "October", "November", "December"};
       int days_month[] = new int[31];
       for(int i=1; i<=30; i++)
           days_month[i] = i;

       String[] hours = {"17:00 Local Time Luzhniki Stadium Moscow" , "18:00 Local Time Kazan Arena Kazan" ,
               "19:00 Local Time Saint Petersburgs Stadium St.Petersburgs", "21:00 Local Time Samara Arena Samara"};

       StringBuilder str_out  = new StringBuilder();

       if (winners.size() == 4){
           str_out.append("Day 23: " + month[6] + " " + days_month[10] + "\n");
           str_out.append(winners.get(0).getTeamName() + " vs " + winners.get(1).getTeamName() +
                   hours[1] + "\n");
           str_out.append("Day 24: " + month[6] + " " + days_month[11] + "\n");
           str_out.append(winners.get(2).getTeamName() + " vs " + winners.get(3).getTeamName() +
                   hours[1] + "\n");
       }
       else if (winners.size() == 3){
           str_out.append("Day 23: " + month[6] + " " + days_month[10] + "\n");
           str_out.append(winners.get(0).getTeamName() + " vs " + winners.get(1).getTeamName() +
                   hours[1] + "\n");
       }
       else if (winners.size() == 2){
           str_out.append("Day 23: " + month[6] + " " + days_month[10] + "\n");
           str_out.append(winners.get(0).getTeamName() + " vs " + winners.get(1).getTeamName() +
                   hours[1] + "\n");

       }
       else if (winners.size() == 1){
           str_out.append("Day 23: " + month[6] + " " + days_month[10] + "\n");
           /*str_out.append(winners.get(0).getTeamName() + " vs " + winners.get(1).getTeamName() +
                   hours[1] + "\n");*/
       }
       System.out.println(str_out);
   }

   public void generateFinal(ArrayList<Team> winners1, ArrayList<Team> winners2) {
       String[] month = {"January", "February", "March", "April", "May", "June",
               "July", "August", "September", "October", "November", "December"};
       int days_month[] = new int[31];
       for (int i = 1; i <= 30; i++)
           days_month[i] = i;

       String[] hours = {"17:00 Local Time Luzhniki Stadium Moscow" , "18:00 Local Time Kazan Arena Kazan" ,
               "19:00 Local Time Saint Petersburgs Stadium St.Petersburgs", "21:00 Local Time Samara Arena Samara"};

       StringBuilder str_out = new StringBuilder();

       if (winners1.size() == 2){
           str_out.append("Final Day: " + month[6] + " " + days_month[15] + "\n");
           str_out.append(winners1.get(0).getTeamName() + " vs " + winners1.get(1).getTeamName() +
                   hours[1] + "\n");

       }else if (winners1.size() == 1){
           str_out.append("Final Day: " + month[6] + " " + days_month[15] + "\n");
           str_out.append(winners1.get(0).getTeamName() + " vs " + winners2.get(2).getTeamName() +
                   hours[1] + "\n");
       }else if (winners1.size() == 0){
           str_out.append("BYE BYE>>>>");
       }

       System.out.println(str_out);

   }



   public int getIndex_8(int i){
        return index_8[i];
   }

   public int getIndex_6(int i){
        return index_6[i];
   }

   public int getIndex_4(int i){
        return index_4[i];
   }

   public int getIndex_2(int i){
        return index_2[i];
   }

   public Group getGroupArray(int index1, int index2){
        return groupArray[index1][index2];
   }
}
