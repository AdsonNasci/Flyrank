package com.AndreyApp.project.OrderItem;

public class OrderItemMapper {

    public static OrderItemModel map(OrderItemDTO orderItemDTO){
        OrderItemModel orderItemModel = new OrderItemModel();
        orderItemModel.setOrderId(orderItemDTO.getOrderId());
        orderItemModel.setProductId(orderItemDTO.getProductId());
        orderItemModel.setQuantity(orderItemDTO.getQuantity());

        return orderItemModel;
    }
    public OrderItemDTO map(OrderItemModel orderItemModel){
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setOrderId(orderItemModel.getOrderId());
        orderItemDTO.setProductId(orderItemModel.getProductId());
        orderItemDTO.setQuantity(orderItemModel.getQuantity());

        return orderItemDTO;
    }
}
