import java.util.List;
class Питання {
    private String текстПитання;
    private String правильнаВідповідь;
    private List<String> варіантиВідповідей;
    public Питання(String текстПитання, String правильнаВідповідь, List<String> варіантиВідповідей) {
        this.текстПитання = текстПитання;
        this.правильнаВідповідь = правильнаВідповідь;
        this.варіантиВідповідей = варіантиВідповідей;
    }

    public Питання(String текстПитання, String правильнаВідповідь) {
        this.текстПитання = текстПитання;
        this.правильнаВідповідь = правильнаВідповідь;
    }

    public Питання(String текстПитання) {
        this.текстПитання = текстПитання;
    }

    public String getТекстПитання() {
        return текстПитання;
    }

    public String getПравильнаВідповідь() {
        return правильнаВідповідь;
    }

    public List<String> getВаріантиВідповідей() {
        return варіантиВідповідей;
    }

    public void add(Питання питання) {
        варіантиВідповідей.add(питання.getТекстПитання());
    }

    public boolean isCorrectAnswer(String вибранаВідповідь) {
        return вибранаВідповідь.contains(правильнаВідповідь);
    }
}