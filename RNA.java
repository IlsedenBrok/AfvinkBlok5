package pkg5.pkg1;

public class RNA extends Sequentie {

    @Override
    public void setSequentie(String ntSeq) {
        if (ntSeq.matches("[AUGC]+")) {
            this.ntSeq = ntSeq;
        } else {
            System.out.println("Er zit een niet RNA nucleotide in de sequentie: "+ntSeq);
        }
    }
}
