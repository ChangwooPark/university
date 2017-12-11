using System;
using System.Collections.Generic;
using System.Text;
using System.Collections;
using System.IO;

namespace IISPLParserGenerator
{
   public class EKTranslatorScanner : IISPLParserGenerator.IISPLLexicalAnalyzer 
    {
       

  /* EKTransScanner.lex
      token : NOWN, VERB, ARTICLE, CR
  */

public void Test(String fn) {
  install(fn); string t;
  do {
    t = (string) lexan();
    Console.WriteLine("[" + t + "]" + lexbuf );
    } while(IsDone());
}
   protected override object Actions(int state)
   {
      switch (state)
       {
                  case 1:
                  case 2:{return "WS";}; break;
                  case 3:
                  case 15:
                  case 16:
                  case 19:{ yyoval=lexbuf; return "NOWN"; }; break;
                  case 14:
                  case 18:{yyoval=lexbuf; return "VERB"; }; break;
                  case 7:{return "ARTICLE"; }; break;
                  case 8:{return "CR"; }; break;
                  case 4:
                  case 5:
                  case 6:
                  case 9:{return "ANY"; }; break;
                  default : return null;
        }
   }
    protected override void Install()
    {
           trans=new int[,]{
             {0,1,'\t'},
             {0,8,'\n'},
             {0,2,'\r'},
             {0,1,' '},
             {0,9,'!'},
             {0,9,'"'},
             {0,9,'#'},
             {0,9,'$'},
             {0,9,'%'},
             {0,9,'&'},
             {0,9,'\''},
             {0,9,'('},
             {0,9,')'},
             {0,9,'*'},
             {0,9,'+'},
             {0,9,','},
             {0,9,'-'},
             {0,9,'.'},
             {0,9,'/'},
             {0,9,'0'},
             {0,9,'1'},
             {0,9,'2'},
             {0,9,'3'},
             {0,9,'4'},
             {0,9,'5'},
             {0,9,'6'},
             {0,9,'7'},
             {0,9,'8'},
             {0,9,'9'},
             {0,9,':'},
             {0,9,';'},
             {0,9,'<'},
             {0,9,'='},
             {0,9,'>'},
             {0,9,'?'},
             {0,9,'@'},
             {0,9,'A'},
             {0,9,'B'},
             {0,9,'C'},
             {0,9,'D'},
             {0,9,'E'},
             {0,9,'F'},
             {0,9,'G'},
             {0,9,'H'},
             {0,3,'I'},
             {0,9,'J'},
             {0,9,'K'},
             {0,9,'L'},
             {0,9,'M'},
             {0,9,'N'},
             {0,9,'O'},
             {0,9,'P'},
             {0,9,'Q'},
             {0,9,'R'},
             {0,9,'S'},
             {0,9,'T'},
             {0,9,'U'},
             {0,9,'V'},
             {0,9,'W'},
             {0,9,'X'},
             {0,4,'Y'},
             {0,9,'Z'},
             {0,9,'['},
             {0,9,'\\'},
             {0,9,']'},
             {0,9,'^'},
             {0,9,'_'},
             {0,9,'`'},
             {0,7,'a'},
             {0,5,'b'},
             {0,9,'c'},
             {0,9,'d'},
             {0,9,'e'},
             {0,9,'f'},
             {0,6,'g'},
             {0,9,'h'},
             {0,9,'i'},
             {0,9,'j'},
             {0,9,'k'},
             {0,9,'l'},
             {0,9,'m'},
             {0,9,'n'},
             {0,9,'o'},
             {0,9,'p'},
             {0,9,'q'},
             {0,9,'r'},
             {0,9,'s'},
             {0,9,'t'},
             {0,9,'u'},
             {0,9,'v'},
             {0,9,'w'},
             {0,9,'x'},
             {0,9,'y'},
             {0,9,'z'},
             {0,9,'{'},
             {0,9,'|'},
             {0,9,'}'},
             {0,9,'~'},
             {0,9,''},
             {1,2,'\t'},
             {1,2,'\r'},
             {1,2,' '},
             {2,2,'\t'},
             {2,2,'\r'},
             {2,2,' '},
             {4,10,'o'},
             {5,11,'o'},
             {6,12,'i'},
             {7,14,'m'},
             {7,13,'r'},
             {10,15,'u'},
             {11,16,'y'},
             {12,17,'r'},
             {13,18,'e'},
            {17,19,'l'}};
            FinalStates=new int[]{1,2,3,15,16,19,14,18,7,8,1,3,4,5,6,7,9};
            Lookaheads=new string[]{"1,2;;","3,15,16,19;;","14,18;;","7;;","8;;","1,3,4,5,6,7,9;;"};                
       }
    }
}