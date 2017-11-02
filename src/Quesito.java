public class Quesito {
    private String domanda;
    private String risposta;
    private String[] opzioni;

    public Quesito(String domanda, String[] opzioni, String risposta) {
        this.domanda = domanda;
        this.opzioni = opzioni;
        this.risposta = risposta;
    }

    public Quesito(String domanda, String risposta) {
        this.domanda = domanda;
        this.risposta = risposta;
    }

    public Quesito(String risposta) {
        this.risposta = risposta;
    }

    @Override
    public String toString() {
        return domanda + "\n" + opzioni[0] + "\n" + opzioni[1] + "\n" + opzioni[2] + "\n" + risposta + "\n";
    }

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public String[] getOpzioni() {
        return opzioni;
    }

    public void setOpzioni(String[] opzioni) {
        this.opzioni = opzioni;
    }
}
