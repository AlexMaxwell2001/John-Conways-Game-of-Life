import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class gameOfLife 
{
    public static char [][] life = new char[20][20];
    public static void main(String args[] ) throws Exception 
    {
        Scanner sc =new Scanner(System.in);
        //make string array to take all strings
        String []ar=new String[20];
        int state=sc.nextInt();
        //initilise the character array so no syntax errors
        for(int i =0;i<life.length;i++)
        {
            for(int j=0;j<life.length;j++)
            {
                life[i][j]=' ';
            }
        }
        //read in the strings to the string array
        for(int i =0;i<ar.length;i++)
        {
            ar[i]=sc.next();
        }
        /*for every string create a character array
        then loop through each of the character array 
        to combine all characters in the life array*/
        for(int i = 0 ;i<20;i++)
        {
            char [] newar = ar[i].toCharArray();
            for(int j=0;j<newar.length;j++)
            {
                life[i][j]= newar[j];
            }
        }
        //move through the game as many times as requested
        for(int k=0;k<state;k++)
        {
            iterate();
        }
        int liveCells = 0;
        //for every one increase count and find the number of live cells
        for(int i =0;i<life.length;i++)
        {
            for(int j=0;j<life.length;j++)
            {
                if(life[i][j]=='1')
                {
                    liveCells++;
                }
            }
        }
        System.out.println(liveCells);
    }
    public static int findNeighbours(int i,int j)
    {   
        int count=0;
        //for the main centre of the graph check all 8 neighbours around the current cell at position i and j
        if((i<=18 && i>=1 )&& (j<=18 && j>=1))
        {
            if(life[i][j+1] == '1' || life[i][j+1]== '3')
            {
                count++;
            }
            if( life[i+1][j+1] == '1' || life[i+1][j+1]== '3')
            {
                count++;
            }
            if( life[i+1][j-1] == '1' || life[i+1][j-1]== '3')
            {
                count++;
            }
            if(life[i+1][j] == '1'|| life[i+1][j]== '3')
            {
                count++;
            }
            if(life[i-1][j] == '1' || life[i-1][j]== '3')
            {
                count++;
            }
            if(life[i-1][j-1] == '1' || life[i-1][j-1]== '3')
            {
                count++;
            }
            if(life[i][j-1] == '1' || life[i][j-1]== '3')
            {
                count++;
            }
            if(life[i-1][j+1] == '1' || life[i-1][j+1]== '3')
            {
                count++;
            }
        }
        else if(i==0 && (j>=1 && j<=18))
        {
            if(life[i][j+1] == '1' || life[i][j+1]== '3')
            {
                count++;
            }
            if( life[i+1][j+1] == '1' || life[i+1][j+1]== '3')
            {
                count++;
            }
            if( life[i+1][j-1] == '1' || life[i+1][j-1]== '3')
            {
                count++;
            }
            if(life[i+1][j] == '1'|| life[i+1][j]== '3')
            {
                count++;
            }
            if(life[i][j-1] == '1' || life[i][j-1]== '3')
            {
                count++;
            }
        }
        else if(i==19 && (j>=1 && j<=18) )
        {
            if(life[i][j+1] == '1' || life[i][j+1]== '3')
            {
                count++;
            }
            if(life[i-1][j] == '1' || life[i-1][j]== '3')
            {
                count++;
            }
            if(life[i-1][j-1] == '1' || life[i-1][j-1]== '3')
            {
                count++;
            }
            if(life[i][j-1] == '1' || life[i][j-1]== '3')
            {
                count++;
            }
            if(life[i-1][j+1] == '1' || life[i-1][j+1]== '3')
            {
                count++;
            }
        }
        else if(j==0 && (i>=1 &&i<=18))
        {
            if(life[i][j+1] == '1' || life[i][j+1]== '3')
            {
                count++;
            }
            if( life[i+1][j+1] == '1' || life[i+1][j+1]== '3')
            {
                count++;
            }
            if(life[i+1][j] == '1'|| life[i+1][j]== '3')
            {
                count++;
            }
            if(life[i-1][j] == '1' || life[i-1][j]== '3')
            {
                count++;
            }
            if(life[i-1][j+1] == '1' || life[i-1][j+1]== '3')
            {
                count++;
            }
        }
        else if(j==19&& (i>=1 &&i<=18))
        {
            if( life[i+1][j-1] == '1' || life[i+1][j-1]== '3')
            {
                count++;
            }
            if(life[i+1][j] == '1'|| life[i+1][j]== '3')
            {
                count++;
            }
            if(life[i-1][j] == '1' || life[i-1][j]== '3')
            {
                count++;
            }
            if(life[i-1][j-1] == '1' || life[i-1][j-1]== '3')
            {
                count++;
            }
            if(life[i][j-1] == '1' || life[i][j-1]== '3')
            {
                count++;
            }
        }
        else if(j==19 && i==19)
        {
            if( life[i-1][j-1] == '1' || life[i-1][j-1]== '3')
            {
                count++;
            }
            if(life[i-1][j] == '1'|| life[i-1][j]== '3')
            {
                count++;
            }
            if(life[i][j-1] == '1' || life[i][j-1]== '3')
            {
                count++;
            }
        }
        else if(j==19 && i==0)
        {
            if(life[i+1][j] == '1' || life[i+1][j]== '3')
            {
                count++;
            }
            if(life[i+1][j-1] == '1' || life[i+1][j-1]== '3')
            {
                count++;
            }
            if(life[i][j-1] == '1' || life[i][j-1]== '3')
            {
                count++;
            }
        }
        
        else if(j==0 && i==19)
        {
            if(life[i][j+1] == '1' || life[i][j+1]== '3')
            {
                count++;
            }
            if( life[i-1][j+1] == '1' || life[i-1][j+1]== '3')
            {
                count++;
            }
           
            if(life[i-1][j] == '1'|| life[i-1][j]== '3')
            {
                count++;
            }
        }
        else if(j==0 && i==0)
        {
            if(life[i][j+1] == '1' || life[i][j+1]== '3')
            {
                count++;
            }
            if(life[i+1][j] == '1' || life[i+1][j]== '3')
            {
                count++;
            }
            if(life[i+1][j+1] == '1' || life[i+1][j+1]== '3')
            {
                count++;
            }
        }
        return count;
    }
    public static void iterate()
    {
        int neighbours=0;
        for(int i =0;i<life.length;i++)
        {
            for(int j=0;j<life.length;j++)
            {
                neighbours= findNeighbours(i, j);
                if(neighbours>3 && life[i][j]=='1')
                {
                    life[i][j]='3';
                }
                if(life[i][j]=='1' && neighbours<2)
                {
                    life[i][j]='3';
                }
                if(life[i][j]=='0' && neighbours==3)
                {
                    life[i][j]='2';
                } 
            }
        }
        liveOrDie();

    }
    public static void liveOrDie()
    {
        for(int i=0;i<life.length;i++)
        {
            for(int j=0;j<life.length;j++)
            {
                if(life[i][j]=='2')
                {
                    life[i][j]='1';
                }
                if(life[i][j]=='3')
                {
                    life[i][j]='0';
                }
            }
        }
    }
}
