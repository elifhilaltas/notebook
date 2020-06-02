package notebook.web;

import com.notebook.domain.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
public class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;
/*
    @Test
    public void testGetUsers(){

        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/users", List.class);
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(200));
       // List<User> users = response.getBody();

    }


 */

}
