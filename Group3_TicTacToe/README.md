# TicTacToe - Group A

A simple console-based TicTacToe game developed as part of the Software Lifecycle course at FH Technikum Wien.

## About

This project is a digital version of the classic TicTacToe game, played in the console.
Two players take turns placing their symbols (X and O) on a 3x3 board until one player wins or the game ends in a draw.

## How to Run

### Requirements
- Java 17 or higher
- Maven

### Steps
```bash
git clone git@github.com:MiklasRiha/Group-A-s-public-repository.git
cd Group3_TicTacToe
mvn install
mvn exec:java
```

## Branching Strategy

We use one feature branch per user story:
- `feature/US-01-player-move`
- `feature/US-02-game-state-display`
- `feature/US-03-game-end-notification`
- `feature/US-04-new-game`

Every branch is merged into `main` via Pull Request after review by a team member.

## CI/CD

- Automated Maven tests run on every Pull Request before merging
- Merging to `main` builds and publishes the `.jar` as a downloadable artifact

## Team

- Miklas
- Kevin
- Daniel

<dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>