package com.tanganda.marsrover.tests.marsrover;

import com.tanganda.marsrover.MainApplication;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

public class MarsRobotApplicationTests {

	@Rule
    public OutputCapture outputCapture = new OutputCapture();

    private static final String SPRING_INIT = "root of context hierarchy";

    @Test
    public void shouldInitApplication() throws Exception {
        MainApplication.main(new String[0]);
        assertThat(outputCapture.toString()).contains(SPRING_INIT);
    }
}
