package br.itau.cadastroclienteservice.service;

import br.itau.cadastroclienteservice.exception.ApiClienteException;
import br.itau.cadastroclienteservice.model.Cliente;
import br.itau.cadastroclienteservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente buscarClientePorCpf(String cpfCliente) throws ApiClienteException {
        Cliente cliente = clienteRepository.findByCpf(cpfCliente)
                .orElseThrow(() -> new ApiClienteException("Cliente não encontrado a partir dos dados informados."));

        return cliente;
    }
}
