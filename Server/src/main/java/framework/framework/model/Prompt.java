package framework.framework.model;

public class Prompt {

    private String id;

    private String promptId;

    private String promptText;

    private String promptDescription;

    public Prompt() {
    }

    public static Prompt prompt(String string) {
        return new Prompt(string);
    }

    public Prompt(String promptText) {
        this.promptText = promptText;
    }

    public Prompt(String id, String promptId, String promptText, String promptDescription) {
        this.id = id;
        this.promptId = promptId;
        this.promptText = promptText;
        this.promptDescription = promptDescription;
    }

    @Override
    public String toString() {
        return "Prompt{" +
                "id='" + id + '\'' +
                ", promptId='" + promptId + '\'' +
                ", promptText='" + promptText + '\'' +
                ", promptDescription='" + promptDescription + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPromptId() {
        return promptId;
    }

    public void setPromptId(String promptId) {
        this.promptId = promptId;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public String getPromptDescription() {
        return promptDescription;
    }

    public void setPromptDescription(String promptDescription) {
        this.promptDescription = promptDescription;
    }
}
