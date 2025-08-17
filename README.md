# 🏏 Console Cricket Game

A fun **console-based cricket game** built in **Java** using the **MVC (Model-View-Controller)** architecture.  
Play against the computer, track runs, wickets, and overs — with a live **scorecard** displayed in colorful terminal output.

---

## 📌 Features
- 🎮 Console-based gameplay
- 🏏 Batting system with random outcomes (Runs, Wickets, Extras)
- 📊 Live **Scorecard** (Runs, Wickets, Balls, Overs, Run Rate)
- 🌈 Colorful terminal text (using ANSI escape codes)
- 🎯 MVC Architecture for clean code separation
  - **Model** → Player, Match, ScoreCard
  - **View** → GameView (handles colorful output)
  - **Controller** → GameController (manages game flow)
- 🚀 Easy to extend (e.g., add 2-player mode, custom overs/wickets)

---

## 🏗️ Project Structure
ConsoleCricket/
│── src/
│ ├── Main.java
│ ├── controller/
│ │ └── GameController.java
│ ├── model/
│ │ ├── Player.java
│ │ ├── ScoreCard.java
│ │ └── Match.java
│ └── view/
│ └── GameView.java
│
│── README.md


---

## ⚡ Installation & Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/console-cricket.git
   cd console-cricket/src
javac Main.java
java Main

#🎮 Gameplay Flow
-Enter your player name.
-Choose the number of overs.
-Start batting against the computer:
-Runs are generated randomly (0,1,2,3,4,6)
-Wickets fall randomly!
-Score updates after every ball.
-Game ends after all overs or all wickets are lost.
-Final Scorecard is displayed.

#🌈 Terminal Colors
-🟢 Runs → Green
-🔴 Wickets → Red
-🟡 Extras → Yellow
-🔵 Game Info → Blue
-(Color codes are handled using ANSI escape codes.)

#Sample Output
🏏 Welcome to Console Cricket!
Enter your name: Ajay
Enter number of overs: 2

Over 1, Ball 1 → You scored 4 runs! 🟢
Over 1, Ball 2 → WICKET! 🔴
Over 1, Ball 3 → You scored 6 runs! 🟢

📊 Scorecard:
Player: Ajay
Runs: 10
Wickets: 1
Balls: 3
Overs: 0.3
Run Rate: 20.0

