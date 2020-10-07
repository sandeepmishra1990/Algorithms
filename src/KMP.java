
public class KMP {

	public static void main(String[] args) {
		String txt="AABAAAABAB";
		String pat="ABAB";
		
		KMP kmp=new KMP();
		kmp.kmpSearch(txt, pat);

	}
	
	public void kmpSearch(String txt,String pat)
	{
		int LPS[]=new int[pat.length()];
		
		
		LPS=constructLPS(LPS,txt,pat);
		
		int patSize=pat.length();
		int txtSize=txt.length();
		int i=0;
		int j=0;
		while(i<txtSize)
		{
			if(pat.charAt(j)==txt.charAt(i))
			{
				i++;
				j++;
				if(patSize==j)
				{
					System.out.println("match found at index"+ (i-j));
					j=LPS[j-1];
				}
			}
			else if(pat.charAt(j)!=txt.charAt(i))
			{
				if(j!=0)
				{
					j=LPS[j-1];
				}
				else{
					i++;
					
				}
			}
		}
		
		
		
	}
	
	
	public int[] constructLPS(int[] LPS,String txt,String pat)
	{
		int i=1;
		int j=0;
		LPS[0]=0;
		
		while(i < LPS.length)
		{
			if(pat.charAt(i) == pat.charAt(j))
			{
				j++;
				LPS[i] = j;
				i++;
			}
			else{
				if(j != 0)
				{
					j = LPS[j-1];
				}
				else{
					
					LPS[i] = j;
					i++;
				}
			}
		}
		
		for(int y=0;y<LPS.length;y++)
		{
			System.out.print(LPS[y]);
		}
		return LPS;
	}

}
