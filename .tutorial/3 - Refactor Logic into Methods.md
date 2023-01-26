# Refactoring Logic into Methods

Another important principle to consider during refactoring is the idea of singular purpose methods. Right now, our `SketchPad`'s `initialLaunch` and `update` methods performs a variety of tasks individually. This creates very long methods with multiple end goals.

It is better practice to separate these actions into their own methods. Something like `drawBackground()`, `drawInterior()`, and `drawButtons()`.

<details>
<summary>Why Encapsulate Methods?</summary>
    
### Readability

Someone else reading your code, or even your future-self, will have a much easier time understanding what the code is doing if your methods are broken down into smaller subtasks. You don't have to look at a for-loop or a bunch of if-statements and figure out what they are doing, instead you'll see a method named, say, `drawBackground()` and know right away what it does.

### Modification of Behavior

If all of the logic for a certain action is encapsulated in its own method, then you only need to go to that method to change or update the behavior. Maybe later we decide our background should contain a mix of circles and rectangles, it'll be nice to have the `drawBackground()` method already contained in its own area before we start adding or modifying any existing behavior.
</details>

## Your Task

In the `initialLaunch` and `update` methods, try to encapsulate each specific action into its own method. `initialLaunch` and `update` should mostly or entirely only call upon `SketchPad` methods, and contain little to no internal logic directly.

Example: Create a method, `drawBackground()`, which contains the code to set the background color and draw the circles. Then, call this method in your `initialLaunch()` method.

<details><summary>Potential Method Breakdown</summary>

``` java
    public void initialLaunch() {
        drawBackground();
        drawInterior();
        drawButtons();
    }

    public void update() {
        updateMouse();
        updateButtons();
    }
```

</details>

<details><summary>Sample Solution</summary>

``` java
    public void initialLaunch() {
        drawBackground();
        drawInterior();
        drawButtons();
    }

    public void update() {
        updateMouse();
        updateButtons();
    }

    public void drawBackground() {
        screen.setBackgroundColor(Color.CYAN);
            
        for (int circleNumber = 0; circleNumber < numCircles; circleNumber++) {
            drawRandomCircle();
        }
    }

    public void drawInterior() {
        paint.setFillColor(Color.WHITE);
        paint.drawRect(margin, 
                       margin, 
                       screen.getWidth() - 2 * margin, 
                       screen.getHeight() - 2 * margin);
    }

    public void drawButtons() {
        clearButton.drawSelf();

        int startX = (screen.getWidth() - buttonSideLength * penColorButtons.length) / 2;
        penColorButtons[0] = new PenColorButton(startX, colorButtonStartY, buttonSideLength, Color.BLACK);
        penColorButtons[0].drawSelf();

        for (int i = 1; i < penColorButtons.length; i++) {
            float hue = 1f / penColorButtons.length * i;
            startX += buttonSideLength;
            penColorButtons[i] = new PenColorButton(startX, colorButtonStartY, buttonSideLength, new Color(hue));
            penColorButtons[i].drawSelf();
        }        
    }

    public void updateMouse() {
        if (mouseInfo.isMousePressed()) {
            updateLastMouseValues();
        }

        if (mouseInfo.isMouseDragged() && isInterior(mouseInfo.getX(), mouseInfo.getY())) {

            paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), lastMouseX, lastMouseY);
            updateLastMouseValues();
        }     
    }

    public void updateButtons() {
        clearButton.update();

        for (PenColorButton button : penColorButtons) {
            button.update();
        }
    }

    // Notice, this breakdown of two lines of code repeated in updateMouse
    public void updateLastMouseValues() {
        lastMouseX = mouseInfo.getX();
        lastMouseY = mouseInfo.getY();
    }
```

</details>