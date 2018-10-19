package com.company;

public class WorldCup {

    private final int Max_NUM_GROUPS = 8; // max number of groups
    private Group worldcup[];


   public WorldCup(){
       this.worldcup = new Group[Max_NUM_GROUPS];
       for(int i=1; i<Max_NUM_GROUPS; i++)
           worldcup[i] = new Group();
   }


    public WorldCup(int NUM_GROUPS){
       this.worldcup = new Group[NUM_GROUPS];
        for(int i=0; i< NUM_GROUPS; i++)
        worldcup[i] = new Group();

    }


    // return a group by his GroupId number
    public Group getWorldcupGroup(int GroupId){
        return worldcup[GroupId];
    }

    public void setWorldcupGroupsName(int NUM_GROUPS){
       String str = "ABCDEFGHIJKL";
       for(int i=0; i<NUM_GROUPS; i++){
           char c[] = str.toCharArray();
           worldcup[i].setGroupName(c[i]);
       }

    }

    // sets the group by his GroupId number
    public void setWorldcupGroup(Group group, int GroupId) {
        worldcup[GroupId] = group;
        group.setGroupId(GroupId);
    }

    // return each group name
    public Character getWorldCupGroupName(int GroupId){
       return worldcup[GroupId].getGroupName();
    }


    public Group[] getWorldcup(){
       return worldcup;
    }


}

