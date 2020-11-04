package java1.interfac;

import java1.db.dao.TourDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Quiz {
    private ImageIcon image;
    private JFrame frame;
    private JLabel label;
    private JTextField tf1, tf2, tf3;
    private JCheckBox cb1, cb2, cb3;
    private int questionNumber = 0;
    private boolean threeStar = false;
    private boolean fourStar = false;
    private boolean fiveStar = false;

    private static final String noTourMessage = "На жаль нема турів із заданими характеристиками";

    private JRadioButton rb1, rb2, rb3, rb4, rb5;

    public Quiz() {
        image = new ImageIcon(getClass().getResource("1.jpg"));
        getFirst();
    }

    private void getFirst() {

        questionNumber = 1;
        Font font = init();
        rb1 = new JRadioButton();
        rb1.setFont(font);
        rb1.setBackground(new Color(145, 197, 225));
        label.add(rb1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        rb1.setText(Answer.getAnswer(1, 1));

        rb2 = new JRadioButton();
        rb2.setFont(font);
        rb2.setBackground(new Color(145, 197, 225));
        label.add(rb2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        rb2.setText(Answer.getAnswer(1, 2));

        rb3 = new JRadioButton();
        rb3.setFont(font);
        rb3.setBackground(new Color(145, 197, 225));
        label.add(rb3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        rb3.setText(Answer.getAnswer(1, 3));

        rb4 = new JRadioButton();
        rb4.setFont(font);
        rb4.setBackground(new Color(145, 197, 225));
        label.add(rb4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        rb4.setText(Answer.getAnswer(1, 4));

        rb5 = new JRadioButton();
        rb5.setFont(font);
        rb5.setBackground(new Color(145, 197, 225));
        label.add(rb5, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        rb5.setText(Answer.getAnswer(1, 5));

        JButton btnAuto = new JButton();
        btnAuto.setText("Далі");
        btnAuto.setFont(font);
        label.add(btnAuto, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        btnAuto.addActionListener(new ListenerForFirst());

        frame.add(label);
        frame.setVisible(true);
    }

    private void getPassportQuiz() {

        questionNumber = 6;
        Font font = init();
        rb1 = new JRadioButton();
        rb1.setFont(font);
        rb1.setText("Так");
        rb1.setBackground(new Color(145, 197, 225));
        label.add(rb1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        rb2 = new JRadioButton();
        rb2.setFont(font);
        rb2.setText("Ні");
        rb2.setBackground(new Color(145, 197, 225));
        label.add(rb2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        JButton btnAuto = new JButton();
        btnAuto.setText("Далі");
        btnAuto.setFont(font);
        label.add(btnAuto, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        btnAuto.addActionListener(new ListenerForPassport());

        frame.add(label);
        frame.setVisible(true);
    }

    private void getVisaQuiz() {

        questionNumber = 7;
        Font font = init();
        rb1 = new JRadioButton();
        rb1.setFont(font);
        rb1.setText("Так");
        rb1.setBackground(new Color(145, 197, 225));
        label.add(rb1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        rb2 = new JRadioButton();
        rb2.setFont(font);
        rb2.setText("Ні");
        rb2.setBackground(new Color(145, 197, 225));
        label.add(rb2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        JButton btnAuto = new JButton();
        btnAuto.setText("Далі");
        btnAuto.setFont(font);
        label.add(btnAuto, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        btnAuto.addActionListener(new ListenerForVisa());

        frame.add(label);
        frame.setVisible(true);
    }

    private void getVisaTest() {
        ArrayList<String> listOfAnswerForFirstQuestion = Answer.getAnswerListForKingQuestion();
        int tourWithVisa = 0;
        int tourWithoutVisa = 0;

        for (String variantOfAnswer : listOfAnswerForFirstQuestion) {
            if (tourWithVisa == 0) {
                ArrayList<Integer> listOfStar = Answer.getAnswerListForStarCount();
                for (Integer star : listOfStar) {
                    tourWithVisa += new TourDao().getCountToutWithVisa(variantOfAnswer, star);
                }
            }
            if (tourWithoutVisa == 0) {
                ArrayList<Integer> listOfStar = Answer.getAnswerListForStarCount();
                for (Integer star : listOfStar) {
                    tourWithoutVisa += new TourDao().getCountToutWithoutVisa(variantOfAnswer, star);
                }
            }
        }
        if ((tourWithoutVisa > 0) && (tourWithVisa > 0)) {
            getVisaQuiz();
            return;
        }
        if (tourWithoutVisa > 0) {
            Answer.setSetOfAnswer(7, 0, "no");
        }
        if (tourWithVisa > 0) {
            Answer.setSetOfAnswer(7, 0, "yes");
        }
        getResult();
    }

    private void getResult(){
        new RedTable().stvor();
    }

    private void getSecond() {

        questionNumber = 2;
        Font font = init();
        JLabel lab1 = new JLabel();
        lab1.setFont(font);
        label.add(lab1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        lab1.setText(Answer.getAnswer(2, 1));

        tf1 = new JTextField();
        tf1.setFont(font);
        label.add(tf1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));


        JLabel lab2 = new JLabel();
        lab2.setFont(font);
        label.add(lab2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        lab2.setText(Answer.getAnswer(2, 2));
        tf2 = new JTextField();
        tf2.setFont(font);
        label.add(tf2, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        JButton btnAuto = new JButton();
        btnAuto.setText("Далі");
        btnAuto.setFont(font);
        label.add(btnAuto, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        btnAuto.addActionListener(new ListenerForSecond());

        frame.add(label);
        frame.setVisible(true);
    }

    private void getThirdFourthFifth() {

        questionNumber = 3;
        Font font = init();
        tf1 = new JTextField();
        tf1.setFont(font);
        label.add(tf1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));


        JLabel lab2 = new JLabel();
        lab2.setFont(font);
        label.add(lab2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        lab2.setText(Question.getQuestion(4));
        tf2 = new JTextField();
        tf2.setFont(font);
        label.add(tf2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        JLabel lab3 = new JLabel();
        lab3.setFont(font);
        label.add(lab3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        lab3.setText(Question.getQuestion(5));
        tf3 = new JTextField();
        tf3.setFont(font);
        label.add(tf3, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        JButton btnAuto = new JButton();
        btnAuto.setText("Далі");
        btnAuto.setFont(font);
        label.add(btnAuto, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        btnAuto.addActionListener(new ListenerForThirdFourth());

        frame.add(label);
        frame.setVisible(true);
    }

    private void gerStarQuiz() {

        questionNumber = 8;
        Font font = init();


        cb1 = new JCheckBox();
        cb1.setText("3");
        cb1.setFont(font);
        cb1.setBackground(new Color(145, 197, 225));
        label.add(cb1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        cb2 = new JCheckBox();
        cb2.setText("4");
        cb2.setFont(font);
        cb2.setBackground(new Color(145, 197, 225));
        label.add(cb2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        cb3 = new JCheckBox();
        cb3.setText("5");
        cb3.setFont(font);
        cb3.setBackground(new Color(145, 197, 225));
        label.add(cb3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));


        JButton btnAuto = new JButton();
        btnAuto.setText("Далі");
        btnAuto.setFont(font);
        label.add(btnAuto, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        btnAuto.addActionListener(new ListenerForStar());

        frame.add(label);
        frame.setVisible(true);
    }

    private Font init() {
        frame = new JFrame();
        frame.setTitle("Туристичне агенство");
        frame.setSize(480, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Font font = new Font("TimesRoman", Font.BOLD, 14);
        Font font1 = new Font("TimesRoman", Font.BOLD, 18);
        label = new JLabel();
        label.setLayout(new GridBagLayout());
        label.setVisible(true);
        label.setBackground(Color.BLUE);
        label.setIcon(image);

        JLabel label1 = new JLabel();
        label1.setFont(font1);
        label.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        label1.setText(Question.getQuestion(questionNumber));
        return font;
    }

    private void shov() {
        frame.setVisible(false);
    }

    class ListenerForFirst implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shov();
            String answer = null;
            int num = 0;
            if (rb1.isSelected()) {
                answer = Answer.getAnswer(1, 1);
                Answer.setSetOfAnswer(0, num++, answer);
            }
            if (rb2.isSelected()) {
                answer = Answer.getAnswer(1, 2);
                Answer.setSetOfAnswer(0, num++, answer);
            }
            if (rb3.isSelected()) {
                answer = Answer.getAnswer(1, 3);
                Answer.setSetOfAnswer(0, num++, answer);
            }
            if (rb4.isSelected()) {
                answer = Answer.getAnswer(1, 4);
                Answer.setSetOfAnswer(0, num++, answer);
            }
            if (rb5.isSelected()) {
                answer = Answer.getAnswer(1, 5);
                Answer.setSetOfAnswer(0, num++, answer);
            }
            getSecond();
        }
    }

    class ListenerForSecond implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shov();
            Answer.setSetOfAnswer(1, 0, tf1.getText());
            Answer.setSetOfAnswer(1, 1, tf2.getText());
            getThirdFourthFifth();
        }
    }

    class ListenerForThirdFourth implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shov();
            Answer.setSetOfAnswer(2, 0, tf1.getText());
            Answer.setSetOfAnswer(3, 0, tf2.getText());
            Answer.setSetOfAnswer(4, 0, tf3.getText());
            ArrayList<String> listOfAnswerForFirstQuestion = Answer.getAnswerListForKingQuestion();
            int countThreeStar = 0;
            int countFourStar = 0;
            int countFiveStar = 0;
            for (String variantOfAnswer : listOfAnswerForFirstQuestion) {
                if (countThreeStar == 0) {
                    countThreeStar += new TourDao().getCountHotelByStarAndKind(variantOfAnswer, 3);
                }
                if (countFourStar == 0) {
                    countFourStar += new TourDao().getCountHotelByStarAndKind(variantOfAnswer, 4);
                }
                if (countFiveStar == 0) {
                    countFiveStar += new TourDao().getCountHotelByStarAndKind(variantOfAnswer, 5);
                }
            }
            if (countThreeStar > 0) {
                threeStar = true;
            }
            if (countFourStar > 0) {
                fourStar = true;
            }
            if (countFiveStar > 0) {
                fiveStar = true;
            }
            if (threeStar && fourStar && fiveStar) {
                gerStarQuiz();
            } else {
                JOptionPane.showMessageDialog(null, noTourMessage);
            }
        }
    }

    class ListenerForStar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            shov();
            if (cb1.isSelected()) {
                Answer.setSetOfAnswer(8, 0, "true");
            }
            if (cb2.isSelected()) {
                Answer.setSetOfAnswer(8, 1, "true");
            }
            if (cb3.isSelected()) {
                Answer.setSetOfAnswer(8, 2, "true");
            }
            ArrayList<String> listOfAnswerForFirstQuestion = Answer.getAnswerListForKingQuestion();
            int tourWithPassport = 0;
            int tourWithoutPassport = 0;

            for (String variantOfAnswer : listOfAnswerForFirstQuestion) {
                if (tourWithPassport == 0) {
                    ArrayList<Integer> listOfStar = Answer.getAnswerListForStarCount();
                    for (Integer star : listOfStar) {
                        tourWithPassport += new TourDao().getCountToutWithPassport(variantOfAnswer, star);
                    }
                }
                if (tourWithoutPassport == 0) {
                    ArrayList<Integer> listOfStar = Answer.getAnswerListForStarCount();
                    for (Integer star : listOfStar) {
                        tourWithoutPassport += new TourDao().getCountToutWithoutPassport(variantOfAnswer, star);
                    }
                }
            }
            if ((tourWithoutPassport > 0) && (tourWithPassport > 0)) {
                getPassportQuiz();
                return;
            }
            if (tourWithoutPassport > 0) {
                Answer.setSetOfAnswer(6, 0, "no");
            }
            if (tourWithPassport > 0) {
                Answer.setSetOfAnswer(6, 0, "yes");
            }
            getVisaTest();
        }
    }

    class ListenerForPassport implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shov();
            if (rb1.isSelected()) {
                Answer.setSetOfAnswer(6, 0, "yes");
            }
            if (rb2.isSelected()) {
                Answer.setSetOfAnswer(6, 0, "no");
            }
            getVisaTest();
        }
    }

    class ListenerForVisa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shov();
            if (rb1.isSelected()) {
                Answer.setSetOfAnswer(7, 0, "yes");
            }
            if (rb2.isSelected()) {
                Answer.setSetOfAnswer(7, 0, "no");
            }
            getResult();
        }
    }
}
