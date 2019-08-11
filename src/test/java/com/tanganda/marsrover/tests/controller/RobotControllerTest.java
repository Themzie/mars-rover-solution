package com.tanganda.marsrover.tests.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.tanganda.marsrover.MainApplication;
import com.tanganda.marsrover.service.ControllerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
@WebAppConfiguration
public class RobotControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ControllerService robotService;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
    public void shouldMoveTo2X0South() throws Exception{
        mockMvc.perform(post("/mars-robot/moveto/MMRMMRMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));
    }

    @Test
    public void shouldMoveTo0x2West() throws Exception{
        mockMvc.perform(post("/mars-robot/moveto/MML"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void shouldValidateInvalidCommand() throws Exception{
        String messageError = messageSource.getMessage("error.command_invalid", null, null);

        mockMvc.perform(post("/mars-robot/moveto/AAA"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(messageError));
    }

    @Test
    public void shouldValidateExceedBondaryLimite() throws Exception {
        String messageError = messageSource.getMessage("error.exceeded_boundary", null, null);

        mockMvc.perform(post("/mars-robot/moveto/MMMMMMMMMMM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(messageError));
    }
    
    @Test
    public void shouldValidateInternalServerErrorException() throws Exception {
        String messageError = messageSource.getMessage("error.unexpected", null, null);
        robotService.setBoundaryValidator(null);
        mockMvc.perform(post("/mars-robot/moveto/MM"))
        		.andExpect(status().isInternalServerError())
                .andExpect(content().string(messageError));
    }
}
