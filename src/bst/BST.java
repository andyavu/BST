package bst;

import java.util.*;

public class BST
{
    public static void main(String[] args)
    {
        BSTclass bst = new BSTclass();
        Scanner userInput = new Scanner(System.in);
        boolean runSystem = true;
        while(runSystem == true)
        {
            try
            {
                System.out.println("Please enter the initial sequence of values:");
                String input = userInput.nextLine();
                String inputArray[] = input.split(" ");
                int array[] = new int[inputArray.length];
                for(int i = 0; i < array.length; i++)
                {
                    array[i] = Integer.parseInt(inputArray[i]);
                }
                for(int i = 0; i < array.length; i++)
                {
                    bst.insert(array[i], bst.root, null);
                }
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid input.");
            }
        }
        System.out.println("\nPre-order: " + bst.preOrder(bst.root) 
                + "\nIn-order: " + bst.inOrder(bst.root) 
                + "\nPost-order: " + bst.postOrder(bst.root) + "\n"); 
        System.out.print("Enter 'H' for commands: ");
        while(runSystem == true)
        {
            String input = userInput.nextLine();
            String inputArray[] = input.split(" ");
            switch(Character.toLowerCase(input.charAt(0)))
            {
                case 'i':
                    try
                    {
                        int insert = Integer.parseInt(inputArray[1]);
                        if(!bst.contains(insert, bst.root))
                        {
                            bst.insert(insert, bst.root, null);
                            System.out.println("In-order: " + bst.inOrder(bst.root));
                            System.out.print("\nCommand? ");
                        }
                        else
                        {
                            System.out.println(insert + " already exists, ignore.");
                            System.out.print("\nCommand? ");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.print("\nInvalid input. Enter 'H' for commands: ");
                    }
                    break;
                case 'd':
                    try
                    {
                        int delete = Integer.parseInt(inputArray[1]);
                        if(bst.contains(delete, bst.root))
                        {
                            bst.delete(delete, bst.root);
                            System.out.println("In-order: " + bst.inOrder(bst.root));
                            System.out.print("\nCommand? ");
                        }
                        else
                        {
                            System.out.println(delete + " doesn't exist!");
                            System.out.print("\nCommand? ");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.print("\nInvalid input. Enter 'H' for commands: ");
                    }
                    break;
                case 'p':
                    try
                    {
                        int predecessor = Integer.parseInt(inputArray[1]);
                        if(bst.predecessor(predecessor, bst.root) != null)
                        {
                            System.out.println(bst.predecessor(predecessor, bst.root).getData());
                            System.out.print("\nCommand? ");
                        }
                        else
                        {
                            System.out.println(predecessor + " does not have a predecessor.");
                            System.out.print("\nCommand? ");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.print("\nInvalid input. Enter 'H' for commands: ");
                    }
                    break;
                case 's':
                    try
                    {
                        int successor = Integer.parseInt(inputArray[1]);
                        if(bst.successor(successor, bst.root) != null)
                        {
                            System.out.println(bst.successor(successor, bst.root).getData());
                            System.out.print("\nCommand? ");
                        }
                        else
                        {
                            System.out.println(successor + " does not have a successor.");
                            System.out.print("\nCommand? ");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.print("\nInvalid input. Enter 'H' for commands: ");
                    }
                    break;
                case 'e':
                    try
                    {
                        System.out.println("Thank you for using my program!");
                        runSystem = false;
                    }
                    catch(Exception e)
                    {
                        System.out.print("\nInvalid input. Enter 'H' for commands: ");
                    }
                    break;
                case 'h':
                    try
                    {
                        System.out.println("I Insert a value\n"
                                + "D Delete a value\n"
                                + "P Find predecessor\n"
                                + "S Find successor\n"
                                + "E Exit the program\n"
                                + "H Display this message");
                        System.out.print("\nCommand? ");
                    }
                    catch(Exception e)
                    {
                        System.out.print("\nInvalid input. Enter 'H' for commands: ");
                    }
                    break;
                default:
                    System.out.print("\nInvalid input. Enter 'H' for commands: ");
            }
        }
    }
}
