package br.com.futurodev.ReciclaVille_API.config;
import br.com.futurodev.ReciclaVille_API.model.dtos.declaracaoDTO.DeclaracaoRequest;
import br.com.futurodev.ReciclaVille_API.model.entity.Declaracao;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Desabilita mapeamento automático para evitar conflitos ambíguos
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setAmbiguityIgnored(true); // <-- ESSENCIAL

        // Criação explícita do TypeMap
        TypeMap<DeclaracaoRequest, Declaracao> typeMap =
                modelMapper.createTypeMap(DeclaracaoRequest.class, Declaracao.class);

        // Ignora o campo ambíguo
        typeMap.addMappings(mapper -> mapper.skip(Declaracao::setDataDeclaracao));

        return modelMapper;
    }
}
