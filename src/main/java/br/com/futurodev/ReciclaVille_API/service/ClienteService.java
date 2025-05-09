package br.com.futurodev.ReciclaVille_API.service;


import br.com.futurodev.ReciclaVille_API.model.entity.Cliente;
import br.com.futurodev.ReciclaVille_API.model.exceptions.ResourceNotFoundException;
import br.com.futurodev.ReciclaVille_API.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente create(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAllCliente(){
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(Long id){
        return clienteRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    public Cliente update(Long id, Cliente clienteUpd){
        Cliente cliente = findClienteById(id);

        /* Validar se codigo abaixo evita com que atualize tudo para Null se a edição for apenas de 1 atributo.
        if (clienteUpd.getNome() != null) {
            cliente.setNome(clienteUpd.getNome());
        }
        if (clienteUpd.getCNPJ() != null) {
            cliente.setCNPJ(clienteUpd.getCNPJ());
        }
        if (clienteUpd.getAtividadeEconomica() != null) {
            cliente.setAtividadeEconomica(clienteUpd.getAtividadeEconomica());
        }
        if (clienteUpd.getResponsavel() != null) {
            cliente.setResponsavel(clienteUpd.getResponsavel());
        }
         */
        cliente.setNome(clienteUpd.getNome());
        cliente.setCNPJ(clienteUpd.getCNPJ());
        cliente.setAtividadeEconomica(clienteUpd.getAtividadeEconomica());
        cliente.setResponsavel(clienteUpd.getResponsavel());
        return clienteRepository.save(cliente);
    }

    public void delete(Long id){
        Cliente cliente = findClienteById(id);
        clienteRepository.delete(cliente);
    }
}
