package annotation.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HTTPreqmcontroller {
    
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String getUser() {
        return "User Details (GET)";
    }   
    
    @RequestMapping(value="/detailspost1", method=RequestMethod.POST)
    public String updateUser() {
        return "User Updated (POST)";
    }

    @RequestMapping(value = "/detailsdelete", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "User Deleted (DELETE)";
    }
}
