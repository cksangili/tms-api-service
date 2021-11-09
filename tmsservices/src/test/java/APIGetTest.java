import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;


public class APIGetTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        //final TestBean person = new TestBean("Luther Blissett", "lb@example.com");

       // final String expected = MAPPER.writeValueAsString(
       //         MAPPER.readValue(fixture("fixtures/person.json"), TestBean.class));

       // assertThat(MAPPER.writeValueAsString(person)).isEqualTo(expected);
    }
}
