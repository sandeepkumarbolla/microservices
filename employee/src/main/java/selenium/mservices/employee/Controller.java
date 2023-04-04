package selenium.mservices.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    MongoRepository mongoRepository;
    Employee employee;
    @GetMapping("/sample")
    public List<Employee> sample(){
        return mongoRepository.findAll();
    }
    @PostMapping("/addEmployee")
    public String insert(@RequestBody Employee employee){
        mongoRepository.insert(employee);
        return "Employee added";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id){

    Optional<Employee> employee1=mongoRepository.findById(id);
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
