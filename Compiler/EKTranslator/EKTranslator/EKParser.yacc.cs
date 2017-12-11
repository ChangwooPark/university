using System;
using System.Collections.Generic;
using System.Text;
using System.Collections;
using System.IO;
using EKTranslator;

namespace IISPLParserGenerator
{
   public  class EKTranslatorParser : IISPLParserGenerator.LRParser 
    {

  /* EKTransParser.yacc
      [Stacktype = string]
  */
  EKDictionary Dict = new EKDictionary();


public void Test(string fn)
{
    lexan.install(fn);
    Parse();
}

     
        protected override void Action(int pn)
        {
            switch(pn)
            {
                case 0 : ; break;
                case 1 : { Console.WriteLine(S[2]); }; break;
                case 2 : { S[0]=S[1]; }; break;
                case 3 : { S[0] = S[1] + " " + S[3] + S[2]; Console.WriteLine(  "sentence  :" + S[1] + " " + S[3] + S[2]);}; break;
                case 4 : { S[0] = Dict[(string)S[2]]; Console.WriteLine(  "subject article nown:" +S[2]);}; break;
                case 5 : { S[0] = Dict[(string)S[1]]; Console.WriteLine(  "subject nown  :" +S[2]);}; break;
                case 6 : { S[0] = Dict[(string)S[1]]; Console.WriteLine(  "verb  :" + S[1]);}; break;
                case 7 : { S[0] = Dict[(string)S[2]]; Console.WriteLine(  "complement article nown  :" + S[2]);}; break;
                case 8 : { S[0] = Dict[(string)S[1]]; }; break;
                default:
                     break;
            }
            


          }
        protected override void install()
        {
            lexan = new EKTranslatorScanner();

            A.Add(0,"", 'r' , 2);
            A.Add(0,"ARTICLE", 'r' , 2);
            A.Add(0,"NOWN", 'r' , 2);
            A.Add(1,"", 'a' , 0);
            A.Add(1,"ARTICLE", 's' , 4);
            A.Add(1,"NOWN", 's' , 5);
            A.Add(2,"CR", 's' , 6);
            A.Add(3,"VERB", 's' , 8);
            A.Add(4,"NOWN", 's' , 9);
            A.Add(5,"VERB", 'r' , 5);
            A.Add(6,"", 'r' , 1);
            A.Add(6,"ARTICLE", 'r' , 1);
            A.Add(6,"NOWN", 'r' , 1);
            A.Add(7,"ARTICLE", 's' , 11);
            A.Add(7,"NOWN", 's' , 12);
            A.Add(8,"ARTICLE", 'r' , 6);
            A.Add(8,"NOWN", 'r' , 6);
            A.Add(9,"VERB", 'r' , 4);
            A.Add(10,"CR", 'r' , 3);
            A.Add(11,"NOWN", 's' , 13);
            A.Add(12,"CR", 'r' , 8);
            A.Add(13,"CR", 'r' , 7);
          O.Add(0,"line",1);
          O.Add(1,"sentence",2);
          O.Add(1,"subject",3);
          O.Add(3,"verb",7);
          O.Add(7,"complement",10);      


           G.Add(G.N," line' complement line sentence subject verb"); 
           G.Add(G.T," ARTICLE CR NOWN VERB");
            P.Add("line -> line sentence CR");
            P.Add("line -> ");
            P.Add("sentence -> subject verb complement");
            P.Add("subject -> ARTICLE NOWN");
            P.Add("subject -> NOWN");
            P.Add("verb -> VERB");
            P.Add("complement -> ARTICLE NOWN");
            P.Add("complement -> NOWN");
       }
    }
}