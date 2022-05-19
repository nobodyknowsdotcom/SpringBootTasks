package com.example.demo.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.Map;

@Timed(value = "api.time", description = "Total controllers uptime")
@Controller
public class MyController {
    private final Counter counter;

    public MyController(MeterRegistry registry) {
        this.counter = registry.counter("api.usage.counter");
    }

    @GetMapping("/headers")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        var headersList= new ArrayList<String>();
        headers.forEach((key, value) -> headersList.add(String.format("Header '%s' = %s", key, value)));
        counter.increment();
        return new ResponseEntity<>(String.join("\n", headersList), HttpStatus.OK);
    }
}
