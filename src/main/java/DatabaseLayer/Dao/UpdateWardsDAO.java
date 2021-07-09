package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Wards;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateWardsDAO {

    public static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    public static Connection connection = databaseConnection.openDBConnection();
    public static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Once the details are received for which update is required
     * The details are updated using SQL query
     */
    public static void updateWard(String str, int id) throws SQLException, ClassNotFoundException {

    }

    /* The details of the ward for which the details have to be updated the id is passed
     * The details are fetched by using SQL query
     */
    public static Wards getWardDetails(int id){

        Wards ward = new Wards();
        try {

            String query1 = "SELECT * from wards where ward_id = '" + id + "' ";
            ResultSet rs = statement.executeQuery(query1);
            while(rs.next()) {
                ward.setWardId(rs.getInt("ward_id"));
                ward.setWardType(rs.getString("ward_type"));
                ward.setWardName(rs.getString("name"));
                ward.setLocation(rs.getString("location"));
                ward.setTotalBeds(rs.getInt("total_beds"));
                ward.setBedType(rs.getString("bed_type"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ward;
    }
}