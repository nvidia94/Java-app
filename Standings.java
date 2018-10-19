package com.company;

import java.text.NumberFormat;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Standings {



    private WorldCup worldCup = new WorldCup();
    private Team WorldChampion = new Team();


    public Standings(WorldCup worldCup){
          this.worldCup = worldCup; }



    // To string method to display the standings
    public String toString(WorldCup worldCup, int groupId, int teamId){
        String str; // to hold a descriptive string
        // create a formatted string describing the item.
        str =(        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getTeamName() + ": " +
                "MP: " + worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getMatchesPlayed() +
                " W: " + worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getWins() +
                " D: " + worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getDraws() +
                " L: " + worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getLosses() +
                " GF: " + worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getGolsFor() +
                " GA: " + worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getGolsAgainst() +
                " GD: " + worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getGolsDiff() +
                " PTS: " + worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).getPoints());
        // return the string
        return str;
    }



    /**
     *  All the calc method sum 1 to each stadistic and calculate
     *  the goal diferential and points for a Team object
     */
    public void calcMatchesPlayed(WorldCup worldCup, int groupId, int teamId){
        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).setMatchesPlayed();
    }

    public void calcWins(WorldCup worldCup, int groupId, int teamId){
        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).setWins();
    }

    public void calcDraws(WorldCup worldCup, int groupId, int teamId){
        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).setDraws();
    }

    public void calcLoses(WorldCup worldCup, int groupId, int teamId){
        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).setLosses();
    }

  /*  public void calcGolsFoward(WorldCup worldCup, int groupId, int teamId){
        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).setGolsFor();
    }*/

   /* public void calcGolsAgainst(WorldCup worldCup, int groupId, int teamId){
        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).setGolsAgainst();
    }*/

    public void calcWinPoints(WorldCup worldCup, int groupId, int teamId){
        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).setPointsWins();
    }

    public void calcDrawPoints(WorldCup worldCup, int groupId, int teamId){
        worldCup.getWorldcupGroup(groupId).getGroupTeam(teamId).setPointsDraw();
    }

    // methods to set the group winner and runner by sorting the teams by amount of points
    // Group Winner
    public Team getGroupWinner(Group group){
        Team temp = new Team();
        Team team1, team2, team3, team4;
        team1 =  group.getGroupTeam(0);
        team2 =  group.getGroupTeam(1);
        team3 =  group.getGroupTeam(2);
        team4 =  group.getGroupTeam(3);

        if(team1.getPoints() > team2.getPoints()){
            temp = team1; team1 = team2; team2 = temp;
        }
        if(team3.getPoints() > team4.getPoints()){
            temp = team3; team3 = team4; team4 = temp;
        }
        if(team1.getPoints() > team4.getPoints()){
            temp = team1; team1 = team3; team3 = temp;
        }
        if(team2.getPoints() > team4.getPoints()){
            temp = team2; team2 = team4; team4 = temp;
        }
        if(team2.getPoints() > team3.getPoints()){
            temp = team2; team2 = team3; team3 = temp;
        }
        if(team4.getPoints() == team3.getPoints())
        return team3;
        else return team4;
    }

    // Group Runner
    public Team getGroupRunner(Group group){
        Team temp = new Team();
        Team team1, team2, team3, team4;
        team1 = group.getGroupTeam(0);
        team2 = group.getGroupTeam(1);
        team3 = group.getGroupTeam(2);
        team4 = group.getGroupTeam(3);

        if(team1.getPoints() > team2.getPoints()){
            temp = team1; team1 = team2; team2 = temp;
        }
        if(team3.getPoints() > team4.getPoints()){
            temp = team3; team3 = team4; team4 = temp;
        }
        if(team1.getPoints() > team4.getPoints()){
            temp = team1; team1 = team3; team3 = temp;
        }
        if(team2.getPoints() > team4.getPoints()){
            temp = team2; team2 = team4; team4 = temp;
        }
        if(team2.getPoints() > team3.getPoints()){
            temp = team2; team2 = team3; team3 = temp;
        }
        if(team4.getPoints() == team3.getPoints())
            return team4;
        else return team3;

    }
/*
    // get the round of sixteen winners
    public Team getRoundOfSixteenWinners(int teamId) {return roundOfSixteenWinners.get(teamId);}
    public int getRoundOfSixTeenLength(){return roundOfSixteenWinners.size();}
    // get the quarter finals winners
    public Team getQuarterFinalsWinners(int teamId){return quarterFinalsWinners.get(teamId);}
    // get the semi finals winners
    public Team getSemiFinalsWinners(int teamId){return semiFinalsWinners.get(teamId);}
*/


    public void PlayingMatch(Team team1, Team team2, Scanner in){
        int amount_gols = 0;
        int team1_gols, team2_gols;
        team1.setMatchesPlayed();
        team2.setMatchesPlayed();
        System.out.println(team1.getTeamName() + " vs " +
                team2.getTeamName());
        System.out.println("Enter " + team1.getTeamName() +
                " amount of gols foward");
        amount_gols = in.nextInt();
        team1_gols = amount_gols;
        team1.setGolsFor(amount_gols);
        team2.setGolsAgainst(amount_gols);

        System.out.println("Enter " + team2.getTeamName() +
                " amount of gols foward");
        amount_gols = in.nextInt();
        team2_gols = amount_gols;
        team2.setGolsFor(amount_gols);
        team1.setGolsAgainst(amount_gols);

        if (team1_gols > team2_gols && team1_gols != team2_gols) {
            team1.setWins();
            team1.setPointsWins();
            team2.setLosses();
        } else if (team1_gols == team2_gols) {
            team1.setDraws();
            team2.setDraws();
            team1.setPointsDraw();
            team2.setPointsDraw();
        } else if (team1_gols < team2_gols) {
            team1.setLosses();
            team2.setWins();
            team2.setPointsWins();
        }
        team1.setGolsDiff();
        team2.setGolsDiff();
    }

    public void PlayingPlayOff(Team team1, Team team2,ArrayList<Team> winners, Scanner in){
        int amount_gols = 0;
        int team1_gols, team2_gols;
        team1.setMatchesPlayed();
        team2.setMatchesPlayed();
        System.out.println("Enter " + team1.getTeamName() +
                " amount of gols foward");
        amount_gols = in.nextInt();
        team1_gols = amount_gols;
        team1.setGolsFor(amount_gols);
        team2.setGolsAgainst(amount_gols);

        System.out.println("Enter " + team2.getTeamName() +
                " amount of gols foward");
        amount_gols = in.nextInt();
        team2_gols = amount_gols;
        team2.setGolsFor(amount_gols);
        team1.setGolsAgainst(amount_gols);

        if (team1_gols > team2_gols && team1_gols != team2_gols) {
            team1.setWins();
            team1.setPointsWins();
            winners.add(team1);
            team2.setLosses();
        } else if (team1_gols == team2_gols) {
            System.out.println("Select the winner by penaltys: \n" +
                    "1. " + team1.getTeamName() + "\n" +
                    "2. " + team2.getTeamName());
            amount_gols = in.nextInt();
            switch (amount_gols){
                case 1:{team1.setWins();
                    team1.setPointsWins();
                    winners.add(team1);
                    team2.setLosses();}break;
                case 2:{team1.setLosses();
                    team2.setWins();
                    team2.setPointsWins();
                    winners.add(team2);}break;
            }
        } else if (team1_gols < team2_gols) {
            team1.setLosses();
            team2.setWins();
            team2.setPointsWins();
            winners.add(team2);}
        team1.setGolsDiff();
        team2.setGolsDiff();
    }





}
