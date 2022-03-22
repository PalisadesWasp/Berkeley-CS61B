/**
 * UC Berkeley CS 61B Spring 2018
 * https://sp18.datastructur.es/materials/proj/proj0/proj0
 * Project 0: NBody Simulation
 * Actually runs simulation of a universe specified in one of the data files
 *
 * sample command:
 * javac NBody.java
 * java NBody 157788000.0 25000.0 data/planets.txt
 * java NBody 20000000 20000 ./data/suninterference.txt
 */

public class NBody {
    /**
     * Given a file name, returns a double corresponding to the radius of the universe in the file
     * @param filePath: file path and name
     */
    public static double readRadius(String filePath) {
        In in = new In(filePath);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
        /** Compile and run with: */
        // javac NBody.java TestReadRadius.java
        // java TestReadRadius
    }

    /**
     * Given a file name, returnS an array of Planets corresponding to the planets in the file
     * @param filePath: file path and name
     * @return
     */
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
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
        /** Compile and run with: */
        // javac Planet.java NBody.java TestReadPlanets.java
        // java TestReadPlanets
    }

    public static void main(String[] args) {
        /** Read command line arguments and collects all needed input */
        double T = Double.parseDouble(args[0]); // time to stop simulation
        double dt = Double.parseDouble(args[1]); // small period of time
        String filename = args[2]; // file name and path of the data file w/ planet information
        double radius = readRadius(filename); // radius of the universe
        Planet[] planets = readPlanets(filename);
        double currTime = 0;
        int numP = planets.length;

        /** Draw the background and the planets */
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : planets) {
            p.draw();
        }
        /** Compile and run with: */
        // javac NBody.java
        // java NBody 157788000.0 25000.0 data/planets.txt

        StdDraw.enableDoubleBuffering(); // Graphics technique to prevent flickering in the animation
        StdDraw.show(); // Drawing get copied from the offscreen canvas to the onscreen canvas

        while (currTime < T) {
            double[] xForces = new double[numP];
            double[] yForces = new double[numP];
            /** Calculate the net x and y forces for each planet */
            for (int i = 0; i < numP; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            /** Update each planet’s position, velocity, and acceleration */
            for (int i = 0; i < numP; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg"); // Draw the background image
            for (Planet p : planets) {
                p.draw(); // Draw all of the planets
            }
            StdDraw.show(); // Show the offscreen buffer
            StdDraw.pause(10); // Pause the animation for 10 milliseconds
            currTime += dt;
        }

        /** Print out the final state of the universe when the simulation is over */
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}
