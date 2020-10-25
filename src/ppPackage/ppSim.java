/** */
package ppPackage;

import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import static ppPackage.ppSimParams.*;

import java.awt.Color;

/**
 * This class is the base for initialization of the ping-pong simulation. It is the main graphics
 * program for this simulation.
 */
@SuppressWarnings("serial")
public class ppSim extends GraphicsProgram {
  /** Main entry point for the acm.GraphicsProgram. Contains the simulation */
  public void run() {
    this.resize(scrWIDTH + OFFSET, scrHEIGHT + OFFSET);

    ppTable myTable = new ppTable(this);
    RandomGenerator rgen = RandomGenerator.getInstance();

    rgen.setSeed(RSEED);

    for (int i = 0; i < NUMBALLS; i++) {
      Color iColor = rgen.nextColor();
      double iYinit = rgen.nextDouble(YinitMIN, YinitMAX);
      double iLoss = rgen.nextDouble(EMIN, EMAX);
      double iVel = rgen.nextDouble(VoMIN, VoMAX);
      double iTheta = rgen.nextDouble(ThetaMIN, ThetaMAX);

      // // A2-1
      // iYinit = YMAX / 2;
      // iVel = 3;
      // iTheta = 10;
      // iColor = Color.RED;
      // iLoss = 0.12;

      // // A2-2
      // double XINIT = XRWALL - bSize;
      // iYinit = YMAX / 2;
      // iVel = -3;
      // iTheta = 10;
      // iColor = Color.RED;
      // iLoss = 0.12;

      ppBall iBall = new ppBall(XINIT, iYinit, iVel, iTheta, iColor, iLoss, myTable);
      add(iBall.getBall());
      iBall.start();
    }
  }
}
