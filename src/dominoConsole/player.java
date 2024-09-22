package dominoConsole;

import dominosGame.mainGame;

import java.util.Scanner;

import static dominoConsole.main.*;
import static dominosGame.compPlayer.computerTurn;

public class player {
    private static Scanner scanner = new Scanner(System.in);
    public static void humanTurn() {

        int quit = 0;
        print();
        System.out.println("Tray: " + human);
        System.out.println("Human's turn");
        System.out.println("[p] Play Domino \n[d] Draw from boneyard \n[q] Quit");
        char c = scanner.next().charAt(0);
        // to check for winner.
        if(human.size()==0 || boneyard.size()==0){
            winCheck(human,computer);

        }else if(c=='p'){
            System.out.println("Which domino?");
            int i= scanner.nextInt();
            mainGame playingDomino= human.getDomino(i);
            System.out.println("Left or Right? (l/r)");
            char left_right = scanner.next().charAt(0);
            System.out.println("Rotate first? (y/n)");
            char y_n = scanner.next().charAt(0);

            if(y_n=='y'){
                playingDomino.rotateDomino();
            }

            if(left_right=='l'){

                if(validDomino(playingDomino,table,left_right)){
                    System.out.println("playing "+playingDomino +" at left.");
                    table.addDomino(0,playingDomino);
                    human.removeDomino(i);

                }else{

                    System.out.println("please put a valid domino.");
                    humanTurn();
                }

            }else{
                if(validDomino(playingDomino,table,left_right)==true) {
                    System.out.println("playing "+playingDomino +" at right.");
                    table.addDomino(playingDomino);
                    human.removeDomino(i);
                }else{
                    System.out.println("please place a valid domino.");
                    humanTurn();
                }
            }

            computerTurn();

        }else if(c=='d'){
            human.drawDomino(boneyard);
            humanTurn();


        }else if(c=='q'){
            winCheck(human,computer);
            gameover=true;
        }else {
            System.out.println("please Enter a valid input.");
            humanTurn();

        }

    }
}
