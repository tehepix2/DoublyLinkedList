package src;
import src.MagazineStuff.*;
import java.util.Scanner;



class Main {
    public static void main(String[] args) {
      lib.clearConsole();
      Scanner input = new Scanner(System.in);
      Magazine mag1 = new Magazine("The Very Hungry Caterpillar", "Peak Fiction", "In the light of the moon a little egg lay on a leaf. One Sunday morning the\r\n" + //
                "warm sun came up….and POP, out of the egg came a tiny, very hungry\r\n" + //
                "caterpillar. He started looking for some food. On Monday he ate through\r\n" + //
                "one apple. But he was still hungry. On Tuesday he ate through two\r\n" + //
                "pears, but he was still hungry.\r\n" + //
                "On Wednesday he ate through three plums, but he was still hungry. On\r\n" + //
                "Thursday he ate through four strawberries, but he was still hungry. On\r\n" + //
                "Friday he ate through five oranges, but he was still hungry.\r\n" + //
                "On Saturday he ate through one piece of chocolate cake, one ice-\r\n" + //
                "cream cone, one pickle, one slice of Swiss cheese, one slice of salami,\r\n" + //
                "one lollipop, one piece of cherry pie, one sausage, one cupcake, and\r\n" + //
                "one slice of watermelon. That night he had a stomach ache! The next\r\n" + //
                "day was Sunday again. The caterpillar ate through one nice leaf, and\r\n" + //
                "after that he felt better. Now he wasn't hungry anymore--and he wasn't a\r\n" + //
                "little caterpillar anymore. He was a big fat caterpillar. He built a small\r\n" + //
                "house, called a cocoon, around himself. He stayed inside for more than\r\n" + //
                "two weeks. Then he nibbled a hole in the cocoon, pushed his way out\r\n" + //
                "and...He became a beautiful butterfly!", "Eric Carle");
      Magazine mag2 = new Magazine("eGg", "egg", "bingus", "burger king");
      Magazine mag3 = new Magazine("egG", "egg", "bingus", "mcdonalds");

      Link node3 = new Link(mag3, null, null);
      Link node2 = new Link(mag2, node3, null);
      Link node1 = new Link(mag1, node2, null);

      node3.setNext(node1);
      node3.setPrev(node2);
      node2.setPrev(node1);
      node1.setPrev(node3);

      MagazineRack rack1 = new MagazineRack(node1);
    
      boolean loop = true;
      while(loop) {
        System.out.println("Welcome to your magazine rack!");
        System.out.println("What would you like to do?\n1 -- View a Magazine\n2 -- Edit a magazine\n3 -- Add a magazine\n4 -- Delete a magazine\n5 -- Leave");
        int menuChoice = input.nextInt();
        lib.clearConsole();
        if (menuChoice == 1) {
          System.out.println("View from top or bottom?\n1 -- Top\n2 -- Bottom");
          int orderChoice = input.nextInt();
          lib.clearConsole();
          if (orderChoice == 1) {
            rack1.displayRack(rack1.getHead());
            System.out.print("What would you like to access? : ");
            int magChoice = input.nextInt();
            lib.clearConsole();
            System.out.println("Title: " + rack1.chooseItem(rack1.getHead(), magChoice).getName());
            System.out.println("Genre: " + rack1.chooseItem(rack1.getHead(), magChoice).getGenre());
            System.out.println("Author: " + rack1.chooseItem(rack1.getHead(), magChoice).getAuthor());
            rack1.chooseItem(rack1.getHead(), magChoice).displayContent();
            System.out.println("Enter anything to continue...");
            int continueThing = input.nextInt();
            lib.clearConsole();
          }
          else if (orderChoice == 2) {
            rack1.rDisplayRack(rack1.getHead());
            System.out.print("What would you like to access? : ");
            int magChoice = input.nextInt();
            lib.clearConsole();
            System.out.println("Title: " + rack1.rChooseItem(rack1.getHead(), magChoice).getName());
            System.out.println("Genre: " + rack1.rChooseItem(rack1.getHead(), magChoice).getGenre());
            System.out.println("Author: " + rack1.rChooseItem(rack1.getHead(), magChoice).getAuthor());
            rack1.rChooseItem(rack1.getHead(), magChoice).displayContent();
            System.out.println("Enter anything to continue...");
            int continueThing = input.nextInt();
            lib.clearConsole();
          }
          else {
            System.out.println("Invalid input!");
            lib.sleep(1500);
            lib.clearConsole();
          }
          
        }

        else if (menuChoice == 2) {
          System.out.println("Which magazine would you like to edit?");
          rack1.displayRack(rack1.getHead());
          int magChoice = input.nextInt();
          lib.clearConsole();
          System.out.println("What would you like to change?\n1 -- Name\n2 -- Genre\n3 -- Author\n4 -- Content\n5 -- Cancel");
          int editChoice = input.nextInt();
          lib.clearConsole();
          switch(editChoice) {
            case 1:
              System.out.print("Enter a new name: ");
              String newName = input.next();
              rack1.chooseItem(rack1.getHead(), magChoice).changeName(newName);
              break;
            case 2:
              System.out.print("Enter a new genre: ");
              String newGenre = input.next();
              rack1.chooseItem(rack1.getHead(), magChoice).changeGenre(newGenre);
              break;
            case 3:
              System.out.print("Enter a new author: ");
              String newAuthor = input.next();
              rack1.chooseItem(rack1.getHead(), magChoice).changeAuthor(newAuthor);
              break;
            case 4:
              System.out.print("Enter new content: ");
              String newContent = input.next();
              rack1.chooseItem(rack1.getHead(), magChoice).changeContent(newContent);
              break;
            case 5:
              break;
            default:
              System.out.print("Invalid input!");
              break;
          }
          lib.clearConsole();
          System.out.println("Changes successful!");
          lib.sleep(2000);
          lib.clearConsole();
        }

        else if (menuChoice == 3) {
          System.out.print("Enter a name: ");
          String cName = input.next();
          lib.clearConsole();
          System.out.print("Enter a genre: ");
          String cGenre = input.next();
          lib.clearConsole();
          System.out.print("Enter an author: ");
          String cAuthor = input.next();
          lib.clearConsole();
          System.out.print("Enter content: ");
          String cContent = input.next();
          lib.clearConsole();
          rack1.getLast(rack1.getHead()).setNext(new Link(new Magazine(cName, cGenre, cContent, cAuthor), rack1.getHead(), rack1.getLast(rack1.getHead())));

        }

        else if (menuChoice == 4) {
          System.out.println("Which magazine would you like to remove?");
          rack1.displayRack(rack1.getHead());
          int magChoice = input.nextInt();
          lib.clearConsole();
          rack1.removeItem(magChoice, rack1.getHead());
          ((Magazine)rack1.chooseNode(rack1.getHead(), magChoice).getItem()).getName();

        }

        else if (menuChoice == 5) {
          loop = false;
          System.out.println("You left the magazine rack.");
          input.close();
        }
        else {
          System.out.println("Invalid input!");
        }
      }

    } 
}
