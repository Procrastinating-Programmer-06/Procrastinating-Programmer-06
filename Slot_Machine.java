import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Slot_Machine
{
    static String[] scramble(String[] str)
    {
        Random random = new Random();
        String[] slot = new String[3];
        for (int i=0;i<3;i++)
        {
            int ind = random.nextInt(0,5);
            slot[i] = str[ind];
        }
        return slot;
    }

    static int winnings(String[] slot)
    {
        if (slot[0].equals(slot[1]) || slot[1].equals(slot[2]) || slot[2].equals(slot[0]))
        {
            return 2;
        }
        else if (slot[0].equals(slot[1]) && slot[0].equals(slot[2]))
        {
            return 3;
        }
        else return 0;
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("⭐⭐⭐ Welcome to Java Slots 🎰🎱🕹️ ⭐⭐⭐\nYou have a purse of 1000$ ride your luck and win big!!");
        System.out.println("if you hit either a JACKPOT or a DOUBLE you will win back your bet too\nIn all other cases its a loss and your bet placed will be lost");
        int balance=1000;
        int bet,winnings=0,losses=0;
        int[] score = {0,0,0};
        String choice="";
        do
        {
            System.out.print("Enter your bet in $:");
            bet = scan.nextInt();
            String[] tokens = {" 🍎 "," 🍉 "," 🥭 "," 🔔 "," ⭐ "};
            int win =0;
            if (bet > balance)
            {
                System.out.println("Bet amount cannot be more than balance amount");
                continue;
            }
            else
            {
                balance = balance - bet;
                System.out.printf("Bet has been placed\nYour balance is now %d$\nRolling .....\n",balance);
                String[] slot = scramble(tokens);
                System.out.println(Arrays.toString(slot));
                int payout = winnings(slot);
                if (payout == 3)
                {
                    System.out.println("Congrats you scored a JACKPOT!!! 🙌🎆🍾");
                    score[2]+=1;
                    winnings +=payout*bet*3;
                    win += payout*bet*3 ;
                    balance += payout*bet*3 + bet;
                    System.out.printf("You won %d$ in this round\nYour balance is now %d\n",win,balance);
                }
                else if (payout == 2)
                {
                    System.out.println("Nice you scored a DOUBLE 🎉🍾");
                    score[1]+=1;
                    winnings += payout*bet;
                    win +=payout*bet*2;
                    balance += payout*bet*2 + bet;
                    System.out.printf("You won %d$ in this round\nYour balance is now %d\n",win,balance);
                }
                else
                {
                    System.out.println("Better luck next time! Keep spinning for your chance to hit the jackpot! 🎰");
                    losses += bet;
                    score[0]+=1;
                }
                if (balance ==0)
                {
                    System.out.println("Sorry you have insufficient money in your purse to continue the game!!! try later");
                }
                System.out.print("Would you like to keep spinning (yes->y,no->n):");
                choice = scan.next();
            }
        } while (balance !=0 && choice.equals("y"));
        System.out.printf("Game Over\nBalance:%d$\nWinnings Made:%d$\nJackpots Scored:%d\nDoubles Scored:%d\n",balance,balance-1000,score[2],score[1]);
    }
}

