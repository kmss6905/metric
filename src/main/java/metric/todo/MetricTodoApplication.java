package metric.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MetricTodoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MetricTodoApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {return builder.build();}


  @RestController
  class HelloController {

    private final RestTemplate restTemplate;

    HelloController(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<String> getPosts(@PathVariable Long id) {
      String url = "https://jsonplaceholder.typicode.com/posts/{id}";
      return restTemplate.getForEntity(url, String.class, id);
    }
  }

}
