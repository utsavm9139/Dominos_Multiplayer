//Utsav Malla
//This is the main class with all the
//game functions and the scene builder.

package dominosGame;
import javafx.scene.Group;
import javafx.scene.layout.HBox;

public class mainGame {

    private int num1, num2;
    private HBox hBox;

    public mainGame(int n, int j, HBox hBox1) {
        this.setNum1(n);
        this.setNum2(j);
        this.setHBox(hBox1);

    }


    public mainGame (mainGame d)
    {
        this.setNum1(d.num1);
        this.setNum2(d.num2);
        this.setHBox(d.hBox);

    }

    public int getNum1()
    {
        return this.num1;
    }
    public HBox getHBox()
    {
        return this.hBox;
    }
    public int getNum2()
    {
        return this.num2;
    }
    public void setNum1(int n)
    {
        this.num1 = n;
    }
    public void setNum2(int n)
    {
        this.num2 = n;
    }
    public void setHBox(HBox h)
    {
        this.hBox = h;
    }
    // to string method.
    public String toString()
    {
        return String.format("[" + this.num1 + " | " + this.num2 + "]" );
    }


    public Boolean equal(mainGame d){
        mainGame c = (mainGame) d;
        return Integer.compare(num1, c.num1) == 0 || Integer.compare(num1, c.num2) == 0 || Integer.compare(num2, c.num1) == 0 || Integer.compare(num2, c.num2) == 0;
    }

    public Boolean dominoequal(mainGame d){
        return Integer.compare(num1, d.num1) == 0 && Integer.compare(num2, d.num2) == 0;
    }

    public void rotateDomino()
    {
        int holder;
        holder = this.num1;
        this.num1 = this.num2;
        this.num2 = holder;
        Group group1 = (Group) this.getHBox().getChildren().get(0);
        Group group2 = (Group) this.getHBox().getChildren().get(1);
        HBox hBox = new HBox(1,group2,group1);
        this.hBox= hBox;

    }


    public int getValue()
    {
        int total;
        total = this.num1 + this.num2;
        return total;
    }


}