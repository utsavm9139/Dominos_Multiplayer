//This class sets up the
// calculations for the boneyard.


package dominosGame;

import java.util.ArrayList;
import java.util.Random;
import static dominoGUI.mainGUI.newList;

public class boneYard {
    private ArrayList<mainGame> dominos;

    public boneYard(){
        this.dominos= dominos;
        dominos= new ArrayList<mainGame>();
    }

    public  void createBoneYard(){

        int flag=0;
        for ( int num1=0;num1<7;num1++){
            for( int num2=num1;num2<7;num2++){
                dominos.add(new mainGame(num1, num2, newList.get(flag)));
                flag += 1;
            }
        }

    }

    public String tableToString(){
        String tray= " ";
        String tray1= "       ";
        for(int i=0; i<dominos.size();i++){
            if(i%2==0){
                tray+=dominos.get(i);
            }else{
                tray1+=dominos.get(i);
            }
        }
        tray+="\n";
        return tray+tray1;
    }

    public String toString(){
        String tray="[";
        for(mainGame aDomino: dominos){
            tray+= aDomino+ " ";
        }

        return tray+" ]";
    }
    // shuffle the boneyard.
    public void shuffle(){
        ArrayList<mainGame> newBoneYard = new ArrayList<mainGame>();
        Random rand= new Random();
        int randomCardIndex;
        int originaSize=dominos.size();
        for(int i=0; i<originaSize;i++){
            randomCardIndex =rand.nextInt((dominos.size()-1)+1);
            newBoneYard.add(dominos.get(randomCardIndex));
            dominos.remove(randomCardIndex);
        }
        dominos=newBoneYard;
    }

    public mainGame getDomino(int i){
        return dominos.get(i);
    }

    public void addDomino(mainGame addDomino){
        dominos.add(addDomino);
    }

    public void addDomino(int index, mainGame domino){
        dominos.add(index,domino);
    }


    public void drawDomino(boneYard boneyard){
        dominos.add(boneyard.getDomino(0));
        boneyard.removeDomino(0);
    }


    public int size(){
        return dominos.size();
    }
    public void removeDomino(int i ){
        dominos.remove(i);

    }

    public mainGame lastDomino(){
        return dominos.get(dominos.size()-1);
    }

    public void removeDomino(mainGame domino ){
        dominos.remove(domino);

    }

    public int valueOfBoneYard( boneYard boneyard){
        int value=0;
        for(int i=0 ;i<boneyard.size();i++){
            value+=boneyard.getDomino(i).getValue();

        }
        return value;
    }
}