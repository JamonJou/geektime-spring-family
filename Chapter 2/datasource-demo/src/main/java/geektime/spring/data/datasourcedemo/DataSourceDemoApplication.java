package geektime.spring.data.datasourcedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class DataSourceDemoApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		System.out.println("main-thread Starting...");
		SpringApplication.run(DataSourceDemoApplication.class, args);
		System.out.println("Exit main-thread");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.toString() + " run method");
		showConnection();
		showData();
	}

	private void showConnection() throws SQLException {
		log.info("DataSource: " + dataSource.toString());
		Connection conn = dataSource.getConnection();
		log.info("Connection: " + conn.toString());
		conn.close();
	}

	private void showData() {
		jdbcTemplate.queryForList("SELECT * FROM FOO")
				.forEach(row -> log.info(row.toString()));
	}
}

