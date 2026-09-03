package com.AndreyApp.project.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO {

    private Long orderId;
    private Long productId;
    private Integer quantity;
}
