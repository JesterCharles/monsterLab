package com.revature.monster_lab.web.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.AuthorizationException;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.services.ScientistService;
import com.revature.monster_lab.web.dto.ScientistRequest;
import com.revature.monster_lab.web.dto.UpdateScienitstRequest;

@RestController
@RequestMapping("/scientists")
public class ScientistServlet {
	
	private final ScientistService scientistService;
	
	@Autowired
	public ScientistServlet(ScientistService scientistService) {
		this.scientistService = scientistService;
	}
	
	@GetMapping("/username")
	public ResponseEntity<Void> checkUsername(@RequestParam String username){
		return scientistService.isUsernameAvailable(username) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@GetMapping("/email")
	public ResponseEntity<Void> checkEmail(@RequestParam String email){
		return scientistService.isEmailAvailable(email) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createScientist(@RequestBody @Valid ScientistRequest scientistRequest) {
		scientistService.registerNewScientist(scientistRequest);
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateUserInfo(@RequestBody UpdateScienitstRequest editUserRequest, HttpServletRequest req) {

        HttpSession session = req.getSession(false);
        if (session == null) {
            throw new AuthenticationException("No session found.");
        }

        Scientist requestingUser = (Scientist) session.getAttribute("authUser");

        boolean requesterEditSelf = requestingUser.getScientistId().equals(editUserRequest.getId());

        if (!requesterEditSelf) {
            throw new AuthorizationException("Forbidden request made.");
        }

        scientistService.updateScientist(editUserRequest);

    }
	
}
