package org.upskill.ProjectJavaC.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.ProjectJavaC.Exceptions.VeiculoNotFoundException;
import org.upskill.ProjectJavaC.models.*;

import java.util.List;
import java.util.Optional;

@Service

public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo, Long brandId , Long modelId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com ID: " + brandId));

        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com ID: " + modelId));

        veiculo.setBrand(brand);
        veiculo.setModel(model);
        return veiculoRepository.save(veiculo);



    }

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

            throw new RuntimeException("Erro ao deletar o veículo com ID: " + id, e);
        }
    }
}
