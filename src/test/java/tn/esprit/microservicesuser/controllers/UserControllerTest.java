//package tn.esprit.microservicesuser.controllers;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import tn.esprit.microservicesuser.entities.UserEntity;
//import tn.esprit.microservicesuser.services.UserServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//class UserControllerTest {
//    private MockMvc mockMvc;
//
//    @Mock
//    private UserServiceImpl userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    private List<UserEntity> userList;
//
//    @BeforeEach
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//        userList = new ArrayList<>();
//        userList.add(new UserEntity(1L, "Ahmed", "Bahri", "09628440", "Ahmed-Bahri-09628440", "ahmed.bahri.g@gmail.com", "password"));
//        userList.add(new UserEntity(2L, "Bahri", "Ahmed", "9628440", "Ahmed-Bahri-09628440", "bahri.ahmed@esprit.tn", "password"));
//    }
//
//    @Test
//    public void testGetAllUsers() throws Exception {
//        when(userService.getAllUsers()).thenReturn(userList);
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/list").accept(MediaType.APPLICATION_JSON))
//                .andReturn();
//        String expectedJson = new ObjectMapper().writeValueAsString(userList);
//        String actualJson = result.getResponse().getContentAsString();
//        assertEquals(expectedJson, actualJson);
//    }
//
//    @Test
//    public void testGetUserById() throws Exception {
//        UserEntity user = new UserEntity(1L, "Ahmed", "Bahri", "09628440", "Ahmed-Bahri-09628440", "ahmed.bahri.g@gmail.com", "password");
//        when(userService.getUserById(any(Long.class))).thenReturn(user);
//        MvcResult result = mockMvc
//                .perform(MockMvcRequestBuilders.get("/users/list/1").accept(MediaType.APPLICATION_JSON)).andReturn();
//        String expectedJson = new ObjectMapper().writeValueAsString(user);
//        String actualJson = result.getResponse().getContentAsString();
//        assertEquals(expectedJson, actualJson);
//    }
//
//
//    @Test
//    public void testCreateUser() throws Exception {
//        UserEntity user = new UserEntity(1L, "Ahmed", "Bahri", "09628440", "Ahmed-Bahri-09628440", "ahmed.bahri.g@gmail.com", "password");
//        when(userService.createUser(any(UserEntity.class))).thenReturn(user);
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/list/create")
//                        .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user)))
//                .andReturn();
//        String expectedJson = new ObjectMapper().writeValueAsString(user);
//        String actualJson = result.getResponse().getContentAsString();
//        assertEquals(expectedJson, actualJson);
//    }
//
//    @Test
//    void testUpdateUser() {
//      //TODO
//    }
//
//    @Test
//    void testDeleteUser() {
//        // Arrange
//        Long id = 1L;
//
//        // Act
//        userController.deleteUser(id);
//
//        // Assert
//        verify(userService).deleteUser(id);
//    }
//
//}