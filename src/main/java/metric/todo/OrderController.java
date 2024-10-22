package metric.todo;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderRepository orderRepository;

  public OrderController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @GetMapping("/{id}")
  public Order getOrder(@PathVariable Long id) {
    return orderRepository.findById(id).orElseThrow(
        () -> new IllegalArgumentException("Invalid Id : %d".formatted(id))
    );
  }
}
