package com.company;

public class Group {


    final int NUM_TEAMS = 4; // number of teams
    private Team[] group = new Team[NUM_TEAMS]; // array of Team objects
    private Character GroupName;
    private Team team;

    private int GroupId;

    public Group(){
        group[0] = new Team();
        group[1] = new Team();
        group[2] = new Team();
        group[3] = new Team();
    }




  // return a team by his TeamId number
    public Team getGroupTeam(int TeamId){
        return group[TeamId];
    }

  // sets the team by his TeamId number
    public void setGroupTeam(Team team, int TeamId) {
        group[TeamId] = team;
        team.setTeamId(TeamId);
    }
    // set each team his name by his id
    public void setGroupTeam(String team_name, int TeamId){
        group[TeamId].setTeamName(team_name);
    }

    public void setGroupTeam(Team team){
        this.team = new Team(team);
    }




    // Accessors and mutators methods

    public void setGroupId(int GroupId){
        this.GroupId = GroupId;
    }

    public void setGroupName(char GroupName){
        this.GroupName = GroupName;
    }
    public Character getGroupName(){
        return GroupName;
    }






}

