package com.example.ecommerce.service;
import com.example.ecommerce.model.ChatResponse;
import org.springframework.stereotype.Service;
@Service
public class SupportAgentService {
 public ChatResponse answer(String message){
  String t=message.toLowerCase();
  if(t.contains("track")||t.contains("order status")||t.contains("where is my order"))
   return new ChatResponse("You can check your order status from the Orders section. Keep your order ID ready for tracking.","ORDER_TRACKING");
  if(t.contains("return")||t.contains("replace")||t.contains("exchange"))
   return new ChatResponse("Eligible products can be returned or replaced within 7 days of delivery. Keep the item, packaging and invoice ready.","RETURNS");
  if(t.contains("refund")||t.contains("money back")||t.contains("cancel"))
   return new ChatResponse("After an approved cancellation or return, the refund is initiated to the original payment method. Bank processing time may vary.","REFUNDS");
  if(t.contains("delivery")||t.contains("shipping")||t.contains("arrive"))
   return new ChatResponse("Standard delivery usually takes 3–7 working days, depending on location and product availability.","DELIVERY");
  if(t.contains("phone")||t.contains("headphone")||t.contains("backpack")||t.contains("watch")||t.contains("product"))
   return new ChatResponse("You can explore phones, headphones, backpacks and watches in the product catalogue.","PRODUCT_INFORMATION");
  if(t.contains("hello")||t.contains("hi")||t.contains("hey"))
   return new ChatResponse("Hello! Ask me about products, delivery, returns, refunds or order tracking.","GREETING");
  return new ChatResponse("I can help with products, order tracking, delivery, returns and refunds. Please explain your question in more detail.","GENERAL_SUPPORT");
 }
}
