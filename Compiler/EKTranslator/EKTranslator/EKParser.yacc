%{
  /* EKTransParser.yacc
      [Stacktype = string]
  */
  EKDictionary Dict = new EKDictionary();

%}
%token NOWN VERB ARTICLE CR 

%%

line : line sentence CR { Console.WriteLine($2); } | ;
sentence : subject verb complement { $$ = $1 + " " + $3 + $2; Console.WriteLine(  "sentence  :" + $1 + " " + $3 + $2);};
subject : ARTICLE NOWN { $$ = Dict[(string)$2]; Console.WriteLine(  "subject article nown:" +$2);} | NOWN { $$ = Dict[(string)$1]; Console.WriteLine(  "subject nown  :" +$2);};
verb : VERB { $$ = Dict[(string)$1]; Console.WriteLine(  "verb  :" + $1);};
complement : ARTICLE NOWN { $$ = Dict[(string)$2]; Console.WriteLine(  "complement article nown  :" + $2);} | NOWN { $$ = Dict[(string)$1]; };

%%

%{
public void Test(string fn)
{
    lexan.install(fn);
    Parse();
}
%}