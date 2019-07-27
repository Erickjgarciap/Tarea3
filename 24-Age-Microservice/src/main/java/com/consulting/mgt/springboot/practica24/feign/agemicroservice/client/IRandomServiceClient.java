package com.consulting.mgt.springboot.practica24.feign.agemicroservice.client;

import java.util.Map;

// Agrega Feign Client
public interface IRandomServiceClient {

	// Agrega "/next" edpoint mediante Metodo GET.
	public Map<String, Object> next();
}
