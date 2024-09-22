//This creates the main GUI including the

package dominoGUI;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import dominosGame.mainGame;
import static dominoGUI.mainGUI.gDomino;
import static dominoConsole.main.*;
import static dominoGUI.humanGUI.humanG;







public class mainDisplay extends Application {
    public static HBox hBox = new HBox(10);
    public static HBox finalHbox = new HBox(10);
    public static VBox labelVbox = new VBox(10);
    public static HBox winShowHbox = new HBox(10);
    public static boolean guiMainBoolean = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        guiMainBoolean= true;
        VBox vBox = new VBox(20);
        winShowHbox.setAlignment(Pos.CENTER);
        primaryStage.setTitle("DOMINO GAME");
        gDomino();
        boneyard.createBoneYard();
        boneyard.shuffle();

        for (int i = 0; i < 7; i++) {
            computer.drawDomino(boneyard);
        }

        for (int i = 0; i < 6; i++) {
            human.drawDomino(boneyard);
        }

        Label computerLabel = new Label("Computer domino " + computer.size());
        computerLabel.setFont(Font.font(20));
        computerLabel.setAlignment(Pos.CENTER);
        Label boneyardLabel = new Label("Boneyard domino " + boneyard.size());
        boneyardLabel.setFont(Font.font(20));
        boneyardLabel.setAlignment(Pos.CENTER);

        labelVbox.getChildren().addAll(boneyardLabel, computerLabel);
        Label playerLabel = new Label("PLAYER'S DOMINO");
        playerLabel.setFont(Font.font(20));

        Label title = new Label("DOMINO GAME");
        title.setFont(Font.font(45));
        HBox titleBox = new HBox(title);
        titleBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(25, 25, 700, 200);

        Button drawButton = new Button("Draw from Boneyard");
        Button quitButton = new Button("QUIT");

        quitButton.setOnAction(event -> {
            System.exit(1);
        });

        drawButton.setOnAction(event -> {

            human.drawDomino(boneyard);

            hBox.getChildren().clear();
            for( int i=0 ;i<human.size();i++){
                hBox.getChildren().addAll(human.getDomino(i).getHBox());
            }

            Label updatdBoneyardla = new Label("Boneyard domino " + boneyard.size());
            updatdBoneyardla.setFont(Font.font(20));
            updatdBoneyardla.setAlignment(Pos.CENTER);
            labelVbox.getChildren().clear();
            labelVbox.getChildren().addAll(updatdBoneyardla, computerLabel);
            gamePlay();

        });

        Button play = new Button("PLAY");
        HBox playhBox= new HBox(10, play);
        playhBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(playhBox );

        play.setOnAction(event -> {
            drawButton.fire();
            vBox.getChildren().addAll(titleBox, labelVbox, finalHbox, playerLabel, hBox, drawButton, quitButton,winShowHbox);
            play.setDisable(true);
        });

        for (int i = 0; i < human.size(); i++) {
            hBox.getChildren().addAll(human.getDomino(i).getHBox());
        }

        finalHbox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        primaryStage.show();

        BorderPane borderPane = new BorderPane(vBox);
        primaryStage.setScene(new Scene(borderPane, 300, 275));


    }


    public static void gamePlay(){

        for (int i = 0; i < human.size(); i++) {
            mainGame domino = human.getDomino(i);



            domino.getHBox().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    if (e.getButton() == MouseButton.PRIMARY) {

                        humanG(domino, 'r');
                    } else if (e.getButton() == MouseButton.SECONDARY) {
                        humanG(domino, 'l');
                    }

                    hBox.getChildren().clear();
                    for (int i = 0; i < human.size(); i++) {
                        hBox.getChildren().addAll(human.getDomino(i).getHBox());
                    }

                    Label updatdBoneyardla = new Label("Boneyard domino " + boneyard.size());
                    updatdBoneyardla.setFont(Font.font(20));
                    updatdBoneyardla.setAlignment(Pos.CENTER);
                    Label updatedComputerLabel = new Label("Computer domino " + computer.size());
                    updatedComputerLabel.setFont(Font.font(20));
                    labelVbox.getChildren().clear();
                    labelVbox.getChildren().addAll(updatdBoneyardla,updatedComputerLabel);

                    if(computer.size()==0|| human.size()==0 || boneyard.size()==0){
                        guiWinner();
                    }
                }
            });

        }}

    public static void guiWinner (){
        Label comWinLabe = new Label("!!!!  COMPUTER WINS  !!!!");
        comWinLabe.setFont(Font.font(40));
        Label humWinLabe = new Label("!!!!  YOU WIN  !!!!");
        humWinLabe.setFont(Font.font(40));
        if (human.valueOfBoneYard(human) == computer.valueOfBoneYard(computer)) {
            if (turnComputer == true) {
                winShowHbox.getChildren().clear();
                winShowHbox.getChildren().addAll(comWinLabe);
            } else {
                winShowHbox.getChildren().clear();
                winShowHbox.getChildren().addAll(humWinLabe);
            }
        } else if (human.valueOfBoneYard(human) >= computer.valueOfBoneYard(computer)) {
            winShowHbox.getChildren().clear();
            winShowHbox.getChildren().addAll(comWinLabe);
        } else if (human.valueOfBoneYard(human) <= computer.valueOfBoneYard(computer)) {
            winShowHbox.getChildren().clear();
            winShowHbox.getChildren().addAll(humWinLabe);
        }
    }


    public static VBox twoLine( HBox hbox44){
        Rectangle rectangle1 = new Rectangle(80,40);

        VBox hbox21= new VBox(10);
        VBox hbox22= new VBox(10,rectangle1 );
        for(int i=0 ; i<hbox44.getChildren().size();i++){
            if(i%2==0){
                hbox21.getChildren().addAll(hBox.getChildren().get(i));
            }else{
                hbox22.getChildren().addAll(hBox.getChildren().get(i));
            }
        }
        return new VBox(10, hbox21,hbox22);
    }

}








