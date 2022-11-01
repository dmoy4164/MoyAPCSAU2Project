import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//welcomes the user//
        System.out.println("Welcome!");
//asks for coordinate 1//
        System.out.println("Enter coordinate 1: ");
        String str = scanner.nextLine();
//obtains the x and y coordinates of coordinate 1//
        int x1 = Integer.parseInt(str.substring(1, str.indexOf(",")));
        int y1 = Integer.parseInt(str.substring(str.indexOf(",") + 2, str.indexOf(")")));


//asks for coordinate 2//
        System.out.println("Enter coordinate 2: ");
        String str2 = scanner.nextLine();
//obtains the x and y coordinates of coordinate 2//
        int x2 = Integer.parseInt(str2.substring(1, str2.indexOf(",")));
        int y2 = Integer.parseInt(str2.substring(str2.indexOf(",") + 2, str2.indexOf(")")));


//constructs a new linear equation using coordinates given//
        LinearEquation linearThing= new LinearEquation(x1, y1, x2, y2);
//checks if the two coordinates are on a vertical line//
        if (x1 == x2) {
            System.out.println("These points are on a vertical line: x = " + x1);
        } else {
            System.out.println(linearThing.lineInfo());

        }


//asks for a new value of x//
        System.out.println("Enter a value for x: ");
        double newX = scanner.nextDouble();
//prints out the new coordinate using the x given and slope from coordinates 1 and 2//
        System.out.println("The point on the line is (" + linearThing.coordinateForX(newX) + ")");
    }
}