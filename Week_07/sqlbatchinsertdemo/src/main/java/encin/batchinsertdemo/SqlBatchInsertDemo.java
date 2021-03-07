package encin.batchinsertdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.zaxxer.hikari.HikariDataSource;


public class SqlBatchInsertDemo {

    public static void main(final String[] args) throws SQLException {

        final JdbcUtil jdbcUtil = new JdbcUtil();
        final HikariDataSource hikariDS = jdbcUtil.getHikariDS();
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = hikariDS.getConnection();
            connection.setAutoCommit(false);

            final String createSql = "insert into test values(?,?)";
            ps = connection.prepareStatement(createSql);
            final Long start = System.currentTimeMillis();
            int k = 0;

            for (Integer i = 1; i <= 1000000; i++) {
                ps.setString(1, String.valueOf(i));
                ps.setString(2, String.valueOf(System.currentTimeMillis()));
                ps.addBatch();
//                if (i % 10000 == 0) {

                    ps.executeBatch();
                    connection.commit();
                    ps.clearBatch();

                    System.out.println("execute-----" + k++);
//                }
            }
            ps.executeBatch();
            connection.commit();

            final Long end = System.currentTimeMillis();
            System.out.println("耗时(ms)：" + (end - start));//分组情况 5917  不分组情况   3806537
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            connection.close();
        }
    }
}
