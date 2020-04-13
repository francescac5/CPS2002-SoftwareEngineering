import java.util.ArrayList;
import java.util.*;

public class Game {
    int turns=0;
    ArrayList<Player> players;
//map
    static void choosedirection(String answer){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print(" Choose the direction(U=UP,D=DOWN,L=LEFT,R=RIGHT): ");
            try{
                answer = sc.next();
            }catch (Exception e){
                sc.next();
            }finally {
                if(answer.equalsIgnoreCase("L")) {
                    Player.move('L');
                }else if(answer.equalsIgnoreCase("R")){
                    Player.move('R');
                }else if(answer.equalsIgnoreCase("D")){
                    Player.move('D');
                }else if(answer.equalsIgnoreCase("U")){
                    Player.move('U');
                }else{
                    System.err.println("ERROR: Enter a valid direction");
                }
            }
        }
    }
    int setNoofplayers(int n){
        int Noofplayers = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Please choose the number of player: ");
            try {
                Noofplayers = sc.nextInt();
            } catch (Exception e) {
                sc.next();
            } finally {
                return Noofplayers;
            }
        } while (true);
    }

    //method for starting the game
    void startGame(){

    }

     //runner
    public static void main(String[] args) {

    }

    //generateHTMLFILES
    void generateHTMLfiles(){

    }

}
