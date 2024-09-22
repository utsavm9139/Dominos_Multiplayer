//This works as the main for the console.
//It imports the GUI functions and checks the
//winner of the game.

package dominoConsole;

import dominosGame.mainGame;
import dominosGame.boneYard;



import static dominoConsole.player.humanTurn;
import static dominoGUI.mainGUI.gDomino;



public class main {


    public static boneYard boneyard = new boneYard();

    public static boneYard human = new boneYard();

    public static boneYard computer = new boneYard();

    public static boneYard table = new boneYard();

    public static boolean gameover= false;
    public static boolean turnComputer= false;




        public static void main(String[] args) {
            gDomino();
            System.out.println("Welcome Dominos!");

            boneyard.createBoneYard();
            boneyard.shuffle();
            for ( int i=0 ; i<7;i++){
                human.drawDomino(boneyard);
                computer.drawDomino(boneyard);
            }

            humanTurn();

        }

        public static void print(){
            System.out.println();
            System.out.println(table.tableToString());
            System.out.println("computer has "+computer.size()+ " dominos");
            System.out.println("Boneyard contains "+boneyard.size()+ " dominos\n");


        }


        public static boolean validDomino(mainGame maingame , boneYard boneyard , char l_r){
            boolean result=false;
            if(boneyard.size()==0){ result= true;
            }else {
                if (l_r=='l' ){
                    if(boneyard.getDomino(0).getNum1() == maingame.getNum2()|| maingame.getNum2()==0)
                    { result = true; }
                }else if (l_r=='r' )
                    if(boneyard.lastDomino().getNum2() == maingame.getNum1() || maingame.getNum1()==0)
                    { result = true; }
            }
            return result;
        }

        public static void winCheck(boneYard human, boneYard computer) {
            if (human.valueOfBoneYard(human) == computer.valueOfBoneYard(computer)) {
                if(turnComputer==true){
                    System.out.println("Computer wins.");
                }else{
                    System.out.println("Human wins.");
                }
            } else if (human.valueOfBoneYard(human) >= computer.valueOfBoneYard(computer)) {
                System.out.println("Computer wins.");
            } else if (human.valueOfBoneYard(human) <= computer.valueOfBoneYard(computer)) {
                System.out.println("Human wins.");
            }
        }
    }