package org.upskill.ProjectJavaC.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.ProjectJavaC.Exceptions.VeiculoNotFoundException;
import org.upskill.ProjectJavaC.models.Veiculo;
import org.upskill.ProjectJavaC.models.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service

public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        try {

            Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
            return veiculoSalvo;
        } catch (Exception e) {

            throw new RuntimeException("Erro ao salvar o veículo", e);
        }
    }

    public Veiculo obterVeiculoPorId(Long id) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        return (Veiculo) ((Optional<?>) veiculoOptional).orElseThrow(() -> new VeiculoNotFoundException("Veículo não encontrado com ID: " + id));
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public void deletarVeiculo(Long id) {
        try {
            veiculoRepository.deleteById(id);
        } catch (Exception e) {
            // Tratamento de exceção ou logging
            throw new RuntimeException("Erro ao deletar o veículo com ID: " + id, e);
        }
    }
}
