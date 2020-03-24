package domein;

import java.util.*;
import persistentie.*;

public class RekeningRepository
{
    private final RekeningMapper rm;
    private final List<Rekening> deRekeningen;

    public RekeningRepository()
    {
        rm = new RekeningMapper();
        deRekeningen = rm.geefRekeningen();
    }
    
    public List<Rekening> getRekeningen()
    {
        return deRekeningen;
    }
}







