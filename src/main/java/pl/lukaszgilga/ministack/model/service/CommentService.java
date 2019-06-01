package pl.lukaszgilga.ministack.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lukaszgilga.ministack.model.repository.CommentRepository;

public class CommentService {
    @Autowired
    SessionService sessionService;
    @Autowired
    CommentRepository commentRepository;


}
