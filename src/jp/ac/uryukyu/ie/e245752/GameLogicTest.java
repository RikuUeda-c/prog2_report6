package jp.ac.uryukyu.ie.e245752;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameLogicTest {

    @Test
    public void testDetermineWinner() {
        GameLogic gameLogic = new GameLogic();

        // ユーザーがグー（0）、コンピュータがチョキ（2）
        int result = gameLogic.determineWinner(0, 2);
        assertEquals(1, result); // ユーザーの勝ち

        // ユーザーがパー（1）、コンピュータがグー（0）
        result = gameLogic.determineWinner(1, 0);
        assertEquals(1, result); // ユーザーの勝ち

        // ユーザーがチョキ（2）、コンピュータがパー（1）
        result = gameLogic.determineWinner(2, 1);
        assertEquals(1, result); // ユーザーの勝ち

        // ユーザーとコンピュータが同じ手の場合
        result = gameLogic.determineWinner(0, 0);
        assertEquals(0, result); // 引き分け
    }

    @Test
    public void testDetermineGameResult() {
        GameLogic gameLogic = new GameLogic();

        // 引き分け
        String result = gameLogic.determineGameResult(0);
        assertEquals("引き分け", result);

        // ユーザーの勝ち
        result = gameLogic.determineGameResult(1);
        assertEquals("ユーザーの勝ち", result);

        // コンピュータの勝ち
        result = gameLogic.determineGameResult(2);
        assertEquals("コンピュータの勝ち", result);
    }

    @Test
    public void testIsDirectionMatch() {
        GameLogic gameLogic = new GameLogic();

        // ユーザーとコンピュータが同じ方向
        boolean isMatch = gameLogic.isDirectionMatch(0, 0);
        assertTrue(isMatch);

        // ユーザーとコンピュータが異なる方向
        isMatch = gameLogic.isDirectionMatch(0, 1);
        assertFalse(isMatch);
    }

    @Test
    public void testGetComputerChoice() {
        GameLogic gameLogic = new GameLogic();
        
        // コンピュータの選択が0から2の範囲であることをテスト
        int choice = gameLogic.getComputerChoice();
        assertTrue(choice >= 0 && choice <= 2);
    }

    @Test
    public void testGetComputerDirection() {
        GameLogic gameLogic = new GameLogic();

        // コンピュータの方向が0から3の範囲であることをテスト
        int direction = gameLogic.getComputerDirection();
        assertTrue(direction >= 0 && direction <= 3);
    }
}