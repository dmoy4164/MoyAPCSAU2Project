public class LinearEquation {
//instance variables//
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated)

 */
    //constructor//
public LinearEquation(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
}

/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    //does ^, finds the distance between the two points with pythagorean theorem//
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));
    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    //does ^, finds the y intercept//
    public double yIntercept(){
        return roundedToHundredth(y1-(slope()*x1));
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    //does ^, obtains slope//
    public double slope(){
        return roundedToHundredth((double)(y2-y1)/(double)(x2-x1));
    }

    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    //does ^, creates equation//
    public String equation(){
       double m = slope();
       double b = yIntercept();

       if (m == 0){
           return ("y = " + y1);
       }

       String equat = ("y = ");
       int rise = y2-y1;
       int run = x2-x1;

       String mCheck = ("");
       if (m<0){
           mCheck = ("-");
       }
       String mValue = ("");
       if (Math.abs(m) != 1) {
           if (((int) (m)) == m) {
               mValue = ("" + (int) Math.abs(m));
           } else {
               mValue = ("" + Math.abs(rise) + "/" + Math.abs(run));
           }
       }
        equat = (equat + mCheck + mValue + "x");

       if (b!=0){
           String bCheck = ("+");
           if (b<0){
               bCheck = ("-");
           }
           equat = (equat+" "+ bCheck + " " + Math.abs(b));
       }
       return equat;
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    //does ^, obtains the new coordinates with same slope using new x from the user//
    public String coordinateForX(double xValue){
        return ( xValue + ", " + (slope()*xValue));
    }


    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    //does ^, rounds the number//
    public double roundedToHundredth(double toRound){
        return Math.round(toRound * 100)/100.0;
    }

    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().
      */
    //does ^, returns all the information//
    public String lineInfo(){
    String points = ("The two points are: (" + x1 + ", " + y1 + ") " + "and " + "(" + x2 + ", " + y2 + ")");
    String equation = ("The equation of the line between these points is: " + equation());
    String slope = ("The slope of this line is: " + slope());
    String yInt = ("The y-intercept of the line is: " + yIntercept());
    String dist = ("The distance between the two points is: " + distance());
        return (points + "\n" + equation + "\n" + slope + "\n" + yInt + "\n" + dist + "\n" );

    }
}
