using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using IISPLParserGenerator;

namespace EKTranslator
{
    class Program
    {
        static void Main(string[] args)
        {
            new EKTranslatorScanner().Test("../../EKTranslator.txt");
            new EKTranslatorParser().Test("../../EKTranslator.txt");
        }
    }
}
