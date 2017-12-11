using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace EKTranslator
{
    class EKDictionary
    {
        Dictionary<string, string> Dict = new Dictionary<string, string>();
        public EKDictionary()
        {
            Dict["I"] = "나";
            Dict["am"] = "입니다";
            Dict["a"] = "";
            Dict["boy"] = "소년";
            Dict["girl"] = "소녀";
            Dict["You"] = "너";
            Dict["are"] = "입니다";
        }
        public string this[string word]{
            get { return (Dict.ContainsKey(word) ? Dict[word] : "[" + word + "]"); }
            set {Dict[word] = value; }
        }
    }
}
