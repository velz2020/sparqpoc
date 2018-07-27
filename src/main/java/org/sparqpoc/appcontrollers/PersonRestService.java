package org.sparqpoc.appcontrollers;

import java.util.List;

import org.sparqpoc.appmodel.AnswerMaster;
import org.sparqpoc.appmodel.Document;
import org.sparqpoc.appmodel.LoanApplicantDetails;
import org.sparqpoc.appmodel.LoanCatagory;
import org.sparqpoc.appmodel.LoanMaster;
import org.sparqpoc.appmodel.QuestionMaster;
import org.sparqpoc.appservice.AnswerMasterService;
import org.sparqpoc.appservice.AppUserService;
import org.sparqpoc.appservice.DocumentService;
import org.sparqpoc.appservice.LoanApplicantDetailsService;
import org.sparqpoc.appservice.LoanService;
import org.sparqpoc.appservice.QuestionMasterService;
import org.sparqpoc.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
//@CrossOrigin()
public class PersonRestService {
	
	@Autowired
	AppUserService appUserService;
	@Autowired
	LoanService loanService;
	@Autowired
	QuestionMasterService questionMasterService;
	@Autowired
	AnswerMasterService answerMasterService;
	@Autowired
	LoanApplicantDetailsService loanApplicantDetailsService; 
	@Autowired
	DocumentService documentService;
	
//    private static final List<Person> persons;
//
//    static {
//        persons = new ArrayList<>();
//        persons.add(new Person("Hello", "World"));
//        persons.add(new Person("Foo", "Bar"));
//    }
//
//    @RequestMapping(path = "/persons", method = RequestMethod.GET)
//    public static List<Person> getPersons() {
//        return persons;
//    }
//
//    @RequestMapping(path = "/persons/{name}", method = RequestMethod.GET)
//    public static Person getPerson(@PathVariable("name") String name) {
//        return persons.stream()
//                .filter(person -> name.equalsIgnoreCase(person.getName()))
//                .findAny().orElse(null);
//    }
    
    @RequestMapping(path = "/register/user", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public User registerNewUser(@RequestBody User user,Model model)
    {
    	
    	return appUserService.registerNewUser(user);
    	
    }
    
      
    @RequestMapping(path = "/common/applynewloan1", method = RequestMethod.POST)
    public List<LoanMaster> applyNewLoan1(@RequestBody List<LoanMaster> loans, UriComponentsBuilder ucBuilder)
    {
    	System .out.println("***URL MAPPING CALLED*******");
    	List<LoanMaster> toReturn = loanService.saveNewLoanDetails1(loans);
    	System .out.println("***URL MAPPING CALLED*******");
    	//System.exit(0);
    	return toReturn;
    
    }
    
    @RequestMapping(path = "/common/applynewloan2", method = RequestMethod.POST)
    public List<LoanMaster> applyNewLoan2(@RequestBody List<LoanMaster> loans, UriComponentsBuilder ucBuilder)
    {
    	System .out.println("***URL MAPPING CALLED*******");
    	List<LoanMaster> toReturn = loanService.saveNewLoanDetails2(loans);
    	System .out.println("***URL MAPPING CALLED*******");
    	//System.exit(0);
    	return toReturn;
    
    }
    
        
    @RequestMapping(path = "/common/getallloans", method = RequestMethod.GET)
    public List<LoanMaster> getAllLoanDetails()
    {
    	return loanService.retriveAllLoans(); 
    
    }
    
    @RequestMapping(path = "/common/getallloan/{loanid}", method = RequestMethod.GET)
    public LoanMaster getAllLoanDetailByLoanid(@PathVariable("loanid") long loanid)
    {
    	return loanService.retriveAllLoanByLoanId(loanid); 
    
    }
    
    @RequestMapping(path = "/common/getallapplicants/{loanid}", method = RequestMethod.GET)
    public List<LoanApplicantDetails> retriveAllApplicantDetils(@PathVariable("loanid") LoanMaster loanid)
    {
    	return loanApplicantDetailsService.retriveAllApplicantDetails(loanid); 
    
    }
    
    
    @RequestMapping(path = "/common/getallapplicants", method = RequestMethod.GET)
    public List<LoanApplicantDetails> retriveAllApplicantDetils()
    {
    	return loanApplicantDetailsService.retriveAllApplicantDetails(); 
    
    }
    
    @RequestMapping(path = "/common/getapplicant/{applicantid}", method = RequestMethod.GET)
    public LoanApplicantDetails getApplicantDetilsByApplicantId(@PathVariable("applicantid") long applicantid)
    {
    	return loanApplicantDetailsService.getApplicantDetilsByApplicantId(applicantid); 
    
    }
    
    @RequestMapping(path = "/getapplicant/{firstname}", method = RequestMethod.GET)
    public LoanApplicantDetails getApplicantDetailsByFirstname(@PathVariable("firstname") String firstname)
    {
    	return loanApplicantDetailsService.getApplicantDetailsByFirstname(firstname); 
    
    }
    
    
    @RequestMapping(path = "/addquestions", method = RequestMethod.POST)
    public List<QuestionMaster> saveNewQuestions(@RequestBody List<QuestionMaster> listofquestions,UriComponentsBuilder ucBuilder)
    {
    	
    	return questionMasterService.saveListOfQuestions(listofquestions);
    
    }
    
    @RequestMapping(path = "/common/getquestions/{questioncatagory}", method = RequestMethod.GET)
    public List<QuestionMaster> getQuestionsByLoanCatagory(@PathVariable LoanCatagory questioncatagory,UriComponentsBuilder ucBuilder)
    {
    	
    	return questionMasterService.getQuestionByLoanCatagory(questioncatagory);
    
    }
    
    
    @RequestMapping(path = "common/saveanswers", method = RequestMethod.POST)
    public List<AnswerMaster>saveAnswers(@RequestBody List<AnswerMaster> listofanswers,UriComponentsBuilder ucBuilder)
    {
    	
    	return answerMasterService.saveListOfAnswers(listofanswers);
    
    }
    
    @RequestMapping(path = "common/getanswersbyapplicant/{applicantid}", method = RequestMethod.GET)
    public List<AnswerMaster>getAnswersByApplicantId(@PathVariable LoanApplicantDetails applicantid,UriComponentsBuilder ucBuilder)
    {
    	
    	return answerMasterService.getAnswersByApplicantId(applicantid);
    
    }
    
    @RequestMapping(path = "common/getanswersbyloan/{loanid}", method = RequestMethod.GET)
    public List<AnswerMaster>getAnswersByLoanId(@PathVariable LoanMaster loanid,UriComponentsBuilder ucBuilder)
    {
    	
    	return answerMasterService.getAnswersByLoanId(loanid);
    
    }
    
    @RequestMapping(path = "common/saveapplicantdocuments", method = RequestMethod.POST)
    public List<Document> saveApplicantDocuments(@RequestBody List<Document> documnets,UriComponentsBuilder ucBuilder)
    {
    	
    	return documentService.saveDocuments(documnets);
    
    }
    
    @RequestMapping(path = "common/getwelcomemsg", method = RequestMethod.GET)
    public String getWelcomeMsg()
    {
    	
    	return "Hi Welcome to SPARQ POC Demo App";
    
    }
    
    
    
    
    
    
}
