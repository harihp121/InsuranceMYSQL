package com.insurance.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.HealthPlans;
import com.insurance.repository.HealthPlansRepository;
@RestController
@RequestMapping(value="api/healthinsurance")
public class HealthPlansController {
	
	@Autowired
	HealthPlansRepository healthplans;

	String line="";
	String seperator=",";
	
//	 @PostMapping("/upload-csv-file")
//	    public String uploadCSVFile(@RequestParam("fileUpload") MultipartFile file, Model model) {
//
//	        // validate file
//	        if (file.isEmpty()) {
//	            model.addAttribute("message", "Please select a CSV file to upload.");
//	            model.addAttribute("status", false);
//	        } else {
//
//	            // parse CSV file to create a list of `User` objects
//	            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//
//	                // create csv bean reader
//	                CsvToBean<HealthPlans> csvToBean = new CsvToBeanBuilder(reader)
//	                        .withType(HealthPlans.class)
//	                        .withIgnoreLeadingWhiteSpace(true)
//	                        .build();
//
//	                // convert `CsvToBean` object to list of users
//	                List<HealthPlans> users = csvToBean.parse();
//
//	                
//
//	                // save users list on model
//	                model.addAttribute("users", users);
//	                model.addAttribute("status", true);
//
//	            } catch (Exception ex) {
//	                model.addAttribute("message", "An error occurred while processing the CSV file.");
//	                model.addAttribute("status", false);
//	            }
//	        }
//
//	        return "file-upload-status";
//	    }

	
	
	@RequestMapping("/importplans")
	public ResponseEntity<Object> savePlans() throws FileNotFoundException
	{
		
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\harip\\OneDrive\\Desktop\\Insurance CSV\\Plan_details.csv"));
		try {
			while((line=((BufferedReader) br).readLine())!=null){
					String[] data=line.split(seperator);
					HealthPlans plan= new HealthPlans();
					plan.setPlanId(data[0]);
					plan.setPlanName(data[1]);
					plan.setPlanType(data[2]);
					plan.setCoverAmount(data[3]);
					plan.setPremium(data[4]);
					plan.setSettlementRatio(data[5]);
					plan.setExistingIllness(data[6]);
					plan.setInsurerName(data[7]);
					plan.setPolicyPeriod(data[8]);
					healthplans.save(plan);
					
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	

//	@GetMapping("/getplans")
//	public ResponseEntity<List<HealthPlans>> findByTypeAndHealth(@RequestParam String planType, @RequestParam String existingIllness)
//	{
//		return new ResponseEntity<List<HealthPlans>>(healthplans.findByTypeAndHealth(planType,existingIllness),HttpStatus.ACCEPTED);
//	}
	
//@RequestMapping(value="/plans/{planType}",method=RequestMethod.POST)
//	
//	public ResponseEntity<HealthPlans> HealthPlansByPlanType(@PathVariable  String planType,@RequestBody Plan plan) {
///*	List<HealthPlans> HeatlhPlansByPlanType= healthplans.getHeatlhPlansByPlanType("Individual");
//			HeatlhPlansByPlanType.forEach(e->{
//			System.out.println(e);
//			});*/
//	        List list=healthplans.findAll();
//	        for(Object hp1:list)
//	        {
//	        	System.out.println(hp1.toString());
//	        }
//	        for(Object list1:list)
//	        {
//	        	 if(plan.getPlanType().equalsIgnoreCase(planType))
//	  	           {
//	  	            
//	        		 return new ResponseEntity<HealthPlans>(plan,HttpStatus.ACCEPTED);
//	  	           }      
//	        }
//	        
//	        return new ResponseEntity<HealthPlans>(HttpStatus.BAD_GATEWAY);
//	          
//	            if(hp.getPlanType().equalsIgnoreCase(planType))
//	           {
//	            
//	            return hp.getPlanName() + hp.getPlanId();
//	           }
//	       
		//	return new ResponseEntity<List<HealthPlans>>(planType,HttpStatus.ACCEPTED);	
			//return null;
	
	//}



@RequestMapping("/plantype/{planType}/existingillness/{existingIllness}")

public ResponseEntity<List<HealthPlans>> HealthPlansByPlanType(@PathVariable String planType,@PathVariable String existingIllness) {
//List<HealthPlans> HeatlhPlansByPlanType= healthplans.getHeatlhPlansByPlanType("Individual");
		//HeatlhPlansByPlanType.forEach(e->{
			//System.out.println(e);
		//});	
	System.out.println(planType);
	System.out.println(existingIllness);
		return new ResponseEntity<>(healthplans.getHealthPlansByPlanType(planType,existingIllness),HttpStatus.ACCEPTED);
}

/*@RequestMapping("/illness")
public ResponseEntity<List<HealthPlans>> HealthPlansByExistingIllness(@RequestBody String existingIllness) {
	//List<HealthPlans> HeatlhPlansByPlanType= healthplans.getHeatlhPlansByPlanType("Individual");
			//HeatlhPlansByPlanType.forEach(e->{
				//System.out.println(e);
			//});	
		System.out.println(existingIllness);
			return new ResponseEntity<List<HealthPlans>>(healthplans.getHealthPlansByExistingIllness(existingIllness),HttpStatus.ACCEPTED);
	}
*/
}
