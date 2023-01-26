# Removing Literal Values

One of the first things to lookout for when refactoring code are literal values. A literal value is any fixed value written explicitly in your code. For example, the `for-loop` we are using to draw our background circles is set to continue as long as `circleNumber < 500` the `500` is a literal value.

Usually, creating a variable for a value like this is a better solution. For example, we could define a variable named `numberOfCircles` and use that instead of the literal `500`. Doing it this way allows for a bit more extensibility and ease of use. If we want to change the number of circles, we only need to find the variable in our code and change the value there- as opposed to finding the for loop which may get buried as our program grows. Additionally, the code becomes easier to read. It is very likely that you would forget what specific numbers represent, but looking at the name of a value reminds you what the value is for.

<details>
<summary>When Should You Use a Literal Value</summary>
Some values should remain literals. For example, in this same for loop we state `int circleNumber = 0` to start our counter at zero. We probably always want this counter to start at exactly 0, because that's how the logic of our for loop works. Using a variable here implies we may change its value and can be more confusing than helpful.
</details>

<details>
<summary>Literal Values that will never Change</summary>
Some literal values may never need to change while the code is running. For instance, if a value represents the year an event occurred, that year should never be changed.

Adding the word `final` to a variable means the value it is looking at cannot change. You will also see most `final` values use an UPPERCASE_NAMING_CONVENTION.

Example:  
`private final int FIRST_MODERN_OLYMPICS_YEAR = 1896;`

</details>



## Your Task

Look through the `SketchPad` class for any values that should be represented by variables and not literal values. Any arbitrary values such as the size of our pen colors array, or any value which needs to be repeated in multiple places such as the size of our margins.

What if later we change the screen size, or we want to change the margin size? You would have to change the literal value anywhere it appears. Replacing literals with variables allows you to change your program quickly and avoid annoying mistakes, like changing the margin size everywhere except one place in your code which can be hard to debug.

<details>
<summary>Tips!</summary>
Some literal values which could be turned into variables:  

* the margin size  
* the number of circles  
* the min and max radius of the circles
* the side lengths of the buttons
* the number of buttons
* the starting y coordinate for the buttons
* the starting x coordinate of the buttons, *this could also be calculated mathematically if all buttons are meant to be centered on the screen*
</details>


<details>
<summary>Potential Solutions!</summary>
    
``` java
private int margin = 30;
private int numCircles = 500;
private int minRadius = 10;
private int maxRadius = 30;
private int buttonSideLength = 20;
private int numButtons = 24;
private int colorButtonStartY = 5;

...

for (int circleNumber = 0; circleNumber < numCircles; circleNumber++) {
    drawRandomCircle();
}

...
    
paint.drawRect(margin, 
       margin, 
       screen.getWidth() - 2 * margin, 
       screen.getHeight() - 2 * margin);

...

int startX = (screen.getWidth() - buttonSideLength * penColorButtons.length) / 2;
penColorButtons[0] = new PenColorButton(startX, colorButtonStartY, buttonSideLength, Color.BLACK);

...

startX += buttonSideLength;
penColorButtons[i] = new PenColorButton(startX, colorButtonStartY, buttonSideLength, new Color(hue));

...

return x >= margin && 
    x <= screen.getWidth() - margin &&
    y >= margin &&
    y <= screen.getHeight() - margin;

```
</details>