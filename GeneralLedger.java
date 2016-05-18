package erpMain;
import java.util.ArrayList;

import java.util.Date;

public class GeneralLedger extends ERP{

	private ArrayList<Double> debits = new ArrayList<Double>(10);
	private ArrayList<Double> credits = new ArrayList<Double>(10);
	private ArrayList<Integer> journalNumbers = new ArrayList<Integer>(10);
	private ArrayList<JDate> journalDates = new ArrayList<JDate>(10);
	private ArrayList<Date> entryDate = new ArrayList<Date>(10);
	private ArrayList<String> dclassification = new ArrayList<String>(10);
	private ArrayList<String> dsubClass = new ArrayList<String>(10);
	private ArrayList<String> ddescription = new ArrayList<String>(10);
	private ArrayList<String> cclassification = new ArrayList<String>(10);
	private ArrayList<String> csubClass = new ArrayList<String>(10);
	private ArrayList<String> cdescription = new ArrayList<String>(10);
	
	public void initArrays()
	{
		// This is a clunky bit of code to intialise array values to stop out of bounds exceptions. Might be a better fix.
		
	JDate e = new JDate(1,1,1900);
	Date d = new Date();
	
	debits.add(0.0);
	debits.add(0.0);
	credits.add(0.0);
	credits.add(0.0);
	dclassification.add("");
	dclassification.add("");
	dsubClass.add("");
	dsubClass.add("");
	ddescription.add("");
	ddescription.add("");
	cclassification.add("");
	cclassification.add("");
	csubClass.add("");
	csubClass.add("");
	cdescription.add("");
	cdescription.add("");
	entryDate.add(d);
	entryDate.add(d);
	journalDates.add(e);
	journalDates.add(e);
	}
	
	public void setDebit(Entry entry)
	{
		debits.add(entry.getJNumber(), entry.getDebit());
	}
	
	public void setCredit(Entry entry)
	{
		credits.add(entry.getJNumber(), entry.getCredit());
	}	
	
	public void setDate(Entry entry)
	{
		entryDate.add(entry.getJNumber(), entry.getEntDate());
	}
	
	public void setJDate(Entry entry)
	{
		journalDates.add(entry.getJNumber(), entry.getJDate());
	}
	
	public void setdClass(Entry entry)
	{
		dclassification.add(entry.getJNumber(), entry.gdClass());
	}
	
	public void setdSubClass(Entry entry)
	{
		dsubClass.add(entry.getJNumber(), entry.getdSubC());
	}
	
	public void setdDesc(Entry entry)
	{
		ddescription.add(entry.getJNumber(), entry.getdDesc());
	}
	
	public void setcClass(Entry entry)
	{
		cclassification.add(entry.getJNumber(), entry.gcClass());
	}
	
	public void setcSubClass(Entry entry)
	{
		csubClass.add(entry.getJNumber(), entry.getcSubC());
	}
	
	public void setcDesc(Entry entry)
	{
		cdescription.add(entry.getJNumber(), entry.getcDesc());
	}
	
	public double fsClassTotal(fsClass finSClass)
	{
		String sClass = finSClass.toString();
		double total=0;
		
		for(int i = 0; i< dclassification.size();i++)
		{
			if(sClass.equalsIgnoreCase(dclassification.get(i)))
				{
				total += debits.get(i);
				}
			
			if(sClass.equalsIgnoreCase(cclassification.get(i)))
				{
				total += credits.get(i);
				}
		}
		
		return total;
	}
	
	public void printDetail()
	{
		for(int i = 1; i<=ERP.getLastJN(); i++)
		{
			System.out.printf("%8d\t",i);
			System.out.print(journalDates.get(i)+"\t");
			System.out.print(debits.get(i)+"\t");
			System.out.print("\t");
			System.out.print(dclassification.get(i)+"\t");
			System.out.print(dsubClass.get(i)+"\t");
			System.out.print(ddescription.get(i)+"\t");
			System.out.print(entryDate.get(i)+"\t");
			System.out.println();
			System.out.printf("%8d\t",i);
			System.out.print(journalDates.get(i)+"\t");
			System.out.print("\t");
			System.out.print(credits.get(i)+"\t");
			System.out.print(cclassification.get(i)+"\t");
			System.out.print(csubClass.get(i)+"\t");
			System.out.print(cdescription.get(i)+"\t");
			System.out.print(entryDate.get(i)+"\t");
			System.out.println();
		
		}
	}
}
