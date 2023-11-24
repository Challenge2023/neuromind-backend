package com.neuromind.neuromind.shared.api.services;

import com.google.gson.JsonArray;
import com.neuromind.neuromind.shared.api.types.ChatGptRequest;
import com.neuromind.neuromind.shared.api.types.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MedicalSupportService {
    private final WebClient webClient;

    @Autowired
    public MedicalSupportService(WebClient.Builder builder, @Value("${openai.api.key}") String apiKey) {
        this.webClient = builder
                .baseUrl("https://api.openai.com/v1/completions")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }
    public Mono<String> generateAnalysis(String records)  {
        ChatGptRequest request = makeSolicitation(records);
        Mono<ChatGptResponse> response = webClient.post().bodyValue(request).retrieve().bodyToMono(ChatGptResponse.class);
        return response.map(res -> res.choices().get(0).text());
    }
    private ChatGptRequest makeSolicitation(String records) {
        String question  = "A partir de agora você deve agir com um médico. Faça uma análise completa todo seguinte relatório médico do paciente orgnizado no formato JSON e responda as perguntas que vão ser feitas." + "\n" + "Esse é p relatório: " + records;
        return new ChatGptRequest("text-davinci-003", question, 0.3, 3000, 1.0, 0.0, 0.0);
    }
}
