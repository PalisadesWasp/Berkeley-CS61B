public class Planet {
    public double xxPos; // current x position
    public double yyPos; // current y position
    public double xxVel; // current velocity in the x direction
    public double yyVel; // current velocity in the y direction
    public double mass; // mass of the planet
    public String imgFileName; // the name of the file that corresponds to the image that depicts the planet

    private static final double gCons = 6.67e-11; // gravitational constant

    /**
     * Constructor that initializes an instance of the Planet class w/ given parameters
     @param xP: current x position
     @param yP: current y position
     @param xV: current velocity in the x direction
     @param yV: current velocity in the y direction
     @param m: mass of the planet
     @param img: the name of the file that corresponds to the image that depicts the planet
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
        /** Below can replaces all above */
        // this.Planet(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }

    /**
     * Constructor that takes in a Planet object and initializes an identical Planet object
     */
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     * Calculates the distance between two Planets
     */
    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow((this.xxPos - p.xxPos), 2) + Math.pow((this.yyPos - p.yyPos), 2));
        /** Compile and run with: */
        // javac Planet.java TestCalcDistance.java
        // java TestCalcDistance
    }

    /**
     * Calculates the force exerted on this Planet by the given Planet
     */
    public double calcForceExertedBy(Planet p) {
        return gCons * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
        /** Compile and run with: */
        // javac Planet.java TestCalcForceExertedBy.java
        // java TestCalcForceExertedBy
    }

    /**
     * Calculates the force exerted in the X direction
     */
    public double calcForceExertedByX(Planet p) {
        double xCoorDiff = p.xxPos - this.xxPos;
        return this.calcForceExertedBy(p) * xCoorDiff / this.calcDistance(p);
    }

    /**
     * Calculates the force exerted in the Y direction
     */
    public double calcForceExertedByY(Planet p) {
        double yCoorDiff = p.yyPos - this.yyPos;
        return this.calcForceExertedBy(p) * yCoorDiff / this.calcDistance(p);
        /** Compile and run with: */
        // javac Planet.java TestCalcForceExertedByXY.java
        // java TestCalcForceExertedByXY
    }

    /**
     * Take in an array of Planets and calculate the net X force exerted by all planets
     * in that array upon the current Planet
     */
    public double calcNetForceExertedByX(Planet[] ps) {
        double xNetForce = 0;
        for (Planet p : ps) {
            if (this.equals(p) != true) {
                xNetForce += this.calcForceExertedByX(p);
            }
        }
        return xNetForce;
    }

    /**
     * Take in an array of Planets and calculate the net Y force exerted by all planets
     * in that array upon the current Planet
     */
    public double calcNetForceExertedByY(Planet[] ps) {
        double yNetForce = 0;
        for (Planet p : ps) {
            if (this.equals(p) != true) {
                yNetForce += this.calcForceExertedByY(p);
            }
        }
        return yNetForce;
        /** Compile and run with: */
        // javac Planet.java TestCalcNetForceExertedByXY.java
        // java TestCalcNetForceExertedByXY
    }

    /**
     * Determines how much the forces exerted on the planet will cause that planet to accelerate,
     * and the resulting change in the planet’s velocity and position in a small period of time dt
     * @param dt: small period of time
     * @param fX: net force in X direction
     * @param fY: net force in Y direction
     */
    public void update(double dt, double fX, double fY) {
        double xAcc = fX / mass;
        double yAcc = fY / mass;
        xxVel += dt * xAcc;
        yyVel += dt * yAcc;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
        /** Compile and run with: */
        // javac Planet.java TestUpdate.java
        // java TestUpdate
    }

    public void draw() {
        String filePath = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, filePath);
    }
}
