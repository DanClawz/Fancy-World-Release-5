public class Gioco {
    private String nomeGiocatore;
    private Giocatore giocatore;
    private Mondo m;
    private char input;

    public Gioco(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
        m = new Mondo("mondo1");
        this.giocatore = new Giocatore(nomeGiocatore);
        gioca();
    }

    private void gioca() {
        while(true) {
            System.out.println(m.stampaMappa());

            if (m.getMondo().get(m.getPianoCorrente()-1).isChiavePresente()) {
                System.out.println(m.getMondo().get(m.getPianoCorrente()-1).getChiave().getTipoChiave());
                if (MyUtil.controlledCharInput("Vuoi raccogliere la chiave? [s-n]", 's', 'n') == 's') {
                    System.out.println("Chiave raccolta!");
                    giocatore.aggiungiChiave(m.getMondo().get(m.getPianoCorrente()-1).getChiave());
                    m.getMondo().get(m.getPianoCorrente()-1).setChiave(null);
                }
                m.getMondo().get(m.getPianoCorrente()-1).setChiavePresente(false);
            }


            String in = MyUtil.stringInput("Dove vuoi muoverti? [n-s-e-w-u-d][q per uscire]: ");
            checkInput(in);


            if(input == 'n' || input == 's' || input == 'e' || input == 'w')
                m.getMondo().get(m.getPianoCorrente()-1).aggiornaMappa(input);
            else if (input == 'u' || input == 'd')
                m.cambioLuogo(input, giocatore.getChiavi());
            else if (input == 'q') System.exit(1);

            if (m.getMondo().get(m.getPianoCorrente()-1).isPassaggioRaggiunto())
                System.out.println("Il passaggio ti porta verso: luogo" + Passaggio.pianoDestPassaggio(m.getMondo().get(m.getPianoCorrente()-1).getLista_passaggi(), m.getMondo().get(m.getPianoCorrente()-1).getPosCorrente()));

            System.out.print("\n\n\n\n\n\n");

            if (m.obbiettivoRaggiunto()) {
                System.out.println(m.stampaMappa());
                System.out.println("Hai vinto!");
                break;
            }
        }
    }

    private void checkInput(String input) {
        if (input.length() != 0)
            this.input = input.charAt(0);
    }


}
