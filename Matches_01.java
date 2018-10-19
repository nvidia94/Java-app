package com.company;

import java.util.ArrayList;

public class Matches_01 {

    private WorldCup worldCup;
    private GroupRounds match_array[];
    private ArrayList<Team> matches = new ArrayList<Team>();

    public Matches_01(WorldCup worldCup){
        this.worldCup = new WorldCup(worldCup.getWorldcup().length);
        this.worldCup = worldCup;
        this.match_array = new GroupRounds[(this.worldCup.getWorldcup().length)];
        for (int i=0; i < this.worldCup.getWorldcup().length; i++){
            match_array[i] = new GroupRounds(this.worldCup.getWorldcupGroup(i));
        }
    }

    public void getMatches() {
        for (int k = 0; k < 3; k++)
            for (int i = 0; i < this.worldCup.getWorldcup().length; i++)
            {    int counter = 0;
                 int counter2 = 1;
                 do {
                     matches.add(match_array[i].getGroupRound()[k][counter]);
                     matches.add(match_array[i].getGroupRound()[k][counter2]);
            counter += 2;
            counter2 += 2;

        } while (counter2 == 3);
    }

    }

    public Team getMatchList(int index) {
        return matches.get(index);
    }

    public int matchesListLength(){
        return matches.size();
    }



}
