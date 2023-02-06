import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StratSQL {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("StratSQL");
            c = DriverManager.getConnection("jdbc:sqlite:strat.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM strat;");

            while (rs.next()) {
                int id = rs.getInt("id");
                int site = rs.getInt("site");
                String hole = rs.getString("hole");
                String type = rs.getString("type");
                String label = rs.getString("label");
                double min_depth = rs.getDouble("min_depth");
                double max_depth = rs.getDouble("max_depth");
                double avg_depth = rs.getDouble("avg_depth");
                double age = rs.getDouble("age");

                System.out.println("ID = " + id);
                System.out.println("SITE = " + site);
                System.out.println("HOLE = " + hole);
                System.out.println("TYPE = " + type);
                System.out.println("LABEL = " + label);
                System.out.println("MIN DEPTH = " + min_depth + " cmbsf");
                System.out.println("MAX DEPTH = " + max_depth + " cmbsf");
                System.out.println("AVG DEPTH = " + avg_depth + " cmbsf");
                System.out.println("AGE = " + age + "Ma");
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
