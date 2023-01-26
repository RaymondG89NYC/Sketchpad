# Set Background Color Button

Let's start thinking about new features we can add to our sketch app. Many of these features could involve a new button which the user can press to perform some action.

## Your Task

Add a button that changes the background color to the currently selected color. This would work similarly to the `ClearButton` which erases everything and sets the background color to white. You won't be able to change the background color without erasing everything (without some major, major refactoring).

Perhaps you could modify the look at behavior of the `ClearButton` class, or you may create an entirely new button to do this. It's up to you.

<details>
<summary>Tips!</summary>

The `ClearButton` class is already set up for this new feature. Because the `ClearButton` receives a color (which is stored in its parent), instead of setting the fill color to WHITE each time, have your clear button set the fill color to the color it knows. Remember, the parent class, `SquareButton`, has a `getter` method that can be used to determine which color the `ClearButton` is.

Your second step will be to make as many clear buttons as you need. You can either use an array to make many, or choose to make additional individual `ClearButton` variables, each with a different color.

</details>

<details>
<summary>Sample Solution</summary>

`ClearButton`
``` java
    @Override
    public void performAction() {
        // Draw a new rectangle over the interior to clear the screen
        paint.setFillColor(getColor());
        paint.setLineThickness(1);
        paint.setLineColor(Color.BLACK);
        paint.drawRect(30, 30, 540, 340);
    }
```

`SketchPad`
``` java
// Updating the field to have an array of buttons
private ClearButton[] clearButtons = new ClearButton[19];

...

// In drawButtons
int startY = colorButtonStartY;
clearButtons[0] = new ClearButton(5, colorButtonStartY, buttonSideLength, Color.WHITE);
clearButtons[0].drawSelf();

for (int i = 1; i < clearButtons.length; i++) {
    float hue = 1f / clearButtons.length * i;
    startY += buttonSideLength;
    clearButtons[i] = new ClearButton(5, startY, buttonSideLength, new Color(hue));
    clearButtons[i].drawSelf();
}

...

// In updateButtons
for (ClearButton button : clearButtons) {
    button.update();
}
    
```
    
</details>
