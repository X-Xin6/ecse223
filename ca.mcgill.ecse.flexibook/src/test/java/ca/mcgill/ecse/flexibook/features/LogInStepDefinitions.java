package ca.mcgill.ecse.flexibook.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Map;

import org.junit.After;

import ca.mcgill.ecse.flexibook.Controller.FlexibookController;
import ca.mcgill.ecse.flexibook.Controller.InvalidInputException;
import ca.mcgill.ecse.flexibook.application.FlexiBookApplication;
import ca.mcgill.ecse.flexibook.model.Customer;
import ca.mcgill.ecse.flexibook.model.FlexiBook;
import ca.mcgill.ecse.flexibook.model.Service;
import ca.mcgill.ecse.flexibook.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInStepDefinitions {
	private FlexiBook flexibook=FlexiBookApplication.getflexibook();

	  
	@Given("the following customers exist in the system:")
	public void the_following_customers_exist_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		  List<Map<String, String>> valueMaps = dataTable.asMaps();
		    for (Map<String, String> map : valueMaps) {
		     String name = map.get("username");
		     String passcode = map.get("password");
		    Customer customer=new Customer(name, passcode, flexibook);
		    flexibook.addCustomer(customer);
		    }
		    
		    }
	@When("the user tries to log in with username {string} and password {string}")
	public void the_user_tries_to_log_in_with_username_and_password(String string, String string2) throws InvalidInputException {
	   FlexibookController.AttemptLogIn(string, string2, flexibook);
	}
	@Then("the user should be successfully logged in")
	public void the_user_should_be_successfully_logged_in() {
	    assertEquals(FlexiBookApplication.getCurrentuser(),flexibook.getCustomer(0));
	}
	@Then("a new account shall be created")
	public void a_new_account_shall_be_created() {
	    assertTrue(flexibook.getOwner()!=null);
	}


	@Then("the user shall be successfully logged in")
	public void the_user_shall_be_successfully_logged_in() {
	    assertEquals(FlexiBookApplication.getCurrentuser(),flexibook.getOwner());

	}
	@After
	public void tearDown() {
	   flexibook=FlexiBookApplication.getflexibook();
	    flexibook.delete();
	}

	}

