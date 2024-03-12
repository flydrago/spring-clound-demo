package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static hello.UserApplication.SAY_HELLO_ENDPOINT;


@RestController
public class UserAyncController {
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public UserAyncController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @RequestMapping("/async/hi")
    public Mono<String> hi(@RequestParam(value = "name", defaultValue = "Mary") String name) {
         // 使用webClientBuilder构建WebClient实例
        WebClient webClient = webClientBuilder.build();
        
        // 发起GET请求，并处理响应
        Mono<String> responseMono = webClient.get()
            .uri(SAY_HELLO_ENDPOINT + "/greeting") // 设置请求URI
            .retrieve() // 获取响应体
            .bodyToMono(String.class)
            .map(greeting -> String.format("%s, %s!", greeting, name));

        return responseMono;
    }

    @RequestMapping("/async/hello")
    public Mono<String> hello(@RequestParam(value = "name", defaultValue = "Mary") String name) {
         // 使用webClientBuilder构建WebClient实例
        WebClient webClient = webClientBuilder.build();
        
        // 发起GET请求，并处理响应
        Mono<String> responseMono = webClient.get()
            .uri(SAY_HELLO_ENDPOINT + "/greeting") // 设置请求URI
            .retrieve() // 获取响应体
            .bodyToMono(String.class)
            .map(greeting -> String.format("%s, %s!", greeting, name));

        return responseMono;
    }
}