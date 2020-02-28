package gui;

import domein.DomeinController;
import domein.Rekening;
import domein.ZichtRekening;
import domein.SpaarRekening;
import java.util.List;


public class RekeningApplicatie {
    /*
    
    private final DomeinController dc;

    public RekeningApplicatie(DomeinController dc) {
        this.dc = dc;
    }
    
    public void werkMetRekeningen(){
        
        List<Rekening> rekeningen = dc.geefRekeningen();
        
        for(Rekening rek : rekeningen){
	    if (rek instanceof SpaarRekening) {
                double intrest = SpaarRekening.getAangroeiIntrest();
                rek.stortOp((int) (rek.getSaldo() * intrest / 100));
            } else // rek is automatisch een ZichtRekening
            {
                ZichtRekening z = (ZichtRekening) rek;
                z.setMaxKredietOnderNul(z.getMaxKredietOnderNul()-10);
            }
            
            System.out.println(rek.geefCode());
            System.out.println(rek);
            
        }
    }

     */
}
