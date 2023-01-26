package buttons;

import tools.Color;
import tools.PaintingTool;

public class PenThickness extends SquareButton {
  private final PaintingTool paint = new PaintingTool();
  private int thickness;

  public PenThickness(int incomingX, int incomingY, int incomingSize, int thickness){
    super(incomingX, incomingY, incomingSize, Color.WHITE);
    this.thickness = thickness;
  }

      public void drawSelf() {
        super.drawSelf();
        paint.setLineThickness(thickness);
        paint.drawLine(getLeftX(), getTopY() + getSize(), getLeftX() + getSize(), getTopY());
        paint.setLineThickness(1);
    }


  public void performAction() {
    paint.setLineThickness(thickness);
  }
  
}