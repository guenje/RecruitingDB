package com.Recruiting.springboot.Recruiting.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Recruiting.springboot.Recruiting.model.User;
import com.Recruiting.springboot.Recruiting.repository.UserRepository;



@RestController
public class WebController {
    @Autowired
    UserRepository repository;

      
    @RequestMapping("/save")
    public String process(){
        repository.save(new User("Schmitt", "Tim", "Schmitttim@web.de"));
        repository.save(new User("Günsche", "John", "J.Günsche@googlemail.com"));
        repository.save(new User("Müller", "Ezra", "EMuller@web.de"));
        repository.save(new User("Meyer", "Tina", "FamilieMüller@web.de"));
        repository.save(new User("Hoffmann", "David", "DonDavid@mail.com"));
        repository.save(new User("Oberberger", "Maurice", "MauriceO@t-online.de"));
        return "Done";
    }
    
    public String namenew;
    public String vornamenew;
    public String emailnew;
    
    
    @RequestMapping("/new")
    public String processnew() {
    	System.out.println("Wir legen nun einen neuen Eintrag in der RecruteDB an.");
    	System.out.println("Bitte geben sie den Namen an:");
    	Scanner scanner = new Scanner(System.in);
		String namenew = scanner.nextLine();
		System.out.println("Bitte geben sie den Vornamen an:");
		String vornamenew = scanner.nextLine();
		System.out.println("Bitte geben sie die zugehörige Emailadresse ein:");
		String emailnew = scanner.nextLine();
		repository.save(new User(namenew, vornamenew, emailnew));
		scanner.close();
    	return "Neuer Eintrag (" + namenew + ", " + vornamenew + ", " + emailnew + ") wurde hinzugefügt!";
    }
    
    @RequestMapping("/findAll")
    public String findAll(){
        String result = "";
          
        for(User cust : repository.findAll()){
            result += "" + cust.toString() + "";
        }
          
        return "" + result + "";
    }
    
        
    @RequestMapping("/findbyVorname")
    public String findByVorname(@RequestParam("vorname") String vorname){
        String result = "";
          
        for(User cust: repository.findByVorname(vorname)){
            result += "" + cust.toString() + ""; 
        }
          
        return result + "";
    }
}