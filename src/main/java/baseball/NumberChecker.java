package baseball;

import java.util.List;

public class NumberChecker {
    private int ballCnt;
    private int strikeCnt;
    private Computer computer;

    public NumberChecker(Computer computer) {
        this.strikeCnt = 0;
        this.ballCnt = 0;
        this.computer = computer;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public String getBaseballGameResult(Player player) {
        checkResult(player);
        return createResultContent();
    }

    private void checkResult(Player player) {
        int ballCnt = 0;
        int strikeCnt = 0;
        List<Integer> playerList = player.getNumbers();
        List<Integer> computerList = computer.getNumbers();

        for (int i = 0; i < playerList.size(); i++) {
            // 컴퓨터의 3자리 숫자 중에 포함되면서 자릿수 까지 일치한 경우
            if (computerList.contains(playerList.get(i)) && computerList.get(i) == playerList.get(i)) {
                strikeCnt++;
                continue;
            }
            // 컴퓨터의 3자리 숫자 중에 포함된 숫자인 경우
            if (computerList.contains(playerList.get(i))) {
                ballCnt++;
            }
        }

        changeCount(ballCnt, strikeCnt);
    }

    private void changeCount(int ballCnt, int strikeCnt) {
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    private String createResultContent() {
        StringBuilder builder = new StringBuilder();
        if (getBallCnt() == 0 && getStrikeCnt() == 0) {
            builder.append("낫싱");
        }
        if (getBallCnt() != 0) {
            builder.append(getBallCnt() + "볼");
        }
        // 볼 카운트가 존재하면 스트라이크 카운트 출력 시 공백 추가 - ex) 1볼 1스트라이크
        if (getBallCnt() != 0 && getStrikeCnt() != 0) {
            builder.append(" ").append(getStrikeCnt() + "스트라이크");
        }
        // 볼 카운트가 존재하지 않으면 스트라이크 카운트 출력 시 공백 X - ex) 2스트라이크
        if (getBallCnt() == 0 && getStrikeCnt() != 0) {
            builder.append(getStrikeCnt() + "스트라이크");
        }

        return builder.toString();
    }
}
