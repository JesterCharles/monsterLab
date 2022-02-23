package com.revature.monster_lab.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserControllerIntegrationTest {

//    private MockMvc mockMvc;
//    private final WebApplicationContext context;
//    private final ObjectMapper mapper;
//
//    @Autowired
//    public UserControllerIntegrationTest(WebApplicationContext context, ObjectMapper mapper) {
//        this.context = context;
//        this.mapper = mapper;
//    }
//
//    @BeforeEach
//    public void setup() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
    
    @Test
    public void test_isTrue_returnTrue() {
    	assertTrue(true);
    }

//    @Test
//    public void test_checkUsernameAvailability_returns204_givenThatProvidedUsernameIsNotTaken() throws Exception {
//        mockMvc.perform(get("/scientists/username?username=totally-not-taken-username"))
//               .andDo(print())
//               .andExpect(status().is(204))
//               .andReturn();
//    }
	
//	@Test
//	public void test_isScientistValid_returnsFalse_givenUserWithFirstName() {
//		
//		// Arrange
//		ScientistRequest invalidScientist1 = new ScientistRequest("","valid","valid","valid","valid");
//		ScientistRequest invalidScientist2 = new ScientistRequest(null,"valid","valid","valid","valid");
//		ScientistRequest invalidScientist3 = new ScientistRequest("         ","valid","valid","valid","valid");
//		
//		
//		//Act
//		boolean actualResult1 = sut.isScientistValid(invalidScientist1);
//		boolean actualResult2 = sut.isScientistValid(invalidScientist2);
//		boolean actualResult3 = sut.isScientistValid(invalidScientist3);
//		
//		//Assert - everything you assert must pass the condition
//		assertFalse(actualResult1);
//		assertFalse(actualResult2);
//		assertFalse(actualResult3);
//		
//	}
//	
//	//TODO: Figure out implementation. CHARLES YOU DINGLEBERRY MOCK IT!!!!!!!
//	@Test
//	public void test_registerScientist_returnsTrue_givenValidScientist() {
//		// Arrange
//		ScientistRequest validScientist = new ScientistRequest("valid","valid","valid","valid","valid");
//		Scientist scientist = new Scientist(validScientist.getFirstName(),validScientist.getLastName(), validScientist.getEmail(), validScientist.getUsername(), validScientist.getPassword());
//		when(mockScientistDAO.findScientistByUsername(validScientist.getUsername())).thenReturn(null);
//		when(mockScientistDAO.findScientistByEmail(validScientist.getEmail())).thenReturn(null);
//		when(mockScientistDAO.create(scientist)).thenReturn(scientist);
//		
//		// Act
//		boolean actualResult = sut.registerNewScientist(validScientist);
//		
//		// Assert
//		assertNotNull(actualResult);
//		verify(mockScientistDAO, times(1)).create(scientist);
//	}
//
//	@Test
//	public void test_registerScientist_throwsInvalidRequestException_givenInvalidUser() {
//		assertThrows(InvalidRequestException.class, () -> sut.registerNewScientist(null));
//		
//	}
//	
//	@Test
//	public void test_registerScientist_throwsResourcePersistenceException_givenScientistWithTakenUsername() {
//		
//		// Arrange
//		ScientistRequest usernameTakenScientist = new ScientistRequest("valid","valid","valid","valid","valid");
//		Scientist scientist = new Scientist(usernameTakenScientist.getFirstName(),usernameTakenScientist.getLastName(), usernameTakenScientist.getEmail(), usernameTakenScientist.getUsername(), usernameTakenScientist.getPassword());
//		when(mockScientistDAO.findScientistByUsername(usernameTakenScientist.getUsername())).thenReturn(scientist);
//		when(mockScientistDAO.findScientistByEmail(usernameTakenScientist.getEmail())).thenReturn(null);
//		when(mockScientistDAO.create(scientist)).thenReturn(scientist);
//		
//		// Act
//		try {
//			assertThrows(ResourcePersistenceException.class, () -> sut.registerNewScientist(usernameTakenScientist));
//		} finally {
//			// Assert
//			verify(mockScientistDAO, times(0)).create(scientist);
//		}
//	}
//		
//		@Test
//		public void test_registerScientist_throwsResourcePersistenceException_givenScientistWithTakenEmail() {
//			
//			// Arrange
//			ScientistRequest emailTakenScientist = new ScientistRequest("valid","valid","valid","valid","valid");
//			Scientist scientist = new Scientist(emailTakenScientist.getFirstName(),emailTakenScientist.getLastName(), emailTakenScientist.getEmail(), emailTakenScientist.getUsername(), emailTakenScientist.getPassword());
//			when(mockScientistDAO.findScientistByUsername(emailTakenScientist.getUsername())).thenReturn(null);
//			when(mockScientistDAO.findScientistByEmail(emailTakenScientist.getEmail())).thenReturn(scientist);
//			when(mockScientistDAO.create(scientist)).thenReturn(scientist);
//			
//			// Act
//			try {
//				assertThrows(ResourcePersistenceException.class, () -> sut.registerNewScientist(emailTakenScientist));
//			} finally {
//				// Assert
//				verify(mockScientistDAO, times(0)).create(scientist);
//			}
//		
//		
//	}
}
