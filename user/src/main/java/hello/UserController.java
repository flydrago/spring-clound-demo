package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import static hello.UserApplication.SAY_HELLO_ENDPOINT;

@RestController
public class UserController {

    private final RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/root", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        String greeting = restTemplate.getForObject(SAY_HELLO_ENDPOINT + "/", String.class);

        return String.format("Hi1 %s, %s!", greeting, str);
    }

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "Mary") String name) {
        String greeting = restTemplate.getForObject(SAY_HELLO_ENDPOINT + "/greeting", String.class);

        return String.format("Hi %s, %s!", greeting, name);
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "John") String name) {
        String greeting = restTemplate.getForObject(SAY_HELLO_ENDPOINT + "/greeting", String.class);

        return String.format("Hello %s, %s!", greeting, name);
    }
}