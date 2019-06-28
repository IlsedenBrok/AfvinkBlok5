package pkg5.pkg1;

public class Test {
    
    public static void main(String args[]) {
        DNA dna1 = new DNA();
        dna1.setSequentie("AUG");
        RNA rna1 = new RNA();
        rna1.setSequentie("ATG");
        
        DNA dna2 = new DNA();
        dna2.setSequentie("ATGCTACG");
        RNA rna2 = new RNA();
        rna2.setSequentie("UAGCUGAUCGA");
        
        DNA dna3 = new DNA();
        dna3.setSequentie("TGATCTCTCAGTCTGACTAC");

        dna1.getCount();
        dna2.getCount();
        dna3.getCount();
        //System.out.println(counterDNA);

    }
   }

