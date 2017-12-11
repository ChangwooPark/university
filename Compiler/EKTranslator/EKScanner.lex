%{
  /* EKTransScanner.lex
      token : NOWN, VERB, ARTICLE, CR
  */
%}

delim [\t\r]
WS {delim}+
Nown I|You|boy|girl
verb am|are
Article a
cr [\n]

%%

{WS} {return "WS"}
{nown} { yyoval=lexbuf; return "NOWN"; }
{verb} {yyoval=lexbuf; return "VERB"; }
{article} {return "ARTICLE"; }
{CR} {return "CR"; }
. {return "ANY"; }

%%

public void Test(String fn) {
  install(fn); string t;
  do {
    t = (string) lexan();
    Console.WriteLine("[" + t + "]" + lexbuf );
    }
}