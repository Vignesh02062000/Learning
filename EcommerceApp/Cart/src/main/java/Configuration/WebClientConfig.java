package Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient productWebClient(WebClient.Builder builder,
                                      @Value("${product.service.url:http://localhost:8081}") String baseUrl) {
        return builder.baseUrl(baseUrl).build();
    }
}
