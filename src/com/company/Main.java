package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int min = 2;
        int max = 11;
        int sum = 0;
        int rp1 = (int) (Math.random() * (max - min)) + min;
        int rp2 = (int) (Math.random() * (max - min)) + min;
        int rd1 = (int) (Math.random() * (max - min)) + min;
        int rd2 = (int) (Math.random() * (max - min)) + min;
        System.out.println("You get a " + rp1 + " and a " + rp2 + ".");
        System.out.println("Your total is " + (rp1 + rp2) + ".");
        System.out.println("The dealer has a " + rd1 + " showing, and a hidden card.");
        System.out.println("His total is hidden, too.");
        sum = rp1 + rp2;
        int sum1=rd1+rd2;
        player(sum,rd1,rd2);
    }
    public static void hsPlayer(int sum,int rd1,int rd2)
    {
        int min=2;
        int max=11;
        int sum1=rd1+rd2;
        int ran=(int)(Math.random() * (max-min)) + min;
        sum=sum+ran;
        System.out.println("You drew a "+ran+".");
        System.out.println("Your total is "+sum+".");
        if(sum>21)
        {
            System.out.println("bust, the dealer wins.");
            return;
        }
        else
        {
            player(sum,rd1,rd2);
        }

    }
    public static void player(int sum,int rd1,int rd2)
    {
        int sum1 = rd1 + rd2;
        System.out.println("Would you like to \"hit\" or \"stay\"?");
        Scanner sc=new Scanner(System.in);
        String choice=sc.nextLine();
        if(choice.equals("hit"))
        {
            hsPlayer(sum,rd1,rd2);
        }
        else if(choice.equals("stay"))
        {
            System.out.println("Okay, dealer's turn.");
            System.out.println("His hidden card was a "+rd2+".");
            System.out.println("His total was "+(rd1+rd2)+".");
            dealer(sum1,sum);
        }
    }
    public static void dealer(int sum1,int sum)
    {
        int min=2;
        int max=11;
        String [] arr = {"hit", "stay"};
        Random random = new Random();
        int select = random.nextInt(arr.length);
        if(arr[select].equals("hit")) {
            int randno = (int) (Math.random() * (max - min)) + min;
            System.out.println("Dealer chooses to hit.");
            System.out.println("He draws a " + randno + ".");
            int ran = (int) (Math.random() * (max - min)) + min;
            sum1 = sum1 + ran;
            System.out.println("His total was " + sum1 + ".");
            if (sum1 > 16) {
                System.out.println("YOU WIN");
                return;
            } else
                dealer(sum1, sum);
        }
        else if(arr[select].equals("stay"))
        {
            System.out.println("Dealer chooses to stay.");
            if(sum1>sum)
            {
                System.out.println("Dealer wins.");
                return;
            }
            else
                System.out.println("You win.");
        }
    }
}