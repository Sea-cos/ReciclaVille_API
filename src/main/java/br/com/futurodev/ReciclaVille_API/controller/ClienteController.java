package br.com.futurodev.ReciclaVille_API.controller;

import br.com.futurodev.ReciclaVille_API.model.dtos.clienteDTO.ClienteRequest;
import br.com.futurodev.ReciclaVille_API.model.dtos.clienteDTO.ClienteResponse;
import br.com.futurodev.ReciclaVille_API.model.entity.Cliente;
import br.com.futurodev.ReciclaVille_API.service.ClienteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> list(){
        List<ClienteResponse> clientes = this.clienteService.findAllCliente().stream()
                .map(cliente -> modelMapper.map(cliente, ClienteResponse.class)).collect(Collectors.toList());
        return clientes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getById(@PathVariable Long id){
        Cliente cliente = clienteService.findClienteById(id);
        if (cliente == null ){
            return ResponseEntity.notFound().build();
        }
        ClienteResponse response = modelMapper.map(cliente, ClienteResponse.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> create(@RequestBody @Valid ClienteRequest clienteDTO) throws Exception{
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente newCliente = clienteService.create(cliente);
        ClienteResponse newClienteDTO = modelMapper.map(newCliente, ClienteResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Long id, @RequestBody ClienteRequest clienteDTO) throws Exception{
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente newCliente = clienteService.update(id, cliente);
        ClienteResponse newClienteDTO = modelMapper.map(newCliente, ClienteResponse.class);
        return ResponseEntity.ok(newClienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.clienteService.delete(id);
        return ResponseEntity.ok("Cliente removido com sucesso!");
    }


}
