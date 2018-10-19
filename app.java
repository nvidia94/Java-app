package com.company;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.ArrayList;


public class app extends Application  {


    private boolean data = false;
    private boolean worldcup_creator = true;
    private int day_counter = 0;
    private int day = 1;
    private int months = 14;
    private int counter = 2;
    private int counter2 = 3;
    private int counter_text = 0;
    private int index=0;
    private int round16_counter1 = 0;
    private int round16_counter2 = 0;
    private boolean click_matches=true;
    private boolean click_group=false;
    private boolean click_Round16 = true;
    private boolean click_quarter = true;
    private boolean click_semifinal = true;
    private boolean click_final = true;
    private ArrayList<TextField> textField1 = new ArrayList<TextField>();
    private ArrayList<TextField> textField2 = new ArrayList<TextField>();
    // GroupArray
    private Group[][] groupArray;
    // Indexes Array
    private int index_8[] = new int[]{0,0,1,0,0,1,1,1,1,0,0,0,1,1,0,1,0,2,1,2,0,3,1,3,1,2,0,2,1,3,0,3};
    private Matches_01 matches_01;
    private int matches_record[];


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        WorldCup worldCup = new WorldCup(8);

        primaryStage.setTitle("2018 RUSSIA FIFA WORLD CUP");

        GridPane grid = new GridPane();
        ScrollPane scroller = new ScrollPane(grid);
        scroller.setFitToWidth(true);
        scroller.setFitToHeight(true);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(225);
        grid.setVgap(100);
        grid.setId("primary");

        grid.setPadding(new Insets(5,5,5,5));

        Scene scene = new Scene(scroller, 1730, 775);
        primaryStage.setScene(scene);

        //file:C:\Users\perer\Documents\wor.png
        Image image1 = new Image("file:D:\\Java\\app_fax\\src\\com\\company\\wor.png");
        ImageView imageView = new ImageView(image1);
        imageView.setId("image");

      // Text scenetitle = new Text("2018 FIFA WORLD CUP RUSSIA");
        HBox hbox10 = new HBox();
        hbox10.setAlignment(Pos.CENTER);
        hbox10.setId("scene");
        hbox10.getChildren().add(imageView);
        grid.add(hbox10, 0,0,5,1);

        Label create_worldcup = new Label("Create World Cup");
        create_worldcup.setTextFill(Color.WHITE);
        VBox vbox1 = new VBox(create_worldcup);
        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setSpacing(10);
        vbox1.setId("vbox1");
        grid.add(vbox1, 0,1);

        Label matches = new Label("Matches");
        VBox vbox2 = new VBox(matches);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(10);
        grid.add(vbox2,0,2);
        vbox2.setId("vbox2");


        Label groups = new Label("Group Standings");
        VBox vbox3 = new VBox(groups);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setSpacing(10);
        grid.add(vbox3,0,3);
        vbox3.setId("vbox3");


        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.setHgap(55);
        grid1.setVgap(25);

        grid1.setPadding(new Insets(12,12,12,12));
        grid.add(grid1, 1, 1, 2, 3);
        grid1.setVisible(false);

        Label no_groups = new Label("No. Groups");
        Label selec_group = new Label("Select a Group");
        ComboBox comboBox1 = new ComboBox();
        comboBox1.setId("combo1");
        for (int i=1; i<=8; i++)
            comboBox1.getItems().add(i);
        ComboBox comboBox2 = new ComboBox();
        comboBox2.setId("combo2");


        Label team1 = new Label("Team 1.");
        Label team2 = new Label("Team 2.");
        Label team3 = new Label("Team 3.");
        Label team4 = new Label("Team 4.");
        VBox vbox4 =  new VBox(12,team1, team2, team3, team4);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setId("vbox4");


        TextField team1_name = new TextField();
        TextField team2_name = new TextField();
        TextField team3_name = new TextField();
        TextField team4_name = new TextField();
        VBox vbox5 = new VBox(12,team1_name,team2_name,team3_name,team4_name);
        vbox5.setId("vbox5");

//======================================================================================================================


        // Date Time And Locations Strings for Matches
        String[] month = {"January", "February", "March", "Abril", "May", "June",
                "July", "Augost", "September", "Octuber", "November", "December"};
        int days_month[] = new int[31];
        for (int i = 1; i <= 30; i++)
            days_month[i] = i;

        String[] hours = {"17:00 Local Time Luzhniki Stadium Moscow", "18:00 Local Time Kazan Arena Kazan",
                "19:00 Local Time Saint Petersburgs Stadium St.Petersburgs", "21:00 Local Time Samara Arena Samara"};

       VBox  vbox6 = new VBox(35);
       Label matches_date = new Label("Day 1 " + month[5] + " " +  days_month[14]);
       vbox6.getChildren().add(matches_date);

       Button button_update = new Button("Update Schedule");

       VBox vbox7 = new VBox(35);
       Label matches_date1 = new Label("Day 17 " + month[5] + " " +  days_month[30]);
       vbox7.getChildren().add(matches_date1);



//======================================================================================================================
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.TOP_CENTER);
        grid2.setHgap(5);
        grid2.setVgap(35);


        grid2.add(vbox6,1,1);
        vbox6.setVisible(false);
        grid2.add(vbox7,1,1);
        vbox7.setVisible(false);

        Label group_phase = new Label("Group Phase");
        Label Round_of_16 = new Label("Round of Sixteen");
        Label quarter  = new Label("Quarter Finals");
        Label semifinal = new Label("Semi-finals");
        Label finales = new Label("Final");
        HBox hbox4 = new HBox(group_phase,Round_of_16,quarter,semifinal,finales);
        hbox4.setSpacing(35);
        grid2.add(hbox4,1,0);





        grid2.setPadding(new Insets(12,12,12,12));
        grid.add(grid2, 1, 1, 2, 5);
        grid2.setVisible(false);




        VBox vbox = new VBox(55);

        Label groups_letter = new Label("Group A");  // + worldCup.getWorldCupGroup(0).getGroupName;
        Label mp  = new Label("  MP");
        Label w   = new Label(" W ");
        Label d   = new Label("D  ");
        Label l   = new Label("L  ");
        Label gf  = new Label(" GF");
        Label ga  = new Label(" GA");
        Label gd  = new Label("+/-");
        Label p   = new Label("PTS");
        HBox hbox1 = new HBox(groups_letter,mp,w,d,l,gf,ga,gd,p);
        hbox1.setSpacing(35);

        vbox.getChildren().add(hbox1);


        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.TOP_CENTER);
        grid3.setHgap(55);
        grid3.setVgap(35);

        grid3.add(vbox,1,0);
        grid3.setPadding(new Insets(12,12,12,12));
        grid.add(grid3, 2, 1, 2, 5);
        grid3.setVisible(false);

//=======================================================================================================================


        create_worldcup.setOnMouseClicked(event -> {
            if(worldcup_creator != false) {
                grid2.setVisible(false);
                grid1.setVisible(true);
                grid3.setVisible(false);

                comboBox1.setOnAction(event1 -> {
                    comboBox2.getItems().removeAll();
                    int value = comboBox1.getSelectionModel().getSelectedIndex();
                    for (int i = 0; i <= value; i++) {
                        String str[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
                        comboBox2.getItems().add(str[i]);
                    }
                    comboBox2.setOnAction(event2 -> {

                        team1_name.setOnAction((event3) -> {
                            worldCup.getWorldcupGroup(comboBox2.getSelectionModel().getSelectedIndex()).getGroupTeam(0).setTeamName(team1_name.getText());
                        });

                        team2_name.setOnAction(event3 -> {
                            worldCup.getWorldcupGroup(comboBox2.getSelectionModel().getSelectedIndex()).getGroupTeam(1).setTeamName(team2_name.getText());
                        });

                        team3_name.setOnAction(event3 -> {
                            worldCup.getWorldcupGroup(comboBox2.getSelectionModel().getSelectedIndex()).getGroupTeam(2).setTeamName(team3_name.getText());
                        });

                        team4_name.setOnAction(event3 -> {
                            worldCup.getWorldcupGroup(comboBox2.getSelectionModel().getSelectedIndex()).getGroupTeam(3).setTeamName(team4_name.getText());
                            data = true;
                        });

                    });
                });
            }
        });

        matches.setOnMouseClicked(event -> {
                    if (data != false) {
                        worldcup_creator = false;
                        grid1.setVisible(false);
                        grid3.setVisible(false);
                        //click_group = true;
                        grid2.setVisible(true);
                    }
        });

        groups.setOnMouseClicked(event -> {
            if (click_group != false) {
                grid1.setVisible(false);
                grid2.setVisible(false);
                vbox.getChildren().clear();
                vbox.getChildren().add(hbox1);
               // grid3.setVisible(true);


                if (matches_record.length != 0){
                for (int i=0 ; i< matches_record.length; i++){
                    if (matches_record[i] == 1 && (i % 2 ==0)){
                        matches_01.getMatchList(i).setWins();
                        matches_01.getMatchList(i).setPointsWins();
                        matches_01.getMatchList(i + 1).setLosses();
                        matches_record[i]=0;
                    }else if(matches_record[i] == 1 && (i % 2 !=0)){
                        matches_01.getMatchList(i -1).setLosses();
                        matches_01.getMatchList(i).setWins();
                        matches_01.getMatchList(i).setPointsWins();
                        matches_record[i]=0;
                    }
                }}

                grid3.setVisible(true);

                    counter = 0;

                    Standings group_standings = new Standings(worldCup);

                    while (counter != 8) {
                        for (int i = 0; i < 4; i++) {
                            AnchorPane standings = new AnchorPane();
                            //AnchorPane.setLeftAnchor(standings, 5.0);
                          //  AnchorPane.setTopAnchor(standings, 35.0);
                            // AnchorPane.setRightAnchor(standings,25.0);
                            Label country = new Label(worldCup.getWorldcupGroup(counter).getGroupTeam(i).getTeamName()); // Worldcup.getGropuTeam.getTeam.getName
                            //  country.setMinWidth(35);
                            Label map = new Label("" + worldCup.getWorldcupGroup(counter).getGroupTeam(i).getMatchesPlayed());
                           // map.setMaxWidth(1);
                            Label wins = new Label("" + worldCup.getWorldcupGroup(counter).getGroupTeam(i).getWins());
                           // wins.setMaxWidth(1);
                            Label draws = new Label("" + worldCup.getWorldcupGroup(counter).getGroupTeam(i).getDraws());
                            //draws.setMaxWidth(1);
                            Label looses = new Label("" + worldCup.getWorldcupGroup(counter).getGroupTeam(i).getLosses());
                           // looses.setMaxWidth(1);
                            Label golfow = new Label("" + worldCup.getWorldcupGroup(counter).getGroupTeam(i).getGolsFor());
                            //golfow.setMaxWidth(1);
                            Label golagg = new Label("" + worldCup.getWorldcupGroup(counter).getGroupTeam(i).getGolsAgainst());
                            //golagg.setMaxWidth(1);
                            Label goldif = new Label("" +(worldCup.getWorldcupGroup(counter).getGroupTeam(i).getGolsFor()
                            - worldCup.getWorldcupGroup(counter).getGroupTeam(i).getGolsAgainst()));
                            //goldif.setMaxWidth(1);
                            Label points = new Label("" + worldCup.getWorldcupGroup(counter).getGroupTeam(i).getPoints());
                            //points.setMaxWidth(1);
                            HBox hbox2 = new HBox( map, wins, draws, looses, golfow, golagg, goldif, points);
                            hbox2.setSpacing(53);
                            standings.getChildren().add(hbox2);
                            BorderPane borderPane = new BorderPane();
                            borderPane.setLeft(country);
                            borderPane.setRight(standings);
                            vbox.getChildren().add(borderPane);
                        }

                        counter++;

                        String[] str = {"A", "B", "C", "D", "E", "F", "G", "H"};
                        if (counter != 8) {
                            Label groups_letter1 = new Label("Group " + str[counter]);  // + worldCup.getWorldCupGroup(0).getGroupName;
                            Label mp1 = new Label("  MP");
                            Label w1 = new Label(" W ");
                            Label d1 = new Label("D  ");
                            Label l1 = new Label("L  ");
                            Label gf1 = new Label(" GF");
                            Label ga1 = new Label(" GA");
                            Label gd1 = new Label("+/-");
                            Label p1 = new Label(" PTS");
                            HBox hbox11 = new HBox( mp1, w1, d1, l1, gf1, ga1, gd1, p1);
                            hbox11.setSpacing(35);
                            BorderPane borderPane1 = new BorderPane();
                            borderPane1.setLeft(groups_letter1);
                            borderPane1.setRight(hbox11);

                            vbox.getChildren().add(borderPane1);


                        }


                    }
            }

        });


        group_phase.setOnMouseClicked(event ->{

            vbox7.setVisible(false);
            click_group = true;
            vbox6.setVisible(true);
            if (click_matches) {
                matches_01 = new Matches_01(worldCup);
                matches_01.getMatches();
                matches_record = new int[matches_01.matchesListLength()];


                counter = 2;
                counter2 = 3;
                day_counter = 0;
                day = 1;
                months = 14;
                textField1.clear();


                Label label1 = new Label(matches_01.getMatchList(0).getTeamName());
                label1.setId("label1");
                textField1.add(new TextField("0"));
                textField1.get(0).setPrefColumnCount(1);
                textField1.add(new TextField("0"));
                textField1.get(1).setPrefColumnCount(1);
                Label label2 = new Label(matches_01.getMatchList(1).getTeamName() + "  " +
                        hours[day_counter]);
                label2.setId("label2");
                HBox hBox = new HBox(label1, textField1.get(0), textField1.get(1), label2);
                hBox.setSpacing(15);
                vbox6.getChildren().add(hBox);


                do {
                    AnchorPane anchorPane = new AnchorPane();
                    label1 = new Label(matches_01.getMatchList(counter).getTeamName());
                    label1.setId("label11");
                    textField1.add(new TextField("0"));
                    textField1.get(counter).setPrefColumnCount(1);
                    textField1.add(new TextField("0"));
                    textField1.get(counter2).setPrefColumnCount(1);
                    label2 = new Label(matches_01.getMatchList(counter2).getTeamName() + "  " +
                            hours[day_counter]);
                    label2.setId("label12");
                    hBox = new HBox(label1, textField1.get(counter), textField1.get(counter2), label2);
                    hBox.setSpacing(15);
                    //AnchorPane.setLeftAnchor(hBox, 5.0);
                    // AnchorPane.setTopAnchor(hBox, 5.0);
                    day_counter += 1;
                    if (day_counter == 3) {
                        day_counter = 0;
                        day += 1;
                        months += 1;
                        Label label = new Label(" Day " + day + " " + month[5] + " " + days_month[months]);
                        vbox6.getChildren().add(label);
                    }


                    anchorPane.getChildren().add(hBox);
                    vbox6.getChildren().add(anchorPane);

                    counter += 2;
                    counter2 += 2;
                } while (counter2 <= matches_01.matchesListLength());


                textField1.forEach(tf -> {
                    tf.textProperty().addListener((observableValue, oldVal, newVal) -> {
                        if (! newVal.isEmpty()){
                            matches_01.getMatchList(textField1.indexOf(tf)).setGolsFor(Integer.parseInt(newVal));
                            matches_01.getMatchList(textField1.indexOf(tf)).setMatchesPlayed();


                            if (textField1.indexOf(tf) % 2 == 0)
                                matches_01.getMatchList(textField1.indexOf(tf) + 1).setGolsAgainst(Integer.parseInt(newVal));
                            else
                                matches_01.getMatchList(textField1.indexOf(tf) - 1).setGolsAgainst(Integer.parseInt(newVal));}
                        //=======================================================================================================================================================
                        if (textField1.indexOf(tf) % 2 == 0 && ! newVal.isEmpty()){

                            if (Integer.parseInt(newVal) > Integer.parseInt(textField1.get(textField1.indexOf(tf) + 1).getText())){
                                matches_record[textField1.indexOf(tf)] = 1;
                                matches_record[textField1.indexOf(tf) + 1] = 0;
                            }else if (Integer.parseInt(newVal) == Integer.parseInt(textField1.get(textField1.indexOf(tf) + 1).getText())){
                                matches_record[textField1.indexOf(tf)] = 2;
                                matches_record[textField1.indexOf(tf) + 1] = 2;
                            }
                        }else if(textField1.indexOf(tf) % 2 != 0 && ! newVal.isEmpty()) {

                            if (Integer.parseInt(newVal) > Integer.parseInt(textField1.get(textField1.indexOf(tf) - 1).getText())){
                                matches_record[textField1.indexOf(tf) - 1] = 0;
                                matches_record[textField1.indexOf(tf)] = 1;
                            }else if (Integer.parseInt(newVal) == Integer.parseInt(textField1.get(textField1.indexOf(tf) - 1).getText())){
                                matches_record[textField1.indexOf(tf) - 1] = 2;
                                matches_record[textField1.indexOf(tf)] = 2;
                            }
                        }

                        textField1.get(textField1.indexOf(tf)).setMouseTransparent(true);


                    });
                });

            }
         click_matches = false;

        });

        Round_of_16.setOnMouseClicked(event -> {

            vbox6.setVisible(false);
            vbox7.setVisible(true);
            Standings standings = new Standings(worldCup);

//===========================================================================================================================================================
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
                index+=1;}
//=======================================================================================================================================================

            // counters
            int counter=0;
            this.index=0;
            int counter_match=0; int counter_day=0;
            int days = (worldCup.getWorldcup().length / 2);

            if(click_Round16) {
                while (counter_match < worldCup.getWorldcup().length) {
                    AnchorPane anchorPane1 = new AnchorPane();
                    Label label11 = new Label(standings.getGroupWinner(groupArray[index_8[this.index]][index_8[this.index + 1]]).getTeamName());
                    label11.setId("label11");
                    textField2.add(new TextField("0"));
                    textField2.get(counter_text).setPrefColumnCount(1);
                    textField2.add(new TextField("0"));
                    textField2.get(counter_text + 1).setPrefColumnCount(1);
                    Label label21 = new Label(standings.getGroupRunner(groupArray[index_8[this.index + 2]][this.index_8[index + 3]]).getTeamName() + "  " +
                            hours[1]);
                    label21.setId("label12");
                    HBox hBox1 = new HBox(label11, textField2.get(counter_text), textField2.get(counter_text + 1), label21);
                    hBox1.setSpacing(15);
                    day_counter += 1;
                    if (counter == 2) {
                        counter = 0;
                        counter_day += 1;

                        Label label2 = new Label(" Day " + (17 + counter_day) + day + " " + month[6] + " " + days_month[counter_day]);
                        vbox7.getChildren().add(label2);
                    }


                    anchorPane1.getChildren().add(hBox1);
                    vbox7.getChildren().add(anchorPane1);

                    counter += 1;
                    this.index += 4;
                    counter_match += 1;
                    counter_text += 2;
                }

             /*   index=0;
                textField2.forEach(tf ->{
                    tf.textProperty().addListener((observable, oldValue, newValue) -> {
                        if (!newValue.isEmpty()) {
                            standings.getGroupWinner(groupArray[index_8[index]][index_8[index + 1]]).setGolsFor(Integer.parseInt(newValue));
                            standings.getGroupRunner(groupArray[index_8[index + 2]][index_8[index + 3]]).setGolsAgainst(Integer.parseInt(newValue));
                        }
                        index +=4;
                    });
                });
                index=2;
                textField2.forEach(tf ->{
                    tf.textProperty().addListener((observable, oldValue, newValue) -> {
                        if (!newValue.isEmpty()) {
                            standings.getGroupRunner(groupArray[index_8[index]][index_8[index + 1]]).setGolsFor(Integer.parseInt(newValue));
                            standings.getGroupWinner(groupArray[index_8[index - 2]][index_8[index - 1]]).setGolsAgainst(Integer.parseInt(newValue));
                        }
                        index +=4;
                    });
                });

*/


             while (round16_counter2 < worldCup.getWorldcup().length) {
                 textField2.get(round16_counter2).setOnAction(event1 -> {
                     System.out.println(this.index);
                      standings.getGroupWinner(groupArray[index_8[round16_counter1]][index_8[round16_counter1 + 1]]).setGolsFor(Integer.parseInt(textField2.get(round16_counter2).getText()));
                      //standings.getGroupRunner(groupArray[index_8[this.index + 2]][index_8[this.index + 3]]).setGolsAgainst(Integer.parseInt(newValue));
                 });






/*

                 textField2.get(index +1).textProperty().addListener((observable, oldValue, newValue) ->  {
                     standings.getGroupRunner(groupArray[index_8[this.index + 2]][index_8[this.index + 3]]).getTeamName();//setGolsFor(Integer.parseInt(newValue));
                     standings.getGroupWinner(groupArray[index_8[this.index]][index_8[this.index + 1]]).setGolsAgainst(Integer.parseInt(newValue));
                 });*/

                 round16_counter2+=1;
                 round16_counter1 +=4;
             }


            }click_Round16 = false;

            });

        quarter.setOnMouseClicked(event -> {

        });





//======================================================================================================================




        grid1.add(comboBox1,0,1);
        grid1.add(comboBox2,4,1);
        grid1.add(no_groups, 0,0);
        grid1.add(selec_group, 4,0);
        grid1.add(vbox4, 0,2);
        grid1.add(vbox5, 4,2);





       primaryStage.show();
       scene.getStylesheets().add(app.class.getResource("app.css").toExternalForm());

    }
}
