public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double gCons = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow((this.xxPos - p.xxPos), 2) + Math.pow((this.yyPos - p.yyPos), 2));
    }

    public double calcForceExertedBy(Planet p) {
        return gCons * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p) {
        double xCoorDiff = p.xxPos - this.xxPos;
        return this.calcForceExertedBy(p) * xCoorDiff / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        double yCoorDiff = p.yyPos - this.yyPos;
        return this.calcForceExertedBy(p) * yCoorDiff / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double xNetForce = 0;
        for (Planet p : ps) {
            if (this.equals(p) != true) {
                xNetForce += this.calcForceExertedByX(p);
            }
        }
        return xNetForce;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double yNetForce = 0;
        for (Planet p : ps) {
            if (this.equals(p) != true) {
                yNetForce += this.calcForceExertedByY(p);
            }
        }
        return yNetForce;
    }

    public void update(double dt, double fX, double fY) {
        double xAcc = fX / mass;
        double yAcc = fY / mass;
        xxVel += dt * xAcc;
        yyVel += dt * yAcc;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw() {
        String filePath = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, filePath);
    }
}
