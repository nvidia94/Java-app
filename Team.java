package com.company;

/**
 * Team class for the tournament */

public class Team {

    private int teamId; // holds team id number
    private String teamName; // holds team country
    private int groupId; // holds the groupid for the team
    private int matchesPlayed; // holds the matches
    private int wins; // hold the wins
    private int draws; // holds the draws
    private int losses; // hold the looses
    private int golsFor; // hold the gols against
    private int golsAgainst; // hold the gols against
    private int golsDiff ; // holds the gol differential
    private int points; // hold the points

    /**
     * Constructors
     * */

    public Team(){}

    public Team(Team team){
        this.teamId = team.teamId;
        this.teamName = team.teamName;
        this.matchesPlayed = team.matchesPlayed;
        this.wins = team.wins;
        this.draws = team.draws;
        this.losses = team.losses;
        this.golsFor = team.golsFor;
        this.golsAgainst = team.golsAgainst;
        this.golsDiff = team.golsDiff;
        this.points = team.points;
    }

    public Team(String teamName){
        this.teamName = teamName;
    }

    public Team(String teamName, int matchesPlayed, int wins,
                int draws, int losses, int golsFor, int golsAgainst,
                int golsDiff, int points){
        this.teamName = teamName;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.golsFor = golsFor;
        this.golsAgainst = golsAgainst;
        this.golsDiff = golsDiff;
        this.points = points;
    }


    /**
     *  Accessors and mutators methods methods
     */

    public int getGroupId(){
        return groupId;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName(){
        return teamName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getGolsAgainst() {
        return golsAgainst;
    }

    public int getGolsFor() {
        return golsFor;
    }

    public int getGolsDiff() {
        return golsDiff;
    }

    public int getPoints() {
        return points;
    }


    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setWins() {
        this.wins += 1;
    }

    public void setDraws() {
        this.draws += 1;
    }

    public void setLosses() {
        this.losses += 1;
    }

    public void setGolsFor(int i) {
        this.golsFor +=i;
    }

    public void setGolsAgainst(int i) {
        this.golsAgainst += i;
    }

    public void setGolsDiff() {
        this.golsDiff = (this.golsFor -
        this.golsAgainst);
    }

    public void setPointsWins() {
        this.points += 3;
    }

    public void setPointsDraw(){
        this.points += 1;
    }

    public void setMatchesPlayed() {
        this.matchesPlayed += 1;
    }


}
