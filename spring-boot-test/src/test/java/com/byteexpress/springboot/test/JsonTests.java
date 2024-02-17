package com.byteexpress.springboot.test;

import com.byteexpress.springboot.test.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @Author: ByteExpress
 * @Date: 2024/2/16 14:51
 * @Version V1.0
 */
@JsonTest
public class JsonTests {
    @Autowired
    private JacksonTester<User> json;

    @Test
    void serialize() throws Exception {
        User user = new User("1001","汤姆", "17788996600");
        assertThat(this.json.write(user)).isEqualToJson("/demo.json");
        assertThat(this.json.write(user)).hasJsonPathStringValue("@.name");
        assertThat(this.json.write(user)).
                extractingJsonPathStringValue("@.name").isEqualTo("汤姆");
    }

    @Test
    void deserialize() throws Exception {
        String content = "{\"id\":\"林肯\", \"name\":\"林肯\", \"mobile\": \"17788996601\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new User("1002", "林肯", "17788996601"));
        assertThat(this.json.parseObject(content).getName()).isEqualTo("林肯");
    }
}
