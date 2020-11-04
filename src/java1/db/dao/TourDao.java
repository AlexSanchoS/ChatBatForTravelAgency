package java1.db.dao;

import java1.Main;
import java1.db.entity.Tour;
import java1.interfac.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TourDao {

    private static final String SQL_GET_COUNT_TOUR_WITH_PASSPORT = "SELECT count(tour.id) from hotel join kind join tour join country ON " +
            "kind.name = ? and kind.id = tour.kind_id " +
            "and (tour.price_for_adult*?+tour.price_for_child*?)*?+tour.journey_for_adult*?+tour.journey_for_child*?<? " +
            "and hotel.id = tour.hotel_id " +
            "and hotel.number_of_stars = ? " +
            "and tour.country_id = country.id " +
            "and country.biometric_passport='yes'";

    private static final String SQL_GET_COUNT_TOUR_WITHOUT_PASSPORT = "SELECT count(tour.id) from hotel join kind join tour join country ON " +
            "kind.name = ? and kind.id = tour.kind_id " +
            "and (tour.price_for_adult*?+tour.price_for_child*?)*?+tour.journey_for_adult*?+tour.journey_for_child*?<? " +
            "and hotel.id = tour.hotel_id " +
            "and hotel.number_of_stars = ? " +
            "and tour.country_id = country.id " +
            "and country.biometric_passport='no'";

    private static final String SQL_GET_COUNT_TOUR_WITHOUT_VISA = "SELECT count(tour.id) from hotel join kind join tour join country ON " +
            "kind.name = ? and kind.id = tour.kind_id " +
            "and (tour.price_for_adult*?+tour.price_for_child*?)*?+tour.journey_for_adult*?+tour.journey_for_child*?<? " +
            "and hotel.id = tour.hotel_id " +
            "and hotel.number_of_stars = ? " +
            "and tour.country_id = country.id " +
            "and country.biometric_passport=? " +
            "and country.visa = 'no'";

    private static final String SQL_GET_COUNT_TOUR_WITH_VISA = "SELECT count(tour.id) from hotel join kind join tour join country ON " +
            "kind.name = ? and kind.id = tour.kind_id " +
            "and (tour.price_for_adult*?+tour.price_for_child*?)*?+tour.journey_for_adult*?+tour.journey_for_child*?<? " +
            "and hotel.id = tour.hotel_id " +
            "and hotel.number_of_stars = ? " +
            "and tour.country_id = country.id " +
            "and country.biometric_passport=? " +
            "and country.visa = 'yes'";

    private static final String SQL_GET_COUNT_HOTEL_BY_KING_AND_STAR = "SELECT count(hotel.id) " +
            "from hotel join kind join tour ON " +
            "kind.name = ? and kind.id = tour.kind_id " +
            "and (tour.price_for_adult*?+tour.price_for_child*?)*?" +
            "+tour.journey_for_adult*?+tour.journey_for_child*?<? " +
            "and hotel.id = tour.hotel_id " +
            "and hotel.number_of_stars = ?";

    private static final String SQL_GET_YOUR_RESULT = "SELECT country.name, hotel.city, " +
            "(tour.price_for_adult*?+tour.price_for_child*?)*? + tour.journey_for_adult*?+tour.journey_for_child*?, " +
            "tour.food, tour.add_information " +
            "from hotel join kind join tour join country  ON " +
            "kind.name = ? and kind.id = tour.kind_id " +
            "and (tour.price_for_adult*?+tour.price_for_child*?)*? + tour.journey_for_adult*?+tour.journey_for_child*?<? " +
            "and hotel.id = tour.hotel_id and hotel.number_of_stars = ? and country.id = tour.country_id " +
            "and country.biometric_passport = ? and country.visa = ?";


    public int getCountToutWithPassport(String variant, int star) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = Main.connection;
        int rez = 0;
        try {
            pstmt = con.prepareStatement(SQL_GET_COUNT_TOUR_WITH_PASSPORT);
            pstmt.setString(1, variant);
            pstmt.setInt(2, Answer.getCountAdult());
            pstmt.setInt(3, Answer.getCountChild());
            pstmt.setInt(4, Answer.getDayCount());
            pstmt.setInt(5, Answer.getCountAdult());
            pstmt.setInt(6, Answer.getCountChild());
            pstmt.setInt(7, Answer.getPrice());
            pstmt.setInt(8, star);
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rez = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return rez;
    }

    public int getCountToutWithVisa(String variant, int star) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = Main.connection;
        int rez = 0;
        try {
            pstmt = con.prepareStatement(SQL_GET_COUNT_TOUR_WITH_VISA);
            pstmt.setString(1, variant);
            pstmt.setInt(2, Answer.getCountAdult());
            pstmt.setInt(3, Answer.getCountChild());
            pstmt.setInt(4, Answer.getDayCount());
            pstmt.setInt(5, Answer.getCountAdult());
            pstmt.setInt(6, Answer.getCountChild());
            pstmt.setInt(7, Answer.getPrice());
            pstmt.setInt(8, star);
            pstmt.setString(9, Answer.getPassportStatus());
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rez = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return rez;
    }

    public int getCountToutWithoutVisa(String variant, int star) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = Main.connection;
        int rez = 0;
        try {
            pstmt = con.prepareStatement(SQL_GET_COUNT_TOUR_WITHOUT_VISA);
            pstmt.setString(1, variant);
            pstmt.setInt(2, Answer.getCountAdult());
            pstmt.setInt(3, Answer.getCountChild());
            pstmt.setInt(4, Answer.getDayCount());
            pstmt.setInt(5, Answer.getCountAdult());
            pstmt.setInt(6, Answer.getCountChild());
            pstmt.setInt(7, Answer.getPrice());
            pstmt.setInt(8, star);
            pstmt.setString(9, Answer.getPassportStatus());
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rez = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return rez;
    }

    public int getCountToutWithoutPassport(String variant, int star) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = Main.connection;
        int rez = 0;
        try {
            pstmt = con.prepareStatement(SQL_GET_COUNT_TOUR_WITHOUT_PASSPORT);
            pstmt.setString(1, variant);
            pstmt.setInt(2, Answer.getCountAdult());
            pstmt.setInt(3, Answer.getCountChild());
            pstmt.setInt(4, Answer.getDayCount());
            pstmt.setInt(5, Answer.getCountAdult());
            pstmt.setInt(6, Answer.getCountChild());
            pstmt.setInt(7, Answer.getPrice());
            pstmt.setInt(8, star);
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rez = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return rez;
    }

    public int getCountHotelByStarAndKind(String variant, int star) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = Main.connection;
        int rez = 0;
        try {
            pstmt = con.prepareStatement(SQL_GET_COUNT_HOTEL_BY_KING_AND_STAR);
            pstmt.setString(1, variant);
            pstmt.setInt(2, Answer.getCountAdult());
            pstmt.setInt(3, Answer.getCountChild());
            pstmt.setInt(4, Answer.getDayCount());
            pstmt.setInt(5, Answer.getCountAdult());
            pstmt.setInt(6, Answer.getCountChild());
            pstmt.setInt(7, Answer.getPrice());
            pstmt.setInt(8, star);
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rez = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return rez;
    }

    public ArrayList<Tour> getTourList(String king, int star){
        ArrayList<Tour> rez = new ArrayList<>();
        String visa = Answer.getVisaStatus();
        String passport = Answer.getPassportStatus();
        if (passport.equals("yes")){
            if (visa.equals("yes")){
                rez.addAll(getTourListVisaPassport(king,star, "yes","yes"));
                rez.addAll(getTourListVisaPassport(king,star, "yes","no"));
                rez.addAll(getTourListVisaPassport(king,star, "no","no"));
                rez.addAll(getTourListVisaPassport(king,star, "no","yes"));
            }else{
                rez.addAll(getTourListVisaPassport(king,star, "yes","no"));
                rez.addAll(getTourListVisaPassport(king,star, "no","no"));
            }
        }else{
            if (visa.equals("yes")){
                rez.addAll(getTourListVisaPassport(king,star, "no","no"));
                rez.addAll(getTourListVisaPassport(king,star, "no","yes"));
            }else{
                rez.addAll(getTourListVisaPassport(king,star, "no","no"));
            }
        }
        return rez;
    }

    private ArrayList<Tour> getTourListVisaPassport(String king, int star,  String passport,String visa){
        ArrayList<Tour> rez = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = Main.connection;
        try {
            pstmt = con.prepareStatement(SQL_GET_YOUR_RESULT);
            pstmt.setInt(1, Answer.getCountAdult());
            pstmt.setInt(2, Answer.getCountChild());
            pstmt.setInt(3, Answer.getDayCount());
            pstmt.setInt(4, Answer.getCountAdult());
            pstmt.setInt(5, Answer.getCountChild());
            pstmt.setString(6, king);
            pstmt.setInt(7, Answer.getCountAdult());
            pstmt.setInt(8, Answer.getCountChild());
            pstmt.setInt(9, Answer.getDayCount());
            pstmt.setInt(10, Answer.getCountAdult());
            pstmt.setInt(11, Answer.getCountChild());
            pstmt.setInt(12, Answer.getPrice());
            pstmt.setInt(13, star);
            pstmt.setString(14, passport);
            pstmt.setString(15, visa);
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Tour tour = new Tour();
                tour.setCountry(rs.getString(1));
                tour.setCity(rs.getString(2));
                tour.setPrise(rs.getString(3));
                tour.setFood(rs.getString(4));
                tour.setAddInformation(rs.getString(5));
                rez.add(tour);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return rez;
    }



    private void close(AutoCloseable forClose) {
        if (forClose != null) {
            try {
                forClose.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
