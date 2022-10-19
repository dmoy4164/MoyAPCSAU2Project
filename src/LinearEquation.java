public class LinearEquation {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated)

 */
public LinearEquation(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
}

/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance(){
        int xDist = Math.abs(x1-x2);
        int yDist = Math.abs(y1-y2);
        double theDistance = Math.sqrt((Math.pow(xDist,2)+Math.pow(yDist,2)));
        return roundedToHundredth(theDistance);
    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        return y1-(slope()*x1);
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope(){
        //problem here, negatives: fix later//
        int run = x2-x1;
        int rise = y2-y1;
        //if both rise and run are negative//
        if ((rise<0)&&(run<0)){
            run = Math.abs(run);
            rise = Math.abs(rise);
            return roundedToHundredth(rise/run);
        } //IF TE SLOPE IS NEGATIVE//
        if ((rise/run)<0) {
        }
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
    public String equation(){
        int run = x2-x1;
        int rise = y2-y1;
        //if the slope is negative
        if (slope() < 0){
            //if the slope is a whole number
            if (slope() % run == 0) {
                return ("y = -" + rise/run + "x + " + yIntercept());
            }else {
                String m = ("-" + rise + "/" + run);
                return ("y = " + m + "x + " + yIntercept());
            }
        } else {
            if (slope() % run == 0){
                return ("y = " + rise/run + "x + " + yIntercept());
            }else{
                String m = ("" + rise + "/" + run);
                return ("y = " + m + "x + " + yIntercept());
            }

        }

    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue){
        return (+ xValue + ", " + (slope()*xValue));
    }


    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound){
        return Math.round(toRound * 100)/100;
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
    public String lineInfo(){
    String points = ("The two points are: (" + x1 + ", " + y1 + ") " + "and " + "(" + x2 + ", " + y2 + ")");
    String equation = ("The equation of the line between these points is: " + equation());
    String slope = ("The slope of this line is: " + slope());
    String yInt = ("The y-intercept of the line is: " + yIntercept());
    String dist = ("The distance between the two points is: " + distance());
        return (points + "\n" + equation + "\n" + slope + "\n" + yInt + "\n" + dist + "\n" );

    }
}
