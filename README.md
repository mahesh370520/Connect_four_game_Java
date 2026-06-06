# 🎮 Connect Four in Java

A console-based implementation of the classic **Connect Four** game built in Java.  
Two players (`X` and `O`) take turns dropping discs into a 6x7 grid, aiming to connect four in a row horizontally, vertically, or diagonally.

---

## ✨ Features
- 🟦 **6x7 Grid** with clean console display
- 🎯 **Two-player mode** (X vs O)
- ⬇️ **Gravity logic**: discs fall to the lowest available row
- 🏆 **Win detection**: horizontal, vertical, and diagonal checks
- 🤝 **Draw detection** when the board is full
- 🔄 **Replay-ready** structure for easy extension

---

## 📂 Project Structure

- `printBoard()` → Displays the current board state  
- `dropDisc()` → Handles disc placement in chosen column  
- `checkWin()` → Validates winning conditions  
- `isFull()` → Detects draw scenarios  
- `main()` → Game loop for player turns  

---

## 🚀 How to Run
1. Clone or download this repository.
2. Compile the program:
   ```bash
   javac ConnectFour.java
   java ConnectFour
## Sample game Output
. . . . . . .\
. . . . . . .\
. . . . . . .\
. . . . . . .\
. . . . . . .\
. . . X O . .\
0 1 2 3 4 5 6\
Player X wins!

