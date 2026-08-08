using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MiniLanguageCompiler
{
    internal class ParserErrorListener : IAntlrErrorListener<IToken>
    {
        public List<string> errors = new List<string>();

        public void SyntaxError(TextWriter writer, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            errors.Add($"Eroare sintactica la linia {line}: {msg}");
        }
    }
}
