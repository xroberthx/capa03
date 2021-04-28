package com.paramonga.capacitacion.controller;

import com.paramonga.capacitacion.domain.DateUtils;
import com.paramonga.capacitacion.domain.Ejemplo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/welcomeRest")
public class WelcomeRest {

    @GetMapping(value = "/devuelveEjemplo", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ejemplo> devuelveEjemplo(){
        Ejemplo ejemplo;
        ejemplo = new Ejemplo();
        ejemplo.setApellidos("Perez");
        ejemplo.setNombres("Juan");
        ejemplo.setDireccion("Los Pinos 173");
        return Optional.ofNullable(ejemplo).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/devuelveEjemplo01/{ejemplo1}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ejemplo> devuelveEjemplo01(@PathVariable String ejemplo1){
        Ejemplo ejemplo;
        ejemplo = new Ejemplo();
        ejemplo.setApellidos("Perez");
        ejemplo.setNombres("Juan " + ejemplo1);
        ejemplo.setDireccion("Los Pinos 173");
        return Optional.ofNullable(ejemplo).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/devuelveEjemploPost", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ejemplo> devuelveEjemplo(@RequestBody Ejemplo ejemplo){
        ejemplo.setApellidos(ejemplo.getApellidos() + " FINAL");
        ejemplo.setApellidosNombres(ejemplo.getApellidos() + " , " + ejemplo.getNombres());
        return Optional.ofNullable(ejemplo).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/devuelveFechaActual", produces = APPLICATION_JSON_VALUE)
    public String devuelveFechaActual(){
        Date fechaActual = DateUtils.obtenerFechaActual();
        String result = DateUtils.convertDateToString(fechaActual);
        return result;
    }

}
