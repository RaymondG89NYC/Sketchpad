# Pen Thickness Options

Another place where we could add some customization options is the pen thickness. The `PaintingTool` class has a `setLineTickness()` method which we could use.

There are multiple ways to utilize this concept. One would be to keep track of the line thickness in a variable and allow users to change this value with a `+` and `-` button. Another option would be to display a number of buttons, each representing a specific line thickness. When clicked, each of these buttons would adjust the line thickness to their appropriate value.

## Your Task

Create a pair of buttons or preset array of buttons that allow users to change the pen thickness. You could create a `+` and `-` button which increases and decreases pen thickness. Be careful not to let users set the pen thickness less than `1`, and perhaps set some sort of upper limit too.

You could instead create an array of pen thicknesses and display several buttons like we did with the pen colors.


<details>
    <summary>Tips!</summary>
    
The following tip involves creating an array of buttons.  

Create another button class, similar to our `ClearButton` and `PenColorButton`. This new class will need to store one additional piece of data about itself - what line thickness (weight) this particular button is for. Create a field to store this data and add an additional value into the constructor which takes an incoming line weight. Check the `SquareButton` class for an example of how to store this value correctly.

In the `drawSelf()` method, think of some way to differentiate how these buttons look. You could use drawText, and the text could be the line weight this button uses. Or, you could actually draw a line with the right weight inside the button itself.

In the `performAction()`, make the correct call to the `paint` value to set the line thickness to the value your button is storing.

Final steps? In the `Sketchpad.java` create an array of buttons. Build each of the buttons and make them draw themselves, then make sure to call the update on them. This follows very similarly to our `PenColorButtons`.
</details>

<details>
    <summary>Potential Solution</summary>

`PenWeightButton`
``` java
   
package buttons;

import tools.Color;
import tools.PaintingTool;

public class PenWeightButton extends SquareButton {
    private final PaintingTool paint = new PaintingTool();
    private int weight;
    
    public PenWeightButton(int incomingX, int incomingY, int incomingSize, Color incomingColor, int incomingWeight) {
        super(incomingX, incomingY, incomingSize, incomingColor);
        weight = incomingWeight;
    }

    @Override
    public void drawSelf() {
        // First have the SquareButton draw itself as normal
        super.drawSelf();


        paint.setLineColor(tools.Color.BLACK);
        paint.setLineThickness(weight);
        paint.drawLine(getLeftX() + getSize() / 2, getTopY() + getSize() / 4, getLeftX() + getSize() / 2, getTopY() + 3 * getSize() / 4);
    }

    @Override
    public void performAction() {
        // Draw a new rectangle over the interior to clear the screen
        paint.setLineThickness(weight);
    }
}
```

`Sketchpad`
``` java
// New fields
private int weightButtonStartY = screen.getHeight() - 25;
private int numWeightButtons = 8;
private PenWeightButton[] penWeightButtons = new PenWeightButton[numWeightButtons];

...

// Draw buttons
startX = (screen.getWidth() - buttonSideLength * penWeightButtons.length) / 2;

for (int i = 0; i < penWeightButtons.length; i++) {
    startX += buttonSideLength;
    penWeightButtons[i] = new PenWeightButton(startX, weightButtonStartY, buttonSideLength, Color.WHITE, i + 1);
    penWeightButtons[i].drawSelf();
    paint.setLineThickness(1);
}

...

// Update buttons
for (PenWeightButton button : penWeightButtons) {
    button.update();
}

```
    
</details>