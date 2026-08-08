using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.Diagnostics.Eventing.Reader;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MiniLanguageCompiler
{
    internal class LexerErrorListener : IAntlrErrorListener<int>
    {
        public List<string> errors { get; } = new List<string>();
        public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            errors.Add($"Eroare lexicala la linia {line}: {msg}");
        }
       
    }
}
