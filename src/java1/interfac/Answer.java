package java1.interfac;

import java1.CalendarProcessing;

import java.util.ArrayList;
import java.util.Calendar;

public class Answer {
    private static String listOfAnswer[][] = new String[10][5];

    private static final String FIRST_QUESTION_FIRST_VARIANT = "Рекреаційний";
    private static final String FIRST_QUESTION_SECOND_VARIANT = "Культурно-історичний";
    private static final String FIRST_QUESTION_THIRD_VARIANT = "Лікувально-оздоровчий";
    private static final String FIRST_QUESTION_FOURTH_VARIANT = "Спортивно-екстримальний";
    private static final String FIRST_QUESTION_FIFTH_VARIANT = "Екотуризм";
    private static final String SECOND_QUESTION_FIRST_VARIANT = "З";
    private static final String SECOND_QUESTION_SECOND_VARIANT = "По";
    private static final String SIXTH_QUESTION_FIRST_VARIANT = "Так";
    private static final String SIXTH_QUESTION_SECOND_VARIANT = "Ні";
    private static final String SEVENTH_QUESTION_FIRST_VARIANT = "Так";
    private static final String SEVENTH_QUESTION_SECOND_VARIANT = "Ні";

    public static String getAnswer(int qNumber, int aNumber) {
        if (qNumber == 1) {
            switch (aNumber) {
                case 1:
                    return FIRST_QUESTION_FIRST_VARIANT;
                case 2:
                    return FIRST_QUESTION_SECOND_VARIANT;
                case 3:
                    return FIRST_QUESTION_THIRD_VARIANT;
                case 4:
                    return FIRST_QUESTION_FOURTH_VARIANT;
                case 5:
                    return FIRST_QUESTION_FIFTH_VARIANT;

            }
        }
        if (qNumber == 2) {
            switch (aNumber) {
                case 1:
                    return SECOND_QUESTION_FIRST_VARIANT;
                case 2:
                    return SECOND_QUESTION_SECOND_VARIANT;
            }
        }
        return null;
    }

    public static void setSetOfAnswer(int numberI, int numberJ, String answer) {
        listOfAnswer[numberI][numberJ] = answer;
    }

    public static int getCountAdult() {
        return Integer.parseInt(listOfAnswer[2][0]);
    }

    public static int getCountChild() {
        return Integer.parseInt(listOfAnswer[3][0]);
    }

    public static int getPrice() {
        return Integer.parseInt(listOfAnswer[4][0]);
    }

    public static String getPassportStatus() {
        return listOfAnswer[6][0];
    }
    public static String getVisaStatus() {
        return listOfAnswer[7][0];
    }

    public static int getDayCount() {
        Calendar startDate = CalendarProcessing.string2FullDate(listOfAnswer[1][0]);
        Calendar endDate = CalendarProcessing.string2FullDate(listOfAnswer[1][1]);

        return CalendarProcessing.dayCount(startDate, endDate);
    }


    public static ArrayList<String> getAnswerListForKingQuestion() {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < listOfAnswer[0].length; i++) {
            if (listOfAnswer[0][i] != null) {
                res.add(listOfAnswer[0][i]);
            }
        }
        return res;
    }

    public static ArrayList<Integer> getAnswerListForStarCount() {
        ArrayList<Integer> res = new ArrayList<>();
        if (listOfAnswer[8][0] != null) {
            res.add(3);
        }
        if (listOfAnswer[8][1] != null) {
            res.add(4);
        }
        if (listOfAnswer[8][2] != null) {
            res.add(5);
        }
        return res;
    }

}

