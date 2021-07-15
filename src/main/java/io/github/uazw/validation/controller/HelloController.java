package io.github.uazw.validation.controller;

import io.github.uazw.validation.controller.request.NameAndAge;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("hello")
@Validated
public class HelloController {

    @PostMapping
    public NameAndAge Hello(@Valid @RequestBody NameAndAge nameAndAge) {
        return nameAndAge;
    }
}
