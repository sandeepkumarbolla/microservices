package selenium.mservices.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    MongoRepository mongoRepository;
    Employee employee;

    //GETMAPPING Starts HERE
    @GetMapping("/sample")
    public List<Employee> sample(){
        return mongoRepository.findAll();
    }


    //GETMAPPING Starts HERE
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmp(@PathVariable int id){

            return mongoRepository.findById(id);
    }


    //POSTMAPPING Starts HERE
    @PostMapping("/addEmployee")
    public String insert(@RequestBody Employee employee){
        mongoRepository.insert(employee);
        return "Employee added";
    }


    //DELETEMAPPING Starts HERE
    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id){

    Optional<Employee> employee1=mongoRepository.findById(id);
    ArrayList<Employee> foo;
        try{
            System.out.println(employee1.get().empName);
            System.out.println("exists");
            mongoRepository.deleteById(id);
        }
        catch(Exception x) {
            System.out.println(x);
            System.out.println(x.getMessage());
        }
        return "Employee with {id} deleted successfully";
    }
}
