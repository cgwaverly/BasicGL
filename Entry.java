package erpMain;
import java.util.Date;

public class Entry extends ERP {

	private double debit;
	private double credit;
	private int journalNumber;
	private JDate journalDate;
	private Date entryDate;
	private String dclassification;
	private String dsubClass;
	private String ddescription;
	private String cclassification;
	private String csubClass;
	private String cdescription;
	
	public Entry(double debit, double credit, fsClass dclassification, String dsubClass, String ddescription, fsClass cclassification, String csubClass, String cdescription, JDate journalDate)
	{
		if(debit>=0)
		this.debit = debit;
		else
			System.out.println("Debit must be positive.");
		
		if(credit<=0)
			this.credit = credit;
			else
				System.out.println("Credit must be negative.");
		
		if(debit + credit != 0)
		{
			System.out.println("Journal doesn't balance.");
			System.exit(1);
		}
		this.dclassification = dclassification.toString();
		this.dsubClass = dsubClass;
		this.ddescription = ddescription;
		this.cclassification = cclassification.toString();
		this.csubClass = csubClass;
		this.cdescription = cdescription;
		this.journalDate = new JDate(journalDate);
		journalNumber = getEntry();
		entryDate = new Date(); 
	
	
	
	}
	
	public Date getEntDate()
	{
		Date copy = new Date(entryDate.getTime());
		return copy;
	}
	
	public JDate getJDate()
	{
		JDate copy = new JDate(journalDate);
		return copy;
	}
	
	public double getDebit()
	{
		return debit;
	}
	
	public double getCredit()
	{
		return credit;
	}
	
	public int getJNumber()
	{
		return journalNumber;
	}
	
	public String gdClass()
	{
		return dclassification;
	}
	
	public String getdSubC()
	{
		return dsubClass;
	}
	
	public String getdDesc()
	{
		return ddescription;
	}

	public String gcClass()
	{
		return cclassification;
	}
	
	public String getcSubC()
	{
		return csubClass;
	}
	
	public String getcDesc()
	{
		return cdescription;
	}
}
