public class NBody {
    public static double readRadius(String filePath) {
        In in = new In(filePath);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filePath) {
        In in = new In(filePath);
        int numP = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[numP];
        for (int i = 0; i < numP; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet p = new Planet(xP, yP, xV, yV, m, img);
            planets[i] = p;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        double currTime = 0;
        int numP = planets.length;

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : planets) {
            p.draw();
        }

        StdDraw.enableDoubleBuffering();
        StdDraw.show();

        while (currTime < T) {
            double[] xForces = new double[numP];
            double[] yForces = new double[numP];
            for (int i = 0; i < numP; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < numP; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            currTime += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}
