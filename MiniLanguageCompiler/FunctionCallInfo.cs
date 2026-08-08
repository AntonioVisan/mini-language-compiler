using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MiniLanguageCompiler
{
    internal class FunctionCallInfo
    {
        public string name { get; set; }
        public int line { get; set; }
        public List<string> arguments { get; set; } = new List<string>();
        public string callerFunction { get; set; }
    }
}
