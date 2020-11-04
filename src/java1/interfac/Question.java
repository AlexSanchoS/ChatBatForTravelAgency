package java1.interfac;

public class Question {
    private static final String FIRST_QUESTION = "Оберіть вид туризму";
    private static final String SECOND_QUESTION = "Вкажіть дати відпочинку";
    private static final String THIRD_QUESTION = "Вкажіть кількість дорослих";
    private static final String FOURTH_QUESTION = "Вкажіть кількість дітей";
    private static final String FIFTH_QUESTION = "Вкажіть максимальну допустима ціну";
    private static final String STAR_QUESTION = "Вкажіть допустиму кількість зірок в отелі";
    private static final String SIXTH_QUESTION = "Ви маєте біометричний закордонний паспорт?";
    private static final String SEVENTH_QUESTION = "Ви маєте візу?";
    private static final String EIGHTH_QUESTION = "Вкажіть бажаний трансфер";

    public static String getQuestion(int number){
        switch (number){
            case 1:
                return FIRST_QUESTION;
            case 2:
                return SECOND_QUESTION;
            case 3:
                return THIRD_QUESTION;
            case 4:
                return FOURTH_QUESTION;
            case 5:
                return FIFTH_QUESTION;
            case 6:
                return SIXTH_QUESTION;
            case 7:
                return SEVENTH_QUESTION;
            case 8:
                return STAR_QUESTION;
            case 9:
                return EIGHTH_QUESTION;
        }
        return null;
    }
}
