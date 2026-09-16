package com.campusai.model;

import java.util.List;

public class ChatResponse {
    private String answer;
    private String source;
    private List<String> suggestions;

    public ChatResponse(String answer, String source, List<String> suggestions) {
        this.answer = answer;
        this.source = source;
        this.suggestions = suggestions;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSource() {
        return source;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
}
