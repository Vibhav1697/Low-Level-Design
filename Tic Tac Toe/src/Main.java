public class Main {
    public static void main(String[] args) {
       Game game=new Game();

       game.startGame();

       if(game.getGameWinner()==null){
           System.out.println("Its a Tie");
       }
       else{
           System.out.println("Winner is "+game.getGameWinner().getName());
       }


    }
}