# Project: Minesweeper

## MVP

- Recreate a simplified version of the game Minesweeper to be played in the java console
- The game should be able to randomly generate 10 mines in a 10x10 grid

  - Grid will be represented by a 2 dimensional array (or array like structure)

- The user will be able to enter a command that represents a coordinate to check a location for a mine

  - (e.g "00" or "19" or "X: 0, Y: 9")

- After every guess the application should "redraw" the 2d grid. Releaving either a number from 0-8 depending on how many mines surround that location (based on the cooridnate)
- If the user selects a mine, the game will respond "boom!" and the game will be lost
- Game over screen and exit the application

- If every non-mine square has been revealed, the game is won
- Render the grid to the console after every user command

## Bonuses (optional)

- Allow for the user to configure number of mines and grid size via a configuration.json file OR command line arguments
- Keep track of win/loss in a file
  (Difficult) Discovering an empty square should reveal all squares around it, and cascade into other nearby empty squares

### Guidance

- Think about how this can be achieved in an OOP way
- A focus on single responsibility, and also maintainability/extension
- If you're lost, ask for help early
- Avoid guides, you'll just end up copying it
- If you don't understand minesweeper. Ask a coach.

### What you don't need to do

- Flag mines
- Have a fancy display. A grid with "?" "1" etc is fine
