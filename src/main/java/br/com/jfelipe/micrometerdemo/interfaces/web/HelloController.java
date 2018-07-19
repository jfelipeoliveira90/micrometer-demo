package br.com.jfelipe.micrometerdemo.interfaces.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private MeterRegistry registry;

    private Counter helloCount;

    @PostConstruct
    public void init() {
        helloCount = Counter.builder("hello.count")
                            .description("Quantities of hello")
                            .tag("uri", "/hello")
                            .register(registry);
    }

    @GetMapping
    public ResponseEntity<String> hello(@RequestParam String name) {
        helloCount.increment();
        return ResponseEntity.ok("Hello " + name + "!!!");
    }
}
