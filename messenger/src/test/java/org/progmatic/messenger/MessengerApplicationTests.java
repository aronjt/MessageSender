package org.progmatic.messenger;

import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
class MessengerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	void homeShouldReturnGreeting() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/home"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("HomePage"))
				.andExpect(MockMvcResultMatchers.content().string(StringContains.containsString("List of messages")));
	}

	@Test
	void newMessageReturn() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/newmessage"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("NewMessage"))
				.andExpect(MockMvcResultMatchers.content().string(StringContains.containsString("From")));
	}

	@Test
	public void testCreateMessage() throws Exception {
		System.out.println("createMessage");
		mockMvc.perform(
				MockMvcRequestBuilders.post("/newmessagesend")
						.param("from", "essssn")
						.param("to", "tessss")
						.param("message", "cssss")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andExpect(
						MockMvcResultMatchers.redirectedUrl("/home"));
	}


}
