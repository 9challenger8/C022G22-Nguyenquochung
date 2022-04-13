package ss8_clean_code_va_refactoring.bai_tap.refactoring;

public class TennisGame {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static String getScore(int scorePlayer1, int scorePlayer2) {
        String matchResult = "";
        if (scorePlayer1==scorePlayer2)
        {
            return getScorePlayer1(scorePlayer1);
        }
        else if (scorePlayer1>=4 || scorePlayer2>=4)
        {
            matchResult = getResult(scorePlayer1, scorePlayer2);
        }
        else
        {
            matchResult = getScore(scorePlayer1, scorePlayer2, matchResult);
        }
        return matchResult;
    }

    private static String getScore(int scorePlayer1, int scorePlayer2, String matchResult) {
        for (int i=1; i<3; i++)
        {
            int tempScore;
            if (i==1) tempScore = scorePlayer1;
            else {
                matchResult +="-";
                tempScore = scorePlayer2;
            }
            switch(tempScore)
            {
                case 0:
                    matchResult +="Love";
                    break;
                case 1:
                    matchResult +="Fifteen";
                    break;
                case 2:
                    matchResult +="Thirty";
                    break;
                case 3:
                    matchResult +="Forty";
                    break;
            }
        }
        return matchResult;
    }

    private static String getResult(int scorePlayer1, int scorePlayer2) {
        String matchResult;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult==1) matchResult ="Advantage player1";
        else if (minusResult ==-1) matchResult ="Advantage player2";
        else if (minusResult >= 2) matchResult = "Win for player1";
        else matchResult ="Win for player2";
        return matchResult;
    }

    private static String getScorePlayer1(int scorePlayer1) {
        switch (scorePlayer1)
        {
            case ZERO:
                return  "Love-All";
            case ONE:
                return  "Fifteen-All";
            case TWO:
                return  "Thirty-All";
            case THREE:
                return  "Forty-All";
            default:
                return  "Deuce";
        }
    }
}
