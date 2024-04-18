package rpcGame;

import java.util.Random;
import java.util.Scanner;

class RockPaperScissors   
{
    private int User_Winner = 0;
    private int Computer_Winner = 0;
    private int Tie = 0;
    private int GAME = 1;
    private Random rand = new Random();
    private Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args)    //Main class
    {
        greeting();
        RockPaperScissors rps = new RockPaperScissors();
        for(int i=0;i<3;i++)
        {
            rps.playRound();
        }
        if(rps.getWinner()==rps.User_Winner)
        {
            System.out.println("Congratulations....You Win!\n" );
        }
        if(rps.getWinner()==rps.Computer_Winner)
        {
            System.out.println("\nComputer is winner!");
            System.out.println("Better Luck Next Time!");
        }
        if(rps.getWinner()==rps.Tie)
        {
            System.out.println("/nNo one Winns....!!!!");
        }
        System.out.print("Do you want to play Again? (1-yes, 2-No) : ");
        int Play_Again = rps.sc.nextInt();
        if(Play_Again==1)
        {
            main(null);
        }else{
            System.exit(0);
        }
        
    }

    public static void greeting()   // Function Used to speak with User about Game Rules
    {
        System.out.println("Welcome to the Rock./.Paper./.Scissor Game\n---------------------------------------------\n");
        System.out.println("Here are the rules of the game.");
        System.out.println("You and I will get to choose rock, Paper, Scissor");
        System.out.println("After we made a decision , we will then reveal the choices we both made and decide a winner based on these rules");
        System.out.println("Rock beats Scissor");
        System.out.println("Paper beats Rocks");
        System.out.println("Scissor beats Paper");
        System.out.println("If we both pick the same option , then it is a tie .");
        System.out.println("Ready to Play..?");
      
    }

    public void playRound()       //Function used to track wins and losses
    {
        System.out.println("\nGame "+GAME+": \n");
        int User_Choice = UserChoice();
        int Computer_Choice = ComputerChoice();
        int ChoiceBattle = choiceBattle(User_Choice, Computer_Choice);
        if(ChoiceBattle==User_Choice)
        {
            User_Winner++;
        }else if(ChoiceBattle==Computer_Choice)
        {
            Computer_Winner++;
        }else if(ChoiceBattle == 0)
        {
            Tie++;
        }
        GAME++;
    }
    public int choiceBattle(int p1,int p2)    //Function Used to determine who won the game
    {
        if(p1==1&&p2==2)
        {
            System.out.println("\nYou used Rock");
            System.out.println("I used Paper");
            System.out.println("Paper beats Rock");
            return p2;
        }else if(p1==1&&p2==3)
        {
            System.out.println("\nYou used Rock");
            System.out.println("I used Scissor");
            System.out.println("Rock beats Scissor");
            return p1;
        }else if(p1==2&&p2==1)
        {
            System.out.println("\nYou used Paper");
            System.out.println("I used Rock");
            System.out.println("Paper beats Rock");
            return p1;
        }else if(p1==2&&p2==3)
        {
            System.out.println("\nYou used Paper");
            System.out.println("I used Scissor");
            System.out.println("Scissor beats Paper");
            return p2;
        }else if(p1==3&&p2==1)
        {
            System.out.println("\nYou used Scissor");
            System.out.println("I used Rock");
            System.out.println("Rock beats Scissor");
            return p2;
        }else if(p1==3&&p2==2)
        {
            System.out.println("\nYou used Scissor");
            System.out.println("I used Paper");
            System.out.println("Scissor beats Paper");
            return p1;
        }else if(p1==2&&p2==2)
        {
            System.out.println("\nYou used Paper");
            System.out.println("I used paper");
            System.out.println("Its a tie");
            return 0;
        }else if(p1==1&&p2==1)
        {
            System.out.println("\nYou used Rock");
            System.out.println("I used Rock");
            System.out.println("Its a tie");
            return 0;
        }else
        {
            System.out.println("\nYou used Scissor");
            System.out.println("I used Scissor");
            System.out.println("Its a tie");
            return 0;
        }
        
        
    }
    int ComputerChoice()    // Randomize computer choice from 1 - 3
    {
        
        int min =1;
        int max =4;
        int number = (rand.nextInt(max-min)+min);
        return number;
    }
    int UserChoice()	
    {
        System.out.print("|Make a choice|  [1-Rock, 2-Paper, 3-Scissor] : ");
        int User_Choice = sc.nextInt();
        return User_Choice;
    }
    public int getWinner()
    {
        if (User_Winner >= Computer_Winner && User_Winner >= Tie)
            return User_Winner;
        else if (Computer_Winner >= User_Winner && Computer_Winner >= Tie)
            return Computer_Winner;
        else
            return Tie;
    }
} 

