package org.ccfebras.ckp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class CkpApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {
    }

    @Test
    public void connectionEstablished() throws SQLException {
        Connection connection = dataSource.getConnection();
        assertThat(connection.getCatalog(), is("test"));
    }
}
