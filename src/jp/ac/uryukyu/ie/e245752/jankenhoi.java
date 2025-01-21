package jp.ac.uryukyu.ie.e245752;
import java.util.Random;
import java.util.Scanner;

public class jankenhoi {

    // 定数でじゃんけんの手を定義
    private static final int ROCK = 0;  // グー
    private static final int PAPER = 1; // パー
    private static final int SCISSORS = 2; // チョキ
    private static final String[] handNames = {"グー", "パー", "チョキ"};
    
    // 定数で方向を定義
    private static final int UP = 0;    // 上
    private static final int DOWN = 1;  // 下
    private static final int LEFT = 2;  // 左
    private static final int RIGHT = 3; // 右
    private static final String[] directionNames = {"上", "下", "左", "右"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("あっち向いてホイ ゲーム開始！");

        while (true) {
            // 1. じゃんけん
            System.out.println("じゃんけんを始めます。");
            System.out.println("グーは 0、パーは 1、チョキは 2 を入力してください。");

            int userChoice = scanner.nextInt();
            if (userChoice < 0 || userChoice > 2) {
                System.out.println("無効な入力です。0, 1, 2 のいずれかを入力してください。");
                continue;  // 無効な入力(0~2以外)の場合は再度じゃんけんを行う
            }

            // コンピュータの選択
            int computerChoice = random.nextInt(3);

            System.out.println("あなたの選択: " + handNames[userChoice]);
            System.out.println("コンピュータの選択: " + handNames[computerChoice]);

            // じゃんけんの勝敗判定
            int result = (userChoice - computerChoice + 3) % 3;

            if (result == 0) {
                System.out.println("引き分け！ もう一度じゃんけんをしよう！！\n");
                continue; // 引き分けの場合はじゃんけんを繰り返す
            } else {
                String winner = (result == 1) ? "あなた" : "コンピュータ";
                System.out.println(winner + "の勝ちです！");
                
                // 勝った場合、あっち向いてホイ
                System.out.println("次はあっち向いてホイ！");

                // ユーザーとコンピュータが向きを決める
                System.out.println("方向は 上は 0、下は 1、左は 2、右は 3 を入力してください。");
                int userDirection = scanner.nextInt();
                if (userDirection < 0 || userDirection > 3) {
                    System.out.println("無効な入力です。0, 1, 2, 3 のいずれかを入力してください。");
                    continue; // 無効な入力の場合は再度じゃんけんを行う
                }

                int computerDirection = random.nextInt(4); // コンピュータの方向をランダムに選択                

                //じゃんけんであなたが勝った時
                if (winner == "あなた"){
                    System.out.println("あなたの向き: " + directionNames[userDirection]);
                    System.out.println("コンピュータの向き: " + directionNames[computerDirection]);
    
                    // あっち向いてホイの結果判定
                    if (userDirection == computerDirection) {
                        System.out.println("おめでとう！コンピュータがあなたの向きを向きました！you win!!");
                    } else {
                        System.out.println("残念！コンピュータはあなたの向きを向きませんでした。");
                    }
                    break; // 勝者が決まったのでゲーム終了
                }
                //じゃんけんでコンピュータが勝った時 
                else{
                    System.out.println("あなたの向き: " + directionNames[userDirection]);
                    System.out.println("コンピュータの向き: " + directionNames[computerDirection]);
    
                    // あっち向いてホイの結果判定
                    if (userDirection == computerDirection) {
                        System.out.println("残念！あなたがコンピュータの向きを向きました！you lose");
                    } else {
                        System.out.println("あなたはコンピュータの向きを向きませんでした。");
                    }
                    break; // 勝者が決まったのでゲーム終了
                    }  
                }
            }
        }
}

