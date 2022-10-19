import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");

        System.out.println("Enter coordinate 1: ");
        String str = scanner.nextLine();
        int x1 = Integer.parseInt(str.substring(1,str.indexOf(",")));
        int y1 = Integer.parseInt(str.substring(str.indexOf(",") + 2, str.indexOf(")")));

        System.out.println("Enter coordinate 2: ");
        String str2 = scanner.nextLine();
        int x2 = Integer.parseInt(str2.substring(1,str2.indexOf(",")));
        int y2 = Integer.parseInt(str2.substring(str2.indexOf(",") + 2, str2.indexOf(")")));

        LinearEquation linearThing = new LinearEquation(x1,y1,x2,y2);
        System.out.println(linearThing.lineInfo());

    }
}
