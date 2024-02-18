package com.example.msscolarite.Proxy;

import com.example.msscolarite.Model.Formation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-formation", url="localhost:8081")
public interface FormationProxy {
    //GET http://localhost:8081/formations/1

    @GetMapping("formations/{id}")
    public Formation getFormationById(@PathVariable("id") Long id);
}
