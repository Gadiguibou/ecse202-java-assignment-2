/** */
package ppPackage;

import static ppPackage.ppSimParams.*;
import java.awt.Color;
import acm.graphics.GLine;

/**
 * This class encapsulates the logic related to setting up and updating the display of the
 * GraphicsProgram for the simulation.
 */
public class ppTable {
  private ppSim dispRef;
  /**
   * Initializes the display for the simulation. Takes a reference to the ppSim object and adds the
   * borders and floor to the display. It stores the reference to the display object for future
   * reference.
   *
   * @param dispRef Specifies a reference to the the ppSim class containing the main logic for the
   *     program
   */
  public ppTable(ppSim dispRef) {
    final GLine leftBorder = new GLine(toScrX(XLWALL), 0, toScrX(XLWALL), scrHEIGHT);
    leftBorder.setColor(Color.BLUE);
    dispRef.add(leftBorder);

    final GLine rightBorder = new GLine(toScrX(XMAX), 0, toScrX(XMAX), scrHEIGHT);
    rightBorder.setColor(Color.RED);
    dispRef.add(rightBorder);

    final GLine floor = new GLine(0, scrHEIGHT, scrWIDTH + OFFSET, scrHEIGHT);
    floor.setColor(Color.BLACK);
    dispRef.add(floor);

    this.dispRef = dispRef;
  }

  /**
   * Translates a simulation x coordinate and returns its equivalent screen x coordinate.
   *
   * @param x Specifies the simulation coordinate in x to be translated.
   * @return Returns the equivalent x coordinate on the screen.
   */
  double toScrX(double x) {
    return x * SCALE;
  }

  /**
   * Translates a simulation y coordinate and returns its equivalent screen y coordinate.
   *
   * @param y Specifies the simulation coordinate in y to be translated.
   * @return Returns the equivalent y coordinate on the screen.
   */
  double toScrY(double y) {
    return scrHEIGHT - y * SCALE;
  }

  /**
   * Yields a reference to the ppSim class instance used by the ppTable.
   *
   * @return Returns the reference to the ppSim class instance.
   */
  ppSim getDisplay() {
    return this.dispRef;
  }
}
