package jp.ac.uryukyu.ie.e245752;

import java.util.Random;

public class GameTest {
    private static final String[] handNames = {"グー", "パー", "チョキ"};
    private static final String[] directionNames = {"上", "下", "左", "右"};

    public int determineWinner(int userChoice, int computerChoice) {
        // 勝敗判定
        return (userChoice - computerChoice + 3) % 3;
    }

    public String determineGameResult(int result) {
        if (result == 0) {
            return "引き分け";
        } else if (result == 1) {
            return "ユーザーの勝ち";
        } else {
            return "コンピュータの勝ち";
        }
    }

    public boolean isDirectionMatch(int userDirection, int computerDirection) {
        return userDirection == computerDirection;
    }
    
    public int getComputerChoice() {
        return new Random().nextInt(3);
    }

    public int getComputerDirection() {
        return new Random().nextInt(4);
    }
}
