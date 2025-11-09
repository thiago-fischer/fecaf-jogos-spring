package br.com.fecaf.controller;

import br.com.fecaf.model.Jogo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("api/v1/jogos")
public class JogoController {

    private List<Jogo> jogos;
    private final String arquivoJson = "src/main/java/br/com/fecaf/database/jogos.json";

    @PostConstruct
    private void carregarJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream arquivo = new FileInputStream(arquivoJson);
            this.jogos =  mapper.readValue(arquivo, new TypeReference<List<Jogo>>() {});
        } catch (Exception e) {
            System.out.println("Erro ao carregar JSON: " + e.getMessage());
            this.jogos = new ArrayList<>();
        }
    }

    private void salvarJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File arquivoSaida = new File(arquivoJson);
            jogos.sort(Comparator.comparingInt(Jogo::getId));
            mapper.writerWithDefaultPrettyPrinter().writeValue(arquivoSaida, this.jogos);
        } catch (Exception e) {
            System.out.println("Erro ao salvar JSON: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Jogo> listarTodos() {
        return this.jogos;
    }

    @GetMapping("{id}")
    public ResponseEntity<Jogo> procurarJogo(@PathVariable("id") int id) {
        for(Jogo jogo : this.jogos) {
            if(jogo.getId() == id) {
                return ResponseEntity.ok(jogo);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Jogo> adicionarJogo(@RequestBody Jogo novoJogo) {

        int maiorId = jogos.stream()
                .mapToInt(Jogo::getId)
                .max()
                .orElse(0);

        novoJogo.setId(maiorId + 1);
        this.jogos.add(novoJogo);
        this.salvarJson();
        return ResponseEntity.ok(novoJogo);

    }

    @PutMapping
    public ResponseEntity<Jogo> editarJogo(@RequestBody Jogo atualizarJogo) {
        if(this.jogos.removeIf(jogo -> jogo.getId() == atualizarJogo.getId())) {
            this.jogos.add(atualizarJogo);
            this.salvarJson();
            return ResponseEntity.ok(atualizarJogo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarJogo(@PathVariable("id") int id){

        if(this.jogos.removeIf(jogo -> jogo.getId() == id)) {
            this.salvarJson();
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
