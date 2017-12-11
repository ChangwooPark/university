%{
  /* EKTransScanner.lex
      token : NOWN, VERB, ARTICLE, CR
  */
%}

delim [ \t\r]
WS {delim}+
Nown I|You|boy|girl
verb am|are
Article a
CR [\n]

%%

{WS} {return "WS";}
{Nown} { yyoval=lexbuf; return "NOWN"; }
{verb} {yyoval=lexbuf; return "VERB"; }
{Article} {return "ARTICLE"; }
{CR} {return "CR"; }
. {return "ANY"; }

%%

public void Test(String fn) {
  install(fn); string t;
  do {
    t = (string) lexan();
    Console.WriteLine("[" + t + "]" + lexbuf );
    } while(IsDone());
}