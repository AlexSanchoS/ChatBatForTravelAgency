package java1.interfac;

import java1.db.dao.TourDao;
import java1.db.entity.Tour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModalRed extends AbstractTableModel {

    public ArrayList<String[]> tableData;
    public int columnQ1;

    public TableModalRed() {
        tableData = new ArrayList<String[]>();
        for (int i = 0; i < tableData.size(); i++) {
            tableData.add(new String[getColumnCount()]);
        }

        this.columnQ1 = 5;


    }

    @Override
    public int getColumnCount() {
        return columnQ1;
    }

    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        String[] rows = tableData.get(arg0);
        return rows[arg1];
    }

    @Override
    public String getColumnName(int colomnIndex) {

        switch (colomnIndex) {
            case 0:
                return "Країна";
            case 1:
                return "Місто";
            case 2:
                return "Ціна";
            case 3:
                return "Харчування";
            case 4:
                return "Додаткова інформація";

        }
        return null;

    }

    public void addData(String[] row) {
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        tableData.add(row);
    }

    public void addData() {
        ArrayList<String> kings = Answer.getAnswerListForKingQuestion();
        ArrayList<Integer> stars = Answer.getAnswerListForStarCount();
        ArrayList<Tour> tours = new ArrayList<>();
        for (String king : kings) {
            for (Integer star : stars) {
                tours.addAll(new TourDao().getTourList(king, star));
            }
        }
        for (Tour tour : tours) {
            String[] row = new String[]{tour.getCountry(), tour.getCity(), tour.getPrise(), tour.getFood(), tour.getAddInformation()};
            addData(row);
            System.out.println(tour);
        }
    }
}
