package riwi.demo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
title = "API para administrar Encuestas Riwi",
version ="1.0",
description = "Documentacion Api de Encuestas Filtro Riwi"))
public class OpenApiConfig {
    
}