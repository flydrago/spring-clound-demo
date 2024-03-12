package hello;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    /**
     * 创建并配置一个支持负载平衡的WebClient.Builder实例。
     * 
     * @return WebClient.Builder 返回一个配置了负载平衡能力的WebClient.Builder实例。
     */
    @LoadBalanced
    @Bean
    public WebClient.Builder webClientBuilder() {
        // 创建WebClient.Builder实例
        return WebClient.builder();
    }

    /**
     * 使用负载均衡机制创建RestTemplate对象。
     *
     * @return 返回一个RestTemplate对象
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}