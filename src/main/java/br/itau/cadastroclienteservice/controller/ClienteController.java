package br.itau.cadastroclienteservice.controller;

import br.itau.cadastroclienteservice.exception.ApiClienteException;
import br.itau.cadastroclienteservice.exception.EndpointException;
import br.itau.cadastroclienteservice.model.Cliente;
import br.itau.cadastroclienteservice.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @RequestMapping(value = "/{cpfCliente}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable("cpfCliente") String cpfCliente) throws EndpointException {

        try {
            Cliente cliente = clienteService.buscarClientePorCpf(cpfCliente);

            return ResponseEntity.ok(cliente);
        } catch (ApiClienteException e) {
            logger.error("Erro: " + e.getMessage(), e);
            throw new EndpointException("Erro: " + e.getMessage());
        }
    }
}
