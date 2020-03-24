package domein;

import java.math.BigDecimal;

public class TipCalculator
{
    private BigDecimal amount;

    public TipCalculator()
    {
        this (new BigDecimal(0));
    }

    public TipCalculator(BigDecimal amount)
    {
        setAmount(amount);
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public final void setAmount(BigDecimal amount)
    {
        if(amount.doubleValue() < 0)
            throw new IllegalArgumentException
                ("Geen negatief bedrag toegelaten!");
        this.amount = amount; 
    }
    
    public BigDecimal calculateTip(BigDecimal percentage)
    {
        return amount.multiply(percentage);
    }
   
}
