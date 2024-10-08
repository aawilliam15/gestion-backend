package com.gestion.reclamo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class GestionReclamoBackendAplicationTests {
	@Autowired
	private MockMvc mockMvc;
	// SE VERIFICA QUE LA RESPUESTA SEA UN ARRAY
	
	   @Test
	    void testListarReclamos() throws Exception {
	        String token = obtenerToken(); 

	        mockMvc.perform(get("http://web-backend-b9cxcpawaxbreqdu.canadacentral-01.azurewebsites.net/api/v1/reclamos")
	                .header("Authorization",  token)) 
	                .andExpect(status().isOk()) 
	                .andExpect(jsonPath("$").isArray());
	    }
	   
	   
	   
	   private String obtenerToken() throws Exception {
	        String loginJson = "{\"user\":\"admin\",\"pwd\":\"admintest\"}";

	        MvcResult result = mockMvc.perform(post("http://web-backend-b9cxcpawaxbreqdu.canadacentral-01.azurewebsites.net/api/v1/login")
	                .contentType("application/json")
	                .content(loginJson))
	                .andExpect(status().isOk()) 
	                .andReturn();

	        String token = result.getResponse().getContentAsString();
	        return token; 
	    }
}