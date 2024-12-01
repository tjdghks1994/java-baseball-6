package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private Computer computer;
    private NumberChecker numberChecker;
    private Player player;
    private boolean complete;   //   게임 성공 여부

    public Game(Computer computer, NumberChecker numberChecker, Player player) {
        this.computer = computer;
        this.numberChecker = numberChecker;
        this.player = player;
    }

    public void printGameStartText() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void start() {
        init(); // 초기화
        String answer = proceed();  // 게임 진행
        finish(answer);     // 게임 완료
    }

    private void finish(String answer) {
        if (answer.equals("1")) {
            start();    // 재시작
        } else {
            System.out.println("게임 종료");
        }
    }

    private String proceed() {
        while (!complete) {
            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();
            player.savePlayerNumber(number);

            String baseballGameResult = numberChecker.getBaseballGameResult(player);
            System.out.println(baseballGameResult);

            if (numberChecker.getStrikeCnt() == 3) {
                complete = true;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        return answer;
    }

    private void init() {
        computer.createNumber();
        complete = false;
    }
}
