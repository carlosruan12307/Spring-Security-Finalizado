package com.security.security.Run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.security.security.enums.RoleEnum;
import com.security.security.models.RoleModel;
import com.security.security.repository.RoleRepository;

@Component
public class AppStartRun implements ApplicationRunner {
    @Autowired
    private RoleRepository rr;

    
    @Override
    public void run(ApplicationArguments args) throws Exception {
      
		for(RoleEnum ro: RoleEnum.values()){
            if(rr.findBynome(ro).isEmpty()){
                RoleModel rom = new RoleModel(ro);
                rr.save(rom);

            }
    
				
			
	
		  }
        
    }
    
}
