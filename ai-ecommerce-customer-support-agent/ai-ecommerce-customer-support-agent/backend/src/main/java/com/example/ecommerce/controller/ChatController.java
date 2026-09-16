package com.example.ecommerce.controller;
import com.example.ecommerce.model.*;
import com.example.ecommerce.service.SupportAgentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins="*")
public class ChatController {
 private final SupportAgentService service;
 public ChatController(SupportAgentService service){this.service=service;}
 @PostMapping public ChatResponse chat(@Valid @RequestBody ChatRequest request){return service.answer(request.message());}
}
