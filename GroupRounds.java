package com.company;

public class GroupRounds {

    private Group group;
    private Team[] round1 = new Team[4];
    private Team[] round2 = new Team[4];
    private Team[] round3 = new Team[4];
    private Team[][] GroupRounds = new Team[3][4];



    public GroupRounds(){
        round1 = null;
        round2 = null;
        round3 = null;
    }


    public GroupRounds(Group group){
        this.group = group;
        // creates the round groups
        //round1
        round1[0] = group.getGroupTeam(0);
        round1[1] = group.getGroupTeam(3);
        round1[2] = group.getGroupTeam(1);
        round1[3] = group.getGroupTeam(2);
        // round2
        round2[0] = group.getGroupTeam(1);
        round2[1] = group.getGroupTeam(3);
        round2[2] = group.getGroupTeam(0);
        round2[3] = group.getGroupTeam(2);
        // round3
        round3[0] = group.getGroupTeam(2);
        round3[1] = group.getGroupTeam(3);
        round3[2] = group.getGroupTeam(0);
        round3[3] = group.getGroupTeam(1);

        GroupRounds[0] = round1;
        GroupRounds[1] = round2;
        GroupRounds[2] = round3;
    }


    public Team getRound1(int num){
        return round1[num];
    }

    public Team getRound2(int i){
        return round2[i];
    }

    public Team getRound3(int i){
        return round3[i];
    }

    public Team[][] getGroupRound(){ // first index number of the round, second
        return GroupRounds;          // index , index in round
    }





}
