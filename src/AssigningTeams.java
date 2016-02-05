import java.util.*;
public class AssigningTeams {
    
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    static int[] colors;
    
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int probs = scan.nextInt();
        colors = new int[total];
        
        for (int i = 0; i < total; i++)
        {
            //for ever person, I'm creating an arraylist to contain who they have problems with
            adj.add(new ArrayList<Integer>());
        }
        
        //ensure bi-directionality
        //this is the graph
        for(int i = 0; i < probs; i++)
        {
            int a = scan.nextInt();
            int b = scan.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);  
        }
        
        //we are counting up (iterating through the color array)
        for (int c = 0; c < total; c++)
        {
            //if c in the array is 0, that means it hasn't been visited which means it doesn't have color
            //this activates the giveColor method which holds the logic for dfs which establishes the start point for exploration of adjacent nodes
            if (colors[c] == 0)
            {
                //giving it type boolean means the method will return a boolean
                //however, we have to store the answer in a variable (a variable whose type is a boolean)
                //i think you have to set the method equal to a variable because i don't think you can say giveColor() = true etc.
                boolean answer = giveColor(c);
                if (answer == false)
                {
                    System.out.println("no");
                    //writing return just ends the current method
                    return;
                }
            }
            
        }
        //if we get here, that means no colors were zero (hence the if statement above)
        System.out.println("yes");
    }
    
    
    
    //I'm writing some methods outside of the main method this time #goodcodepractices

        
    
    

    //the parameter is called "person" because you're giving color to a person
    //remember: "person" is connected "c" which is a location in the array
    //made a static boolean because it returns true if it colors its neighbors
    //false if it couldnt
    //it's specifically of type static because i'm outside of the main method
    static boolean giveColor(int person) 
    {
        //arbitrarily give the person a color
        colors[person] = 1;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        //offer is like "add" so we just added a person to the queue
        //queue represents what you are going to search
        //a queue is like creating a schedule
        queue.offer(person);
        while (!queue.isEmpty())
        {
            //poll() is like remove()
            //it grabs the current search item and removes it from the queue
            int current = queue.poll();
            
            //we iterate through our adjacency list
            for (int i : adj.get(current))
            {
                //"i" represents the number of values inside the inner array of adjacent nodes
                //if colors of i is already the same as the color of current person, then it's not valid
                //if it's not valid, that would imply that we've visited it.
                //however, if we visited it already, we wouldn't be in this loop in the first place
                //remember, "current" is a value taken from our queue. 
                if (colors[i] == colors[current])
                {
                    return false;
                }
                //if you get inside the else if statement, you know what you're looking at doesn't have a color yet
                else if (colors[i] == 0)
                {
                    //if the current number you're looking at is 1, then you'd have to set the adjacent color to 2 
                    //this is the whole point of the code. adjacent nodes shouldn't be the same color as the current
                    if (colors[current] == 1)
                    {
                        colors[i] = 2;
                    }
                    else
                    {
                        colors[i] = 1;
                    }
                    //now offer i to be explored
                    //this represents the bi-directionality. 
                    //when we split things off using adj.get(a).add(b) and vice versa, this is the same thing, but with offering things to the queue
                    queue.offer(i);
                }
                
            }
        }
        //completing the while loop means you've explored everything
        return true;
    }
}
