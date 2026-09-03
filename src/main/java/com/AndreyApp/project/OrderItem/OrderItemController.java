package com.AndreyApp.project.OrderItem;

import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderitem")
@ToString()
public class OrderItemController {
    OrderItemDTO orderItemDTO = new OrderItemDTO();

    public List<OrderItemDTO> getOrderItems(){
        return List.of(orderItemDTO);
    }

}
