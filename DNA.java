package pkg5.pkg1;

public class DNA extends Sequentie {

    //public void setDNA(int counterDNA) {
    //    this.counterDNA = counterDNA;
    //}

    public int getCount() {
        System.out.println(counterDNA);
        return counterDNA;
    }

    @Override
    public void setSequentie(String ntSeq) {
        if (ntSeq.matches("[ATGC]+")) {
            this.ntSeq = ntSeq;
            counterDNA++;
            
        } else {
            System.out.println("Er zit een niet DNA nucleotide in de sequentie: " + ntSeq);
        }
    }
}